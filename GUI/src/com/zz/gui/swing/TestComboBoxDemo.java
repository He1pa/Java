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
