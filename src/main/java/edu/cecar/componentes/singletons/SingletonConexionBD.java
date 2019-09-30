/**
 * Clase: SingletonConexionBD
 * 
 * @version: 0.1
 *  
 * @since: 17/09/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: Vincenzo Angelone Salgado
 * 
 * Copyrigth: CECAR
 */
package edu.cecar.componentes.singletons;

import edu.cecar.componentes.baseDatos.ConectarMySQL;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Singleton que devuelve una conexion a una base de datos
 */
public final class SingletonConexionBD {
    
    
    private static Connection connection;
    
    public static Connection getinstance(){
        
        if(connection == null){ 
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("recursos/Conexion.properties"));
            connection = new ConectarMySQL(properties.getProperty("host"),properties.getProperty("baseDatos"),properties.getProperty("port"),properties.getProperty("usuario"),properties.getProperty("password")).getConnection();
        } catch (IOException ex) {
            Logger.getLogger(SingletonConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        return connection;
    }
    
    
    
}
