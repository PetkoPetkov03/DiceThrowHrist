/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.github.org.sparks_of_fabrication.diceproject;

import com.github.org.sparks_of_fabrication.diceproject.wins.MainFrame;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author petko
 */
public class DiceProject {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        
        frame.setVisible(true);
    }
}
