import java.util.*;
import java.io.*;
public class Main {
    static Scanner input = new Scanner(System.in);
    static int teacherCount=0;
    static String[] teacherUsernames= new String[2];
    static String[] teacherPasswords= new String[2];
    static int studentCount=0;
    static int [] studentIDs= new int [2];
    static String[] studentNames= new String[2];
    static String[] studentDepts= new String[2];
    static String[] studentUsernames= new String[2];
    static String[] studentPasswords= new String[2];
    static double [] cgpa = new double[2];
    static int[] courseCount= new int [2];
    static String[][] courseNames= new String[2][2];
    static int[][] courseSem= new int[2][2];
    static double[][] quizMarks = new double[2][2];
    static double[][] asgmMarks = new double[2][2];
    static double[][] midMarks = new double[2][2];
    static double[][] finalMarks = new double[2][2];
    static boolean[][] gradeCalc = new boolean[2][2];
    static  String STUDENTS_FILE = "students.csv";
    static  String COURSES_FILE = "courses.csv";
    static  String MARKS_FILE = "marks.csv";
    static void addTeacher(String username, String password) {
        if (teacherCount == teacherUsernames.length) {
            String[] newteacher = new String[teacherUsernames.length * 2];
            String[] newPassword = new String[teacherUsernames.length * 2];
            for (int j = 0; j < teacherCount; j++) {
                newteacher[j] = teacherUsernames[j];
                newPassword[j] = teacherPasswords[j];
            }
            teacherUsernames = newteacher;
            teacherPasswords = newPassword;
        }
        teacherUsernames[teacherCount] = username;
        teacherPasswords[teacherCount] = password;
        teacherCount++;
    }
    static void addStudent(int id, String name, String dept, String uname, String pass) {
        if (studentCount == studentIDs.length) {
            int newLength = studentIDs.length * 2;
            int[] newIDs = new int[newLength];
            String[] newNames = new String[newLength];
            String[] newDepts = new String[newLength];
            String[] newUsernames = new String[newLength];
            String[] newPasswords = new String[newLength];
            double[] newCgpa = new double[newLength];
            int[] newCCount = new int[newLength];
            String[][] newCNames = new String[newLength][];
            int[][] newCSem = new int[newLength][];
            double[][] newQuiz = new double[newLength][];
            double[][] newAsgm = new double[newLength][];
            double[][] newMid = new double[newLength][];
            double[][] newFinal = new double[newLength][];
            boolean[][] newGCalc = new boolean[newLength][];
            for (int j = 0; j < studentCount; j++) {
                newIDs[j] = studentIDs[j];
                newNames[j] = studentNames[j];
                newDepts[j] = studentDepts[j];
                newUsernames[j] = studentUsernames[j];
                newPasswords[j] = studentPasswords[j];
                newCgpa[j] = cgpa[j];
                newCCount[j] = courseCount[j];
                newCNames[j] = courseNames[j];
                newCSem[j] = courseSem[j];
                newQuiz[j] = quizMarks[j];
                newAsgm[j] = asgmMarks[j];
                newMid[j] = midMarks[j];
                newFinal[j] = finalMarks[j];
                newGCalc[j] = gradeCalc[j];
            }
            studentIDs = newIDs;
            studentNames = newNames;
            studentDepts = newDepts;
            studentUsernames = newUsernames;
            studentPasswords = newPasswords;
            cgpa = newCgpa;
            courseCount = newCCount;
            courseNames = newCNames;
            courseSem = newCSem;
            quizMarks = newQuiz;
            asgmMarks = newAsgm;
            midMarks = newMid;
            finalMarks = newFinal;
            gradeCalc = newGCalc;
        }
        int i = studentCount;
        studentIDs[i] = id;
        studentNames[i] = name;
        studentDepts[i] = dept;
        studentUsernames[i] = uname;
        studentPasswords[i] = pass;
        cgpa[i] = 0.0;
        courseCount[i] = 0;
        courseNames[i] = new String[2];
        courseSem[i] = new int[2];
        quizMarks[i] = new double[2];
        asgmMarks[i] = new double[2];
        midMarks[i] = new double[2];
        finalMarks[i] = new double[2];
        gradeCalc[i] = new boolean[2];
        studentCount++;
    }
    static void addCourse(int idx, String coursename, int sem) {
        int cc = courseCount[idx];
        if (cc == courseNames[idx].length) {
            int newLength = courseNames[idx].length * 2;
            String[] newCNames = new String[newLength];
            int[] newCSem = new int[newLength];
            double[] newQuiz = new double[newLength];
            double[] newAsgm = new double[newLength];
            double[] newMid = new double[newLength];
            double[] newFinal = new double[newLength];
            boolean[] newGCalc = new boolean[newLength];
            for (int j = 0; j < cc; j++) {
                newCNames[j] = courseNames[idx][j];
                newCSem[j] = courseSem[idx][j];
                newQuiz[j] = quizMarks[idx][j];
                newAsgm[j] = asgmMarks[idx][j];
                newMid[j] = midMarks[idx][j];
                newFinal[j] = finalMarks[idx][j];
                newGCalc[j] = gradeCalc[idx][j];
            }
            courseNames[idx] = newCNames;
            courseSem[idx] = newCSem;
            quizMarks[idx] = newQuiz;
            asgmMarks[idx] = newAsgm;
            midMarks[idx] = newMid;
            finalMarks[idx] = newFinal;
            gradeCalc[idx] = newGCalc;
        }
        courseNames[idx][cc] = coursename;
        courseSem[idx][cc] = sem;
        gradeCalc[idx][cc] = false;
        courseCount[idx]++;
    }
    public static void main(String[] args) {
        addTeacher("aqeel", "12345");
        addTeacher("ahtesham", "12345");
        addTeacher("muzammil", "12345");
        addTeacher("esha", "12345");
        loadAllData();
        new RoleSelectionPage();
    }
    static void teacherLogin() {
        System.out.println("       TEACHER LOGIN        ");
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        for (int i = 0; i < teacherCount; i++) {
            if (teacherUsernames[i].equals(username) && teacherPasswords[i].equals(password)) {
                System.out.println("Login successful ");
                System.out.println("Welcome Teacher " + username);
                new TeacherDashboard(username);
                return;
            }
        }
        System.out.println("Invalid username or password. Access denied.");
    }
    static void studentLogin() {
        System.out.println("       STUDENT LOGIN    ");
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        for (int i = 0; i < studentCount; i++) {
            if (studentUsernames[i] != null
                    && studentUsernames[i].equals(username)
                    && studentPasswords[i].equals(password)) {
                System.out.println("Login successful ");
                System.out.println("Welcome  " + studentNames[i]);
                new StudentDashboard(i);
                return;
            }
        }
        System.out.println("Invalid username or password. Access denied.");
    }
    static void teacherMenu() {
        int choice = 0;
        while (choice != 11) {
            System.out.println("       TEACHER MENU      ");
            System.out.println("1.  Add student");
            System.out.println("2.  Update student info");
            System.out.println("3.  Delete student");
            System.out.println("4.  Display all students");
            System.out.println("5.  Register semester courses");
            System.out.println("6.  Add  update marks");
            System.out.println("7.  Calculate grades & GPA");
            System.out.println("8.  View student Transcript");
            System.out.println("9.  Search student");
            System.out.println("10. Sort students");
            System.out.println("11. Save & Logout");
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
                if (choice == 1)
                    addStudent();
                else if (choice == 2)
                    updateStudent();
                else if (choice == 3)
                    deleteStudent();
                else if (choice == 4)
                    displayAllStudents();
                else if (choice == 5)
                    registerCourses();
                else if (choice == 6)
                    addMarks();
                else if (choice == 7)
                    calculateGrades();
                else if (choice == 8) {
                    System.out.print("Enter Student ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    int idx = findID(id);
                    if (idx == -1) {
                        System.out.println("Student not found ");
                    } else {
                        printTranscript(idx);
                    }
                }   else if (choice == 9) searchMenu();
                else if
                (choice == 10) sortMenu();
                else if (choice == 11) {
                    saveAllData();
                    System.out.println("Data saved. Logging out ");
                } else System.out.println("Invalid choice. Enter 1-11.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
    static void addStudent() {
        System.out.println("   Add Student    ");
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(input.nextLine());
            if (findID(id) != -1) {
                System.out.println(" Student ID " + id + " already exists ");
                return;
            }
            System.out.print("Enter student name: ");
            String name = input.nextLine();
            System.out.print("Enter department: ");
            String dept = input.nextLine();
            System.out.print("Set username for Student: ");
            String uname = input.nextLine();
            for (int i = 0; i < studentCount; i++) {
                if (studentUsernames[i] != null && studentUsernames[i].equals(uname)) {
                    System.out.println("Username '" + uname + "' already taken. Choose another.");
                    return;
                }
            }
            System.out.print("Set password for student: ");
            String pass = input.nextLine();
            addStudent(id, name, dept, uname, pass);
            System.out.println("Student added successfully. your Login = " + uname + " and password = " + pass);
            saveAllData();
        } catch (NumberFormatException e) {
            System.out.println("Invalid id. it must be a number.");
        }
    }
    static void updateStudent() {
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine();
        int idx = findID(id);
        if (idx == -1) {
            System.out.println("Student not found ");
            return;
        }
        System.out.println("just press Enter if you dont want to update any thing");
        System.out.print("New Name [" + studentNames[idx] + "]: ");
        String name = input.nextLine();
        System.out.print("New Department [" + studentDepts[idx] + "]: ");
        String dept = input.nextLine();
        if (!name.isEmpty())
            studentNames[idx] = name;
        if (!dept.isEmpty())
            studentDepts[idx] = dept;
        System.out.println("Student updated successfully ");
        saveAllData();
    }
    static void deleteStudent() {
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine();
        int idx = findID(id);
        if (idx == -1) {
            System.out.println("Student not found!");
            return;
        }
        for (int i = idx; i < studentCount - 1; i++) {
            studentIDs[i] = studentIDs[i + 1];
            studentNames[i] = studentNames[i + 1];
            studentDepts[i] = studentDepts[i + 1];
            studentUsernames[i] = studentUsernames[i + 1];
            studentPasswords[i] = studentPasswords[i + 1];
            courseCount[i] = courseCount[i + 1];
            cgpa[i] = cgpa[i + 1];
            courseNames[i] = courseNames[i + 1];
            courseSem[i] = courseSem[i + 1];
            quizMarks[i] = quizMarks[i + 1];
            asgmMarks[i] = asgmMarks[i + 1];
            midMarks[i] = midMarks[i + 1];
            finalMarks[i] = finalMarks[i + 1];
            gradeCalc[i] = gradeCalc[i + 1];
        }
        studentCount--;
        System.out.println("Student Deleted Successfully.");
        saveAllData();
    }
    static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("     All Students    ");
        System.out.println("ID     Name       Dept    CGPA");
        for (int i = 0; i < studentCount; i++)
            System.out.println(studentIDs[i] + "      " + studentNames[i] + "      " + studentDepts[i] + "       " + cgpa[i]);
    }
    static void registerCourses() {
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine();
        int idx = findID(id);
        if (idx == -1) {
            System.out.println("Student not found!");
            return;
        }
        try {
            System.out.print("Enter Semester Number: ");
            int sem = Integer.parseInt(input.nextLine());
            System.out.print("Enter Number of Courses: ");
            int num = Integer.parseInt(input.nextLine());
            if (num <= 0) {
                System.out.println("Invalid course count.");
                return;
            }
            for (int i = 0; i < num; i++) {
                System.out.print("Enter Course " + (i + 1) + " Name: ");
                String cname = input.nextLine();
                addCourse(idx, cname, sem);
            }
            System.out.println("Courses Registered Successfully ");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. enter  numbers only.");
        }
    }
    static void addMarks() {
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine();
        int idx = findID(id);
        if (idx == -1) {
            System.out.println("Student not found!");
            return;
        }
        int cc = courseCount[idx];
        if (cc == 0) {
            System.out.println("No courses registered for this student.");
            return;
        }
        System.out.println("courses:");
        for (int i = 0; i < cc; i++)
            System.out.println("  " + (i + 1) + ". " + courseNames[idx][i] + " (Sem " + courseSem[idx][i] + ")");
        try {
            System.out.print("Select course number: ");
            int ci = Integer.parseInt(input.nextLine()) - 1;
            if (ci < 0 || ci >= cc) {
                System.out.println("Invalid course.");
                return;
            }
            System.out.println("Max marks → Quiz:10  Assignment:20  Mid:30  Final:40");
            quizMarks[idx][ci] = getmarks("Quiz marks (max 10): ", 10);
            asgmMarks[idx][ci] = getmarks("Assignment marks (max 20): ", 20);
            midMarks[idx][ci] = getmarks("Midterm Marks (max 30): ", 30);
            finalMarks[idx][ci] = getmarks("Final Marks (max 40): ", 40);
            System.out.println("Marks updated Successfully.");
            saveAllData();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }
    static double getmarks(String prompt, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double val = Double.parseDouble(input.nextLine());
                if (val < 0) {
                    System.out.println("Invalid input. Marks cannot be negative.");
                } else if (val > max) {
                    System.out.println("Invalid input. marks cannot exceed " + (int) max + ".");
                } else {
                    if (val == 0)
                        System.out.println(" Teacher has not added marks yet");
                    return val;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. enter a number.");
            }
        }
    }
    static void calculateGrades() {
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine();
        int idx = findID(id);
        if (idx == -1) { System.out.println("Student not found!");
            return;
        }
        int cc = courseCount[idx];
        if (cc == 0) { System.out.println("No courses found.");
            return;
        }
        System.out.print("Enter Semester Number to calculate grades for: ");
        int sem;
        try {
            sem = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }
        for (int i = 0; i < cc; i++) {
            if (courseSem[idx][i] == sem) {
                double total = quizMarks[idx][i] + asgmMarks[idx][i] + midMarks[idx][i] + finalMarks[idx][i];
                if (total > 0) gradeCalc[idx][i] = true;
            }
        }
        double semGP = 0;
        int semGraded = 0;
        for (int i = 0; i < cc; i++) {
            if (courseSem[idx][i] == sem && gradeCalc[idx][i]) {
                double total = quizMarks[idx][i] + asgmMarks[idx][i] + midMarks[idx][i] + finalMarks[idx][i];
                semGP += marksToGradePoint(total);
                semGraded++;
            }
        }
        double totalGP = 0;
        int totalGraded = 0;
        for (int i = 0; i < cc; i++) {
            if (gradeCalc[idx][i]) {
                double total = quizMarks[idx][i] + asgmMarks[idx][i] + midMarks[idx][i] + finalMarks[idx][i];
                totalGP += marksToGradePoint(total);
                totalGraded++;
            }
        }
        if (semGraded > 0) {
            double semGPA = semGP / semGraded;
            if (totalGraded > 0)
                cgpa[idx] = totalGP / totalGraded;
            else
                cgpa[idx] = 0;
            System.out.println("Grades calculated.");
            saveAllData();
            System.out.println("Semester " + sem + " GPA : " + semGPA);
            System.out.println("Overall CGPA       = " + cgpa[idx]);
        } else {
            System.out.println("No marks found for semester " + sem + ".");
        }
    }
    static void studentMenu(int idx) {
        boolean running = true;
        while (running) {
            System.out.println("        STUDENT DASHBOARD       ");
            System.out.println("Student= " + studentNames[idx] + " | ID= " + studentIDs[idx] + " | Dept= " + studentDepts[idx]);
            System.out.println("1. View Registered courses");
            System.out.println("2. View My marks");
            System.out.println("3. View grades & GPA");
            System.out.println("4. View full Transcript");
            System.out.println("5. Logout");
            System.out.print("Choice: ");
            try {
                int c = Integer.parseInt(input.nextLine());
                switch (c) {
                    case 1:
                        viewCourses(idx);
                        break;
                    case 2:
                        viewMarks(idx);
                        break;
                    case 3:
                        viewGrades(idx);
                        break;
                    case 4:
                        printTranscript(idx);
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Enter 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. enter a number.");
            }
        }
    }
    static void viewCourses(int idx) {
        int cc = courseCount[idx];
        if (cc == 0) {
            System.out.println("No courses registered yet.");
            return;
        }
        System.out.println("     Registered Courses   ");
        System.out.println("Course" + "      " + "Semester");
        for (int i = 0; i < cc; i++)
            System.out.println(courseNames[idx][i] + "           " + courseSem[idx][i]);
    }
    static void viewMarks(int idx) {
        int cc = courseCount[idx];
        if (cc == 0) {
            System.out.println("No courses found.");
            return;
        }
        System.out.println("    My Marks   ");
        System.out.println("Quiz" + "  " + "Asgmt" + "  " + "Mid" + "  " + "Final" + "  " + "Total");
        for (int i = 0; i < cc; i++) {
            double total = quizMarks[idx][i] + asgmMarks[idx][i] + midMarks[idx][i] + finalMarks[idx][i];
            System.out.println(courseNames[idx][i] + " " + quizMarks[idx][i] + " " + asgmMarks[idx][i] + " " + midMarks[idx][i] + " " + finalMarks[idx][i] + " " + total);
            if (total == 0)
                System.out.println("  Pending  ");
            else
                System.out.println("");
        }
    }
    static void viewGrades(int idx) {
        int cc = courseCount[idx];
        if (cc == 0) {
            System.out.println("No courses found.");
            return;
        }
        System.out.println("    Grades   ");
        System.out.println("Course" + "  " + "Total" + "   " + "Grade");
        for (int i = 0; i < cc; i++) {
            if (!gradeCalc[idx][i]) {
                System.out.println(courseNames[idx][i] + "  Grade not calculated. Contact your teacher.");
            } else {
                double total = quizMarks[idx][i] + asgmMarks[idx][i] + midMarks[idx][i] + finalMarks[idx][i];
                System.out.println(courseNames[idx][i] + "  " + total + "  " + "  " + marksToGrade(total));
            }
        }
        System.out.println("CGPA: " + cgpa[idx]);
    }
    static String marksToGrade(double marks) {
        if (marks >= 90) return "A+";
        if (marks >= 85) return "A";
        if (marks >= 80) return "A-";
        if (marks >= 75) return "B+";
        if (marks >= 70) return "B";
        if (marks >= 65) return "B-";
        if (marks >= 60) return "C+";
        if (marks >= 55) return "C";
        if (marks >= 50) return "C-";
        if (marks >= 45) return "D";
        return "F";
    }
    static double marksToGradePoint(double marks) {
        if (marks >= 90) return 4.0;
        if (marks >= 85) return 3.9;
        if (marks >= 80) return 3.7;
        if (marks >= 75) return 3.3;
        if (marks >= 70) return 3.0;
        if (marks >= 65) return 2.7;
        if (marks >= 60) return 2.3;
        if (marks >= 55) return 2.0;
        if (marks >= 50) return 1.7;
        if (marks >= 45) return 1.0;
        return 0.0;
    }
    static void printTranscript(int idx) {
        System.out.println("           ACADEMIC TRANSCRIPT             ");
        System.out.println("Student Name : " + studentNames[idx]);
        System.out.println("Student ID   : " + studentIDs[idx]);
        System.out.println("Department   : " + studentDepts[idx]);
        int cc = courseCount[idx];
        if (cc == 0) {
            System.out.println("No courses registered.");
            return;
        }
        int maxSem = 0;
        for (int i = 0; i < cc; i++)
            if (courseSem[idx][i] > maxSem)
                maxSem = courseSem[idx][i];
        double totalGP = 0;
        int totalCourse = 0;
        boolean pending = false;
        for (int sem = 1; sem <= maxSem; sem++) {
            boolean headerPrinted = false;
            double semGP = 0;
            int semCourses = 0;
            for (int i = 0; i < cc; i++) {
                if (courseSem[idx][i] != sem)
                    continue;
                if (!headerPrinted) {
                    System.out.println("  SEMESTER " + sem);
                    System.out.println("Course" + "  " + "Marks " + "  " + " Grade" + "  " + "Points");
                    headerPrinted = true;
                }
                if (!gradeCalc[idx][i]) {
                    System.out.println(courseNames[idx][i] + "  Grade not calculated. Contact your teacher.");
                    pending = true;
                } else {
                    double total = quizMarks[idx][i] + asgmMarks[idx][i] + midMarks[idx][i] + finalMarks[idx][i];
                    double gp = marksToGradePoint(total);
                    System.out.println(courseNames[idx][i] + "  " + total + "  " + marksToGrade(total) + "  " + gp);
                    semGP += gp;
                    semCourses++;
                }
            }
            if (semCourses > 0) {
                System.out.println("  Semester GPA = " + semGP / semCourses);
                totalGP += semGP;
                totalCourse += semCourses;
            }
        }
        if (totalCourse > 0) {
            System.out.println("Overall CGPA = " + totalGP / totalCourse);
        } else {
            System.out.println("Overall CGPA= " + 0.0);
        }
        if (pending)
            System.out.println(" Contact your teacher for pending grades.");
    }
    static void searchMenu() {
        System.out.println("    Search   ");
        System.out.println("1. Search by ID (Linear Search)");
        System.out.println("2. Search by ID (Binary Search - recursive)");
        System.out.println("3. Search by Name");
        System.out.print("Choice: ");
        try {
            int c = Integer.parseInt(input.nextLine());
            if (c == 1) {
                System.out.print("Enter Student ID: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.println("[Linear Search ...");
                printResult(linearSearchByID(id));
            } else if (c == 2) {
                System.out.print("Enter Student ID: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.println("[Binary Search ...");
                bubbleSortByID();
                printResult(binarySearch(id, 0, studentCount - 1));
            } else if (c == 3) {
                System.out.print("Enter Name  ");
                String name = input.nextLine().toLowerCase();
                boolean found = false;
                for (int i = 0; i < studentCount; i++) {
                    if (studentNames[i].equalsIgnoreCase(name)) {
                        System.out.println("  ID= " + studentIDs[i] + " | Name= " + studentNames[i] + " | Dept: =" + studentDepts[i] + " CGPA = " + cgpa[i]);
                        found = true;
                    }
                }
                if (!found) System.out.println("No students found matching " + name);
            } else {
                System.out.println("Invalid choice Enter 1, 2, 3.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. enter a number.");
        }
    }
    static int linearSearchByID(int id) {
        for (int i = 0; i < studentCount; i++)
            if (studentIDs[i] == id)
                return i;
        return -1;
    }
    static int binarySearch(int id, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (studentIDs[mid] == id)
            return mid;
        if (studentIDs[mid] < id)
            return binarySearch(id, mid + 1, high);
        return binarySearch(id, low, mid - 1);
    }
    static void printResult(int idx) {
        if (idx == -1)
            System.out.println("Student not found.");
        else
            System.out.println("  ID= " + studentIDs[idx] + " | Name= " + studentNames[idx] + " | Dept: =" + studentDepts[idx] + "  CGPA= " + cgpa[idx]);
    }
    static void sortMenu() {
        System.out.println("   Sort Students by bubble  sort ");
        System.out.println("1. Sort by Student ID");
        System.out.println("2. Sort by Name");
        System.out.println("3. Sort by CGPA (highest first)");
        System.out.print("Choice: ");
        try {
            int c = Integer.parseInt(input.nextLine());
            if (c == 1)
                bubbleSortByID();
            else if (c == 2)
                bubbleSortByName();
            else if (c == 3)
                bubbleSortByCGPA();
            else {
                System.out.println("Invalid choice! Enter 1, 2, or 3.");
                return;
            }
            displayAllStudents();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
        }
    }
    static void swapStudents(int i, int j) {
        int tempid = studentIDs[i];
        studentIDs[i] = studentIDs[j];
        studentIDs[j] = tempid;
        String tempname = studentNames[i];
        studentNames[i] = studentNames[j];
        studentNames[j] = tempname;
        String tempdept = studentDepts[i];
        studentDepts[i] = studentDepts[j];
        studentDepts[j] = tempdept;
        String tempUsername = studentUsernames[i];
        studentUsernames[i] = studentUsernames[j];
        studentUsernames[j] = tempUsername;
        String temppass = studentPasswords[i];
        studentPasswords[i] = studentPasswords[j];
        studentPasswords[j] = temppass;
        double tempcgpa = cgpa[i];
        cgpa[i] = cgpa[j];
        cgpa[j] = tempcgpa;
        int tempcount = courseCount[i];
        courseCount[i] = courseCount[j];
        courseCount[j] = tempcount;
        String[] tempCoursename = courseNames[i];
        courseNames[i] = courseNames[j];
        courseNames[j] = tempCoursename;
        int[] tempCoursesem = courseSem[i];
        courseSem[i] = courseSem[j];
        courseSem[j] = tempCoursesem;
        double[] tempquiz = quizMarks[i];
        quizMarks[i] = quizMarks[j];
        quizMarks[j] = tempquiz;
        double[] tempasg = asgmMarks[i];
        asgmMarks[i] = asgmMarks[j];
        asgmMarks[j] = tempasg;
        double[] tempmid = midMarks[i];
        midMarks[i] = midMarks[j];
        midMarks[j] = tempmid;
        double[] tempfinal = finalMarks[i];
        finalMarks[i] = finalMarks[j];
        finalMarks[j] = tempfinal;
        boolean[] tempgrade = gradeCalc[i];
        gradeCalc[i] = gradeCalc[j];
        gradeCalc[j] = tempgrade;
    }
    static void bubbleSortByID() {
        for (int i = 0; i < studentCount - 1; i++)
            for (int j = 0; j < studentCount - i - 1; j++)
                if (studentIDs[j] > studentIDs[j + 1])
                    swapStudents(j, j + 1);
        System.out.println("sorted by student id from small to large");
    }
    static void bubbleSortByName() {
        for (int i = 0; i < studentCount - 1; i++)
            for (int j = 0; j < studentCount - i - 1; j++)
                if (studentNames[j].compareToIgnoreCase(studentNames[j + 1]) > 0)
                    swapStudents(j, j + 1);
        System.out.println("sorted by name from A to Z");
    }
    static void bubbleSortByCGPA() {
        for (int i = 0; i < studentCount - 1; i++)
            for (int j = 0; j < studentCount - i - 1; j++)
                if (cgpa[j] < cgpa[j + 1])
                    swapStudents(j, j + 1);
        System.out.println("sorted by cgpa from hig to low ");
    }
    static void saveAllData() {
        try {
            FileWriter fw1 = new FileWriter(STUDENTS_FILE);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write("id,name,dept,username,password,cgpa");
            bw1.newLine();
            for (int i = 0; i < studentCount; i++) {
                bw1.write(studentIDs[i] + "," + studentNames[i] + "," + studentDepts[i] + "," + studentUsernames[i] + "," + studentPasswords[i] + "," + cgpa[i]);
                bw1.newLine();
            }
            bw1.close();
            FileWriter fw2 = new FileWriter(COURSES_FILE);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            bw2.write("studentIdx,courseIdx,courseName,semester");
            bw2.newLine();
            for (int i = 0; i < studentCount; i++)
                for (int j = 0; j < courseCount[i]; j++) {
                    bw2.write(studentIDs[i] + "," + j + "," + courseNames[i][j] + "," + courseSem[i][j]);
                    bw2.newLine();
                }
            bw2.close();
            FileWriter fw3 = new FileWriter(MARKS_FILE);
            BufferedWriter bw3 = new BufferedWriter(fw3);
            bw3.write("studentIdx,courseIdx,quiz,asgm,mid,final,gradeCalc");
            bw3.newLine();
            for (int i = 0; i < studentCount; i++)
                for (int j = 0; j < courseCount[i]; j++) {
                    bw3.write(studentIDs[i]+ "," + j + "," + quizMarks[i][j] + "," + asgmMarks[i][j] + "," + midMarks[i][j] + "," + finalMarks[i][j] + "," + gradeCalc[i][j]);
                    bw3.newLine();
                }
            bw3.close();
        } catch (IOException e) {
            System.out.println("file handling error");
        }
    }
    static void loadAllData() {
        try {
            FileReader fr1 = new FileReader(STUDENTS_FILE);
            BufferedReader br1 = new BufferedReader(fr1);
            br1.readLine();
            String line;
            while ((line = br1.readLine()) != null) {
                String[] p = line.split(",", 6);
                if (p.length < 6) continue;
                addStudent(Integer.parseInt(p[0]), p[1], p[2], p[3], p[4]);
                cgpa[studentCount - 1] = Double.parseDouble(p[5]);
            }
            br1.close();
            FileReader fr2 = new FileReader(COURSES_FILE);
            BufferedReader br2 = new BufferedReader(fr2);
            br2.readLine();
            while ((line = br2.readLine()) != null) {
                String[] p = line.split(",", 4);
                if (p.length < 4) continue;
                int sid = Integer.parseInt(p[0]);
                int idx = findID(sid);
                if (idx == -1) continue;
                addCourse(idx, p[2], Integer.parseInt(p[3]));
            }
            br2.close();

            FileReader fr3 = new FileReader(MARKS_FILE);
            BufferedReader br3 = new BufferedReader(fr3);
            br3.readLine();
            while ((line = br3.readLine()) != null) {
                String[] p = line.split(",", 7);
                if (p.length < 7) continue;
                int sid = Integer.parseInt(p[0]);
                int cid = Integer.parseInt(p[1]);
                int idx = findID(sid);
                if (idx == -1 || cid >= courseCount[idx]) continue;
                quizMarks[idx][cid] = Double.parseDouble(p[2]);
                asgmMarks[idx][cid] = Double.parseDouble(p[3]);
                midMarks[idx][cid] = Double.parseDouble(p[4]);
                finalMarks[idx][cid] = Double.parseDouble(p[5]);
                gradeCalc[idx][cid] = Boolean.parseBoolean(p[6]);
            }
            br3.close();
        } catch (IOException e) {
        }
    }
    static int findID(int id) {
        for (int i = 0; i < studentCount; i++)
            if (studentIDs[i] == id)
                return i;
        return -1;
    }

}