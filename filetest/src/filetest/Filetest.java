2package filetest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Filetest {

    private int list1, list_1, list2, list_2, list3, list_3,n1,n2;
    private String asdf;

    public static void main(String[] args) {
        new Filetest();
    }

    Filetest() {
        String path = "D:/Documents/Tencent Files/1169453275/Image/Group2";
        long b = LocalDateTime.parse("2020-03-24 22:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        long c = LocalDateTime.parse("2020-03-25 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        String d = "D:/Documents/Tencent Files/1169453275/Image/out";
        Path qwe = Paths.get(path);
        new Timer("none").start();
        list1 = new File(path).list().length;
        list_1 = 0;
        n1=0;
        n2=0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(qwe)) {
            for (Path e : stream) {
                list2 = e.toFile().list().length;
                list_2 = 0;
                try (DirectoryStream<Path> stream1 = Files.newDirectoryStream(e)) {
                    for (Path e1 : stream1) {
                        list3 = e1.toFile().list().length;
                        list_3 = 0;
                        try (DirectoryStream<Path> stream2 = Files.newDirectoryStream(e1)) {
                            for (Path e2 : stream2) {
                                asdf = e2.toString();
                                File f = e2.toFile();
                                long a = f.lastModified();
                                if (a > b && a < c) {
                                    Files.copy(e2, Paths.get(d + "/" + e2.getFileName()));
                                    n1++;
                                }
                                n2++;
                                list_3++;
                            }
                        } catch (IOException e2) {
                        }
                        list_2++;
                    }
                } catch (IOException e1) {
                }
                list_1++;
            }
        } catch (IOException e) {
        }
    }

    private class Timer implements Runnable {

        private volatile transient Thread t;
        private volatile transient String threadName;

        Timer(String name) {
            threadName = name;
            t = null;
        }

        @Override
        public void run() {
            int time = 0;
            while (true) {
                System.out.println("\n\n\n\n" + asdf + "\n" + list_1 + "/" + list1 + "\n" + list_2 + "/" + list2 + "\n" + list_3 + "/" + list3 +"\n"+n1+"/"+n2+ "\n" + time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Filetest.class.getName()).log(Level.SEVERE, null, ex);
                }
                time++;
                if (list1 == list_1 && list2 == list_2 && list3 == list_3) {
                    System.out.println("\n\n\n\n" + asdf + "\n" + list_1 + "/" + list1 + "\n" + list_2 + "/" + list2 + "\n" + list_3 + "/" + list3 +"\n"+n1+"/"+n2+ "\n" + time);
                    System.exit(0);
                }
            }
        }

        public void start() {
            if (t == null) {
                t = new Thread(this, threadName);
                t.start();
            }
        }
    }
}
