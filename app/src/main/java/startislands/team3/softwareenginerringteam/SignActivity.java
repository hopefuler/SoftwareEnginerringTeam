package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignActivity extends AppCompatActivity {
    Button signAdmit;
    Button signCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        signAdmit=(Button)findViewById(R.id.signAdmit);
        signCancel =(Button)findViewById(R.id.signCancel);

        signAdmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signAdmit();
            }
        });

        signCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void signAdmit(){
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();

    }


    public void topButtonClick(View v) {
        switch (v.getId()) {
            case R.id.order_btn: // 주문 창
                startActivity(new Intent(SignActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.list_btn: // 거래내역 창
                startActivity(new Intent(SignActivity.this, PaymentListInfoActivity.class));
                finish();
                break;
            case R.id.adjust_btn: // 상품관리 창
                startActivity(new Intent(SignActivity.this, productAdjustActivity.class));
                finish();
                break;
        }
    }
}
