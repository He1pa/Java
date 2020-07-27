package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JCheckBoxDemo extends JFrame {
    public JCheckBoxDemo() {
        Container container = this.getContentPane();
        URL resource = JButtonDemo.class.getResource("Icon.png");
        Icon icon = new ImageIcon(resource);

        //多选框
        JCheckBox jCheckBox1 = new JCheckBox("1");
        JCheckBox jCheckBox2 = new JCheckBox("2");
        JCheckBox jCheckBox3 = new JCheckBox("3");

        container.add(jCheckBox1,BorderLayout.SOUTH);
        container.add(jCheckBox2,BorderLayout.NORTH);
        container.add(jCheckBox3,BorderLayout.CENTER);



        this.setVisible(true);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {

        new JCheckBoxDemo();
    }
}

