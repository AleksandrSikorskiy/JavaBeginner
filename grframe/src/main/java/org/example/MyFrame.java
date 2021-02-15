package org.example;

import javax.swing.*;
import java.awt.*;

public class MyFrame {
    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(drawPanel);

        frame.setSize(800, 500);
        frame.setVisible(true);
        int x=70; int y=70;
        for (int i = 0; i < 130; i++) {
            x++;
            y++;
            drawPanel.getxc(x);
            drawPanel.getyc(y);
            drawPanel.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
            }
        }


    }
}
