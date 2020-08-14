package FileInputStream;

import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description:将集合的数据存入到文件中
 * date:2020/8/14
 * fileName:Test02.java
 * Author:yangrun
 */
public class Test02 {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("摩卡",30);
        map.put("卡布奇诺",32);
        map.put("拿铁",27);
        FileOutputStream fos=new FileOutputStream("4.txt");
        for(String key:map.keySet()){
            fos.write(key.getBytes());
            fos.write("=".getBytes());
            fos.write(map.get(key).toString().getBytes());
            fos.write("\r\n".getBytes());
        }
        //fos.write(map.toString().getBytes());
        fos.close();
    }
}
