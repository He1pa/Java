package com.zz.gui1;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame{
    public void loadFrame(){
        setBounds(200,200,600,800);
        setVisible(true);
    }

    public void  paint(Graphics g){
        g.setColor(Color.red);
        //g.drawOval(100,100,100,100);
        g.fillOval(100,100,100,100);
        //画笔用完还原原色
        g.setColor(Color.black);
    }
}
