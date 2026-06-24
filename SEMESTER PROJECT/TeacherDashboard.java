import javax.swing.*;
import java.awt.*;
public class TeacherDashboard extends JFrame {
    private JTextArea outputArea;
    public TeacherDashboard(String teacherName) {
        setTitle("Teacher Dashboard");
        setSize(750, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel infoLabel           = new JLabel("Teacher: " + teacherName);
        JButton addStudentBtn      = new JButton("Add Student");
        JButton updateStudentBtn   = new JButton("Update Student");
        JButton deleteStudentBtn   = new JButton("Delete Student");
        JButton displayAllBtn      = new JButton("Display All Students");
        JButton registerCoursesBtn = new JButton("Register Courses");
        JButton addMarksBtn        = new JButton("Add / Update Marks");
        JButton calcGradesBtn      = new JButton("Calculate Grades & GPA");
        JButton transcriptBtn      = new JButton("View Transcript");
        JButton searchBtn          = new JButton("Search Student");
        JButton sortBtn            = new JButton("Sort Students");
        JButton logoutBtn          = new JButton("Save & Logout");
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        outputArea.setRows(5);
        outputArea.setColumns(50);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(560, 100));
        JPanel buttonPanel = new JPanel(new GridLayout(3, 4, 8, 8));
        buttonPanel.add(infoLabel);
        buttonPanel.add(addStudentBtn);
        buttonPanel.add(updateStudentBtn);
        buttonPanel.add(deleteStudentBtn);
        buttonPanel.add(displayAllBtn);
        buttonPanel.add(registerCoursesBtn);
        buttonPanel.add(addMarksBtn);
        buttonPanel.add(calcGradesBtn);
        buttonPanel.add(transcriptBtn);
        buttonPanel.add(searchBtn);
        buttonPanel.add(sortBtn);
        buttonPanel.add(logoutBtn);
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
        addStudentBtn.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog(this, "Enter Student ID:");
                if (idStr == null) return;
                int id = Integer.parseInt(idStr.trim());
                if (Main.findID(id) != -1) { outputArea.setText("Student ID " + id + " already exists."); return; }
                String name = JOptionPane.showInputDialog(this, "Enter Student Name:");
                if (name == null || name.trim().isEmpty()) return;
                String dept = JOptionPane.showInputDialog(this, "Enter Department:");
                if (dept == null || dept.trim().isEmpty()) return;
                String uname = JOptionPane.showInputDialog(this, "Set Username:");
                if (uname == null || uname.trim().isEmpty()) return;
                for (int i = 0; i < Main.studentCount; i++) {
                    if (Main.studentUsernames[i] != null && Main.studentUsernames[i].equals(uname.trim())) {
                        outputArea.setText("Username '" + uname + "' already taken.");
                        return;
                    }
                }
                String pass = JOptionPane.showInputDialog(this, "Set Password:");
                if (pass == null || pass.trim().isEmpty()) return;
                Main.addStudent(id, name.trim(), dept.trim(), uname.trim(), pass.trim());
                Main.saveAllData();
                outputArea.setText("Student added successfully.\nLogin = " + uname.trim() + " and password = " + pass.trim());
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid ID. Must be a number.");
            }
        });
        updateStudentBtn.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog(this, "Enter Student ID:");
                if (idStr == null) return;
                int id = Integer.parseInt(idStr.trim());
                int idx = Main.findID(id);
                if (idx == -1) { outputArea.setText("Student not found."); return; }
                String newName = JOptionPane.showInputDialog(this, "New Name (leave blank to keep current: " + Main.studentNames[idx] + "):");
                String newDept = JOptionPane.showInputDialog(this, "New Department (leave blank to keep current: " + Main.studentDepts[idx] + "):");
                if (newName != null && !newName.trim().isEmpty()) Main.studentNames[idx] = newName.trim();
                if (newDept != null && !newDept.trim().isEmpty()) Main.studentDepts[idx] = newDept.trim();
                Main.saveAllData();
                outputArea.setText("Student updated successfully.");
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid ID. Must be a number.");
            }
        });
        deleteStudentBtn.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog(this, "Enter Student ID:");
                if (idStr == null) return;
                int id = Integer.parseInt(idStr.trim());
                int idx = Main.findID(id);
                if (idx == -1) { outputArea.setText("Student not found."); return; }
                int confirm = JOptionPane.showConfirmDialog(this, "Delete student " + Main.studentNames[idx] + "?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) return;
                for (int i = idx; i < Main.studentCount - 1; i++) {
                    Main.studentIDs[i]       = Main.studentIDs[i + 1];
                    Main.studentNames[i]     = Main.studentNames[i + 1];
                    Main.studentDepts[i]     = Main.studentDepts[i + 1];
                    Main.studentUsernames[i] = Main.studentUsernames[i + 1];
                    Main.studentPasswords[i] = Main.studentPasswords[i + 1];
                    Main.courseCount[i]      = Main.courseCount[i + 1];
                    Main.cgpa[i]             = Main.cgpa[i + 1];
                    Main.courseNames[i]      = Main.courseNames[i + 1];
                    Main.courseSem[i]        = Main.courseSem[i + 1];
                    Main.quizMarks[i]        = Main.quizMarks[i + 1];
                    Main.asgmMarks[i]        = Main.asgmMarks[i + 1];
                    Main.midMarks[i]         = Main.midMarks[i + 1];
                    Main.finalMarks[i]       = Main.finalMarks[i + 1];
                    Main.gradeCalc[i]        = Main.gradeCalc[i + 1];
                }
                Main.studentCount--;
                Main.saveAllData();
                outputArea.setText("Student Deleted Successfully.");
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid ID. Must be a number.");
            }
        });

        displayAllBtn.addActionListener(e -> {
            if (Main.studentCount == 0) { outputArea.setText("No student records found."); return; }
            StringBuilder sb = new StringBuilder("All Students\n\n");
            sb.append("ID     Name       Dept    CGPA\n");
            for (int i = 0; i < Main.studentCount; i++)
                sb.append(Main.studentIDs[i] + "      " + Main.studentNames[i] + "      " + Main.studentDepts[i] + "       " + Main.cgpa[i] + "\n");
            outputArea.setText(sb.toString());
        });
        registerCoursesBtn.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog(this, "Enter Student ID:");
                if (idStr == null) return;
                int id = Integer.parseInt(idStr.trim());
                int idx = Main.findID(id);
                if (idx == -1) { outputArea.setText("Student not found."); return; }
                String semStr = JOptionPane.showInputDialog(this, "Enter Semester Number:");
                if (semStr == null) return;
                int sem = Integer.parseInt(semStr.trim());
                String numStr = JOptionPane.showInputDialog(this, "Enter Number of Courses:");
                if (numStr == null) return;
                int num = Integer.parseInt(numStr.trim());
                if (num <= 0) { outputArea.setText("Invalid course count."); return; }
                StringBuilder sb = new StringBuilder("Courses Registered Successfully\n");
                for (int i = 0; i < num; i++) {
                    String cname = JOptionPane.showInputDialog(this, "Enter Course " + (i + 1) + " Name:");
                    if (cname == null || cname.trim().isEmpty()) continue;
                    Main.addCourse(idx, cname.trim(), sem);
                    sb.append(cname.trim() + "\n");
                }
                Main.saveAllData();
                outputArea.setText(sb.toString());
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input. Numbers only.");
            }
        });
        addMarksBtn.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog(this, "Enter Student ID:");
                if (idStr == null) return;
                int id = Integer.parseInt(idStr.trim());
                int idx = Main.findID(id);
                if (idx == -1) { outputArea.setText("Student not found."); return; }
                int cc = Main.courseCount[idx];
                if (cc == 0) { outputArea.setText("No courses registered for this student."); return; }
                StringBuilder courseList = new StringBuilder("Select course number:\n");
                for (int i = 0; i < cc; i++)
                    courseList.append((i + 1) + ". " + Main.courseNames[idx][i] + " (Sem " + Main.courseSem[idx][i] + ")\n");
                String ciStr = JOptionPane.showInputDialog(this, courseList.toString());
                if (ciStr == null) return;
                int ci = Integer.parseInt(ciStr.trim()) - 1;
                if (ci < 0 || ci >= cc) { outputArea.setText("Invalid course selection."); return; }
                double quiz = promptMark("Quiz marks (max 10):", 10);
                double asgm = promptMark("Assignment marks (max 20):", 20);
                double mid  = promptMark("Midterm marks (max 30):", 30);
                double fin  = promptMark("Final marks (max 40):", 40);
                Main.quizMarks[idx][ci]  = quiz;
                Main.asgmMarks[idx][ci]  = asgm;
                Main.midMarks[idx][ci]   = mid;
                Main.finalMarks[idx][ci] = fin;
                Main.saveAllData();
                outputArea.setText("Marks updated Successfully.");
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input.");
            }
        });
        calcGradesBtn.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog(this, "Enter Student ID:");
                if (idStr == null) return;
                int id = Integer.parseInt(idStr.trim());
                int idx = Main.findID(id);
                if (idx == -1) { outputArea.setText("Student not found."); return; }
                int cc = Main.courseCount[idx];
                if (cc == 0) { outputArea.setText("No courses found."); return; }
                String semStr = JOptionPane.showInputDialog(this, "Enter Semester Number:");
                if (semStr == null) return;
                int sem = Integer.parseInt(semStr.trim());
                for (int i = 0; i < cc; i++) {
                    if (Main.courseSem[idx][i] == sem) {
                        double total = Main.quizMarks[idx][i] + Main.asgmMarks[idx][i] + Main.midMarks[idx][i] + Main.finalMarks[idx][i];
                        if (total > 0) Main.gradeCalc[idx][i] = true;
                    }
                }
                double semGP = 0; int semGraded = 0;
                double totalGP = 0; int totalGraded = 0;
                for (int i = 0; i < cc; i++) {
                    if (Main.gradeCalc[idx][i]) {
                        double total = Main.quizMarks[idx][i] + Main.asgmMarks[idx][i] + Main.midMarks[idx][i] + Main.finalMarks[idx][i];
                        double gp = Main.marksToGradePoint(total);
                        totalGP += gp; totalGraded++;
                        if (Main.courseSem[idx][i] == sem) { semGP += gp; semGraded++; }
                    }
                }
                if (semGraded == 0) { outputArea.setText("No marks found for semester " + sem + "."); return; }
                Main.cgpa[idx] = totalGraded > 0 ? totalGP / totalGraded : 0;
                Main.saveAllData();
                outputArea.setText("Grades calculated.\nSemester " + sem + " GPA : " + (semGP / semGraded) + "\nOverall CGPA       = " + Main.cgpa[idx]);
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input.");
            }
        });
        transcriptBtn.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog(this, "Enter Student ID:");
                if (idStr == null) return;
                int id = Integer.parseInt(idStr.trim());
                int idx = Main.findID(id);
                if (idx == -1) { outputArea.setText("Student not found."); return; }
                outputArea.setText(buildTranscript(idx));
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid ID.");
            }
        });
        searchBtn.addActionListener(e -> {
            String[] options = {"Search by ID (Linear)", "Search by ID (Binary)", "Search by Name"};
            int choice = JOptionPane.showOptionDialog(this, "Choose search method:", "Search",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            try {
                if (choice == 0) {
                    String idStr = JOptionPane.showInputDialog(this, "Enter Student ID:");
                    if (idStr == null) return;
                    int id = Integer.parseInt(idStr.trim());
                    int idx = Main.linearSearchByID(id);
                    outputArea.setText(idx == -1 ? "Student not found." : "ID= " + Main.studentIDs[idx] + " | Name= " + Main.studentNames[idx] + " | Dept: =" + Main.studentDepts[idx] + "  CGPA= " + Main.cgpa[idx]);
                } else if (choice == 1) {
                    String idStr = JOptionPane.showInputDialog(this, "Enter Student ID:");
                    if (idStr == null) return;
                    int id = Integer.parseInt(idStr.trim());
                    Main.bubbleSortByID();
                    int idx = Main.binarySearch(id, 0, Main.studentCount - 1);
                    outputArea.setText(idx == -1 ? "Student not found." : "ID= " + Main.studentIDs[idx] + " | Name= " + Main.studentNames[idx] + " | Dept: =" + Main.studentDepts[idx] + "  CGPA= " + Main.cgpa[idx]);
                } else if (choice == 2) {
                    String name = JOptionPane.showInputDialog(this, "Enter Student Name:");
                    if (name == null) return;
                    StringBuilder sb = new StringBuilder();
                    boolean found = false;
                    for (int i = 0; i < Main.studentCount; i++) {
                        if (Main.studentNames[i].equalsIgnoreCase(name.trim())) {
                            sb.append("ID= " + Main.studentIDs[i] + " | Name= " + Main.studentNames[i] + " | Dept: =" + Main.studentDepts[i] + " CGPA = " + Main.cgpa[i] + "\n");
                            found = true;
                        }
                    }
                    outputArea.setText(found ? sb.toString() : "No students found matching " + name);
                }
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input. Enter a number.");
            }
        });
        sortBtn.addActionListener(e -> {
            String[] options = {"Sort by Student ID", "Sort by Name", "Sort by CGPA (highest first)"};
            int choice = JOptionPane.showOptionDialog(this, "Choose sort method:", "Sort Students",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice == 0) Main.bubbleSortByID();
            else if (choice == 1) Main.bubbleSortByName();
            else if (choice == 2) Main.bubbleSortByCGPA();
            else return;
            StringBuilder sb = new StringBuilder("ID     Name       Dept    CGPA\n");
            for (int i = 0; i < Main.studentCount; i++)
                sb.append(Main.studentIDs[i] + "      " + Main.studentNames[i] + "      " + Main.studentDepts[i] + "       " + Main.cgpa[i] + "\n");
            outputArea.setText(sb.toString());
        });
        logoutBtn.addActionListener(e -> {
            Main.saveAllData();
            outputArea.setText("Data saved. Logging out.");
            dispose();
            new RoleSelectionPage();
        });
    }
    private double promptMark(String prompt, double max) {
        while (true) {
            String val = JOptionPane.showInputDialog(this, prompt);
            if (val == null) return 0;
            try {
                double d = Double.parseDouble(val.trim());
                if (d < 0) JOptionPane.showMessageDialog(this, "Invalid input. Marks cannot be negative.");
                else if (d > max) JOptionPane.showMessageDialog(this, "Invalid input. marks cannot exceed " + (int) max + ".");
                else return d;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. enter a number.");
            }
        }
    }
    static String buildTranscript(int idx) {
        StringBuilder sb = new StringBuilder();
        sb.append("           ACADEMIC TRANSCRIPT             \n");
        sb.append("Student Name : " + Main.studentNames[idx] + "\n");
        sb.append("Student ID   : " + Main.studentIDs[idx] + "\n");
        sb.append("Department   : " + Main.studentDepts[idx] + "\n");
        int cc = Main.courseCount[idx];
        if (cc == 0) { sb.append("No courses registered."); return sb.toString(); }
        int maxSem = 0;
        for (int i = 0; i < cc; i++) if (Main.courseSem[idx][i] > maxSem) maxSem = Main.courseSem[idx][i];
        double totalGP = 0; int totalCourse = 0; boolean pending = false;
        for (int sem = 1; sem <= maxSem; sem++) {
            boolean headerPrinted = false;
            double semGP = 0; int semCourses = 0;
            for (int i = 0; i < cc; i++) {
                if (Main.courseSem[idx][i] != sem) continue;
                if (!headerPrinted) {
                    sb.append("  SEMESTER " + sem + "\n");
                    sb.append("Course  Marks   Grade  Points\n");
                    headerPrinted = true;
                }
                if (!Main.gradeCalc[idx][i]) {
                    sb.append(Main.courseNames[idx][i] + "  Grade not calculated. Contact your teacher.\n");
                    pending = true;
                } else {
                    double total = Main.quizMarks[idx][i] + Main.asgmMarks[idx][i] + Main.midMarks[idx][i] + Main.finalMarks[idx][i];
                    double gp = Main.marksToGradePoint(total);
                    sb.append(Main.courseNames[idx][i] + "  " + total + "  " + Main.marksToGrade(total) + "  " + gp + "\n");
                    semGP += gp; semCourses++;
                }
            }
            if (semCourses > 0) {
                sb.append("  Semester GPA = " + semGP / semCourses + "\n");
                totalGP += semGP; totalCourse += semCourses;
            }
        }
        sb.append("Overall CGPA = " + (totalCourse > 0 ? totalGP / totalCourse : 0.0) + "\n");
        if (pending) sb.append(" Contact your teacher for pending grades.\n");
        return sb.toString();
    }
}