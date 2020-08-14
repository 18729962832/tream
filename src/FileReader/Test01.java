package FileReader;

import java.io.FileReader;

/**
 * description:将文本内容读取到数组
 * date:2020/8/14
 * fileName:Test01.java
 * Author:yangrun
 */
public class Test01 {
    public static void main(String[] args) throws Exception{
        //读取字符
        FileReader fr = new FileReader("1.txt");
        //读取到数组理面
        char[] chars = new char[3];
        int count = 0;
        while ((count = fr.read(chars)) != -1){
            for (int i = 0; i < chars.length; i++) {
                System.out.println(chars[i]);
            }
        }
    }
}
