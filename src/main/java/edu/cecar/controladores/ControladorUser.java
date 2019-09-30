
package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase: ControladorUser
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
public final class ControladorUser {
    
    public void guardar(User user) throws SQLException{
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("insert into user values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, user.getId_user());
        preparedStatement.setString(2, user.getFirst_name());
        preparedStatement.setString(3, user.getLast_name());
        preparedStatement.setString(4, user.getGender());
        preparedStatement.setString(5, user.getDob());
        preparedStatement.setString(6, user.getEmail());
        preparedStatement.setString(7, user.getPhone());
        preparedStatement.setString(8, user.getWebsite());
        preparedStatement.setString(9, user.getAdress());
        preparedStatement.setString(10, user.getStatus());
        preparedStatement.setString(11, user.getSelf());
        preparedStatement.setString(12, user.getEdit());
        preparedStatement.setString(13, user.getAvatar());        
        preparedStatement.execute();
    }
    
    
    public void eliminarTodo()throws SQLException{
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("delete from user");
        preparedStatement.execute();
    }

}
