package FileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * description:将指定路径的文件复制到当前目录下
 * date:2020/8/14
 * fileName:Test04.java
 * Author:yangrun
 */
public class Test04 {
    public static void main(String[] args) throws Exception{
        File file=getFile();
        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos=new FileOutputStream(file.getName());
        byte[] bytes=new byte[10];
        int count=0;
        while((count=fis.read(bytes))!=-1){
            fos.write(bytes,0,count);
        }
        fos.close();
        fis.close();
        System.out.println("复制成功！");
    }

    public static File getFile() {
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.print("请输入一个文件的路径:");
            String path = sc.next();
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("输入路径不存在！");
            } else if (file.isDirectory()) {
                System.out.println("路径必须是文件！");
            } else{
                return file;
            }
        }
    }

}
