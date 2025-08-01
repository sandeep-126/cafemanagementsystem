package cafemanagementsystem;

import dao.BillDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.Bill;

/**
 * TodaySalesReport JFrame to display today's total sales in a GUI.
 * 
 * @author 
 */
public class TodaySalesReport extends javax.swing.JFrame {

    /**
     * Creates new form TodaySalesReport
     */
    public TodaySalesReport() {
        initComponents();
        loadTodaySales();
    }

    /**
     * This method retrieves today's total sales and populates the table and total sales label.
     */
    private void loadTodaySales() {
        // Step 1: Get today's date
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date today = new Date();
        String todayDate = dFormat.format(today);

        // Step 2: Retrieve bills for today
        ArrayList<Bill> bills = BillDao.getAllRecordByInc(todayDate);

        // Step 3: Populate the table
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        
        dtm.setRowCount(0);
        double totalSales = 0.0;

        for (Bill bill : bills) {
           totalSales += Double.parseDouble(bill.getTotal());
            dtm.addRow(new Object[]{
                bill.getId(),
                bill.getName(),
                bill.getMobileNumber(),
                bill.getEmail(),
                bill.getDate(),
                bill.getTotal(),
                bill.getCreatedBy()
            });
        }

        // Step 4: Display total sales
        jLabelTotalSales.setText("Total Sales: ₹ " + String.format("%.2f", totalSales));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonClose = new javax.swing.JButton();
        jLabelTotalSales = new javax.swing.JLabel();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("Today's Total Sales Report");
        getContentPane().add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Bill ID", "Customer Name", "Mobile Number", "Email", "Date", "Total Amount", "Created By"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 1500, 500));

        jButtonClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 20, 30, 30));

        jLabelTotalSales.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTotalSales.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalSales.setText("Total Sales: ₹ 0.0");
        getContentPane().add(jLabelTotalSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 620, -1, -1));

        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/full-page-background1.png"))); // NOI18N
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        pack();
    }// </editor-fold>                        

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    /**
     * Main method to launch the JFrame.
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TodaySalesReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonClose;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTotalSales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
