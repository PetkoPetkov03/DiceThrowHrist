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
import java.awt.Graphics2D;

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
    
    private int xDSpacing = 0;
    private int yDSpacing = 0;
//
//    public DiagramBorder(Vector2D originPoint, Vector2D endingPoint, Dimension size) {
////        this.originPoint = originPoint;
////        this.endingPoint = endingPoint;
//        this.size = size;
//        
//        
//    }
    
    private void drawBorders(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.drawLine((int)offset, size.height - offset, (int)(size.width - offset), size.height - offset);
        g2.drawLine((int)offset, (int)offset, (int)offset, size.height - offset);
        
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

    public DiagramBorder(Dimension d, int[] xvals, int[] yvals, Pair<Integer, Integer> xRange, Pair<Integer, Integer> yRange, double offset) {
        this.size = d;
        this.offset = (int)offset;
        System.out.println(String.format("Size: %d %d", size.width, size.height));
        this.minX = xRange.first();
        this.maxX = xRange.second();
        this.minY = yRange.first();
        this.maxY = yRange.second();
        
        
        xDSpacing = Math.floorDiv(size.width, xvals.length);
        yDSpacing = Math.floorDiv(size.height, yvals.length);
    }
    
    public void recalc(Dimension d, int[] xvals, int[] yvals, Pair<Integer, Integer> xRange, Pair<Integer, Integer> yRange, double offset) {
        this.size = d;
        this.offset = (int)offset;
        this.minX = xRange.first();
        this.maxX = xRange.second();
        this.minY = yRange.first();
        this.maxY = yRange.second();
        
        xDSpacing = Math.floorDiv(size.width, xvals.length);
        yDSpacing = Math.floorDiv(size.height, yvals.length);
    }
    
    private void drawMarks(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        
        if((xDSpacing * xvals.length) != size.width) {
            int correction = size.width - (xDSpacing*xvals.length);
            
            System.out.println(String.format("Correction x: %d", correction));
            
            xDSpacing = xDSpacing + (int)Math.floor(((double)correction/xvals.length));
            
            System.out.println("BIG CALL");
        }
        
        if((yDSpacing * yvals.length) != size.height) {
            int correction = size.height - (yDSpacing*yvals.length);
            
            yDSpacing = yDSpacing + (int)Math.floor((correction/yvals.length));
            
            System.out.println("BIG CALL2");
        }
        
        System.out.println("LENGTH " + xvals.length);
        for(int i = 0 ; i < xvals.length; i++) {
            System.out.println(String.format("x %d position %d", i , offset+(i*spacing)));
            g2.drawLine(offset+((i+1)*xDSpacing), (this.size.height - offset) - 10, offset+((i+1) * xDSpacing), this.size.height - offset);
        }
        
        System.out.println("Y LENGTH " + yvals.length);
        for(int i = 0; i < yvals.length; i++) {
            System.out.println(String.format("y %d position %d", i , offset+(i*spacing)));
            g2.drawLine(offset, (this.size.height - offset) - ((i+1)*yDSpacing), offset+10, (this.size.height - offset) - ((i+1)*yDSpacing));
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        drawBorders(g);
        drawMarks(g);
    }
    
}
