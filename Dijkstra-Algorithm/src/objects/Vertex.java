/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import forms.Circle;
import java.util.ArrayList;

/**
 *
 * @author swords
 */
public class Vertex {
    
    private Object data;
    private ArrayList<VertexLinks> adjacentEnabledVertexList;
    private boolean vertexTraversed = false;
    private Circle circle;
    private int left;
    
    private int pathDistance;
    private Vertex previousVertex;
    private boolean mark;    

    public Vertex() {
        this.data = new Object();
        this.circle = null;
        this.left = 0;
        this.initialize();
    }
    
    private void initialize(){
        this.pathDistance = -1;
        this.previousVertex = null;
        this.mark = false;
    }
    
    public Vertex(Object data, Coordinates coordinates){
        this.data = data;
        this.adjacentEnabledVertexList = new ArrayList<>();
        this.circle = new Circle(coordinates);
        this.circle.setLeft(this.left);
        this.initialize();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ArrayList<VertexLinks> getAdjacentEnabledVertexList() {
        
        ArrayList<VertexLinks> listAristaAux = null;
        if(!this.adjacentEnabledVertexList.isEmpty()){
            listAristaAux = new ArrayList<VertexLinks>();
            for(VertexLinks vl : this.adjacentEnabledVertexList){
                if(vl.getEdge().isEnabled()){
                    listAristaAux.add(vl);
                }
            }
        }        
        return listAristaAux;
    }

    public void setAdjacentEnabledVertexList(ArrayList<VertexLinks> adjacentVertexList) {
        this.adjacentEnabledVertexList = adjacentVertexList;
    }

    public boolean isVertexTraversed() {
        return vertexTraversed;
    }

    public void setVertexTraversed(boolean vertexTraversed) {
        this.vertexTraversed = vertexTraversed;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getPathDistance() {
        return pathDistance;
    }

    public void setPathDistance(int pathDistance) {
        this.pathDistance = pathDistance;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }
    
    public void pushAdjacentVertex(VertexLinks vertexLink){
        this.adjacentEnabledVertexList.add(vertexLink);
    }
    
    public void pushAdjacentVertex(Edge edge, Vertex vertex){
        this.adjacentEnabledVertexList.add(new VertexLinks(edge, vertex));
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
    
}
