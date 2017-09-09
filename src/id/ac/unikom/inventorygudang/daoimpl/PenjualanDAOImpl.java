/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.daoimpl;

import id.ac.unikom.inventorygudang.dao.PenjualanDAO;
import id.ac.unikom.inventorygudang.entity.Penjualan;
import id.ac.unikom.inventorygudang.utility.DatabaseConnectivity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqram
 */
public class PenjualanDAOImpl implements PenjualanDAO {

    private final java.sql.Connection conn;

    public PenjualanDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Penjualan> getPenjualan() {
        return getPenjualan(null);
    }

    @Override
    public ArrayList<Penjualan> getPenjualan(String cari) {
        ArrayList<Penjualan> arrayPenjualan = null;
        PreparedStatement state = null;

        boolean isSearching = cari != null && !cari.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT kode_jual,tgl_jual,total FROM tb_penjualan WHERE kode_jual  LIKE ?";
        } else {
            SELECT = "SELECT kode_jual,tgl_jual,total FROM tb_penjualan";

        }

        try {
            state = conn.prepareStatement(SELECT);

            if (isSearching) {
                state.setString(1, "%" + cari + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPenjualan = new ArrayList<>();
                while (result.next()) {
                    Penjualan penjualan = new Penjualan();
                    penjualan.setKodePenjualan(result.getString(1));
                    penjualan.setTglJual(result.getDate(2));
                    penjualan.setTotal(result.getInt(3));
                    arrayPenjualan.add(penjualan);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PenjualanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPenjualan;
    }

    @Override
    public boolean tambahPenjualan(Penjualan penjualan) {
        String INSERT = "INSERT INTO tb_penjualan (kode_jual,tgl_jual,"
                + "total, total_bayar, kembalian,no_admin) "
                + "VALUES (?,?,?,?,?,?)";

        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            java.util.Date utilDate = new java.util.Date();
            utilDate = penjualan.getTglJual();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            state.setString(1, penjualan.getKodePenjualan());
            state.setDate(2, sqlDate);
            state.setInt(3, penjualan.getTotal());
            state.setInt(4, penjualan.getTotalBayar());
            state.setInt(5, penjualan.getKembalian());
            state.setInt(6, penjualan.getNoAdmin());

            int qty = state.executeUpdate();
            return qty > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public Penjualan nomorUrut() {
        Penjualan pj = null;
        String SELECT = "SELECT MAX(RIGHT(kode_jual,4)) FROM tb_penjualan";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            ResultSet result = state.executeQuery();
            pj = new Penjualan();
            if (result != null && result.next()) {
                pj.setKodePenjualan(result.getString(1));
            } else {
                pj.setKodePenjualan(null);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pj;
    }

}
