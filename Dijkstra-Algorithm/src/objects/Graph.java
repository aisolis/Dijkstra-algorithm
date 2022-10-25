/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author swords
 */
public class Graph {
    
    private ArrayList<Vertex> vertexList;

    public Graph() {
        this.vertexList = new ArrayList<>();
    }

    public ArrayList<Vertex> getVertexList() {
        return vertexList;
    }

    public void setVertexList(ArrayList<Vertex> vertexList) {
        this.vertexList = vertexList;
    }
    
    public boolean appendVertex(Vertex vertex){
        Vertex auxVertex = this.searchVertex(vertex.getData());
        
        if(auxVertex != null){
            return false;
        }else{
            this.vertexList.add(vertex);
            return true;
        }
    }
    
    public void appendDirectedLinkedVertex(Vertex fatherVertex, Vertex adjacentVertex, Edge edge){
        if(fatherVertex != null && adjacentVertex != null){
            fatherVertex.pushAdjacentVertex(edge, fatherVertex);
        }
    }
    
    public void appendNonDirectedLinkedVertex(Vertex fatherVertex, Vertex adjacentVertex, Edge edge){
        appendDirectedLinkedVertex(fatherVertex, adjacentVertex, edge);
        appendDirectedLinkedVertex(adjacentVertex, fatherVertex, edge);
    }
    
    public Vertex searchVertex(int x, int y){
        Vertex auxVertex = null;
        
        for(int i = 0; i < this.vertexList.size(); i++){
            int xVertex = this.vertexList.get(i).getCircle().getX();
            int yVertex = this.vertexList.get(i).getCircle().getY();
            
            if(x > xVertex && x < (xVertex + this.vertexList.get(i).getCircle().getDiameter())){
                if(y > yVertex && y < (yVertex + this.vertexList.get(i).getCircle().getDiameter())){
                    auxVertex = this.vertexList.get(i);
                    break;
                }
            }
        }
        
        return auxVertex;
    }
    
    public Vertex searchVertex(Object dato){
        Vertex auxVertex = null;        
        if(dato != null){
            for(Vertex vertex : this.vertexList){
                if(dato.equals(vertex.getData())){
                    auxVertex = vertex;
                }
            }
        }
        return auxVertex;
    }
    
    public ArrayList<Vertex> getAdjacent(Object data){
        ArrayList<Vertex> vertexAdjacentList = new ArrayList<>();
        
        Vertex mainVertex = searchVertex(data);
        ArrayList<VertexLinks> edges = mainVertex.getAdjacentEnabledVertexList();
        
        if(!edges.isEmpty()){
            for(int x = 0; x < edges.size(); x++){
                vertexAdjacentList.add(edges.get(x).getVertex());
            }
        }
        
        return vertexAdjacentList;
    }
    
    public boolean isAdjacent(Vertex vertex1, Vertex vertex2){
        boolean adjacent = false;
        
        ArrayList<VertexLinks> vertexArrayList = vertex1.getAdjacentEnabledVertexList();
        
        if(!vertexArrayList.isEmpty()){
            for(int i = 0; i < vertexArrayList.size(); i++){
                if(vertexArrayList.get(i).getVertex() == vertex2){
                    adjacent = true;
                    break;
                }
            }
        }
        return adjacent;
    }
    
    public boolean isAdjacent(Object start, Object end){
        boolean adjacent = false;
        
        Vertex vertex1 = searchVertex(start);
        Vertex vertex2 = searchVertex(end);
        
        ArrayList<VertexLinks> vertexArrayList = vertex1.getAdjacentEnabledVertexList();
        
        if(!vertexArrayList.isEmpty()){
            for(int i = 0; i < vertexArrayList.size(); i++){
                if(vertexArrayList.get(i).getVertex() == vertex2){
                    adjacent = true;
                    break;
                }
            }
        }
        return adjacent;       
    }
    
    public Edge getEdge(Object vertex1, Object vertex2){
        return getEdge(searchVertex(vertex1), searchVertex(2));
    }
    
