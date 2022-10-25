/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import objects.Coordinates;
import java.awt.*;

/**
 *
 * @author swords
 */
public class Circle {
    
    private Coordinates coordinates;
    private Color color;
    private int diameter;
    private String label;
    private Font font;
    private int left;
    private int border;

    public Circle(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.color = Color.CYAN;
        this.diameter = 30;
        this.label = "";
        this.font = null;
        this.left = 0;
        this.border = 2;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }
    
    public int getX(){
        if(!this.coordinates.isEmpty()){
            return this.coordinates.get(0)[0];
        }else{
            return -1;
        }
    }
    
    public int getY(){
        if(!this.coordinates.isEmpty()){
            return this.coordinates.get(0)[1];
        }else{
            return -1;
        }
    }
    
    public void drawCircle(Graphics g){
        if(!coordinates.isEmpty()){
            ((Graphics2D)g).setColor(this.color); 
            ((Graphics2D)g).setStroke(new BasicStroke(getBorder()));

            ((Graphics2D)g).fillOval(this.coordinates.get(0)[0],this.coordinates.get(0)[1],this.diameter,this.diameter);
            ((Graphics2D)g).setColor(Color.black);
            ((Graphics2D)g).drawOval(this.coordinates.get(0)[0],this.coordinates.get(0)[1],this.diameter,this.diameter);
            
            if(!this.label.equals("")){
                if(this.font != null){
                    g.setFont(this.font);
                }else{
                    Font fuente=new Font("Monospaced",Font.BOLD, 13);
                    g.setFont(fuente);
                }
                
                ((Graphics2D)g).drawString(this.label,this.coordinates.get(0)[0] - (this.left),this.coordinates.get(0)[1]);
                ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
            }   
        }else{
            System.out.println("No se encontraron coordenadas que graficar");
        }
    }
    
    
    
}
