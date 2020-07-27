package com.zz.gui.awt;

import java.awt.*;

public class TestFrame01 {
    public static void main(String[] args) {
        Frame frame =new Frame("the first window");

        //设置可见性
        frame.setVisible(true);

        //设置大小 颜色
        frame.setSize(400,400);
        frame.setBackground(new Color(31, 83, 41));

        //初始位置
        frame.setLocation(200,200);

        //大小固定
        frame.setResizable(false);
    }
}
