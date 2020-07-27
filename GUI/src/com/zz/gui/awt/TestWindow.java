package com.zz.gui.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

class WindowFrame extends Frame{
    //匿名内部类
    public  WindowFrame(){

        setBounds(100,100,200,200);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {

                System.exit(0);
        }});
    }
}

