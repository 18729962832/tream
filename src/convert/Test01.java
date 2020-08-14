package convert;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * description:转换流
 * date:2020/8/14
 * fileName:Test01.java
 * Author:yangrun
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        //将一个字节输出流转换成字符输出流，方便字节写入字符
        FileOutputStream fos=new FileOutputStream("1.txt");
        //转换流
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        osw.write("你好呀！");
        osw.close();
        fos.close();
    }
}
