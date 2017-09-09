/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.dao;

import id.ac.unikom.inventorygudang.entity.DetailBarang;

/**
 *
 * @author Rahadian Nugraha
 */
public interface DetailBarangDAO {
    boolean tambahDetailBarang(DetailBarang detailBarang);

    boolean ubahDetailBarang(DetailBarang detailBarang);

    boolean hapusDetailBarang(String kodeBarang);

    boolean ubahDetailHarga(DetailBarang detailBarang);
}
