/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.inventorygudang;

import id.ac.unikom.inventorygudang.dao.BarangDAO;
import id.ac.unikom.inventorygudang.dao.DetailPembelianDAO;
import id.ac.unikom.inventorygudang.dao.PembelianDAO;
import id.ac.unikom.inventorygudang.daoimpl.BarangDAOImpl;
import id.ac.unikom.inventorygudang.daoimpl.DetailPembelianDAOImpl;
import id.ac.unikom.inventorygudang.daoimpl.PembelianDAOImpl;
import id.ac.unikom.inventorygudang.entity.Barang;
import id.ac.unikom.inventorygudang.entity.DetailPembelian;
import id.ac.unikom.inventorygudang.entity.Pembelian;
import id.ac.unikom.inventorygudang.entity.Supplier;
import id.ac.unikom.inventorygudang.tablemodel.DetailPembelianTM;
import id.ac.unikom.inventorygudang.utility.DatabaseConnectivity;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
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
public class FormTambahPembelian extends javax.swing.JFrame {

    private Barang barang;
    private DetailPembelian detailPembelian;
    private ArrayList<Barang> arrayBarang;
    private ArrayList<DetailPembelian> arrayDetailPembelian = new ArrayList<>();
    private Supplier supplier;
    private String namaUser;
    private String hakAkses;
    private int idAdmin;
    private String tglBeli;
    private int hargaTotal = 0;
    private int kodeSupplier1 = 0;
    private int kodeSupplier2 = 0;
    private String kodePembelian;
    private String jenis = null;
    private Pembelian pb = new Pembelian();
    private PembelianDAO dao = new PembelianDAOImpl();

    //Tipe data untuk memanggil jasper/report
    java.sql.Connection conn;
    JasperReport jasRep;
    JasperPrint jasPri;
    Map param = new HashMap();
    JasperDesign jasDes;
    DatabaseConnectivity koneksi = new DatabaseConnectivity();

    public FormTambahPembelian() {
        initComponents();
        getData();
        getDate();
        getDataBarang();
        btnCetakStruk.setEnabled(false);
    }

    public FormTambahPembelian(String akses, String nama, int noAdmin) {
        initComponents();
        getData();
        getDate();
        getDataBarang();
        namaUser = nama;
        hakAkses = akses;
        idAdmin = noAdmin;
        btnCetakStruk.setEnabled(false);
    }

    private void getData() {
        DetailPembelianTM dp = new DetailPembelianTM();
        dp.setArrayDetailPembelian(arrayDetailPembelian);
        tableDaftarBarang.setModel(dp);
    }

    private void getDataBarang() {
        BarangDAO dao = new BarangDAOImpl();
        arrayBarang = dao.getBarang();
    }

    private void getDate() {
        SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
        Date date = new Date();
        pb = dao.nomorUrut();
        Integer nomorUrut;
        dateTanggalBeli.setDate(date);
        if (dateTanggalBeli.getDate() != null) {
            if (pb.getKodePembelian() != null) {
                nomorUrut = Integer.parseInt(pb.getKodePembelian());
                nomorUrut = nomorUrut + 1;
            } else {
                nomorUrut = 1;
            }
            String nomor = String.format("%04d", nomorUrut);
            tglBeli = format.format(dateTanggalBeli.getDate());
            fieldKodeBeli.setText("PBL/" + tglBeli + "/" + nomor);
        }
    }

