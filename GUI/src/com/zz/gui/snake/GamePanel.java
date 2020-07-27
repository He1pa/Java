package com.zz.gui.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //蛇的数据结构
    int length;
    int[] snakex = new int[600];//蛇的x坐标
    int[] snakey = new int[500];//蛇的y坐标
    String fx;//方向
    boolean isStart = false;
    boolean isFail = false;
    int score;
    int foodx;
    int foody;
    Random random = new Random();

    Timer timer = new Timer(100, this);

    public GamePanel() {
        init();
        //获得焦点和键盘事件
        this.setFocusable(true);
        this.addKeyListener(this);

    }


    public void init() {
        length = 3;
        snakex[0] = 100;
        snakey[0] = 100;
        snakex[1] = 75;
        snakey[1] = 100;
        snakex[2] = 50;
        snakey[2] = 100;
        fx = "R";
        score = 0;
        timer.start();

        foodx = 25 + 25 * random.nextInt(34);
        foody = 75 + 25 * random.nextInt(24);

    }


    //绘制面板
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.WHITE);
        //绘制面板
        Data.header.paintIcon(this, g, 25, 11);//头部广告栏
        g.fillRect(25, 75, 850, 600);//默认游戏界面
        //积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度"+ length,750,35);
        g.drawString("分数"+ score,750,50);
        //画蛇
        if (fx.equals("R")) {
            Data.right.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (fx.equals("L")) {
            Data.left.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (fx.equals("D")) {
            Data.down.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (fx.equals("U")) {
            Data.up.paintIcon(this, g, snakex[0], snakey[0]);
        }
        Data.food.paintIcon(this, g, foodx, foody);

        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this, g, snakex[i], snakey[i]);
        }

        //游戏状态
        if (isStart == false) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 300, 300);
        }
        if (isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("Failed", 300, 300);
        }
    }

    //键盘监听
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if(isFail){
                isFail = false;
                init();
            }else {
                isStart = !isStart;
            }
        }

        if (keyCode == KeyEvent.VK_UP) {
            fx = "U";
        } else if (keyCode == KeyEvent.VK_DOWN) {
            fx = "D";
        } else if (keyCode == KeyEvent.VK_LEFT) {
            fx = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            fx = "R";
        }
    }

    // 事件监听
    @Override
    public void actionPerformed(ActionEvent e) {
        //吃食物
        if (snakex[0] == foodx && snakey[0] == foody) {
            length++;
            score += 10;
            foodx = 25 + 25 * random.nextInt(34);
            foody = 75 + 25 * random.nextInt(24);

        }
        if (isStart && !isFail) {
            for (int i = length - 1; i > 0; i--) {
                snakex[i] = snakex[i - 1];
                snakey[i] = snakey[i - 1];
            }
            if (fx.equals("R")) {
                snakex[0] += 25;
                if (snakex[0] > 850) {
                    snakex[0] = 25;
                }
            } else if (fx.equals("L")) {
                snakex[0] -= 25;
                if (snakex[0] < 25) {
                    snakex[0] = 850;
                }
            } else if (fx.equals("U")) {
                snakey[0] -= 25;
                if (snakey[0] < 75) {
                    snakey[0] = 650;
                }
            } else if (fx.equals("D")) {
                snakey[0] += 25;
                if (snakey[0] > 650) {
                    snakey[0] = 75;
                }
            }

            repaint();
        }
        for (int i = 1; i < length; i++){
            if(snakex[0] == snakex[i] && snakey[0] == snakey[i]){
                isFail = true;
            }
        }
        timer.start();//定时器开始
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}