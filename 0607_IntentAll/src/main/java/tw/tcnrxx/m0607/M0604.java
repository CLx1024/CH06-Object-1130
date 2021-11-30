package tw.tcnrxx.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M0604 extends AppCompatActivity {

    private Button b001;
    private Button b002;
    private Button b003;
    private Button b004;
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0604);
        setupViewComponent();
    }

    private void setupViewComponent() {
        Intent intent = this.getIntent();  // 區域
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);  // 傳遞參數

        b001 = (Button)findViewById(R.id.m0604_b001);
        b002 = (Button)findViewById(R.id.m0604_b002);
        b003 = (Button)findViewById(R.id.m0604_b003);
        b004 = (Button)findViewById(R.id.m0604_b004);
        b001.setOnClickListener(btoast);
        b002.setOnClickListener(btoast);
        b003.setOnClickListener(btoast);
        b004.setOnClickListener(btoast);
    }


    private View.OnClickListener btoast = new View.OnClickListener() {  // 這個要從private開始打
        @Override
        public void onClick(View v) {
            toast = null;  //設初始值 清掉
            switch(v.getId()){
                case(R.id.m0604_b001):
                    Toast.makeText(getApplicationContext(),getText(R.string.m0604_t001),Toast.LENGTH_LONG).show();
                break;
                case(R.id.m0604_b002):
                    toast = Toast.makeText(getApplicationContext(),getText(R.string.m0604_b002),Toast.LENGTH_LONG); //不用show
                    toast.setGravity(Gravity.CENTER, 0,0);  // Offset微調(幾dp?)
                    toast.show();
                break;
                case(R.id.m0604_b003):
                    toast = Toast.makeText(getApplicationContext(),getText(R.string.m0604_b003),Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.END, 0,0);  // 右上角
                    LinearLayout toastView = (LinearLayout) toast.getView();  //區域變數 第一個字LinearLayout不用打最後用選的
                    ImageView img01 = new ImageView(getApplicationContext());
                    img01.setImageResource(R.drawable.ico1);
                    toastView.addView(img01, 0);
                    toast.show();
                break;
                case(R.id.m0604_b004):
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom, (ViewGroup) findViewById(R.id.llToast));  // 設定Layout

                    ImageView image = (ImageView) layout.findViewById(R.id.tvImageToast);  // 這個layout的findViewById
                    TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
                    TextView text = (TextView) layout.findViewById(R.id.tvTextToast);

                    image.setImageResource(R.drawable.ico1);
                    title.setText(getString(R.string.m0604_t001).toString());
                    text.setText(getString(R.string.m0604_t003).toString());

                    //-----------------------------------
                    toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.START | Gravity.TOP, 20, 40);  // 左上 微調dp 那是提示字不用打出來
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();

                    break;
            }
        }
    };
}