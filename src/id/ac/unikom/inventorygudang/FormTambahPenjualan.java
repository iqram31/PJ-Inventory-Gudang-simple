/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang;

import id.ac.unikom.inventorygudang.dao.BarangDAO;
import id.ac.unikom.inventorygudang.dao.DetailPenjualanDAO;
import id.ac.unikom.inventorygudang.dao.PenjualanDAO;
import id.ac.unikom.inventorygudang.daoimpl.BarangDAOImpl;
import id.ac.unikom.inventorygudang.daoimpl.DetailPenjualanDAOImpl;
import id.ac.unikom.inventorygudang.daoimpl.PenjualanDAOImpl;
import id.ac.unikom.inventorygudang.entity.Barang;
import id.ac.unikom.inventorygudang.entity.DetailPenjualan;
import id.ac.unikom.inventorygudang.entity.Penjualan;
import id.ac.unikom.inventorygudang.tablemodel.DetailPenjualanTM;
import id.ac.unikom.inventorygudang.utility.DatabaseConnectivity;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Saeful Rahman
 */
public class FormTambahPenjualan extends javax.swing.JFrame {

    private DetailPenjualan detailPenjualan;
    private Barang barang;
    private ArrayList<Barang> arrayBarang;
    private ArrayList<DetailPenjualan> arrayDetailPenjualan = new ArrayList<>();
    private String namaUser;
    private String hakAkses;
    private int idAdmin = 4;
    private String tglJual;
    private int hargaTotal = 0;
    private String kodePenjualan;
    private String jenis = null;
    public Penjualan pj = new Penjualan();
    public PenjualanDAO dao = new PenjualanDAOImpl();

    //Tipe data untuk memanggil jasper/report
    java.sql.Connection conn;
    JasperReport jasRep;
    JasperPrint jasPri;
    Map param = new HashMap();
    JasperDesign jasDes;
    DatabaseConnectivity koneksi = new DatabaseConnectivity();

    public FormTambahPenjualan() {
        initComponents();
        getData();
        getDate();
        fieldStok.setVisible(false);
        getDataBarang();
        btnCetakStruk.setEnabled(false);
    }

    public FormTambahPenjualan(String akses, String nama, int noAdmin) {
        initComponents();
        getData();
        getDate();
        fieldStok.setVisible(false);
        getDataBarang();
        namaUser = nama;
        hakAkses = akses;
        idAdmin = noAdmin;
        btnCetakStruk.setEnabled(false);
    }

    private void getData() {
        DetailPenjualanTM dp = new DetailPenjualanTM();
        dp.setArrayDetailPenjualan(arrayDetailPenjualan);
        tableDaftarBarang.setModel(dp);
    }

    private void getDate() {
        SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
        Date date = new Date();
        pj = dao.nomorUrut();
        Integer nomorUrut;
        dateTanggalJual.setDate(date);
        if (dateTanggalJual.getDate() != null) {
            if (pj.getKodePenjualan() != null) {
                nomorUrut = Integer.parseInt(pj.getKodePenjualan());
                nomorUrut = nomorUrut + 1;
            } else {
                nomorUrut = 1;
            }
            String nomor = String.format("%04d", nomorUrut);
            tglJual = format.format(dateTanggalJual.getDate());
            fieldKodeJual.setText("PJL/" + tglJual + "/" + nomor);
        }
    }

    private void getDataBarang() {
        BarangDAO dao = new BarangDAOImpl();
        arrayBarang = dao.getBarang();
    }

