import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class onJLabel {


}
public class GXOForm extends JFrame {

    private JPanel mainPanel;
    private JLabel XY00;
    private JLabel XY10;
    private JLabel XY20;
    private JLabel XY01;
    private JLabel XY11;
    private JLabel XY21;
    private JLabel XY02;
    private JLabel XY12;
    private JLabel XY22;
    String[] arrxo=new String[9];
    String charX="X";
    String charD=".";

    public void onclickJLabel(JLabel vJLabel) {
        if (vJLabel.getText().equals(charD)) {vJLabel.setText(charX);}
    }

    public GXOForm(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        XY00.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
               GXOForm.onclickJLabel(XY00);
            }
        });
        XY10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                onJLabel.onclickJLabel(XY10);
            }
        });
        XY20.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                onJLabel.onclickJLabel(XY20);
            }
        });
        XY01.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                onJLabel.onclickJLabel(XY01);
            }
        });        XY11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (XY11.getText().equals(".")) {XY11.setText(charX);}
            }
        });        XY21.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (XY21.getText().equals(".")) {XY21.setText(charX);}
            }
        });        XY02.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (XY02.getText().equals(".")) {XY02.setText(charX);}
            }
        });        XY12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (XY12.getText().equals(".")) {XY12.setText(charX);}
            }
        });        XY22.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (XY22.getText().equals(".")) {XY22.setText(charX);}
            }
        });
    }

    public static void main(String[] arg){
        JFrame frame=new GXOForm("Крестики нолики");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
