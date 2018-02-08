/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Louis
 */
public class MastermindModel {
    
    private String solution;
    private int good, goodBut;

    public MastermindModel() {
        // Generate random solution
        this.solution = "ABCD";
        this.good = 0;
        this.goodBut = 0;
    }
    
    public void calculateResults(String text){
        
        // Initialization
        int index1 = 0;
        int index2 = 0;
        this.good = 0;
        this.goodBut = 0;
        String tmpSol = this.solution;
        
        // Let's scroll the characters in the text
        for(char a : text.toCharArray()){
            // If the char at the same position is the same
            if(a == tmpSol.charAt(index1)){
                // Char found, we can change it to # in tmpSol
                tmpSol = changeCharAt(index1, tmpSol);
                this.good++;
            }
            else{
                // Reset index2 
                index2 = 0;
                for(char b : tmpSol.toCharArray()){
                    if((a == b) && (b != text.charAt(index2))){
                        // Char found, we can change it to # in tmpSol
                        tmpSol = changeCharAt(index2, tmpSol);
                        this.goodBut++;
                    }
                    index2++;
                }
            }
            index1++;
        }
    }
    
    public String changeCharAt(int index, String tmpSol){
        StringBuilder tmp = new StringBuilder(tmpSol);
        tmp.setCharAt(index, '#');
        return tmp.toString();
    }
    
    public int getResultGood(){
        return good;
    }
    
    public int getResultGoodButWrongPosition(){
        return goodBut;
    }
}
