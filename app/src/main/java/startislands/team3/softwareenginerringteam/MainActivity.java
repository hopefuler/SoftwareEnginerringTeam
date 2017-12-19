package startislands.team3.softwareenginerringteam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.YEAR;

public class MainActivity extends AppCompatActivity {

    // 주문 내용
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

    int menu_able_count_01= 0;
    int menu_able_count_02= 0;
    int menu_able_count_03= 0;
    int menu_able_count_04= 0;
    int menu_able_count_05= 0;
    int menu_able_count_06= 0;
    int menu_able_count_07= 0;
    int menu_able_count_08= 0;
    int menu_able_count_09= 0;
    int menu_able_count_10= 0;

    String menu_able_outDate_01="";
    String menu_able_outDate_02="";
    String menu_able_outDate_03="";
    String menu_able_outDate_04="";
    String menu_able_outDate_05="";
    String menu_able_outDate_06="";
    String menu_able_outDate_07="";
    String menu_able_outDate_08="";
    String menu_able_outDate_09="";
    String menu_able_outDate_10="";


    int PAYMENT_centext[]; // 주문 내용
    int PAYMENT_number = 0 ; // 주문 번호 -> db에서 유동적으로 변화시키기
    String PAYMENT_date; // 주문 일자
    int PAYMENT_total_price = 0; // 주문 총액
    String PAYMENT_time; // 주문 시간

