package com.zz.gui.snake;

import javax.swing.*;
import java.net.URL;

public class Data {
    public static URL HEAD_URL = Data.class.getResource("/statics/header.png");
    public static URL UP_URL = Data.class.getResource("/statics/up.png");
    public static URL DOWN_URL = Data.class.getResource("/statics/down.png");
    public static URL LEFT_URL = Data.class.getResource("/statics/left.png");
    public static URL RIGHT_URL = Data.class.getResource("/statics/right.png");
    public static URL BODY_URL = Data.class.getResource("/statics/body.png");
    public static URL FOOD_URL = Data.class.getResource("/statics/food.png");
    public static ImageIcon header = new ImageIcon(HEAD_URL);
    public static ImageIcon up = new ImageIcon(UP_URL);
    public static ImageIcon down = new ImageIcon(DOWN_URL);
    public static ImageIcon left = new ImageIcon(LEFT_URL);
    public static ImageIcon right = new ImageIcon(RIGHT_URL);
    public static ImageIcon body = new ImageIcon(BODY_URL);
    public static ImageIcon food = new ImageIcon(FOOD_URL);

}
