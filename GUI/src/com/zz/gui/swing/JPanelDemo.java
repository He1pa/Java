package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {
    public JPanelDemo(){
        Container container = this.getContentPane();

        container.setLayout(new GridLayout(2,1,10,10));

        JPanel panel1 = new JPanel(new GridLayout(1,3));
        JPanel panel2 = new JPanel(new GridLayout(1,2));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel2.add(new JButton("2"));
        panel2.add(new JButton("2"));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500,500);
        container.add(panel1);
        container.add(panel2);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
