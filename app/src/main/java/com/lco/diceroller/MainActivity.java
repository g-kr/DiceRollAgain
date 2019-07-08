package com.lco.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView dice1,dice2;
    Button btn;
    SoundPool soundPool;

    private Random random=new Random();
    int sound1;
   // private SoundPool soundpool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes =new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool=new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(audioAttributes).build();
//

       // }
        sound1=soundPool.load(this,R.raw.roll,1);



        dice1=findViewById(R.id.img1);
        dice2=findViewById(R.id.img2);
        btn=findViewById(R.id.roll);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animate();
                roll1();
                roll2();
                soundPool.play(sound1,1,1,0,0,1);

            }
        });

    }
    public void animate(){
        //set two pivot points
        int pivotY=dice1.getHeight()/2;
        int pivotX=dice1.getWidth()/2;
        int first;
        int last;
        Random r;
        r=new Random();
        int a=r.nextInt(3600);
        last=0;
        first=a;
        Animation rotate=new RotateAnimation(first,last,pivotX,pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        dice1.startAnimation(rotate);
        dice2.startAnimation(rotate);

    }
    public void roll1(){
        int number =random.nextInt(6)+1;
        if(number==1){
            dice2.setImageResource(R.drawable.dice1);

        }
        else if(number==2){
            dice2.setImageResource(R.drawable.dice2);
        }
        else if(number==3){
            dice2.setImageResource(R.drawable.dice3);
        }
        else if(number==4){
            dice2.setImageResource(R.drawable.dice4);
        }
        else if(number==5){
            dice2.setImageResource(R.drawable.dice5);
        }
        else if(number==6){
            dice2.setImageResource(R.drawable.dice6);
        }


    }
    public void roll2(){
        int number =random.nextInt(6)+1;
        if(number==1){
            dice1.setImageResource(R.drawable.dice1);

        }
        else if(number==2){
            dice1.setImageResource(R.drawable.dice2);
        }
        else if(number==3){
            dice1.setImageResource(R.drawable.dice3);
        }
        else if(number==4){
            dice1.setImageResource(R.drawable.dice4);
        }
        else if(number==5){
            dice1.setImageResource(R.drawable.dice5);
        }
        else if(number==6){
            dice1.setImageResource(R.drawable.dice6);
        }


    }

}
