/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.ReservaDAO;
import grupo3a.tp_diseno.DAOs.ReservaEsporadicaDAO;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.ReservaEsporadica;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author exero
 */
public class ReservaEsporadicaSqlDAO implements ReservaEsporadicaDAO {

    private ReservaDAO DAO = ReservaSqlDAO.getInstance();

    //singleton
    private static ReservaEsporadicaSqlDAO instance;

    public static ReservaEsporadicaSqlDAO getInstance() {
        if (ReservaEsporadicaSqlDAO.instance == null) {
            ReservaEsporadicaSqlDAO.instance = new ReservaEsporadicaSqlDAO();
        }
        return ReservaEsporadicaSqlDAO.instance;
    }

    @Override
    public Integer crear(ReservaEsporadica reserva) throws DAOException {

        String query = "INSERT INTO reserva_esporadica (id_reserva) VALUES (?)";
        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            conn.setAutoCommit(false);

            int idReserva = DAO.crear(reserva);

            stmt.setInt(1, idReserva);
            stmt.executeUpdate();
            System.out.println("Reserva insertada exitosamente.");
            conn.commit();
            return idReserva;
        } catch (SQLException e) {
            System.out.println("Error al agregar la reserva esporadica");
            throw new DAOException("Error al agregar la reserva esporadica: " + e.getMessage());
        }

    }

}
