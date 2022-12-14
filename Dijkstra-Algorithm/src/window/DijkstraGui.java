/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package window;

import algorithms.Dijkstra;
import forms.Line;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objects.Coordinates;
import objects.Edge;
import objects.Graph;
import objects.Vertex;
import objects.VertexLinks;

/**
 *
 * @author swords
 */
public class DijkstraGui extends javax.swing.JFrame {

    Graph graph = new Graph();
    Vertex startVertex = null;
    Vertex endVertex = null;
    
    public void drawGraph(){
        canvas.paint(canvas.getGraphics());
        drawEdge();
        drawVertex();
    }
    
    public void drawVertex(){
        ArrayList<Vertex> vertexList = this.graph.getVertexList();
        for(Vertex vertex: vertexList){            
            vertex.getCircle().drawCircle(canvas.getGraphics());
        }
    }
    
    public void drawEdge(){
        ArrayList<Vertex> vertexList = this.graph.getVertexList();
        for(Vertex vertex : vertexList){            
            ArrayList<VertexLinks> edgeList = vertex.getAdjacentEnabledVertexList();
            if(edgeList != null){
                for(VertexLinks vl : edgeList){
                    vl.getEdge().getBreakLine().drawLine(canvas.getGraphics());
                }
            }            
        }
    }
    
    private int enterWeight(){
        String weight = JOptionPane.showInputDialog("Escriba la distancia entre los vertices");
        int intWeight = 0;
        
        try{
            intWeight = Integer.parseInt(weight);            
        }catch(Exception ex){
            intWeight = enterWeight();
        }
        return intWeight;
    }
    
    private void instanceVertex(int x, int y){
        Coordinates c = new Coordinates(100000,100000, x, y);
            String vertexName = JOptionPane.showInputDialog("Escriba el nombre del Vertice");
            if(vertexName != null){
                vertexName = vertexName.toUpperCase();//por que lo quiero todo en mayusculas
                Vertex vertex = new Vertex(vertexName,c);
                vertex.getCircle().setDiameter(30);
                vertex.getCircle().setLabel(vertex.getData() + "");
                if(this.graph.appendVertex(vertex)){
                    vertex.getCircle().drawCircle(canvas.getGraphics());
                }else{
                }
                startVertex = null;
                endVertex = null; 
            }
    }
    
    private void appendEdge(){
        int weight = enterWeight();
        Edge edge = new Edge();
        edge.setWeight(weight);
        Coordinates c = new Coordinates(100000,100000);
        c.addCoordinate(this.startVertex.getCircle().getX() + (this.startVertex.getCircle().getDiameter()/2),this.startVertex.getCircle().getY() + (this.startVertex.getCircle().getDiameter()/2));
        c.addCoordinate(this.endVertex.getCircle().getX() + (this.endVertex.getCircle().getDiameter()/2),this.endVertex.getCircle().getY() + (this.endVertex.getCircle().getDiameter()/2));
        Line line = new Line(c);
        edge.setEnabled(true);
        edge.setBreakLine(line);               
        //System.out.println(edge.toString());
        this.graph.appendNonDirectedLinkedVertex(this.startVertex, this.endVertex,edge);
       
    }
    
