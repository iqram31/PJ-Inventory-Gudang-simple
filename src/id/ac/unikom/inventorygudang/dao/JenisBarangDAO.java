/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.dao;

import id.ac.unikom.inventorygudang.entity.JenisBarang;
import java.util.ArrayList;

/**
 *
 * @author Saeful Rahman
 */
public interface JenisBarangDAO {

    ArrayList<JenisBarang> getJenisBarang();
    
    ArrayList<JenisBarang> getJenisBarang(String cari);

    boolean tambahJenisBarang(JenisBarang jenisBarang);

    boolean ubahJenisBarang(JenisBarang jenisBarang);

    boolean hapusJenisBarang(int noJenis);
}
