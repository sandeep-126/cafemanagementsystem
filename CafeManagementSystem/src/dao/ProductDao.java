/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import model.Product;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author SandipKoirala
 */
public class ProductDao {
    
    public static void save(Product product){
        String query = "insert into product(name,category,price) values('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";
        DbOperation.setDataOrDelete(query,"Product Added Successfully");
    
    }
    
    public static ArrayList<Product> getAllRecords(){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperation.getData("select *from product");
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                arrayList.add(product);
                
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;           
    }
    
    public static void update(Product product){
      String query = "update product set name ='"+product.getName()+"',category ='"+product.getCategory()+"',price ='"+product.getPrice()+"' where id = '"+product.getId()+"'";
      DbOperation.setDataOrDelete(query,"Product Updated Successfully");
    }
    
    public static void delete(String id ){
        String query = "delete from product where id = '"+id+"'";
        DbOperation.setDataOrDelete(query,"Product Deleted Successfully");
    }
    
    public static ArrayList<Product> getAllRecordsByCategory(String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
          ResultSet rs = DbOperation.getData("select *from product where category ='"+category+"'");
          while(rs.next()){
              Product product = new Product();
              product.setName(rs.getString("name"));
              arrayList.add(product);
          }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static ArrayList<Product> filterProductByname(String name,String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
          ResultSet rs = DbOperation.getData("select *from product where name like '%"+name+"%' and category='"+category+"'");
          while(rs.next()){
              Product product = new Product();
              product.setName(rs.getString("name"));
              arrayList.add(product);
          }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static Product getProductByname(String name){
        Product product = new Product();
        try{
           ResultSet rs = DbOperation.getData("select *from product where name='"+name+"'");
           while (rs.next()){
               product.setName(rs.getString(2));
               product.setCategory(rs.getString(3));
               product.setPrice(rs.getString(4));
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
