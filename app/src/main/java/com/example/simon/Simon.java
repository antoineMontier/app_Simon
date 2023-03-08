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
        stade = 0;
        colors = new int[max_size];
    }

    public void generate_color_vector(int number){
        stade = 0;
        if(number > size)
            return;
        Random r = new Random();
        for(int i = 0 ; i < size ; i++)
                colors[i] = 0;
        for(int i = 0 ; i < number ; i++)
            colors[i] = 1 + r.nextInt(5);
    }

    public int nextC(){
        if(stade >= size)
            return 0;
        stade++;
        return colors[stade-1];
    }

    public int getStade(){
        return stade;
    }

    public int getSize(){
        return size;
    }

    public boolean check_next(int color){
        if(stade >= size - 1)
            return false;
        return color == colors[stade + 1];
    }

    public void reset_stade(){
        stade = 0;
    }


}
