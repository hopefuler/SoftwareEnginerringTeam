package startislands.team3.softwareenginerringteam;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.YEAR;

public class productAdjustActivity extends AppCompatActivity {

    int year, month, day, hour, minute;

    EditText etEdit;
    AlertDialog.Builder dialog ;
    String AdjustBuffer;
    View AdjustBtnView;
    Button AdjustBtn;
    String temp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_adjust);

        initList();

        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(YEAR);
        month = calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

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

        String StringGoodsList = pref.getString("goodsList","");

        try {
            JSONObject goodsList = new JSONObject(StringGoodsList);
            menu_count_01.setText(goodsList.getString("menu_count_01"));
            menu_count_02.setText(goodsList.getString("menu_count_02"));
            menu_count_03.setText(goodsList.getString("menu_count_03"));
            menu_count_04.setText(goodsList.getString("menu_count_04"));
            menu_count_05.setText(goodsList.getString("menu_count_05"));
            menu_count_06.setText(goodsList.getString("menu_count_06"));
            menu_count_07.setText(goodsList.getString("menu_count_07"));
            menu_count_08.setText(goodsList.getString("menu_count_08"));
            menu_count_09.setText(goodsList.getString("menu_count_09"));
            menu_count_10.setText(goodsList.getString("menu_count_10"));

            menu_inDate_01.setText((goodsList.getString("menu_inDate_01")));
            menu_inDate_02.setText((goodsList.getString("menu_inDate_02")));
            menu_inDate_03.setText((goodsList.getString("menu_inDate_03")));
            menu_inDate_04.setText((goodsList.getString("menu_inDate_04")));
            menu_inDate_05.setText((goodsList.getString("menu_inDate_05")));
            menu_inDate_06.setText((goodsList.getString("menu_inDate_06")));
            menu_inDate_07.setText((goodsList.getString("menu_inDate_07")));
            menu_inDate_08.setText((goodsList.getString("menu_inDate_08")));
            menu_inDate_09.setText((goodsList.getString("menu_inDate_09")));
            menu_inDate_10.setText((goodsList.getString("menu_inDate_10")));

            menu_outDate_01.setText(goodsList.getString("menu_outDate_01"));
            menu_outDate_02.setText(goodsList.getString("menu_outDate_02"));
            menu_outDate_03.setText(goodsList.getString("menu_outDate_03"));
            menu_outDate_04.setText(goodsList.getString("menu_outDate_04"));
            menu_outDate_05.setText(goodsList.getString("menu_outDate_05"));
            menu_outDate_06.setText(goodsList.getString("menu_outDate_06"));
            menu_outDate_07.setText(goodsList.getString("menu_outDate_07"));
            menu_outDate_08.setText(goodsList.getString("menu_outDate_08"));
            menu_outDate_09.setText(goodsList.getString("menu_outDate_09"));
            menu_outDate_10.setText(goodsList.getString("menu_outDate_10"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void AddAdjustClick(View v){


        switch (v.getId()){
            case R.id.menu_count_01 :
                temp = "menu_count_01";
                break;
            case R.id.menu_count_02 :
                temp = "menu_count_02";
                break;
            case R.id.menu_count_03 :
                temp = "menu_count_01";
                break;
            case R.id.menu_count_04 :
                temp = "menu_count_01";
                break;
            case R.id.menu_count_05 :
                temp = "menu_count_05";
                break;
            case R.id.menu_count_06 :
                temp = "menu_count_06";
                break;
            case R.id.menu_count_07 :
                temp = "menu_count_07";
                break;
            case R.id.menu_count_08 :
                temp = "menu_count_08";
                break;
            case R.id.menu_count_09 :
                temp = "menu_count_09";
                break;
            case R.id.menu_count_10 :
                temp = "menu_count_10";
                break;

        }

        AdjustBtnView = v;

        etEdit = new EditText(this);
        dialog = new AlertDialog.Builder(productAdjustActivity.this);
        dialog.setTitle("입력");
        dialog.setView(etEdit);
        if(v.getId()==R.id.menu_count_01 || v.getId()==R.id.menu_count_02 || v.getId()==R.id.menu_count_03 ||
                v.getId()==R.id.menu_count_04 || v.getId()==R.id.menu_count_05 || v.getId()==R.id.menu_count_06 ||
                v.getId()==R.id.menu_count_07 || v.getId()==R.id.menu_count_08 || v.getId()==R.id.menu_count_09 ||
                v.getId()==R.id.menu_count_10)
            etEdit.setInputType(0x00000002);

        // OK 버튼 이벤트
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String inputValue = etEdit.getText().toString();
                AdjustBuffer = inputValue;
                setBtnText(AdjustBtnView);




                SharedPreferences pref = getSharedPreferences("goodsList", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                String StringGoodsList = pref.getString("goodsList","");

                try {
                    JSONObject goodsList = new JSONObject(StringGoodsList);
                    goodsList.put(temp,AdjustBuffer);
                    editor.putString("goodsList",goodsList.toString());
                    editor.commit();

                }catch (JSONException e){

                }
            }
        });

        // Cancel 버튼 이벤트
        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    public void setBtnText(View v){


        switch (v.getId()){
            case R.id.menu_count_01:
                AdjustBtn = (Button)findViewById(R.id.menu_count_01);
                break;
            case R.id.menu_count_02:
                AdjustBtn = (Button)findViewById(R.id.menu_count_02);
                break;
            case R.id.menu_count_03:
                AdjustBtn = (Button)findViewById(R.id.menu_count_03);
                break;
            case R.id.menu_count_04:
                AdjustBtn = (Button)findViewById(R.id.menu_count_04);
                break;
            case R.id.menu_count_05:
                AdjustBtn = (Button)findViewById(R.id.menu_count_05);
                break;
            case R.id.menu_count_06:
                AdjustBtn = (Button)findViewById(R.id.menu_count_06);
                break;
            case R.id.menu_count_07:
                AdjustBtn = (Button)findViewById(R.id.menu_count_07);
                break;
            case R.id.menu_count_08:
                AdjustBtn = (Button)findViewById(R.id.menu_count_08);
                break;
            case R.id.menu_count_09:
                AdjustBtn = (Button)findViewById(R.id.menu_count_09);
                break;
            case R.id.menu_count_10:
                AdjustBtn = (Button)findViewById(R.id.menu_count_10);
                break;
        }

        if(v.getId()==R.id.menu_count_01 || v.getId()==R.id.menu_count_02 || v.getId()==R.id.menu_count_03 ||
                v.getId()==R.id.menu_count_04 || v.getId()==R.id.menu_count_05 || v.getId()==R.id.menu_count_06 ||
                v.getId()==R.id.menu_count_07 || v.getId()==R.id.menu_count_08 || v.getId()==R.id.menu_count_09 ||
                v.getId()==R.id.menu_count_10) {
            if (Integer.parseInt(AdjustBuffer) > 99){
                Toast.makeText(this, "99이하로 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        AdjustBtn.setText(AdjustBuffer);
    }


    public void dateClick(View v){

        switch (v.getId()){
            case R.id.menu_inDate_01 :
                temp = "menu_inDate_01";
                break;
            case R.id.menu_inDate_02 :
                temp = "menu_inDate_02";
                break;
            case R.id.menu_inDate_03 :
                temp = "menu_inDate_03";
                break;
            case R.id.menu_inDate_04 :
                temp = "menu_inDate_04";
                break;
            case R.id.menu_inDate_05 :
                temp = "menu_inDate_05";
                break;
            case R.id.menu_inDate_06 :
                temp = "menu_inDate_06";
                break;
            case R.id.menu_inDate_07 :
                temp = "menu_inDate_07";
                break;
            case R.id.menu_inDate_08 :
                temp = "menu_inDate_08";
                break;
            case R.id.menu_inDate_09 :
                temp = "menu_inDate_09";
                break;
            case R.id.menu_inDate_10 :
                temp = "menu_inDate_10";
                break;

            case R.id.menu_outDate_01 :
                temp = "menu_outDate_01";
                break;
            case R.id.menu_outDate_02 :
                temp = "menu_outDate_02";
                break;
            case R.id.menu_outDate_03 :
                temp = "menu_outDate_03";
                break;
            case R.id.menu_outDate_04 :
                temp = "menu_outDate_04";
                break;
            case R.id.menu_outDate_05 :
                temp = "menu_outDate_05";
                break;
            case R.id.menu_outDate_06 :
                temp = "menu_outDate_06";
                break;
            case R.id.menu_outDate_07 :
                temp = "menu_outDate_07";
                break;
            case R.id.menu_outDate_08 :
                temp = "menu_outDate_08";
                break;
            case R.id.menu_outDate_09 :
                temp = "menu_outDate_09";
                break;
            case R.id.menu_outDate_10 :
                temp = "menu_outDate_10";
                break;
        }


        switch (v.getId()) {
            case R.id.menu_inDate_01:
                AdjustBtn = (Button) findViewById(R.id.menu_inDate_01);
                break;
            case R.id.menu_inDate_02:
                AdjustBtn = (Button) findViewById(R.id.menu_inDate_02);
                break;
            case R.id.menu_inDate_03:
                AdjustBtn = (Button) findViewById(R.id.menu_inDate_03);
                break;
            case R.id.menu_inDate_04:
                AdjustBtn = (Button) findViewById(R.id.menu_inDate_04);
                break;
            case R.id.menu_inDate_05:
                AdjustBtn = (Button) findViewById(R.id.menu_inDate_05);
                break;
            case R.id.menu_inDate_06:
                AdjustBtn = (Button) findViewById(R.id.menu_inDate_06);
                break;
            case R.id.menu_inDate_07:
                AdjustBtn = (Button) findViewById(R.id.menu_inDate_07);
                break;
            case R.id.menu_inDate_08:
                AdjustBtn = (Button) findViewById(R.id.menu_inDate_08);
                break;
            case R.id.menu_inDate_09:
                AdjustBtn = (Button) findViewById(R.id.menu_inDate_09);
                break;

            case R.id.menu_outDate_01:
                AdjustBtn = (Button) findViewById(R.id.menu_outDate_01);
                break;
            case R.id.menu_outDate_02:
                AdjustBtn = (Button) findViewById(R.id.menu_outDate_02);
                break;
            case R.id.menu_outDate_03:
                AdjustBtn = (Button) findViewById(R.id.menu_outDate_03);
                break;
            case R.id.menu_outDate_04:
                AdjustBtn = (Button) findViewById(R.id.menu_outDate_04);
                break;
            case R.id.menu_outDate_05:
                AdjustBtn = (Button) findViewById(R.id.menu_outDate_05);
                break;
            case R.id.menu_outDate_06:
                AdjustBtn = (Button) findViewById(R.id.menu_outDate_06);
                break;
            case R.id.menu_outDate_07:
                AdjustBtn = (Button) findViewById(R.id.menu_outDate_07);
                break;
            case R.id.menu_outDate_08:
                AdjustBtn = (Button) findViewById(R.id.menu_outDate_08);
                break;
            case R.id.menu_outDate_09:
                AdjustBtn = (Button) findViewById(R.id.menu_outDate_09);
                break;
            case R.id.menu_outDate_10:
                AdjustBtn = (Button) findViewById(R.id.menu_outDate_10);
                break;

        }
        new DatePickerDialog(productAdjustActivity.this, dateSetListener, year, month, day).show();
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
            // TODO Auto-generated method stub
            String msg="";

            if (dayOfMonth<10 && monthOfYear+1<10)
                msg = String.format("%d/0%d/0%d", year,monthOfYear+1, dayOfMonth);
            else if (dayOfMonth<10 && monthOfYear+1>=10)
                msg = String.format("%d/%d/0%d", year,monthOfYear+1, dayOfMonth);
            else if (dayOfMonth>=10 && monthOfYear+1<10)
                msg = String.format("%d/0%d/%d", year,monthOfYear+1, dayOfMonth);
            else
                msg = String.format("%d/%d/%d", year,monthOfYear+1, dayOfMonth);

            AdjustBtn.setText(msg);

            SharedPreferences pref = getSharedPreferences("goodsList", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            String StringGoodsList = pref.getString("goodsList","");

            try {
                JSONObject goodsList = new JSONObject(StringGoodsList);
                goodsList.put(temp,msg);
                editor.putString("goodsList",goodsList.toString());
                editor.commit();

            }catch (JSONException e){

            }
        }
    };
}
