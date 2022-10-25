/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

import algorithms.util.VertexList;
import java.awt.Color;
import java.util.ArrayList;
import objects.Edge;
import objects.Graph;
import objects.Vertex;
import objects.VertexLinks;

/**
 *
 * @author swords
 */
public class Dijkstra {
    Graph graph;
    VertexList vertexList;
    ArrayList<Edge> edgeList = new ArrayList<>();

    public Dijkstra(Graph graph) {
        this.graph = graph;
        System.out.println(this.graph);
        vertexList = new VertexList();
    }
    
    public void doShortestRoute(Vertex startVertex){
        
        startVertex.setPathDistance(0);
        if(startVertex != null){
            vertexList = new VertexList();
            vertexList.add(startVertex);
            while(!vertexList.isEmpty()){
                Vertex minorVertex = vertexList.shortestVertex();
                minorVertex.setMark(true);
                vertexList.remove(minorVertex);
                FillWithAdjacentsVertex(minorVertex);
            }
        }
    }

    private void FillWithAdjacentsVertex(Vertex vertex){
        if(vertex != null){
            ArrayList<VertexLinks> vertexLinks = vertex.getAdjacentEnabledVertexList();
            if(vertexLinks != null){
                    for(VertexLinks vl:vertexLinks){
                    Vertex aux2 = vl.getVertex();
                    if(!aux2.isMark()){
                        if(vertexList.listContainsVertex(aux2)){
                            int length = vertex.getPathDistance()+ vl.getEdge().getWeight();
                            if(aux2.getPathDistance()> length){
                                aux2.setPathDistance(length);
                                aux2.setPreviousVertex(vertex);
                            }
                        }else{
                            aux2.setPathDistance(vertex.getPathDistance()+ vl.getEdge().getWeight());
                            aux2.setPreviousVertex(vertex);
                            vertexList.add(aux2);
                        }

                    }
                }
            }
        }
    }

    public void coloringEdgesShortestPath(Vertex finalVertex, Color color){
        if(finalVertex != null){
        shortestPath(finalVertex);
            for(int i = 0;i < this.edgeList.size();i++){
                if(!this.edgeList.isEmpty()){
                    this.edgeList.get(i).getBreakLine().setColor(color);
                    this.edgeList.get(i).getBreakLine().setWeight(4);
                }
            }
        }
    }
    
    private void shortestPath(Vertex fv){
        this.edgeList.clear();
        Vertex auxVertex = fv;
        while(auxVertex.getPreviousVertex()!= null){
        this.edgeList.add(this.graph.getEdge(auxVertex,
                auxVertex.getPreviousVertex()));
        auxVertex = auxVertex.getPreviousVertex();
    }
    }
    
}
