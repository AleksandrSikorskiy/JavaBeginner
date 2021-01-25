package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SimpleGui1Bevent implements ActionListener {
//    MouseListener WindowListener
//    mousePressed mouseMoved mouseReleased
    JButton button;

    public static void main( String[] args ) {
        SimpleGui1Bevent gui = new SimpleGui1Bevent();
        gui.go();
    }
    public void go() {
//        JRadioButton JCheckBox JLabel JList JScrollPane JSlider JTextArea JTextField JTable
// actionPerformed
       JFrame frame= new JFrame();
       JPanel panel = new JPanel();
       button= new JButton("click me");
//       button.setBounds(150, 150, 80, 40);
        button.setPreferredSize(new Dimension(160, 40));
       panel.add(button);
       frame.setContentPane(panel);
       button.addActionListener(this);
//       addKeyListener

//       frame.getContentPane().add(button);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800,500);
       frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        windowClosing actionPerformed ItemStateChanged mousePressed keyTyped  mouseExited focusGained
//        MouseEvent KeyEvent WindowEvent
        button.setText("I clicked");
    }
}
