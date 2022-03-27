package filetest3;

import java.io.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileTest3 {

    public static void main(String[] args) {
        //System.out.println(getSysClipboardText().substring(0, 100).split("\n")[1]);
        //System.exit(0);
        String a = "", b,path="E:\\小说\\万族之劫\\200-299\\";
        int cp;
        boolean end = true;
        File f=null;
        try {
            while (true) {
                b = getSysClipboardText();
                if ((b.length() >= 7 && a.length() >= 7) ? !b.substring(0, 7).equals(a.substring(0, 7)) : b.length() >= 7) {
                    a = b;
                    if (end) {
                        if(ridNum(a.substring(0, 7)).substring(0, 2).equals("第章")){
                            f=new File(path+a.substring(0, 30).split("\n")[0]+".txt");
                            f.createNewFile();
                            write(f,a);
                            end=a.substring(a.length()-5, a.length()).equals("(本章完)");
                        }
                    }else{
                        write(f,a);
                        end=a.substring(a.length()-5, a.length()).equals("(本章完)");
                    }
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(FileTest3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileTest3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getSysClipboardText() {
        String ret = "";
        Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 获取剪切板中的内容
        Transferable clipTf = sysClip.getContents(null);
        if (clipTf != null) {
            // 检查内容是否是文本类型
            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    ret = (String) clipTf
                            .getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    private static int toInt(String s) {
        String result = "";
        boolean a;
        for (int i = 0; i < s.length(); i++) {
            a = false;
            for (int j = 0; j < 10; j++) {
                if (s.substring(i, i + 1).equals(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}[j])) {
                    a = true;
                }
            }
            if (a) {
                result += s.substring(i, i + 1);
            }
        }
        return Integer.parseInt(result);
    }

    private static String ridNum(String s) {
        String result = "";
        boolean a;
        for (int i = 0; i < s.length(); i++) {
            a = false;
            for (int j = 0; j < 10; j++) {
                if (s.substring(i, i + 1).equals(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}[j])) {
                    a = true;
                }
            }
            if (!a) {
                result += s.substring(i, i + 1);
            }
        }
        return result;
    }
    public static void write(File file, String a) {
        String[] b=a.split("\n");
        try (java.io.FileWriter fw = new java.io.FileWriter(file, true)) {
            java.io.PrintWriter x = new java.io.PrintWriter(fw);
            for (int i=0;i<b.length-1;i++) {
                x.println(b[i]);
            }
            x.print(b[b.length-1]);
            x.flush();
            fw.flush();
            x.close();
            fw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
