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
public class Usuario extends Celda{

    String simboloUsuario="o";
    
    public Usuario(int x, int y) {
        super(x, y);
    }

    @Override
    public void pintar() {
        System.out.print(simboloUsuario);
    }
    
}
