import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;

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

        Drinks smirnoff = new Drinks("Vodka", "Smirnoff", 12.00, 40);
        Drinks ciroc = new Drinks("Vodka", "Ciroc", 12.00, 40);
        Drinks bombaySapphire = new Drinks("Gin", "Bombay", 14.00, 24);
        Drinks patron = new Drinks("Tequila", "Patron", 15.00, 16);
        Drinks jack = new Drinks("Whiskey", "Jack Daniels", 15.00, 40);

        ArrayList<Drinks> drinksList = new ArrayList<>();
        drinksList.add(smirnoff);
        drinksList.add(ciroc);
        drinksList.add(bombaySapphire);
        drinksList.add(patron);
        drinksList.add(jack);

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);

        for (Drinks drinks : drinksList) {
            tableModel.addRow(new String[]{drinks.getBrand(),
                    drinks.getType(), drinks.getPrice(),
                    String.valueOf(drinks.getVolume())});
        }
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(scrollPane, gbc);

        // Array of valid drink types
        String[] drinkTypes = {"vodka", "gin", "whiskey", "wine",
                "beer", "champagne", "tequila"};

        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {

                if (e.getType() == TableModelEvent.UPDATE) {

                    int row = e.getFirstRow();
                    int col = e.getColumn();

                    Drinks d = drinksList.get(row);
                    Object o = tableModel.getValueAt(row, col);

                    if (col == 0) {
                        d.setBrand(o.toString());
                    } else if (col == 1) {
                        d.setType(o.toString());
                    } else if (col == 2) {
                        d.setPrice(Double.parseDouble(o.toString()));
                    } else if (col == 3) {
                        d.setVolume(Integer.parseInt(o.toString()));
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        });

        // Add button logic
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // for adding a new drink
                Drinks tempDrink = new Drinks(null, null, 0, 0);
                boolean test = true;
                JOptionPane.showMessageDialog(null, addPanel,
                        "Enter Values", JOptionPane.PLAIN_MESSAGE);
                while (test) {
                    try {
                        tempDrink.setBrand(brandField.getText().toLowerCase()
                                .substring(0, 1).toUpperCase()
                                + brandField.getText()
                                .toLowerCase().substring(1));
                        if (brandField.getText().equals("")) {
                            throw new IllegalArgumentException();
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null,
                                "Brand field is blank");
                        break;
                    }
                    try {
                        tempDrink.setType(typeField.getText().toLowerCase()
                                .substring(0, 1).toUpperCase()
                                + typeField.getText()
                                .toLowerCase().substring(1));
                        if (typeField.getText().equals("")) {
                            throw new IllegalArgumentException();
                        } else if (!Arrays.asList(drinkTypes)
                                .contains(tempDrink.getType().toLowerCase())) {
                            throw new IllegalArgumentException();
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null,
                                "Invalid drink type");
                        break;
                    }
                    try {
                        tempDrink.setPrice(Double
                                .parseDouble(priceField.getText()));
                        if (priceField.getText().equals("")) {
                            throw new IllegalArgumentException();
                        }
                        if (Double.parseDouble(priceField.getText()) < 0.0) {
                            throw new IllegalArgumentException();
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null,
                                "Error in price field");
                        break;
                    }
                    try {
                        tempDrink.setVolume(Integer
                                .parseInt(volField.getText()));
                        if (volField.getText().equals("")) {
                            throw new IllegalArgumentException();
                        }
                        if (Integer.parseInt(volField.getText()) < 0) {
                            throw new IllegalArgumentException();
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null,
                                "Error in volume field");
                        break;
                    }
                    drinksList.add(tempDrink);
                    tableModel.setRowCount(0);
                    for (Drinks drinks : drinksList) {
                        tableModel.addRow(new String[]{drinks.getBrand(),
                                drinks.getType(), drinks.getPrice(),
                                String.valueOf(drinks.getVolume())});
                    }
                    test = false;
                }
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

                try {
                    int drinkIndex = table.getSelectedRow();
                    if (drinkIndex != -1) {
                        tableModel.removeRow(drinkIndex);
                        drinksList.remove(drinkIndex);
                        JOptionPane.showMessageDialog(null, "Deleted Row!");
//                        System.out.println(drinksList);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,
                            "You must select a row first!");
                }
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(remButton, gbc);

        // Filter button logic
        filterType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter;
                boolean test = true;
                while (test) {
                    try {
                        filter = JOptionPane.showInputDialog("Enter Type");
                        if (filter.equals("")) {
                            throw new IllegalArgumentException();
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Error");
                        break;
                    }
                    tableModel.setRowCount(0);
                    ArrayList<Drinks> tempList =
                            Drinks.findType(drinksList, filter);
                    for (Drinks drinks : tempList) {
                        tableModel.addRow(new String[]{drinks.getBrand(),
                                drinks.getType(), drinks.getPrice(),
                                String.valueOf(drinks.getVolume())});
                    }
                    test = false;
                }
            }
        });

        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(filterType, gbc);

        // filter brand logic
        filterBrand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filter;
                boolean test = true;
                while (test) {
                    try {
                        filter = JOptionPane.showInputDialog("Enter Brand");
                        if (filter.equals("")) {
                            throw new IllegalArgumentException();
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null,
                                "Text field is blank");
                        break;
                    }
                    tableModel.setRowCount(0);
                    ArrayList<Drinks> tempList =
                            Drinks.findBrand(drinksList, filter);
                    for (Drinks drinks : tempList) {
                        tableModel.addRow(new String[]{drinks.getBrand(),
                                drinks.getType(), drinks.getPrice(),
                                String.valueOf(drinks.getVolume())});
                    }
                    test = false;
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
                    tableModel.addRow(new String[]{drinks.getBrand(),
                            drinks.getType(), drinks.getPrice(),
                            String.valueOf(drinks.getVolume())});
                }
            }
        });
        gbc.gridx = 5;
        gbc.gridy = 0;
        panel.add(refreshButton, gbc);

        //Sort by column
        table.setAutoCreateRowSorter(true);

        gui.setSize(1000, 550);
        gui.add(panel);
        //gui.pack();
        gui.setVisible(true);
    }

    public static void main(String[] args) {
        new Gui();
    }
}
