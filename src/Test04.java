import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * description:Map集合遍历
 * date:2020/8/13
 * fileName:Test04.java
 * Author:yangrun
 */
public class Test04 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","aaa");
        map.put("2","bbb");
        map.put("3","ccc");
        map.put("4","ddd");

        //第一种遍历方式
        //1.先获取所有的键
        Set<String> key = map.keySet();
        for (String str : key){
            String value = map.get(str);
            System.out.println("获取到的键和值为--->" + str + " : " + value);
        }
        System.out.println("----------------------------------------------");
        //第二种方式
        //获取所有的键值对
        Set<Map.Entry<String,String>> entries = map.entrySet();
        for (Map.Entry<String,String> entry : entries){
            String key1 = entry.getKey();
            String value1 = entry.getValue();
            System.out.println("获取到的键和值为--->" + key1 + " : " + value1);
        }
    }
}
