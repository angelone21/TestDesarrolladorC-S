package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.Post;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase: ControladorPost
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
public final class ControladorPost {

    public void guardar(Post post) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("insert into post values(?,?,?,?,?,?)");
        preparedStatement.setInt(1, post.getId_post());
        preparedStatement.setInt(2, post.getId_user());
        preparedStatement.setString(3, post.getTitle());
        preparedStatement.setString(4, post.getBody());
        preparedStatement.setString(5, post.getSelf());
        preparedStatement.setString(6, post.getEdit());

        preparedStatement.execute();
    }

    public void eliminarTodo() throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("delete from post");
        preparedStatement.execute();
    }

}
