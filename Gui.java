

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Gui {
    public static  void main (String[] args) {

        Border border = new LineBorder(Color.BLACK, 4, true);

        //creates the frame to the GUI
        JFrame gui = new JFrame("Bar Inventory");
        gui.setLayout(new GridLayout(1,2));
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //This is the creation of the first panel along with giving it a colored background.
        BarInventoryPanel liquorPanel = new BarInventoryPanel();
        gui.getContentPane().add(liquorPanel);
        liquorPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,0));
        liquorPanel.setBackground(Color.GREEN);
        liquorPanel.setBorder(border);

        //Sets the title for the liquor panel
        JLabel label = new JLabel("Liquor", SwingConstants.CENTER);
        label.setFont(new java.awt.Font("Arial", Font.ITALIC, 25));
        liquorPanel.add(label);

//        String[] optionsToChoose = {"Whiskey", "Brandy", "Vodka", "Rum", "None of the listed"};
//        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
//        panel.add(jComboBox);

        //makes two textfedields, one for the liquor information and the other
        //for whatever inputs you want to put in.
        JTextField textLiquor = new JTextField();
        JTextField textLiquor1 = new JTextField();

        textLiquor.setPreferredSize(new Dimension(300,350));
        textLiquor1.setPreferredSize(new Dimension(100,30));

        textLiquor.setBorder(border);
        textLiquor1.setBorder(border);

        textLiquor.setEditable(false);

        liquorPanel.add(textLiquor);
        liquorPanel.add(textLiquor1);

        liquorPanel.add(new JButton("add"));

        //Everything on the second panel
        BeerPanelClass beerPanel = new BeerPanelClass();
        gui.getContentPane().add(beerPanel);
        beerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,0));
        beerPanel.setBorder(border);

        JLabel label1 = new JLabel("Beer", SwingConstants.CENTER);
        label1.setFont(new java.awt.Font("Arial", Font.ITALIC, 25));
        beerPanel.setBackground(Color.YELLOW);
        beerPanel.add(label1);

        JTextField textBeer = new JTextField();
        JTextField textBeer1 = new JTextField();

        textBeer.setPreferredSize(new Dimension(300,350));
        textBeer1.setPreferredSize(new Dimension(100,30));

        textBeer.setBorder(border);
        textBeer1.setBorder(border);

        textBeer.setEditable(false);

        beerPanel.add(textBeer);
        beerPanel.add(textBeer1);

        beerPanel.add(new JButton("add"));

        //Everything on the thrid panel
        OtherPanelClass otherPanel = new OtherPanelClass();
        gui.getContentPane().add(otherPanel);
        otherPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,0));
        otherPanel.setBorder(border);

        JLabel label2 = new JLabel("Other", SwingConstants.CENTER);
        label2.setFont(new java.awt.Font("Arial", Font.ITALIC, 25));
        otherPanel.setBackground(Color.ORANGE);
        otherPanel.add(label2);

        JTextField textOther = new JTextField();
        JTextField textOther1 = new JTextField();

        textOther.setPreferredSize(new Dimension(300,350));
        textOther1.setPreferredSize(new Dimension(100,30));

        textOther.setBorder(border);
        textOther1.setBorder(border);

        textOther.setEditable(false);

        otherPanel.add(textOther);
        otherPanel.add(textOther1);

        otherPanel.add(new JButton("add"));

        gui.setSize(1250, 500);
        gui.setPreferredSize(new Dimension(1000, 500));
        gui.setVisible(true);

    }

}
