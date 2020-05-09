/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uno;
// protected Player list<Player> Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import javax.swing.JButton;


public class Leitsystem implements ActionListener{
protected ArrayDeque<Karten> cards = new ArrayDeque<Karten>();    
protected ArrayDeque<Karten> pile = new ArrayDeque();    
private Boolean gameStarted;
protected String CurrentType;
protected String CurrentColor;
private GUI gui= new GUI(this);
private Spieler spieler1 = new Spieler();

public Leitsystem(){
    // Karten erstellung
    String[] werte = {"1","2","3","4","5","6","7","8","9","skip","reverse","Draw"};
    String[] farbe = {"Red","Blue","Green","Yellow"};
    for(int i = 0;i<12;i++){
        for(int j=0;j<4;j++){
            cards.add(new Karten(farbe[j],werte[i]));
            cards.add(new Karten(farbe[j],werte[i]));
        }
    }
    for(int i=0;i<4;i++){
        cards.add(new Karten(farbe[i],"0"));
        cards.add(new Karten("wild","+4"));
        cards.add(new Karten("wild","farbe"));
    }
    cards = MixDeck(cards);
    pile.add(cards.removeLast());
    // Spieler
    
    
    for(int i=0;i<7;i++){
        spieler1.addKarte(cards.removeFirst());
    }
    reload(spieler1);
}
@Override
public void actionPerformed(ActionEvent a) {
        JButton button = (JButton) a.getSource();
        if(button.getText()=="ziehen"){
            drawCard(spieler1);
        }else{
        ablegen(spieler1,spieler1.getKarte(Integer.parseInt(button.getText())));
        System.out.println("s "+button.getText());
        System.out.println(pile.getFirst().getFarbe()+pile.getFirst().getWert());
    }}
public void drawCard(Spieler spieler){
    spieler.addKarte(cards.remove());
    reload(spieler);
}
public ArrayDeque<Karten> MixDeck(ArrayDeque<Karten> cards){
    List<Karten> list = new ArrayList<Karten>(cards); 
    Collections.shuffle(list);
    cards = new ArrayDeque<Karten>(list);
    System.out.println(cards.size());
    System.out.println(cards.peek().getFarbe());
    return cards;
}
public void ablegen(Spieler spieler,Karten card){
    System.out.println("Geclickt: "+card.getFarbe()+card.getWert());
    System.out.println("stapel: "+pile.getLast().getFarbe()+pile.getLast().getWert());
    if (pile.getLast().getWert()==card.getWert()||pile.getLast().getFarbe()==card.getFarbe()){
        spieler.removeKarte(card);
        pile.add(card);
        
        reload(spieler);
    }
}
public void CheckCard(){
    
}
public void changeColor(){
    
}
public void reload(Spieler spieler){
    List<Karten> list = new ArrayList();
    list = spieler.getAlleKarten();
    gui.addCard(list);

}
}

