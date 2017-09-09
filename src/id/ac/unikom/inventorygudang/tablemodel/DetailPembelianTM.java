/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang.tablemodel;

import id.ac.unikom.inventorygudang.entity.DetailPembelian;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class DetailPembelianTM extends AbstractTableModel {

    private ArrayList<DetailPembelian> arrayDetailPembelian;

    public void setArrayDetailPembelian(ArrayList<DetailPembelian> arrayDetailPembelian) {
        this.arrayDetailPembelian = arrayDetailPembelian;
    }

    @Override
    public int getRowCount() {
        return this.arrayDetailPembelian.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayDetailPembelian.get(rowIndex).getKodeBarang();
            case 1:
                return arrayDetailPembelian.get(rowIndex).getNamaBarang();
            case 2:
                return arrayDetailPembelian.get(rowIndex).getJenisBarang();
            case 3:
                return arrayDetailPembelian.get(rowIndex).getDetailJenisBarang();
            case 4:
                return arrayDetailPembelian.get(rowIndex).getJumlahBarang();
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
        }
        return null;

    }

}
