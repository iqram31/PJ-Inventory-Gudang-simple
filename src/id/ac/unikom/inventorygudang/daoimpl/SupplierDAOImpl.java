/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.daoimpl;

import id.ac.unikom.inventorygudang.dao.SupplierDAO;
import id.ac.unikom.inventorygudang.entity.Supplier;
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
public class SupplierDAOImpl implements SupplierDAO {

    private final java.sql.Connection conn;

    public SupplierDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Supplier> getSupplier() {
        return getSupplier(null);
    }

    @Override
    public ArrayList<Supplier> getSupplier(String cari) {
        ArrayList<Supplier> arraySupplier = null;
        PreparedStatement state = null;

        boolean isSearching = cari != null && !cari.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM tb_supplier WHERE nama LIKE ? OR alamat LIKE ?";
        } else {
            SELECT = "SELECT * FROM tb_supplier";
        }

        try {
            state = conn.prepareStatement(SELECT);

            if (isSearching) {
                state.setString(1, "%" + cari + "%");
                state.setString(2, "%" + cari + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arraySupplier = new ArrayList<>();
                while (result.next()) {
                    Supplier supplier = new Supplier();
                    supplier.setKodeSupplier(result.getString(1));
                    supplier.setNama(result.getString(2));
                    supplier.setAlamat(result.getString(3));
                    supplier.setNoHp(result.getString(4));
                    arraySupplier.add(supplier);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arraySupplier;
    }

    @Override
    public boolean tambahSupplier(Supplier supplier) {

        String INSERT = "INSERT INTO tb_supplier(nama, alamat"
                + ",no_hp) VALUES (?,?,?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, supplier.getNama());
            state.setString(2, supplier.getAlamat());
            state.setString(3, supplier.getNoHp());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean ubahSupplier(Supplier supplier) {

        String UPDATE = "UPDATE tb_supplier "
                + "SET nama = ?, alamat = ?,"
                + "no_hp = ? WHERE kode_supplier = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, supplier.getNama());
            state.setString(2, supplier.getAlamat());
            state.setString(3, supplier.getNoHp());
            state.setString(4, supplier.getKodeSupplier());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean hapusSupplier(String kodeSupplier) {

        String DELETE = "DELETE FROM tb_supplier "
                + "WHERE kode_supplier = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, kodeSupplier);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
