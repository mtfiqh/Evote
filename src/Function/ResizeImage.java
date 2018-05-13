/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author mtauf
 */
public class ResizeImage {
    int width,height;
    String ImagePath;
    
    public ResizeImage(int w,int h,String imgPath){
        this.width=w;
        this.height=h;
        this.ImagePath=imgPath;
    }
    public ImageIcon resizeImage (){
        ImageIcon MyImage=null;
        if(ImagePath!=null){
            MyImage=new ImageIcon(ImagePath);
        }else{
            return null;
        }
        Image img=MyImage.getImage();
        Image newImg=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(newImg);
        return image;
        
    }
}
