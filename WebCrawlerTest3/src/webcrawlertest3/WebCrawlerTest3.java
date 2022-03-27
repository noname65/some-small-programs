package webcrawlertest3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import redis.clients.jedis.Jedis;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawlerTest3 {

    //private static String name = "";
    static String strurl = "http://www.wucuoxs.com";//"https://www.dawenxue.net";
    static String strid = "/108082/";//轮回乐园:81080|万族之劫:80580|修真聊天群:49301|86178|诸天演道:89316|不死的我只好假扮血族:91445|诡秘之主:81091
    static String savepath = "D:\\迅雷下载\\asd";
    static String filepath = "1-99/";
    static int cp100 = 0, j1,start=1;
    static File file;
    static PrintWriter x;
    //static URLConnection conn;
    //static InputStream is;
    static BufferedReader br;
    static String line;
    static String[] ll;
    static String title;
    static ArrayList<String> result = new ArrayList<>();
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<Thread> robots = new ArrayList<>();
    static String l;
    //static URL url;
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;".length());
        //System.out.println(1200 / 100);
        /*ArrayList<String> aa = new ArrayList<>();
        aa.add("1");
        aa.add("2");
        aa.add("3");
        aa.add("3");
        aa.add("4");
        System.out.println(aa);
        aa.removeIf(e -> e.equals("3"));
        System.out.println(aa);
        System.exit(0);*/
        //parse();
        //test();
        getList();
        //System.out.println(list);
        //boolean start = false;
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
        //file = new File(savepath + "list.txt");
        //java.io.BufferedReader read = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), "UTF-8"));//读取文件
        file = new File(savepath + title + "/" + filepath);
        if (!file.exists()) {
            file.mkdir();
        }
        For1:
        for (j1 = start; j1 < list.size(); j1++) {
            System.out.println(j1 + "/" + (list.size()-1));
            l = list.get(j1 - 1);
            if (j1 / 100 > cp100) {
                cp100 = j1 / 100;
                filepath = (j1 / 100) + "00-" + (j1 / 100) + "99";
                file = new File(savepath + title + "/" + filepath);
                if (!file.exists()) {
                    file.mkdir();
                }
            }
            robots.add(new Thread("Timer") {
                BufferedReader br;
                String line1 = null, l1 = l, su = strurl;
                String title1 = title, sp = savepath;
                ArrayList<String> result = new ArrayList<>();
                PrintWriter x;
                String fp = filepath;
                File f;
                int j2 = j1;

                @Override
                public void run() {
                    try {
                        boolean start = false;
                        br = new BufferedReader(new InputStreamReader(new URL(su + l1).openConnection().getInputStream(), "UTF-8"));
                        A:
                        while ((line1 = br.readLine()) != null) {
                            //System.out.println(line1);
                            line1 = line1.trim();
                            if (start) {
                                if (line1.length() < 6) {
                                    continue;
                                }
                                if (line1.substring(0, 3).equals("<p>")) {
                                    result.add("  " + line1.substring(3, line1.length() < 8 ? line1.length() : line1.length() - 4));
                                    //x.println("  " + line1.substring(3, line1.length() - 4));
                                } else if (line1.substring(0, 6).equals("</div>")) {
                                    break;
                                }
                                //System.out.println(line1);
                                //System.out.println(line1.substring(12));
                                //ll = line1.substring(12).split("<br /><br />");
                                //System.out.println(Arrays.toString(ll));
                                //System.exit(0);
                                //result.addAll(Arrays.asList(ll));
                                //break;
                            } else if (line1.length() > 9 ? line1.substring(0, 4).equals("<h1>") : false) {
                                result.add(line1.substring(4, line1.length() - 5));
                                f = new File(sp + title1 + "/" + fp + (j2 < 100 ? (j2 < 10 ? "/00" : "/0") : "/") + j2 + result.get(0).replaceAll("[\\\\/:\\*\\?\\\"<>\\|]", "") + ".txt");
                                //if (f.exists() && new java.io.FileInputStream(f).available() > 100) {
                                //    break A;
                                //}
                                //file = new File(savepath+title1+"/" + filepath + (j1 < 10 ? "/00" : (j1 < 100 ? "/0" : "/")) + j1 + line1.substring(4, line1.length() - 5).replace("/".charAt(0), "_".charAt(0)) + ".txt");
                                //if (!file.exists()) {
                                //file.createNewFile();
                                //}
                                //x = new PrintWriter(file);
                                //x.println(line1.substring(4, line1.length() - 5));
                            } else if (line1.length() == 18 ? (line1.substring(0, 18).equals("<div id=\"content\">")) : false) {
                                start = true;
                            }
                        }
                        br.close();
                        result.removeIf(e -> e.contains("咪咪"));
                        result.removeIf(e -> e.contains("咪\\咪"));
                        f = new File(sp + title1 + "/" + fp + (j2 < 100 ? (j2 < 10 ? "/00" : "/0") : "/") + j2 + result.get(0).replaceAll("[\\\\/:\\*\\?\\\"<>\\|\\▄\\█\\●\\√]", "") + ".txt");
                        if (!f.exists()) {
                            f.createNewFile();
                        }
                        x = new PrintWriter(f);
                        for (int i = 0; i < result.size(); i++) {
                            x.println(result.get(i));
                        }
                        x.flush();
                        x.close();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(WebCrawlerTest3.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(WebCrawlerTest3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            robots.get(robots.size() - 1).start();
            if (j1 % 10 == 0) {
                Thread.sleep(1000);
            }
            /*br = new BufferedReader(new InputStreamReader(new URL(strurl + l).openConnection().getInputStream(), "UTF-8"));
            line1 = null;
            start = false;
            result = new ArrayList<>();
            while ((line1 = br.readLine()) != null) {
            //System.out.println(line1);
            line1 = line1.trim();
            if (start) {
            if (line1.length() < 6) {
            continue;
            }
            if (line1.substring(0, 3).equals("<p>")) {
            result.add("  " + line1.substring(3, line1.length() < 8 ? line1.length() : line1.length() - 4));
            //x.println("  " + line1.substring(3, line1.length() - 4));
            } else if (line1.substring(0, 6).equals("</div>")) {
            break;
            }
            //System.out.println(line1);
            //System.out.println(line1.substring(12));
            //ll = line1.substring(12).split("<br /><br />");
            //System.out.println(Arrays.toString(ll));
            //System.exit(0);
            //result.addAll(Arrays.asList(ll));
            //break;
            } else if (line1.length() > 9 ? line1.substring(0, 4).equals("<h1>") : false) {
            result.add(line1.substring(4, line1.length() - 5));
            file = new File(savepath + title + "/" + filepath + (j1 < 100 ? (j1 < 10 ? "/00" : "/0") : "/") + j1 + result.get(0).replaceAll("[\\\\/:\\*\\?\\\"<>\\|]", "") + ".txt");
            if (file.exists() && new java.io.FileInputStream(file).available() > 100) {
            continue For1;
            }
            //file = new File(savepath+title1+"/" + filepath + (j1 < 10 ? "/00" : (j1 < 100 ? "/0" : "/")) + j1 + line1.substring(4, line1.length() - 5).replace("/".charAt(0), "_".charAt(0)) + ".txt");
            //if (!file.exists()) {
            //file.createNewFile();
            //}
            //x = new PrintWriter(file);
            //x.println(line1.substring(4, line1.length() - 5));
            } else if (line1.length() == 18 ? (line1.substring(0, 18).equals("<div id=\"content\">")) : false) {
            start = true;
            }
            }
            br.close();
            file = new File(savepath + title + "/" + filepath + (j1 < 100 ? (j1 < 10 ? "/00" : "/0") : "/") + j1 + result.get(0).replaceAll("[\\\\/:\\*\\?\\\"<>\\|]", "") + ".txt");
            if (!file.exists()) {
            file.createNewFile();
            }
            x = new PrintWriter(file);
            for (int i = 0; i < result.size(); i++) {
            x.println(result.get(i));
            }
            x.flush();
            x.close();*/
            //System.exit(0);
        }
    }

    public static void getList() {
        //System.out.println("<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;".length());
        //System.exit(0);
        boolean start = false;
        //int cp = 0;
        try {
            //url = new URL(strurl + strid);
            br = new BufferedReader(new InputStreamReader(new URL(strurl + strid).openConnection().getInputStream(), "UTF-8"));
            //file = new File(savepath + "list.txt");
            //if (!file.exists()) {
                //file.createNewFile();
            //}
            //x = new PrintWriter(file);
            while (true) {
                line = br.readLine();
                if (line != null) {
                    line = line.trim();
                    if (start) {
                        if (line.length() > 20 && line.substring(0, 13).equals("<dd><a href=\"")) {
                            list.add(line.split("\"")[1]);
                            //x.println(line1.split("\"")[1]);
                        }
                    } else if (line.length() >= 35 && line.substring(0, 35).equals("<meta property=\"og:title\" content=\"")) {
                        title = line.split("\"")[3];
                        file = new File(savepath + title);
                        if (!file.exists()) {
                            file.mkdir();
                        }
                    } else if (line.length() >= 13 && line.substring(line.length() - 9, line.length()).equals("全部章节</dt>")) {
                        start = true;
                    }
                } else {
                    break;
                }
            }
            //x.flush();
            //x.close();
        } catch (IOException e) {
        }
    }

    public static void test() {
        try {
            //url = new URL(strurl);
            br = new BufferedReader(new InputStreamReader(new URL(strurl + strid).openConnection().getInputStream(), "UTF-8"));
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

    public static void parse() {

        // blogBody("");
        List<String> list = null;
        try {
            list = getHtml();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String path = "/Users/tianjia/Documents/article";
        List<String> articles = FileUtil.getListFromFile(path);
        ExecutorService executorService = Executors.newCachedThreadPool();
        int len_article = articles.size();
        for (int i = 0; i < len_article; i++) {
            executorService.execute(new MyRun(articles.get(i), list));
        }
    }

    private static List<String> getHtml() throws IOException {
        Document doc = null;
        try {
            // doc = Jsoup.connect("http://www.baidu.com")
            doc = Jsoup.connect("http://www.xicidaili.com/nt")
                    // .data("query", "Java")
                    .userAgent("Mozilla")
                    // .cookie("auth", "token")
                    // .timeout(3000)
                    .get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<String> list = new ArrayList<String>();
        Elements elements = doc.select("tr.odd");
        int len = elements.size();
        Element element = null;
        for (int i = 0; i < len; i++) {
            element = elements.get(i);
            StringBuilder sBuilder = new StringBuilder(20);
            sBuilder.append(element.child(1).text());
            sBuilder.append(":");
            sBuilder.append(element.child(2).text());
            list.add(sBuilder.toString());
        }
        // System.out.println(doc.html());
        doc = null;
        elements.clear();
        elements = null;
        return list;
    }

    public static void visit(String ip, String url) {
        // prop.setProperty("http.proxyHost", "183.45.78.31");
        // 设置http访问要使用的代理服务器的端口
        // prop.setProperty("http.proxyPort", "8080");
        String[] r = ip.split(":");
        System.getProperties().setProperty("http.proxyHost", r[0]);
        System.getProperties().setProperty("http.proxyPort", r[1]);
        try {
            // doc = Jsoup.connect("http://www.baidu.com")
            Jsoup.connect(url)
                    // .data("query", "Java")
                    .userAgent("Mozilla")
                    // .cookie("auth", "token")
                    // .timeout(3000)
                    .get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