    long now;
    Date date;
    SimpleDateFormat sdfNowDate;
    SimpleDateFormat sdfNowTime ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ableOrder();
        Toast.makeText(this, menu_able_count_01+"", Toast.LENGTH_SHORT).show();

    }

    public void topButtonClick(View v) {
        switch (v.getId()) {
            case R.id.order_btn: // 주문 창
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.list_btn: // 거래내역 창
                startActivity(new Intent(MainActivity.this, PaymentListInfoActivity.class));

                break;
            case R.id.adjust_btn: // 상품관리 창
                startActivity(new Intent(MainActivity.this, productAdjustActivity.class));

                break;
        }
    }

    public void orderSubmitClick(View v) {  // 주문 버튼
        orderSubmit(v); // 주문 접수
    }

    public void orderSubmit(View v){ // 주문 접수
        now = System.currentTimeMillis();
        date = new Date(now);
        sdfNowDate = new SimpleDateFormat("yyyy/MM/dd");
        sdfNowTime = new SimpleDateFormat("HH:mm:ss");

        switch (v.getId()) {
            case R.id.order_submit_btn: // 결제창으로 이동

                PAYMENT_centext = new int[10];
                PAYMENT_centext[0]=menu_count_01;
                PAYMENT_centext[1]=menu_count_02;
                PAYMENT_centext[2]=menu_count_03;
                PAYMENT_centext[3]=menu_count_04;
                PAYMENT_centext[4]=menu_count_05;
                PAYMENT_centext[5]=menu_count_06;
                PAYMENT_centext[6]=menu_count_07;
                PAYMENT_centext[7]=menu_count_08;
                PAYMENT_centext[8]=menu_count_09;
                PAYMENT_centext[9]=menu_count_10;



                PAYMENT_date = sdfNowDate.format(date);
                PAYMENT_time = sdfNowTime.format(date);

                Intent intent = new Intent(MainActivity.this, SelectPaymentActivity.class);
                intent.putExtra("PAYMENT_centext",PAYMENT_centext); // 주문 내용
                intent.putExtra("PAYMENT_number",PAYMENT_number+""); // 주문 번호
                intent.putExtra("PAYMENT_date",PAYMENT_date); // 주문 일자
                intent.putExtra("PAYMENT_total_price",PAYMENT_total_price+""); // 주문 총액
                intent.putExtra("PAYMENT_time",PAYMENT_time); // 주문 시간

                // 주문번호 ++ 해서 DB 저장하기.

                startActivity(intent);
                //finish();

                for(int i=0; i<10 ; i++){
                    TextView order_count = (TextView)findViewById(R.id.TV_order_count_01+i);
                    order_count.setText("0");
                    TextView order_price = (TextView)findViewById(R.id.TV_order_price_01+i);
                    order_price.setText("0");
                }
                TextView TV_totalPrice = (TextView)findViewById(R.id.TV_totalPrice);
                TV_totalPrice.setText("0");

                break;
        }
    }

    public void ableOrder(){

        SharedPreferences pref = getSharedPreferences("goodsList", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();


        String initFlag=pref.getString("goodsList","");

        if(initFlag.equals("")){    //초기값 설정
            JSONObject goodsList = new JSONObject();
            try {
                goodsList.put("menu_count_01","10");
                goodsList.put("menu_count_02","10");
                goodsList.put("menu_count_03","10");
                goodsList.put("menu_count_04","10");
                goodsList.put("menu_count_05","10");
                goodsList.put("menu_count_06","10");
                goodsList.put("menu_count_07","10");
                goodsList.put("menu_count_08","10");
                goodsList.put("menu_count_09","10");
                goodsList.put("menu_count_10","10");

                Calendar now = Calendar.getInstance();


                goodsList.put("menu_inDate_01",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_inDate_02",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_inDate_03",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_inDate_04",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_inDate_05",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_inDate_06",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_inDate_07",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_inDate_08",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_inDate_09",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_inDate_10",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));


                goodsList.put("menu_outDate_01",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_outDate_02",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_outDate_03",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_outDate_04",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_outDate_05",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_outDate_06",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_outDate_07",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_outDate_08",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_outDate_09",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
                goodsList.put("menu_outDate_10",now.get(YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DATE));
            } catch (JSONException e) {
                e.printStackTrace();
            }


            editor.putString("goodsList",goodsList.toString());
            editor.commit();

        }

        String StringGoodsList = pref.getString("goodsList","");

        try {
            JSONObject goodsList = new JSONObject(StringGoodsList);
            menu_able_count_01=Integer.parseInt(goodsList.getString("menu_count_01"));
            menu_able_count_02=Integer.parseInt(goodsList.getString("menu_count_02"));
            menu_able_count_03=Integer.parseInt(goodsList.getString("menu_count_03"));
            menu_able_count_04=Integer.parseInt(goodsList.getString("menu_count_04"));
            menu_able_count_05=Integer.parseInt(goodsList.getString("menu_count_05"));
            menu_able_count_06=Integer.parseInt(goodsList.getString("menu_count_06"));
            menu_able_count_07=Integer.parseInt(goodsList.getString("menu_count_07"));
            menu_able_count_08=Integer.parseInt(goodsList.getString("menu_count_08"));
            menu_able_count_09=Integer.parseInt(goodsList.getString("menu_count_09"));
            menu_able_count_10=Integer.parseInt(goodsList.getString("menu_count_10"));


            menu_able_outDate_01=(goodsList.getString("menu_outDate_01"));
            menu_able_outDate_02=(goodsList.getString("menu_outDate_02"));
            menu_able_outDate_03=(goodsList.getString("menu_outDate_03"));
            menu_able_outDate_04=(goodsList.getString("menu_outDate_04"));
            menu_able_outDate_05=(goodsList.getString("menu_outDate_05"));
            menu_able_outDate_06=(goodsList.getString("menu_outDate_06"));
            menu_able_outDate_07=(goodsList.getString("menu_outDate_07"));
            menu_able_outDate_08=(goodsList.getString("menu_outDate_08"));
            menu_able_outDate_09=(goodsList.getString("menu_outDate_09"));
            menu_able_outDate_10=(goodsList.getString("menu_outDate_10"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void countAdjustClick(View v) { // 수정 버튼
        orderAdjust(v); // 주문수정
    }

    public void orderAdjust(View v){ // 주문 수정
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
                menu_price_02 += 2800;
                TV_order_price_02.setText(menu_price_02+"");
                break;
            case R.id.BT_minus_02:
                if(menu_count_02<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_02 -= 1;
                    TV_order_count_02.setText(menu_count_02+"");
                    menu_price_02 -= 2800;
                    TV_order_price_02.setText(menu_price_02+"");
                }
                break;

            case R.id.BT_plus_03:
                menu_count_03 += 1;
                TV_order_count_03.setText(menu_count_03+"");
                menu_price_03 += 2300;
                TV_order_price_03.setText(menu_price_03+"");
                break;
            case R.id.BT_minus_03:
                if(menu_count_03<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_03 -= 1;
                    TV_order_count_03.setText(menu_count_03+"");
                    menu_price_03 -= 2300;
                    TV_order_price_03.setText(menu_price_03+"");
                }
                break;

            case R.id.BT_plus_04:
                menu_count_04 += 1;
                TV_order_count_04.setText(menu_count_04+"");
                menu_price_04 += 2500;
                TV_order_price_04.setText(menu_price_04+"");
                break;
            case R.id.BT_minus_04:
                if(menu_count_04<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_04 -= 1;
                    TV_order_count_04.setText(menu_count_04+"");
                    menu_price_04 -= 2500;
                    TV_order_price_04.setText(menu_price_04+"");
                }
                break;

            case R.id.BT_plus_05:
                menu_count_05 += 1;
                TV_order_count_05.setText(menu_count_05+"");
                menu_price_05 += 2500;
                TV_order_price_05.setText(menu_price_05+"");
                break;
            case R.id.BT_minus_05:
                if(menu_count_05<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_05 -= 1;
                    TV_order_count_05.setText(menu_count_05+"");
                    menu_price_05 -= 2500;
                    TV_order_price_05.setText(menu_price_05+"");
                }
                break;

            case R.id.BT_plus_06:
                menu_count_06 += 1;
                TV_order_count_06.setText(menu_count_06+"");
                menu_price_06 += 3500;
                TV_order_price_06.setText(menu_price_06+"");
                break;
            case R.id.BT_minus_06:
                if(menu_count_06<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_06 -= 1;
                    TV_order_count_06.setText(menu_count_06+"");
                    menu_price_06 -= 3500;
                    TV_order_price_06.setText(menu_price_06+"");
                }
                break;

            case R.id.BT_plus_07:
                menu_count_07 += 1;
                TV_order_count_07.setText(menu_count_07+"");
                menu_price_07 += 3500;
                TV_order_price_07.setText(menu_price_07+"");
                break;
            case R.id.BT_minus_07:
                if(menu_count_07<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_07 -= 1;
                    TV_order_count_07.setText(menu_count_07+"");
                    menu_price_07 -= 3500;
                    TV_order_price_07.setText(menu_price_07+"");
                }
                break;

            case R.id.BT_plus_08:
                menu_count_08 += 1;
                TV_order_count_08.setText(menu_count_08+"");
                menu_price_08 += 3800;
                TV_order_price_08.setText(menu_price_08+"");
                break;
            case R.id.BT_minus_08:
                if(menu_count_08<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_08 -= 1;
                    TV_order_count_08.setText(menu_count_08+"");
                    menu_price_08 -= 3800;
                    TV_order_price_08.setText(menu_price_08+"");
                }
                break;

            case R.id.BT_plus_09:
                menu_count_09 += 1;
                TV_order_count_09.setText(menu_count_09+"");
                menu_price_09 += 500;
                TV_order_price_09.setText(menu_price_09+"");
                break;
            case R.id.BT_minus_09:
                if(menu_count_09<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_09 -= 1;
                    TV_order_count_09.setText(menu_count_09+"");
                    menu_price_09 -= 500;
                    TV_order_price_09.setText(menu_price_09+"");
                }
                break;

            case R.id.BT_plus_10:
                menu_count_10 += 1;
                TV_order_count_10.setText(menu_count_10+"");
                menu_price_10 += 500;
                TV_order_price_10.setText(menu_price_10+"");
                break;
            case R.id.BT_minus_10:
                if(menu_count_10<1)
                    Toast.makeText(this, "더 이상 메뉴를 줄일 수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    menu_count_10 -= 1;
                    TV_order_count_10.setText(menu_count_10+"");
                    menu_price_10 -= 500;
                    TV_order_price_10.setText(menu_price_10+"");
                }
                break;
        }

        PAYMENT_total_price = menu_price_01 + menu_price_02 + menu_price_03 + menu_price_04 + menu_price_05 + menu_price_06
                + menu_price_07 + menu_price_08 + menu_price_09 + menu_price_10;

        TV_totalPrice.setText(PAYMENT_total_price+"");

    }
}