    public Edge getEdge(String label){
        Edge auxEdge = null;
        if(label != null){
            ArrayList<Vertex> vertex = this.vertexList;
            for(Vertex vertexN : vertex){
                ArrayList<VertexLinks> vl = vertexN.getAdjacentEnabledVertexList();
                for(VertexLinks vlinks: vl ){
                    if(vlinks.getEdge().getEdgeName().equals(label)){
                        auxEdge = vlinks.getEdge();
                    }
                }
            }
        }
        return auxEdge;
    }
    
    public Edge getEdge(Vertex vertex1, Vertex vertex2){
        Edge auxEdege = null;
        if(isAdjacent(vertex1, vertex2)){
            ArrayList<VertexLinks> edgesList = vertex1.getAdjacentEnabledVertexList();
            for(int i = 0;i < edgesList.size();i++){
                if(edgesList.get(i).getVertex()== vertex2){
                    auxEdege = edgesList.get(i).getEdge();
                }
            }
        }else if(isAdjacent(vertex2, vertex1)){
            auxEdege = getEdge(vertex2, vertex1);
        }
        return auxEdege;
    }
    
    public VertexLinks getEnlace(Object datoNodo1,Object datoNodo2){
        VertexLinks auxEdge = null;
        if(isAdjacent(datoNodo1, datoNodo2)){
            Vertex vertex1 = searchVertex(datoNodo1);
            Vertex vertex2 = searchVertex(datoNodo2);
            ArrayList<VertexLinks> edgeList = vertex1.getAdjacentEnabledVertexList();
            for(int i = 0;i < edgeList.size();i++){
                if(edgeList.get(i).getVertex() == vertex2){
                    auxEdge = edgeList.get(i);
                }
            }
        }
        else if(isAdjacent(datoNodo2, datoNodo1)){
            auxEdge = getEnlace(datoNodo2, datoNodo1);
        }
        return auxEdge;
    }
    
    
    public void resetGraph(){
        for(Vertex n : this.vertexList){
            n.setMark(false);
            n.setPreviousVertex(null);
            n.setPathDistance(-1);
        }
    }
    
    public boolean deleteVertex(Vertex vertex){
        boolean removed = false;
        
        if(vertex != null){
            removed = this.vertexList.remove(vertex);
        }
        return removed;
    }
    
    public void resetVertexColoring(){
        if(!this.vertexList.isEmpty()){
            for(Vertex vertex: this.vertexList){
                vertex.getCircle().setColor(Color.CYAN);
            ArrayList<VertexLinks> vl = vertex.getAdjacentEnabledVertexList();
                if(!vl.isEmpty()){
                    for(VertexLinks vl1 : vl){
                        //if(vl1.getEdge().isEnabled()){
                            vl1.getEdge().getBreakLine().setColor(Color.black);
                            vl1.getEdge().getBreakLine().setLineWeight(2);
                        //}
                    }
                }
            }
        }
    }
    
    public ArrayList<Edge> incomingEdge(Vertex vertex){
        ArrayList<Edge> vList = new ArrayList<>();
        for(Vertex v: this.vertexList){
            ArrayList<VertexLinks> vl = v.getAdjacentEnabledVertexList();
            if(!vl.isEmpty()){
                for(VertexLinks vl1 : vl){
                    if(vl1.getVertex() == vertex){
                        vList.add(vl1.getEdge());
                    }
                }
            }
        }
        return vList;
    }
    
    public ArrayList<Edge> outgoingEdge(Vertex vertex){
        ArrayList<Edge> vList = new ArrayList<>();
        
        if(vertex != null){
            if(this.vertexList.contains(vertex)){                
                ArrayList<VertexLinks> vlList = vertex.getAdjacentEnabledVertexList();
                for(VertexLinks vl: vlList){
                    vList.add(vl.getEdge());
                }
            }
        }
        return vList;
    }
    
    public void deleteEdges(Vertex vertex){
        ArrayList<Edge> edges = outgoingEdge(vertex);        
        for(Edge edge : edges){
            edge.resetEdge();
        }
    }
    
    public void deleteOutgoingEdges(Vertex vertex){
        deleteEdges(vertex);
    }
    
    public void deleteincomingEdges(Vertex vertex){
        deleteEdges(vertex);
    }

    
}
