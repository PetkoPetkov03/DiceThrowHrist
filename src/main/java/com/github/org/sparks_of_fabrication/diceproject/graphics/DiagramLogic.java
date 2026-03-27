/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.diceproject.graphics;

import com.github.org.sparks_of_fabrication.diceproject.graphics.Drawable;
import com.github.org.sparks_of_fabrication.diceproject.utils.Pair;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author petko
 */
public class DiagramLogic implements Drawable {
    private DiagramBorder border;

    public DiagramLogic(Dimension borderSize) {
        Pair<Integer, Integer> x = new Pair<>(10, 100);
        Pair<Integer, Integer> y = new Pair<>(10, 100);
        
        this.border = new DiagramBorder(borderSize, x, y, 20);
        System.out.println(String.format("%s Size: %d %d", this.getClass().getName(), borderSize.width, borderSize.height));
    }
    
    public void recalcRepaint(Dimension borderSize) {
        Pair<Integer, Integer> x = new Pair<>(10,100);
        Pair<Integer, Integer> y = new Pair<>(10, 100);
        
        this.border.recalc(borderSize, x, y, 20);
        
        System.out.println(String.format("%s Size: %d %d", this.getClass().getName(), borderSize.width, borderSize.height));
    }
    
    @Override
    public void draw(Graphics g) {
        border.draw(g);
    }
}
