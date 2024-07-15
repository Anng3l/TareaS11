import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VerBiografia extends JFrame{
    private JPanel panel1;
    private JTextField nombreTextField;
    private JButton buscarButton;
    private JButton volverButton;

    public VerBiografia() {
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

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                try {
                    Mostrar(nombre);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void Mostrar(String nombre) throws SQLException
    {
        Connection connection = conexion();

        String sql = "SELECT * FROM usuarios WHERE nombre = (?);";

        PreparedStatement prst = connection.prepareStatement(sql);

        prst.setString(1, nombre);

        ResultSet rs = prst.executeQuery();

        String usuario="";
        String name="";
        String apellido="";
        Integer edad=0;
        String nacionalidad="";
        String biografia="";
        if (rs.next())
        {
            usuario = rs.getString("usuario");
            name = rs.getString("nombre");
            apellido = rs.getString("apellido");
            edad = rs.getInt("edad");
            nacionalidad = rs.getString("nacionalidad");
            biografia = rs.getString("biografia");

            JOptionPane.showMessageDialog(null, "Usuario: "
                    + usuario + "\nNombre: " + name + "\nApellido: " + apellido + "\nEdad: " + edad +
                    "\nNacionalidad: " + nacionalidad + "\nBiografía: " + biografia);
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
