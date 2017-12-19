package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SelectPaymentActivity extends AppCompatActivity {

    final int CASH_PAYMENT =100;
    final int CARD_PAYMENT =101;

    int[] PAYMENT_centext; // 주문 내용  -- 추후에 이 객체를 가져오면될듯
    String PAYMENT_number; // 주문 번호 -> db에서 유동적으로 변화시키기
    String PAYMENT_date; // 주문 일자
    String PAYMENT_total_price; // 주문 총액
    String PAYMENT_time; // 주문 시간
    String PAYMENT_sale_price="0";

    String PAYMENT_method; // 결제 방식
    // 결제 상태
    TextView TV_order_count_01;
    TextView TV_order_count_02;
    TextView TV_order_count_03;
    TextView TV_order_count_04;
    TextView TV_order_count_05;
    TextView TV_order_count_06;
    TextView TV_order_count_07;
    TextView TV_order_count_08;
    TextView TV_order_count_09;
    TextView TV_order_count_10;

    TextView TV_order_price_01;
    TextView TV_order_price_02;
    TextView TV_order_price_03;
    TextView TV_order_price_04;
    TextView TV_order_price_05;
    TextView TV_order_price_06;
    TextView TV_order_price_07;
    TextView TV_order_price_08;
    TextView TV_order_price_09;
    TextView TV_order_price_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_payment);

        Intent intent = getIntent();
        PAYMENT_centext = intent.getExtras().getIntArray("PAYMENT_centext"); // 주문 내용
        PAYMENT_number = intent.getExtras().getString("PAYMENT_number"); // 주문 번호 -> db에서 유동적으로 변화시키기
        PAYMENT_date = intent.getExtras().getString("PAYMENT_date"); // 주문 일자
        PAYMENT_total_price = intent.getExtras().getString("PAYMENT_total_price"); // 주문 총액
        PAYMENT_time = intent.getExtras().getString("PAYMENT_time"); // 주문 시간


        //값
        TextView TV_totalPrice = (TextView)findViewById(R.id.TV_totalPrice);
        TV_totalPrice.setText(PAYMENT_total_price+"");

        TV_order_count_01 = (TextView)findViewById(R.id.TV_order_count_01);
        TV_order_count_02 = (TextView)findViewById(R.id.TV_order_count_02);
        TV_order_count_03 = (TextView)findViewById(R.id.TV_order_count_03);
        TV_order_count_04 = (TextView)findViewById(R.id.TV_order_count_04);
        TV_order_count_05 = (TextView)findViewById(R.id.TV_order_count_05);
        TV_order_count_06 = (TextView)findViewById(R.id.TV_order_count_06);
        TV_order_count_07 = (TextView)findViewById(R.id.TV_order_count_07);
        TV_order_count_08 = (TextView)findViewById(R.id.TV_order_count_08);
        TV_order_count_09 = (TextView)findViewById(R.id.TV_order_count_09);
        TV_order_count_10 = (TextView)findViewById(R.id.TV_order_count_10);
        //158000
        TV_order_price_01 = (TextView)findViewById(R.id.TV_order_price_01);
        TV_order_price_02 = (TextView)findViewById(R.id.TV_order_price_02);
        TV_order_price_03 = (TextView)findViewById(R.id.TV_order_price_03);
        TV_order_price_04 = (TextView)findViewById(R.id.TV_order_price_04);
        TV_order_price_05 = (TextView)findViewById(R.id.TV_order_price_05);
        TV_order_price_06 = (TextView)findViewById(R.id.TV_order_price_06);
        TV_order_price_07 = (TextView)findViewById(R.id.TV_order_price_07);
        TV_order_price_08 = (TextView)findViewById(R.id.TV_order_price_08);
        TV_order_price_09 = (TextView)findViewById(R.id.TV_order_price_09);
        TV_order_price_10 = (TextView)findViewById(R.id.TV_order_price_10);

        TV_order_count_01.setText(String.valueOf(PAYMENT_centext[0]));
        TV_order_count_02.setText(String.valueOf(PAYMENT_centext[1]));
        TV_order_count_03.setText(String.valueOf(PAYMENT_centext[2]));
        TV_order_count_04.setText(String.valueOf(PAYMENT_centext[3]));
        TV_order_count_05.setText(String.valueOf(PAYMENT_centext[4]));
        TV_order_count_06.setText(String.valueOf(PAYMENT_centext[5]));
        TV_order_count_07.setText(String.valueOf(PAYMENT_centext[6]));
        TV_order_count_08.setText(String.valueOf(PAYMENT_centext[7]));
        TV_order_count_09.setText(String.valueOf(PAYMENT_centext[8]));
        TV_order_count_10.setText(String.valueOf(PAYMENT_centext[9]));

        TV_order_price_01.setText(String.valueOf(PAYMENT_centext[0]*2000));
        TV_order_price_02.setText(String.valueOf(PAYMENT_centext[1]*2800));
        TV_order_price_03.setText(String.valueOf(PAYMENT_centext[2]*2300));
        TV_order_price_04.setText(String.valueOf(PAYMENT_centext[3]*2500));
        TV_order_price_05.setText(String.valueOf(PAYMENT_centext[4]*2500));
        TV_order_price_06.setText(String.valueOf(PAYMENT_centext[5]*3500));
        TV_order_price_07.setText(String.valueOf(PAYMENT_centext[6]*3500));
        TV_order_price_08.setText(String.valueOf(PAYMENT_centext[7]*3800));
        TV_order_price_09.setText(String.valueOf(PAYMENT_centext[8]*500));
        TV_order_price_10.setText(String.valueOf(PAYMENT_centext[9]*500));
    }

    public void topButtonClick(View v) {
        switch (v.getId()) {
            case R.id.order_btn: // 주문 창
                paymentCancel(); // 결제 취소
                break;
            case R.id.list_btn: // 거래내역 창


                break;
            case R.id.adjust_btn: // 상품관리 창


                break;
        }
    }




    public void paymentSubmitClick(View v) {
        payment(v); // 결제
    }

    public void payment(View v){ // 결제
        Intent intent = new Intent(SelectPaymentActivity.this, SelectPaymentActivity.class);
        switch (v.getId()) {
            case R.id.payment_sale_btn:

                break;
            case R.id.payment_cash_btn: // 현금
                PAYMENT_method="현금";

                intent = new Intent(SelectPaymentActivity.this, CashPaymentActivity.class);
                intent.putExtra("PAYMENT_total_price",PAYMENT_total_price); // 주문 내용
                startActivityForResult(intent,CASH_PAYMENT);

                break;
            case R.id.payment_card_btn: // 카드
                PAYMENT_method="카드";
                intent = new Intent(SelectPaymentActivity.this, CardPaymentActivity.class);
                intent.putExtra("PAYMENT_total_price",PAYMENT_total_price); // 주문 내용
                startActivity(intent);

                break;
            case R.id.payment_cheque_btn: // 수표
                intent = new Intent(SelectPaymentActivity.this, CheckCheck.class);
                startActivity(intent);
                break;
        }

    }

    public void paymentCancel(){ // 결제 취소
        startActivity(new Intent(SelectPaymentActivity.this, MainActivity.class));
        finish();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode==RESULT_OK){
            if(requestCode==CASH_PAYMENT){
                if(data!=null){

                    SharedPreferences pref = getSharedPreferences("transactionList", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    int transactionCount=Integer.parseInt(pref.getString("transactionCount", "0"));
                    PAYMENT_number=transactionCount+"";

                    JSONObject transaction = new JSONObject();
                    try {
                        transaction.put("TV_order_count_01",TV_order_count_01.getText().toString());
                        transaction.put("TV_order_count_02",TV_order_count_02.getText().toString());
                        transaction.put("TV_order_count_03",TV_order_count_03.getText().toString());
                        transaction.put("TV_order_count_04",TV_order_count_04.getText().toString());
                        transaction.put("TV_order_count_05",TV_order_count_05.getText().toString());
                        transaction.put("TV_order_count_06",TV_order_count_06.getText().toString());
                        transaction.put("TV_order_count_07",TV_order_count_07.getText().toString());
                        transaction.put("TV_order_count_08",TV_order_count_08.getText().toString());
                        transaction.put("TV_order_count_09",TV_order_count_09.getText().toString());
                        transaction.put("TV_order_count_10",TV_order_count_10.getText().toString());
                        transaction.put("PAYMENT_total_price",PAYMENT_total_price);
                        transaction.put("PAYMENT_date",PAYMENT_date);
                        transaction.put("PAYMENT_time",PAYMENT_time);
                        transaction.put("PAYMENT_sale_price",PAYMENT_sale_price);
                        transaction.put("PAYMENT_number",PAYMENT_number);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    transactionCount++;

                    editor.putString("count", PAYMENT_number);
                    editor.putString(PAYMENT_number, transaction.toString());
                    editor.commit();


                }
            }
        }
    }

}
