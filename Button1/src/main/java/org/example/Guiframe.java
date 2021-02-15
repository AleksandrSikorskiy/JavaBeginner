package org.example;

import javax.swing.*;
import java.awt.*;

public class Guiframe {
    // главный фрейм а также лефт райт топ даун и центр
    JFrame frame = new JFrame();
    JPanel paneltop = new JPanel();
    JPanel panelbottom = new JPanel();
    JPanel panelleft = new JPanel();
    JPanel panelrigth = new JPanel();
    JPanel panelcenter = new JPanel();
    // тестовое поле аналог мемо
    JTextArea textarearigth = new JTextArea(20, 14);
    JTextArea textareabottom = new JTextArea(20, 120);
    JTextArea textareacentr = new JTextArea(20, 92);
    //скролл в райт мемо
    JScrollPane scrollerright = new JScrollPane(textarearigth);
    // скролл в нижнем мемо
    JScrollPane scrollerbottom = new JScrollPane(textareabottom);
    // скролл в центральном мемо
    JScrollPane scrollercentr = new JScrollPane(textareacentr);
    // лабел и поля ввода
    JLabel labelsqlsrv = new JLabel("SQL Server:");
    JTextField fieldsqlsrv = new JTextField(18);
    JLabel labelport = new JLabel("Port:");
    JTextField fieldport = new JTextField(6);
    JLabel labeldatabase = new JLabel("DataBase:");
    JTextField fielddatabase = new JTextField(16);
    JLabel labelusername = new JLabel("UserName:");
    JTextField fieldusername = new JTextField(16);
    JLabel labelpass = new JLabel("Password:");
    JTextField fieldpass = new JTextField(16);
    //        кнопки
    JButton buttoncon = new JGradientButton();
    JButton buttondiscon = new JGradientButton();
    JButton buttongetver = new JGradientButton();
    JButton buttonactusr = new JGradientButton();
    JButton buttonlastlog = new JGradientButton();
    JButton buttongetdb = new JGradientButton();
    JButton buttongetinfo = new JGradientButton();
    JButton buttonrunsql = new JGradientButton();

    public static void main(String[] args) {
        Guiframe gui = new Guiframe();
        gui.frame.getContentPane().setLayout(new FlowLayout());
        gui.go();
    }

    public void go() {
//        UIManager.put("activeButton", new javax.swing.plaf.ColorUIResource(Color.DARK_GRAY));
//        JDialog.setDefaultLookAndFeelDecorated(true);
//        frame.setBackground(Color.DARK_GRAY);
        //скролл в райт мемо
        buttoncon.setText("Connect");
        buttondiscon.setText("Disconnect");
        buttongetver.setText("GetVersion");
        buttonactusr.setText("ActiveUser");
        buttonlastlog.setText("LastLogin");
        buttongetdb.setText("GetDataBase");
        buttongetinfo.setText("GetInfo");
        buttonrunsql.setText("RunSQLQuery");

        buttongetdb.setBackground(Color.black);
        textarearigth.setLineWrap(true);
        textarearigth.setBackground(Color.gray);
        scrollerright.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerright.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        // скролл в нижнем мемо
        textareabottom.setLineWrap(true);
        textareabottom.setBackground(Color.gray);
        scrollerbottom.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerbottom.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        // скролл в уцентральном мемо
        textareacentr.setLineWrap(true);
        textareacentr.setBackground(Color.gray);
        scrollercentr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollercentr.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        paneltop.setBackground(Color.DARK_GRAY);
        panelbottom.setBackground(Color.DARK_GRAY);
        panelleft.setBackground(Color.DARK_GRAY);
        panelrigth.setBackground(Color.DARK_GRAY);
        panelcenter.setBackground(Color.DARK_GRAY);
//      цвета label и textfield
        labeldatabase.setForeground(Color.gray);
        labelport.setForeground(Color.gray);
        labelsqlsrv.setForeground(Color.gray);
        labelusername.setForeground(Color.gray);
        labelpass.setForeground(Color.gray);
        fieldsqlsrv.setForeground(Color.gray);
        fielddatabase.setForeground(Color.gray);
        fieldport.setForeground(Color.gray);
        fieldusername.setForeground(Color.gray);
        fieldpass.setForeground(Color.gray);
        fieldsqlsrv.setBackground(Color.DARK_GRAY);
        fielddatabase.setBackground(Color.DARK_GRAY);
        fieldport.setBackground(Color.DARK_GRAY);
        fieldusername.setBackground(Color.DARK_GRAY);
        fieldpass.setBackground(Color.DARK_GRAY);
// добавление лабел и полей ввода на верхнюю панель
        paneltop.add(labelsqlsrv);
        paneltop.add(fieldsqlsrv);
        paneltop.add(labelport);
        paneltop.add(fieldport);
        paneltop.add(labeldatabase);
        paneltop.add(fielddatabase);
        paneltop.add(labelusername);
        paneltop.add(fieldusername);
        paneltop.add(labelpass);
        paneltop.add(fieldpass);
//        scrollerbottom.setBounds(10, 53, 927, 480);
//        panelbottom.add(scrollerbottom);
//        добавление скорр в нижний мемо
        panelbottom.add(scrollerbottom);

//        panelleft.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        ширина и высота левой панели
        panelleft.setLayout(new GridLayout(10, 1));
//        panelleft.setLayout(new BoxLayout(panelleft, BoxLayout.Y_AXIS));
//        добавление кнопок на левую панель

        panelleft.add(buttoncon);
        panelleft.add(buttondiscon);
        panelleft.add(buttongetver);
        panelleft.add(buttongetdb);
        panelleft.add(buttongetinfo);
        panelleft.add(buttonactusr);
        panelleft.add(buttonlastlog);
        panelleft.add(buttonrunsql);

// добавление скрола в центральную панель
        panelcenter.add(scrollercentr);
//добавление скрола в правую панель
        panelrigth.add(scrollerright);
//        определение закрытия окна
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.NORTH, paneltop);
        frame.getContentPane().add(BorderLayout.EAST, panelrigth);
        frame.getContentPane().add(BorderLayout.WEST, panelleft);
        frame.getContentPane().add(BorderLayout.CENTER, panelcenter);
        frame.getContentPane().add(BorderLayout.SOUTH, panelbottom);
//        главное окно на весь экран и показать его
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
