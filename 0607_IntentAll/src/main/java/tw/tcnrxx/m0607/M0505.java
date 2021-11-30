package tw.tcnrxx.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0505 extends AppCompatActivity {

    //private TextView t001;
    private AutoCompleteTextView e001;
    private Button b001;
    private Button b002;
    private ArrayAdapter<String> adapAutoTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0505);
        setupViewcompoment();
    }
    private void setupViewcompoment(){
        Intent intent = this.getIntent();  // 區域
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);  // 傳遞參數

        //t001 = (TextView)findViewById(R.id.m0505_t001);
        e001 = (AutoCompleteTextView)findViewById(R.id.m0505_a001);  //e001
        b001 = (Button)findViewById(R.id.m0505_b001);
        b002 = (Button)findViewById(R.id.m0505_b002);

        adapAutoTxt = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line);  //adapAutoCompText名字可自取

        e001.setAdapter(adapAutoTxt);
        b001.setOnClickListener(b001On);
        b002.setOnClickListener(b001On);  //只需要一個所以也是b001On
    }

    private View.OnClickListener b001On = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.m0505_b001:
                    String s = e001.getText().toString();
                    adapAutoTxt.add(s);
                    e001.setText("");
                    break;
                case R.id.m0505_b002:
                    adapAutoTxt.clear();
                    e001.setText("");
                    break;
            }
        }
    };
}