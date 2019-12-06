import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JDialog {
    private JPanel contentPane;
    private JButton buttonAdmin;
    private JButton buttonCustomer;
    private JButton quitButton;

    public MainMenu() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonAdmin);

        buttonAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAdmin();
            }
        });

        buttonCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCustomer();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onQuit();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onAdmin() {
        // add your code here
        this.setEnabled(false);
        AdminMenu dialog = new AdminMenu();
        dialog.pack();
        dialog.setVisible(true);
        this.setEnabled(true);
    }

    private void onCustomer() {
        // add your code here if necessary
        dispose();
    }

    private void onQuit() {
        // add your code here if necessary
        dispose();
    }
}
