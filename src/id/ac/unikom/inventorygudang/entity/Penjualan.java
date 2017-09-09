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
public class Penjualan {

    private String kodePenjualan;
    private Date tglJual;
    private int total;
    private int totalBrg;
    private int totalBayar;
    private int kembalian;
    private int noAdmin;

    public int getNoAdmin() {
        return noAdmin;
    }

    public void setNoAdmin(int noAdmin) {
        this.noAdmin = noAdmin;
    }
    

    public int getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(int totalBayar) {
        this.totalBayar = totalBayar;
    }

    public int getKembalian() {
        return kembalian;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }

    public int getTotalBrg() {
        return totalBrg;
    }

    public void setTotalBrg(int totalBrg) {
        this.totalBrg = totalBrg;
    }

    public String getKodePenjualan() {
        return kodePenjualan;
    }

    public void setKodePenjualan(String kodePenjualan) {
        this.kodePenjualan = kodePenjualan;
    }

    public Date getTglJual() {
        return tglJual;
    }

    public void setTglJual(Date tglJual) {
        this.tglJual = tglJual;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
