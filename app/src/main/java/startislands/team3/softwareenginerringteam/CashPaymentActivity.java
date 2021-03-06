package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

public class CashPaymentActivity extends AppCompatActivity {

    int PAYMENT_receive_price=0; // 받은 금액
    String PAYMENT_total_price; // 주문 총액
    int exchange=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_payment);

        Intent intent = getIntent();
        PAYMENT_total_price = intent.getExtras().getString("PAYMENT_total_price"); // 주문 총액

        TextView TV_totalPrice = (TextView)findViewById(R.id.TV_totalPrice);
        TV_totalPrice.setText(PAYMENT_total_price);

        EditText ET_receivePrice = (EditText)findViewById(R.id.ET_receivePrice);

        ET_receivePrice.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                EditText ET_receivePrice = (EditText)findViewById(R.id.ET_receivePrice);

                if(ET_receivePrice.getText().toString().equals("")){
                    exchange = 0;
                }
                else{
                    PAYMENT_receive_price = Integer.parseInt(ET_receivePrice.getText().toString());

                    exchange = PAYMENT_receive_price - Integer.parseInt(PAYMENT_total_price);
                }

                TextView TV_exchagePrice = (TextView)findViewById(R.id.TV_exchagePrice);

                TV_exchagePrice.setText(exchange+"");
            }
        });
    }




    public void topButtonClick(View v) {
        switch (v.getId()) {
            case R.id.order_btn: // 주문 창
                startActivity(new Intent(CashPaymentActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.list_btn: // 거래내역 창
                startActivity(new Intent(CashPaymentActivity.this, PaymentListInfoActivity.class));
                finish();
                break;
            case R.id.adjust_btn: // 상품관리 창
                startActivity(new Intent(CashPaymentActivity.this, productAdjustActivity.class));
                finish();
                break;
        }
    }



    public void paymentSubmitClick(View v) { // 현금 결제
        paymentCash(v);
    }

    public void paymentCash(View v){ // 현금 결제
        switch (v.getId()) {
            case R.id.payment_cash_btn:
                if(Integer.parseInt(PAYMENT_total_price)<=PAYMENT_receive_price){
                    Intent intent = new Intent();
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Toast.makeText(this, "받은 금액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
        }
    }

    public void paymentCashCancel(){ // 현금 결제 취소
        startActivity(new Intent(CashPaymentActivity.this, MainActivity.class));
        finish();
    }
}
