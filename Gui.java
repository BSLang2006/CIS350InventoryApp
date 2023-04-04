import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;

public class Gui {

    GridBagConstraints gbc = new GridBagConstraints();
    JButton button = new JButton("Add");
    JButton button2 = new JButton("Remove");

    public Gui() {
        JFrame gui = new JFrame("Bar Inventory");
        JPanel panel = new JPanel();
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new GridBagLayout());
        //gbc.insets = new Insets(10,5,10,5);

        // for add button
        JLabel brandLabel = new JLabel("Brand");
        JLabel typeLabel = new JLabel("Type");
        JLabel priceLabel = new JLabel("Price");
        JLabel volLabel = new JLabel("Volume");
        JTextField brandField = new JTextField(10);
        JTextField typeField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JTextField volField = new JTextField(10);
        JPanel addPanel = new JPanel();
        addPanel.add(brandLabel);
        addPanel.add(brandField);
        addPanel.add(typeLabel);
        addPanel.add(typeField);
        addPanel.add(priceLabel);
        addPanel.add(priceField);
        addPanel.add(volLabel);
        addPanel.add(volField);

        String[] colNames = {"Brand", "Type", "Price", "Vol"};

        Drinks Smirnoff = new Drinks("Vodka", "Smirnoff", 12.00, 40);
        Drinks Ciroc = new Drinks("Vodka", "Ciroc", 12.00, 40);
        Drinks BombaySapphire = new Drinks("Gin", "Bombay", 14.00, 24);
        Drinks Patron = new Drinks("Tequila", "Patron", 15.00, 16);
        Drinks Jack = new Drinks("Whiskey", "Jack Daniels", 15.00, 40);

        ArrayList<Drinks> drinksList = new ArrayList<>();
        drinksList.add(Smirnoff);
        drinksList.add(Ciroc);
        drinksList.add(BombaySapphire);
        drinksList.add(Patron);
        drinksList.add(Jack);

        // testing adding a drink
        Drinks testDrink = new Drinks(null, null, 0, 0);

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);

        for (Drinks drinks : drinksList) {
            tableModel.addRow(new String[]{drinks.getBrand(), drinks.getType(), drinks.getPrice(),
                    String.valueOf(drinks.getVolume())});
        }
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                JOptionPane.showMessageDialog(null, addPanel,
                        "Enter Values", JOptionPane.INFORMATION_MESSAGE);
                testDrink.setBrand(brandField.getText());
                testDrink.setType(typeField.getText());
                testDrink.setPrice(Double.parseDouble(priceField.getText()));
                testDrink.setVolume(Integer.parseInt(volField.getText()));
                drinksList.add(testDrink);
                for (Drinks drinks : drinksList) {
                    tableModel.addRow(new String[]{drinks.getBrand(), drinks.getType(), drinks.getPrice(),
                            String.valueOf(drinks.getVolume())});
                }
                System.out.println(drinksList);
            }
        });
        //JButton button = new JButton("Add");
        gbc.ipadx = 10;
        gbc.ipady = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 5;
        //gbc.gridwidth = 5;
        //gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(button, gbc);

        //Select a row
        table.setRowSelectionAllowed(true);



        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tableModel.removeRow(table.getSelectedRow());
                drinksList.remove(table.getSelectedRow()+1);
                JOptionPane.showMessageDialog(null,"Deleted Row!");
                System.out.println(drinksList);
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(button2, gbc);

