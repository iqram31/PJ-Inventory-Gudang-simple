/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.dao;

import id.ac.unikom.inventorygudang.entity.Penjualan;
import java.util.ArrayList;

/**
 *
 * @author Iqram
 */
public interface PenjualanDAO {
    
    ArrayList<Penjualan> getPenjualan();
        
    ArrayList<Penjualan> getPenjualan(String cari);

    boolean tambahPenjualan (Penjualan penjualan);
    
    Penjualan nomorUrut();
    
}
