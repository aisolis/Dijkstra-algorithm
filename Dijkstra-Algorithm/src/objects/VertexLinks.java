/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import java.util.Objects;

/**
 *
 * @author swords
 */
public class VertexLinks {
    
    private Edge edge;
    private Vertex vertex;

    public VertexLinks() {
        this(new Edge(), new Vertex());
    }
    
    public VertexLinks(Edge edge, Vertex vertex) {
        this.edge = edge;
        this.vertex = vertex;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }
}
