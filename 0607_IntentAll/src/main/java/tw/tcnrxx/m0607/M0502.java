package tw.tcnrxx.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0502 extends AppCompatActivity {

    private Button b001;
    private TextView ans01;
    private RadioGroup rb01, rb02;
    private RadioButton rb021, rb022, rb023;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0502);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        Intent intent = this.getIntent();  // 區域
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);  // 傳遞參數

        b001 = (Button) findViewById(R.id.m0502_b001);
        ans01 = (TextView) findViewById(R.id.m0502_f000);    // 建議
        rb01 = (RadioGroup) findViewById(R.id.m0502_r001);    // 性別
        rb02 = (RadioGroup) findViewById(R.id.m0502_r002);    // 年齡
        rb021 = (RadioButton) findViewById(R.id.m0502_r002a);
        rb022 = (RadioButton) findViewById(R.id.m0502_r002b);
        rb023 = (RadioButton) findViewById(R.id.m0502_r002c);

        // 兩個監聽
        rb01.setOnCheckedChangeListener(rb01On);    // 名字可以自己取
        b001.setOnClickListener(b001On);
    }

    private RadioGroup.OnCheckedChangeListener rb01On = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {    // 選到男還女
            switch (checkedId) {    // 上面那行int叫什麼字這裡就放什麼字  // 不用if的話也可這樣做
                case R.id.m0502_r001a:    // 選男
                    rb021.setText(R.string.m0502_r002aa);
                    rb022.setText(R.string.m0502_r002ab);
                    rb023.setText(R.string.m0502_r002ac);
                    break;    // 到這裡中斷跳出 (跳出這個case還這個switch？)
                case R.id.m0502_r001b:    // 選女
                    rb021.setText(R.string.m0502_r002ba);
                    rb022.setText(R.string.m0502_r002bb);
                    rb023.setText(R.string.m0502_r002bc);
                    break;
            }
        }
    };

    private View.OnClickListener b001On = new View.OnClickListener() {    // 這行不會自己出來 要背起來
        @Override
        public void onClick(View v) {
            String strSug = getString(R.string.m0502_f000);
            //--------------------------------------
            int iCheckedRadBtn = rb01.getCheckedRadioButtonId();    // iCheckedRadBtn選區域變數即可
            switch (iCheckedRadBtn) {

                case R.id.m0502_r001a:    // 男
                    switch (rb02.getCheckedRadioButtonId()) {
                        case R.id.m0502_r002a:
                            strSug += getString(R.string.m0502_f001);
                            break;
                        case R.id.m0502_r002b:
                            strSug += getString(R.string.m0502_f002);
                            break;
                        case R.id.m0502_r002c:
                            strSug += getString(R.string.m0502_f003);
                            break;
                    }
                    break;

                case R.id.m0502_r001b:    // 女
                    switch (rb02.getCheckedRadioButtonId()) {
                        case R.id.m0502_r002a:
                            strSug += getString(R.string.m0502_f004);
                            break;
                        case R.id.m0502_r002b:
                            strSug += getString(R.string.m0502_f005);
                            break;
                        case R.id.m0502_r002c:
                            strSug += getString(R.string.m0502_f006);
                            break;

                    }
                    break;
            }
            //--------------------------------------
            ans01.setText(strSug);    // output叫strSug
        }
    };
}



