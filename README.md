# Online Examination System

A web-based Online Examination System developed using Java Servlets, JSP, JDBC, and MySQL. The application enables students to take online examinations securely while allowing administrators to manage exams, questions, and users.

## Features

* User Authentication
* Student & Admin Login
* Role-Based Access Control
* Online Timed Examination
* Multiple Choice Questions (MCQs)
* Automatic Score Calculation
* Exam Result Management
* MySQL Database Integration
* Power BI Performance Analysis

## Tech Stack

* Java
* Java Servlets
* JSP
* JDBC
* MySQL
* HTML
* CSS
* JavaScript
* Power BI
* Apache Tomcat

## Project Structure

```text
OnlineExaminationSystem/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── nexlink/
│       │           ├── controllers/
│       │           ├── dao/
│       │           ├── model/
│       │           └── util/
│       └── webapp/
│           ├── css/
│           ├── js/
│           ├── images/
│           ├── WEB-INF/
│           └── *.jsp
│
├── build/
└── README.md
```

## Modules

### Student

* Register
* Login
* View Available Exams
* Start Examination
* Submit Exam
* View Results

### Administrator

* Manage Students
* Manage Exams
* Manage Questions
* View Exam Results
* Performance Analysis

## Database

* Users
* Exams
* Questions
* Answers
* Results

## Power BI Analysis

Examination data exported from the database was analyzed using Power BI.

Analysis includes:

* Correct Answers
* Incorrect Answers
* Unattempted Questions
* Student Performance Statistics

## Getting Started

### Clone Repository

```bash
git clone https://github.com/koyaumamaheswar14-cmd/Online-Examination-System.git
```

### Requirements

* JDK 17+
* Apache Tomcat
* MySQL
* Eclipse IDE

### Run Project

1. Import the project into Eclipse.
2. Configure Apache Tomcat.
3. Create the MySQL database.
4. Update database credentials.
5. Run the project on Tomcat.

## Future Improvements

* Email Notifications
* JWT Authentication
* Question Categories
* Leaderboard
* Certificate Generation
* AI-based Performance Analytics

## Author

**Uma Maheswar Koya**

GitHub: https://github.com/koyaumamaheswar14-cmd
