package com.zz.gui.awt;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMouseListener {
    public static void main(String[] args) {
        new MouseFrame("画图");
    }
}
class MouseFrame extends Frame {
    ArrayList points;
    public MouseFrame(String title){
        super(title);
        setBounds(400,400,400,400);
        //存鼠标的点
        points = new ArrayList<>();
        setVisible(true);
        //鼠标监听器
        this.addMouseListener(new MyMouseListner());
    }

    public void paint(Graphics g){
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point point = (Point) iterator.next();
            g.setColor(Color.red);
            g.fillOval(point.x,point.y,10,10);
        }
    }

    public void addPaint(Point point){
        points.add(point);
    }

    private class MyMouseListner extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            MouseFrame myframe = (MouseFrame)e.getSource();
            myframe.addPaint(new Point(e.getX(),e.getY()));


            //每次点击都重画一次
            myframe.repaint();
        }
    }
}