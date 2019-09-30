package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.Photo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase: ControladorPhoto
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
public final class ControladorPhoto {

    public void guardar(Photo photo) throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("insert into photo values(?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, photo.getId_photo());
        preparedStatement.setInt(2, photo.getId_album());
        preparedStatement.setString(3, photo.getTitle());
        preparedStatement.setString(4, photo.getUrl());
        preparedStatement.setString(5, photo.getThumbnail());
        preparedStatement.setString(6, photo.getSelf());
        preparedStatement.setString(7, photo.getEdit());

        preparedStatement.execute();
    }

    public void eliminarTodo() throws SQLException {
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("delete from photo");
        preparedStatement.execute();
    }

}
