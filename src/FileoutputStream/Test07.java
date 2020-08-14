package FileoutputStream;

import java.io.FileInputStream;
import java.util.TreeMap;

/**
 * description:统计文件中字母出现的次数
 * date:2020/8/14
 * fileName:FileoutputStream.Test07.java
 * Author:yangrun
 */
public class Test07 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("1.txt");
        byte[] bytes = new byte[4];
        int count = 0;
        StringBuffer str = new StringBuffer();
        while ((count = fis.read(bytes)) != -1){
            str.append(new String(bytes,0,count));
        }
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        for (char c : str.toString().toCharArray()){
            treeMap.put(c,treeMap.containsKey(c)?treeMap.get(c) + 1 : 1);
        }
        System.out.println(treeMap);
    }
}
