/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;

public class DbOperation {
    public static void setDataOrDelete(String query, String msg) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConnectionProvider.getCon();
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Failed to establish connection to the database.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    public static ResultSet getData(String query){
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
    }
}


