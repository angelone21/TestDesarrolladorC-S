package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.Album;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase: ControladorAlbum
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
public final class ControladorAlbum {

    public void guardar(Album album) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("insert into album values(?,?,?,?,?)");
        preparedStatement.setInt(1, album.getId_album());
        preparedStatement.setInt(2, album.getId_user());
        preparedStatement.setString(3, album.getTitle());
        preparedStatement.setString(4, album.getSelf());
        preparedStatement.setString(5, album.getEdit());

        preparedStatement.execute();
    }

    public void eliminarTodo() throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("delete from album");
        preparedStatement.execute();
    }

}
