/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 * Class to open PDF files based on ID
 */
public class OpenPdf {
    public static void openById(String id){
        try{
            if((new File ("C:\\Users\\Sandip Koirala\\Pro"+id+".pdf")).exists()){
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\Sandip Koirala\\Pro"+id+".pdf");
            }
            else
                JOptionPane.showMessageDialog(null, "File is not Exists");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
