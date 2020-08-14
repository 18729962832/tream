package FileoutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * description:复制文件
 * date:2020/8/14
 * fileName:FileoutputStream.Test06.java
 * Author:yangrun
 */
public class Test06 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("1.txt");
        FileOutputStream fos = new FileOutputStream("3.txt");
        byte[] bytes = new byte[4];
        int count = 0;
        while((count=fis.read(bytes)) != -1){
            fos.write(bytes,0,count);
        }
        fos.close();
        fis.close();
        System.out.println("复制成功！");

    }
}