    private void tampilReport() {
        try {
            File report = new File("src\\id\\ac\\unikom\\inventorygudang\\report\\ReportCetakStrukPenjualan.jrxml");
            jasDes = JRXmlLoader.load(report);
            String image = "src\\id\\ac\\unikom\\inventorygudang\\image\\logo-pusdav.png";
            param.put("logo", image);
            param.put("kodePenjualan", kodePenjualan);
            jasRep = JasperCompileManager.compileReport(jasDes);
            jasPri = JasperFillManager.fillReport(jasRep, param, koneksi.getConnection());
            JasperViewer.viewReport(jasPri, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        fieldKodeJual = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dateTanggalJual = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        fieldTotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fieldTotalBayar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        fieldKembalian = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDaftarBarang = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        fieldKodeBarang = new javax.swing.JTextField();
        btnPilihBarang = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldNamaBarang = new javax.swing.JTextField();
        fieldJumlah = new javax.swing.JTextField();
        fieldHargaJual = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fieldStok = new javax.swing.JTextField();
        btnKembali = new javax.swing.JButton();
        btnCetakStruk = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelJudul = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuKeluar = new javax.swing.JMenuItem();
        menu = new javax.swing.JMenu();
        menuUtama = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Gudang");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Penjualan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Kode Penjualan               : ");

        fieldKodeJual.setEnabled(false);
        fieldKodeJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldKodeJualActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Tanggal Penjualan           :");

        dateTanggalJual.setEnabled(false);
        dateTanggalJual.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTanggalJualPropertyChange(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Harga Total                    :");

        fieldTotal.setEnabled(false);
        fieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotalActionPerformed(evt);
            }
        });
        fieldTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTotalKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Total Bayar                     :");

        fieldTotalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotalBayarActionPerformed(evt);
            }
        });
        fieldTotalBayar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fieldTotalBayarPropertyChange(evt);
            }
        });
        fieldTotalBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTotalBayarKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Kembalian                       :");

        fieldKembalian.setEnabled(false);
        fieldKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldKembalianActionPerformed(evt);
            }
        });
        fieldKembalian.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fieldKembalianPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel14))
                            .addGap(18, 18, 18))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(20, 20, 20)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(20, 20, 20)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTotalBayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(dateTanggalJual, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(fieldKodeJual)
                    .addComponent(fieldTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(fieldKembalian, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fieldKodeJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateTanggalJual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTotal)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        tableDaftarBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableDaftarBarang);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Daftar Penjualan Barang");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Penjualan Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Kode Barang             :");

        fieldKodeBarang.setEnabled(false);
        fieldKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldKodeBarangActionPerformed(evt);
            }
        });

        btnPilihBarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPilihBarang.setText("...");
        btnPilihBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihBarangActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Nama Barang            :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Jumlah Barang           :");

        fieldNamaBarang.setEnabled(false);

        fieldJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldJumlahActionPerformed(evt);
            }
        });
        fieldJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldJumlahKeyPressed(evt);
            }
        });

        fieldHargaJual.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Harga Jual                :");

        fieldStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldStokActionPerformed(evt);
            }
        });
        fieldStok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldStokKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(fieldKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPilihBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fieldNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(fieldJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldStok, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPilihBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNamaBarang))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldJumlah)
                    .addComponent(fieldStok))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldHargaJual)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnReset))
                .addGap(14, 14, 14))
        );

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnCetakStruk.setText("Cetak Struk");
        btnCetakStruk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakStrukActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        labelJudul.setBackground(new java.awt.Color(255, 255, 255));
        labelJudul.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelJudul.setForeground(new java.awt.Color(255, 255, 255));
        labelJudul.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelJudul.setText("CV Pusat Dakwah Visual (PUSDAV)");
        labelJudul.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Jln. Diponegoro No. 63, Cihaurgeulis, Cibeunying Kaler, Bandung 40112");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/ac/unikom/inventorygudang/image/logo-pusdav.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCetakStruk, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnKembali)
                    .addComponent(btnCetakStruk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        menuKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/ac/unikom/inventorygudang/image/icon-exit.png"))); // NOI18N
        menuKeluar.setText("Keluar");
        menuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKeluarActionPerformed(evt);
            }
        });
        jMenu1.add(menuKeluar);

        jMenuBar1.add(jMenu1);

        menu.setText("Menu");

        menuUtama.setText("Halaman Utama");
        menuUtama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUtamaActionPerformed(evt);
            }
        });
        menu.add(menuUtama);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldKodeJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKodeJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodeJualActionPerformed

    private void fieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTotalActionPerformed

    private void menuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKeluarActionPerformed
        dispose();
        FormLogin fl = new FormLogin(this, true);
        fl.setLocationRelativeTo(null);
        fl.setVisible(true);
    }//GEN-LAST:event_menuKeluarActionPerformed

    private void fieldKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKodeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodeBarangActionPerformed

    private void btnPilihBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihBarangActionPerformed
        FormPilihBarang fpb = new FormPilihBarang(this, true);
        fpb.setLocationRelativeTo(null);
        fpb.setVisible(true);
        barang = fpb.getBarang();
        if (barang != null) {
            double harga;
            double hargaJual;
            //String txtHargaJual;
            fieldKodeBarang.setText(barang.getKodeBarang());
            fieldNamaBarang.setText(barang.getNama());
            //fieldHargaBeli.setText(String.valueOf(barang.getHarga()));
            fieldStok.setText(String.valueOf(barang.getStok()));
            jenis = barang.getJenis();
            harga = barang.getHargaBarang();
            hargaJual = harga + (harga * 0.2);
            fieldHargaJual.setText(String.valueOf(Math.round(hargaJual)));
        }
    }//GEN-LAST:event_btnPilihBarangActionPerformed

    private void dateTanggalJualPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTanggalJualPropertyChange

    }//GEN-LAST:event_dateTanggalJualPropertyChange

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        boolean sama = false;
        kodePenjualan = fieldKodeJual.getText();
        String kode = fieldKodeBarang.getText();
        String nama = fieldNamaBarang.getText();
        String txtJumlah = fieldJumlah.getText();
        String txtHarga = fieldHargaJual.getText();

        if ((kode != null && !kode.isEmpty()) && (nama != null && !nama.isEmpty())
                && (txtJumlah != null && !txtJumlah.isEmpty())
                && (txtHarga != null && !txtHarga.isEmpty())
                && (kodePenjualan != null && !kodePenjualan.isEmpty())) {
            int stok = Integer.parseInt(fieldStok.getText());
            int jumlah = Integer.parseInt(txtJumlah);
            if (jumlah > stok) {
                JOptionPane.showMessageDialog(this, "Stok barang : " + stok);
            } else {
                for (int i = 0; i < arrayDetailPenjualan.size(); i++) {
                    if (kode.equalsIgnoreCase(arrayDetailPenjualan.get(i).getKodeBarang())) {
                        sama = true;
                    }
                }
                if (sama) {
                    JOptionPane.showMessageDialog(this, "Data barang sudah dimasukkan !");
                } else {
                    int harga = Integer.parseInt(txtHarga);
                    int hargaBayar = harga * jumlah;
                    String detailJenis = barang.getDetailJenis();
                    hargaTotal = hargaTotal + hargaBayar;
                    DetailPenjualan detailPenjualan = new DetailPenjualan();
                    detailPenjualan.setKodePenjualan(kodePenjualan);
                    detailPenjualan.setKodeBarang(kode);
                    detailPenjualan.setNama(nama);
                    detailPenjualan.setJumlah(jumlah);
                    detailPenjualan.setJenis(jenis);
                    detailPenjualan.setDetailJenis(detailJenis);
                    detailPenjualan.setHarga(harga);
                    detailPenjualan.setSubTotal(hargaBayar);

                    arrayDetailPenjualan.add(detailPenjualan);

                    String txtTotal = String.valueOf(hargaTotal);
                    fieldTotal.setText(txtTotal);
                    getData();
                    fieldKodeBarang.setText(null);
                    fieldNamaBarang.setText(null);
                    fieldJumlah.setText(null);
                    //fieldHargaBeli.setText(null);
                    fieldHargaJual.setText(null);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Silakan isi data form penjualan!");
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        boolean sukses2 = false;
        boolean ketemu = false;
        boolean ubahStok = false;
        int brgKetemu = 0;
        int stok1, stok2, stokBaru = 0;
        String txtBayar, txtKembalian = null;
        String kode2 = "";
        String kodePenjualan = fieldKodeJual.getText();
        Date tglPenjualan = dateTanggalJual.getDate();
        String txtTotal = fieldTotal.getText();
        txtBayar = fieldTotalBayar.getText();

        if ((kodePenjualan != null && !kodePenjualan.isEmpty() && dateTanggalJual != null
                && fieldTotalBayar.getText() != null)
                && (arrayDetailPenjualan.size() != 0)
                && txtBayar != null && !txtBayar.isEmpty()) {
            int total = Integer.parseInt(txtTotal);
            int totalBayar = Integer.parseInt(txtBayar);
            int totalKembalian = totalBayar - total;
            if (totalBayar >= total) {

                fieldKembalian.setText(String.valueOf(totalKembalian));
                Penjualan penjualan = new Penjualan();
                penjualan.setKodePenjualan(kodePenjualan);
                penjualan.setTglJual(tglPenjualan);
                penjualan.setTotal(total);
                penjualan.setTotalBayar(totalBayar);
                penjualan.setKembalian(totalKembalian);
                penjualan.setNoAdmin(idAdmin);

                PenjualanDAO daoP = new PenjualanDAOImpl();
                boolean sukses = daoP.tambahPenjualan(penjualan);

                for (int i = 0; i < arrayDetailPenjualan.size(); i++) {
                    //arrayDetailPembelian.get(i).getKodePembelian();
                    String kodeBarang = arrayDetailPenjualan.get(i).getKodeBarang();
                    String nama = arrayDetailPenjualan.get(i).getNama();
                    String jns = arrayDetailPenjualan.get(i).getJenis();
                    int harga = arrayDetailPenjualan.get(i).getHarga();
                    int jumlah = arrayDetailPenjualan.get(i).getJumlah();
                    int subTotal = arrayDetailPenjualan.get(i).getSubTotal();
                    DetailPenjualan detailPenjualan = new DetailPenjualan();

                    detailPenjualan.setKodePenjualan(kodePenjualan);
                    detailPenjualan.setKodeBarang(kodeBarang);
                    detailPenjualan.setNama(nama);
                    detailPenjualan.setJenis(jns);
                    detailPenjualan.setHarga(harga);
                    detailPenjualan.setJumlah(jumlah);
                    detailPenjualan.setSubTotal(subTotal);

                    for (int j = 0; j < arrayBarang.size(); j++) {
                        if (arrayBarang.get(j).getKodeBarang().equalsIgnoreCase(arrayDetailPenjualan.get(i).getKodeBarang())) {
                            ketemu = true;
                            brgKetemu = j;
                        }
                    }//penutup For j

                    if (ketemu) {
                        stok1 = arrayBarang.get(brgKetemu).getStok();
                        stok2 = arrayDetailPenjualan.get(i).getJumlah();
                        stokBaru = stok1 - stok2;
                        kode2 = arrayBarang.get(brgKetemu).getKodeBarang();
                        Barang barang = new Barang();
                        barang.setStok(stokBaru);
                        barang.setKodeBarang(kode2);

                        BarangDAO ubah = new BarangDAOImpl();
                        boolean suksesUbah = ubah.ubahStok(barang);
                        if (suksesUbah) {
                            ubahStok = true;
                        } else {
                            ubahStok = false;
                        }
                    }

                    DetailPenjualanDAO daoDP = new DetailPenjualanDAOImpl();
                    boolean suksesDetail = daoDP.tambahDetailPenjualan(detailPenjualan);
                    if (suksesDetail && ubahStok) {
                        sukses2 = true;
                    } else {
                        sukses2 = false;
                    }

                }//penutup For i

                if (sukses && sukses2) {
                    JOptionPane.showMessageDialog(this, "Data transaksi berhasil ditambahkan");
                    tampilReport();
                    getDate();
                    fieldTotal.setText(null);
                    fieldTotalBayar.setText(null);
                    fieldKembalian.setText(null);
                    arrayDetailPenjualan.clear();
                    hargaTotal = 0;
                    getData();
                    btnCetakStruk.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Data transaksi gagal ditambahkan!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Uang Bayar tidak boleh kurang!");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Silakan isi data form penjualan dan data barang!");
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void menuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUtamaActionPerformed
        dispose();
        FormMenuUtama fmu = new FormMenuUtama(hakAkses, namaUser, idAdmin);
        fmu.setLocationRelativeTo(null);
        fmu.setVisible(true);
    }//GEN-LAST:event_menuUtamaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        fieldKodeBarang.setText(null);
        fieldNamaBarang.setText(null);
        fieldJumlah.setText(null);
        //fieldHargaBeli.setText(null);
        fieldHargaJual.setText(null);
    }//GEN-LAST:event_btnResetActionPerformed

    private void fieldJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldJumlahKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9)
                || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9)
                || (key == KeyEvent.VK_BACK_SPACE)) {
            fieldJumlah.setEditable(true);
            fieldJumlah.setBackground(Color.white);
        } else {
            fieldJumlah.setEditable(false);
            fieldJumlah.setBackground(Color.red);
        }
    }//GEN-LAST:event_fieldJumlahKeyPressed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        dispose();
        FormPenjualan fp = new FormPenjualan(hakAkses, namaUser, idAdmin);
        fp.setLocationRelativeTo(null);
        fp.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void fieldTotalBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTotalBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTotalBayarActionPerformed

    private void fieldKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKembalianActionPerformed

    private void fieldTotalBayarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fieldTotalBayarPropertyChange

    }//GEN-LAST:event_fieldTotalBayarPropertyChange

    private void btnCetakStrukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakStrukActionPerformed
        tampilReport();
    }//GEN-LAST:event_btnCetakStrukActionPerformed

    private void fieldKembalianPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fieldKembalianPropertyChange

    }//GEN-LAST:event_fieldKembalianPropertyChange

    private void fieldJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldJumlahActionPerformed

    private void fieldTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTotalKeyPressed

    }//GEN-LAST:event_fieldTotalKeyPressed

    private void fieldTotalBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTotalBayarKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9)
                || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9)
                || (key == KeyEvent.VK_BACK_SPACE)) {
            fieldTotalBayar.setEditable(true);
            fieldTotalBayar.setBackground(Color.white);
        } else {
            fieldTotalBayar.setEditable(false);
            fieldTotalBayar.setBackground(Color.red);
        }
    }//GEN-LAST:event_fieldTotalBayarKeyPressed

    private void fieldStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldStokActionPerformed

    private void fieldStokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldStokKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldStokKeyPressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTambahPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTambahPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTambahPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTambahPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormTambahPenjualan fb = new FormTambahPenjualan();
                fb.setLocationRelativeTo(null);
                fb.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetakStruk;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPilihBarang;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private com.toedter.calendar.JDateChooser dateTanggalJual;
    private javax.swing.JTextField fieldHargaJual;
    private javax.swing.JTextField fieldJumlah;
    private javax.swing.JTextField fieldKembalian;
    private javax.swing.JTextField fieldKodeBarang;
    private javax.swing.JTextField fieldKodeJual;
    private javax.swing.JTextField fieldNamaBarang;
    private javax.swing.JTextField fieldStok;
    private javax.swing.JTextField fieldTotal;
    private javax.swing.JTextField fieldTotalBayar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem menuKeluar;
    private javax.swing.JMenuItem menuUtama;
    private javax.swing.JTable tableDaftarBarang;
    // End of variables declaration//GEN-END:variables
}
