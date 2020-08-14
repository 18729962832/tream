package FileInputStream;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description:将文件存入集合
 * date:2020/8/14
 * fileName:Test03.java
 * Author:yangrun
 */
public class Test03 {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new LinkedHashMap<>();
        FileInputStream fis = new FileInputStream("4.txt");
        byte[] bytes = new byte[1024];
        int count = fis.read(bytes);
        String str = new String(bytes, 0, count);
        String[] line = str.split("\r\n");
        for (String k : line) {
            String[] s = k.split(",");
            for (int i = 0; i < s.length; i++) {
                map.put(s[i].split("=")[0], s[i].split("=")[1]);
            }
        }
        System.out.println(map);
    }
}
