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
public class Security {
    public static final int[] chain={
        5,9,3,1,2,4,6,8,7
    };
    
    public String encrypt(String text){
        String result="";
        int l = text.length();
        char ch;
        int ck=0;
        for(int i=0;i<l;i++){
            if(ck>=chain.length -1) ck=0;
            ch=text.charAt(i);
            ch+=chain[ck];
            result+=ch;
            ck++;
        }
        return result;
    }
    public String decrypt(String text){
        String result="";
        int l = text.length();
        char ch;
        int ck=0;
        for(int i=0;i<l;i++){
            if(ck>=chain.length -1) ck=0;
            ch=text.charAt(i);
            ch-=chain[ck];
            result+=ch;
            ck++;
        }
        return result;
    }
    
}
