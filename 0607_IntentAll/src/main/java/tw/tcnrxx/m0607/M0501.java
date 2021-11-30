package tw.tcnrxx.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0501 extends AppCompatActivity {


    private Spinner s001;
    private EditText e001;
    private Button b001;
    private TextView ans01;
    private String sSex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0501);
        setupViewcomponent();    // 自定義方法
    }

    // 空的建構式？
    private void setupViewcomponent() {
        Intent intent = this.getIntent();  // 區域
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);  // 傳遞參數

        s001 = (Spinner) findViewById(R.id.m0501_s001);    // 前面是你JV要叫什麼名字 後面是你Layout叫什麼名字 兩者名字可以完全沒關係
        e001 = (EditText) findViewById(R.id.m0501_e001);
        //////e001 = (TextView) findViewById(R.id.m0501_e001);  //這樣會錯 沒紅字但閃退 但沒說第幾行
        b001 = (Button) findViewById(R.id.m0501_b001);
        ans01 = (TextView) findViewById(R.id.m0501_f000);

//        ArrayAdapter<CharSequence> adapSexList =     // 做一個Adapter給s001用  看你Adapter要取什麼名字都可以
//                ArrayAdapter.createFromResource(
//                        this,
//                        R.array.m0501_a001,
//                        R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapSexList =     // 做一個Adapter給s001用  看你Adapter要取什麼名字都可以
                ArrayAdapter.createFromResource(
                        this,
                        R.array.m0501_a001,
                        R.layout.spinner_item);

//--------------------------------------- Line的
//        ArrayAdapter adapSexList = ArrayAdapter.createFromResource(this, R.array.m0501_a001, R.layout.spinner_item);
//        s001.setAdapter(adapSexList);
//---------------------------------------

        s001.setAdapter(adapSexList);    
        s001.setOnItemSelectedListener(spnSexItemSelLis);    // 監聽Item？
        b001.setOnClickListener(b001On);    // 監聽這個button按下我要做什麼事 這行紅字先不用管打完下面就會消失(不要點紅字自動生宣告行)
    }


    private AdapterView.OnItemSelectedListener spnSexItemSelLis = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sSex = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    private View.OnClickListener b001On = new View.OnClickListener() {    // 這行不會自己出來要背起來
        @Override
        public void onClick(View v) {
            String strSug = getString(R.string.m0501_f000);
            //ans01.setText(strSug);    // output叫strSug
            //--------------------------------------

            if (e001.getText().toString().length()>0){        // 檢查 年齡是否有輸入
                int iAge = Integer.parseInt(e001.getText().toString());
                if(sSex.equals(getString(R.string.chk01))){         // 男
                    if(iAge<28){
                        strSug+=getString(R.string.m0501_f001);
                    }else if (iAge>33){
                        strSug+=getString(R.string.m0501_f003);
                    }else    // 28~33歲
                        strSug+=getString(R.string.m0501_f002);
                }else {                                                                      // 女
                    if(iAge<25){
                        strSug+=getString(R.string.m0501_f001);
                    }else if (iAge>30){
                        strSug+=getString(R.string.m0501_f003);
                    }else    // 25~30歲
                        strSug+=getString(R.string.m0501_f002);
                }



            }else {
                strSug=getString(R.string.nospace);



            }


            //--------------------------------------
            ans01.setText(strSug);    // output叫strSug
        }
    };
    // 挖坑叫做new  new完後面會出來不用自己打
    // view 是你手機看到的地方
    // @override 繼承(系統的？)才有這個字

}



