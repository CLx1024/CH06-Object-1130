package tw.tcnrxx.m0603;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0603 extends AppCompatActivity {


    private TextView txtSelect;
    private TextView txtResult;


    private String user_select;
    private String answer;
    private ImageButton btnScissors;
    private ImageButton btnStone;
    private ImageButton btnNet;
    private ImageView txtComPlay;
    private MediaPlayer startmusic;
    private MediaPlayer mediaWin;
    private MediaPlayer mediaLose;
    private MediaPlayer mediaDraw;
    private MediaPlayer endmusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0603);
        setupViewCOmponent();
    }

    private void setupViewCOmponent() {
        btnScissors = (ImageButton)findViewById(R.id.m0603_b001); //***
        btnStone = (ImageButton)findViewById(R.id.m0603_b002); //***
        btnNet = (ImageButton)findViewById(R.id.m0603_b003);  //***
        txtSelect = (TextView)findViewById(R.id.m0603_s001);
        txtResult = (TextView)findViewById(R.id.m0603_f000);
        txtComPlay = (ImageView)findViewById(R.id.m0603_c001); //******我上支城市沒寫到這個變數？

        // --開啟片頭音樂-----
        startmusic = MediaPlayer.create(getApplication(),R.raw.guess);  // 自定義開始的音樂  create建議一個媒體檔 這個create要放在哪個class 來源
        startmusic.start();

        // --Close音樂-----
        endmusic = MediaPlayer.create(getApplication(), R.raw.good9);

        mediaWin = MediaPlayer.create(getApplication(), R.raw.vctory);  //宣告
        mediaDraw = MediaPlayer.create(getApplication(), R.raw.haha);
        mediaLose = MediaPlayer.create(getApplication(), R.raw.lose);

        btnScissors.setOnClickListener(btn01On);
        btnStone.setOnClickListener(btn01On);
        btnNet.setOnClickListener(btn01On);
    }



    private View.OnClickListener btn01On = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1);       // 1 - scissors, 2 - stone, 3 - net.

            switch(v.getId()){   //這邊次之2
                case R.id.m0603_b001:  //玩家選剪刀
                    user_select = getString(R.string.m0603_ans1)+" "+getString(R.string.m0603_b001);
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                        //    answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f003);  // 1123可寫到下面
                        //    txtResult.setTextColor(Color.YELLOW); //平手黃色  // 1123可寫到下面                            break;
                            music(2);
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                        //    answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f002);
                        //    txtResult.setTextColor(Color.RED); //輸用紅色
                            music(3);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                        //    answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f001);
                        //    txtResult.setTextColor(Color.GREEN); //贏用綠色
                            music(1);
                            break;
                    }

                   // switch(iComPlay)
                    break;
                case R.id.m0603_b002:  //石頭
                    user_select = getString(R.string.m0603_ans1)+" "+getString(R.string.m0603_b002);
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                        //    answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f001);
                        //    txtResult.setTextColor(Color.GREEN); //贏用綠色
                            music(1);
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                        //    answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f003);
                        //    txtResult.setTextColor(Color.YELLOW); //平手黃色
                            music(2);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                        //    answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f002);
                        //    txtResult.setTextColor(Color.RED); //輸用紅色
                            music(3);
                            break;
                    }
                    break;
                case R.id.m0603_b003:  //布
                    user_select = getString(R.string.m0603_ans1)+" "+getString(R.string.m0603_b003);
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                        //    answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f002);
                        //    txtResult.setTextColor(Color.RED); //輸用紅色
                            music(3);
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                        //    answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f001);
                        //    txtResult.setTextColor(Color.GREEN); //贏用綠色
                            music(1);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                        //    answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f003);  // 1123可寫到下面
                        //    txtResult.setTextColor(Color.YELLOW); //平手黃色  // 1123可寫到下面
                            music(2);
                            break;
                    }
                    break;

            }
            txtSelect.setText(user_select);  //這邊先寫1
            txtResult.setText(answer);
        }
        };

    private void music(int i) {
        if(startmusic.isPlaying()) //你直接stop會閃退所以先判斷
            startmusic.stop();
        if(mediaWin.isPlaying())
            mediaWin.pause();
        if(mediaDraw.isPlaying())
            mediaDraw.pause();
        if(mediaLose.isPlaying())
            mediaLose.pause();
        //i = 1 win, 2 draw, 3 lose
        switch(i){
            case(1):
                answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f001);
                txtResult.setTextColor(Color.GREEN); //贏用綠色
                mediaWin.start();
                break;
            case(2):
                answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f003);
                txtResult.setTextColor(Color.YELLOW); //平手黃色
                mediaDraw.start();
                break;
            case(3):
                answer = getString(R.string.m0603_ans2)+getString(R.string.m0603_f002);
                txtResult.setTextColor(Color.RED); //輸用紅色
                mediaLose.start();
                break;
            case(4):
                endmusic.start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if(startmusic.isPlaying())
//            startmusic.stop();
        music(4);
    }
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