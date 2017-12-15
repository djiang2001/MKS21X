import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Temperature extends JFrame implements ActionListener{
  
  private Container pane;
  private JButton b1,b2;
  private ButtonGroup B = new ButtonGroup();
  private JRadioButton cf,fc;
  private JTextField t;
  private JLabel l;

  public void actionPerformed (ActionEvent e){
    String s = e.getActionCommand();
    System.out.println(s);
    if(s.equals("Convert")){
      try{
        if(cf.isSelected()){
        t.setText(CtoF(Double.parseDouble(t.getText())) + "");
        }
        if(fc.isSelected()){
          t.setText(FtoC(Double.parseDouble(t.getText())) + "");
        }
      } catch(NumberFormatException a){
        t.setText("Enter Numerical Data");
      }
    }
    if(s.equals("Clear")){
      t.setText("");
    }
  }
    
  public Temperature(){
    this.setTitle("Temperature Conversion");
    this.setSize(600,400);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());

    l = new JLabel("Temperature");
    t = new JTextField(50);
    b1 = new JButton("Convert");
    b2 = new JButton("Clear");
    cf = new JRadioButton("Celsius to Fahrenheit");
    fc = new JRadioButton("Fahrenheit to Celsius");
    B.add(cf);
    B.add(fc);

    b1.addActionListener(this);
    b2.addActionListener(this);
    cf.addActionListener(this);
    fc.addActionListener(this);
    
    pane.add(l);
    pane.add(t);
    pane.add(b1);
    pane.add(b2);
    pane.add(cf);
    pane.add(fc);
    
  }

  public static double CtoF(double t){
    return t * 1.4 + 32;
  }

  public static double FtoC(double t){
    return (t - 32) * 5.0 / 9.0 ;
  }


  public static void main(String[]args){
    Temperature g = new Temperature();
    g.setVisible(true);
  }
}
