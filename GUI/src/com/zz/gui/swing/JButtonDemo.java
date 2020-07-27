package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo extends JFrame {
    public JButtonDemo(){
        Container container = this.getContentPane();
        URL resource = JButtonDemo.class.getResource("Icon.png");
        Icon icon = new ImageIcon(resource);

        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("图片按钮");
        container.add(button);

        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        new JButtonDemo();
    }
}
