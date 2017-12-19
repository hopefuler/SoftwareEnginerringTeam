package startislands.team3.softwareenginerringteam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SaleActivity extends AppCompatActivity {

    EditText salePhoneEdit,saleCuponEdit;
    Button salePhoneBtn,saleCuponBtn,saleAdmitbtn,saleBackbtn;

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

    }
}
