package GUI;

import BusinessLogic.Operations;
import DataModels.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener, MouseListener {
    Calculator calculator;
    public Controller(){

        this.calculator = new Calculator();
        addActionListeners();
        addMouseListeners();
    }
    public void addActionListeners(){
        for(JButton elem : this.calculator.inputButtons)
        {
            elem.addActionListener(this);
        }
        for(JButton elem : this.calculator.operationButtons)
        {
            elem.addActionListener(this);
        }
        this.calculator.delButton.addActionListener(this);
        this.calculator.clearButton.addActionListener(this);

    }

    public void addMouseListeners(){

        this.calculator.textField1.addMouseListener(this);
        this.calculator.textField2.addMouseListener(this);
    }

    public void actionPerformed(ActionEvent ev) {
        for (JButton elem : calculator.inputButtons) {
            if (ev.getSource() == elem) {

               calculator.var.setText(calculator.var.getText().concat(elem.getText()));
            }
        }
        if(ev.getSource() == calculator.delButton && calculator.var.getText().length() > 0){

            calculator.var.setText(calculator.var.getText().substring(0,calculator.var.getText().length()-1));

        } else if (ev.getSource() == calculator.clearButton) {

            calculator.textField1.setText("");
            calculator.textField2.setText("");

        } else if (ev.getSource() == calculator.operationButtons[0]) {  //add

            Polynomial polynomial1 = new Polynomial(calculator.textField1.getText());
            Polynomial polynomial2 = new Polynomial(calculator.textField2.getText());
            Operations operations = new Operations();
            Polynomial result = new Polynomial();
            result = operations.add(polynomial1, polynomial2);
            calculator.result.setText(result.toString());

        } else if (ev.getSource() == calculator.operationButtons[1]) {  //subtract

            Polynomial polynomial1 = new Polynomial(calculator.textField1.getText());
            Polynomial polynomial2 = new Polynomial(calculator.textField2.getText());
            Operations operations = new Operations();
            Polynomial result = new Polynomial();
            result = operations.subtract(polynomial1, polynomial2);
            calculator.result.setText(result.toString());

        } else if (ev.getSource() == calculator.operationButtons[2]) {  //multiply

            Polynomial polynomial1 = new Polynomial(calculator.textField1.getText());
            Polynomial polynomial2 = new Polynomial(calculator.textField2.getText());
            Operations operations = new Operations();
            Polynomial result = new Polynomial();
            result = operations.multiply(polynomial1, polynomial2);
            calculator.result.setText(result.toString());

        } else if (ev.getSource() == calculator.operationButtons[3]) {  //divide

            Polynomial polynomial1 = new Polynomial(calculator.textField1.getText());
            Polynomial polynomial2 = new Polynomial(calculator.textField2.getText());
            Operations operations = new Operations();
            Polynomial result = new Polynomial();
            result = operations.divide(polynomial1, polynomial2);
            calculator.result.setText(result.toString());

        } else if (ev.getSource() == calculator.operationButtons[4]) {  //derivative

            Polynomial polynomial1 = new Polynomial(calculator.textField1.getText());
            Operations operations = new Operations();
            Polynomial result = new Polynomial();
            result = operations.derivative(polynomial1);
            calculator.result.setText(result.toString());

        } else if (ev.getSource() == calculator.operationButtons[5]) {  //integrate

            Polynomial polynomial1 = new Polynomial(calculator.textField1.getText());
            Operations operations = new Operations();
            Polynomial result = new Polynomial();
            result = operations.integrate(polynomial1);
            calculator.result.setText(result.toString() + "+C");
        }
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == calculator.textField2)
        {
            calculator.var = calculator.textField2;
        }
        if(e.getSource() == calculator.textField1)
        {
           calculator.var = calculator.textField1;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
