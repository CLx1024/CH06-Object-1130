package tw.tcnr13.m0608;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class M0608 extends AppCompatActivity {

    private Button b000, b001, b002, b003, b004;
    private Button b005;
    private Button b006;
    private Button b007;
    private Button b008;
    private Button b009;
    private Button b010;
    private Button b011, b012, b013, b014, b015;

    private TextView num1;
    private TextView ans;
    private double nn;
    private String s;
    private double n1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0608);
        setupViewComponent();
    }

    private void setupViewComponent() {
        num1 = (TextView) findViewById(R.id.m0608_t001);
        num1.setText("");
        ans = (TextView) findViewById(R.id.m0608_t002);

        b000 = (Button) findViewById(R.id.m0608_b000);
        b001 = (Button) findViewById(R.id.m0608_b001);
        b002 = (Button) findViewById(R.id.m0608_b002);
        b003 = (Button) findViewById(R.id.m0608_b003);
        b004 = (Button) findViewById(R.id.m0608_b004);
        b005 = (Button) findViewById(R.id.m0608_b005);
        b006 = (Button) findViewById(R.id.m0608_b006);
        b007 = (Button) findViewById(R.id.m0608_b007);
        b008 = (Button) findViewById(R.id.m0608_b008);
        b009 = (Button) findViewById(R.id.m0608_b009);
        b010 = (Button) findViewById(R.id.m0608_b010);

        b011 = (Button) findViewById(R.id.m0608_b011);
        b012 = (Button) findViewById(R.id.m0608_b012);
        b013 = (Button) findViewById(R.id.m0608_b013);
        b014 = (Button) findViewById(R.id.m0608_b014);
        b015 = (Button) findViewById(R.id.m0608_b015);

        b000.setOnClickListener(numOnClick);
        b001.setOnClickListener(numOnClick);
        b002.setOnClickListener(numOnClick);
        b003.setOnClickListener(numOnClick);
        b004.setOnClickListener(numOnClick);
        b005.setOnClickListener(numOnClick);
        b006.setOnClickListener(numOnClick);
        b007.setOnClickListener(numOnClick);
        b008.setOnClickListener(numOnClick);
        b009.setOnClickListener(numOnClick);
        b010.setOnClickListener(numOnClick);

        b011.setOnClickListener(calOnClick);
        b012.setOnClickListener(calOnClick);
        b013.setOnClickListener(calOnClick);
        b014.setOnClickListener(calOnClick);

        b015.setOnClickListener(equOnClick);

    }


    private View.OnClickListener numOnClick = new View.OnClickListener() {  // 這裡的private要自己打 打到後面再讓它自己生下面的字
        @Override
        public void onClick(View v) {
            String keyin = num1.getText().toString();  // 這個keyin選local即可

            switch (v.getId()) {  // 把文字變字串相加
                case R.id.m0608_b000:
                    num1.setText(keyin + "0");
                    break;
                case R.id.m0608_b001:
                    num1.setText(keyin + "1");
                    break;
                case R.id.m0608_b002:
                    num1.setText(keyin + "2");
                    break;
                case R.id.m0608_b003:
                    num1.setText(keyin + "3");
                    break;
                case R.id.m0608_b004:
                    num1.setText(keyin + "4");
                    break;
                case R.id.m0608_b005:
                    num1.setText(keyin + "5");
                    break;
                case R.id.m0608_b006:
                    num1.setText(keyin + "6");
                    break;
                case R.id.m0608_b007:
                    num1.setText(keyin + "7");
                    break;
                case R.id.m0608_b008:
                    num1.setText(keyin + "8");
                    break;
                case R.id.m0608_b009:
                    num1.setText(keyin + "9");
                    break;
                case R.id.m0608_b010:
                    num1.setText(keyin + ".");
                    break;
            }
        }
    };

    private View.OnClickListener calOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//
//            nn = Double.parseDouble(num1.getText().toString());  // 把剛剛打的字抓出來存到nn裡面  //沒輸入按+-*/這行會閃退所以改寫
//            num1.setText(""); //存起來後就清空白了

            try {
                nn = Double.parseDouble(num1.getText().toString());  //因為會閃退所以改寫成這樣
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), getText(R.string.error), Toast.LENGTH_LONG).show();  //這行也可不show出來 只是告訴你為何錯誤  吐司這行要背起來
            }

            switch (v.getId()) {
                case R.id.m0608_b011:
                    s = "P";
                    n1 = n1 + nn;
                    break;
                case R.id.m0608_b012:
                    s = "M";
                    n1 = n1 - nn;
                    break;
                case R.id.m0608_b013:
                    s = "X";
                    n1 = n1 * nn;
                    break;
                case R.id.m0608_b014:
                    s = "D";
                    n1 = n1 / nn;
                    break;
            }


        }

    };

    private View.OnClickListener equOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (num1.getText().toString().trim().length() != 0) {

                double n2 = Double.parseDouble(num1.getText().toString());  //區域變數
                DecimalFormat nf = new DecimalFormat("0.0000");   //格式化

                if (s.equals("P"))
                    ans.setText(nf.format(nn + n2));  // 只有一行就不用{}
                if (s.equals("M"))
                    ans.setText(nf.format(nn - n2));  // 只有一行就不用{}
                if (s.equals("X"))
                    ans.setText(nf.format(nn * n2));  // 只有一行就不用{}
                if (s.equals("D"))
                    ans.setText(nf.format(nn / n2));  // 只有一行就不用{}

                num1.setText("");  // 這兩行是要清掉
                nn = 0;
            } else {
                Toast.makeText(getApplicationContext(), R.string.m0608_error, Toast.LENGTH_LONG).show(); //記得要show
            }
        }
    };


//    private View.OnClickListener equOnClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View v){
//        if(num1.getText().toString().trim().length()!=0)
//        {
//            double n2=Double.parseDouble(num1.getText().toString());  //區域變數
//            DecimalFormat nf=new DecimalFormat("0.0000");   //格式化
//
//        if(s.equals("P"))
//        ans.setText(nf.format(nn+n2));  // 只有一行就不用{}
//
//        num1.setText("");  // 這兩行是要清掉
//        nn=0;
//
//
//        } else{  // 講義沒放else這段
//            Toast.makeText(getApplicationContext(),R.string.m0608_error,Toast.LENGTH_LONG).show();
//        }
//        }
//    };
//}

}