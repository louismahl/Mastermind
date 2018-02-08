/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.MastermindModel;
import View.MastermindView;
import Controller.MastermindController;

/**
 *
 * @author Louis
 */
public class Mastermind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MastermindModel model = new MastermindModel();
        MastermindView view = new MastermindView();
        MastermindController controller = new MastermindController(view, model);
        view.setVisible(true);
    }
    
}
