/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.daoimpl;

import id.ac.unikom.inventorygudang.dao.DetailPenjualanDAO;
import id.ac.unikom.inventorygudang.entity.DetailPenjualan;
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
public class DetailPenjualanDAOImpl implements DetailPenjualanDAO {

    private final java.sql.Connection conn;

    public DetailPenjualanDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<DetailPenjualan> getDetailPenjualan() {
        return getDetailPenjualan(null);
    }

    @Override
    public ArrayList<DetailPenjualan> getDetailPenjualan(String kodePenjualan) {
        ArrayList<DetailPenjualan> arrayDetailPenjualan = null;
        PreparedStatement state = null;

        boolean isSearching = kodePenjualan != null && !kodePenjualan.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT tb_detail_penjualan.kode_jual,tb_detail_penjualan.kd_barang,"
                    + "tb_barang.nama,tb_jenis.jenis_barang,tb_detail_penjualan.harga,tb_detail_penjualan.jumlah,"
                    + "tb_detail_penjualan.sub_total "
                    + "FROM tb_detail_penjualan,tb_barang,tb_jenis "
                    + "WHERE tb_detail_penjualan.kd_barang = tb_barang.kd_barang "
                    + "AND tb_barang.no_jenis = tb_jenis.no_jenis AND kode_jual LIKE ?";
        } else {
            SELECT = "SELECT tb_detail_penjualan.kode_jual,tb_detail_penjualan.kd_barang,"
                    + "tb_barang.nama,tb_jenis.jenis_barang,tb_detail_penjualan.harga,tb_detail_penjualan.jumlah,"
                    + "tb_detail_penjualan.sub_total "
                    + "FROM tb_detail_penjualan,tb_barang,tb_jenis "
                    + "WHERE tb_detail_penjualan.kd_barang = tb_barang.kd_barang "
                    + "AND tb_barang.no_jenis = tb_jenis.no_jenis";
        }

        try {
            state = conn.prepareStatement(SELECT);

            if (isSearching) {
                state.setString(1, "%" + kodePenjualan + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayDetailPenjualan = new ArrayList<>();
                while (result.next()) {
                    DetailPenjualan detailPenjualan = new DetailPenjualan();
                    detailPenjualan.setKodePenjualan(result.getString(1));
                    detailPenjualan.setKodeBarang(result.getString(2));
                    detailPenjualan.setNama(result.getString(3));
                    detailPenjualan.setJenis(result.getString(4));
                    detailPenjualan.setHarga(result.getInt(5));
                    detailPenjualan.setJumlah(result.getInt(6));
                    detailPenjualan.setSubTotal(result.getInt(7));
                    arrayDetailPenjualan.add(detailPenjualan);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailPenjualanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DetailPenjualanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayDetailPenjualan;
    }

    @Override
    public boolean tambahDetailPenjualan(DetailPenjualan detailPenjualan) {

        String INSERT = "INSERT INTO tb_detail_penjualan (kode_jual,kd_barang,"
                + "harga,jumlah,sub_total) "
                + "VALUES (?,?,?,?,?)";

        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);

            state.setString(1, detailPenjualan.getKodePenjualan());
            state.setString(2, detailPenjualan.getKodeBarang());
            state.setInt(3, detailPenjualan.getHarga());
            state.setInt(4, detailPenjualan.getJumlah());
            state.setInt(5, detailPenjualan.getSubTotal());

            int qty = state.executeUpdate();
            return qty > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DetailPenjualanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
