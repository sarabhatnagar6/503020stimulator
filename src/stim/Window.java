package stim;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.*;
import java.awt.*;



public class Window {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel origLabel = new JLabel();
    JLabel infoLabel = new JLabel();
    JTextField moneyBox = new JTextField(15);
    Stimulation alg;
    JTextArea output = new JTextArea();
    JButton enter = new JButton("Enter");
    JButton home = new JButton("Home");
    JButton all = new JButton("History");
    

    
    public Window(){
        panel.add(output);
        output.setVisible(false);
        setFrame();
		setLabels(origLabel, 250, 10, 500, 80, 50, "Savings Manager");
        setLabels(infoLabel, 175, 80, 800, 50, 20,"Enter your salary or an amount of money in the box below" );
        moneyBox.setBounds(200, 200, 500,50);
        panel.add(moneyBox);
        frame.setVisible(true);
        enter.setBounds(400,300,100,60);
        enter.addActionListener(clicked);
        all.setVisible(true);
        all.setBounds(400,380,100,60);
        all.addActionListener(click);
        home.addActionListener(clickHome);
        panel.add(enter);
        enter.setVisible(true);
        home.setBounds(400,300,100,60);
        home.addActionListener(clicked);
        panel.add(home);
        home.setVisible(false);
        panel.add(all);

        
    }

    public void setFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,500);
        panel.setLayout(null);
        frame.add(panel);
        frame.setResizable(false); 
		frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    public void setLabels(JLabel label, int x, int y, int w, int h, int size, String text){
        label.setFont(new Font("Serif", Font.BOLD, size)); 
        label.setText(text);
        label.setBounds(x,y,w,h);
        panel.add(label);
        
    }

    
    ActionListener clicked = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        alg = new Stimulation(moneyBox, output);
        enter.setVisible(false);
        home.setVisible(true);
        panel.revalidate();
        panel.repaint();
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(frame, "Enter a valid number\nEx: 5000");
        }

    }
};

    ActionListener clickHome = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        enter.setVisible(true);
        home.setVisible(false);
        output.setVisible(false);
        output.setText("");
        moneyBox.setText("");
        moneyBox.setVisible(true);
        panel.revalidate();
        panel.repaint();


    }
};
    ActionListener click = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if (moneyBox.isVisible()){
                moneyBox.setVisible(false);
            }
            if(!output.isVisible()){
                output.setVisible(true);
            }
            alg.totalCosts(output);
            enter.setVisible(false);
            home.setVisible(true);
        }
    };


}
