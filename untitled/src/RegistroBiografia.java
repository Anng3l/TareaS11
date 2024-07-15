import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroBiografia extends JFrame{
    private JPanel panel1;
    private JTextField nombreTextField;
    private JTextField apellidoTextField;
    private JTextField edadTextField;
    private JTextField nacionalidadTextField;
    private JTextArea biografiaTextArea;
    private JButton registrarButton;
    private JButton volverButton;

    public RegistroBiografia() {
        super("Registro");
        setContentPane(panel1);
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Biografia biografia = new Biografia();
                biografia.setVisible(true);
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String apellido = apellidoTextField.getText();
                int edad = Integer.parseInt(edadTextField.getText());
                String nacionalidad = nacionalidadTextField.getText();
                String biografia = biografiaTextArea.getText();
            }
        });
    }


    public void RegistrarBiografia(String nombre, String apellido, Integer edad, String nacionalidad, String biografia) throws SQLException
    {
        Connection connection = conexion();

        String sql = "INSERT INTO usuarios (nombre, " +
                "apellido, edad, nacionalidad, biografia" +
                "VALUES ((?), (?), (?), (?), (?));";

        PreparedStatement prst = connection.prepareStatement(sql);

        prst.setString(1, nombre);
        prst.setString(2, apellido);
        prst.setInt(3, edad);
        prst.setString(4, nacionalidad);
        prst.setString(5, biografia);

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
