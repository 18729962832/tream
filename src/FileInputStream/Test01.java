package FileInputStream;

import java.io.FileInputStream;

public class Test01 {
    public static void main(String[] args) throws Exception{
        FileInputStream file=new FileInputStream("1.txt");
        //读取数据,一次一个,是int 型的数据
        System.out.println((char)file.read());
        file.close();
        //读取所有的内容
        FileInputStream file1=new FileInputStream("1.txt");
        int n=0;
        while ((n=file1.read())!=-1){
            System.out.print((char)n);
        }
        file1.close();
    }
}
