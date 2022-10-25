/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import forms.Line;

/**
 *
 * @author swords
 */
public class Edge {
    
    private int idEdge;
    private String edgeName;
    private int weight;
    private Line breakLine;
    private boolean enabled;

    public Edge() {
        this.idEdge = -1;
        this.edgeName = "";
    }
    
    public Edge(int idEdge) {
        this.idEdge = idEdge;
        this.edgeName = "";
    }

    public Edge(int idEdge, String edgeName, int weight) {
        this.idEdge = idEdge;
        this.edgeName = edgeName;
        this.weight = weight;
        this.breakLine = null;
        this.enabled = true;
    }

    public int getIdEdge() {
        return idEdge;
    }

    public void setIdEdge(int idEdge) {
        this.idEdge = idEdge;
    }

    public String getEdgeName() {
        return edgeName;
    }

    public void setEdgeName(String edgeName) {
        this.edgeName = edgeName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public void resetEdge(){
        this.edgeName = "";
        this.enabled = true;
        this.idEdge = -1;
        this.weight = -1;
    }

    public Line getBreakLine() {
        return breakLine;
    }

    public void setBreakLine(Line breakLine) {
        this.breakLine = breakLine;
        if(breakLine != null){
            this.breakLine.setWeight(this.weight);
        }
    }

    @Override
    public String toString() {
        return "Edge{" + "idEdge=" + idEdge + ", edgeName=" + edgeName + ", weight=" + weight + ", breakLine=" + breakLine + ", enabled=" + enabled + '}';
    }
    
}