    private void tampilReport() {
        try {
            File report = new File("src\\id\\ac\\unikom\\inventorygudang\\report\\ReportCetakStrukPembelian.jrxml");
            jasDes = JRXmlLoader.load(report);
            jasDes.setPageHeight(842);
            jasDes.setPageWidth(595);
            String image = "src\\id\\ac\\unikom\\inventorygudang\\image\\logo-pusdav.png";
            param.put("logo", image);
            param.put("kode_pembelian", kodePembelian);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        fieldKodeBeli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dateTanggalBeli = new com.toedter.calendar.JDateChooser();
        fieldNamaSupplier = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDaftarBarang = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnCetakStruk = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelJudul = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuKeluar = new javax.swing.JMenuItem();
        daftarMenu = new javax.swing.JMenu();
        menuUtama = new javax.swing.JMenuItem();
        menuBarang = new javax.swing.JMenuItem();
        menuSupplier = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Gudang");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pembelian Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
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

        fieldJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldJumlahKeyPressed(evt);
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
                    .addComponent(jLabel6))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(fieldKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPilihBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fieldNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPilihBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNamaBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldJumlah))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnReset))
                .addGap(17, 17, 17))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pembelian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Kode Pembelian             : ");

        fieldKodeBeli.setEnabled(false);
        fieldKodeBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldKodeBeliActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Tanggal Pembelian         :");

        dateTanggalBeli.setEnabled(false);
        dateTanggalBeli.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTanggalBeliPropertyChange(evt);
            }
        });

        fieldNamaSupplier.setEnabled(false);
        fieldNamaSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNamaSupplierActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Nama Supplier                :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dateTanggalBeli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addComponent(fieldKodeBeli, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(fieldNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fieldKodeBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateTanggalBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldNamaSupplier)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jLabel15.setText("Daftar Pembelian Barang");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCetakStruk, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKembali)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSimpan)
                        .addComponent(btnCetakStruk)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Data Penjualan Barang");

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

        daftarMenu.setText("Menu");

        menuUtama.setText("Halaman Utama");
        menuUtama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUtamaActionPerformed(evt);
            }
        });
        daftarMenu.add(menuUtama);

        menuBarang.setText("Barang");
        menuBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarangActionPerformed(evt);
            }
        });
        daftarMenu.add(menuBarang);

        menuSupplier.setText("Supplier");
        menuSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSupplierActionPerformed(evt);
            }
        });
        daftarMenu.add(menuSupplier);

        jMenuBar1.add(daftarMenu);

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

    private void fieldKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKodeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodeBarangActionPerformed

    private void fieldKodeBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKodeBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodeBeliActionPerformed

    private void fieldNamaSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNamaSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaSupplierActionPerformed

    private void menuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKeluarActionPerformed
        dispose();
        FormLogin fl = new FormLogin(this, true);
        fl.setLocationRelativeTo(null);
        fl.setVisible(true);
    }//GEN-LAST:event_menuKeluarActionPerformed

    private void menuSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSupplierActionPerformed
        dispose();
        FormSupplier fs = new FormSupplier(hakAkses, namaUser, idAdmin);
        fs.setLocationRelativeTo(null);
        fs.setVisible(true);
    }//GEN-LAST:event_menuSupplierActionPerformed

    private void menuBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarangActionPerformed
        dispose();
        FormBarang fb = new FormBarang(hakAkses, namaUser, idAdmin);
        fb.setLocationRelativeTo(null);
        fb.setVisible(true);
    }//GEN-LAST:event_menuBarangActionPerformed

    private void btnPilihBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihBarangActionPerformed
        FormPilihBarang fpb = new FormPilihBarang(this, true);
        fpb.setLocationRelativeTo(null);
        fpb.setVisible(true);
        barang = fpb.getBarang();
        if (barang != null) {
            if (fieldNamaSupplier.getText().isEmpty()) {
                fieldNamaSupplier.setText(barang.getNamaSupplier());
                kodeSupplier1 = barang.getKodeSupplier();
            }
            fieldKodeBarang.setText(barang.getKodeBarang());
            fieldNamaBarang.setText(barang.getNama());
            jenis = barang.getJenis();
            kodeSupplier2 = barang.getKodeSupplier();
        }
    }//GEN-LAST:event_btnPilihBarangActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        boolean sama = false;
        kodePembelian = fieldKodeBeli.getText();
        String kode = fieldKodeBarang.getText();
        String nama = fieldNamaBarang.getText();
        String txtJumlah = fieldJumlah.getText();
        //String txtHarga = fieldHargaBeli.getText();
        if ((kode != null && !kode.isEmpty()) && (nama != null && !nama.isEmpty())
                && (txtJumlah != null && !txtJumlah.isEmpty())
                //&& (txtHarga != null && !txtHarga.isEmpty())
                && (kodePembelian != null && !kodePembelian.isEmpty())
                && (fieldNamaSupplier.getText() != null)) {
            if (kodeSupplier1 == kodeSupplier2) {
                for (int i = 0; i < arrayDetailPembelian.size(); i++) {
                    if (kode.equalsIgnoreCase(arrayDetailPembelian.get(i).getKodeBarang())) {
                        sama = true;
                    }
                }
                if (sama) {
                    JOptionPane.showMessageDialog(this, "Data barang sudah dimasukkan");
                } else {
                    int jumlah = Integer.parseInt(txtJumlah);
                    DetailPembelian detailPembelian = new DetailPembelian();
                    detailPembelian.setKodePembelian(kodePembelian);
                    detailPembelian.setKodeBarang(kode);
                    detailPembelian.setNamaBarang(nama);
                    detailPembelian.setJenisBarang(jenis);
                    detailPembelian.setDetailJenisBarang(barang.getDetailJenis());
                    detailPembelian.setJumlahBarang(jumlah);

                    arrayDetailPembelian.add(detailPembelian);
                    getData();
                    fieldKodeBarang.setText(null);
                    fieldNamaBarang.setText(null);
                    fieldJumlah.setText(null);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Silakan pilih barang dari supplier " + fieldNamaSupplier.getText());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Silakan isi data form Pembelian!");
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void dateTanggalBeliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTanggalBeliPropertyChange

    }//GEN-LAST:event_dateTanggalBeliPropertyChange

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        boolean sukses2 = false;
        String kodePembelian = fieldKodeBeli.getText();
        Date tglPembelian = dateTanggalBeli.getDate();
        int kodeSupplier = barang.getKodeSupplier();

        if ((kodePembelian != null && !kodePembelian.isEmpty())
                && (arrayDetailPembelian.size() != 0)) {

            Pembelian pembelian = new Pembelian();
            pembelian.setKodeSupplier(kodeSupplier);
            pembelian.setKodePembelian(kodePembelian);
            pembelian.setTglBeli(tglPembelian);
            pembelian.setNoAdmin(idAdmin);
            PembelianDAO daoP = new PembelianDAOImpl();
            boolean sukses = daoP.tambahPembelian(pembelian);

            for (int i = 0; i < arrayDetailPembelian.size(); i++) {
                String kodeBarang = arrayDetailPembelian.get(i).getKodeBarang();
                String nama = arrayDetailPembelian.get(i).getNamaBarang();
                String jns = arrayDetailPembelian.get(i).getJenisBarang();
                String detailJenis = arrayDetailPembelian.get(i).getDetailJenisBarang();
                int jumlah = arrayDetailPembelian.get(i).getJumlahBarang();

                DetailPembelian detailPembelian = new DetailPembelian();

                detailPembelian.setKodePembelian(kodePembelian);
                detailPembelian.setKodeBarang(kodeBarang);
                detailPembelian.setNamaBarang(nama);
                detailPembelian.setJenisBarang(jns);
                detailPembelian.setDetailJenisBarang(detailJenis);
                detailPembelian.setJumlahBarang(jumlah);

                DetailPembelianDAO daoDP = new DetailPembelianDAOImpl();
                boolean suksesDetail = daoDP.tambahDetailPembelian(detailPembelian);
                if (suksesDetail) {
                    sukses2 = true;
                } else {
                    sukses2 = false;
                }
            }

            if (sukses && sukses2) {
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil ditambahkan");
                tampilReport();
                btnCetakStruk.setEnabled(true);
                fieldNamaSupplier.setText(null);
                //fieldTotal.setText(null);
                getDate();
                arrayDetailPembelian.clear();
                getData();
            } else {
                JOptionPane.showMessageDialog(this, "Data transaksi gagal ditambahkan");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Silakan isi data form pembelian dan data barang!");
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
        FormPembelian fp = new FormPembelian(hakAkses, namaUser, idAdmin);
        fp.setLocationRelativeTo(null);
        fp.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnCetakStrukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakStrukActionPerformed
        tampilReport();
    }//GEN-LAST:event_btnCetakStrukActionPerformed

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
            java.util.logging.Logger.getLogger(FormTambahPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTambahPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTambahPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTambahPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormTambahPembelian fb = new FormTambahPembelian();
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
    private javax.swing.JMenu daftarMenu;
    private com.toedter.calendar.JDateChooser dateTanggalBeli;
    private javax.swing.JTextField fieldJumlah;
    private javax.swing.JTextField fieldKodeBarang;
    private javax.swing.JTextField fieldKodeBeli;
    private javax.swing.JTextField fieldNamaBarang;
    private javax.swing.JTextField fieldNamaSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JMenuItem menuBarang;
    private javax.swing.JMenuItem menuKeluar;
    private javax.swing.JMenuItem menuSupplier;
    private javax.swing.JMenuItem menuUtama;
    private javax.swing.JTable tableDaftarBarang;
    // End of variables declaration//GEN-END:variables
}
