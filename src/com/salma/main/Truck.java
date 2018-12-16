/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salma.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mel Salma
 */
public class Truck extends Vehicle{

     public Truck(int newx, int newy){
        super(newx, newy);
        width = 160;
        height = 40;
        speed = 8;
    }
    
    public void paintMe(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
    
}
