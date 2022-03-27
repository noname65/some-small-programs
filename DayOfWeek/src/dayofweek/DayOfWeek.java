package dayofweek;

import java.util.Scanner;
public class DayOfWeek {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("What day of the week is today?");
	String dayOfWeekStr=s.nextLine();
        System.out.println("How may days into the future would you like to know the day of the week?");
        int daysLater=s.nextInt();
        int dayOfWeekInt=0;
        switch(dayOfWeekStr){
            case "Sunday":
                dayOfWeekInt=1;
                break;
            case "Monday":
                dayOfWeekInt=2;
                break;
            case "Tuesday":
                dayOfWeekInt=3;
                break;
            case "Wednesday":
                dayOfWeekInt=4;
                break;
            case "Thursday":
                dayOfWeekInt=5;
                break;
            case "Friday":
                dayOfWeekInt=6;
                break;
            case "Saturday":
                dayOfWeekInt=7;
                break;
        }
        dayOfWeekInt+=daysLater;
        for(int i = 0; i <= daysLater+7; i++){
            if(dayOfWeekInt>=8){
                dayOfWeekInt-=7;
            }else{
                break;
            }
        }
        switch(dayOfWeekInt){
            case 1:
                dayOfWeekStr="Sunday";
                break;
            case 2:
                dayOfWeekStr="Monday";
                break;
            case 3:
                dayOfWeekStr="Tuesday";
                break;
            case 4:
                dayOfWeekStr="Wednesday";
                break;
            case 5:
                dayOfWeekStr="Thursday";
                break;
            case 6:
                dayOfWeekStr="Friday";
                break;
            case 7:
                dayOfWeekStr="Saturday";
                break;
        }
        System.out.println(dayOfWeekStr);
    }
    
}
