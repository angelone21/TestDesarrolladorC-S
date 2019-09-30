package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.Coment;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase: ControladorComent
 *
 * @version: 0.1
 *
 * @since: 16/09/2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone
 *
 * Copyrigth: CECAR
 */
public final class ControladorComent {

    public void guardar(Coment coment) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("insert into coment values(?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, coment.getId_coment());
        preparedStatement.setInt(2, coment.getId_post());
        preparedStatement.setString(3, coment.getBody());
        preparedStatement.setString(4, coment.getName());
        preparedStatement.setString(5, coment.getEmail());
        preparedStatement.setString(6, coment.getSelf());
        preparedStatement.setString(7, coment.getEdit());

        preparedStatement.execute();
    }

    public void eliminarTodo() throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("delete from coment");
        preparedStatement.execute();
    }

}
