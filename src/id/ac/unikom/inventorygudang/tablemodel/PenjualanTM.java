/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.tablemodel;

import id.ac.unikom.inventorygudang.entity.Penjualan;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saeful Rahman
 */
public class PenjualanTM extends AbstractTableModel {

    private ArrayList<Penjualan> arrayPenjualan;

    public void setArrayPenjualan(ArrayList<Penjualan> arrayPenjualan) {
        this.arrayPenjualan = arrayPenjualan;
    }

    @Override
    public int getRowCount() {
        return this.arrayPenjualan.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        switch (columnIndex) {
            case 0:
                return arrayPenjualan.get(rowIndex).getKodePenjualan();
            case 1:
                return  fmt.format(arrayPenjualan.get(rowIndex).getTglJual());
            case 2:
                return arrayPenjualan.get(rowIndex).getTotalBrg();
            case 3:
                int total = arrayPenjualan.get(rowIndex).getTotal();
                return kursIndonesia.format(total);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Penjualan";
            case 1:
                return "Tanggal Penjualan";
            case 2:
                return "Jumlah Barang";
            case 3:
                return "Harga Total";
        }
        return null;

    }
}
