package Concursos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class BdExport implements Export {
    @Override
    public void guardarInscripcion(int idParticipante, int idConcurso) {
        String sql = "INSERT INTO registroConcurso (fecha, id_Persona, id_Concurso) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2, idParticipante);
            ps.setInt(3, idConcurso);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar", e);
        }


    }
}

