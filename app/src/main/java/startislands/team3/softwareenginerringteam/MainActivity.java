package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int menu_count_01= 0;
    int menu_count_02= 0;
    int menu_count_03= 0;
    int menu_count_04= 0;
    int menu_count_05= 0;
    int menu_count_06= 0;
    int menu_count_07= 0;
    int menu_count_08= 0;
    int menu_count_09= 0;
    int menu_count_10= 0;

    int menu_price_01= 0;
    int menu_price_02= 0;
    int menu_price_03= 0;
    int menu_price_04= 0;
    int menu_price_05= 0;
    int menu_price_06= 0;
    int menu_price_07= 0;
    int menu_price_08= 0;
    int menu_price_09= 0;
    int menu_price_10= 0;

    int menu_total_price=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void topButtonClick(View v) {
        switch (v.getId()) {
            case R.id.order_btn: // 주문 창
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.list_btn: // 거래내역 창


                break;
            case R.id.adjust_btn: // 상품관리 창


                break;
        }
    }

    public void orderSubmitClick(View v) {
        switch (v.getId()) {
            case R.id.order_submit_btn: // 결제창으로 이동
                startActivity(new Intent(MainActivity.this, SelectPaymentActivity.class));
                finish();
                break;
        }
    }

    public void countAdjustClick(View v) {

        TextView TV_order_count_01 = (TextView)findViewById(R.id.TV_order_count_01);
        TextView TV_order_count_02 = (TextView)findViewById(R.id.TV_order_count_02);
        TextView TV_order_count_03 = (TextView)findViewById(R.id.TV_order_count_03);
        TextView TV_order_count_04 = (TextView)findViewById(R.id.TV_order_count_04);
        TextView TV_order_count_05 = (TextView)findViewById(R.id.TV_order_count_05);
        TextView TV_order_count_06 = (TextView)findViewById(R.id.TV_order_count_06);
        TextView TV_order_count_07 = (TextView)findViewById(R.id.TV_order_count_07);
        TextView TV_order_count_08 = (TextView)findViewById(R.id.TV_order_count_08);
        TextView TV_order_count_09 = (TextView)findViewById(R.id.TV_order_count_09);
        TextView TV_order_count_10 = (TextView)findViewById(R.id.TV_order_count_10);

        TextView TV_order_price_01 = (TextView)findViewById(R.id.TV_order_price_01);
        TextView TV_order_price_02 = (TextView)findViewById(R.id.TV_order_price_02);
        TextView TV_order_price_03 = (TextView)findViewById(R.id.TV_order_price_03);
        TextView TV_order_price_04 = (TextView)findViewById(R.id.TV_order_price_04);
        TextView TV_order_price_05 = (TextView)findViewById(R.id.TV_order_price_05);
        TextView TV_order_price_06 = (TextView)findViewById(R.id.TV_order_price_06);
        TextView TV_order_price_07 = (TextView)findViewById(R.id.TV_order_price_07);
        TextView TV_order_price_08 = (TextView)findViewById(R.id.TV_order_price_08);
        TextView TV_order_price_09 = (TextView)findViewById(R.id.TV_order_price_09);
        TextView TV_order_price_10 = (TextView)findViewById(R.id.TV_order_price_10);

        TextView TV_totalPrice = (TextView)findViewById(R.id.TV_totalPrice);

        switch (v.getId()) {
            case R.id.BT_plus_01:
                menu_count_01 += 1;
                TV_order_count_01.setText(menu_count_01+"");
                menu_price_01 += 2000;
                TV_order_price_01.setText(menu_price_01+"");
                break;
            case R.id.BT_minus_01:
                if(menu_count_01<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_01 -= 1;
                    TV_order_count_01.setText(menu_count_01+"");
                    menu_price_01 -= 2000;
                    TV_order_price_01.setText(menu_price_01+"");
                }
                break;

            case R.id.BT_plus_02:
                menu_count_02 += 1;
                TV_order_count_02.setText(menu_count_02+"");
                menu_price_02 += 2000;
                TV_order_price_02.setText(menu_price_02+"");
                break;
            case R.id.BT_minus_02:
                if(menu_count_02<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_02 -= 1;
                    TV_order_count_02.setText(menu_count_02+"");
                    menu_price_02 -= 2000;
                    TV_order_price_02.setText(menu_price_02+"");
                }
                break;

            case R.id.BT_plus_03:
                menu_count_03 += 1;
                TV_order_count_03.setText(menu_count_03+"");
                menu_price_03 += 2000;
                TV_order_price_03.setText(menu_price_03+"");
                break;
            case R.id.BT_minus_03:
                if(menu_count_03<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_03 -= 1;
                    TV_order_count_03.setText(menu_count_03+"");
                    menu_price_03 -= 2000;
                    TV_order_price_03.setText(menu_price_03+"");
                }
                break;

            case R.id.BT_plus_04:
                menu_count_04 += 1;
                TV_order_count_04.setText(menu_count_04+"");
                menu_price_04 += 2000;
                TV_order_price_04.setText(menu_price_04+"");
                break;
            case R.id.BT_minus_04:
                if(menu_count_04<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_04 -= 1;
                    TV_order_count_04.setText(menu_count_04+"");
                    menu_price_04 -= 2000;
                    TV_order_price_04.setText(menu_price_04+"");
                }
                break;

            case R.id.BT_plus_05:
                menu_count_05 += 1;
                TV_order_count_05.setText(menu_count_05+"");
                menu_price_05 += 2000;
                TV_order_price_05.setText(menu_price_05+"");
                break;
            case R.id.BT_minus_05:
                if(menu_count_05<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_05 -= 1;
                    TV_order_count_05.setText(menu_count_05+"");
                    menu_price_05 -= 2000;
                    TV_order_price_05.setText(menu_price_05+"");
                }
                break;

            case R.id.BT_plus_06:
                menu_count_06 += 1;
                TV_order_count_06.setText(menu_count_06+"");
                menu_price_06 += 2000;
                TV_order_price_06.setText(menu_price_06+"");
                break;
            case R.id.BT_minus_06:
                if(menu_count_06<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_06 -= 1;
                    TV_order_count_06.setText(menu_count_06+"");
                    menu_price_06 -= 2000;
                    TV_order_price_06.setText(menu_price_06+"");
                }
                break;

            case R.id.BT_plus_07:
                menu_count_07 += 1;
                TV_order_count_07.setText(menu_count_07+"");
                menu_price_07 += 2000;
                TV_order_price_07.setText(menu_price_07+"");
                break;
            case R.id.BT_minus_07:
                if(menu_count_07<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_07 -= 1;
                    TV_order_count_07.setText(menu_count_07+"");
                    menu_price_07 -= 2000;
                    TV_order_price_07.setText(menu_price_07+"");
                }
                break;

            case R.id.BT_plus_08:
                menu_count_08 += 1;
                TV_order_count_08.setText(menu_count_08+"");
                menu_price_08 += 2000;
                TV_order_price_08.setText(menu_price_08+"");
                break;
            case R.id.BT_minus_08:
                if(menu_count_08<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_08 -= 1;
                    TV_order_count_08.setText(menu_count_08+"");
                    menu_price_08 -= 2000;
                    TV_order_price_08.setText(menu_price_08+"");
                }
                break;

            case R.id.BT_plus_09:
                menu_count_09 += 1;
                TV_order_count_09.setText(menu_count_09+"");
                menu_price_09 += 2000;
                TV_order_price_09.setText(menu_price_09+"");
                break;
            case R.id.BT_minus_09:
                if(menu_count_09<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_09 -= 1;
                    TV_order_count_09.setText(menu_count_09+"");
                    menu_price_09 -= 2000;
                    TV_order_price_09.setText(menu_price_09+"");
                }
                break;

            case R.id.BT_plus_10:
                menu_count_10 += 1;
                TV_order_count_05.setText(menu_count_10+"");
                menu_price_10 += 2000;
                TV_order_price_10.setText(menu_price_10+"");
                break;
            case R.id.BT_minus_10:
                if(menu_count_10<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_10 -= 1;
                    TV_order_count_10.setText(menu_count_10+"");
                    menu_price_10 -= 2000;
                    TV_order_price_10.setText(menu_price_10+"");
                }
                break;
        }

        menu_total_price = menu_price_01 + menu_price_02 + menu_price_03 + menu_price_04 + menu_price_05 + menu_price_06
                + menu_price_07 + menu_price_08 + menu_price_09 + menu_price_10;

        TV_totalPrice.setText(menu_total_price+"");

    }
}
