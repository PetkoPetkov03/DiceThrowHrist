/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.diceproject.graphics;

import com.github.org.sparks_of_fabrication.diceproject.graphics.Drawable;
import com.github.org.sparks_of_fabrication.diceproject.graphics.Vector2D;
import com.github.org.sparks_of_fabrication.diceproject.utils.Pair;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author petko
 */
public class DiagramBorder implements Drawable {
//    private final Vector2D originPoint;
//    private final Vector2D endingPoint;
    private Dimension size;
    private int offset;
    
    private int[] xvals;
    private int[] yvals;
    
    private int spacing;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
//
//    public DiagramBorder(Vector2D originPoint, Vector2D endingPoint, Dimension size) {
////        this.originPoint = originPoint;
////        this.endingPoint = endingPoint;
//        this.size = size;
//        
//        
//    }
    
    private void drawBorders(Graphics g) {
        g.drawLine((int)offset, size.height - offset, (int)(size.width - offset), size.height - offset);
        g.drawLine((int)offset, (int)offset, (int)offset, size.height - offset);
        
        System.out.println(String.format("REDRAW: %d %d %d", size.width, size.height, offset));
    }
    
    private static int[] generateRange(int min, int max, int spaceing) {
        int slices = (max - min) / spaceing;
        int[] arr = new int[slices+1];
        int step = 0;
        for(int i = min; i <= max; i+= spaceing) {
            arr[step] = i;
            step++;
        }
        
        return arr;
    }

    public DiagramBorder(Dimension d, Pair<Integer, Integer> xRange, Pair<Integer, Integer> yRange, double offset) {
        this.size = d;
        this.offset = (int)offset;
        System.out.println(String.format("Size: %d %d", size.width, size.height));
        this.minX = xRange.first();
        this.maxX = xRange.second();
        this.minY = yRange.first();
        this.maxX = yRange.second();
        this.xvals = generateRange(minX, maxX, 10);
    }
    
    public void recalc(Dimension d, Pair<Integer, Integer> xRange, Pair<Integer, Integer> yRange, double offset) {
        this.size = d;
        this.offset = (int)offset;
        this.minX = xRange.first();
        this.maxX = xRange.second();
        this.minY = yRange.first();
        this.maxX = yRange.second();
        this.xvals = generateRange(minX, maxX, 10);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        drawBorders(g);
    }
    
}
