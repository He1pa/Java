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