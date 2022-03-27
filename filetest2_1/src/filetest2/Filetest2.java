/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetest2;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Filetest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Filetest2();
    }

    Filetest2() {
        String path = "D:/Documents/MuMu共享文件夹/新建文件夹 (2)";
        String[] list = new File(path).list();
        String[] namelist= new String[list.length];
        String a,read;
        String[] l;
        File f;
        for (String name : list) {
            try {
                a="";
                f=new File(path+"/"+name+"/1/entry.json");
                read = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(f), "UTF-8")).readLine();//读取文件
                //System.out.println(read.split("\"title\":\"")[1].split("\",\"type_tag\":")[0]+".blv");
                //System.exit(0);
                l=new File(path+"/"+name).list();
                System.out.println(Arrays.toString(l));
                for(int j=0;j<l.length;j++)if(l[j].substring(0, 3).equals("lua"))a=l[j];
                System.exit(0);
                renameFile(path+"/"+name+"/1/"+a, "0.blv", read.split("\"title\":\"")[1].split("\",\"type_tag\":")[0]+".blv");
            } catch (IOException ex) {
                Logger.getLogger(Filetest2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void renameFile(String path, String oldname, String newname) {
        if (!oldname.equals(newname)) {//新的文件名和以前文件名不同时,才有必要进行重命名 
            File oldfile = new File(path + "/" + oldname);
            File newfile = new File(path + "/" + newname);
            if (!oldfile.exists()) {
                return;//重命名文件不存在
            }
            if (newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名 
            {
                System.out.println(newname + "已经存在！");
            } else {
                oldfile.renameTo(newfile);
            }
        } else {
            System.out.println("新文件名和旧文件名相同...");
        }
    }
}
