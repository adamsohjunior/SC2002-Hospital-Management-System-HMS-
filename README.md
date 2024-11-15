# Hospital Management System (HMS)

** NTU College of Computing and Data Science**

## SC2002 Assignment | SCS6 GROUP 5

<p align="center">
  <img src="readme_cover.png" alt="Cover"/>
</p>


## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
    - [Patient](#patient)
    - [Doctor](#doctor)
    - [Pharmacist](#pharmacist)
    - [Administrator](#administrator)
3. [Assumptions](#assumptions)
4. [Additional Features](#additional-features)
5. [Installation](#installation)
6. [Running the Application](#running-the-application)
7. [UML Class Diagram](#uml-class-diagram)
8. [Team Members](#team-members)
9. [License](#license)
10. [Contact](#contact)
11. [Disclaimer](#disclaimer)

---

## Project Overview

Hospital Management System (HMS) is a Java-based console application developed for the SC2002 course assignment. Designed with maintainability and modularity in mind, HMS streamlines hospital operations by managing core functions such as appointment scheduling, inventory management, and staff administration. The system caters to different user roles including patients, doctors, pharmacists, and administrators, ensuring adaptability and scalability for future enhancements. HMS aims to improve hospital resource utilization, enhance patient care, and simplify administrative tasks through an efficient command-line interface.

---

## Features

### **Patient**
- **Profile Management:** Access personal and medical information.
- **Secure Authentication:** Change password with strength validation.
- **Appointment Handling:** Schedule, reschedule, or cancel appointments with doctors.
- **Medical Records:** View diagnoses, treatments, and prescriptions.
- **Inbox:** Receive and manage notifications and messages.
- **Feedback:** Rate doctors after appointments.

### **Doctor**
- **Profile Management:** Access personal and professional information.
- **Secure Authentication:** Change password with strength validation.
- **Availability Management:** Set available dates and times for appointments.
- **Appointment Management:** Accept or reject appointment requests and view upcoming appointments.
- **Medical Documentation:** Record appointment outcomes, including diagnosis and treatment notes.
- **Medication Prescription:** Prescribe medications from the inventory.
- **Inbox:** Receive and manage notifications and messages.
- **Performance Review:** View patient ratings for performance evaluations.

### **Pharmacist**
- **Profile Management:** Access personal and professional information.
- **Secure Authentication:** Change password with strength validation.
- **Medication Management:** Prescribe medications based on doctor's prescriptions and manage inventory.
- **Replenishment Requests:** Submit requests for restocking low inventory items.
- **Inbox:** Receive and manage notifications and messages.

### **Administrator**
- **Profile Management:** Access personal and professional information.
- **Secure Authentication:** Change password with strength validation.
- **User Management:** Oversee and manage patient, doctor, pharmacist, and staff accounts.
- **Inventory Control:** View and manage medication stock levels and statuses.
- **Replenishment Approval:** Authorize restocking of inventory items.
- **Reporting:** Generate detailed reports on various system aspects.
- **Inbox:** Receive and manage notifications and messages.
- **Performance Review:** Access doctors’ ratings for performance evaluations.
---

### Assumptions

- **Doctor Availability:** All doctors are required to manually add their availability to the system for patients to schedule appointments. The system does not automatically assign availability based on predefined schedules.
- **24/7 Service:** HMS operates round-the-clock, ensuring uninterrupted service for users, including patients, doctors, pharmacists, and administrators.
- **Medicine Quantity:** The inventory system tracks the quantity of medicine in terms of packets rather than individual pills, simplifying stock management and replenishment processes.
- **Date & Time:** The system considers the current date as the reference point. For example, if a doctor sets an availability date before the current date, it is considered for the next year.


---

### Additional Features

- **Password Validation**
  - **Requirements:**
    - At least 1 uppercase letter and 1 lowercase letter.
    - At least 1 digit and 1 special character.
    - Minimum length of 8 characters.
  - **Implementation:** `inputPasswordStrict.java`
  - **Benefit:** Enhances data security by ensuring strong passwords.

- **Datetime Validation**
  - **Functionality:**
    - Verifies that the input follows a valid datetime format (month, day, and time).
    - Ensures the provided date exists (e.g., rejects invalid dates like 31st February).
  - **Implementation:** `DayChecker.java`
  - **Benefit:** Improves system robustness by preventing invalid date inputs.

- **Inbox**
  - **Features:**
    - Each user has an inbox to check and clear messages.
    - Automatic notifications for actions such as scheduling, rescheduling, or canceling appointments; doctors accepting or rejecting requests; pharmacists making replenishment requests.
  - **Benefit:** Simulates real-life applications, keeping users informed about important actions.

- **Rating**
  - **Functionality:**
    - Patients can rate doctors (out of 5) after completing an appointment.
    - Admins can view doctors’ ratings for performance reviews.
  - **Implementation:** `DoctorRating` and `UpdateRating.java`
  - **Benefit:** Facilitates feedback collection and supports employee performance evaluation.

- **UI Enhancement**
  - **Features:**
    - Pretty printing, boxes for user menus and inboxes, borders for information display.
    - Display HMS title in ASCII art.
  - **Benefit:** Enhances user experience by making the interface more visually appealing.

- **Password Invisibility**
  - **Functionality:** Hides password input while typing for added privacy and security.
  - **Implementation:** `SessionManager.java`
  - **Benefit:** Protects user passwords from being displayed during input.

---

## Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/tanueihorng/sc2002-hms.git
   ```
2. **Navigate to the Project Directory:**
   ```bash
   cd Hospital-Management-System
   ```
3. **Build & Run the Project:**
   - Open the project in [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/).
   - Ensure you have Java 17 installed.
   - Build the project using IntelliJ IDEA's build tools.

---

## Running the Application

### **Using Command Line:**

1. **Navigate to the Build Directory:**
   ```bash
   cd out/artifacts/HMS_jar/
   ```
2. **Run the Jar File:**
   ```bash
   java -jar HMS.jar
   ```

### **Using Scripts:**

- **For Unix/Linux:**
  ```bash
  ./run.sh
  ```
- **For Windows:**
  ```cmd
  run.cmd
  ```

### **Using IntelliJ IDEA:**

- Open the project in IntelliJ IDEA.
- Locate the `HMS.java` file in `src/system/`.
- Run the `HMS` class.

**Initial Login Credentials:**
- **Default Password for All Users:** `password`

---

## UML Class Diagram

The UML class diagram for HMS is done using plantuml code and can be viewed [here](path/to/hms_classdiagram.svg).

---

## Team Members

We are **Group 5** from tutorial group **SCS6**, Nanyang Technological University, Singapore. Our team consists of 5 members:

| Name           | GitHub Account | Email               |
|----------------|-----------------|---------------------|
| Adam Soh Shi Jie | adam-soh      | adam0025@e.ntu.edu.sg |
| Chong Jia Chern  | chong-jc      | jchong069@e.ntu.edu.sg |
| Ho Shang Ji Jason| ho-shang-jj   | U2322832D@e.ntu.edu.sg |
| Song Tingfeng    | song-tingfeng | tsong005@e.ntu.edu.sg |
| Tan Uei Horng    | tanueihorng   | utan001@e.ntu.edu.sg |

---

## License

MIT © Adam Soh Shi Jie, Chong Jia Chern, Ho Shang Ji Jason, Song Tingfeng, Tan Uei Horng

---

## Contact

For any queries or support, please contact any of the team members via their provided email addresses.

---

# Disclaimer

This project is developed for educational purposes as part of the SC2002 course assignment at Nanyang Technological University, Singapore.
 
