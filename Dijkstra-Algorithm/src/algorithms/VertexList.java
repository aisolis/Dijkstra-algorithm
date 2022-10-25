/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

import java.awt.Color;
import java.util.ArrayList;
import objects.Vertex;

/**
 *
 * @author swords
 */
public class VertexList extends ArrayList<Vertex> {

    public VertexList() {
        super();
    }
    
    
    public Vertex shortestVertex(){
        Vertex aux = new Vertex();
        aux.setPathDistance(9999999);

        for(Vertex vertex : this){
            if(vertex.getPathDistance()< aux.getPathDistance()){
                aux = vertex;       
            }
        }

        return aux;
    }
    
    public boolean listContainsVertex(Vertex vertex){
        boolean contained = false;
        
        for(Vertex vtx : this){
            if(vtx == vertex){
                contained = true;
            }
        }
        return contained;
    }
    
    
    
}
