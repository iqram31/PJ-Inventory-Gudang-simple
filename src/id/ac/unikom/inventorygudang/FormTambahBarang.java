/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang;

import id.ac.unikom.inventorygudang.dao.BarangDAO;
import id.ac.unikom.inventorygudang.dao.DetailBarangDAO;
import id.ac.unikom.inventorygudang.dao.JenisBarangDAO;
import id.ac.unikom.inventorygudang.daoimpl.BarangDAOImpl;
import id.ac.unikom.inventorygudang.daoimpl.DetailBarangDAOImpl;
import id.ac.unikom.inventorygudang.daoimpl.JenisBarangDAOImpl;
import id.ac.unikom.inventorygudang.entity.Barang;
import id.ac.unikom.inventorygudang.entity.DetailBarang;
import id.ac.unikom.inventorygudang.entity.JenisBarang;
import id.ac.unikom.inventorygudang.entity.Supplier;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Saeful Rahman
 */
public class FormTambahBarang extends javax.swing.JDialog {

    private Barang barang;
    private Supplier supplier;
    private ArrayList<Barang> arrayBarang;
    private ArrayList<JenisBarang> arrayJenisBarang;
    boolean sama = false;

    public FormTambahBarang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fieldKodeSupplier.setVisible(false);
        getData();
        getJenis();
        for (int i = 0; i < arrayJenisBarang.size(); i++) {
            comboJenis.addItem(arrayJenisBarang.get(i).getNamaJenisBarang());
        }
    }

    private void getData() {
        BarangDAO dao = new BarangDAOImpl();
        arrayBarang = dao.getBarang();
    }

    private void getJenis() {
        JenisBarangDAO daoJenis = new JenisBarangDAOImpl();
        arrayJenisBarang = daoJenis.getJenisBarang();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelJudul = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldKodeBarang = new javax.swing.JTextField();
        fieldNamaBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboJenis = new javax.swing.JComboBox<>();
        btnTambahBarang = new javax.swing.JButton();
        btnResetBarang = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fieldHarga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fieldStok = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fieldDetailJenisBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldNamaSupplier = new javax.swing.JTextField();
        btnPilihSupplier = new javax.swing.JButton();
        fieldKodeSupplier = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        labelJudul.setBackground(new java.awt.Color(255, 255, 255));
        labelJudul.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelJudul.setForeground(new java.awt.Color(255, 255, 255));
        labelJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJudul.setText("Tambah Barang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(labelJudul)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelJudul)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel2.setText("Kode   Barang        :");

        fieldKodeBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldKodeBarangKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldKodeBarangKeyTyped(evt);
            }
        });

        jLabel3.setText("Nama Barang         :");

        jLabel5.setText("Jenis Barang          :");

        btnTambahBarang.setText("Tambah");
        btnTambahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBarangActionPerformed(evt);
            }
        });

        btnResetBarang.setText("Reset");
        btnResetBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetBarangActionPerformed(evt);
            }
        });

        jLabel1.setText("Harga                        : ");

        fieldHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldHargaKeyPressed(evt);
            }
        });

        jLabel7.setText("Stok                           :");

        fieldStok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldStokKeyPressed(evt);
            }
        });

        jLabel8.setText("Detail Jenis             :");

        jLabel4.setText("Nama Supplier       :");

        fieldNamaSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaSupplierKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNamaSupplierKeyTyped(evt);
            }
        });

        btnPilihSupplier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPilihSupplier.setText("...");
        btnPilihSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihSupplierActionPerformed(evt);
            }
        });

        fieldKodeSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldKodeSupplierKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldKodeSupplierKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fieldNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPilihSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fieldDetailJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fieldKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fieldNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldStok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambahBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetBarang)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPilihSupplier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fieldDetailJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fieldStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahBarang)
                    .addComponent(btnResetBarang))
                .addGap(26, 26, 26))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldKodeBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldKodeBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodeBarangKeyPressed

    private void fieldKodeBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldKodeBarangKeyTyped
        if (fieldKodeBarang.getText().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldKodeBarangKeyTyped

    private void btnTambahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBarangActionPerformed

        String kode = fieldKodeBarang.getText();
        String nama = fieldNamaBarang.getText();
        String txtHarga = fieldHarga.getText();
        String txtStok = fieldStok.getText();
        String detailJenis = fieldDetailJenisBarang.getText();
        int kodeSupplier = Integer.parseInt(fieldKodeSupplier.getText());
        
        Integer noJenisBarang = 0;
        boolean ketemu = false;
        int iKetemu = 0;

        for (int i = 0; i < arrayJenisBarang.size(); i++) {
            if (arrayJenisBarang.get(i).getNamaJenisBarang().equals(comboJenis.getSelectedItem())) {
                ketemu = true;
                iKetemu = i;
            }
            if (ketemu) {
                noJenisBarang = arrayJenisBarang.get(iKetemu).getNoJenis();
            }
        }

        for (int i = 0; i < arrayBarang.size(); i++) {
            if (kode.equalsIgnoreCase(arrayBarang.get(i).getKodeBarang())) {
                sama = true;
            }
        }

        //validasi input
        if ((kode != null && !kode.isEmpty()) && (nama != null && !nama.isEmpty())
                && (detailJenis != null && !detailJenis.isEmpty())
                && (txtHarga != null && !txtHarga.isEmpty())
                && (txtStok != null && !txtStok.isEmpty())
                && (noJenisBarang != null)) {

            if (sama) {
                JOptionPane.showMessageDialog(this, "Data barang sudah ada");
                /*
                Barang barang = new Barang();
                DetailBarang detailBarang = new DetailBarang();
                int harga = Integer.parseInt(txtHarga);
                int stok = Integer.parseInt(txtStok);

                barang.setKodeBarang(kode);
                barang.setNama(nama);
                barang.setNoJenis(noJenisBarang);
                barang.setStok(stok);
                barang.setKodeSupplier(kodeSupplier);

                detailBarang.setKodeBarang(kode);
                detailBarang.setHargaBarang(harga);
                
                //Update Barang
                BarangDAO dao = new BarangDAOImpl();
                DetailBarangDAO daoDetail = new DetailBarangDAOImpl();
                
                boolean sukses = dao.ubahBarang(barang);
                boolean suksesDetail = daoDetail.ubahDetailHarga(detailBarang);

                if (sukses && suksesDetail) {
                    JOptionPane.showMessageDialog(this, "Data barang berhasil ditambahkan");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Data barang gagal ditambahkan");
                }
                */
            } else {
                Barang barang = new Barang();
                DetailBarang detailBarang = new DetailBarang();
                int harga = Integer.parseInt(txtHarga);
                int stok = Integer.parseInt(txtStok);

                barang.setKodeBarang(kode);
                barang.setNama(nama);
                barang.setNoJenis(noJenisBarang);
                barang.setStok(stok);
                barang.setKodeSupplier(kodeSupplier);
                
                detailBarang.setKodeBarang(kode);
                detailBarang.setHargaBarang(harga);
                detailBarang.setDetailJenis(detailJenis);

                //Insert Barang
                BarangDAO dao = new BarangDAOImpl();
                DetailBarangDAO daoDetail = new DetailBarangDAOImpl();
                
                boolean sukses = dao.tambahBarang(barang);
                boolean suksesDetail = daoDetail.tambahDetailBarang(detailBarang);

                if (sukses && suksesDetail) {
                    JOptionPane.showMessageDialog(this, "Data barang berhasil ditambahkan");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Data barang gagal ditambahkan");
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Silakan isi data pada form barang!");
            sama = false;
        }
    }//GEN-LAST:event_btnTambahBarangActionPerformed

    private void btnResetBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetBarangActionPerformed
        fieldKodeBarang.setText(null);
        fieldNamaBarang.setText(null);
        fieldHarga.setText(null);
        fieldStok.setText(null);
        fieldDetailJenisBarang.setText(null);
        comboJenis.setSelectedItem(arrayJenisBarang.get(1).getNamaJenisBarang());
    }//GEN-LAST:event_btnResetBarangActionPerformed

    private void fieldHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldHargaKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9)
            || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9)
            || (key == KeyEvent.VK_BACK_SPACE)) {
            fieldHarga.setEditable(true);
            fieldHarga.setBackground(Color.white);
        } else {
            fieldHarga.setEditable(false);
            fieldHarga.setBackground(Color.red);
        }
    }//GEN-LAST:event_fieldHargaKeyPressed

    private void fieldStokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldStokKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9)
            || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9)
            || (key == KeyEvent.VK_BACK_SPACE)) {
            fieldStok.setEditable(true);
            fieldStok.setBackground(Color.white);
        } else {
            fieldStok.setEditable(false);
            fieldStok.setBackground(Color.red);
        }
    }//GEN-LAST:event_fieldStokKeyPressed

    private void fieldNamaSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaSupplierKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaSupplierKeyPressed

    private void fieldNamaSupplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaSupplierKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaSupplierKeyTyped

    private void btnPilihSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihSupplierActionPerformed
        FormPilihSupplier fps = new FormPilihSupplier(null, true);
        fps.setLocationRelativeTo(null);
        fps.setVisible(true);
        supplier = fps.getSupplier();
        if (supplier != null) {
            fieldKodeSupplier.setText(supplier.getKodeSupplier());
            fieldNamaSupplier.setText(supplier.getNama());
        }
    }//GEN-LAST:event_btnPilihSupplierActionPerformed

    private void fieldKodeSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldKodeSupplierKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodeSupplierKeyPressed

    private void fieldKodeSupplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldKodeSupplierKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodeSupplierKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTambahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTambahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTambahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTambahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormTambahBarang dialog = new FormTambahBarang(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPilihSupplier;
    private javax.swing.JButton btnResetBarang;
    private javax.swing.JButton btnTambahBarang;
    private javax.swing.JComboBox<String> comboJenis;
    private javax.swing.JTextField fieldDetailJenisBarang;
    private javax.swing.JTextField fieldHarga;
    private javax.swing.JTextField fieldKodeBarang;
    private javax.swing.JTextField fieldKodeSupplier;
    private javax.swing.JTextField fieldNamaBarang;
    private javax.swing.JTextField fieldNamaSupplier;
    private javax.swing.JTextField fieldStok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelJudul;
    // End of variables declaration//GEN-END:variables
}
