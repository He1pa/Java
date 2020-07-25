<center>  GUI  </center>



# 1 简介

# 2.AWT

## 2.1 AWT介绍

## 2.2组件和容器

### 1 Frame

### 2 面板Panel

Panel可以看成是一个空间，但是不能单独存在

### 3 布局管理器

+ 流式布局
+ 东西南北中
+ 表格

总结：

1. Frame是一个顶级窗口
2. Panel无法单独显示，必须添加到某个容器中
3. 布局管理器
4. 大小，背景颜色，定位，可见性，监听

### 4 事件监听

当某个事件发生时，需要做什么

### 5 TextField

### 6 组合内部类，计算器

```java
package com.zz.gui1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TestCalc {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}
//计算器类
class Calculator extends Frame {
    TextField num1,num2,num3;
    public void loadFrame(){
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(20);
        Button button = new Button("=");
        button.addActionListener(new CalculatorListener());
        Label label = new Label("+");
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);
        pack();
        setVisible(true);
    }
    private class CalculatorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            num3.setText("" + (n1 + n2));
            num1.setText("");
            num2.setText("");
        }
    }
}
```



### 7 画笔

```java
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

```



### 8 鼠标监听

```java
package com.zz.gui1;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
```



### 9 窗口监听

### 10 键盘监听



