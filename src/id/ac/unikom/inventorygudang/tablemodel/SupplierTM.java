/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.tablemodel;

import id.ac.unikom.inventorygudang.entity.Barang;
import id.ac.unikom.inventorygudang.entity.Supplier;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class SupplierTM extends AbstractTableModel{
    
    private ArrayList<Supplier> arraySupplier;

    public void setArraySupplier(ArrayList<Supplier> arraySupplier) {
        this.arraySupplier = arraySupplier;
    }

    @Override
    public int getRowCount() {
        return this.arraySupplier.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arraySupplier.get(rowIndex).getNama();
            case 1:
                return arraySupplier.get(rowIndex).getAlamat();
            case 2:
                return arraySupplier.get(rowIndex).getNoHp();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
    switch (column) {
            case 0:
                return "Nama";
            case 1:
                return "Alamat";
            case 2:
                return "No Hp";
        }
        return null;   
    }
    
    
}
