package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_payment);
    }

    public void topButtonClick(View v) {
        switch (v.getId()) {
            case R.id.order_btn: // 주문 창
                startActivity(new Intent(SelectPaymentActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.list_btn: // 거래내역 창


                break;
            case R.id.adjust_btn: // 상품관리 창


                break;
        }
    }

    public void paymentSubmitClick(View v) {
        switch (v.getId()) {
            case R.id.payment_cash_btn: // 현금


                break;
            case R.id.payment_card_btn: // 카드


                break;
            case R.id.payment_cheque_btn: // 수표


                break;
        }
    }
}
