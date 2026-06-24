import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RoleSelectionPage extends JFrame {
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JButton teacherButton;
    private JButton studentButton;
    private JButton exitButton;
    public RoleSelectionPage() {
        setTitle("University Student Management System");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));
        titleLabel = new JLabel("SELECT YOUR ROLE", JLabel.CENTER);
        teacherButton = new JButton("1. Teacher Login");
        studentButton = new JButton("2. Student Login");
        exitButton = new JButton("3. Exit");
        mainPanel.add(titleLabel);
        mainPanel.add(teacherButton);
        mainPanel.add(studentButton);
        mainPanel.add(exitButton);
        add(mainPanel);
        setVisible(true);
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage("Teacher");
            }
        });
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage("Student");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.saveAllData();
                JOptionPane.showMessageDialog(null, "Data saved. Goodbye!");
                System.exit(0);
            }
        });
    }
}