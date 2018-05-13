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
public class DataOrang {
    String nim,nama,kd_prodi;
    public DataOrang(String nim,String nama,String kd_prodi){
        this.nim=nim;
        this.nama=nama;
        this.kd_prodi=kd_prodi;
    }
    
    public String getNama(){
        return nama;
    }
    public String getNim(){
        return nim;
    }
    public String getProdi(){
        return kd_prodi;
    }
}
