# Borrow Book System (Java Swing GUI)

A Java Swing GUI desktop application for managing student registrations, book records, and book borrowing transactions
# Project Structure

- `MainMenu.java` — Main entry point and navigation menu window (`Add Student Info`, `Add Book Info`, `Borrow Book`).
- `AddStudentInfo.java` — Form to register new `Student` objects and list all registered students.
- `AddBookInfo.java` — Form to register new `Book` objects and list all registered books.
- `BorrowBook.java` — Form allowing a student to borrow a book via `JComboBox` dropdowns and displaying borrow confirmation details.
- `Student.java` — Model class representing a student (`name`, `matric`, and `borrowedBook` reference).
- `Book.java` — Model class representing a book (`title`, `author`, `borrower` reference, and `borrowBy(Student)` logic).


