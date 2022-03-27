package filetest6;

import java.io.IOException;

public class FileTest6 {

    public static void main(String[] args) {
        try {
            java.util.ArrayList<String> a=new java.util.ArrayList<>();
            String l;
            java.io.File f = new java.io.File("C:\\Users\\Administrator\\Desktop\\340457631ac98c2349ef3318ecf9bf0fdca3a6b9");
            java.io.BufferedReader read = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(f), "UTF-8"));
            java.io.PrintWriter asd = new java.io.PrintWriter(new java.io.FileWriter(new java.io.File("C:\\Users\\Administrator\\Desktop\\新建文本文档 (2).txt"), true));
            for (int i = 0; (l = read.readLine()) != null; i++) {
                asd.print(UtS(l));
                asd.println();
            }
            asd.flush();
            asd.close();
        } catch (java.io.FileNotFoundException | java.io.UnsupportedEncodingException ex) {
        } catch (java.io.IOException ex) {
        }
    }
    public static void test() throws IOException{
        java.io.PrintWriter asd = new java.io.PrintWriter(new java.io.FileWriter(new java.io.File("C:\\Users\\Administrator\\Desktop\\新建文本文档.txt"), true));
        for(int i=8192;i<=Short.MAX_VALUE;i++){
            asd.print("    \"enchantment.level."+i+"\": \"Lv."+i+"\",");
            asd.println();
        }
        asd.flush();
        asd.close();
    }
    public static String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <values.length && num >=0 ; i++) {
            while (values[i] <= num){
                num  -=values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
    public static String UtS(String a){
        String result="";
        int last=0;
        for (int i=0;i<a.length()-1;i++)if(a.substring(i,i+2).equals("\\u")){
            result+=a.substring(last,i)+(char)Integer.parseInt(a.substring(i+2,i+6),16);
            last=i+6;
            i+=5;
        }
        result+=a.substring(last);
        return result.equals("")?a:result;
    }
}
