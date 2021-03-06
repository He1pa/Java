package com.zz.gui.awt;

import java.awt.*;

public class TestFrame02 {

    public static void main(String[] args) {
        MyFrame myFrame1 = new MyFrame(100, 100, 200, 200, Color.BLUE);
        MyFrame myFrame2 = new MyFrame(300, 100, 200, 200, Color.BLUE);
        MyFrame myFrame3 = new MyFrame(100, 300, 200, 200, Color.BLUE);
        MyFrame myFrame4 = new MyFrame(300, 300, 200, 200, Color.BLUE);
    }
}


class MyFrame extends Frame {
    static int id = 0;
        public MyFrame(int x,int y,int w,int h,Color color){
            super("MyFrame" + (++id));
            setVisible(true);
            setBounds(x,y,w,h);
            setBackground(color);
        }

}