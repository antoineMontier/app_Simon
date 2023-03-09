package com.example.simon;

import java.util.Random;

public class Simon {
    // 1 = red
    // 2 = green
    // 3 = blue
    // 4 = yellow
    private int[] colors;
    private int size;

    private int stade;

    public Simon(int max_size){
        size = max_size;
        stade = 3;
        colors = new int[max_size];
    }

    public void generate_color_vector(int number){
        stade = 3;
        if(number > size)
            return;
        Random r = new Random();
        for(int i = 0 ; i < size ; i++)
                colors[i] = 0;
        for(int i = 0 ; i < number ; i++)
            colors[i] = 1 + r.nextInt(4);
    }

    public void add_c() {
        if (stade >= size - 1)
            return; // not enough room
        Random r = new Random();
        colors[stade + 1] = 1 + r.nextInt(4);
        stade++;
    }


    public int[] get_color_tab(){
        int res [] = new int[stade];
        for(int i = 0 ; i < stade ; i++)
            res[i] = colors[i];
        return res;
    }

    public int getStade(){
        return stade;
    }

    public int getSize(){
        return size;
    }

    public boolean check_color(int index, int color){
        if(index >= size - 1)
            return false;
        return color == colors[index];
    }

    public void reset_stade(){
        stade = 0;
    }


}
