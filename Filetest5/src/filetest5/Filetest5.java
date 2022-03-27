/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetest5;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Filetest5 {
    static BufferedImage bi;
    static javax.swing.JFrame jf;
    static javax.swing.JPanel jp;
    static final Object lock = new Object();
    static byte display_memory = 1;
    public static void main(String[] args) {
        try {
            String path="D:\\我的世界\\.minecraft\\screenshots/";
            String name="2021-03-10_17.23.25.png";
            String rename="123.png";
            BufferedImage bi1=ImageIO.read(new File(path+name));
            int h=bi1.getHeight(),w=bi1.getWidth();
            System.out.print(h+","+w);
            bi=bi1.getSubimage(w/2-h/3,0,h/3*2,h);
            ImageIO.write(bi,"png",new File(path+rename));
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
                                        if (display_memory >= 3) {
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
        } catch (IOException | InterruptedException ex) {
        }
    }
    private static void paint() {
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
