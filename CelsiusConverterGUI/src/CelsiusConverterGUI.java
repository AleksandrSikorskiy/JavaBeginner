import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusConverterGUI extends JFrame{
    private JPanel mainPanel;
    private JTextField celsiusTextField;
    private JLabel celsiusLabel;
    private JButton celsiusButton;
    private JLabel farenheitLabel;

    public CelsiusConverterGUI  (String title) {
            super(title);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.pack();
        celsiusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int farenheit= (int) ((Double.parseDouble(celsiusTextField.getText()))*1.8+32);
                farenheitLabel.setText(farenheit+" Farenheit");
            }
        });
    }

        public static void main(String[] arg){
            JFrame frame=new CelsiusConverterGUI("My First Form");
            frame.setVisible(true);
        }



}