//                String[] sortOptions = {"brand", "type", "volume", "Price", "None"};
//                JComboBox<String> sortList = new JComboBox<String>(sortOptions);
//                gbc.gridx = 1;
//                gbc.gridy = 1;
//                panel.add(sortList, gbc);

        //Sort by column
        table.setAutoCreateRowSorter(true);


        gui.setSize(700, 600);
        gui.add(panel);
        gui.setVisible(true);


    }

    public static void main(String[] args) {
//            Border border = new LineBorder(Color.BLACK, 4, true);
//
//            //creates the frame for the GUI
//            JFrame gui = new JFrame("Bar Inventory");
//            gui.setLayout(new GridLayout(1, 2));
//            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            //Liquor Panel
//            LiquorInventoryPanel liquorPanel = new LiquorInventoryPanel();
//            liquorPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
//            liquorPanel.setBackground(Color.red);
//            liquorPanel.setBorder(border);
//
//
//            //Sets the title for the liquor panel
//            JLabel liquorLabel = new JLabel("Liquor", SwingConstants.CENTER);
//            liquorLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, 25));
//            liquorPanel.add(liquorLabel);
//
////        String[] optionsToChoose = {"Whiskey", "Brandy", "Vodka", "Rum", "None of the listed"};
////        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
////        panel.add(jComboBox);
//
//            //makes two textfields, one for the liquor information and the other
//            //for whatever inputs you want to put in.
//            JTextField textLiquor = new JTextField("The list of products will show here");
//            JTextField textLiquor1 = new JTextField("Enter Product");
//            //String inputText = textLiquor1.getText();
//            textLiquor.setPreferredSize(new Dimension(300, 350));
//            textLiquor.setBorder(border);
//            textLiquor.setEditable(false);
//
//            textLiquor1.setPreferredSize(new Dimension(100, 30));
//            textLiquor1.setBorder(border);
//
//            liquorPanel.add(textLiquor, textLiquor1);
//            liquorPanel.add(new JButton("add"));
//
//            //attempting to add the data to the gui
//            textLiquor.setToolTipText("Fill in the Blank");
//            gui.add(liquorPanel);
//
//            //Beer panel
//            BeerPanelClass beerPanel = new BeerPanelClass();
//            beerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
//            beerPanel.setBorder(border);
//            beerPanel.setBackground(Color.YELLOW);
//
//            JLabel beerLabel = new JLabel("Beer", SwingConstants.CENTER);
//            beerLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, 25));
//            beerPanel.add(beerLabel);
//
//            JTextField textBeer = new JTextField();
//            JTextField textBeer1 = new JTextField();
//
//            textBeer.setPreferredSize(new Dimension(300, 350));
//            textBeer.setBorder(border);
//            textBeer.setEditable(false);
//
//            textBeer1.setPreferredSize(new Dimension(100, 30));
//            textBeer1.setBorder(border);
//
//            beerPanel.add(textBeer, textBeer1);
//            beerPanel.add(new JButton("add"));
//            gui.add(beerPanel);
//
//            //NonAlcohol Panel
//            NonAlcoholPanelClass nonAlcoholPanel = new NonAlcoholPanelClass();
//            nonAlcoholPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
//            nonAlcoholPanel.setBorder(border);
//            nonAlcoholPanel.setBackground(Color.ORANGE);
//
//            JLabel nonAlcoholLabel = new JLabel("Non-Alcohol", SwingConstants.CENTER);
//            nonAlcoholLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, 25));
//            nonAlcoholPanel.add(nonAlcoholLabel);
//
//            JTextField textNonAlcohol = new JTextField();
//            JTextField textNonAlcohol1 = new JTextField();
//
//            textNonAlcohol.setPreferredSize(new Dimension(300, 350));
//            textNonAlcohol.setBorder(border);
//            textNonAlcohol.setEditable(false);
//
//            textNonAlcohol1.setPreferredSize(new Dimension(100, 30));
//            textNonAlcohol1.setBorder(border);
//
//            nonAlcoholPanel.add(textNonAlcohol, textNonAlcohol1);
//            nonAlcoholPanel.add(new JButton("add"));
//            gui.add(nonAlcoholPanel);
//
//            //build the gui
//
//            gui.setSize(1250, 500);
//            gui.setPreferredSize(new Dimension(1000, 500));
//            gui.setVisible(true);
//            gui.getContentPane().add(liquorPanel);
//            gui.getContentPane().add(beerPanel);
//            gui.getContentPane().add(nonAlcoholPanel);
//
        new Gui();

    }

}
