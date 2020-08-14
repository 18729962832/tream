package FileoutputStream;

import java.io.FileOutputStream;

/**
 * description:IO流的使用
 * date:2020/8/14
 * fileName:FileoutputStream.Test05.java
 * Author:yangrun
 */
public class Test05 {

    //FileOutPutStream类（文件输出流）
    public static void main(String[] args) throws Exception{
        //如果文件不错在会帮我们自动创建
        FileOutputStream fos = new FileOutputStream("1.txt");
        //输出
        fos.write(98);
        byte[] bytes={97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120};
        fos.write(bytes);
        //关闭流
        fos.close();

        //第二个参数是否续写
        FileOutputStream fos1 = new FileOutputStream("1.txt",true);
        fos1.write(90);
        fos1.close();

        //输出中文
        FileOutputStream fos2 = new FileOutputStream("2.txt");
        fos2.write("你好".getBytes());
        //换行
        fos2.write("\r\n".getBytes());
        fos2.write("隔壁老王".getBytes());
    }
}
