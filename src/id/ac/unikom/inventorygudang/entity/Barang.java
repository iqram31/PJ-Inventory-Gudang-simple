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
public class Barang {

    private String kodeBarang;
    private int noJenis;
    private String nama;
    private String jenis;
    private String detailJenis;
    private int stok;
    private int hargaBarang;
    private int kodeSupplier;
    private String namaSupplier;

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public int getNoJenis() {
        return noJenis;
    }

    public void setNoJenis(int noJenis) {
        this.noJenis = noJenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDetailJenis() {
        return detailJenis;
    }

    public void setDetailJenis(String detailJenis) {
        this.detailJenis = detailJenis;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public int getKodeSupplier() {
        return kodeSupplier;
    }

    public void setKodeSupplier(int kodeSupplier) {
        this.kodeSupplier = kodeSupplier;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier = namaSupplier;
    }
}
