/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

/**
 *
 * @author swords
 */
public class Euclides {
    
    public int euclidesAlgorithm(int a, int b){
        if(b == 0){
            return a;
        }
        
        return euclidesAlgorithm(b, a%b);
    }
    
}
