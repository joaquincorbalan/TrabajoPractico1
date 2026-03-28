package Restaurante;

import Concursos.ConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class BdExportRes implements Export {
    @Override
    public void guardarOperacion(double monto) {
        String sql = "INSERT INTO registroVenta (fecha, monto) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setDouble(2, monto);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar", e);
        }
    }
}
