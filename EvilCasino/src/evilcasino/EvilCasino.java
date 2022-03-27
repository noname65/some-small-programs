package evilcasino;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
public class EvilCasino extends JFrame{
    public static void main(String[] args) {
        new EvilCasino();
    }
    public EvilCasino(){
        window=new JFrame("Evil Casino");
        window.setLocation(600, 600);//设置窗口x y坐标
        window.setSize(600, 300);//设置窗口大小
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭程序就停止
        window.setResizable(false);//设置窗口不可移动
        window.setLocationRelativeTo(null);//设置居中
        window.setResizable(false);//设置窗口不可拉伸改变大小
        jButton1 = new JButton("Start");
        jButton2 = new JButton("Automatically select.csv files from your desktop");
        jButton3 = new JButton("Manually select the.csv file");
        jButton4 = new JButton("Initializes the.csv file");
        jButton5 = new JButton("Put");
        jLabel1 = new JLabel("A single investment of money:");
        jTextField1 = new JTextField("0");
        jTextField2 = new JTextField("0");
        jLabel2 = new JLabel("The slot machine has ");
        jLabel3 = new JLabel("0");
        jLabel4 = new JLabel("Random results:");
        jLabel5 = new JLabel("none");
        jLabel6 = new JLabel("");
        jLabel7 = new JLabel("");
        jLabel8 = new JLabel("You still have ");
        jLabel9 = new JLabel("0");
        jLabel10 = new JLabel("Put more money in");
        jButton1.setBounds(0, 232, 70, 30);
        jButton2.setBounds(204, 202, 380, 30);
        jButton3.setBounds(384, 232, 200, 30);
        jButton4.setBounds(204, 232, 180, 30);
        jButton5.setBounds(404, 152, 180, 30);
        jLabel1.setBounds(0, 0, 170, 30);
        jTextField1.setBounds(170, 5, 200, 20);
        jTextField2.setBounds(404, 132, 180, 20);
        jLabel2.setBounds(0, 30, 130, 30);
        jLabel3.setBounds(130, 30, 200, 30);
        jLabel8.setBounds(0, 60, 80, 30);
        jLabel9.setBounds(80, 60, 100, 30);
        jLabel4.setBounds(0, 90, 100, 30);
        jLabel5.setBounds(100, 90, 100, 30);
        jLabel6.setBounds(0, 150, 600, 30);
        jLabel7.setBounds(0, 120, 600, 30);
        jLabel10.setBounds(404, 112, 180, 20);
        window.add(jButton1);
        window.add(jButton2);
        window.add(jButton3);
        window.add(jButton4);
        window.add(jButton5);
        window.add(jLabel1);
        window.add(jTextField1);
        window.add(jTextField2);
        window.add(jLabel2);
        window.add(jLabel3);
        window.add(jLabel8);
        window.add(jLabel9);
        window.add(jLabel4);
        window.add(jLabel5);
        window.add(jLabel6);
        window.add(jLabel7);
        window.add(jLabel10);
        jLabel_5 = new JLabel("");
        jLabel_5.setBounds(0, 0, 1, 1);
        window.add(jLabel_5);
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(EvilCasino.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButton4ActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(EvilCasino.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButton5ActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(EvilCasino.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        window2=new JFrame("Sweeten the pot");
        window2.setLocation(600, 600);//设置窗口x y坐标
        window2.setSize(300, 188+60);//设置窗口大小
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭程序就停止
        window2.setResizable(false);//设置窗口不可移动
        window2.setLocationRelativeTo(null);//设置居中
        window2.setResizable(false);//设置窗口不可拉伸改变大小
        jButton_1 = new JButton("Filling double");
        jButton_2 = new JButton("Three times as much as filling");
        jButton_3 = new JButton("Not filling");
        jLabel_1 = new JLabel("Random results:");
        jLabel_2 = new JLabel("none");
        jLabel_3 = new JLabel("");
        jLabel_4 = new JLabel("");
        jButton_1.setBounds(0, 0+60, 284,50);
        jButton_2.setBounds(0, 50+60, 284, 50);
        jButton_3.setBounds(0, 100+60, 284, 50);
        jLabel_1.setBounds(0, 0, 100, 20);
        jLabel_2.setBounds(100, 0, 100, 20);
        jLabel_3.setBounds(0, 20, 200, 20);
        jLabel_4.setBounds(0, 40, 200, 20);
        window2.add(jButton_1);
        window2.add(jButton_2);
        window2.add(jButton_3);
        window2.add(jLabel_1);
        window2.add(jLabel_2);
        window2.add(jLabel_3);
        window2.add(jLabel_4);
        window2.add(jLabel_5);
        jButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_1ActionPerformed(evt);
            }
        });
        jButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_2ActionPerformed(evt);
            }
        });
        jButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_3ActionPerformed(evt);
            }
        });
        window.setVisible(true);
        window2.setVisible(false);
    }
    private void jButton1ActionPerformed(ActionEvent e) throws Exception{
        String[] number={"0","1","2","3","4","5","6","7","8","9"};
        String TextField;
        if(asd==null){
            prompt("Please select file");
            throw new Exception("You didn't choose the file");
        }else if(!asd.exists()){
            prompt("The file you selected does not exist. Please reselect it");
            throw new Exception("The file you selected does not exist");
        }
        if(jTextField1.getText()!=null){
            TextField=jTextField1.getText();
            boolean k=true;
            for(int i1=0;i1<TextField.length();i1++){
                k=true;
                for(int i2=0;i2<10;i2++){
                    if(TextField.substring(i1,i1+1) == null ? number[i2] == null : TextField.substring(i1,i1+1).equals(number[i2])){
                        k=false;
                    }
                }
                if(k){
                    prompt("Please enter Numbers");
                    throw new Exception("You didn't enter a number");
                }
            }
        }else{
            prompt("Please enter Numbers");
            throw new Exception("You didn't enter a number");
        }
        stakes=Integer.parseInt(jTextField1.getText());
        if(CSVRead()[0]<=0){
            text2="The casino is closed";
            Refresh_the_text();
            throw new Exception("The casino is closed");
        }
        if(CSVRead()[1]<=0){
            text2="Please put in more money";
            Refresh_the_text();
            throw new Exception("Please put in more money");
        }
        if(stakes>CSVRead()[1]){
            prompt("You put in more money than you have");
            throw new Exception("You put in more money than you have");
        }else if(stakes==0){
            prompt("Do not enter 0");
            throw new Exception("Do not enter 0");
        }
        Start();
    }
    private void Start() throws Exception{
        if(asd==null){
            prompt("Please select file");
            throw new Exception("You didn't choose the file");
        }else if(!asd.exists()){
            prompt("The file you selected does not exist. Please reselect it");
            throw new Exception("The file you selected does not exist");
        }
        User_residual=CSVRead()[1];
        Slot_machine_surplus=CSVRead()[0];
        if(Slot_machine_surplus<=0){
            text2="The casino is closed";
            Refresh_the_text();
            throw new Exception("The casino is closed");
        }
        if(User_residual<=0){
            text2="Please put in more money";
            Refresh_the_text();
            throw new Exception("Please put in more money");
        }
        Random_results[0]=10;
        Random_results[1]=10;
        Random_results[2]=10;
        for(int ii=0;ii<10;ii++){
            Random_results[0]=(int)Math.ceil(Math.random()*10);
            jLabel5.setText("|"+text1[Random_results[0]]+"|"+text1[Random_results[1]]+"|"+text1[Random_results[2]]+"|");
            jLabel_2.setText("|"+text1[Random_results[0]]+"|"+text1[Random_results[1]]+"|"+text1[Random_results[2]]+"|");
        }
        for(int ii=0;ii<10;ii++){
            Random_results[1]=(int)Math.ceil(Math.random()*10);
            jLabel5.setText("|"+text1[Random_results[0]]+"|"+text1[Random_results[1]]+"|"+text1[Random_results[2]]+"|");
            jLabel_2.setText("|"+text1[Random_results[0]]+"|"+text1[Random_results[1]]+"|"+text1[Random_results[2]]+"|");
            if(Random_results[0]==Random_results[1]||Random_results[1]==Random_results[2]||Random_results[0]==Random_results[2]){
                text2="Do you want to add?";
                window2.setVisible(true);
                window.setVisible(false);
            }
        }
        for(int ii=0;ii<10;ii++){
            Random_results[2]=(int)Math.ceil(Math.random()*10);
            jLabel5.setText("|"+text1[Random_results[0]]+"|"+text1[Random_results[1]]+"|"+text1[Random_results[2]]+"|");
            jLabel_2.setText("|"+text1[Random_results[0]]+"|"+text1[Random_results[1]]+"|"+text1[Random_results[2]]+"|");
        }
        int multiple=2;
        User_residual-=stakes;
        Slot_machine_surplus+=stakes;
        if(Random_results[0]==Random_results[1] && Random_results[1]==Random_results[2]){
            if(Random_results[0]==3){
                multiple=3;
            }
            User_residual+=stakes*multiple;
            Slot_machine_surplus-=stakes*multiple;
            text2="You hit the jackpot and won "+(stakes*(multiple-1));
        }else if(Random_results[0]==Random_results[1]||Random_results[1]==Random_results[2]||Random_results[0]==Random_results[2]){
            text2="Do you want to add?";
            window2.setVisible(true);
            window.setVisible(false);
        }else{
            text2="You you lost "+(stakes);
        }
        Save();
        if(Slot_machine_surplus<=0){
            text2="The casino is closed. Good luck. Bye";
        }
        Refresh_the_text();
    }
    private void jButton_1ActionPerformed(ActionEvent e) {
        if(stakes*2<CSVRead()[1]){
            stakes*=2;
        }else{
            stakes=CSVRead()[1];
        }
        window2.setVisible(false);
        window.setVisible(true);
        try {
            Start();
        } catch (Exception ex) {
            Logger.getLogger(EvilCasino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton_2ActionPerformed(ActionEvent e) {
        if(stakes*4<CSVRead()[1]){
            stakes*=4;
        }else{
            stakes=CSVRead()[1];
        }
        window2.setVisible(false);
        window.setVisible(true);
        try {
            Start();
        } catch (Exception ex) {
            Logger.getLogger(EvilCasino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton_3ActionPerformed(ActionEvent e) {
        text2="Cancel the filling";
        Refresh_the_text();
        window2.setVisible(false);
        window.setVisible(true);
    }
    private void jButton2ActionPerformed(ActionEvent e) {
        asd = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"desktop"+System.getProperty("file.separator")+"bank-book.csv");
        if(asd.exists()){
            prompt("The.csv file was successfully found");
            try {
                if(new Scanner(asd).hasNext()){
                    Refresh_the_text();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EvilCasino.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            prompt("The.csv file was not found");
            asd=null;
        }
    }
    private void CSVWrite(int i1,int i2){
        if(asd!=null){
        try{
            PrintWriter x = new PrintWriter(asd);
            x.println(i1);
            x.println(i2);
            x.close();
            prompt("The.csv file was successfully written");
        } catch(IOException e){
            prompt("Unable to write.csv file");
        }}else{
            prompt("Unable to write.csv file");
        }
    }
    private int[] CSVRead(){
        int[] i={999999999,999999999};
        Scanner a=new Scanner(System.in);
        Scanner b=a;
        try {
            a=new Scanner(asd);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EvilCasino.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(a!=b){
            for(int t=0;a.hasNext();t++){
                i[t]=a.nextInt();
            }
        }
        return i;
    }
    private void jButton3ActionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setAcceptAllFileFilterUsed(false);
        final String[][] fileENames = { { ".csv", "逗号分隔符CSV文档 (.csv)" }};
        fileChooser.addChoosableFileFilter(new FileFilter() {
            public boolean accept(File file) {
            return true;
            }
            public String getDescription() {
                return "所有文件(*.*)";
            }
        });
        for (final String[] fileEName : fileENames) {
            fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File file) { 
                    if (file.getName().endsWith(fileEName[0]) || file.isDirectory()) {
                        return true;
                    }
                    return false;
                }
                public String getDescription() {
                    return fileEName[1];
                }
            });
        }
        fileChooser.showDialog(null, null);
        asd=fileChooser.getSelectedFile();
        try {
            if(asd!=null&&asd.exists()&&new Scanner(asd).hasNext()){
                Refresh_the_text();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EvilCasino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton4ActionPerformed(ActionEvent e) throws Exception{
        if(asd==null){
            prompt("Please select file");
            throw new Exception("You didn't choose the file");
        }else if(!asd.exists()){
            prompt("The file you selected does not exist. Please reselect it");
            throw new Exception("The file you selected does not exist");
        }else{
            CSVWrite(100000,100000);
            User_residual=CSVRead()[1];
            Slot_machine_surplus=CSVRead()[0];
            Refresh_the_text();
        }
    }
    private void jButton5ActionPerformed(ActionEvent e) throws Exception{
        String[] number={"0","1","2","3","4","5","6","7","8","9"};
        String TextField;
        if(jTextField2.getText()!=null){
            TextField=jTextField2.getText();
            boolean k=true;
            for(int i1=0;i1<TextField.length();i1++){
                k=true;
                for(int i2=0;i2<10;i2++){
                    if(TextField.substring(i1,i1+1) == null ? number[i2] == null : TextField.substring(i1,i1+1).equals(number[i2])){
                        k=false;
                    }
                }
                if(k){
                    prompt("Please enter Numbers");
                    throw new Exception("You didn't enter a number");
                }
            }
        }else{
            prompt("Please enter Numbers");
            throw new Exception("You didn't enter a number");
        }
        User_residual+=Integer.parseInt(jTextField2.getText());
        Save();
        Refresh_the_text();
    }
    public void Save(){
        CSVWrite(Slot_machine_surplus,User_residual);
    }
    public void Refresh_the_text(){
        jLabel3.setText(""+CSVRead()[0]);
        jLabel9.setText(""+CSVRead()[1]);
        jLabel5.setText("|"+text1[Random_results[0]]+"|"+text1[Random_results[1]]+"|"+text1[Random_results[2]]+"|");
        jLabel_2.setText("|"+text1[Random_results[0]]+"|"+text1[Random_results[1]]+"|"+text1[Random_results[2]]+"|");
        jLabel7.setText(text2);
        jLabel_4.setText(text2);
    }
    public void prompt(String text){
        jLabel_4.setText(text);
        jLabel6.setText(text);
    }
    public transient volatile int stakes;
    public transient volatile int User_residual;
    public transient volatile int Slot_machine_surplus;
    public transient volatile int[] Random_results={10,10,10};
    public transient volatile String[] text1={"☺","❤","7","3","☹","♦","❃","©","✓","$",null};
    public transient volatile String text2;
    public transient volatile File asd=null;
    public transient volatile JButton jButton1;
    public transient volatile JButton jButton2;
    public transient volatile JButton jButton3;
    public transient volatile JButton jButton4;
    public transient volatile JButton jButton5;
    public transient volatile JLabel jLabel1;
    public transient volatile JTextField jTextField1;
    public transient volatile JTextField jTextField2;
    public transient volatile JLabel jLabel2;
    public transient volatile JLabel jLabel3;
    public transient volatile JLabel jLabel4;
    public transient volatile JLabel jLabel5;
    public transient volatile JLabel jLabel6;
    public transient volatile JLabel jLabel7;
    public transient volatile JLabel jLabel8;
    public transient volatile JLabel jLabel9;
    public transient volatile JLabel jLabel10;
    public transient volatile JButton jButton_1;
    public transient volatile JButton jButton_2;
    public transient volatile JButton jButton_3;
    public transient volatile JLabel jLabel_1;
    public transient volatile JLabel jLabel_2;
    public transient volatile JLabel jLabel_3;
    public transient volatile JLabel jLabel_4;
    public transient volatile JLabel jLabel_5;
    public transient volatile JFrame window;
    public transient volatile JFrame window2;
}
