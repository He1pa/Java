package com.zz.gui.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel();

        frame.setLayout(null);

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(40,160,35));

        panel.setBounds(50,50,400,400);
        panel.setBackground(Color.red);

        frame.add(panel);

        frame.setVisible(true);

        //监听事件，关闭窗口
        //适配器模式
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}
