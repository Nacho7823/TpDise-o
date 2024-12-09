
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.CuatrimestreDAO;
import grupo3a.tp_diseno.Exceptions.Exceptions.DAOException;
import grupo3a.tp_diseno.Modelos.Cuatrimestre;
import grupo3a.tp_diseno.database.DataBaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CuatrimestreSqlDAO implements CuatrimestreDAO{

    public CuatrimestreSqlDAO() {
    }
    
    //singleton
    private static CuatrimestreSqlDAO instance;
    public static CuatrimestreSqlDAO getInstance(){
        if(CuatrimestreSqlDAO.instance == null)CuatrimestreSqlDAO.instance =  new CuatrimestreSqlDAO();
        return CuatrimestreSqlDAO.instance;
    }
    
    
    @Override
    public Cuatrimestre buscarPorId(int id){
        
        
        return null;
    }
    
    @Override
    public List<Cuatrimestre> getCuatrimestresActuales() throws DAOException{
        String query = "SELECT id_cuatrimestre, fecha_inicio_cuatrimestre, fecha_fin_cuatrimestre FROM cuatrimestre "+
                "WHERE EXTRACT(YEAR FROM fecha_inicio_cuatrimestre) = EXTRACT(YEAR FROM CURRENT_DATE) " +
                "OR EXTRACT(YEAR FROM fecha_fin_cuatrimestre) = EXTRACT(YEAR FROM CURRENT_DATE);";
        List<Cuatrimestre> cuatrimestres = new ArrayList<>();
        try(Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                int id = rs.getInt("id_cuatrimestre");
                Date fechaIni = rs.getDate("fecha_inicio_cuatrimestre");
                Date fechaF = rs.getDate("fecha_fin_cuatrimestre");
                
                LocalDate fechaInicio = fechaIni.toLocalDate();
                LocalDate fechaFin = fechaF.toLocalDate();
                
                Cuatrimestre cuat = new Cuatrimestre(id,fechaInicio,fechaFin);
                cuatrimestres.add(cuat);
            }            
            
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
            //System.out.println("Error al listar los cuatrimestres. Se devuelve lista vacia.");
        }
        
        return cuatrimestres;
    }
}
