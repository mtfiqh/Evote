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
public class DataCalon extends DataOrang{
    private String keterangan;
    private int dipilih;
    public DataCalon(String nim, String nama, String keterangan, int dipilih) {
        super(nim, nama, "");
        this.keterangan=keterangan;
        this.dipilih=dipilih;
    }
    
    public String getKeterangan(){
        return keterangan;
    }
    public int getDipilih(){
        return dipilih;
    }

}
