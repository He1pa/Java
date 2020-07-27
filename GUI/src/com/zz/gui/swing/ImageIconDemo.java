package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {
    public ImageIconDemo(){
        JLabel label = new JLabel("Icon");
        URL url = ImageIconDemo.class.getResource("Icon.png");

        ImageIcon imageIcon = new ImageIcon(url);
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Container container = getContentPane();
        container.add(label);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageIconDemo();
    }
}
