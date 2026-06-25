# Online Examination System

Online Examination System is a web-based examination platform developed using Java Servlets, JSP, JDBC, and MySQL. It enables secure online examinations with role-based access for students and administrators, automatic evaluation, result management, and performance analysis using Power BI.

## Features

* User Authentication
* Student & Administrator Login
* Role-Based Access Control
* Online Timed Examination
* Multiple Choice Questions (MCQs)
* Automatic Score Calculation
* Exam Result Management
* MySQL Database Integration
* Power BI Performance Analysis

## Architecture

```text
                    +----------------------+
                    |      Browser         |
                    +----------+-----------+
                               |
                               ▼
                    +----------------------+
                    |   Apache Tomcat      |
                    +----------+-----------+
                               |
                +--------------+--------------+
                |                             |
                ▼                             ▼
         Java Servlets                  JSP Pages
                |
                ▼
              JDBC
                |
                ▼
        +------------------+
        |  MySQL Database  |
        +------------------+
```

## Tech Stack

* Java
* Java Servlets
* JSP
* JDBC
* MySQL
* HTML
* CSS
* JavaScript
* Apache Tomcat
* Power BI

## 🛠️ Technologies Used

| Technology    | Purpose                             |
| ------------- | ----------------------------------- |
| Java          | Core programming language           |
| Java Servlets | Backend request handling            |
| JSP           | Dynamic web page development        |
| JDBC          | Database connectivity               |
| MySQL         | Relational database management      |
| HTML          | Web page structure                  |
| CSS           | User interface styling              |
| JavaScript    | Client-side interactions            |
| Apache Tomcat | Application server                  |
| Power BI      | Performance analytics and reporting |

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
* Submit Examination
* View Results

### Administrator

* Manage Students
* Manage Exams
* Manage Questions
* View Examination Results
* Performance Analysis Dashboard

## Database

The application uses MySQL for persistent data storage.

Main database tables include:

* Users
* Exams
* Questions
* Answers
* Results

## Workflow

1. Student registers or logs into the system.
2. Administrator creates examinations and manages questions.
3. Student selects an available examination.
4. Student completes the timed examination.
5. Answers are evaluated automatically.
6. Results are stored in the MySQL database.
7. Performance reports are analyzed using Power BI.

## Power BI Analysis

Examination data is exported from the MySQL database and analyzed using Power BI.

The dashboard provides insights such as:

* Total Students
* Correct Answers
* Incorrect Answers
* Unattempted Questions
* Student Performance Statistics
* Score Distribution
* Overall Examination Analytics

## Getting Started

### Clone Repository

```bash
git clone https://github.com/koyaumamaheswar14-cmd/Online-Examination-System.git
```

### Requirements

* JDK 17 or later
* Apache Tomcat
* MySQL
* Eclipse IDE

### Run the Project

1. Clone the repository.
2. Import the project into Eclipse.
3. Configure Apache Tomcat.
4. Create the MySQL database.
5. Update the database credentials.
6. Run the project on the Tomcat server.
7. Access the application through your web browser.

## Future Improvements

* JWT Authentication & Authorization
* Email Notifications
* Question Categories
* Leaderboard
* Certificate Generation
* AI-Based Performance Analytics
* Responsive User Interface
* Online Proctoring Support

## Author

**Uma Maheswar Koya**

GitHub: https://github.com/koyaumamaheswar14-cmd
