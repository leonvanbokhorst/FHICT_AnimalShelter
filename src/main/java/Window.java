import animals.Animal;
import animals.Gender;
import interfaces.ISellable;
import managers.ReservationManager;
import managers.ShopManager;

import javax.swing.*;
import java.awt.event.*;

public class Window extends JDialog {
    private JPanel contentPane;
    private JTextField txtName;
    private JComboBox boxSpecies;
    private JRadioButton radioMale;
    private JRadioButton radioFemale;
    private JTextField txtBadHabits;
    private JButton btnAddAnimal;
    private JList listAnimals;
    private JButton btnReserve;
    private JTextField txtReserveName;
    private JTextField txtItemName;
    private JTextField txtItemPrice;
    private JList listItems;
    private JButton btnBuyItem;
    private JButton btnAddItem;
    private JList listCart;
    private JButton btnRemoveFromCart;

    private ReservationManager reservation;
    private ShopManager shopManager;

    private Window() {
        setContentPane(contentPane);
        setModal(true);

        registerEvents();
    }

    public static void main(String[] args) {
        Window dialog = new Window();
        dialog.pack();
        dialog.setVisible(true);

        System.exit(0);
    }

    private void registerEvents() {
        reservation = new ReservationManager();
        shopManager = new ShopManager();

        boxSpecies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean enabled = boxSpecies.getSelectedItem().toString() == "Cat";
                txtBadHabits.enableInputMethods(enabled);
            }
        });

        btnAddAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String species = boxSpecies.getSelectedItem().toString();
                String name = txtName.getText();
                Gender gender = radioMale.isSelected() ? Gender.MALE : Gender.FEMALE;

                if (species == "Cat") {
                    String badHabits = txtBadHabits.getText();

                    reservation.newCat(name, gender, badHabits);
                } else if (species == "Dog") {
                    reservation.newDog(name, gender);
                }

                reloadAnimalList();
            }
        });

        btnReserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Animal animal = (Animal) listAnimals.getSelectedValue();

                if (animal != null) {
                    String reserverName = txtReserveName.getText();

                    animal.reserve(reserverName);
                    shopManager.addItemToCart(animal);

                    reloadAnimalList();
                    reloadCartList();
                }
            }
        });

        btnAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String name = txtItemName.getText();
                    double price = Double.parseDouble(txtItemPrice.getText());
                    ISellable item = new ShopItem(name, price);

                    shopManager.addItem(item);
                    reloadItemList();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid price!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnBuyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                 ShopItem item = (ShopItem) listItems.getSelectedValue();

                if (item != null) {
                    shopManager.addItemToCart(item);
                    reloadCartList();
                }
            }
        });

        btnRemoveFromCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ISellable item = (ISellable) listCart.getSelectedValue();

                if (item != null) {
                    shopManager.removeItemFromCart(item);
                    reloadCartList();
                }
            }
        });
    }

    private void reloadAnimalList() {
        listAnimals.setListData(reservation.getAnimals().toArray());
    }

    private void reloadItemList() {
        listItems.setListData(shopManager.getItems().toArray());
    }

    private void reloadCartList() {
        listCart.setListData(shopManager.getCart().toArray());
    }
}
