package com.zz.gui1;

import java.awt.*;

public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button button1 = new Button("1");
        Button button2= new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");

        frame.add(button1,BorderLayout.EAST);
        frame.add(button2,BorderLayout.WEST);
        frame.add(button3,BorderLayout.NORTH);
        frame.add(button4,BorderLayout.SOUTH);
        frame.add(button5,BorderLayout.CENTER);

        frame.setSize(200,200);
        frame.setVisible(true);


    }
}
