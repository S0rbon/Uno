/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uno;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sebie
 */
public class GUI extends JFrame implements ActionListener{
    JFrame fenster = new JFrame();
    JPanel PlayerCards = new JPanel();
    JPanel panel = new JPanel();
    JLabel derText;
    List<JButton> cards = new ArrayList();
    Leitsystem Leitsystem;
    
    public GUI(Leitsystem system){
        this.Leitsystem = system;

        
        
    }
    
    public ImageIcon setIcon(String imgn){
        ImageIcon icon = new ImageIcon(imgn);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance( 130, 170,  java.awt.Image.SCALE_SMOOTH ) ;  
        return new ImageIcon( newimg );
    }
    
    public void addCard(List<Karten> list){
        cards = new ArrayList();
        for(int i=0;i<list.size();i++){
            cards.add(new JButton(cards.size()+"",setIcon("design/"+list.get(i).getFarbe()+"_"+list.get(i).getWert()+".png")));
        }
        reload();
        
    }
    public void reload(){
        fenster.dispose();
        fenster = new JFrame();
        fenster.setVisible(true);
        fenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fenster.setLayout(new BorderLayout());
        
        PlayerCards = new JPanel();
        PlayerCards.setBackground(Color.red);
        for(int i=0;i<cards.size();i++){
            cards.get(i).setPreferredSize(new Dimension(126,170));
            PlayerCards.add(cards.get(i));
            cards.get(i).addActionListener(Leitsystem);
        }
        fenster.add(PlayerCards, BorderLayout.SOUTH);
        
        
        panel = new JPanel();
        JButton button = new JButton(Leitsystem.pile.size()+"",setIcon("design/"+Leitsystem.pile.getLast().getFarbe()+"_"+Leitsystem.pile.getLast().getWert()+".png"));
        button.setPreferredSize(new Dimension(130,170));
        panel.add(button);
        fenster.add(panel, BorderLayout.CENTER);
        
        
        panel = new JPanel();
        panel.setBackground(Color.red);
        JButton button2 = new JButton("ziehen",setIcon("design/Uno.png"));
        button2.addActionListener(Leitsystem);
        button2.setPreferredSize(new Dimension(130,170));
        panel.add(button2);
        fenster.add(panel, BorderLayout.WEST);
        
        
        fenster.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

