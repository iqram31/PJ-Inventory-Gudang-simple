/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.daoimpl;

import id.ac.unikom.inventorygudang.dao.PembelianDAO;
import id.ac.unikom.inventorygudang.entity.Pembelian;
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
public class PembelianDAOImpl implements PembelianDAO {

    private final java.sql.Connection conn;

    public PembelianDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Pembelian> getPembelian() {
        return getPembelian(null);
    }

    @Override
    public ArrayList<Pembelian> getPembelian(String cari) {
        ArrayList<Pembelian> arrayPembelian = null;
        PreparedStatement state = null;

        boolean isSearching = cari != null && !cari.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT tb_pembelian.kode_beli, tb_supplier.nama, tb_pembelian.tgl_beli, COUNT(tb_detail_pembelian.kode_beli) "
                    + "FROM tb_pembelian,tb_supplier,tb_detail_pembelian "
                    + "WHERE tb_pembelian.kode_beli = tb_detail_pembelian.kode_beli AND tb_pembelian.kode_supplier = tb_supplier.kode_supplier AND (tb_pembelian.kode_beli LIKE ? OR tb_supplier.nama LIKE ?)";
        } else {
            SELECT = "SELECT tb_pembelian.kode_beli, tb_supplier.nama, tb_pembelian.tgl_beli, COUNT(tb_detail_pembelian.kode_beli) "
                    + "FROM tb_pembelian,tb_supplier,tb_detail_pembelian "
                    + "WHERE tb_pembelian.kode_beli = tb_detail_pembelian.kode_beli AND tb_pembelian.kode_supplier = tb_supplier.kode_supplier "
                    + "GROUP BY tb_pembelian.kode_beli";

        }

        try {
            state = conn.prepareStatement(SELECT);

            if (isSearching) {
                state.setString(1, "%" + cari + "%");
                state.setString(2, "%" + cari + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPembelian = new ArrayList<>();
                while (result.next()) {
                    Pembelian pembelian = new Pembelian();
                    pembelian.setKodePembelian(result.getString(1));
                    pembelian.setNama(result.getString(2));
                    pembelian.setTglBeli(result.getDate(3));
                    pembelian.setTotalBrg(result.getInt(4));
                    arrayPembelian.add(pembelian);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(PembelianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PembelianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPembelian;

    }

    @Override
    public boolean tambahPembelian(Pembelian pembelian) {
        String INSERT = "INSERT INTO tb_pembelian (kode_beli,tgl_beli,"
                + "kode_supplier,no_admin) "
                + "VALUES (?,?,?,?)";

        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            java.util.Date utilDate = new java.util.Date();
            utilDate = pembelian.getTglBeli();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            state.setString(1, pembelian.getKodePembelian());
            state.setDate(2, sqlDate);
            state.setInt(3, pembelian.getKodeSupplier());
            state.setInt(4, pembelian.getNoAdmin());

            int qty = state.executeUpdate();
            return qty > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PembelianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Pembelian nomorUrut() {
        Pembelian pb = null;
        String SELECT = "SELECT MAX(RIGHT(kode_beli,4)) FROM tb_pembelian";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            ResultSet result = state.executeQuery();
            pb = new Pembelian();
            if (result != null && result.next()) {
                pb.setKodePembelian(result.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PembelianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pb;
    }
}
