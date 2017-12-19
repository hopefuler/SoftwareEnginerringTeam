package startislands.team3.softwareenginerringteam;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

import java.util.Calendar;
import java.util.GregorianCalendar;

public class productAdjustActivity extends AppCompatActivity {

    int year, month, day, hour, minute;

    EditText etEdit;
    AlertDialog.Builder dialog ;
    String AdjustBuffer;
    View AdjustBtnView;
    Button AdjustBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_adjust);

        initList();

        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
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

    public void AddAdjustClick(View v){

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

            case R.id.menu_kind_01:
                AdjustBtn = (Button)findViewById(R.id.menu_kind_01);
                break;
            case R.id.menu_kind_02:
                AdjustBtn = (Button)findViewById(R.id.menu_kind_02);
                break;
            case R.id.menu_kind_03:
                AdjustBtn = (Button)findViewById(R.id.menu_kind_03);
                break;
            case R.id.menu_kind_04:
                AdjustBtn = (Button)findViewById(R.id.menu_kind_04);
                break;
            case R.id.menu_kind_05:
                AdjustBtn = (Button)findViewById(R.id.menu_kind_05);
                break;
            case R.id.menu_kind_06:
                AdjustBtn = (Button)findViewById(R.id.menu_kind_06);
                break;
            case R.id.menu_kind_07:
                AdjustBtn = (Button)findViewById(R.id.menu_kind_07);
                break;
            case R.id.menu_kind_08:
                AdjustBtn = (Button)findViewById(R.id.menu_kind_08);
                break;
            case R.id.menu_kind_09:
                AdjustBtn = (Button)findViewById(R.id.menu_kind_09);
                break;
            case R.id.menu_kind_10:
                AdjustBtn = (Button)findViewById(R.id.menu_kind_10);
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

        if(v.getId()==R.id.menu_kind_01 || v.getId()==R.id.menu_kind_02 || v.getId()==R.id.menu_kind_03 ||
                v.getId()==R.id.menu_kind_04 || v.getId()==R.id.menu_kind_05 || v.getId()==R.id.menu_kind_06 ||
                v.getId()==R.id.menu_kind_07 || v.getId()==R.id.menu_kind_08 || v.getId()==R.id.menu_kind_09 ||
                v.getId()==R.id.menu_kind_10) {
            if (AdjustBuffer.length()>5){
                Toast.makeText(this, "5자 이하로 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        AdjustBtn.setText(AdjustBuffer);
    }

    public void dateClick(View v){
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
            if (dayOfMonth<10){
                String dayOfMonth_str = "0"+dayOfMonth;
                msg = String.format("%d/%d/%s", year,monthOfYear+1, dayOfMonth_str);
            }
            msg = String.format("%d/%d/%d", year,monthOfYear+1, dayOfMonth);
            AdjustBtn.setText(msg);
        }
    };
}
