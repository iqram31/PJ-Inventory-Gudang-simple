/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.entity;

/**
 *
 * @author Iqram
 */
public class DetailPembelian {
    
    private String kodePembelian;
    private String kodeBarang;
    private String namaBarang;
    private String jenisBarang;
    private String detailJenisBarang;
    private int jumlahBarang;
    private String status;

    public String getKodePembelian() {
        return kodePembelian;
    }

    public void setKodePembelian(String kodePembelian) {
        this.kodePembelian = kodePembelian;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public String getDetailJenisBarang() {
        return detailJenisBarang;
    }

    public void setDetailJenisBarang(String detailJenisBarang) {
        this.detailJenisBarang = detailJenisBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
