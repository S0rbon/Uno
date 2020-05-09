/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uno;

/**
 *
 * @author sebie
 */
public class Karten {
    private String Farbe;
    private String Wert;
    
    public Karten(String farbe,String value){
        this.Farbe = farbe;
        this.Wert = value;
    }
    public String getFarbe(){
        return this.Farbe;
    }
    public String getWert(){
        return this.Wert;
    }
    
    
}
