import javax.swing.*;
import java.awt.*;
public class StudentDashboard extends JFrame {
    private int idx;
    private JTextArea outputArea;
    public StudentDashboard(int idx) {
        this.idx = idx;
        setTitle("Student Dashboard");
        setSize(650, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel infoLabel         = new JLabel("Student: " + Main.studentNames[idx] + "  |  ID: " + Main.studentIDs[idx] + "  |  Dept: " + Main.studentDepts[idx]);
        JButton coursesButton    = new JButton("View Courses");
        JButton marksButton      = new JButton("View Marks");
        JButton gradesButton     = new JButton("View Grades");
        JButton transcriptButton = new JButton("View Transcript");
        JButton logoutButton     = new JButton("Logout");
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        outputArea.setRows(5);
        outputArea.setColumns(50);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(560, 100));
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 8, 8));
        buttonPanel.add(infoLabel);
        buttonPanel.add(coursesButton);
        buttonPanel.add(marksButton);
        buttonPanel.add(gradesButton);
        buttonPanel.add(transcriptButton);
        buttonPanel.add(logoutButton);
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
        coursesButton.addActionListener(e    -> showCourses());
        marksButton.addActionListener(e      -> showMarks());
        gradesButton.addActionListener(e     -> showGrades());
        transcriptButton.addActionListener(e -> outputArea.setText(TeacherDashboard.buildTranscript(idx)));
        logoutButton.addActionListener(e     -> { dispose(); new RoleSelectionPage(); });
    }
    private void showCourses() {
        int cc = Main.courseCount[idx];
        if (cc == 0) { outputArea.setText("No courses registered yet."); return; }
        StringBuilder sb = new StringBuilder("Registered Courses\n\n");
        for (int i = 0; i < cc; i++)
            sb.append(Main.courseNames[idx][i] + " - Semester " + Main.courseSem[idx][i] + "\n");
        outputArea.setText(sb.toString());
    }
    private void showMarks() {
        int cc = Main.courseCount[idx];
        if (cc == 0) { outputArea.setText("No courses found."); return; }
        StringBuilder sb = new StringBuilder("My Marks\n\n");
        for (int i = 0; i < cc; i++) {
            double total = Main.quizMarks[idx][i] + Main.asgmMarks[idx][i] + Main.midMarks[idx][i] + Main.finalMarks[idx][i];
            sb.append(Main.courseNames[idx][i] + "  Quiz:" + Main.quizMarks[idx][i] + "  Asgmt:" + Main.asgmMarks[idx][i] + "  Mid:" + Main.midMarks[idx][i] + "  Final:" + Main.finalMarks[idx][i] + "  Total:" + total);
            if (total == 0) sb.append("  (Pending)");
            sb.append("\n");
        }
        outputArea.setText(sb.toString());
    }
    private void showGrades() {
        int cc = Main.courseCount[idx];
        if (cc == 0) { outputArea.setText("No courses found."); return; }
        StringBuilder sb = new StringBuilder("Grades\n\n");
        for (int i = 0; i < cc; i++) {
            if (!Main.gradeCalc[idx][i]) {
                sb.append(Main.courseNames[idx][i] + " - Grade not calculated. Contact your teacher.\n");
            } else {
                double total = Main.quizMarks[idx][i] + Main.asgmMarks[idx][i] + Main.midMarks[idx][i] + Main.finalMarks[idx][i];
                sb.append(Main.courseNames[idx][i] + "  Total:" + total + "  Grade:" + Main.marksToGrade(total) + "\n");
            }
        }
        sb.append("\nCGPA: " + Main.cgpa[idx]);
        outputArea.setText(sb.toString());
    }
}