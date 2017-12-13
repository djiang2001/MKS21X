import javax.swing.*;
import java.awt.*;
public class Temperature extends JFrame{
    private JButton b1;
    private JButton b2;
    private JLabel l;
    private JTextField t;
    
    public Temperature(){
	this.setTitle("Conversions");
	this.setSize(600,400);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	l = new JLabel("Input:");
	t = new JTextField(5);
	b1 = new JButton("Convert F to C");
	b2 = new JButton("Convert C to F");
    }

    public static void main(String[]args){
	Temperature g = new Temperature();
	g.setVisible(true);
    }
}
