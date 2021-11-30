package tw.tcnrxx.m0601;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class M0601 extends AppCompatActivity {

    private Button btnScissors;
    private Button btnStone;
    private Button btnNet;
    private TextView txtSelect;
    private TextView txtResult;
    private TextView txtComPlay;

    private String user_select;
    private String answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0601);
        setupViewCOmponent();
    }

    private void setupViewCOmponent() {
        txtComPlay = (TextView)findViewById(R.id.m0601_c001);
        btnScissors = (Button)findViewById(R.id.m0601_b001);
        btnStone = (Button)findViewById(R.id.m0601_b002);
        btnNet = (Button)findViewById(R.id.m0601_b003);
        txtSelect = (TextView)findViewById(R.id.m0601_s001);
        txtResult = (TextView)findViewById(R.id.m0601_f000);

        btnScissors.setOnClickListener(btn01On);
        btnStone.setOnClickListener(btn01On);
        btnNet.setOnClickListener(btn01On);
    }



    private View.OnClickListener btn01On = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1);       // 1 - scissors, 2 - stone, 3 - net.

            switch(v.getId()){   //這邊次之2
                case R.id.m0601_b001:  //剪刀
                    user_select = getString(R.string.m0601_ans1)+" "+getString(R.string.m0601_b001);
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setText(R.string.m0601_b001);
                            answer = getString(R.string.m0601_ans2)+getString(R.string.m0601_f003);
                            break;
                        case 2:
                            txtComPlay.setText(R.string.m0601_b002);
                            answer = getString(R.string.m0601_ans2)+getString(R.string.m0601_f002);
                            break;
                        case 3:
                            txtComPlay.setText(R.string.m0601_b003);
                            answer = getString(R.string.m0601_ans2)+getString(R.string.m0601_f001);
                            break;
                    }

                   // switch(iComPlay)
                    break;
                case R.id.m0601_b002:  //石頭
                    user_select = getString(R.string.m0601_ans1)+" "+getString(R.string.m0601_b002);
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setText(R.string.m0601_b001);
                            answer = getString(R.string.m0601_ans2)+getString(R.string.m0601_f001);
                            break;
                        case 2:
                            txtComPlay.setText(R.string.m0601_b002);
                            answer = getString(R.string.m0601_ans2)+getString(R.string.m0601_f003);
                            break;
                        case 3:
                            txtComPlay.setText(R.string.m0601_b003);
                            answer = getString(R.string.m0601_ans2)+getString(R.string.m0601_f002);
                            break;
                    }
                    break;
                case R.id.m0601_b003:  //布
                    user_select = getString(R.string.m0601_ans1)+" "+getString(R.string.m0601_b003);
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setText(R.string.m0601_b001);
                            answer = getString(R.string.m0601_ans2)+getString(R.string.m0601_f002);
                            break;
                        case 2:
                            txtComPlay.setText(R.string.m0601_b002);
                            answer = getString(R.string.m0601_ans2)+getString(R.string.m0601_f001);
                            break;
                        case 3:
                            txtComPlay.setText(R.string.m0601_b003);
                            answer = getString(R.string.m0601_ans2)+getString(R.string.m0601_f003);
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