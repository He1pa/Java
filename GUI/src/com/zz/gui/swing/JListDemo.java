package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;

public class JListDemo extends JFrame {
    public JListDemo() {
        Container container = this.getContentPane();

        String[] contents = {"1","2","3"};
        JList jList = new JList(contents);
        container.add(jList);
        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new JListDemo();
    }
}
