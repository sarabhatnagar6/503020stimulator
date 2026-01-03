package stim;
import javax.swing.*;
import java.awt.*;


public class Stimulation {
    String userInput;
    int money;
    double save;
    double needs;
    double wants;
    double totalSave;
    double totalWants;
    double totalNeeds;

    public Stimulation(JTextField box, JTextArea output){
        userInput = box.getText();
        money = Integer.parseInt(userInput);
        setMoney();
        box.setVisible(false);
        output.setEditable(false);
        output.setBounds(200,200,500,100);
        output.setFont(new Font("Serif", Font.BOLD, 24));


        output.setText(
        "You should save " + save + " dollars\n" +
        "You should spend " + wants + " dollars on your wants\n" +
        "You should spend " + needs + " dollars on your needs");
        output.setVisible(true);
    }

    public void setMoney(){
        needs = (int)(0.5 * money);
        wants = (int)(0.2 * money);
        save = (int)(0.3 * money);
        totalNeeds+=needs;
        totalWants+=wants;
        totalSave+=save;

    }

    public double getNeeds(){
        return needs;
    }

    public double getSave(){
        return save;
    }

    public double getWants(){
        return wants;
    }

    public void totalCosts(JTextArea t){
        t.setText(
            "You should have " + totalNeeds + " dollars total for your needs\n" +
            "You should have " + totalSave + " dollars total saved\n" +
            "You should have " + totalWants + " dollars for your wants"
        );

    }
}
