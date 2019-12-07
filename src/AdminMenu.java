import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JDialog {
    private JPanel contentPane;
    private JButton displayAllButton;
    private JButton searchButton;
    private JButton addMovieButton;
    private JButton removeMovieButton;
    private JButton sortButton;
    private JButton mainMenuButton;
    private JButton unlockButton;
    private JTextArea textArea1;
    private JPasswordField passwordField1;
    private JTextField inputSearchQueryTextField;
    private JTextField textField1;
    private JRadioButton titleRadioButton;
    private JRadioButton leadActorActressRadioButton;
    private JRadioButton genreRadioButton;
    private JRadioButton releaseYearRadioButton;
    private JButton enterButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton addMovieButton1;
    private JTextField titleTextField;
    private JTextField leadActorActressTextField;
    private JTextField genreTextField;
    private JTextField releaseYearTextField;
    private JTextField enterMovieNumberToTextField;
    private JTextField textField7;
    private JButton removeButton;
    private JRadioButton quickSortRadioButton;
    private JRadioButton bubbleSortRadioButton;
    private JCheckBox aZCheckBox;
    private JCheckBox zACheckBox;
    private JButton sortButton1;

    public AdminMenu() {

        setContentPane(contentPane);
        setModal(true);
        final int[] i = {0};
        getRootPane().setDefaultButton(displayAllButton);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(mainMenuButton.getActionCommand().equals(actionEvent.getActionCommand())){
                    dispose();
                }
                if(unlockButton.getActionCommand().equals(actionEvent.getActionCommand())){
                    Driver.setTypedPassword(String.valueOf(passwordField1.getPassword()));
                    if(Driver.testPassword()){
                        displayAllButton.setEnabled(true);
                        searchButton.setEnabled(true);
                        addMovieButton.setEnabled(true);
                        removeMovieButton.setEnabled(true);
                        sortButton.setEnabled(true);
                        unlockButton.setEnabled(false);

                    }
                    else{
                        if (i[0] < 3) {
                            String message = "Invalid Password! " + (2 - i[0]) + " attempt(s) remaining.";
                            JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            i[0]++;
                            if (i[0] == 3)
                                dispose();
                        }
                    }

                }
                if(displayAllButton.getActionCommand().equals(actionEvent.getActionCommand())){
                    textArea1.setText(Driver.methods.toString());
                }
                if(searchButton.getActionCommand().equals(actionEvent.getActionCommand())){
                    displayAllButton.setEnabled(false);
                    searchButton.setEnabled(false);
                    addMovieButton.setEnabled(false);
                    removeMovieButton.setEnabled(false);
                    sortButton.setEnabled(false);
                    textField1.setEditable(true);
                    textField1.setEnabled(true);
                    titleRadioButton.setEnabled(true);
                    leadActorActressRadioButton.setEnabled(true);
                    genreRadioButton.setEnabled(true);
                    releaseYearRadioButton.setEnabled(true);
                    enterButton.setEnabled(true);
                    textField1.setText("");

                }
            }

        };
        displayAllButton.addActionListener(listener);
        searchButton.addActionListener(listener);
        addMovieButton.addActionListener(listener);
        removeMovieButton.addActionListener(listener);
        sortButton.addActionListener(listener);
        mainMenuButton.addActionListener(listener);
        unlockButton.addActionListener(listener);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayAllButton.setEnabled(true);
                searchButton.setEnabled(true);
                addMovieButton.setEnabled(true);
                removeMovieButton.setEnabled(true);
                sortButton.setEnabled(true);
                textField1.setEditable(false);
                textField1.setEnabled(false);
                titleRadioButton.setEnabled(false);
                leadActorActressRadioButton.setEnabled(false);
                genreRadioButton.setEnabled(false);
                releaseYearRadioButton.setEnabled(false);
                enterButton.setEnabled(false);
                String searchTest = textField1.getText();
                if(titleRadioButton.isSelected())
                    textArea1.setText(Driver.methods.searchMovie(1, searchTest));
                else if (leadActorActressRadioButton.isSelected())
                    textArea1.setText(Driver.methods.searchMovie(2, searchTest));
                else if (genreRadioButton.isSelected())
                    textArea1.setText(Driver.methods.searchMovie(3, searchTest));
                else if (releaseYearRadioButton.isSelected())
                    textArea1.setText(Driver.methods.searchMovie(4, searchTest));
            }
        });
        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayAllButton.setEnabled(false);
                searchButton.setEnabled(false);
                addMovieButton.setEnabled(false);
                removeMovieButton.setEnabled(false);
                sortButton.setEnabled(false);
                textField2.setEnabled(true);
                textField2.setEditable(true);
                textField3.setEnabled(true);
                textField3.setEditable(true);
                textField4.setEnabled(true);
                textField4.setEditable(true);
                textField5.setEnabled(true);
                textField5.setEditable(true);
                addMovieButton1.setEnabled(true);
                titleTextField.setEnabled(true);
                leadActorActressTextField.setEnabled(true);
                genreTextField.setEnabled(true);
                releaseYearTextField.setEnabled(true);
            }
        });
        addMovieButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayAllButton.setEnabled(true);
                searchButton.setEnabled(true);
                addMovieButton.setEnabled(true);
                removeMovieButton.setEnabled(true);
                sortButton.setEnabled(true);
                textField2.setEnabled(false);
                textField2.setEditable(false);
                textField3.setEnabled(false);
                textField3.setEditable(false);
                textField4.setEnabled(false);
                textField4.setEditable(false);
                textField5.setEnabled(false);
                textField5.setEditable(false);
                addMovieButton1.setEnabled(false);
                titleTextField.setEnabled(false);
                leadActorActressTextField.setEnabled(false);
                genreTextField.setEnabled(false);
                releaseYearTextField.setEnabled(false);
                Driver.methods.addMovies(textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText());
                textArea1.setText(Driver.methods.toString());
            }
        });
        removeMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField7.setText("");
                textArea1.setText(Driver.methods.toString());
                displayAllButton.setEnabled(false);
                searchButton.setEnabled(false);
                addMovieButton.setEnabled(false);
                removeMovieButton.setEnabled(false);
                sortButton.setEnabled(false);
                removeButton.setEnabled(true);
                enterMovieNumberToTextField.setEnabled(true);
                textField7.setEnabled(true);
                textField7.setEditable(true);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayAllButton.setEnabled(true);
                searchButton.setEnabled(true);
                addMovieButton.setEnabled(true);
                removeMovieButton.setEnabled(true);
                sortButton.setEnabled(true);
                removeButton.setEnabled(false);
                enterMovieNumberToTextField.setEnabled(false);
                textField7.setEnabled(false);
                textField7.setEditable(false);
                Driver.methods.removeMovie(Integer.parseInt(textField7.getText()));
                textArea1.setText(Driver.methods.toString());
            }
        });
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayAllButton.setEnabled(false);
                searchButton.setEnabled(false);
                addMovieButton.setEnabled(false);
                removeMovieButton.setEnabled(false);
                sortButton.setEnabled(false);
                sortButton1.setEnabled(true);
                quickSortRadioButton.setEnabled(true);
                bubbleSortRadioButton.setEnabled(true);
                aZCheckBox.setEnabled(true);
                zACheckBox.setEnabled(true);
            }
        });
        sortButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayAllButton.setEnabled(true);
                searchButton.setEnabled(true);
                addMovieButton.setEnabled(true);
                removeMovieButton.setEnabled(true);
                sortButton.setEnabled(true);
                sortButton1.setEnabled(false);
                quickSortRadioButton.setEnabled(false);
                bubbleSortRadioButton.setEnabled(false);
                aZCheckBox.setEnabled(false);
                zACheckBox.setEnabled(false);
                int sortType = 1, sortChoice = 1;
                if (!quickSortRadioButton.isSelected())
                    sortType = 0;

                if (!aZCheckBox.isSelected())
                    sortChoice = 0;

                textArea1.setText(Driver.sortFound(sortType, sortChoice, Driver.movieList));
            }
        });
    }
}
