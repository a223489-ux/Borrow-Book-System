import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenu extends JFrame implements ActionListener {
    private JButton btnAddStudent, btnAddBook, btnBorrowBook;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Book> bookList = new ArrayList<>();

    public MainMenu() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel("~~ BORROW BOOK SYSTEM ~~", SwingConstants.CENTER);
        btnAddStudent = new JButton("Add Student Info");
        btnAddBook = new JButton("Add Book Info");
        btnBorrowBook = new JButton("Borrow Book");

        btnAddStudent.addActionListener(this);
        btnAddBook.addActionListener(this);
        btnBorrowBook.addActionListener(this);

        pane.add(title);
        pane.add(btnAddStudent);
        pane.add(btnAddBook);
        pane.add(btnBorrowBook);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddStudent) {
            AddStudentInfo studentFrame = new AddStudentInfo();
            studentFrame.setTitle("Add Student Info");
            studentFrame.setSize(450, 280);
            studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            studentFrame.setLocationRelativeTo(this);
            studentFrame.setVisible(true);
        } else if (e.getSource() == btnAddBook) {
            AddBookInfo bookFrame = new AddBookInfo();
            bookFrame.setTitle("Add Book Info");
            bookFrame.setSize(450, 280);
            bookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            bookFrame.setLocationRelativeTo(this);
            bookFrame.setVisible(true);
        } else if (e.getSource() == btnBorrowBook) {
            BorrowBook borrowFrame = new BorrowBook();
            borrowFrame.setTitle("Borrow Book");
            borrowFrame.setSize(520, 280);
            borrowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            borrowFrame.setLocationRelativeTo(this);
            borrowFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setTitle("Main Menu");
        frame.setSize(320, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