    /**
     * Creates new form DijkstraGui
     */
    public DijkstraGui() {
        initComponents();
        
        Toolkit tolToolkit = getToolkit();
        Dimension size = tolToolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2-getHeight()/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        addVertex = new javax.swing.JToggleButton();
        addEdge = new javax.swing.JToggleButton();
        dijkstraTrigger = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        switchToEuclides = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instructions = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmo de dijkstra y euclides - Mate Discreta");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(88, 214, 141));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        canvas.setBackground(new java.awt.Color(253, 254, 254));
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canvasMouseClicked(evt);
            }
        });

        addVertex.setText("A??adir Vertices");
        addVertex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVertexActionPerformed(evt);
            }
        });

        addEdge.setText("A??adir aristas");
        addEdge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEdgeActionPerformed(evt);
            }
        });

        dijkstraTrigger.setText("Camino mas corto");
        dijkstraTrigger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dijkstraTriggerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Algoritmo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("de");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Dijkstra");

        switchToEuclides.setText("Cambiar a Euclides");
        switchToEuclides.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToEuclidesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Instrucciones de uso:");

        instructions.setEditable(false);
        jScrollPane1.setViewportView(instructions);

        jButton1.setText("Reinicias canvas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(addVertex)
                            .addComponent(addEdge, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(switchToEuclides, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dijkstraTrigger, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addVertex)
                .addGap(12, 12, 12)
                .addComponent(addEdge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dijkstraTrigger)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(switchToEuclides)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1264, Short.MAX_VALUE))
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addVertexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVertexActionPerformed
        if(addEdge.isSelected()){
            addEdge.setSelected(false);
        }
        
        if(dijkstraTrigger.isSelected()){
            dijkstraTrigger.setSelected(false);
        }
        
        instructions.setText("Para A??adir vertices. \n\n 1) Haz click en cualquier parte de la zona en color blanco \n\n 2) Digita un nombre para el vertice \n\n 3) a??ade mas vertices" );
        
    }//GEN-LAST:event_addVertexActionPerformed

    private void canvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseClicked
        int x = evt.getX();
        int y = evt.getY();
        
        if(evt.getButton() == MouseEvent.BUTTON1 && addVertex.isSelected()){
            try {
                instanceVertex(x, y);
            } catch (Exception e) {}
        }else if(evt.getButton() == MouseEvent.BUTTON1 && addEdge.isSelected()){
            try{
                if(this.startVertex == null){
                   this.startVertex = this.graph.searchVertex(x, y);
                   this.startVertex.getCircle().setColor(Color.orange);
                }else{
                    this.endVertex = this.graph.searchVertex(x, y);                
                    appendEdge();            

                    this.startVertex.getCircle().setColor(Color.CYAN);
                    startVertex = null;
                    endVertex = null;
                }   
            }catch(Exception ex){}
        }else if(evt.getButton() == MouseEvent.BUTTON1 && dijkstraTrigger.isSelected()){
            try {
                if(this.graph.searchVertex(x, y)!=null){
                    if(this.startVertex == null){
                        this.graph.resetGraph();
                        this.graph.resetVertexColoring();
                        this.startVertex = this.graph.searchVertex(x, y);
                        this.startVertex.getCircle().setColor(Color.ORANGE);
                    }else{  
                        this.endVertex = this.graph.searchVertex(x, y);
                        this.endVertex.getCircle().setColor(Color.ORANGE);
                        Dijkstra dijkstra = new Dijkstra(this.graph);
                        dijkstra.doShortestRoute(this.startVertex);
                        dijkstra.coloringEdgesShortestPath(this.endVertex, Color.MAGENTA);
                    }
                }
            } catch (Exception e) {}
        }
        drawGraph();
    }//GEN-LAST:event_canvasMouseClicked

    private void addEdgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEdgeActionPerformed
        if(addVertex.isSelected()){
            addVertex.setSelected(false);
        }
        
        if(dijkstraTrigger.isSelected()){
            dijkstraTrigger.setSelected(false);
        }
        instructions.setText("Para A??adir aristas. \n\n 1) Haz click en cualquier Vertice ya existente \n\n 2) Selecciona otro vertice \n\n 3) colocale un peso o longitud al camino entre los vertices \n\n 4) puedes conectar el mismo vertice la cantidad de veces que desees" );
    }//GEN-LAST:event_addEdgeActionPerformed

    private void dijkstraTriggerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dijkstraTriggerActionPerformed
        if(addVertex.isSelected()){
            addVertex.setSelected(false);
        }
        
        if(addEdge.isSelected()){
            addEdge.setSelected(false);
        }
        
        instructions.setText("Para usar el algortimo dijkstra. \n\n 1) Haz click en cualquier Vertice que desees que sea el vertice origen \n\n 2) Selecciona el vertice final \n\n 3) El camino mas corto se marcara de color magenta" );

    }//GEN-LAST:event_dijkstraTriggerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         this.graph.resetGraph(true);
         drawGraph();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void switchToEuclidesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchToEuclidesActionPerformed
        EuclidesGui euclidesGui = new EuclidesGui();
        euclidesGui.show();
        dispose();
    }//GEN-LAST:event_switchToEuclidesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DijkstraGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DijkstraGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DijkstraGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DijkstraGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DijkstraGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton addEdge;
    private javax.swing.JToggleButton addVertex;
    private javax.swing.JPanel canvas;
    private javax.swing.JToggleButton dijkstraTrigger;
    private javax.swing.JTextPane instructions;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton switchToEuclides;
    // End of variables declaration//GEN-END:variables
}
