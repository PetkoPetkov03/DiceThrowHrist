/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.diceproject.graphics;

import java.awt.Dimension;

/**
 *
 * @author petko
 */

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public static Vector2D createVectorOffset(Dimension dimension, double offset) {
        Vector2D vec = new Vector2D(dimension.getWidth() - offset, dimension.getHeight() - offset);
        
        return vec;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    
}
