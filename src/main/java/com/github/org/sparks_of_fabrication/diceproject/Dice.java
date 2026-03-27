/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.diceproject;

import com.github.org.sparks_of_fabrication.diceproject.utils.Pair;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author petko
 */
public class Dice implements Callable<Double[]> {
    // Inclusive bounds
    private Pair<Integer, Integer> ranges;
    private Random randomizerInstance;
    private int dThrows;
    
    
    public Dice(int lowerBound, int higherBound) {
        ranges = new Pair<>(lowerBound, higherBound);
        randomizerInstance = new Random();
    }

    
    public Double[] norm() {
    Double[] result = new Double[this.dThrows];
        for(int i = 0; i < dThrows; i++) {
            double side = this.randomizerInstance.nextInt(this.ranges.first(), this.ranges.second()+1);
            System.out.println(String.format("Inside dice row %d got %f", i, side));
            result[i] = side;
        }
        
        return result;
    }

    @Override
    public Double[] call() throws Exception {
        Double[] result = new Double[this.dThrows];
        
        System.out.println(String.format("Thread %s startesd", Thread.currentThread().getName()));
        
        for(int i = 0; i < dThrows; i++) {
                double side = ThreadLocalRandom.current().nextInt(this.ranges.first(), this.ranges.second()+1);
//                double side = this.randomizerInstance.nextInt(this.ranges.first(), this.ranges.second()+1);
                //System.out.println(String.format("Inside dice row %d got %f", i, side));//
                result[i] = side;
        }
        
        return result;
    }
    
    
    
    public Dice diceThrow(int times) {
        this.dThrows = times;
        
        return this;
    }
    
    public static Double[] diceThrowCongregation(Double[] dice1, Double[] dice2, int times) {
        Double[] result = new Double[times];
        
        for(int dThrow = 0; dThrow < times; dThrow++) {
            result[dThrow] = dice1[dThrow] + dice2[dThrow];
        }
        
        return result;
    }
}
