/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.omg.CORBA.Environment;

/**
 *
 * @author mtauf
 */
public class FileDataDatabase extends abstrackSaveToTxt{
       String host,username,password;
       File file = new File("settingdata.txt");

    public FileDataDatabase() {
        
    }
    
    @Override
    public void SaveSettings(String host,String username,String password){
        //Change database setting
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(host);
            writer.println(username);
            writer.println(password);
            writer.flush();
            JOptionPane.showMessageDialog(null, "Save Success!");
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    public void LoadSettings(){
        //load database setting
        try (Scanner scan = new Scanner(file)) {
            //read isi file
            System.out.println("file found!");
            host=scan.nextLine();
            username=scan.nextLine();
            password=scan.nextLine();
        }
        catch(FileNotFoundException ex){
            System.out.println("file not found!");
            //jika tidak ada file, membuat file default
            SaveSettings("jdbc:mysql://localhost:3306/e-vote_demo", "root", "");
            //lalu load setting lagi
            LoadSettings();
        }
    }
    
    //------START GET DATA----------
    public String getHost(){
        return host;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    //-------END GET DATA------------
}
