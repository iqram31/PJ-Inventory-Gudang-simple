/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.dao;

import id.ac.unikom.inventorygudang.entity.Barang;
import java.util.ArrayList;

/**
 *
 * @author Iqram
 */
public interface BarangDAO {

    ArrayList<Barang> getBarang();

    ArrayList<Barang> getBarang(String cari);
   
    boolean tambahBarang(Barang barang);

    boolean ubahBarang(Barang barang);

    boolean hapusBarang(String kodeBarang);

    boolean ubahStok(Barang barang);
    
    boolean ubahStokBarang(Barang barang);
}
