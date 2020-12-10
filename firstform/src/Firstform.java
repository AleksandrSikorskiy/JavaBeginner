import javax.swing.*;

 class Firstform extends JFrame{
    private JPanel mainPanel;
    public Firstform  (String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main(String[] arg){
        JFrame frame=new Firstform("My First Form");
        frame.setVisible(true);
    }
}
