/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.dao;

import id.ac.unikom.inventorygudang.entity.Barang;
import id.ac.unikom.inventorygudang.entity.DetailPembelian;
import java.util.ArrayList;

/**
 *
 * @author Iqram
 */
public interface DetailPembelianDAO {
    
    ArrayList<DetailPembelian> getDetailPembelian();
    
    ArrayList<DetailPembelian> getDetailPembelian(String kodePembelian);
    
    ArrayList<DetailPembelian> getDetailPemesanan();
    
    ArrayList<DetailPembelian> getDetailPemesanan(String kodePembelian);
    
    boolean tambahDetailPembelian (DetailPembelian detailPembelian);
    
    boolean ubahStokPembelian(DetailPembelian detailPembelian);
}
