/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;
import GUI.LoginForm;

/**
 *
 * @author mtauf
 */
public class Driver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Display login form
        LoginForm login= new LoginForm();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        login.setResizable(false);
        String encryptPass = (new Security().encrypt("satu dua tiga"));
        System.out.println(encryptPass);
        System.out.println(new Security().decrypt(encryptPass));
        // TODO code application logic here
    }
    
}
