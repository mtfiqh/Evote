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
public class DataVoter extends DataOrang {
    boolean keterangan;
    String vote_who;
    public DataVoter(String nim, String nama, String kd_prodi, boolean keterangan, String vote_who) {
        super(nim, nama, kd_prodi);
        this.keterangan=keterangan;
        this.vote_who=vote_who;
    }
    
    public boolean getKeterangan(){
        return keterangan;
    }
    public String getVoteWho(){
        return vote_who;
    }
}
