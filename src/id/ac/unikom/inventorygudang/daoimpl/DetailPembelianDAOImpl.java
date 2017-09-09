/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.daoimpl;

import id.ac.unikom.inventorygudang.dao.DetailPembelianDAO;
import id.ac.unikom.inventorygudang.entity.DetailPembelian;
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
public class DetailPembelianDAOImpl implements DetailPembelianDAO {

    private final java.sql.Connection conn;

    public DetailPembelianDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<DetailPembelian> getDetailPembelian() {
        return getDetailPembelian(null);
    }

    @Override
    public ArrayList<DetailPembelian> getDetailPembelian(String kodePembelian) {
        ArrayList<DetailPembelian> arrayDetailPembelian = null;
        PreparedStatement state = null;

        boolean isSearching = kodePembelian != null && !kodePembelian.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT tb_detail_pembelian.kode_beli,tb_detail_pembelian.kd_barang,tb_barang.nama,"
                    + "tb_jenis.jenis_barang,tb_detail_barang.detail_jenis,tb_detail_pembelian.jumlah "
                    + "FROM tb_detail_pembelian, tb_barang, tb_jenis, tb_detail_barang "
                    + "WHERE tb_detail_pembelian.kd_barang = tb_barang.kd_barang "
                    + "AND tb_barang.no_jenis = tb_jenis.no_jenis AND tb_barang.kd_barang = tb_detail_barang.kd_barang "
                    + "AND tb_detail_pembelian.status = 'Tidak' "
                    + "AND kode_beli LIKE ?";
        } else {
            SELECT = "SELECT tb_detail_pembelian.kode_beli,tb_detail_pembelian.kd_barang,tb_barang.nama,"
                    + "tb_jenis.jenis_barang,tb_detail_barang.detail_jenis,tb_detail_pembelian.jumlah "
                    + "FROM tb_detail_pembelian, tb_barang, tb_jenis, tb_detail_barang "
                    + "WHERE tb_detail_pembelian.kd_barang = tb_barang.kd_barang "
                    + "AND tb_barang.no_jenis = tb_jenis.no_jenis "
                    + "AND tb_barang.kd_barang = tb_detail_barang.kd_barang "
                    + "AND tb_detail_pembelian.status = 'Tidak'";
        }

        try {
            state = conn.prepareStatement(SELECT);

            if (isSearching) {
                state.setString(1, "%" + kodePembelian + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayDetailPembelian = new ArrayList<>();
                while (result.next()) {
                    DetailPembelian detailPembelian = new DetailPembelian();
                    detailPembelian.setKodePembelian(result.getString(1));
                    detailPembelian.setKodeBarang(result.getString(2));
                    detailPembelian.setNamaBarang(result.getString(3));
                    detailPembelian.setJenisBarang(result.getString(4));
                    detailPembelian.setDetailJenisBarang(result.getString(5));
                    detailPembelian.setJumlahBarang(result.getInt(6));
                    arrayDetailPembelian.add(detailPembelian);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailPembelianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DetailPembelianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayDetailPembelian;
    }

    @Override
    public boolean tambahDetailPembelian(DetailPembelian detailPembelian) {
        String INSERT = "INSERT INTO tb_detail_pembelian (kode_beli,kd_barang,jumlah) "
                + "VALUES (?,?,?)";

        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);

            state.setString(1, detailPembelian.getKodePembelian());
            state.setString(2, detailPembelian.getKodeBarang());
            state.setInt(3, detailPembelian.getJumlahBarang());
            int qty = state.executeUpdate();
            return qty > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DetailPembelianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public ArrayList<DetailPembelian> getDetailPemesanan() {
        return getDetailPemesanan(null);
    }

    @Override
    public ArrayList<DetailPembelian> getDetailPemesanan(String kodePembelian) {
        ArrayList<DetailPembelian> arrayDetailPembelian = null;
        PreparedStatement state = null;

        boolean isSearching = kodePembelian != null && !kodePembelian.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT tb_detail_pembelian.kode_beli,tb_detail_pembelian.kd_barang,tb_barang.nama,"
                    + "tb_jenis.jenis_barang,tb_detail_barang.detail_jenis,tb_detail_pembelian.jumlah "
                    + "FROM tb_detail_pembelian, tb_barang, tb_jenis, tb_detail_barang "
                    + "WHERE tb_detail_pembelian.kd_barang = tb_barang.kd_barang "
                    + "AND tb_barang.no_jenis = tb_jenis.no_jenis AND tb_barang.kd_barang = tb_detail_barang.kd_barang "
                    + "AND tb_detail_pembelian.status = 'Ya' "
                    + "AND tb_barang.nama LIKE ?";
        } else {
            SELECT = "SELECT tb_detail_pembelian.kode_beli,tb_detail_pembelian.kd_barang,tb_barang.nama,"
                    + "tb_jenis.jenis_barang,tb_detail_barang.detail_jenis,tb_detail_pembelian.jumlah "
                    + "FROM tb_detail_pembelian, tb_barang, tb_jenis, tb_detail_barang "
                    + "WHERE tb_detail_pembelian.kd_barang = tb_barang.kd_barang "
                    + "AND tb_barang.no_jenis = tb_jenis.no_jenis "
                    + "AND tb_barang.kd_barang = tb_detail_barang.kd_barang "
                    + "AND tb_detail_pembelian.status = 'Ya'";
        }

        try {
            state = conn.prepareStatement(SELECT);

            if (isSearching) {
                state.setString(1, "%" + kodePembelian + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayDetailPembelian = new ArrayList<>();
                while (result.next()) {
                    DetailPembelian detailPembelian = new DetailPembelian();
                    detailPembelian.setKodePembelian(result.getString(1));
                    detailPembelian.setKodeBarang(result.getString(2));
                    detailPembelian.setNamaBarang(result.getString(3));
                    detailPembelian.setJenisBarang(result.getString(4));
                    detailPembelian.setDetailJenisBarang(result.getString(5));
                    detailPembelian.setJumlahBarang(result.getInt(6));
                    arrayDetailPembelian.add(detailPembelian);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailPembelianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DetailPembelianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayDetailPembelian;
    }

    @Override
    public boolean ubahStokPembelian(DetailPembelian detailPembelian) {
        String UPDATE = "UPDATE tb_detail_pembelian SET jumlah = ?, status = 'Ya' "
                + "WHERE kd_barang = ? AND kode_beli = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setInt(1, detailPembelian.getJumlahBarang());
            state.setString(2, detailPembelian.getKodeBarang());
            state.setString(3, detailPembelian.getKodePembelian());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DetailPembelianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
