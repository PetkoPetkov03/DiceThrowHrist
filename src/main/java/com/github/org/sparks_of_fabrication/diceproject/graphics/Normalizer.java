/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.org.sparks_of_fabrication.diceproject.graphics;

/**
 *
 * @author petko
 */
public class Normalizer {
    private boolean normalizationNeeded;
    private Double[] preNormalization;
    private Double[] postNormalization;

    public Normalizer(Double[] preNormalization) {
        this.preNormalization = preNormalization;
        this.normalizationNeeded = true;
    }

    public Normalizer() {
    }
    
    public void inherit(Double[] d) {
        this.preNormalization = d;
        normalizationNeeded = true;
    }
    
    public Double[] normalize() throws RuntimeException {
        if(preNormalization == null) {
            throw new RuntimeException("Normalizer isn't constructed");
        }
        
        if(postNormalization != null) {
            return postNormalization;
        }
        
        normalizationNeeded = false;
        return postNormalization;
    }
}
