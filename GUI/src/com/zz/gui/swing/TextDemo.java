package com.zz.gui.swing;

import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.awt.*;

public class TextDemo extends JFrame {
    public TextDemo() {
        Container container = this.getContentPane();
        //文本框
        JTextField jTextField1 = new JTextField("hello");
        JTextField jTextField2 = new JTextField("hello",20);
        container.add(jTextField1,BorderLayout.NORTH);
        container.add(jTextField2,BorderLayout.SOUTH);
        //密码框
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setEchoChar('*');
        container.add(jPasswordField,BorderLayout.CENTER);
        //文本域 配合面板使用
        JTextArea jTextArea = new JTextArea(20, 50);
        jTextArea.setText("welcome");

        JScrollPane jScrollPane = new JScrollPane(jTextArea);


        container.add(jScrollPane,BorderLayout.EAST);


        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TextDemo();
    }
}
