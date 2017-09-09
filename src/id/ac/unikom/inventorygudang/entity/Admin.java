/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.entity;

/**
 *
 * @author Saeful Rahman
 */
public class Admin {
    private int noAdmin;
    private String nama;
    private String username;
    private String password;
    private String akses;

    public int getNoAdmin() {
        return noAdmin;
    }

    public void setNoAdmin(int noAdmin) {
        this.noAdmin = noAdmin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAkses() {
        return akses;
    }

    public void setAkses(String akses) {
        this.akses = akses;
    }

    
}
