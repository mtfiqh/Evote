/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mtauf
 */
public class CheckData {
    private String nimMahasiswa=null;
    String username,password;
    ListArray listArray = new ListArray();
    ArrayList<DataLogin> list = new ArrayList<>();
    ArrayList<DataVoter> listDatVot= new ArrayList<>();
    public CheckData(String username,String password){
        this.username=username;
        this.password=password;
        
    }
    public boolean CheckLoginPanitia(){
        
        list = listArray.getListDataLoginPanitia();
        for(int i=0; i<list.size(); i++){
            if(username.equals(list.get(i).getUsername()) && password.equals(list.get(i).password)){
                return true;
            }
        }
        return false;
    }
    public boolean checkLoginVoter(){
        list=listArray.getListDataLoginVoter();
        for(int i=0; i<list.size(); i++){
            if(username.equals(list.get(i).getUsername()) && password.equals(list.get(i).password)){
                listDatVot=listArray.getListDataVoter("SELECT * FROM mahasiswa WHERE NIM='"+username+"'");
                if(listDatVot.get(0).getKeterangan()==false){
                    this.nimMahasiswa=username;
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Sudah Vote!");
                }
            }
        }
        return false;
    }
    public String getNimMahasiswa(){
        return nimMahasiswa;
    }
    
}
