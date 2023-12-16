Description
This full-stack application is developed using Java, Spring Boot, and Thymeleaf, with Spring Security 
for authentication and authorization. It is designed to facilitate the booking of a single apartment for 
extended stays. The application features a user registration and login system, allowing customers to book 
apartments. Additionally, it supports different user roles, including employees and administrators, with varying 
levels of access and functionality. Employees can view a list of existing reservations, while administrators have
the authority to cancel reservations.

Installation Instructions
To set up the application, follow these steps:

Navigate to the "sql scripts" directory within the app backend.
Run the provided SQL script to initialize the database with necessary tables and default data.
Open the project in an IDE of your choice.
Run the application.
Navigate to http://localhost:8080/ in your browser to access the application.

Usage
The application comes with three pre-created users for testing purposes:

John (Customer):
Username: John
Password: hello123

Mary (Employee):
Username: Mary
Password: hello123

Susan (Administrator):
Username: Susan
Password: hello123

A default reservation is also created by the SQL script for demonstration purposes.

Features
New User Registration: Register as a new user with customer authorization to create reservations.
Login: Log in using the provided default usernames and passwords to view specific functionalities based on user roles.
Reservation Management:
Customers can create new reservations.
Employees can view all existing reservations.
Administrators can view and cancel reservations.