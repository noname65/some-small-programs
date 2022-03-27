/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawlertest1;
import com.google.gson.Gson;
import other.IPBean;
import other.IPList;
import other.IPSpider;
import util.IPUtils;
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.net.spi.*;
import java.nio.file.spi.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import javax.xml.parsers.*;
import javax.net.ssl.*;
import javax.xml.xpath.*;

public class WebCrawlerTest1 {

    public static void main(String[] args) {
        String strurl = "http://www.shizongzui.cc/";//http://chuangshi.qq.com/bk/2cy/AGkEPV1oVjYAPVRiATYBZg-r-
        String savepath = "E:/新建文件夹 (11)/";
        File file;
        PrintWriter x;
        URLConnection conn;
        InputStream is;
        BufferedReader br;
        String line;
        byte title;
        ArrayList<String> result;
        String l;
        URL url;
        int[][] cp = {{244, 304}, {305, 364}, {365, 424}, {425, 483}, {484, 539}, {365, 637}};
        int min = 244, max = 637;
        for (int j = min; j < max; j++) {
            try {
                url = new URL(strurl + j + ".html");
                conn = url.openConnection();
                is = conn.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                line = null;
                title = 0;
                result = new ArrayList<String>();
                l = null;
                while ((line = br.readLine()) != null) {
                    //System.out.println(line);
                    line = line.trim();
                    if (title == 1) {
                        result.add(line.substring(4, line.length() - 5));
                        title = 2;
                    } else if (line.equals("<div class=\"chaptertitle clearfix\">") && title != 2) {
                        title = 1;
                    } else if (line.length() > 48 ? (line.substring(0, 48).equals("<div class=\"bookcontent clearfix\" id=\"BookText\">")) : false) {
                        for (int i = 48; i < line.length(); i++) {
                            if (line.substring(i, i + 1).equals("<")) {
                                if (line.substring(i + 1, i + 5).equals("br/>") && l != null && !l.trim().equals("")) {
                                    //System.out.println(l);
                                    result.add(l);
                                    l = "";
                                    i += 9;
                                } else {
                                    while (!line.substring(i - 1, i).equals(">")) {
                                        i++;
                                    }
                                }
                            } else {
                                //System.out.println(line.substring(i, i + 1));
                                l += line.substring(i, i + 1);
                            }
                        }
                        break;
                    }
                }
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
                x.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private List<IPBean> crawl(String api, int index){
        String html = HttpUtils.getResponseContent(api + index);
        System.out.println(html);

        Document document = Jsoup.parse(html);
        Elements eles = document.selectFirst("table").select("tr");

        for (int i = 0; i < eles.size(); i++){
            if (i == 0) continue;
            Element ele = eles.get(i);
            String ip = ele.children().get(1).text();
            int port = Integer.parseInt(ele.children().get(2).text().trim());
            String typeStr = ele.children().get(5).text().trim();

            int type;
            if ("HTTP".equalsIgnoreCase(typeStr))
                type = IPBean.TYPE_HTTP;
            else
                type = IPBean.TYPE_HTTPS;

            IPBean ipBean = new IPBean(ip, port, type);
            ipList.add(ipBean);
        }
        return ipList;
    }
}
