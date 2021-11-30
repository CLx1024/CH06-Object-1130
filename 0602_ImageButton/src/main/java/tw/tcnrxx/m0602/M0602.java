package tw.tcnrxx.m0602;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import tw.tcnrxx.m0602.R;

public class M0602 extends AppCompatActivity {


    private TextView txtSelect;
    private TextView txtResult;


    private String user_select;
    private String answer;
    private ImageButton btnScissors;
    private ImageButton btnStone;
    private ImageButton btnNet;
    private ImageView txtComPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0602);
        setupViewCOmponent();
    }

    private void setupViewCOmponent() {
        btnScissors = (ImageButton)findViewById(R.id.m0602_b001); //***
        btnStone = (ImageButton)findViewById(R.id.m0602_b002); //***
        btnNet = (ImageButton)findViewById(R.id.m0602_b003);  //***
        txtSelect = (TextView)findViewById(R.id.m0602_s001);
        txtResult = (TextView)findViewById(R.id.m0602_f000);
        txtComPlay = (ImageView)findViewById(R.id.m0602_c001); //******我上支城市沒寫到這個變數？
        btnScissors.setOnClickListener(btn01On);
        btnStone.setOnClickListener(btn01On);
        btnNet.setOnClickListener(btn01On);
    }



    private View.OnClickListener btn01On = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1);       // 1 - scissors, 2 - stone, 3 - net.

            switch(v.getId()){   //這邊次之2
                case R.id.m0602_b001:  //剪刀
                    user_select = getString(R.string.m0602_ans1)+" "+getString(R.string.m0602_b001);
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                            answer = getString(R.string.m0602_ans2)+getString(R.string.m0602_f003);
                            txtResult.setTextColor(Color.YELLOW); //平手黃色
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                            answer = getString(R.string.m0602_ans2)+getString(R.string.m0602_f002);
                            txtResult.setTextColor(Color.RED); //輸用紅色
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                            answer = getString(R.string.m0602_ans2)+getString(R.string.m0602_f001);
                            txtResult.setTextColor(Color.GREEN); //贏用綠色
                            break;
                    }

                   // switch(iComPlay)
                    break;
                case R.id.m0602_b002:  //石頭
                    user_select = getString(R.string.m0602_ans1)+" "+getString(R.string.m0602_b002);
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                            answer = getString(R.string.m0602_ans2)+getString(R.string.m0602_f001);
                            txtResult.setTextColor(Color.GREEN); //贏用綠色
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                            answer = getString(R.string.m0602_ans2)+getString(R.string.m0602_f003);
                            txtResult.setTextColor(Color.YELLOW); //平手黃色
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                            answer = getString(R.string.m0602_ans2)+getString(R.string.m0602_f002);
                            txtResult.setTextColor(Color.RED); //輸用紅色
                            break;
                    }
                    break;
                case R.id.m0602_b003:  //布
                    user_select = getString(R.string.m0602_ans1)+" "+getString(R.string.m0602_b003);
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                            answer = getString(R.string.m0602_ans2)+getString(R.string.m0602_f002);
                            txtResult.setTextColor(Color.RED); //輸用紅色
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                            answer = getString(R.string.m0602_ans2)+getString(R.string.m0602_f001);
                            txtResult.setTextColor(Color.GREEN); //贏用綠色
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                            answer = getString(R.string.m0602_ans2)+getString(R.string.m0602_f003);
                            txtResult.setTextColor(Color.YELLOW); //平手黃色
                            break;
                    }
                    break;

            }
            txtSelect.setText(user_select);  //這邊先寫1
            txtResult.setText(answer);
        }

        };
    }
//    {
//        int icomp = (int) (Math.random() * 3 + 1);       // 1 - scissors, 2 - stone, 3 - net.
//
//        switch(){
//          case //玩家選
//
//      }
//        //txtSelect.setText
//
//    }
//}