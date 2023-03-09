package com.example.simon;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Simon s;
    int level;

    boolean onGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = new Simon(32);
        s.generate_color_vector(3);
        // show_new_colors();
        onGame = false;
        level = 1;
    }

    public void start_is_clicked(View v){
        if(onGame)
           return;
        show_new_colors();
    }

    public void red_click(View v){
        if(s.check_color(level, 1))
            display_end(v);
        level++;
        if(level >= s.getStade()) {
            s.add_c();
            show_new_colors();
            level = 1;
        }
        System.out.println("red_clicked");
    }

    public void green_click(View v){
        if(s.check_color(level, 2))
            display_end(v);
        level++;
        if(level >= s.getStade()) {
            s.add_c();
            show_new_colors();
            level = 1;
        }
        System.out.println("green_clicked");
    }

    public void blue_click(View v){
        if(s.check_color(level, 3))
            display_end(v);
        level++;
        if(level >= s.getStade()) {
            s.add_c();
            show_new_colors();
            level = 1;
        }
        System.out.println("blue_clicked");
    }

    public void yellow_click(View v){
        if(s.check_color(level, 4))
            display_end(v);
        level++;
        if(level >= s.getStade()) {
            s.add_c();
            show_new_colors();
            level = 1;
        }
        System.out.println("yellow_clicked");
    }

    public void show_new_colors(){
        Button r = (Button) findViewById(R.id.b_Red);
        Button g = (Button) findViewById(R.id.b_Green);
        Button b = (Button) findViewById(R.id.b_Blue);
        Button y = (Button) findViewById(R.id.b_Yellow);

        // Define the new colors
        int r_clicked = getResources().getColor(R.color.red_click);
        int r_unclicked = getResources().getColor(R.color.red_unclick);

        int g_clicked = getResources().getColor(R.color.green_click);
        int g_unclicked = getResources().getColor(R.color.green_unclick);

        int b_clicked = getResources().getColor(R.color.blue_click);
        int b_unclicked = getResources().getColor(R.color.blue_unclick);

        int y_clicked = getResources().getColor(R.color.yellow_click);
        int y_unclicked = getResources().getColor(R.color.yellow_unclick);

        int[] color_sucessions = s.get_color_tab();
        for(int i = 0 ; i < color_sucessions.length ; i ++){ // for each slot of the tab, change the color of the corresponding buton during .25s then change it back to the original color
            System.out.println(color_sucessions[i]);
            switch(i) {
                case 1:
                    r.setBackgroundColor(r_clicked);
                    try {
                        Thread.sleep(250);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    r.setBackgroundColor(r_unclicked);
                    break;
                case 2:
                    g.setBackgroundColor(g_clicked);
                    try {
                        Thread.sleep(250);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    g.setBackgroundColor(g_unclicked);
                    break;
                case 3:
                    b.setBackgroundColor(b_clicked);
                    try {
                        Thread.sleep(250);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    b.setBackgroundColor(b_unclicked);
                    break;
                case 4:
                    y.setBackgroundColor(y_clicked);
                    try {
                        Thread.sleep(250);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    y.setBackgroundColor(y_unclicked);
                    break;
            }

        }
    }

    public void display_end(View v){
        TextView t = (TextView) findViewById(R.id.score_text);
        t.setText("score " + s.getStade());
    }


}