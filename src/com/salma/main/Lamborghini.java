/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salma.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Mel Salma
 */
public class Lamborghini extends Vehicle{
    Image car;
    
     public Lamborghini(int newx, int newy){
        super(newx, newy);
        width = 80;
        height = 30;
        speed = 15;
//        try { 
//            car = ImageIO.read(new File("car1.png"));
//        } catch(Exception e){
//            e.printStackTrace();
//        }
    }
    
    public void paintMe(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
//        g.drawImage(car, x, y, null);
    }
}
