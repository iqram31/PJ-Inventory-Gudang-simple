/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.tablemodel;

import id.ac.unikom.inventorygudang.entity.Pembelian;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saeful Rahman
 */
public class PembelianTM extends AbstractTableModel {

    private ArrayList<Pembelian> arrayPembelian;

    public void setArrayPembelian(ArrayList<Pembelian> arrayPembelian) {
        this.arrayPembelian = arrayPembelian;
    }

    @Override
    public int getRowCount() {
        return this.arrayPembelian.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        switch (columnIndex) {
            case 0:
                return arrayPembelian.get(rowIndex).getKodePembelian();
            case 1:
                return arrayPembelian.get(rowIndex).getNama();
            case 2:
                return fmt.format(arrayPembelian.get(rowIndex).getTglBeli());
            case 3:
                return arrayPembelian.get(rowIndex).getTotalBrg();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Pembelian";
            case 1:
                return "Nama Supplier";
            case 2:
                return "Tanggal Pembelian";
            case 3:
                return "Jumlah Barang";
        }
        return null;

    }
}
