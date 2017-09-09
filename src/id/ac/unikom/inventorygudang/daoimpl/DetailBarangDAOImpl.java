/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.daoimpl;

import id.ac.unikom.inventorygudang.entity.DetailBarang;
import id.ac.unikom.inventorygudang.dao.DetailBarangDAO;
import id.ac.unikom.inventorygudang.utility.DatabaseConnectivity;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rahadian Nugraha
 */
public class DetailBarangDAOImpl implements DetailBarangDAO{
    
    private final java.sql.Connection conn;

    public DetailBarangDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }
    
    @Override
    public boolean tambahDetailBarang(DetailBarang detailBarang) {
        String INSERT = "INSERT INTO tb_detail_barang(kd_barang, harga_barang,"
                + "detail_jenis) VALUES (?,?,?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, detailBarang.getKodeBarang());
            state.setInt(2, detailBarang.getHargaBarang());
            state.setString(3, detailBarang.getDetailJenis());
            
            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean ubahDetailBarang(DetailBarang detailBarang) {
        String UPDATE = "UPDATE tb_detail_barang "
                + "SET harga_barang = ?, detail_jenis = ? "
                + "WHERE kd_barang = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setInt(1, detailBarang.getHargaBarang());
            state.setString(2, detailBarang.getDetailJenis());
            state.setString(3, detailBarang.getKodeBarang());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DetailBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean hapusDetailBarang(String kodeBarang) {
        String DELETE = "DELETE FROM tb_detail_barang "
                + "WHERE kd_barang = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, kodeBarang);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DetailBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean ubahDetailHarga(DetailBarang detailBarang) {
        String UPDATE = "UPDATE tb_detail_barang SET harga_barang = ? WHERE kd_barang = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setInt(1, detailBarang.getHargaBarang());
            state.setString(2, detailBarang.getKodeBarang());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DetailBarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
}
