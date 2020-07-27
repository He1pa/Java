<center>  GUI  </center>



# 1 简介

GUI核心技术：Swing AWT

不流行原因：

1. 界面不美观
2. 需要jre环境

# 2.AWT

## 2.1 AWT介绍

1. 包含很多类和接口
2. 元素：窗口，按钮，文本框
3. java.awt

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

```java
package com.zz.gui1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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


```



### 10 键盘监听

```java
package com.zz.gui1;

import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();
    }
}

class KeyFrame extends Frame{
    public  KeyFrame(){
        setBounds(1,2,300,400);
        setVisible(true);

        addKeyListener(new KeyAdapter() {
            //键盘按下
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP){
                    System.out.println("up");
                }
            }
        });
    }
}
```

# 3 Swing

## 3.1 窗口、面板

```java
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

```

## 3.2 弹窗

```java
package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo extends JFrame
{
    public DialogDemo(){
        this.setVisible(true);
        this.setSize(700,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        JButton jButton = new JButton("button");
        jButton.setBounds(30,30,200,50);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MydDialogDemo();
            }
        });
        contentPane.add(jButton);
    }

    public static void main(String[] args) {
        new DialogDemo();
    }
}
class MydDialogDemo extends JDialog{
    public MydDialogDemo() {
        this.setVisible(true);
        this.setBounds(100,100,500,500);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        //contentPane.setLayout(null);
        contentPane.add(new JLabel("Welcome"));
    }
}
```

## 3.3 标签

```java
new JLabel("xxx");
```

图片标签

```java
package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {
    public ImageIconDemo(){
        JLabel label = new JLabel("Icon");
        URL url = ImageIconDemo.class.getResource("Icon.png");

        ImageIcon imageIcon = new ImageIcon(url);
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Container container = getContentPane();
        container.add(label);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageIconDemo();
    }
}
```

## 3.4 面板

```java
package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {
    public JPanelDemo(){
        Container container = this.getContentPane();

        container.setLayout(new GridLayout(2,1,10,10));

        JPanel panel1 = new JPanel(new GridLayout(1,3));
        JPanel panel2 = new JPanel(new GridLayout(1,2));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel2.add(new JButton("2"));
        panel2.add(new JButton("2"));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500,500);
        container.add(panel1);
        container.add(panel2);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}

```

JScrollPanel

```java
package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {

    public JScrollDemo(){
        Container container = this.getContentPane();

        JTextArea jTextArea = new JTextArea(20, 50);
        jTextArea.setText("welcome");

        JScrollPane jScrollPane = new JScrollPane(jTextArea);


        container.add(jScrollPane);
        this.setVisible(true);
        this.setBounds(100,100,300,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
```

## 3.5 按钮

图片按钮

```java
package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo extends JFrame {
    public JButtonDemo(){
        Container container = this.getContentPane();
        URL resource = JButtonDemo.class.getResource("Icon.png");
        Icon icon = new ImageIcon(resource);

        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("图片按钮");
        container.add(button);

        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        new JButtonDemo();
    }
}
```

单选框

```java
package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo2 extends JFrame {
    public JButtonDemo2(){
        Container container = this.getContentPane();
        URL resource = JButtonDemo.class.getResource("Icon.png");
        Icon icon = new ImageIcon(resource);

        //单选框
        JRadioButton jrb1 = new JRadioButton("1");
        JRadioButton jrb2 = new JRadioButton("2");
        JRadioButton jrb3 = new JRadioButton("3");
        ButtonGroup group = new ButtonGroup();
        group.add(jrb1);
        group.add(jrb2);
        group.add(jrb3);

        container.add(jrb1,BorderLayout.CENTER);
        container.add(jrb2,BorderLayout.NORTH);
        container.add(jrb3,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        new JButtonDemo2();
    }
}


```

复选框

```java
package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo3 extends JFrame {
    public JButtonDemo3() {
        Container container = this.getContentPane();
        URL resource = JButtonDemo.class.getResource("Icon.png");
        Icon icon = new ImageIcon(resource);

        //多选框
        JCheckBox jCheckBox1 = new JCheckBox("1");
        JCheckBox jCheckBox2 = new JCheckBox("2");
        JCheckBox jCheckBox3 = new JCheckBox("3");

        container.add(jCheckBox1,BorderLayout.SOUTH);
        container.add(jCheckBox2,BorderLayout.NORTH);
        container.add(jCheckBox3,BorderLayout.CENTER);



        this.setVisible(true);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {

        new JButtonDemo3();
    }
}
```

## 3.6 列表

列表框：展示信息，动态扩容

```java
package com.zz.gui.swing;

import javax.swing.*;
import java.awt.*;

public class JListDemo extends JFrame {
    public JListDemo() {
        Container container = this.getContentPane();

        String[] contents = {"1","2","3"};
        JList jList = new JList(contents);
        container.add(jList);
        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new JListDemo();
    }
}

```

下拉框：选择（地区），或单个选项

```java
package com.zz.gui.swing;

import com.zz.gui.awt.Test;

import javax.swing.*;
import java.awt.*;

public class TestComboBoxDemo extends JFrame {
    public TestComboBoxDemo() {
        Container container = this.getContentPane();
        JComboBox status = new JComboBox();
        status.addItem(null);
        status.addItem("1");
        status.addItem("2");
        status.addItem("3");
        container.add(status);



        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TestComboBoxDemo();
    }
}

```



## 3.7 文本框

文本框、密码框、文本域

```java
package com.zz.gui.swing;

import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.awt.*;

public class TextDemo extends JFrame {
    public TextDemo() {
        Container container = this.getContentPane();
        //文本框
        JTextField jTextField1 = new JTextField("hello");
        JTextField jTextField2 = new JTextField("hello",20);
        container.add(jTextField1,BorderLayout.NORTH);
        container.add(jTextField2,BorderLayout.SOUTH);
        //密码框
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setEchoChar('*');
        container.add(jPasswordField,BorderLayout.CENTER);
        //文本域  配合面板使用
        JTextArea jTextArea = new JTextArea();
        jTextArea.setText("21314");
        container.add(jTextArea,BorderLayout.EAST);

        
        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TextDemo();
    }
}

```

