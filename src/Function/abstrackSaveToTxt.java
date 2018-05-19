/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

/**
 *
 * @author mtauf
 */
abstract public class  abstrackSaveToTxt {
    abstract void SaveSettings(String host,String username,String password);
    abstract void LoadSettings();
    abstract String getHost();
    abstract String getUsername();
    abstract String getPassword();
}
