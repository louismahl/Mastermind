/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MastermindModel;
import View.MastermindView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Louis
 */
public class MastermindController {
    
    private MastermindView v;
    private MastermindModel m;
    
    public MastermindController(MastermindView view, MastermindModel model){
        this.v = view;
        this.m = model;
        
        this.v.addSubmitListener(new SubmitListener());
    }
    
    class SubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = "";
            int good = 0;
            int goodButWrongPosition = 0;
            
            try {
                text = v.getTry();
                m.calculateResults(text);
                good = m.getResultGood();
                goodButWrongPosition = m.getResultGoodButWrongPosition();
                v.setResult(good, goodButWrongPosition);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    }
}
