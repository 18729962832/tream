package FileReader;

import cn.hutool.system.SystemUtil;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * description:复制文本文件
 * date:2020/8/14
 * fileName:Test03.java
 * Author:yangrun
 */
public class Test03 {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("5.txt");
        FileWriter fw = new FileWriter("1.txt");
        //提高循环，自定义和缓冲区数组
        char[] chars = new char[1024];
        int len = 0;
        while ((len=fr.read(chars)) != -1){
            fw.write(chars,0,len);
        }
        fw.close();
        fr.close();
        System.out.println("复制完成！");
        System.err.println(SystemUtil.getJvmSpecInfo());
        System.err.println(SystemUtil.getJvmInfo());
        System.err.println(SystemUtil.getJavaSpecInfo());
        System.err.println(SystemUtil.getJavaInfo());

    }
}
