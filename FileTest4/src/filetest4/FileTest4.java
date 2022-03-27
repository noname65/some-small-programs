package filetest4;

public class FileTest4 {
    
    private final Object lock = new Object();
    private javax.swing.JFrame jf;
    private javax.swing.JPanel jp;
    private java.awt.image.BufferedImage bi;
    private String name;
    private short display_memory = 1;

    public static void main(String[] args) {
        FileTest4 ts4 = new FileTest4();
    }

    public FileTest4() {
        bi = null;
        int h, w;
        java.io.File f = null;
        try {
            main:
            while (true) {
                switch (SomeTools.customOptions("选择操作", new String[]{//设置选项
                    "读取图片文件(jpg/png)",
                    "读取图片文件(txt)",
                    "保存图片文件(txt)",
                    "保存图片文件(jpg)",
                    "显示读取图片",
                    "exit"
                }, 1).toString()) {
                    case "读取图片文件(jpg/png)":
                        f = SomeTools.fileChooser(new String[][]{{".jpg", "? (.jpg)"}, {".png", "¿ (.png)"}});//选择文件
                        if (f == null) {//如果没有选择文件,则返回
                            System.out.println("\033[46m没有选择文件\033[m");
                            continue;
                        }
                        bi = javax.imageio.ImageIO.read(f);//读取图片文件
                        name = f.getName();//获取文件名
                        System.out.println("\033[46m读取成功\033[m");
                        break;
                    case "保存图片文件(txt)":
                        //assert bi != null;
                        if (bi == null) {//如果没有读取图片,则返回
                            System.out.println("\033[46m没有读取图片\033[m");
                            continue;
                        }
                        f = SomeTools.fileChooser();//选择文件夹
                        if (f == null) {//如果没有选择文件夹,则返回
                            System.out.println("\033[46m没有选择文件夹\033[m");
                            continue;
                        }
                        f = new java.io.File(f.getPath() + "//" + name.substring(0, name.length() - 3) + "txt");
                        if (f.exists()) {//如果该文件夹有同名文件,则返回
                            System.out.println("\033[46m该文件夹已存在同名文件\033[m");
                            continue;
                        }
                        java.io.FileWriter fw = new java.io.FileWriter(f, true);
                        java.io.PrintWriter asd = new java.io.PrintWriter(fw);
                        h = bi.getHeight();//获取图片高度
                        w = bi.getWidth();//获取图片宽度
                        for (int y = 0; y < h; y++) {//逐行循环
                            for (int x = 0; x < w - 1; x++) {//每行逐个循环
                                java.awt.Color c = new java.awt.Color(bi.getRGB(x, y));//获取像素RGB值
                                asd.print(c.getRed() + "-" + c.getGreen() + "-" + c.getBlue() + ":");//保存RGB值,以"0-0-0:"到"255-255-255:"的格式保存
                            }
                            java.awt.Color c = new java.awt.Color(bi.getRGB(w - 1, y));//获取像素RGB值
                            asd.print(c.getRed() + "-" + c.getGreen() + "-" + c.getBlue());//保存该行最后一个像素的RGB值,以"0-0-0"到"255-255-255"的格式保存
                            asd.println();
                        }
                        asd.flush();
                        fw.flush();
                        asd.close();
                        fw.close();
                        break;
                    case "读取图片文件(txt)":
                        String l;
                        java.util.ArrayList<String[]> al = new java.util.ArrayList<>();
                        f = SomeTools.fileChooser(new String[][]{{".txt", "? (.txt)"}});//选择文件
                        if (f == null) {//如果没有选择文件,则返回
                            System.out.println("\033[46m没有选择文件\033[m");
                            continue;
                        }
                        name = f.getName();//获取文件名
                        java.io.BufferedReader read = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(f), "UTF-8"));//读取文件
                        for (int i = 0; (l = read.readLine()) != null; i++) {//逐行读取
                            al.add(l.split(":"));//以":"为分隔符将该行拆分,拆分后每个元素为"0-0-0"到"255-255-255"
                        }
                        h = al.size();//获取高度
                        w = al.get(0).length;//获取宽度
                        String[] c;
                        bi = new java.awt.image.BufferedImage(w, h, java.awt.image.BufferedImage.TYPE_INT_RGB);
                        for (int y = 0; y < h; y++) {//逐行循环
                            for (int x = 0; x < w; x++) {//每行逐个循环
                                c = al.get(y)[x].split("-");//将"0-0-0"到"255-255-255"的字符拆成["0","0","0"]到["255","255","255"]的数组
                                java.awt.Color co = new java.awt.Color(Short.parseShort(c[0]), Short.parseShort(c[1]), Short.parseShort(c[2]));//将["0","0","0"]到["255","255","255"]的数组变成颜色
                                bi.setRGB(x, y, co.getRGB());//将bi(BufferedImage)对应的像素的颜色改为读取的颜色
                            }
                        }
                        System.out.println("\033[46m读取成功\033[m");
                        break;
                    case "保存图片文件(jpg)":
                        if (bi == null) {//如果没有读取图片,则返回
                            System.out.println("\033[46m没有读取图片\033[m");
                            continue;
                        }
                        f = SomeTools.fileChooser();//选择文件夹
                        if (f == null) {//如果没有选择文件夹,则返回
                            System.out.println("\033[46m没有选择文件夹\033[m");
                            continue;
                        }
                        f = new java.io.File(f.getPath() + "//" + name.substring(0, name.length() - 3) + "jpg");
                        if (f.exists()) {//如果该文件夹有同名文件,则返回
                            System.out.println("\033[46m该文件夹已存在同名文件\033[m");
                            continue;
                        }
                        javax.imageio.ImageIO.write(bi, "jpg", f);//保存文件
                        System.out.println("\033[46m保存成功\033[m");
                        break;
                    case "显示读取图片":
                        if (bi == null) {//如果没有读取图片,则返回
                            System.out.println("\033[46m没有读取图片\033[m");
                            continue;
                        }
                        jf = new javax.swing.JFrame();//新窗口
                        jf.setTitle("显示读取图片");//标题
                        jf.setSize(640 + 16, 480 + 38);//窗口大小
                        jf.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
                        jf.setLocationRelativeTo(null);//设置居中
                        jf.setResizable(true);//设置窗口可拉伸改变大小
                        jf.setBackground(null);//窗口背景
                        jf.setLayout(null);//窗口布局
                        jp = new javax.swing.JPanel();//新画板
                        jp.setBounds(0, 0, 7680, 4320);//设置画板大小
                        jf.add(jp);//将画板加入窗口
                        jf.addWindowListener(new java.awt.event.WindowAdapter() {
                            @Override
                            public void windowClosing(java.awt.event.WindowEvent arg0) {//当关闭窗口时执行
                                synchronized (lock) {//线程锁
                                    jf.setVisible(false);//设置窗口不可视
                                    lock.notify();
                                }
                            }
                        });
                        jf.addKeyListener(new java.awt.event.KeyListener() {
                            @Override
                            public void keyPressed(java.awt.event.KeyEvent e) {
                                int keyCode = e.getKeyCode();
                                switch (keyCode) {
                                    /*case java.awt.event.KeyEvent.VK_DOWN:
                                    break;
                                    case java.awt.event.KeyEvent.VK_LEFT:
                                    break;
                                    case java.awt.event.KeyEvent.VK_RIGHT:
                                    break;
                                    case java.awt.event.KeyEvent.VK_UP:
                                    break;*/
                                    case java.awt.event.KeyEvent.VK_R:
                                        display_memory++;
                                        if (display_memory > 3) {
                                            display_memory = 0;
                                        }
                                        break;
                                }
                            }

                            @Override
                            public void keyTyped(java.awt.event.KeyEvent e) {
                            }

                            @Override
                            public void keyReleased(java.awt.event.KeyEvent e) {
                            }
                        });
                        jf.setVisible(true);//设置窗口可视
                        while (jf.isVisible()) {//当窗口可视时循环执行
                            paint();//画图
                            Thread.sleep(100);//线程休眠100ms
                        }
                        break;
                    case "exit":
                        System.exit(0);//退出程序
                        break;
                }
            }
        } catch (InterruptedException | java.io.IOException ex) {
        }
    }

    private void paint() {
        java.awt.Graphics g = jp.getGraphics();
        int w = bi.getHeight();
        int h = bi.getHeight();
        int ww = jf.getWidth() - 16;
        int hh = jf.getHeight() - 38;
        switch (display_memory) {
            case 0:
                g.drawImage(bi, 0, 0, ww, hh, jp);
                break;
            case 1:
                if (w < ww) {
                    if (h < hh) {
                        g.drawImage(bi, (ww - w) / 2, (hh - h) / 2, w, h, jp);
                    } else {
                        g.drawImage(bi, (ww - w / h * hh) / 2, 0, w / h * hh, hh, jp);
                    }
                } else {
                    if (h < hh) {
                        g.drawImage(bi, 0, (hh - h / w * ww) / 2, ww, h / w * ww, jp);
                    } else {
                        if (w / h > ww / hh) {
                            g.drawImage(bi, 0, (hh - h / w * ww) / 2, ww, h / w * ww, jp);
                        } else {
                            g.drawImage(bi, (ww - w / h * hh) / 2, 0, w / h * hh, hh, jp);
                        }
                    }
                }
                break;
            case 2:
                if (w / h > ww / hh) {
                    g.drawImage(bi, 0, (hh - h / w * ww) / 2, ww, h / w * ww, jp);
                } else {
                    g.drawImage(bi, (ww - w / h * hh) / 2, 0, w / h * hh, hh, jp);
                }
                break;
        }
        g.dispose();
    }
}
