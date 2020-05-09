/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uno;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebie
 */
public class Spieler {
    private List<Karten> cards = new ArrayList();
    
    public void addKarte(Karten card){
        System.out.println(card.getFarbe());
        this.cards.add(card);
    }
    public void removeKarte(Karten card){
        cards.remove(card);
    }
    public List<Karten> getAlleKarten(){
        return cards;
    }
    public Karten getKarte(int index){
        return cards.get(index);
    }
    
}   
