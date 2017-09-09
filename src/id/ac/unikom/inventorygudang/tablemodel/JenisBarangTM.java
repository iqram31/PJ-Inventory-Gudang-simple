/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.tablemodel;

import id.ac.unikom.inventorygudang.entity.Barang;
import id.ac.unikom.inventorygudang.entity.JenisBarang;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class JenisBarangTM extends AbstractTableModel {

    private ArrayList<JenisBarang> arrayJenisBarang;

    public void setArrayJenisBarang(ArrayList<JenisBarang> arrayJenisBarang) {
        this.arrayJenisBarang = arrayJenisBarang;
    }

    @Override
    public int getRowCount() {
        return this.arrayJenisBarang.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayJenisBarang.get(rowIndex).getNamaJenisBarang();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Jenis Barang";
        }
        return null;
    }

}
