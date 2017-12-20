package startislands.team3.softwareenginerringteam;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetailInfoActivity extends AppCompatActivity {


    TextView etEdit;
    AlertDialog.Builder dialog ;

    String PAYMENT_time; // 거래 시간
    String PAYMENT_method; // 거래 방식
    JSONObject PAYMENT_centext; // 거래 내용
    String PAYMENT_date; // 거래 날짜
    String PAYMENT_number; // 거래 일련번호
    String PAYMENT_total_price; // 거래 총액

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail_info);

        Intent intent = getIntent();

        PAYMENT_number =intent.getExtras().getString("PAYMENT_number");

        TextView pdi_totalprice = (TextView)findViewById(R.id.pdi_totalprice);
        TextView pdi_method = (TextView)findViewById(R.id.pdi_method);
        TextView pdi_time = (TextView)findViewById(R.id.pdi_time);
        TextView pdi_date = (TextView)findViewById(R.id.pdi_date);
        TextView result_saleprice =(TextView)findViewById(R.id.result_saleprice);
        TextView pdi_saleprice=(TextView)findViewById(R.id.pdi_saleprice);

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



        SharedPreferences pref = getSharedPreferences("transactionList", MODE_PRIVATE);
        try {
            PAYMENT_centext = new JSONObject(pref.getString(PAYMENT_number,""));
            TV_order_count_01.setText(PAYMENT_centext.getString("TV_order_count_01"));
            TV_order_count_02.setText(PAYMENT_centext.getString("TV_order_count_02"));
            TV_order_count_03.setText(PAYMENT_centext.getString("TV_order_count_03"));
            TV_order_count_04.setText(PAYMENT_centext.getString("TV_order_count_04"));
            TV_order_count_05.setText(PAYMENT_centext.getString("TV_order_count_05"));
            TV_order_count_06.setText(PAYMENT_centext.getString("TV_order_count_06"));
            TV_order_count_07.setText(PAYMENT_centext.getString("TV_order_count_07"));
            TV_order_count_08.setText(PAYMENT_centext.getString("TV_order_count_08"));
            TV_order_count_09.setText(PAYMENT_centext.getString("TV_order_count_09"));
            TV_order_count_10.setText(PAYMENT_centext.getString("TV_order_count_10"));

            TV_order_price_01.setText( Integer.parseInt(TV_order_count_01.getText().toString())*2000+"");
            TV_order_price_02.setText( Integer.parseInt(TV_order_count_02.getText().toString())*2800+"");
            TV_order_price_03.setText( Integer.parseInt(TV_order_count_03.getText().toString())*2300+"");
            TV_order_price_04.setText( Integer.parseInt(TV_order_count_04.getText().toString())*2500+"");
            TV_order_price_05.setText( Integer.parseInt(TV_order_count_05.getText().toString())*2500+"");
            TV_order_price_06.setText( Integer.parseInt(TV_order_count_06.getText().toString())*3500+"");
            TV_order_price_07.setText( Integer.parseInt(TV_order_count_07.getText().toString())*3500+"");
            TV_order_price_08.setText( Integer.parseInt(TV_order_count_08.getText().toString())*3800+"");
            TV_order_price_09.setText( Integer.parseInt(TV_order_count_09.getText().toString())*500+"");
            TV_order_price_10.setText( Integer.parseInt(TV_order_count_10.getText().toString())*500+"");


            PAYMENT_total_price=PAYMENT_centext.getString("PAYMENT_total_price");
            PAYMENT_method=PAYMENT_centext.getString("PAYMENT_method");
            PAYMENT_time=PAYMENT_centext.getString("PAYMENT_time");
            PAYMENT_date=PAYMENT_centext.getString("PAYMENT_date");

            pdi_saleprice.setText(PAYMENT_centext.getString("PAYMENT_sale_price"));
            result_saleprice.setText(Integer.parseInt(PAYMENT_total_price)-Integer.parseInt(pdi_saleprice.getText().toString())+"");


        } catch (JSONException e) {
            e.printStackTrace();
        }


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
                etEdit = new TextView(this);
                dialog = new AlertDialog.Builder(PaymentDetailInfoActivity.this);
                dialog.setTitle("카드를 인식시켜주세요.");
                dialog.setView(etEdit);
                etEdit.setText("0000 - 0000 - 0000 - 0000");
                etEdit.setPadding(100,100,100,100);

                // OK 버튼 이벤트
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // DB내용 지우기
                        SharedPreferences pref = getSharedPreferences("transactionList", MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();

                        if(PAYMENT_method.equals("(결제 취소)")){
                            Toast.makeText(PaymentDetailInfoActivity.this, "이미 결제 취소 완료된 품목입니다.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(PaymentDetailInfoActivity.this, PaymentListInfoActivity.class));
                            finish();
                        }

                        try {
                            PAYMENT_centext.put("PAYMENT_total_price","0");
                            PAYMENT_centext.put("PAYMENT_sale_price","0");
                            PAYMENT_centext.put("PAYMENT_method","(결제 취소)");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        editor.putString(PAYMENT_number, PAYMENT_centext.toString());
                        editor.commit();

                        startActivity(new Intent(PaymentDetailInfoActivity.this, PaymentListInfoActivity.class));
                        finish();

                        Toast.makeText(PaymentDetailInfoActivity.this, "결제취소 완료", Toast.LENGTH_SHORT).show();

                    }
                });

                // Cancel 버튼 이벤트
                dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog.show();
                break;

            case R.id.move_main: // 결제 취소
                startActivity(new Intent(PaymentDetailInfoActivity.this, PaymentListInfoActivity.class));
                finish();
                break;

        }


    }
}
