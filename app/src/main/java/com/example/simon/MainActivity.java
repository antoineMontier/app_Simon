package com.example.simon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Simon s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = new Simon(32);
        s.generate_color_vector(3);
        try {
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        show_new_colors();
    }

    public void red_click(View v){
        if(!s.check_next(1))
            display_end(v);
        System.out.println("red_clicked");
    }

    public void green_click(View v){
        if(!s.check_next(2))
            display_end(v);
        System.out.println("green_clicked");
    }

    public void blue_click(View v){
        if(!s.check_next(3))
            display_end(v);
        System.out.println("blue_clicked");
    }

    public void yellow_click(View v){
        if(!s.check_next(4))
            display_end(v);
        System.out.println("yellow_clicked");
    }

    public void show_new_colors(){
        s.reset_stade();
        Button r = (Button) findViewById(R.id.b_Red);
        Button g = (Button) findViewById(R.id.b_Green);
        Button b = (Button) findViewById(R.id.b_Blue);
        Button y = (Button) findViewById(R.id.b_Yellow);
        int a;
        while((a=s.nextC()) != 0){
            switch(a){
                case 1:
                    r.animate();
                    break;
                case 2:
                    g.animate();
                    break;
                case 3:
                    b.animate();
                    break;
                case 4:
                    y.animate();
                    break;
            }
            // delay between each click
            try {
                Thread.sleep(250);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public void display_end(View v){
        TextView t = (TextView) findViewById(R.id.score_text);
        t.setText("score " + s.getStade());
    }


}