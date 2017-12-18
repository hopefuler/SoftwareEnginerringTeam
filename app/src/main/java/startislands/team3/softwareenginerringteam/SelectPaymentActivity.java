package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SelectPaymentActivity extends AppCompatActivity {

    String PAYMENT_centext; // 주문 내용
    String PAYMENT_number; // 주문 번호 -> db에서 유동적으로 변화시키기
    String PAYMENT_date; // 주문 일자
    String PAYMENT_total_price; // 주문 총액
    String PAYMENT_time; // 주문 시간

    String PAYMENT_method; // 결제 방식
    // 결제 상태

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_payment);

        Intent intent = getIntent();
        PAYMENT_centext = intent.getExtras().getString("PAYMENT_centext"); // 주문 내용
        PAYMENT_number = intent.getExtras().getString("PAYMENT_number"); // 주문 번호 -> db에서 유동적으로 변화시키기
        PAYMENT_date = intent.getExtras().getString("PAYMENT_date"); // 주문 일자
        PAYMENT_total_price = intent.getExtras().getString("PAYMENT_total_price"); // 주문 총액
        PAYMENT_time = intent.getExtras().getString("PAYMENT_time"); // 주문 시간

        TextView TV_totalPrice = (TextView)findViewById(R.id.TV_totalPrice);
        TV_totalPrice.setText(PAYMENT_total_price+"");
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
            case R.id.payment_cash_btn: // 현금
                PAYMENT_method="현금";

                intent = new Intent(SelectPaymentActivity.this, CashPaymentActivity.class);
                intent.putExtra("PAYMENT_total_price",PAYMENT_total_price); // 주문 내용



                break;
            case R.id.payment_card_btn: // 카드
                PAYMENT_method="카드";
                intent = new Intent(SelectPaymentActivity.this, CardPaymentActivity.class);
                intent.putExtra("PAYMENT_total_price",PAYMENT_total_price); // 주문 내용

                break;
            case R.id.payment_cheque_btn: // 수표


                break;
        }

        startActivity(intent);
        finish();
    }

    public void paymentCancel(){ // 결제 취소
        startActivity(new Intent(SelectPaymentActivity.this, MainActivity.class));
        finish();
    }
}
