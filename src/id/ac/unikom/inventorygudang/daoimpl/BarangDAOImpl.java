/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.daoimpl;

import id.ac.unikom.inventorygudang.dao.BarangDAO;
import id.ac.unikom.inventorygudang.entity.Barang;
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
public class BarangDAOImpl implements BarangDAO {

    private final java.sql.Connection conn;

    public BarangDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Barang> getBarang() {
        return getBarang(null);
    }

    @Override
    public ArrayList<Barang> getBarang(String cari) {
        ArrayList<Barang> arrayBarang = null;
        PreparedStatement state = null;

        boolean isSearching = cari != null && !cari.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT tb_supplier.nama,tb_barang.kd_barang,tb_barang.nama,tb_jenis.jenis_barang,"
                    + "tb_detail_barang.detail_jenis,tb_detail_barang.harga_barang,tb_barang.stok, tb_barang.kode_supplier "
                    + "FROM tb_barang,tb_jenis,tb_detail_barang, tb_supplier "
                    + "WHERE tb_barang.kd_barang = tb_detail_barang.kd_barang "
                    + "AND tb_barang.no_jenis = tb_jenis.no_jenis AND tb_barang.kode_supplier = tb_supplier.kode_supplier "
                    + "AND (tb_barang.nama LIKE ? OR tb_jenis.jenis_barang LIKE ? OR tb_detail_barang.detail_jenis LIKE ?)";
        } else {
           SELECT = "SELECT tb_supplier.nama,tb_barang.kd_barang,tb_barang.nama,tb_jenis.jenis_barang,"
                    + "tb_detail_barang.detail_jenis,tb_detail_barang.harga_barang,tb_barang.stok, tb_barang.kode_supplier "
                    + "FROM tb_barang,tb_jenis,tb_detail_barang, tb_supplier "
                    + "WHERE tb_barang.kd_barang = tb_detail_barang.kd_barang AND tb_barang.kode_supplier = tb_supplier.kode_supplier "
                    + "AND tb_barang.no_jenis = tb_jenis.no_jenis ";

        }

        try {
            state = conn.prepareStatement(SELECT);

            if (isSearching) {
                state.setString(1, "%" + cari + "%");
                state.setString(2, "%" + cari + "%");
                state.setString(3, "%" + cari + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayBarang = new ArrayList<>();
                while (result.next()) {
                    Barang barang = new Barang();
                    barang.setNamaSupplier(result.getString(1));
                    barang.setKodeBarang(result.getString(2));
                    barang.setNama(result.getString(3));
                    barang.setJenis(result.getString(4));
                    barang.setDetailJenis(result.getString(5));
                    barang.setHargaBarang(result.getInt(6));
                    barang.setStok(result.getInt(7));
                    barang.setKodeSupplier(result.getInt(8));
                
                    arrayBarang.add(barang);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayBarang;
    }

    @Override
    public boolean tambahBarang(Barang barang) {

        String INSERT = "INSERT INTO tb_barang(kd_barang, nama, no_jenis,"
                + "stok, kode_supplier) VALUES (?,?,?,?,?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, barang.getKodeBarang());
            state.setString(2, barang.getNama());
            state.setInt(3, barang.getNoJenis());
            state.setInt(4, barang.getStok());
            state.setInt(5, barang.getKodeSupplier());
            
            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean ubahBarang(Barang barang) {
        String UPDATE = "UPDATE tb_barang "
                + "SET nama = ?, no_jenis = ?,"
                + "stok = ? "
                + "WHERE kd_barang = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, barang.getNama());
            state.setInt(2, barang.getNoJenis());
            state.setInt(3, barang.getStok());
            state.setString(4, barang.getKodeBarang());
            
            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean hapusBarang(String kodeBarang) {
        String DELETE = "DELETE FROM tb_barang "
                + "WHERE kd_barang = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, kodeBarang);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public boolean ubahStok(Barang barang) {
        String UPDATE = "UPDATE tb_barang SET stok = ? WHERE kd_barang = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setInt(1, barang.getStok());
            state.setString(2, barang.getKodeBarang());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean ubahStokBarang(Barang barang) {
        String UPDATE = "UPDATE tb_barang SET stok = stok + ? WHERE kd_barang = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setInt(1, barang.getStok());
            state.setString(2, barang.getKodeBarang());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
