package com.zz.gui.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText {
    public static void main(String[] args) {
        new MyFrame1();
    }
}
class MyFrame1 extends  Frame{
    public MyFrame1(){
        TextField textField = new TextField();
        add(textField);
        MyActionListener2 myActionListener2 = new MyActionListener2();
        textField.addActionListener(myActionListener2);
        //设置替换编码
        textField.setEchoChar('*');
        setVisible(true);
        pack();
    }
}

class MyActionListener2 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField field = (TextField) e.getSource();
        System.out.println(field.getText());
        field.setText("");
    }
}