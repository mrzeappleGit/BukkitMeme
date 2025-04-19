package me.matthewstevens.meme.helper;

import java.util.Random;

public class randNumGen {
    public double numGen(double min,double max){
        double randNum;
        Random random = new Random();
        randNum = min + (max - min) * random.nextDouble();
        return randNum;
    }
}
