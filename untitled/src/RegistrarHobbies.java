import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrarHobbies extends JFrame {
    private JPanel panel1;
    private JTextField nombreTextField;
    private JTextField descripTextField;
    private JButton registrarButton;
    private JButton volverButton;

    public RegistrarHobbies() {
        super("Registro");
        setContentPane(panel1);
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String descripcion = descripTextField.getText();

            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Hobbies hobbies = new Hobbies();
                hobbies.setVisible(true);
            }
        });
    }


    public void RegistrarHobbies(String nombre, String descripcion) throws SQLException
    {
        Connection connection = conexion();

        String sql = "INSERT INTO hobbies (nombre, descripcion) " +
                "VALUES ((?), (?));";

        PreparedStatement prst = connection.prepareStatement(sql);

        prst.setString(1, nombre);
        prst.setString(2, descripcion);

        int efecto = prst.executeUpdate();

        if (efecto > 0)
        {
            JOptionPane.showMessageDialog(null, "Biografía registrada satisfactoriamente");
        }
    }




    public Connection conexion() throws SQLException
    {
        String url = "jdbc:mysql://127.0.0.1:3306/tareas11";
        String user = "root";
        String password = "vamossobreruedasdefuegoAa@_";

        return DriverManager.getConnection(url, user, password);
    }
}

