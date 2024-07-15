import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VerHobbies extends JFrame{
    private JPanel panel1;
    private JTextField hobbieTextField;
    private JButton volverButton;
    private JButton buscarButton;

    public VerHobbies() {
        super("Login");
        setContentPane(panel1);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hobbies hobbies = new Hobbies();
                hobbies.setVisible(true);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

        String nom="";
        String descrip="";
        if (rs.next())
        {
            nom = rs.getString("nombre_hobbies");
            descrip = rs.getString("descrip_hobbies");

            JOptionPane.showMessageDialog(null, "Nombre: "
                    + nom + "\nDescripción: " + descrip);
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
