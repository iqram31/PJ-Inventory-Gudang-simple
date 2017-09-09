/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.entity;

/**
 *
 * @author Rahadian Nugraha
 */
public class DetailBarang {
    private String kodeBarang;
    private int hargaBarang;
    private String detailJenis;

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getDetailJenis() {
        return detailJenis;
    }

    public void setDetailJenis(String detailJenis) {
        this.detailJenis = detailJenis;
    }
    
    
}
