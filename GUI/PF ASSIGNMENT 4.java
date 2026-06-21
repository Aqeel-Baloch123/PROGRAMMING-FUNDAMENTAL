import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Main extends JFrame {
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField contactField;
    private JTextField updatedNameField;
    private JTextField positionField;
    private JComboBox<String> options;
    private JButton executeButton;
    private JTextArea outputArea;
    private static final String FILE_NAME = "StudentRecord.csv";
    public Main() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1, 5, 5));
        options = new JComboBox<>(new String[]{
                "Insert at Start",
                "Insert at End",
                "Insert at Specific Position",
                "Update Record (by name)",
                "Delete Record (by name)",
                "Display All Records",
                "Exit"
        });
        nameField = new JTextField();
        ageField = new JTextField();
        contactField = new JTextField();
        positionField = new JTextField();
        updatedNameField = new JTextField();
        executeButton = new JButton("Run");
        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        mainPanel.add(new JLabel("Options:"));
        mainPanel.add(options);
        mainPanel.add(new JLabel("Name:"));
        mainPanel.add(nameField);
        mainPanel.add(new JLabel("Age:"));
        mainPanel.add(ageField);
        mainPanel.add(new JLabel("Contact Number:"));
        mainPanel.add(contactField);
        mainPanel.add(new JLabel("Position (for Insert at Specific Position):"));
        mainPanel.add(positionField);
        mainPanel.add(new JLabel("Updated Name (for Update Record):"));
        mainPanel.add(updatedNameField);
        mainPanel.add(executeButton);
        mainPanel.add(new JScrollPane(outputArea));
        setContentPane(mainPanel);
        setTitle("Student Record Management System");
        setSize(450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException ex) {
            outputArea.setText("Error creating file: " + ex.getMessage());
        }
        executeButton.addActionListener(e -> {
            String operation = (String) options.getSelectedItem();
            try {
                if (operation.equals("Insert at Start") || operation.equals("Insert at End") || operation.equals("Insert at Specific Position")) {
                    String name = nameField.getText();
                    String age = ageField.getText();
                    String contact = contactField.getText();
                    if (name.isEmpty() || age.isEmpty() || contact.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill Name, Age and Contact Number", "Input Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String record = name + "," + age + "," + contact;
                    if (operation.equals("Insert at Start")) {
                        atStart(record);
                    } else if (operation.equals("Insert at End")) {
                        atEnd(record);
                    } else {
                        String posText = positionField.getText();
                        if (posText.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Please enter a position", "Input Error", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        int pos = Integer.parseInt(posText);
                        atPosition(record, pos);
                    }
                    nameField.setText("");
                    ageField.setText("");
                    contactField.setText("");
                    positionField.setText("");
                } else if (operation.equals("Update Record (by name)")) {
                    String oldName = nameField.getText();
                    String newName = updatedNameField.getText();
                    if (oldName.isEmpty() || newName.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please fill Name and Updated Name", "Input Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    updateRecord(oldName, newName);
                    nameField.setText("");
                    updatedNameField.setText("");
                } else if (operation.equals("Delete Record (by name)")) {
                    String name = nameField.getText();
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please fill Name", "Input Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    deleteRecord(name);
                    nameField.setText("");
                } else if (operation.equals("Display All Records")) {
                    displayRecords();
                } else if (operation.equals("Exit")) {
                    System.exit(0);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Position must be a number", "Input Error", JOptionPane.WARNING_MESSAGE);
            } catch (IOException ex) {
                outputArea.setText("Error: " + ex.getMessage());
            }
        });
    }
    private void atStart(String record) throws IOException {
        File tempFile = new File("temp.csv");
        FileWriter fw = new FileWriter(tempFile);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(record);
        bw.newLine();
        FileReader fr = new FileReader(FILE_NAME);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();
        fr.close();
        fw.close();
        new File(FILE_NAME).delete();
        tempFile.renameTo(new File(FILE_NAME));
        outputArea.setText("Record inserted at start successfully");
    }
    private void atEnd(String record) throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(record);
        bw.newLine();
        bw.close();
        fw.close();
        outputArea.setText("Record inserted at end successfully");
    }
    private void atPosition(String record, int pos) throws IOException {
        FileReader fr = new FileReader(FILE_NAME);
        BufferedReader br = new BufferedReader(fr);
        int total = 0;
        while (br.readLine() != null) {
            total++;
        }
        br.close();
        fr.close();
        if (pos < 1 || pos > total + 1) {
            outputArea.setText("Invalid position. Valid range: 1 to " + (total + 1));
            return;
        }
        File tempFile = new File("temp.csv");
        FileReader fr2 = new FileReader(FILE_NAME);
        BufferedReader br2 = new BufferedReader(fr2);
        FileWriter fw = new FileWriter(tempFile);
        BufferedWriter bw = new BufferedWriter(fw);
        int currentLine = 1;
        String line;
        while ((line = br2.readLine()) != null) {
            if (currentLine == pos) {
                bw.write(record);
                bw.newLine();
            }
            bw.write(line);
            bw.newLine();
            currentLine++;
        }
        if (pos == total + 1) {
            bw.write(record);
            bw.newLine();
        }
        br2.close();
        bw.close();
        fr2.close();
        fw.close();
        new File(FILE_NAME).delete();
        tempFile.renameTo(new File(FILE_NAME));
        outputArea.setText("Record inserted at position " + pos + " successfully");
    }
    private void updateRecord(String oldName, String newName) throws IOException {
        boolean found = false;
        File tempFile = new File("temp.csv");
        FileReader fr = new FileReader(FILE_NAME);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(tempFile);
        BufferedWriter bw = new BufferedWriter(fw);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (!found && parts[0].equalsIgnoreCase(oldName)) {
                bw.write(newName + "," + parts[1] + "," + parts[2]);
                bw.newLine();
                found = true;
            } else {
                bw.write(line);
                bw.newLine();
            }
        }
        br.close();
        bw.close();
        fr.close();
        fw.close();
        if (found) {
            new File(FILE_NAME).delete();
            tempFile.renameTo(new File(FILE_NAME));
            outputArea.setText("Record updated successfully");
        } else {
            tempFile.delete();
            outputArea.setText("Record is not found");
        }
    }
    private void deleteRecord(String name) throws IOException {
        boolean found = false;
        File tempFile = new File("temp.csv");
        FileReader fr = new FileReader(FILE_NAME);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(tempFile);
        BufferedWriter bw = new BufferedWriter(fw);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (!found && parts[0].equalsIgnoreCase(name)) {
                found = true;
                continue;
            } else {
                bw.write(line);
                bw.newLine();
            }
        }
        br.close();
        bw.close();
        fr.close();
        fw.close();
        if (found) {
            new File(FILE_NAME).delete();
            tempFile.renameTo(new File(FILE_NAME));
            outputArea.setText("Record deleted successfully");
        } else {
            tempFile.delete();
            outputArea.setText("Record is not found");
        }
    }
    private void displayRecords() throws IOException {
        FileReader fr = new FileReader(FILE_NAME);
        BufferedReader br = new BufferedReader(fr);
        String line;
        boolean hasRecords = false;
        outputArea.setText("");
        outputArea.append("      All Student Records   \n");
        outputArea.append("Name   Age  Contact\n");
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                outputArea.append(parts[0] + "      " + parts[1] + "      " + parts[2] + "\n");
                hasRecords = true;
            }
        }
        br.close();
        if (!hasRecords) {
            outputArea.append(" no records found ");
        }
    }
    public static void main(String[] args) {
         new Main();
    }
}