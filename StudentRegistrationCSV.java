import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class StudentRegistrationCSV {

    public static void main(String[] args) {

        JFrame f = new JFrame("Student Registration Form");
        f.setSize(400, 250);
        f.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel l1 = new JLabel("Student Name:");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("Email:"); //exeception shld be addde
        JTextField t2 = new JTextField();

        JLabel l3 = new JLabel("Course:");
        JTextField t3 = new JTextField();

        JButton b1 = new JButton("Register");

        // Add components
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(t3);
        f.add(new JLabel()); f.add(b1);

        // Button Action
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                String email = t2.getText();
                String course = t3.getText();

                try {
                    FileWriter fw = new FileWriter("students.csv", true);
                    fw.write(name + "," + email + "," + course + "\n");
                    fw.close();

                    JOptionPane.showMessageDialog(f, "Student Registered Successfully!");

                    // Clear fields
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(f, "Error saving data");
                }
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}