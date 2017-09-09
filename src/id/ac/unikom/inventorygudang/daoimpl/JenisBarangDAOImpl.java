/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.daoimpl;

import id.ac.unikom.inventorygudang.dao.JenisBarangDAO;
import id.ac.unikom.inventorygudang.entity.JenisBarang;
import id.ac.unikom.inventorygudang.utility.DatabaseConnectivity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saeful Rahman
 */
public class JenisBarangDAOImpl implements JenisBarangDAO {

    private final java.sql.Connection conn;

    public JenisBarangDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<JenisBarang> getJenisBarang() {
        return getJenisBarang(null);
    }

    @Override
    public ArrayList<JenisBarang> getJenisBarang(String cari) {
         ArrayList<JenisBarang> arrayJenisBarang = null;
        PreparedStatement state = null;

        boolean isSearching = cari != null && !cari.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM tb_jenis WHERE jenis_barang LIKE ?";
        } else {
            SELECT = "SELECT * FROM tb_jenis";
        }

        try {
            state = conn.prepareStatement(SELECT);

            if (isSearching) {
                state.setString(1, "%" + cari + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayJenisBarang = new ArrayList<>();
                while (result.next()) {
                    JenisBarang jenisBarang = new JenisBarang();
                    jenisBarang.setNoJenis(result.getInt(1));
                    jenisBarang.setNamaJenisBarang(result.getString(2));
                    arrayJenisBarang.add(jenisBarang);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JenisBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayJenisBarang;}

    @Override
    public boolean tambahJenisBarang(JenisBarang jenisBarang) {
        String INSERT = "INSERT INTO tb_jenis(jenis_barang) VALUES (?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, jenisBarang.getNamaJenisBarang());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean ubahJenisBarang(JenisBarang jenisBarang) {
        String UPDATE = "UPDATE tb_jenis "
                + "SET jenis_barang = ? "
                + "WHERE no_jenis = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, jenisBarang.getNamaJenisBarang());
            state.setInt(2, jenisBarang.getNoJenis());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean hapusJenisBarang(int noJenis) {
        String DELETE = "DELETE FROM tb_jenis "
                + "WHERE no_jenis = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setInt(1, noJenis);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(JenisBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
