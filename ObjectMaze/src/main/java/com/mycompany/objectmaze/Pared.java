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
public class Pared extends Celda{

    private String muro;
    public Pared(int x, int y,String muro) {
        super(x, y);
        this.muro=muro;
    }

    @Override
    public void pintar() {
        System.out.print(muro);
    }
    
    public String toString(){
        return "Pared("+muro+")";
    }
    
}
