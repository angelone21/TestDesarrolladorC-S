
package edu.cecar.vistas;

import edu.cecar.controladores.ControladorServidor;

/**
 * Clase: VistaServidor
 * 
 * @version: 0.1
 *  
 * @since: 27/09/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: Vincenzo Angelone
 * 
 * Copyrigth: CECAR
 */
public final class VistaServidor {

    public static void main(String[] args) {
        new ControladorServidor(17000);
    }
}
