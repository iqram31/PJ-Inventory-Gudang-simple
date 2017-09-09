/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.entity;

import java.util.Date;

/**
 *
 * @author Saeful Rahman
 */
public class Pembelian {

    private String kodePembelian;
    private Date tglBeli;
    private String nama;
    private int total;
    private int totalBrg;
    private int noAdmin;
    private int kodeSupplier;

    public String getKodePembelian() {
        return kodePembelian;
    }

    public void setKodePembelian(String kodePembelian) {
        this.kodePembelian = kodePembelian;
    }

    public Date getTglBeli() {
        return tglBeli;
    }

    public void setTglBeli(Date tglBeli) {
        this.tglBeli = tglBeli;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalBrg() {
        return totalBrg;
    }

    public void setTotalBrg(int totalBrg) {
        this.totalBrg = totalBrg;
    }

    public int getNoAdmin() {
        return noAdmin;
    }

    public void setNoAdmin(int noAdmin) {
        this.noAdmin = noAdmin;
    }

    public int getKodeSupplier() {
        return kodeSupplier;
    }

    public void setKodeSupplier(int kodeSupplier) {
        this.kodeSupplier = kodeSupplier;
    }
    
    
 
}
