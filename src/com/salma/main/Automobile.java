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
public class Automobile extends Vehicle{
    
    public Automobile(int newx, int newy){
        super(newx, newy);
        width = 120;
        height = 40;
        speed = 5;
    }
    
    public void paintMe(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
