package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SaleActivity extends AppCompatActivity {

    EditText salePhoneEdit,saleCuponEdit;
    Button salePhoneBtn,saleCuponBtn,saleAdmitbtn,saleBackbtn;
    TextView saleAfter,saleBefore;

    String SALE_COUPON_NUMBER="";
    String SALE_PHONE_NUMBER="";

    String PAYMENT_total_price="";
    int PAYMENT_sale_price=0;

    boolean PHONE_SALE_PLAG=false;
    boolean CUPON_SALE_PLAG=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);

        salePhoneEdit = (EditText)findViewById(R.id.salePhoneEdit);
        saleCuponEdit = (EditText)findViewById(R.id.saleCuponEdit);

        salePhoneBtn =(Button)findViewById(R.id.salePhoneBtn);
        saleCuponBtn =(Button)findViewById(R.id.saleCuponBtn);
        saleAdmitbtn =(Button)findViewById(R.id.saleAdmitbtn);
        saleBackbtn =(Button)findViewById(R.id.saleBackbtn);
        saleAfter = (TextView)findViewById(R.id.saleAfter);
        saleBefore = (TextView)findViewById(R.id.saleBefore);

        Intent intent = getIntent();
        PAYMENT_total_price=intent.getExtras().getString("PAYMENT_total_price");
        saleBefore.setText(PAYMENT_total_price+"원");


        salePhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SALE_PHONE_NUMBER = salePhoneEdit.getText().toString();
                if(SALE_PHONE_NUMBER.length()>=10&&PHONE_SALE_PLAG==false){
                    PAYMENT_sale_price=PAYMENT_sale_price+(Integer.parseInt(PAYMENT_total_price)/10);
                    saleAfter.setText(Integer.parseInt(PAYMENT_total_price)-PAYMENT_sale_price+"원");
                    PHONE_SALE_PLAG=true;
                }else if(PHONE_SALE_PLAG){
                    Toast.makeText(SaleActivity.this, "이미 통신사 할인이 적용되었습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SaleActivity.this, "정확한 전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        saleCuponBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SALE_COUPON_NUMBER = saleCuponEdit.getText().toString();
                if(SALE_COUPON_NUMBER.length()==10&&CUPON_SALE_PLAG==false){
                    PAYMENT_sale_price=PAYMENT_sale_price+(Integer.parseInt(PAYMENT_total_price)/10);
                    saleAfter.setText(Integer.parseInt(PAYMENT_total_price)-PAYMENT_sale_price+"원");
                    CUPON_SALE_PLAG=true;
                }else if(CUPON_SALE_PLAG){
                    Toast.makeText(SaleActivity.this, "이미 쿠폰할인이 적용되었습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SaleActivity.this, "정확한 쿠폰를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        saleAdmitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saleAdmit();
            }
        });
    }

    public void saleAdmit(){
        Intent intent = new Intent();
        intent.putExtra("PAYMENT_sale_price",String.valueOf(PAYMENT_sale_price));
        setResult(RESULT_OK,intent);
        finish();
    }


}
