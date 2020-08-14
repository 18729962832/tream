package FileReader;

import java.io.FileWriter;

/**
 * description:字符输出流
 * date:2020/8/14
 * fileName:Test02.java
 * Author:yangrun
 */
public class Test02 {
    public static void main(String[] args) throws Exception{
        FileWriter fw = new FileWriter("5.txt");
        //写入字符串
        fw.append("你好，");
        //刷新
        fw.flush();
        //写入字符
        char[] chars = {'世','界','我','爱','你'};
        fw.write(chars);
        fw.flush();
        //关闭流
        fw.close();
    }
}
