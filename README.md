# Borrow Book System (Java Swing GUI)

A Java Swing GUI desktop application for managing student registrations, book records, and book borrowing transactions (TK1143 Program Design & Problem Solving - Tutorial 5A, Section B).

## Project Structure

- `MainMenu.java` — Main entry point and navigation menu window (`Add Student Info`, `Add Book Info`, `Borrow Book`).
- `AddStudentInfo.java` — Form to register new `Student` objects and list all registered students.
- `AddBookInfo.java` — Form to register new `Book` objects and list all registered books.
- `BorrowBook.java` — Form allowing a student to borrow a book via `JComboBox` dropdowns and displaying borrow confirmation details.
- `Student.java` — Model class representing a student (`name`, `matric`, and `borrowedBook` reference).
- `Book.java` — Model class representing a book (`title`, `author`, `borrower` reference, and `borrowBy(Student)` logic).

## How to Compile & Run

1. Open a terminal inside the project folder.
2. Compile all Java files:
   ```bash
   javac *.java
   ```
3. Run the application:
   ```bash
   java MainMenu
   ```

## Usage Flow

1. Click **Add Student Info** to register one or more students, then click **List** to verify.
2. Click **Add Book Info** to register one or more books, then click **List** to verify.
3. Click **Borrow Book**, choose a student and a book from the dropdown lists, and click **Borrow**.
