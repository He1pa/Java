package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JRadioButtonDemo extends JFrame {
    public JRadioButtonDemo(){
        Container container = this.getContentPane();
        URL resource = JButtonDemo.class.getResource("Icon.png");
        Icon icon = new ImageIcon(resource);

        //单选框
        JRadioButton jrb1 = new JRadioButton("1");
        JRadioButton jrb2 = new JRadioButton("2");
        JRadioButton jrb3 = new JRadioButton("3");
        ButtonGroup group = new ButtonGroup();
        group.add(jrb1);
        group.add(jrb2);
        group.add(jrb3);

        container.add(jrb1,BorderLayout.CENTER);
        container.add(jrb2,BorderLayout.NORTH);
        container.add(jrb3,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        new JRadioButtonDemo();
    }
}

