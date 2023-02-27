

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;


public class Gui {
    public static  void main (String[] args) {

//		BarInventoryPanel panel2 = new BarInventoryPanel();
//		BarInventoryPanel panel3 = new BarInventoryPanel();

        JFrame gui = new JFrame("Bar Inventory");

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BarInventoryPanel panel = new BarInventoryPanel();
        gui.getContentPane().add(panel);

        gui.setSize(1250, 500);
        gui.setPreferredSize(new Dimension(1000, 500));
        gui.setVisible(true);
    }

}
