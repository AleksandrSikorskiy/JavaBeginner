package org.example;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class JGradientButton extends JButton{
    Color color1 = Color.BLACK;
    Color color2 = Color.GREEN;
    JGradientButton(){
        super();
        setContentAreaFilled(false);
        setFocusPainted(false); // used for demonstration
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                color2 = (color2==Color.GREEN) ? Color.YELLOW : Color.YELLOW;
                //System.out.println(button.isSelected());
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setPaint(new GradientPaint(
                new Point(0, 0),
                color1,
                new Point(0, getHeight()/3),
                color2));
        g2.fillRect(0, 0, getWidth(), getHeight()/3);
        g2.setPaint(new GradientPaint(
                new Point(0, getHeight()/3),
                color2,
                new Point(0, getHeight()),
                color1));
        g2.fillRect(0, getHeight()/3, getWidth(), getHeight());
        g2.dispose();
        g2.dispose();

        super.paintComponent(g);
    }


}