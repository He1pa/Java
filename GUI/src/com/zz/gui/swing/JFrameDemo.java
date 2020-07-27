package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {

    //init()；初始化

    public void init(){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(100,100,200,200);

        JLabel jLabel = new JLabel("Welcome");
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);


        //容器实例化
        Container contentPane = jFrame.getContentPane();
        contentPane.setBackground(Color.red);
        contentPane.add(jLabel);
        //关闭
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JFrameDemo().init();
    }
}
