import java.awt.*;
import javax.swing.*;

public class SortedListFrame extends JFrame {
    private SortedList sortedList = new SortedList();
    private JTextArea displayArea = new JTextArea();
    private JTextField addField = new JTextField(15);
    private JTextField searchField = new JTextField(15);
    private JButton addButton = new JButton("Add");;
    private JButton searchButton = new JButton("Search");;



    public SortedListFrame(){
        setTitle("Lab 10 Sorted List");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

       displayArea.setEditable(false);
       add(new JScrollPane(displayArea), BorderLayout.CENTER);
       add(createInputPanel(), BorderLayout.NORTH);

       addButton.addActionListener(e -> addword());
       searchButton.addActionListener(e -> searchWord());
    }
    private JPanel createInputPanel(){
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Add:"));
        panel.add(addField);
        panel.add(addButton);


        panel.add(new JLabel("Search:"));
        panel.add(searchField);
        panel.add(searchButton);






       return panel;

    }
    private void addword(){
        String word = addField.getText().trim();
        if (word.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a word to add.");
            return;
        }
        sortedList.add(word);
        displayArea.append("Added: " + word + "   List: " + sortedList + "\n");
        addField.setText("");
    }
    private void searchWord(){
        String word = searchField.getText().trim();
        if (word.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a word to search.");
            return;
        }
        int index = sortedList.binarySearch(word);
        if (index < sortedList.size() && sortedList.get(index).equals(word)) {
            displayArea.append("Found: " + word + "   at index: " + index + "\n");

        }
        else{
            displayArea.append("Not found: " + word + "   would be inserted at index: " + index + "\n");

        }
        searchField.setText("");
    }
}

