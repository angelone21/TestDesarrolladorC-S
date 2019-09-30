package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase: ControladorUsuario
 *
 * @version: 0.1
 *
 * @since: 18/09/2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone
 *
 * Copyrigth: CECAR
 */
public final class ControladorUsuario {

    public boolean consultarUsuario(String usuario, String password) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("select username, password from usuario where username=? and password = ?");
        preparedStatement.setString(1, usuario);
        preparedStatement.setString(2, password);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            if (result.getString(1).equals(usuario) && result.getString(2).equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean registrarUsuario(String usuario, String password) throws SQLException {
        if ((usuario.isEmpty() && password.isEmpty()) || (usuario.isEmpty() || password.isEmpty())) {
            return false;
        } else {
            boolean flag = false;
            PreparedStatement preparedStatementConsulta = SingletonConexionBD.getinstance().prepareStatement("select username from usuario where username=?");
            preparedStatementConsulta.setString(1, usuario);
            ResultSet result = preparedStatementConsulta.executeQuery();
            if (result.next()) {
                if (result.getString(1).equals(usuario)) {
                    flag = true;
                }
            }
            if (flag == false) {
                PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("insert into usuario values (?,?)");
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, password);
                preparedStatement.execute();
                return true;
            }

            return false;
        }

    }
}
