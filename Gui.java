import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;

public class Gui {

    GridBagConstraints gbc = new GridBagConstraints();
    JButton addButton = new JButton("Add");
    JButton remButton = new JButton("Remove");
    JButton filterBrand = new JButton("Filter Brand");
    JButton filterType = new JButton("Filter Type");
    JButton refreshButton = new JButton("Refresh");

    public Gui() {
        JFrame gui = new JFrame("Bar Inventory");
        JPanel panel = new JPanel();
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new GridBagLayout());

        JLabel title = new JLabel("Bar Inventory Manager");
        title.setFont(new Font("Helvetica", Font.BOLD, 24));
        title.setVerticalAlignment(JLabel.TOP);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(title, gbc);

        // Fonts for buttons
        addButton.setFont(new Font("Helvetica", Font.PLAIN, 12));
        remButton.setFont(new Font("Helvetica", Font.PLAIN, 12));
        filterBrand.setFont(new Font("Helvetica", Font.PLAIN, 12));
        filterType.setFont(new Font("Helvetica", Font.PLAIN, 12));
        refreshButton.setFont(new Font("Helvetica", Font.PLAIN, 12));

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

        // for adding a new drink
        Drinks testDrink = new Drinks(null, null, 0, 0);

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);

        for (Drinks drinks : drinksList) {
            tableModel.addRow(new String[]{drinks.getBrand(), drinks.getType(), drinks.getPrice(),
                    String.valueOf(drinks.getVolume())});
        }
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(scrollPane, gbc);

        // Add button logic
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, addPanel,
                        "Enter Values", JOptionPane.PLAIN_MESSAGE);
                testDrink.setBrand(brandField.getText());
                if (brandField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Field is blank!");
                }
                testDrink.setType(typeField.getText());
                testDrink.setPrice(Double.parseDouble(priceField.getText()));
                testDrink.setVolume(Integer.parseInt(volField.getText()));
                drinksList.add(testDrink);
                tableModel.setRowCount(0);
                for (Drinks drinks : drinksList) {
                    tableModel.addRow(new String[]{drinks.getBrand(), drinks.getType(), drinks.getPrice(),
                            String.valueOf(drinks.getVolume())});
                }
                System.out.println(drinksList);
            }
        });
        gbc.ipadx = 10;
        gbc.ipady = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 5;
        panel.add(addButton, gbc);

        //Select a row
        table.setRowSelectionAllowed(true);

        // Remove button logic
        remButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int drinkIndex = table.getSelectedRow();
                tableModel.removeRow(drinkIndex);
                drinksList.remove(drinkIndex);

                JOptionPane.showMessageDialog(null,"Deleted Row!");
                System.out.println(drinksList);
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(remButton, gbc);

        // Filter button logic
        filterType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filterType = JOptionPane.showInputDialog("Enter Type");
                tableModel.setRowCount(0);
                ArrayList<Drinks> tempList = Drinks.findType(drinksList, filterType);
                for (Drinks drinks : tempList) {
                    tableModel.addRow(new String[]{drinks.getBrand(), drinks.getType(), drinks.getPrice(),
                            String.valueOf(drinks.getVolume())});
                }
            }
        });

        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(filterType, gbc);

        // filter brand logic
        filterBrand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filter = JOptionPane.showInputDialog("Enter Brand");
                tableModel.setRowCount(0);
                ArrayList<Drinks> tempList = Drinks.findBrand(drinksList, filter);
                for (Drinks drinks : tempList) {
                    tableModel.addRow(new String[]{drinks.getBrand(), drinks.getType(), drinks.getPrice(),
                            String.valueOf(drinks.getVolume())});
                }
            }
        });
        gbc.gridx = 4;
        gbc.gridy = 0;
        panel.add(filterBrand, gbc);

        // Refresh button logic
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                for (Drinks drinks : drinksList) {
                    tableModel.addRow(new String[]{drinks.getBrand(), drinks.getType(), drinks.getPrice(),
                            String.valueOf(drinks.getVolume())});
                }
            }
        });
        gbc.gridx = 5;
        gbc.gridy = 0;
        panel.add(refreshButton, gbc);

        //Sort by column
        table.setAutoCreateRowSorter(true);


        gui.setSize(750, 600);
        gui.add(panel);
        gui.pack();
        gui.setVisible(true);
    }

    public static void main(String[] args) {
        new Gui();
    }
}
