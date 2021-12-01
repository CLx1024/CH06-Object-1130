package tw.sgft.m0202;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0202 extends AppCompatActivity {

    private Intent intent = new Intent();   // 企圖 宣告 挖一個坑 沒挖坑會閃退
    private Button b001, b002, b003;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0202);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001 = (Button)findViewById(R.id.m0202_b001);
        b002 = (Button)findViewById(R.id.m0202_b002);
        b003 = (Button)findViewById(R.id.m0202_b003);
        b001.setOnClickListener(btnON);
        b002.setOnClickListener(btnON);
        b003.setOnClickListener(btnON);
    }

    private View.OnClickListener btnON = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.m0202_b001:
                    intent.putExtra("class_title",getString(R.string.m0202_b001));
                    intent.setClass(M0202.this, M020201.class);
                    break;
                case R.id.m0202_b002:
                    intent.putExtra("class_title",getString(R.string.m0202_b002));
                    intent.setClass(M0202.this, M020202.class);
                case R.id.m0202_b003:
                    intent.putExtra("class_title",getString(R.string.m0202_b003));
                    intent.setClass(M0202.this, M020204.class);   // M020203
                    break;
            }
            startActivity(intent);
        }
    };
}