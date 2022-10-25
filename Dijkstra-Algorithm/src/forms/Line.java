/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;
import java.awt.*;
import objects.Coordinates;

/**
 *
 * @author swords
 */
public class Line {
    private Coordinates coordinates;
    private Color color;
    private float lineWeight;
    private String label;
    private int weight;
    private boolean showLabel;

    public Line(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.lineWeight = 2f;
        this.color = Color.black;
        this.showLabel = true;
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

    public float getLineWeight() {
        return lineWeight;
    }

    public void setLineWeight(float lineWeight) {
        this.lineWeight = lineWeight;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isShowLabel() {
        return showLabel;
    }

    public void setShowLabel(boolean showLabel) {
        this.showLabel = showLabel;
    }
    
    public void drawLine(Graphics g){
        ((Graphics2D)g).setColor(getColor());
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(lineWeight);
        ((Graphics2D)g).setStroke(stroke);
        if(coordinates != null){
            int []aux = new int[0];
            for(int i = 0; i < coordinates.size(); i++){
                aux = coordinates.get(i);
                if(i == 0){
                    ((Graphics2D)g).drawLine(aux[0],aux[1],aux[0],aux[1]);
                }else{
                    ((Graphics2D)g).drawLine(coordinates.get(i - 1)[0],coordinates.get(i - 1)[1],aux[0],aux[1]);               
                }
            }

            if(showLabel){
                ((Graphics2D)g).setColor(Color.blue);
                Font fuente=new Font("Monospaced",Font.BOLD, 18);
                g.setFont(fuente);

                if(coordinates.size() == 2){
                    int xMinor = minor(coordinates.get(0)[0],coordinates.get(1)[0]);
                    int yMinor = minor(coordinates.get(0)[1],coordinates.get(1)[1]);

                    int xMajor = major(coordinates.get(0)[0],coordinates.get(1)[0]);
                    int yMajor = major(coordinates.get(0)[1],coordinates.get(1)[1]);                    
                    
                    int distanciaVertical = yMajor - yMinor;
                    int distanciaHorizontal = xMajor - xMinor;
                    ((Graphics2D)g).drawString(weight+"",(distanciaHorizontal/2) + xMinor,(distanciaVertical/2) + yMinor);
                }else{
                    int pos = coordinates.size() / 2;

                    ((Graphics2D)g).drawString(weight+"",coordinates.get(pos)[0]+3,coordinates.get(pos)[1]-8);

                    }
                }
            }
            
        
        stroke = new BasicStroke(1);
        ((Graphics2D)g).setStroke(stroke);
        
    }
    
    private int major(int n1,int n2){
        return (n1 > n2) ? n1 : n2;
    }
    private int minor(int n1,int n2){
        return (n1 < n2) ? n1 : n2;
    }
    
}
