package tw.tcnrxx.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class M0500 extends AppCompatActivity {

    // 1102 8:38 錄音      private EditText e001;
    private Button b001;
    private TextView t003;
    private EditText e001;
    private DecimalFormat poundsFormat;      //  1102 8:38 錄音
    private String ans;        //  1102 8:38 錄音

    @Override
    protected void onCreate(Bundle savedInstanceState) {    // void 不用回傳
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewcomponent();    // 自定義方法
    }

    // 定義配置碼
    private void setupViewcomponent() {
        Intent intent = this.getIntent();  //區域即可
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);  // 傳遞參數


        //  1102 8:38 錄音       e001 = (EditText) findViewById(R.id.m0500_e001);    // 輸入公斤
        e001=(EditText)findViewById(R.id.m0500_e001);   // 1102 8:38 錄音
        // e001.get          // 1102 8:38 錄音

        b001 = (Button) findViewById(R.id.m0500_b001);    // 執行換算按鈕
        t003 = (TextView) findViewById(R.id.m0500_t003);    // 公斤轉磅答案
        b001.setOnClickListener(b001On);
    }


    // private String ans;           // 1102 8:38 錄音
        private View.OnClickListener b001On = new View.OnClickListener() {
        @Override
        public void onClick(View v) {    // 被按下按鈕要做的事
            // 1102 8:38 錄音        DecimalFormat poundsFormat = new DecimalFormat("0.00000");    // 格式化的宣告
            poundsFormat = new DecimalFormat("0.00000");       // 1102 8:38 錄音
            if (e001.getText().toString().length() > 0) {
                ans = poundsFormat.format(Float.parseFloat(e001.getText().toString()) * 2.20462262);
            } else {
                ans = "";
            }
            t003.setText(ans);
        }
    };
}