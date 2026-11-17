import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBook extends JFrame implements ActionListener {
    private JComboBox<Student> cmbStudent;
    private JComboBox<Book> cmbBook;
    private JButton btnBorrow;
    private JLabel lblBorrowDetails;

    public BorrowBook() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        // Selection panel
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        formPanel.add(new JLabel("Student Name & Matric:"));
        cmbStudent = new JComboBox<>(MainMenu.studentList.toArray(new Student[0]));
        formPanel.add(cmbStudent);

        formPanel.add(new JLabel("Book Title & Author:"));
        cmbBook = new JComboBox<>(MainMenu.bookList.toArray(new Book[0]));
        formPanel.add(cmbBook);

        // Borrow button panel
        JPanel btnPanel = new JPanel(new FlowLayout());
        btnBorrow = new JButton("Borrow");
        btnBorrow.addActionListener(this);
        btnPanel.add(btnBorrow);

        JPanel northPanel = new JPanel(new BorderLayout(5, 5));
        northPanel.add(formPanel, BorderLayout.NORTH);
        northPanel.add(btnPanel, BorderLayout.SOUTH);

        // Borrow information display panel
        JPanel southPanel = new JPanel(new GridLayout(2, 1));
        southPanel.add(new JLabel("Borrow Information :"));
        lblBorrowDetails = new JLabel(" ");
        southPanel.add(lblBorrowDetails);

        pane.add(northPanel, BorderLayout.NORTH);
        pane.add(southPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBorrow) {
            Student selectedStudent = (Student) cmbStudent.getSelectedItem();
            Book selectedBook = (Book) cmbBook.getSelectedItem();

            if (selectedStudent != null && selectedBook != null) {
                String info = selectedBook.borrowBy(selectedStudent);
                lblBorrowDetails.setText(info);
            } else {
                JOptionPane.showMessageDialog(this, "Please register at least one student and one book first.");
            }
        }
    }
}
