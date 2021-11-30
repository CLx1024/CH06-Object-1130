package tw.tcnrxx.m0607;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class M0607 extends AppCompatActivity {

    private Intent intent = new Intent();   // 企圖 宣告 挖一個坑 沒挖坑會閃退
    private Button b001, b002, b003, b004, b005, b006, b007;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0607);
        setupViewComponent();
    }

    private void setupViewComponent() {



        b001 = (Button)findViewById(R.id.m0000_b0500);
        b002 = (Button)findViewById(R.id.m0000_b0501);
        b003 = (Button)findViewById(R.id.m0000_b0502);
        b004 = (Button)findViewById(R.id.m0000_b0503);
        b005 = (Button)findViewById(R.id.m0000_b0505);
        b006 = (Button)findViewById(R.id.m0000_b0604);
        b007 = (Button)findViewById(R.id.m0000_b0606);
        b001.setOnClickListener(btnON);
        b002.setOnClickListener(btnON);
        b003.setOnClickListener(btnON);
        b004.setOnClickListener(btnON);
        b005.setOnClickListener(btnON);
        b006.setOnClickListener(btnON);
        b007.setOnClickListener(btnON);
    }

    private View.OnClickListener btnON = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.m0000_b0500:
                    // intent.putExtra("class_title","xyz");  //傳遞參數
                    intent.putExtra("class_title",getString(R.string.m0000_b0500));  //傳遞參數
                    intent.setClass(M0607.this,M0500.class);  //  從哪裡到哪裡
                    break;
                case R.id.m0000_b0501:
                    intent.putExtra("class_title",getString(R.string.m0000_b0501));
                    intent.setClass(M0607.this,M0501.class);
                    break;
                case R.id.m0000_b0502:
                    intent.putExtra("class_title",getString(R.string.m0000_b0502));
                    intent.setClass(M0607.this,M0502.class);
                    break;
                case R.id.m0000_b0503:
                    intent.putExtra("class_title",getString(R.string.m0000_b0504));
                    intent.setClass(M0607.this,M0504.class);
                    break;
                case R.id.m0000_b0505:
                    intent.putExtra("class_title",getString(R.string.m0000_b0505));
                    intent.setClass(M0607.this,M0505.class);
                    break;
                case R.id.m0000_b0604:
                    intent.putExtra("class_title",getString(R.string.m0000_b0604));
                    intent.setClass(M0607.this,M0604.class);
                    break;
                case R.id.m0000_b0606:
                    intent.putExtra("class_title",getString(R.string.m0000_b0606));
                    intent.setClass(M0607.this,M0606.class);
                    break;


            }
            startActivity(intent);

        }
    };



}