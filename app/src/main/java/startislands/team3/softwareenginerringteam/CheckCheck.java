package startislands.team3.softwareenginerringteam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//수표확인 페이지
public class CheckCheck extends AppCompatActivity {

    Button checkBackBtn, checkBtn;
    TextView checkResultTV;
    EditText checkEditBtn;

    String checkNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_check);
        checkEditBtn = (EditText)findViewById(R.id.checkEditBtn);
        checkResultTV = (TextView)findViewById(R.id.checkResultTV);
        checkBackBtn = (Button)findViewById(R.id.checkBackBtn);
        checkBtn = (Button)findViewById(R.id.checkBtn);



        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCheck();
            }
        });

        checkBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void checkCheck(){
        checkNumber=checkEditBtn.getText().toString();
        if(checkNumber.length()!=8){
            checkResultTV.setText("일련번호 8자리를 입력해주세요.");
        }else{
            checkResultTV.setText("정상 수표입니다.");
        }
    }

}
