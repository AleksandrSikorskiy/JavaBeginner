package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircleBtn extends JButton {
    Color color1 = Color.BLACK;
    Color color2 = Color.GREEN;
    public CircleBtn() {
        super();
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
        setFocusPainted(false); // used for demonstration
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                color2 = (color2==Color.GREEN) ? Color.YELLOW : Color.YELLOW;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
       Color color01 =Color.GREEN;
       Color color02 =Color.BLACK;
//        if (getModel().isRollover()) {
//            color01=Color.GREEN;
//            color02=Color.ORANGE;
//        }
        if (getModel().isSelected()) {
            color01=Color.cyan;
            color02=Color.blue;
        }
        if (getModel().isArmed()) {
            color01=Color.orange;
            color02=Color.RED;
        }
        if (getModel().isPressed()) {
            color01=Color.CYAN;
            color02=Color.BLACK;
        }
        setForeground(color02);
        g.setColor(color02);
        g.fillOval(0, 0, getSize().width - 2, getSize().height - 2);
        g.setColor(color01);
        g.fillOval(3, 3, getSize().width - 7, getSize().height - 7);
        g.setColor(color02);
        g.fillOval(6, 6, getSize().width - 13, getSize().height - 13);
        g.setColor(color01);
        g.fillRect((getSize().width /2)-2, (getSize().height/2)-5, 5, 10);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 2, getSize().height - 2);
    }
}