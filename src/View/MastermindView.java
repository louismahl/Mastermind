/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Louis
 */
public class MastermindView extends JFrame{
    
    private JLabel label = new JLabel("Enter capital letters");
    private JTextField text = new JTextField(4);
    private JButton submit = new JButton("Try solution");
    private JLabel good = new JLabel();
    private JLabel goodBut = new JLabel();
    
    private JPanel panelInteract = new JPanel();
    private JPanel panelGame = new JPanel();
    
    private JSplitPane splitV;

    private int numberOfTest = 0;
    
    public MastermindView(){
        // Creating a panel
        setTitle( "Mastermind Application" );
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Creating main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);
        
        // Adding components
        panelInteract.add(label);
        panelInteract.add(text);
        panelInteract.add(submit);
        panelInteract.add(good);
        panelInteract.add(goodBut);
        
        // Panel Layout
        panelGame.setLayout(new GridLayout(10, 1));

        // Create a splitter pane
        splitV = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        panel.add(splitV, BorderLayout.CENTER);

        splitV.setTopComponent(panelInteract);
        splitV.setBottomComponent(panelGame);
    }
    
    public String getTry(){
        // Returning the text when the button is pressed
        return text.getText().toString().toUpperCase();
    }
    
    public void addSubmitListener(ActionListener listenForButtonClick){
        // When the button is pressed
        submit.addActionListener(listenForButtonClick);
    }
    
    public void setResult(int good, int goodBut){
        this.good.setText("" + good);
        this.goodBut.setText("" + goodBut);
        
        if(numberOfTest < 10){
            // Creating Temp panel
            JPanel panelTmp = new JPanel();

            // Creating Text views
            JLabel playerSol = new JLabel(this.text.getText().toString() + " | ");
            JLabel newGood = new JLabel("" + good + " well placed | ");
            JLabel newGoodBut = new JLabel("" + goodBut + " misplaced | ");
            JLabel attempt = new JLabel("Attempt " + (numberOfTest + 1) + "/10");

            // Adding Player solution + both results
            panelTmp.add(playerSol);
            panelTmp.add(newGood);
            panelTmp.add(newGoodBut);
            panelTmp.add(attempt);

            panelGame.add(panelTmp);
            
            if(good == 4){
                JOptionPane.showMessageDialog(null, "You won ! Good job.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You Lost, try again !");
        }
        // Check number of tests
        numberOfTest++;
    }

}
