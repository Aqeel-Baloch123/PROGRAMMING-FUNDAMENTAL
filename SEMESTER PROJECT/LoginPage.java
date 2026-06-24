import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginPage extends JFrame {
    private JTextField UnameField;
    private JLabel Unamelable;
    private JPasswordField PassField;
    private JLabel passlabel;
    private JButton button1;
    private JButton backButton;
    private JPanel Panell;
    private String role;
    public LoginPage(String role) {
        this.role = role;
        setTitle(role + " Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        button1 = new JButton("Login");
        backButton = new JButton("Back");
        UnameField = new JTextField(10);
        PassField = new JPasswordField(10);
        Unamelable = new JLabel("Username:");
        passlabel = new JLabel("Password:");
        JPanel userPanel = new JPanel();
        userPanel.add(Unamelable);
        userPanel.add(UnameField);
        JPanel passPanel = new JPanel();
        passPanel.add(passlabel);
        passPanel.add(PassField);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(backButton);
        Panell = new JPanel();
        Panell.add(new JLabel(role.toUpperCase() + " LOGIN", JLabel.CENTER));
        Panell.add(userPanel);
        Panell.add(passPanel);
        Panell.add(buttonPanel);
        add(Panell);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RoleSelectionPage();
            }
        });
    }
    private void handleLogin() {
        String username = UnameField.getText();
        String password = new String(PassField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill username and password.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (role.equals("Teacher")) {
            boolean found = false;
            for (int i = 0; i < Main.teacherCount; i++) {
                if (Main.teacherUsernames[i].equals(username) &&
                        Main.teacherPasswords[i].equals(password)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                dispose();
                new TeacherDashboard(username);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (role.equals("Student")) {
            boolean found = false;
            for (int i = 0; i < Main.studentCount; i++) {
                if (Main.studentUsernames[i] != null
                        && Main.studentUsernames[i].equals(username)
                        && Main.studentPasswords[i].equals(password)) {
                    found = true;
                    dispose();
                    new StudentDashboard(i);
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(null, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}