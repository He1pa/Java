package com.zz.gui1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(400,300);
        frame.setLocation(500,500);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(2,1));

        Panel p1 = new Panel(new BorderLayout());
        Panel p3 = new Panel(new BorderLayout());


        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p4 = new Panel(new GridLayout(2,2));

        p1.add(new Button("b1"),BorderLayout.EAST);
        p1.add(new Button("b2"),BorderLayout.WEST);
        p2.add(new Button("b3"));
        p2.add(new Button("b4"));

        p1.add(p2,BorderLayout.CENTER);

        p3.add(new Button("b5"),BorderLayout.EAST);
        p3.add(new Button("b6"),BorderLayout.WEST);

        for (int i = 0; i < 4; i++) {
            p4.add(new Button("b"+(i+7)));
        }
        p3.add(p4,BorderLayout.CENTER);
        frame.add(p1);
        frame.add(p3);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
