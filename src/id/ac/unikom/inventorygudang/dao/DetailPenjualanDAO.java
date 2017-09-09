/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.dao;

import id.ac.unikom.inventorygudang.entity.DetailPenjualan;
import java.util.ArrayList;

/**
 *
 * @author Iqram
 */
public interface DetailPenjualanDAO {
    
    ArrayList<DetailPenjualan> getDetailPenjualan();
    
    ArrayList<DetailPenjualan> getDetailPenjualan(String kodePenjualan);
    
    boolean tambahDetailPenjualan (DetailPenjualan detailPenjualan);
    
}
