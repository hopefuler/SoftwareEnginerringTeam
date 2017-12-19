package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class PaymentListInfoActivity extends AppCompatActivity {

    String PAYMENT_time = "20:28:59"; // 거래 시간
    String PAYMENT_method = "현금 결제"; // 거래 방식
    String PAYMENT_total_price = "2000"; // 거래 내용
    String PAYMENT_date = "2017/12/12"; // 거래 날짜
    String PAYMENT_number = "20171212001"; // 거래 일련번호

    MyAdapter MyAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_list_info);

        MyAdapter = new MyAdapter();
        mListView = (ListView)findViewById(R.id.stu_listView);

        setListView(); // 거래내역 상세조회

        /*리스트뷰 버튼을 눌럿을때의 이벤트리스너 설정*/
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent1, View view, int position, long id) {
                Toast.makeText(PaymentListInfoActivity.this, position+"번 리스트 뷰", Toast.LENGTH_SHORT).show();

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


                break;
        }
    }

    public void setListView(){ // 거래내역 상세조회

        PAYMENT_time = "20:28:59";
        PAYMENT_method = "현금 결제";
        PAYMENT_total_price = "2000";
        PAYMENT_date = "2017/12/12";
        PAYMENT_number = "20171212001";
        MyAdapter.addItem(PAYMENT_number, PAYMENT_date, PAYMENT_time, PAYMENT_method, PAYMENT_total_price);

        PAYMENT_time = "22:42:01";
        PAYMENT_method = "카드 결제";
        PAYMENT_total_price = "7500";
        PAYMENT_date = "2017/12/12";
        PAYMENT_number = "20171212002";
        MyAdapter.addItem(PAYMENT_number, PAYMENT_date, PAYMENT_time, PAYMENT_method, PAYMENT_total_price);

        mListView.setAdapter(MyAdapter);

    }
}
