package dictionary;
public class Dictionary {
    public static void main(String[] args) {
        String a="";
        while(!"I'm done".equals(a.trim().toLowerCase())){
            System.out.println("Enter the word you want to find or enter \"I'm done\" program");
            a=new java.util.Scanner(System.in).nextLine();
            asd(a.trim().toLowerCase());
        }
    }
    public static void asd(String asd){
        String[] word={"a","","they","be","i","you"},information={"art. 一；任一；每一\n[ 复数 A's或a's或As或as 或 Aes或aes ]\n短语\na cappella 无伴奏合唱 ; 阿卡贝拉 ; 走在大街的女子 ; 无伴奏\nA little 一点 ; 一些 ; 一点儿 ; 一点点\nBisphenol A 双酚A ; 双酚 ; 酚甲烷 ; 丙二酚","","pron. 他们；它们；她们\n短语\nWhy they 所以然\nThey Say 他们说 ; 语录 ; 据说\nThey discussed 他们在讨论 ; 他们讨论 ; 他们讨论了","vt. 是； 有，存在； 做，成为； 发生\nn. (Be)人名；(缅)拜；(日)部(姓)；(朝)培；(中非)贝\n短语\nbe lost 迷路 ; 散失 ; 丢失 ; 走失\nbe seated 坐下 ; 位于 ; 坐着 ; 就座\nBe prepared 准备好 ; 年 ; 快准备","pron. 我\nn. 碘元素；字母I\nabbr. 不及物动词 (intransitive verb)\n短语\nI SWEAR 我宣誓 ; 我发誓 ; 誓言 ; 林忆莲\nI know 我知道 ; 我意识到了 ; 水瓶座\nChildebert I 希尔德贝尔特一世","pron. 你；你们\nn. (You)人名；(柬)尤；(东南亚国家华语)猷\n短语\nYou Know 你知道 ; 你要知道 ; 你了解 ; 我说\nLove you 爱你 ; 醉后决定爱上你 ; 好爱你 ; 爱上你等于爱上寂寞\nYou Higuri 冰栗优"};
        if(java.util.Arrays.binarySearch(word, asd)<=5&&java.util.Arrays.binarySearch(word, asd)>=0){
            System.out.println(information[java.util.Arrays.binarySearch(word, asd)]);
        }
    }
}
