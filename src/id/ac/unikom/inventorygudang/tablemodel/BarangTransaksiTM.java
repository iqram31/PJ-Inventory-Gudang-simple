/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.tablemodel;

import id.ac.unikom.inventorygudang.entity.Barang;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class BarangTransaksiTM extends AbstractTableModel {

    private ArrayList<Barang> arrayBarang;

    public void setArrayBarang(ArrayList<Barang> arrayBarang) {
        this.arrayBarang = arrayBarang;
    }

    @Override
    public int getRowCount() {
        return this.arrayBarang.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        switch (columnIndex) {
            case 0:
                return arrayBarang.get(rowIndex).getNamaSupplier();
            case 1:
                return arrayBarang.get(rowIndex).getKodeBarang();
            case 2:
                return arrayBarang.get(rowIndex).getNama();
            case 3:
                return arrayBarang.get(rowIndex).getJenis();
            case 4:
                return arrayBarang.get(rowIndex).getDetailJenis();
            case 5:
                return arrayBarang.get(rowIndex).getStok();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama Supplier";
            case 1:
                return "Kode Barang";
            case 2:
                return "Nama Barang";
            case 3:
                return "Jenis Barang";
            case 4:
                return "Detail Jenis";
            case 5:
                return "Stok";
        }
        return null;
    }

}
