public class Test02 {
    public static void main(String[] args) {

        byte[] bytes={97,98,99,100};
        //将数字转换为ASCII码对应的字符值
        String s2=new String(bytes);
        System.out.println(s2);

        //截取字符串一部分
        String s3 = new String(bytes,0,2);
        System.out.println(s3);

        //判断是否以某个指定字符串开头
        if(s2.startsWith("a")){
            System.out.println("00000000000");
        }

        //判断是否已某个指定字符串结尾
        if (s2.endsWith("d")){
            System.out.println("11111111111");
        }

        //判断字符串是否为空
        if (!s3.isEmpty()){
            System.out.println("22222222222");
        }

        //判断字符串中是否含有小写字符串
        if (s2.contains(s2)){
            System.out.println("33333333333");
        }

        String s4 = "asdfg";
        String s5 = "ASDFG";
        /**
         * 判断字符串中是否有相同的字符串，不区分大小写
         * 注：不区分大小写的前提是两个字符串必须一个字母不差的不区分大小写的相同
        */
        if (s4.equalsIgnoreCase(s5)){
            System.out.println("44444444444");
        }
        //判断字符串是否相同，区分大小写
        String s6 = "aaa";
        String s7 = "aaa";
        if (s6.equals(s7)){
            System.out.println("55555555555");
        }
    }
}









