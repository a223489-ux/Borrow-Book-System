import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookInfo extends JFrame implements ActionListener {
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtAreaBooks;

    public AddBookInfo() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(5, 5));

        // Top input panel
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        topPanel.add(new JLabel("Book Title:"));
        txtTitle = new JTextField(20);
        topPanel.add(txtTitle);

        topPanel.add(new JLabel("Author:"));
        txtAuthor = new JTextField(20);
        topPanel.add(txtAuthor);

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
        bottomPanel.add(new JLabel("Books:"), BorderLayout.NORTH);
        txtAreaBooks = new JTextArea(6, 35);
        txtAreaBooks.setEditable(false);
        bottomPanel.add(new JScrollPane(txtAreaBooks), BorderLayout.CENTER);

        pane.add(northContainer, BorderLayout.NORTH);
        pane.add(bottomPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            if (!title.isEmpty() && !author.isEmpty()) {
                Book b = new Book(title, author);
                MainMenu.bookList.add(b);
                txtTitle.setText("");
                txtAuthor.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter both Book Title and Author.");
            }
        } else if (e.getSource() == btnList) {
            txtAreaBooks.setText("");
            for (Book b : MainMenu.bookList) {
                txtAreaBooks.append("Book title : " + b.getTitle()
                        + " (Author : " + b.getAuthor() + ")\n");
            }
        }
    }
}
