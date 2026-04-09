/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.diceproject.graphics;

import com.github.org.sparks_of_fabrication.diceproject.graphics.Drawable;
import com.github.org.sparks_of_fabrication.diceproject.utils.Pair;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

/**
 *
 * @author petko
 */
public class DiagramLogic implements Drawable {
    private DiagramBorder border;
    
    private int[] xvals;
    private int[] yvals;

    public DiagramLogic(Dimension borderSize, int[] xvals, int[] yvals) {
        this.xvals = xvals;
        this.yvals = yvals;
        Arrays.sort(this.xvals);
        Arrays.sort(this.yvals);
        Pair<Integer, Integer> x = new Pair<>(this.xvals[0], this.xvals[xvals.length-1]);
        Pair<Integer, Integer> y = new Pair<>(this.yvals[0], this.yvals[yvals.length-1]);
        
        this.border = new DiagramBorder(borderSize, this.xvals, this.yvals, x, y, 20);
        System.out.println(String.format("%s Size: %d %d", this.getClass().getName(), borderSize.width, borderSize.height));
    }
    
    public void recalcRepaint(Dimension borderSize) {
//        Pair<Integer, Integer> x = new Pair<>(10,100);
//        Pair<Integer, Integer> y = new Pair<>(10, 100);


        Pair<Integer, Integer> x = new Pair<>(xvals[0], xvals[xvals.length-1]);
        Pair<Integer, Integer> y = new Pair<>(yvals[0], yvals[yvals.length-1]);
        
        this.border.recalc(borderSize, xvals, yvals, x, y, 20);
        
        System.out.println(String.format("%s Size: %d %d", this.getClass().getName(), borderSize.width, borderSize.height));
    }
    
    @Override
    public void draw(Graphics g) {
        border.draw(g);
    }
}
