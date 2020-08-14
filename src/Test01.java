import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算出生到现在过了多少天
 */
public class Test01 {
    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的出生日期：格式(1998-1-1)");
        String s=sc.next();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        //把字符串转换为日期
        Date date=df.parse(s);
        //算出生的毫秒数
        long time=date.getTime();
        //当前时间的毫秒数
        long currenttime=System.currentTimeMillis();
        long days=(currenttime-time)/(60*60*24*1000);
        System.out.println("您出生已经"+days+"天了");
    }
}
