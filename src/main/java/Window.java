import animals.Animal;
import animals.Gender;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

    private Reservation reservation;

    public Window() {
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
        reservation = new Reservation();

        boxSpecies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                boolean enabled = boxSpecies.getSelectedItem().toString() == "Cat";
                txtBadHabits.enableInputMethods(enabled);
            }
        });

        btnAddAnimal.addActionListener(new ActionListener() {
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

                reloadList();
            }
        });

        btnReserve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Animal animal = (Animal) listAnimals.getSelectedValue();

                if (animal != null) {
                    String reserverName = txtReserveName.getText();

                    animal.reserve(reserverName);
                    reloadList();
                }
            }
        });
    }

    private void reloadList() {
        listAnimals.setListData(reservation.getAnimals().toArray());
    }
}
