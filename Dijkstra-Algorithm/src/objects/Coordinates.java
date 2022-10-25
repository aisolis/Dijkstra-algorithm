/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import java.util.ArrayList;

/**
 *
 * @author swords
 */
public class Coordinates extends ArrayList <int[]>{
    
    private int xMax;
    private int yMax;

    public Coordinates(){
        this(0, 0);
    }   
    
    public Coordinates(int xMax, int yMax) {
        super();
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public Coordinates(int xMax, int yMax, int x, int y) {
        super();
        this.xMax = xMax;
        this.yMax = yMax;
        this.addCoordinate(x, y);
    }  

    public int getxMax() {
        return xMax;
    }

    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public void setyMax(int yMax) {
        this.yMax = yMax;
    }


    public void addCoordinate(int x, int y){
        if(x >= 0 && x <= this.xMax && y >= 0 && y <= this.yMax){
            int[] coordinatesXY = {x,y};
            this.add(coordinatesXY);
        }
    }
    
}
