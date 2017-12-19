package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentDetailInfoActivity extends AppCompatActivity {

    String PAYMENT_time; // 거래 시간
    String PAYMENT_method; // 거래 방식
    String PAYMENT_centext; // 거래 내용
    String PAYMENT_date; // 거래 날짜
    String PAYMENT_number; // 거래 일련번호
    String PAYMENT_total_price; // 거래 총액

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail_info);

        Intent intent = getIntent();

        PAYMENT_centext = intent.getExtras().getString("PAYMENT_centext");
        PAYMENT_time = intent.getExtras().getString("PAYMENT_time");
        PAYMENT_method = intent.getExtras().getString("PAYMENT_method");
        PAYMENT_total_price = intent.getExtras().getString("PAYMENT_total_price");
        PAYMENT_date = intent.getExtras().getString("PAYMENT_date");
        PAYMENT_number = intent.getExtras().getString("PAYMENT_number");

        TextView pdi_totalprice = (TextView)findViewById(R.id.pdi_totalprice);
        TextView pdi_method = (TextView)findViewById(R.id.pdi_method);
        TextView pdi_time = (TextView)findViewById(R.id.pdi_time);
        TextView pdi_date = (TextView)findViewById(R.id.pdi_date);

        pdi_totalprice.setText(PAYMENT_total_price);
        pdi_method.setText(PAYMENT_method);
        pdi_time.setText(PAYMENT_time);
        pdi_date.setText(PAYMENT_date);

    }
    public void pdiClick(View v){

        switch(v.getId()){

            case R.id.print_detail_list: // 영수증 출력
                Toast.makeText(PaymentDetailInfoActivity.this, "영수증이 출력되었습니다.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.payment_cancel: // 결제 취소
                // DB내용 지우기
                Toast.makeText(PaymentDetailInfoActivity.this, "결제가 취소 되었습니다. ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaymentDetailInfoActivity.this, MainActivity.class));
                finish();
                break;

            case R.id.move_main: // 결제 취소
                startActivity(new Intent(PaymentDetailInfoActivity.this, MainActivity.class));
                finish();
                break;

        }


    }
}
