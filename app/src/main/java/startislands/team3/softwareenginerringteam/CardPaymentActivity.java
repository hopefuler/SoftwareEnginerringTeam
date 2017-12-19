package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CardPaymentActivity extends AppCompatActivity {

    int cardCompany; // 신용카드사
    int cardNumber; // 신용카드번호
    int checkNumber; // 승인번호
    int checktDate; // 승인일자

    final int CARD_SIGN = 100;

    String PAYMENT_total_price; // 주문 총액
    TextView TV_totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_payment);

        Intent intent = getIntent();
        PAYMENT_total_price = intent.getExtras().getString("PAYMENT_total_price"); // 주문 총액
        TV_totalPrice = (TextView) findViewById(R.id.TV_totalPrice);
        TV_totalPrice.setText(PAYMENT_total_price);

    }


    public void topButtonClick(View v) {
        switch (v.getId()) {
            case R.id.order_btn: // 주문 창
                startActivity(new Intent(CardPaymentActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.list_btn: // 거래내역 창
                startActivity(new Intent(CardPaymentActivity.this, PaymentListInfoActivity.class));
                finish();
                break;
            case R.id.adjust_btn: // 상품관리 창
                startActivity(new Intent(CardPaymentActivity.this, productAdjustActivity.class));
                finish();
                break;
        }
    }


    public void cashPaymentSubmitClick(View v) {
        switch (v.getId()) {
            case R.id.cash_payment_yes_btn:

                startActivityForResult(new Intent(CardPaymentActivity.this, SignActivity.class),CARD_SIGN);
                break;

            case R.id.cash_payment_no_btn:
                finish();

                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == CARD_SIGN) {
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        }
    }
}
