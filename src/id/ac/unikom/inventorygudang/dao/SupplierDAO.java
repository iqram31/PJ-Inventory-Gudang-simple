/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.dao;

import id.ac.unikom.inventorygudang.entity.Supplier;
import java.util.ArrayList;

/**
 *
 * @author Iqram
 */
public interface SupplierDAO {
    
    ArrayList<Supplier> getSupplier();
    
    ArrayList<Supplier> getSupplier(String cari);
    
    boolean tambahSupplier(Supplier supplier);
    boolean ubahSupplier(Supplier supplier);
    boolean hapusSupplier(String kodeSupplier);
    
}
