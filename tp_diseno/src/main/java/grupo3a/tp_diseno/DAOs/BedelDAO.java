/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo3a.tp_diseno.DAOs;

import grupo3a.tp_diseno.Modelos.Bedel;
import grupo3a.tp_diseno.Modelos.Exceptions.DAOException;

/**
 *
 * @author exero
 */
public interface BedelDAO {
    void crear(Bedel bedel) throws DAOException;
}
