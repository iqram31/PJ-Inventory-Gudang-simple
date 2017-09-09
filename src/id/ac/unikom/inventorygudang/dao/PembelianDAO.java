/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.dao;

import id.ac.unikom.inventorygudang.entity.Pembelian;
import java.util.ArrayList;

/**
 *
 * @author Iqram
 */
public interface PembelianDAO {
    
    ArrayList<Pembelian> getPembelian();
    
    ArrayList<Pembelian> getPembelian(String cari);
    
    boolean tambahPembelian (Pembelian pembelian);
    
    Pembelian nomorUrut();
}
