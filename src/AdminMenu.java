import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        titleRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                leadActorActressRadioButton.setSelected(false);
                genreRadioButton.setSelected(false);
                releaseYearRadioButton.setSelected(false);
            }
        });
        leadActorActressRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                titleRadioButton.setSelected(false);
                genreRadioButton.setSelected(false);
                releaseYearRadioButton.setSelected(false);
            }
        });
        genreRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                titleRadioButton.setSelected(false);
                leadActorActressRadioButton.setSelected(false);
                releaseYearRadioButton.setSelected(false);
            }
        });
        releaseYearRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                titleRadioButton.setSelected(false);
                leadActorActressRadioButton.setSelected(false);
                genreRadioButton.setSelected(false);
            }
        });
    }
}
