package com.zz.gui.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestCalc {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}
//计算器类
class Calculator extends Frame {

    TextField num1,num2,num3;

    public void loadFrame(){
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(20);

        Button button = new Button("=");
        button.addActionListener(new CalculatorListener());
        Label label = new Label("+");
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        pack();
        setVisible(true);


    }

    private class CalculatorListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());

            num3.setText("" + (n1 + n2));

            num1.setText("");
            num2.setText("");

        }
    }

}


