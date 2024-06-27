/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import com.mysql.cj.conf.IntegerPropertyDefinition;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author manin
 */
public class issuebook extends javax.swing.JFrame {

    /**
     * Creates new form issuebook
     */
    public issuebook() {
        initComponents();
    }

    public void getBook() {
        int bookId = Integer.parseInt(txt_bookid.getText());
        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id =?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lbl_book.setText(rs.getString("book_id"));
                lbl_bookname.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));

            } else {
                lbl_bookerror.setText("Invalid Book ID");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void studentdeatails() {
        int studentId = Integer.parseInt(txt_studentid.getText());
        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id =?");
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lbl_id.setText(rs.getString("student_id"));
                lbl_studentname.setText(rs.getString("name"));
                lbl_course.setText(rs.getString("course"));
                lbl_branch.setText(rs.getString("branch"));

            } else {
                lbl_studenterror.setText("Invalid Student ID");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertissuebook() {
        boolean isIssued = false;
        int bookid = Integer.parseInt(txt_bookid.getText());
        int studentid = Integer.parseInt(txt_studentid.getText());
        String bookname = lbl_bookname.getText();
        String Studentname = lbl_studentname.getText();
        Date uIssuedate = date_issuedate.getDatoFecha();
        Date uDueDate = date_duedate.getDatoFecha();
        Long l1 = uIssuedate.getTime();
        Long l2 = uDueDate.getTime();

        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,statu) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookid);
            pst.setString(2, bookname);
            pst.setInt(3, studentid);
            pst.setString(4, Studentname);
            pst.setDate(5, sIssueDate);
              pst.setDate(6, sDueDate);
              pst.setString(7, "PENDING"); 
             int rowCount = pst.executeUpdate();
             if(rowCount > 0){
                isIssued =true; 
             }
              
        }  catch ( Exception e){
            e.printStackTrace();
        }
        return isIssued;
    }
    
    public void updatecount(){
        int bookid = Integer.parseInt(txt_bookid.getText());
        try {
             Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
            PreparedStatement pst =con.prepareStatement(sql);
            pst.setInt(1, bookid);
            int rowCount =  pst.executeUpdate();
            
            if(rowCount > 0){
                JOptionPane.showMessageDialog(this, "Book Count Updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
             }else{
                JOptionPane.showMessageDialog(this, "Can't Book Count Updated");
            }
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean isAlreadyIssued() {
    boolean isAlreadyIssued = false;
    int bookId = Integer.parseInt(txt_bookid.getText());
    int studentId = Integer.parseInt(txt_studentid.getText());
    
    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM issue_book_details WHERE book_id = ? AND student_id = ? AND statu = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, bookId);
        pst.setInt(2, studentId);
        pst.setString(3, "PENDING");
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            isAlreadyIssued = true;
        } else {
            isAlreadyIssued = false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return isAlreadyIssued;
}

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelmain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_book = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_bookerror = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lbl_branch = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_studenterror = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        date_duedate = new rojeru_san.componentes.RSDateChooser();
        date_issuedate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelmain.setBackground(new java.awt.Color(255, 255, 255));
        panelmain.setForeground(new java.awt.Color(51, 51, 51));
        panelmain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(45, 48, 71));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("Book Data");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 250, 90));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 290, 5));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 230, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Id :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Author :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        lbl_book.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_book.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 230, 30));

        lbl_bookname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 230, 30));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 230, 30));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Quantity:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        lbl_bookerror.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookerror.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 260, 40));

        jPanel6.setBackground(new java.awt.Color(45, 48, 71));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        panelmain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 810));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        panelmain.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        jPanel5.setBackground(new java.awt.Color(255, 155, 113));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 310, 5));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(51, 51, 51));
        jPanel5.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 230, 30));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Student Id :");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Student Name :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Course:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Branch:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        lbl_id.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(51, 51, 51));
        jPanel5.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 230, 30));

        lbl_studentname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(51, 51, 51));
        jPanel5.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 230, 30));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(51, 51, 51));
        jPanel5.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 230, 30));

        jLabel14.setBackground(new java.awt.Color(102, 102, 255));
        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel14.setText("Student Details");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 320, 100));

        lbl_studenterror.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studenterror.setForeground(new java.awt.Color(51, 51, 51));
        jPanel5.add(lbl_studenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 280, 40));

        panelmain.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, -10, 420, 810));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel13.setText("Issue Book");
        panelmain.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 60, 190, 50));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panelmain.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 130, -1, -1));

        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(45, 48, 71)));
        txt_bookid.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_bookid.setPlaceholder("Enter  Book Id");
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        txt_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookidActionPerformed(evt);
            }
        });
        panelmain.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 220, 280, 40));

        jLabel9.setFont(new java.awt.Font("Yu Gothic", 1, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Book ID :");
        panelmain.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, -1, -1));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(45, 48, 71)));
        txt_studentid.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_studentid.setPlaceholder("Enter StudentId");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        txt_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentidActionPerformed(evt);
            }
        });
        panelmain.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 300, 280, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic", 1, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Student ID :");
        panelmain.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic", 1, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Issue Date:");
        panelmain.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 380, -1, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic", 1, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Due Date");
        panelmain.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, -1, -1));

        date_duedate.setColorBackground(new java.awt.Color(45, 48, 71));
        date_duedate.setColorForeground(new java.awt.Color(51, 51, 51));
        date_duedate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_duedate.setPlaceholder("Select Dur Date");
        panelmain.add(date_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 440, 310, 30));

        date_issuedate.setColorBackground(new java.awt.Color(45, 48, 71));
        date_issuedate.setColorForeground(new java.awt.Color(51, 51, 51));
        date_issuedate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_issuedate.setPlaceholder("Select issue date");
        panelmain.add(date_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 370, 310, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(45, 48, 71));
        rSMaterialButtonCircle1.setText("Issue book");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panelmain.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 540, 320, 60));

        getContentPane().add(panelmain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
     
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
        if (!txt_bookid.getText().equals("")) {
            getBook();
        }

    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
        if (!txt_studentid.getText().equals("")) {
            studentdeatails();
        }
    }//GEN-LAST:event_txt_studentidFocusLost

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
      if (lbl_quantity.getText().equals("0")) {
    JOptionPane.showMessageDialog(this, "BOOK IS NOT AVAILABLE");
} else {
    if (!isAlreadyIssued()) {
        if (insertissuebook()) {
            JOptionPane.showMessageDialog(this, "BOOK ISSUED");
            updatecount();
        } else {
            JOptionPane.showMessageDialog(this, "CAN'T ISSUE BOOK");
        }
    } else {
        JOptionPane.showMessageDialog(this, "BOOK IS ALREADY ISSUED TO THIS STUDENT");
    }
}

    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Homepage home = new Homepage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked
 
 
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
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new issuebook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_duedate;
    private rojeru_san.componentes.RSDateChooser date_issuedate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_book;
    private javax.swing.JLabel lbl_bookerror;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studenterror;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JPanel panelmain;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}
