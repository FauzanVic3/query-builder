/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.fauzanvic3.query.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
/**
 *
 * @author Fauzan
 */
public class Main {

    public static void main(String[] args) {

        // Create and set up a frame window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Layout");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Define the panel to hold the components  
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
         
        JLabel label = new JLabel("Enter Fibonacci sequence to generate (n): ");
        JTextField text = new JTextField("", 15);
        panel.setSize(300, 300);
        panel.setLayout(layout);
        panel.add(label);
        panel.add(text);
 
        //Define button to perform calculation
        JButton btnCalculate = new JButton("Generate");        
        panel.add(btnCalculate);
        
        //Define label for displaying result
        JLabel labelResult = new JLabel("");
        panel.add(labelResult);
        
        // Put constraint on components
        layout.putConstraint(SpringLayout.WEST, label, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, text, 20, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, text, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, btnCalculate, 20, SpringLayout.EAST, text);
        layout.putConstraint(SpringLayout.NORTH, btnCalculate, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, labelResult, 50, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.SOUTH, labelResult, 100, SpringLayout.SOUTH, text);
         
        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.setVisible(true);
        
        btnCalculate.addActionListener(e -> selectionButtonPressed(frame, panel, text, layout, labelResult));
        
    }
    
    public static void selectionButtonPressed(JFrame frame, JPanel panel, JTextField text, SpringLayout layout, JLabel labelResult){
        String result = generateFibonacci(Integer.parseInt(text.getText()));
            if(result != null){
                result += "</html>";
            }
            labelResult.setText(result);
            frame.invalidate();
            frame.validate();
            frame.repaint();
            
            System.out.println("result : "+result);
    }
    
    public static String generateFibonacci(int n){
        
        String fibonacciResult = "<html>";
        
        int fibonacci = 1;

        int m = 0;

        int n2 = 0;
        for(int i = 1; i<=n ; i++){
            fibonacci = m + n2;
            
            if(m <1) fibonacci = 1;
            fibonacciResult = fibonacciResult + fibonacci + " <br/>";
            
            n2 = m;
            m = fibonacci;
        }
                
        return fibonacciResult;
    }
    
}
