package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PaymentListInfoActivity extends AppCompatActivity {

    String PAYMENT_time; // 거래 시간
    String PAYMENT_method; // 거래 방식
    JSONObject PAYMENT_centext;// 거래 내용
    String PAYMENT_date; // 거래 날짜
    String PAYMENT_number; // 거래 일련번호
    String PAYMENT_total_price; // 거래 총액
    String PAYMENT_sale_price;

    MyAdapter MyAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_list_info);

        MyAdapter = new MyAdapter();
        mListView = (ListView)findViewById(R.id.stu_listView);

        setListView(); // 거래내역 조회

        // 거래내역 수정 ?? -> 뺄 것 상세보기에서 할 일임.

        // 영수증 출력 ?? -> 뺄 것 상세보기에서 할 일임.

        // 결제 취소 ?? -> 뺄 것 상세보기에서 할 일임.


        /*리스트뷰 버튼을 눌럿을때의 이벤트리스너 설정*/
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent1, View view, int position, long id) {

                detailListView(position); // 거래내역 조회 ; 이 함수를 호출 할 것. - 클래스 다이어그램



            }
        });

    }


    public void topButtonClick(View v) {
        switch (v.getId()) {
            case R.id.order_btn: // 주문 창
                startActivity(new Intent(PaymentListInfoActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.list_btn: // 거래내역 창
                startActivity(new Intent(PaymentListInfoActivity.this, PaymentListInfoActivity.class));
                finish();
                break;
            case R.id.adjust_btn: // 상품관리 창
                startActivity(new Intent(PaymentListInfoActivity.this, productAdjustActivity.class));
                finish();
                break;
        }
    }

    public void setListView(){ // 거래내역 상세조회

        SharedPreferences pref = getSharedPreferences("transactionList", MODE_PRIVATE);
        int transactionListCount = Integer.parseInt(pref.getString("count","0"));


        for(int i=0;i<transactionListCount;i++){
            String JSONString = pref.getString(String.valueOf(i),"");

            try {
                PAYMENT_centext = new JSONObject(JSONString);
                PAYMENT_time = PAYMENT_centext.getString("PAYMENT_time");
                PAYMENT_method = PAYMENT_centext.getString("PAYMENT_method");
                PAYMENT_total_price = PAYMENT_centext.getString("PAYMENT_total_price");
                PAYMENT_date = PAYMENT_centext.getString("PAYMENT_date");
                PAYMENT_number =PAYMENT_centext.getString("PAYMENT_number");
                PAYMENT_sale_price =PAYMENT_centext.getString("PAYMENT_sale_price");

            } catch (JSONException e) {
                e.printStackTrace();
            }

            MyAdapter.addItem(PAYMENT_number, PAYMENT_date, PAYMENT_time, PAYMENT_method, Integer.parseInt(PAYMENT_total_price)-Integer.parseInt(PAYMENT_sale_price)+"");
        }
        mListView.setAdapter(MyAdapter);
    }

    public void detailListView(int PAYMENT_number){ // 거래내역 상세조회
        Intent intent = new Intent(PaymentListInfoActivity.this, PaymentDetailInfoActivity.class);

        intent.putExtra("PAYMENT_number",PAYMENT_number+"");
        startActivity(intent);
        finish();
    }
}
