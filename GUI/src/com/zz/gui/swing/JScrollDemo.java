package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {

    public JScrollDemo(){
        Container container = this.getContentPane();

        JTextArea jTextArea = new JTextArea(20, 50);
        jTextArea.setText("welcome");

        JScrollPane jScrollPane = new JScrollPane(jTextArea);


        container.add(jScrollPane);
        this.setVisible(true);
        this.setBounds(100,100,300,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
