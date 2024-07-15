import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel panel1;
    private JButton biografiaButton;
    private JButton hobbiesButton;
    private JButton cerrarSesionButton;

    public Menu() {
        super("Menú");
        setContentPane(panel1);
        setSize(250, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        });

        biografiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Biografia biografia = new Biografia();
                biografia.setVisible(true);
            }
        });

        hobbiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Hobbies hobbies = new Hobbies();
                hobbies.setVisible(true);
            }
        });
    }
}
