/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salma.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Mel Salma
 */
public class MainClass implements ActionListener, Runnable{
    JFrame frame = new JFrame("ITraffic : An Automated Traffic Simulator");
    Road road = new Road();
    JButton start = new JButton("Start");
    JButton stop = new JButton("Stop");
    JLabel throughput = new JLabel("Throughpput:");
    Container south = new Container();
    
    JButton auto = new JButton("Add Automobile");
    JButton truck = new JButton("Add Truck");
    JButton lambo = new JButton("Add Lamborghini");
    Container west = new Container();
    
    boolean running = false;
    int carCount = 0;
    long startTime = 0;
    
    public MainClass(){
        frame.setSize(1000, 550);
        frame.setLayout(new BorderLayout());
        frame.add(road, BorderLayout.CENTER);
        
        south.setLayout(new GridLayout(1, 3));
        south.add(start);
        start.addActionListener(this);
        south.add(stop);
        stop.addActionListener(this);
        south.add(throughput);
        frame.add(south, BorderLayout.SOUTH);
        
        west.setLayout(new GridLayout(3, 1));
        west.add(auto);
        auto.addActionListener(this);
        west.add(truck);
        truck.addActionListener(this);
        west.add(lambo);
        lambo.addActionListener(this);
        frame.add(west, BorderLayout.WEST);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.repaint();
    }
    
    public static void main(String[] args) {
        new MainClass();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(start)){
            if (running == false){
                running = true;
                road.resetCarCount();
                startTime = System.currentTimeMillis();
                Thread t = new Thread(this);
                t.start();
            }
        }
        if (event.getSource().equals(stop)){
            running = false;
        }
        if (event.getSource().equals(auto)){
             Automobile auto = new Automobile(0 ,30);
             road.addCar(auto);
            
            for (int x = 0; x < road.ROAD_WIDTH; x = x + 20) {
                for (int y = 40; y < 480; y = y + 120) {
                    if (road.collision(x, y, auto) == true){
                        auto.setX(x);
                        auto.setY(y);
                        if (road.collision(x, y, auto) == false){
                            frame.repaint();
                            return;
                        }
                    }
                }
            }
        }
          if (event.getSource().equals(truck)){
             Truck truck = new Truck(0, 30);
             road.addCar(truck);
            
            for (int x = 0; x < road.ROAD_WIDTH; x = x + 20) {
                for (int y = 40; y < 480; y = y + 120) {
                    if (road.collision(x, y, truck) == true){
                        truck.setX(x);
                        truck.setY(y);
                        if (road.collision(x, y, truck) == false){
                            frame.repaint();
                            return;
                        }
                    }
                }
            }
        }
          if (event.getSource().equals(lambo)){
             Lamborghini lambo = new Lamborghini(0 ,30);
             road.addCar(lambo);
            
            for (int x = 0; x < road.ROAD_WIDTH; x = x + 20) {
                for (int y = 40; y < 480; y = y + 120) {
                    if (road.collision(x, y, lambo) == true){
                        lambo.setX(x);
                        lambo.setY(y);
                        if (road.collision(x, y, lambo) == false){
                            frame.repaint();
                            return;
                        }
                    }
                }
            }
        }  
    }

    @Override
    public void run() {
        while(running == true){
            road.step();
            carCount = road.getCarCount();
            double throughputCalc = carCount / (double)(System.currentTimeMillis() - startTime);
            throughput.setText("Throughput: " + throughputCalc); 
            frame.repaint();
            try {
                Thread.sleep(100);  
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
}
