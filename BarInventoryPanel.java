

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class BarInventoryPanel extends JPanel {

    private JPanel barPanel;

    public BarInventoryPanel() {

        Border border = new LineBorder(Color.BLACK, 4, true);

        //Liquor Gui

        GridLayout layout = new GridLayout(10, 2);
        JPanel barPanel = new JPanel();
        barPanel.setLayout(layout);
        add(barPanel);


        barPanel.setBackground(Color.YELLOW);
        barPanel.setPreferredSize(new Dimension(350, 450));
        barPanel.setBorder(border);

        JLabel label = new JLabel("Liquor", SwingConstants.CENTER);
        label.setFont(new java.awt.Font("Arial", Font.ITALIC, 25));
        barPanel.add(label);

        String[] optionsToChoose = {"Whiskey", "Brandy", "Vodka", "Rum", "None of the listed"};
        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        JButton jButton = new JButton("Done");
        barPanel.add(jComboBox);
        barPanel.add(jButton);

        JButton jButton2 = new JButton("Done");
        JButton jButton3 = new JButton("Done");
        JButton jButton4 = new JButton("Done");

        barPanel.add(jButton2);
        barPanel.add(jButton3);
        barPanel.add(jButton4);
        //Beer Gui

        GridLayout layout2 = new GridLayout(10, 10);
        JPanel barPanel2 = new JPanel();
        barPanel2.setLayout(layout2);
        add(barPanel2);


        barPanel2.setBackground(Color.YELLOW);
        barPanel2.setPreferredSize(new Dimension(350, 450));
        barPanel2.setBorder(border);

        JLabel label2 = new JLabel("Beer", SwingConstants.CENTER);
        label2.setFont(new java.awt.Font("Arial", Font.ITALIC, 25));
        barPanel2.add(label2);

        //Other gui

        GridLayout layout3 = new GridLayout(10, 10);
        JPanel barPanel3 = new JPanel();
        barPanel3.setLayout(layout3);
        add(barPanel3);


        barPanel3.setBackground(Color.YELLOW);
        barPanel3.setPreferredSize(new Dimension(350, 450));
        barPanel3.setBorder(border);


        JLabel label3 = new JLabel("Other", SwingConstants.CENTER);
        label3.setFont(new java.awt.Font("Arial", Font.ITALIC, 25));
        barPanel3.add(label3);
    }
}
