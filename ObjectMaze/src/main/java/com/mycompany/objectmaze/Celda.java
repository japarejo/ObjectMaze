/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.objectmaze;

/**
 *
 * @author japar
 */
public abstract class Celda implements Pintable {
    private int x,y;

    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
}
