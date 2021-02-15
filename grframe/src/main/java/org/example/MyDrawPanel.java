package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class MyDrawPanel extends JPanel {
    int xc=0;
    int yc=0;
    public void paintComponent(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(xc, yc, 100, 100);
    }
    public void getxc(int xi){
        xc=xi;
    }
    public void getyc(int yi){
        yc=yi;
    }

}

