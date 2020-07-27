package com.zz.gui.awt;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");

       //默认居中
        frame.setLayout(new FlowLayout());
        //居左
        //frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.setSize(200,200);
        frame.setVisible(true);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
    }
}
