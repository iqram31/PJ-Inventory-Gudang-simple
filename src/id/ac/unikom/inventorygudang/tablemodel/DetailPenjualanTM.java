/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.tablemodel;

import id.ac.unikom.inventorygudang.entity.DetailPenjualan;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class DetailPenjualanTM extends AbstractTableModel {

    private ArrayList<DetailPenjualan> arrayDetailPenjualan;

    public void setArrayDetailPenjualan(ArrayList<DetailPenjualan> arrayDetailPenjualan) {
        this.arrayDetailPenjualan = arrayDetailPenjualan;
    }

    @Override
    public int getRowCount() {
        return this.arrayDetailPenjualan.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
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
                return arrayDetailPenjualan.get(rowIndex).getKodeBarang();
            case 1:
                return arrayDetailPenjualan.get(rowIndex).getNama();
            case 2:
                return arrayDetailPenjualan.get(rowIndex).getJenis();
            case 3:
                return arrayDetailPenjualan.get(rowIndex).getDetailJenis();
            case 4:
                return arrayDetailPenjualan.get(rowIndex).getJumlah();
            case 5:
                int harga = arrayDetailPenjualan.get(rowIndex).getHarga();
                return kursIndonesia.format(harga);
            case 6:
                int subTotal = arrayDetailPenjualan.get(rowIndex).getSubTotal();
                return kursIndonesia.format(subTotal);
        }
        return null;

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Barang";
            case 1:
                return "Nama Barang";
            case 2:
                return "Jenis Barang";
            case 3:
                return "Detail Jenis";
            case 4:
                return "Jumlah Barang";
            case 5:
                return "Harga Jual";
            case 6:
                return "Sub Total";
        }
        return null;

    }

}
