/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.objectmaze;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author japar
 */
public class Laberinto implements Pintable {
    public static final Map<String, Double> CELDAS_POR_DEFECTO=new HashMap<>();
    static{
        CELDAS_POR_DEFECTO.put("/",0.5);
        CELDAS_POR_DEFECTO.put("\\", 0.5);
    }
    public static final String paredHorizonal="_";
    public static final String paredVertical="|";
        
    private Celda[][] celdas;
    private Usuario usuario;
    private Tesoro tesoro;
    
    public Laberinto(int filas, int columnas){
        this(filas,columnas,CELDAS_POR_DEFECTO);
    }
    
    public Laberinto(int filas, int columnas, Map<String,Double> probabilidad){
        celdas=new Celda[filas+2][columnas+2];
        generarCeldas(probabilidad);
        generarUsuario();
        generarTesoro();
    }

    private void generarCeldas(Map<String,Double> probabilidad) {
        for(int i=0;i<celdas.length;i++){
            celdas[0][i]=new Pared(0, i, paredHorizonal);
            celdas[celdas[i].length-1][i]=new Pared(0, i, paredHorizonal);
        }
        for(int i=0;i<celdas[0].length;i++){
            celdas[i][0]=new Pared(0, i, paredVertical);
            celdas[i][celdas[i].length-1]=new Pared(0, i, paredVertical);
        }
        for(int i=1;i<celdas.length-1;i++){
            for(int j=1;j<celdas[i].length-1;j++){
                celdas[i][j]=generarInterior(i,j,probabilidad);
            }
        }
    }

    private void generarUsuario() {
        int y=1+(int)(Math.random()*(celdas[0].length-1));
        int x=Math.random()>0.5?0:(celdas.length-1);
        usuario=new Usuario(x, y);
        celdas[x][y]=usuario;
    }
    

    private void generarTesoro() {
        int x = 0;
        int y = 0;
        
        do {
            x=1+(int)(Math.random()*(celdas[0].length-1));
        }
        while(x==0 || x==celdas[0].length-1);
        
        do {
            y=1+(int)(Math.random()*(celdas.length-1));
        }
        while(y==0 || y==celdas.length-1);
        
        tesoro=new Tesoro(x, y);
        celdas[x][y]=tesoro;
    }

    private Celda generarInterior(int x, int y, Map<String, Double> probabilidad) {
        String tipo=escogerPared(probabilidad);
        return new Pared(x,y,tipo);
    }

    private String escogerPared(Map<String, Double> probabilidad) {
        double total=probabilidad.values().stream().collect(Collectors.summingDouble(Double::doubleValue));
        double random=Math.random()*total;
        double conteo=0;
        String result=null;       
        for(String key:probabilidad.keySet()){
            conteo+=probabilidad.get(key);
            result=key;
            if(conteo>=random)                
                break;           
        }
        return result;
    }
    
    public String toString(){
        return "Laberinto de "+celdas.length+" por "+celdas[0].length;
                
    }
    
    public void pintar()
    {
        for(int i=0;i<celdas.length;i++){
            for(int j=0;j<celdas[i].length;j++)
            {
                celdas[i][j].pintar();
            }
            System.out.println();
        }
    }
}
