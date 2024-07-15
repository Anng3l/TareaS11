import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/*
* CREATE TABLE `tareas11`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(12) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `edad` INT NULL,
  `nacionalidad` VARCHAR(45) NULL,
  `biografia` TINYTEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) VISIBLE);

*CREATE TABLE `tareas11`.`hobbies` (
  `id_hobbies` INT NOT NULL AUTO_INCREMENT,
  `nombre_hobbies` VARCHAR(45) NOT NULL,
  `descrip_hobbies` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_hobbies`),
  UNIQUE INDEX `nombre_hobbies_UNIQUE` (`nombre_hobbies` ASC) VISIBLE);
* */

public class Login extends JFrame{
    private JPanel panel1;
    private JButton iniciarSesionButton;
    private JButton salirButton;
    private JTextField usuarioTextField;
    private JTextField passwordTextField;

    public Login() {
        super("Login");
        setContentPane(panel1);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioTextField.getText();
                String password = passwordTextField.getText();

                if (usuario.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Ingrese credenciales");
                }
                else
                {
                    boolean x;

                    try {
                        x = login(usuario, password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }



                    if (x)
                    {
                        dispose();
                        JOptionPane.showMessageDialog(null, "Sesión iniciada correctamente");
                        dispose();
                        Menu menu = new Menu();
                        menu.setVisible(true);
                    }
                    else if (!x)
                    {
                        JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
                    }
                }
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public boolean login(String usuario, String password) throws SQLException
    {
        boolean confirmacion=false;

        Connection connection = conexion();

        String sql = "SELECT * FROM usuarios WHERE usuario = (?)";

        PreparedStatement prst = connection.prepareStatement(sql);
        prst.setString(1, usuario);

        ResultSet rs = prst.executeQuery();

        String user="";
        String contra="";
        if (rs.next())
        {
            user = rs.getString("usuario");
            contra = rs.getString("password");
        }

        if (user.equals(usuario) && contra.equals(password))
        {
            confirmacion = true;
            return confirmacion;
        }
        else
        {
            confirmacion = false;
            return confirmacion;
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
