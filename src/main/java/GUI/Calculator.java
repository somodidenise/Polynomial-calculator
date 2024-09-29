package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {

    Font myFont = new Font("Courier",Font.ITALIC, 15);
    JFrame myFrame;
    JButton[] inputButtons = new JButton[16];
    JButton[] operationButtons = new JButton[6];
    JButton clearButton, delButton;
    JTextField textField1, textField2, var;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    public JLabel result;

    Calculator(){
        myFrame = new JFrame("Polynomial Calculator");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(460,650);
        myFrame.setLayout(null);
        myFrame.setLocationRelativeTo(null);
        myFrame.getContentPane().setBackground(new java.awt.Color(255, 204, 255));

        textField1 = new JTextField();
        textField1.setBounds(200, 30, 200, 25);
        textField1.setFont(myFont);
        var = textField1;
        myFrame.add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(200, 75, 200, 25 );
        textField2.setFont(myFont);
        myFrame.add(textField2);

        label1 = new JLabel("First Polynomial: ");
        label1.setBounds(50, 30,150,25);
        label1.setFont(myFont);
        myFrame.add(label1);

        label2 = new JLabel("Second Polynomial: ");
        label2.setBounds(50, 75,150,25);
        label2.setFont(myFont);
        myFrame.add(label2);

        label3 = new JLabel("Result: ");
        label3.setBounds(190, 510,150,25);
        label3.setFont(myFont);
        myFrame.add(label3);

        JPanel panel = new JPanel();
        panel.setBounds(60, 120, 200, 200);
        panel.setLayout(new GridLayout(4,4, 5, 5));
        panel.setBackground(new java.awt.Color(255, 102, 255));

        inputButtons[0] = new JButton("7");
        inputButtons[1] = new JButton("8");
        inputButtons[2] = new JButton("9");
        inputButtons[3] = new JButton("+");
        inputButtons[4] = new JButton("4");
        inputButtons[5] = new JButton("5");
        inputButtons[6] = new JButton("6");
        inputButtons[7] = new JButton("-");
        inputButtons[8] = new JButton("1");
        inputButtons[9] = new JButton("2");
        inputButtons[10] = new JButton("3");
        inputButtons[11] = new JButton("*");
        inputButtons[12] = new JButton("0");
        inputButtons[13] = new JButton("x");
        inputButtons[14] = new JButton("^");
        inputButtons[15] = new JButton(".");

        for(JButton elem : inputButtons){

            elem.setFont(myFont);
            elem.setBackground(new java.awt.Color(255, 153, 255));
            elem.setFocusable(false);
            panel.add(elem);

        }
        myFrame.add(panel);

        JPanel panel1 = new JPanel();
        panel1.setBounds(60, 350, 330, 150);
        panel1.setLayout(new GridLayout(3,3, 5, 5));
        panel1.setBackground(new java.awt.Color(255, 102, 255));

        operationButtons[0] = new JButton("Add");
        operationButtons[1] = new JButton("Subtract");
        operationButtons[2] = new JButton("Multiply");
        operationButtons[3] = new JButton("Divide");
        operationButtons[4] = new JButton("Derivative");
        operationButtons[5] = new JButton("Integral");

        for(JButton elem : operationButtons){

            elem.setFont(myFont);
            elem.setBackground(new java.awt.Color(255, 153, 255));
            elem.setFocusable(false);
            panel1.add(elem);

        }
        myFrame.add(panel1);

        delButton = new JButton("Delete");
        delButton.setFont(myFont);
        delButton.setFocusable(false);
        delButton.setBackground(new java.awt.Color(255, 153, 255));
        delButton.setBounds(280, 160, 100, 50);
        myFrame.add(delButton);

        clearButton = new JButton("Clear");
        clearButton.setFont(myFont);
        clearButton.setFocusable(false);
        clearButton.setBackground(new java.awt.Color(255, 153, 255));
        clearButton.setBounds(280, 230, 100, 50);
        myFrame.add(clearButton);

        result = new JLabel();
        result.setBounds(140, 550, 300, 25);
        result.setFont(myFont);
        myFrame.add(result);

        myFrame.setVisible(true);
    }
}
