import java.util.Scanner;

/**
 * 字母金字塔
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入一个大写字母：");
        char a=sc.next().charAt(0);
        int c=a-65;
        System.out.println("组成的金字塔是：");
        for(int i=0;i<=c;i++) {
            for(int j=c-1-i;j>=0;j--)
            {
                System.out.print(" ");
            }
            for(char k='A';k<=i+'A';k++)
            {
                System.out.print(k);
            }
            for(int m='A'+i-1;m>='A';m--)
            {
                char t=(char)m;
                System.out.print(t);
            }
            System.out.println();
        }

    }
}
