/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mtauf
 */
public class ListArray {
        DatabaseConnection datacon = new DatabaseConnection();
        private Connection con;
    public ArrayList<DataLogin> getListDataLoginPanitia(){
        ArrayList<DataLogin> listArrayDataLogin = new ArrayList<>();
        con=datacon.getConnection();
        Statement st;
        ResultSet rs;
        try{
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM loginsuper");
            DataLogin dataLogin;
            while(rs.next()){
                dataLogin = new DataLogin(rs.getString("username"), rs.getString("password"));
                listArrayDataLogin.add(dataLogin);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listArrayDataLogin;
    }
    public ArrayList<DataLogin> getListDataLoginVoter(){
        ArrayList<DataLogin> listArrayDataLogin = new ArrayList<>();
        con=datacon.getConnection();
        Statement st;
        ResultSet rs;
        try{
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM loginvoter");
            DataLogin dataLogin;
            while(rs.next()){
                dataLogin = new DataLogin(rs.getString("username"), rs.getString("password"));
                listArrayDataLogin.add(dataLogin);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listArrayDataLogin;
    }
    
    
    public ArrayList<DataVoter> getListDataVoter(String query){
        ArrayList<DataVoter> listArrayDataVoter = new ArrayList<>();
        con=datacon.getConnection();
        Statement st;
        ResultSet rs;
        try{
            st=con.createStatement();
            rs=st.executeQuery(query);
            DataVoter voter;
            while(rs.next()){
                voter=new DataVoter(rs.getString("NIM"), rs.getString("Nama"), rs.getString("kd_prodi"), rs.getBoolean("keterangan"),rs.getString("vote_who"));
                listArrayDataVoter.add(voter);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listArrayDataVoter;
    }
    
    public ArrayList<DataCalon> getListDataCalon(String query){
        ArrayList<DataCalon> listArrayDataCalon = new ArrayList<>();
        con=datacon.getConnection();
        Statement st;
        ResultSet rs;
        try{
            st=con.createStatement();
            rs=st.executeQuery(query);
            DataCalon calon;
            while(rs.next()){
                calon=new DataCalon(rs.getString("NIM"), rs.getString("Nama"), rs.getString("keterangan"), rs.getInt("dipilih"));
                listArrayDataCalon.add(calon);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listArrayDataCalon;
    }
}
