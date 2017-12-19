package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class productAdjustActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_adjust);

        initList();
    }


    public void topButtonClick(View v) {
        switch (v.getId()) {
            case R.id.order_btn: // 주문 창
                startActivity(new Intent(productAdjustActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.list_btn: // 거래내역 창
                startActivity(new Intent(productAdjustActivity.this, PaymentListInfoActivity.class));
                finish();
                break;
            case R.id.adjust_btn: // 상품관리 창
                startActivity(new Intent(productAdjustActivity.this, productAdjustActivity.class));
                finish();
                break;
        }
    }

    public void initList(){
        /*
        Button menu_count_01 = (Button)findViewById(R.id.menu_count_01);
        Button menu_count_02 = (Button)findViewById(R.id.menu_count_02);
        Button menu_count_03 = (Button)findViewById(R.id.menu_count_03);
        Button menu_count_04 = (Button)findViewById(R.id.menu_count_04);
        Button menu_count_05 = (Button)findViewById(R.id.menu_count_05);
        Button menu_count_06 = (Button)findViewById(R.id.menu_count_06);
        Button menu_count_07 = (Button)findViewById(R.id.menu_count_07);
        Button menu_count_08 = (Button)findViewById(R.id.menu_count_08);
        Button menu_count_09 = (Button)findViewById(R.id.menu_count_09);
        Button menu_count_10 = (Button)findViewById(R.id.menu_count_10);

        Button menu_inDate_01 = (Button)findViewById(R.id.menu_inDate_01);
        Button menu_inDate_02 = (Button)findViewById(R.id.menu_inDate_02);
        Button menu_inDate_03 = (Button)findViewById(R.id.menu_inDate_03);
        Button menu_inDate_04 = (Button)findViewById(R.id.menu_inDate_04);
        Button menu_inDate_05 = (Button)findViewById(R.id.menu_inDate_05);
        Button menu_inDate_06 = (Button)findViewById(R.id.menu_inDate_06);
        Button menu_inDate_07 = (Button)findViewById(R.id.menu_inDate_07);
        Button menu_inDate_08 = (Button)findViewById(R.id.menu_inDate_08);
        Button menu_inDate_09 = (Button)findViewById(R.id.menu_inDate_09);
        Button menu_inDate_10 = (Button)findViewById(R.id.menu_inDate_10);

        Button menu_outDate_01 = (Button)findViewById(R.id.menu_outDate_01);
        Button menu_outDate_02 = (Button)findViewById(R.id.menu_outDate_02);
        Button menu_outDate_03 = (Button)findViewById(R.id.menu_outDate_03);
        Button menu_outDate_04 = (Button)findViewById(R.id.menu_outDate_04);
        Button menu_outDate_05 = (Button)findViewById(R.id.menu_outDate_05);
        Button menu_outDate_06 = (Button)findViewById(R.id.menu_outDate_06);
        Button menu_outDate_07 = (Button)findViewById(R.id.menu_outDate_07);
        Button menu_outDate_08 = (Button)findViewById(R.id.menu_outDate_08);
        Button menu_outDate_09 = (Button)findViewById(R.id.menu_outDate_09);
        Button menu_outDate_10 = (Button)findViewById(R.id.menu_outDate_10);

        Button menu_kind_01 = (Button)findViewById(R.id.menu_kind_01);
        Button menu_kind_02 = (Button)findViewById(R.id.menu_kind_02);
        Button menu_kind_03 = (Button)findViewById(R.id.menu_kind_03);
        Button menu_kind_04 = (Button)findViewById(R.id.menu_kind_04);
        Button menu_kind_05 = (Button)findViewById(R.id.menu_kind_05);
        Button menu_kind_06 = (Button)findViewById(R.id.menu_kind_06);
        Button menu_kind_07 = (Button)findViewById(R.id.menu_kind_07);
        Button menu_kind_08 = (Button)findViewById(R.id.menu_kind_08);
        Button menu_kind_09 = (Button)findViewById(R.id.menu_kind_09);
        Button menu_kind_10 = (Button)findViewById(R.id.menu_kind_10);
        */


        for(int i=0 ; i<10 ; i++){
            Button tmp = (Button)findViewById(R.id.menu_count_01+i);
            tmp.setText(i+"");
        }

        for(int i=0 ; i<10 ; i++){
            Button tmp = (Button)findViewById(R.id.menu_inDate_01+i);
            tmp.setText("2017/12/1"+i);
        }

        for(int i=0 ; i<10 ; i++){
            Button tmp = (Button)findViewById(R.id.menu_outDate_01+i);
            tmp.setText("2018/06/2"+i);
        }

        //for(int i=0 ; i<10 ; i++){
        //    Button tmp = (Button)findViewById(R.id.menu_kind_01+i);
        //    tmp.setText("커피");
        //}


    }

}
