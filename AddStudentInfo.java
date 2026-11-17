import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentInfo extends JFrame implements ActionListener {
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtAreaStudents;

    public AddStudentInfo() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(5, 5));

        // Top input panel
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        topPanel.add(new JLabel("Name:"));
        txtName = new JTextField(20);
        topPanel.add(txtName);

        topPanel.add(new JLabel("Matric:"));
        txtMatric = new JTextField(20);
        topPanel.add(txtMatric);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnList);

        JPanel northContainer = new JPanel(new BorderLayout());
        northContainer.add(topPanel, BorderLayout.NORTH);
        northContainer.add(buttonPanel, BorderLayout.SOUTH);

        // Bottom output area
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(new JLabel("Students:"), BorderLayout.NORTH);
        txtAreaStudents = new JTextArea(6, 35);
        txtAreaStudents.setEditable(false);
        bottomPanel.add(new JScrollPane(txtAreaStudents), BorderLayout.CENTER);

        pane.add(northContainer, BorderLayout.NORTH);
        pane.add(bottomPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();
            if (!name.isEmpty() && !matric.isEmpty()) {
                Student s = new Student(name, matric);
                MainMenu.studentList.add(s);
                txtName.setText("");
                txtMatric.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter both Name and Matric.");
            }
        } else if (e.getSource() == btnList) {
            txtAreaStudents.setText("");
            for (Student s : MainMenu.studentList) {
                txtAreaStudents.append("Name : " + s.toString() + "\n");
            }
        }
    }
}
