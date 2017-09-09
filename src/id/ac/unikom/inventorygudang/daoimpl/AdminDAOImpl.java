/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.daoimpl;

import id.ac.unikom.inventorygudang.dao.AdminDAO;
import id.ac.unikom.inventorygudang.entity.Admin;
import id.ac.unikom.inventorygudang.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saeful Rahman
 */
public class AdminDAOImpl implements AdminDAO {

    private final Connection conn;

    public AdminDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public Admin login(String username, String password) {
        Admin admin = null;
        PreparedStatement state = null;
        String SELECT = "SELECT * FROM tb_admin WHERE "
                + "username = ? AND password = ?";

        try {
            state = conn.prepareStatement(SELECT);
            state.setString(1, username);
            state.setString(2, password);

            ResultSet result = state.executeQuery();
            if (result != null && result.next()) {
                admin = new Admin();
                admin.setNoAdmin(result.getInt(1));
                admin.setNama(result.getString(2));
                admin.setUsername(result.getString(3));
                admin.setPassword(result.getString(4));
                admin.setAkses(result.getString(5));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return admin;
    }

}
