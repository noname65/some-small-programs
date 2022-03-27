package webcrawlertest2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

public class WebCrawlerTest2 {

    static String strurl = "https://www.dawenxue.net";
    static String strid = "/108082/";
    static String savepath = "E:/新建文件夹 (11)/";
    static String filepath = "1-99/";
    static int cp100 = 0;
    static File file;
    static PrintWriter x;
    static URLConnection conn;
    static InputStream is;
    static BufferedReader br;
    static String line;
    static String[] ll;
    static byte title;
    static ArrayList<String> result = new ArrayList<>();
    static String l;
    static URL url;

    public static void main(String[] args) {
        //System.out.println("<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;".length());
        //System.out.println(1200 / 100);
        //System.exit(0);
        getList();
        boolean start = false;
        /**
         * int cp=0;try {url = new URL(strurl);conn = url.openConnection();is =
         * conn.getInputStream();br = new BufferedReader(new
         * InputStreamReader(is, "GBK")); file = new File(savepath +
         * "asd.txt");if (!file.exists()) {file.createNewFile();}x = new
         * PrintWriter(file);while (true) { line = br.readLine();if (line !=
         * null) {line = line.trim();if (line.equals("<dt>《放开那个女巫》正文卷</dt>"))
         * {start = true; continue;} else if (line.equals("</dl>")) {start =
         * false;break;}if (start) {if (line.split(">")[2].substring(0,
         * 1).equals("第")) { line =
         * line.split(">")[1];x.println(line.substring(10, line.length() - 1));}
         * else {System.out.println(line);}} else if (start) {
         * System.out.println(line);}} else
         * {System.out.println(line);break;}}x.flush();x.close();System.exit(0);}
         * catch (IOException e) { e.printStackTrace();}int min = 244, max =
         * 637;
         */
        file = new File(savepath + "list.txt");
        try {
            java.io.BufferedReader read = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), "UTF-8"));//读取文件
            file = new File(savepath + filepath);
            if (!file.exists()) {
                file.mkdir();
            }
            for (int j = 650; (l = read.readLine()) != null; j++) {
                System.out.println(j);
                if (j / 100 > cp100) {
                    cp100 = j / 100;
                    filepath = (j / 100) + "00-" + (j / 100) + "99";
                    file = new File(savepath + filepath);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                }
                url = new URL(strurl + l);
                conn = url.openConnection();
                is = conn.getInputStream();
                br = new BufferedReader(new InputStreamReader(new URL(strurl + l).openConnection().getInputStream(), "UTF-8"));
                line = null;
                start = false;
                result = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    //System.out.println(line);
                    line = line.trim();
                    if (start) {
                        if (line.length() < 6) {
                            continue;
                        }
                        if (line.substring(0, 3).equals("<p>")) {
                            result.add("  " + line.substring(3, line.length() - 4));
                            //x.println("  " + line.substring(3, line.length() - 4));
                        } else if (line.substring(0, 6).equals("</div>")) {
                            break;
                        }
                        //System.out.println(line);
                        //System.out.println(line.substring(12));
                        //ll = line.substring(12).split("<br /><br />");
                        //System.out.println(Arrays.toString(ll));
                        //System.exit(0);
                        //result.addAll(Arrays.asList(ll));
                        //break;
                    } else if (line.length() > 9 ? line.substring(0, 4).equals("<h1>") : false) {
                        result.add(line.substring(4, line.length() - 5));
                        //file = new File(savepath + filepath + (j < 10 ? "/00" : (j < 100 ? "/0" : "/")) + j + line.substring(4, line.length() - 5).replace("/".charAt(0), "_".charAt(0)) + ".txt");
                        //if (!file.exists()) {
                            //file.createNewFile();
                        //}
                        //x = new PrintWriter(file);
                        //x.println(line.substring(4, line.length() - 5));
                    } else if (line.length() == 18 ? (line.substring(0, 18).equals("<div id=\"content\">")) : false) {
                        start = true;
                    }
                }
                br.close();
                file = new File(savepath + filepath + (j < 100 ? (j < 10 ? "/00":"/0") : "/") + j + result.get(0).replace("/".charAt(0), "_".charAt(0)) + ".txt");
                if (!file.exists()) {
                file.createNewFile();
                }
                x = new PrintWriter(file);
                for (int i = 0; i < result.size(); i++) {
                    x.println(result.get(i));
                }
                x.flush();
                x.close();
                //System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getList() {
        //System.out.println("<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;".length());
        //System.exit(0);
        boolean start = false;
        int cp = 0;
        try {
            url = new URL(strurl + strid);
            conn = url.openConnection();
            is = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            file = new File(savepath + "list.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            x = new PrintWriter(file);
            while (true) {
                line = br.readLine();
                if (line != null) {
                    line = line.trim();
                    if (start) {
                        if (line.length() > 20 && line.substring(0, 13).equals("<dd><a href=\"")) {
                            x.println(line.split("\"")[1]);
                        }
                    } else if (line.length() >= 13 && line.substring(line.length() - 9, line.length()).equals("全部章节</dt>")) {
                        start = true;
                    }
                } else {
                    break;
                }
            }
            x.flush();
            x.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        file = new File(savepath + "asd.txt");
        try {
            java.io.BufferedReader read = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), "UTF-8"));//读取文件
            for (int j = 0; (l = read.readLine()) != null; j++) {
                System.out.println(j);
                url = new URL(strurl + l);
                conn = url.openConnection();
                is = conn.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "GBK"));
                line = null;
                start = false;
                result = new ArrayList<String>();
                while ((line = br.readLine()) != null) {
                    //System.out.println(line);
                    line = line.trim();
                    if (start) {
                        if (line.length() == 6) {
                            continue;
                        }
                        if (line.substring(0, 8).equals("<script>")) {
                            break;
                        }
                        //System.out.println(line);
                        //System.out.println(line.substring(12));
                        //ll = line.substring(12).split("<br /><br />");
                        //System.out.println(Arrays.toString(ll));
                        //System.exit(0);
                        //result.addAll(Arrays.asList(ll));
                        result.add(line.substring(12));
                        //break;
                    } else if (line.length() > 7 ? line.substring(0, 7).equals("<title>") : false) {
                        result.add((j + 1) + line.substring(8, line.length() - 21));
                    } else if (line.length() > 42 ? (line.substring(0, 42).equals("<div id=\"content\" class=\"showtxt\"><script>")) : false) {
                        result.add(line.split("</script><br />")[1]);
                        //result.addAll(Arrays.asList(line.split("</script><br />")[1].split("<br /><br />")));
                        //result.set(result.size()-1, result.get(result.size()-1).split("<br />")[0]);
                        //break;
                        start = true;
                    }
                }
                result.set(result.size() - 1, result.get(result.size() - 1).split("<br />")[0]);
                br.close();
                file = new File(savepath + result.get(0) + ".txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                x = new PrintWriter(file);
                for (int i = 0; i < result.size(); i++) {
                    x.println(result.get(i));
                }
                x.flush();
                x.close();//System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        try {
            url = new URL(strurl);
            conn = url.openConnection();
            is = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String ridNum(String s) {
        String result = "";
        boolean a;
        for (int i = 0; i < s.length(); i++) {
            a = false;
            for (int j = 0; j < 10; j++) {
                if (s.substring(i, i + 1).equals(new String[]{
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                    "零", "一", "二", "三", "四", "五", "六", "七", "八", "九",
                    "十", "百", "千", "万"}[j])) {
                    a = true;
                }
            }
            if (!a) {
                result += s.substring(i, i + 1);
            }
        }
        return result;
    }
}
