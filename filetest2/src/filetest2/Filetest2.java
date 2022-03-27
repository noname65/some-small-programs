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
        String path = "E:/新建文件夹 (8)";
        String[] list = new File(path).list();
        String[] a;
        for (String name : list) {
            a = name.substring(0, name.length() - 4).split("-");
            renameFile(path, name, a[1].trim() + " - " + a[0].trim()+".mp3");
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
