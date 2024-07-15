import javax.swing.*;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Biografia extends JFrame{
    private JPanel panel1;
    private JButton verBiografiaButton;
    private JButton registrarBiografiaButton;
    private JButton volverButton;

    public Biografia() {
        super("Menú de biografía");
        setContentPane(panel1);
        setSize(200, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu();

            }
        });

        registrarBiografiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegistroBiografia registroBiografia = new RegistroBiografia();
                registroBiografia.setVisible(true);
            }
        });

        verBiografiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VerBiografia verBiografia = new VerBiografia();
                verBiografia.setVisible(true);
            }
        });
    }


}
