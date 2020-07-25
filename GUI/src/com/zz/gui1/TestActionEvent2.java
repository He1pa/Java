package com.zz.gui1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent2 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Button start = new Button("start");
        Button end = new Button("end");
        //如果不显式定义setActionCommand，会返回Button的label值
        start.setActionCommand("start");
        end.setActionCommand("stop");
        MyMonitor myMonitor = new MyMonitor();
        start.addActionListener(myMonitor);
        end.addActionListener(myMonitor);
        frame.pack();
        frame.add(start,BorderLayout.NORTH);
        frame.add(end,BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
class MyMonitor implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("start")){
            System.out.println("start");
        }else {
            System.out.println("end");
        }
    }
}