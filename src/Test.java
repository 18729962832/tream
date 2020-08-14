
public class Test {

    public static void exc(int a[],int i,int j){

        // 当他们相等的时候就没必要进行交换
        if(a[i] != a[j]){
            a[i] ^= a[j];
            a[j] ^= a[i];
            a[i] ^= a[j];
        }
    }
    /**
     * description:选择排序
     * date:2020/8/13
     * fileName:SelectionSort.java
     * Author:yangrun
     */
    public static int[] selectionSort(int a[]){
        int min;
        for(int i=0;i<a.length;i++){
            min = i;
            // 这个for循环是为了找出最小的值
            for (int j = i+1; j < a.length; j++) {
                if(a[min]>a[j]){
                    min = j;
                }
            }
            /** 如果第一个取出的元素不是最小值，就进行交换
             * 意思就是：如果取出的元素就是最小值，那么就没有必要进行交换了 		   */
            if(min != i){
                // 进行交换
                exc(a, i, min);
            }
        }
        return a;
    }

    /**
     * description:插入排序
     * date:2020/8/13
     * fileName:Test01.java
     * Author:yangrun
     */
    public static int[] insertSort(int a[]) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 如果a[i]比前面的数字小，则a[i]向前挪
            for (int j = i; j >0 && (a[j-1]>a[j]); j--) {
                exc(a, j, j-1);
            }
        }
        return a;
    }

    /**
     * description:冒泡排序
     * date:2020/8/13
     * fileName:Test01.java
     * Author:yangrun
     */
    public static int[] bubbleSort2(int[] a) {
        int N = a.length;
        boolean flag = true;
        for (int i = 0; i < N - 1 && flag; i++) {
            int j = N-1;
            for (flag = false; j > i; j--) {
                if(a[j-1]>a[j]){
                    flag = true;
                    exc(a, j-1, j);
                }
            }
        }
        return a;
    }

    /**
     * description:裗排序（最快排序法）
     * date:2020/8/13
     * fileName:Test01.java
     * Author:yangrun
     */
    public static int[] combSort(int[] a) {
        int N = a.length;
        int step = N;
        int k;
        // 第一部分
        while((step /= 1.3) > 1) {
            for (int i = N-1; i >= step; i--) {
                k = i -step;
                if(a[k]>a[i]){
                    // 交换位置
                    exc(a, k, i);
                }
            }
        }
        // 第二部分：进行冒泡排序
        a= bubbleSort2(a);
        return a;
    }

    /**
     * description:希尔排序
     * date:2020/8/13
     * fileName:Test01.java
     * Author:yangrun
     */
    public static int[] shellSort(int[] a){
        int N = a.length;
        int h = 1;
        // 增量序列
        while(h < N/3){
            // h = 1,4,13,40,……
            h = h*3 + 1;
        }

        while(h>=1){
            for (int i = h; i < N; i++) {
                // 进行插入排序，诺a[j]比a[j-h]小，则向前挪动h
                for (int j = i; j >= h && a[j-h]>a[j]; j -= h) {
                    exc(a, j, j-h);
                }
            }
            h /= 3;
        }
        return a;
    }

    /**
     * description:快速排序
     * date:2020/8/13
     * fileName:Test01.java
     * Author:yangrun
     */
    public static int partition(int[] a,int lo,int h){
        // 选取中间的值为基准值
        int middle = (lo+h+1)/2;
        int v = a[middle];
        // 将基准值和a[lo]交换位置
        exc(a, lo, middle);

        int i = lo;
        int j = h+1;
        while(true){

            // 假如左边的小于基准值，则一直进行循环
            while(a[++i] < v){
                // 防止越界
                if(i == h){
                    break;
                }
            }
            // 假如右边的大于基准值，则一直进行循环
            while(a[--j]>v){
                if(j == lo){
                    break;
                }
            }

            // 一旦i>=j则代表i前面的除第一个外都比基准值小，j后面的都比基准值大，这时候就可以跳出循环了
            if(i>=j){
                break;
            }

            // 进行交换(因为a[lo]>v,a[h]<v，所以将两者进行交换)
            exc(a, i,j);
        }
        // 将基准放到分界点
        exc(a, lo, j);
        return j;
    }

    /**
     * description:堆排序
     * date:2020/8/13
     * fileName:Test01.java
     * Author:yangrun
     * @return
     */
    public static int[] heepSort(int[] a) {
        int N = a.length;

        // 构造一个堆有序
        for (int i = N/2; i >= 0; i--) {
            sink(a, i,N - 1);
        }
        N = N -1;
        // 然后进行下沉排序
        while(N>0){
            exc(a, 0, N--);
            sink(a, 0,N);
        }
        return a;
    }
    public static void sink(int[] a,int k,int N) {
        // 满足向下移动的条件
        while(2*k+1 <= N){
            int j = 2*k + 1;
            // 从 a[j]和a[j+1]中a比较出较大的元素
            if(j < N -1 && a[j+1] > a[j]){
                j ++;
            }
            if(a[j] < a[k]){
                break;
            }
            // 将大的元素移动到上面去
            exc(a, k, j);
            k = j;
        }
    }

    /**
     * description:归并排序
     * date:2020/8/13
     * fileName:Test01.java
     * Author:yangrun
     */
    public static int[] aux;
    public static void merge(int[] a,int lo,int middle,int hi) {
        int i = lo;
        // 第二部分数组归并的开始位置
        int j = middle +1;

        // 将a[lo..hi]的内容复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int z = lo; z <= hi; z++) {

            if(i > middle){
                a[z] = aux[j++];
            }else if(j > hi){
                a[z] = aux[i++];
            }else if(aux[i] > aux[j]){
                a[z] = aux[j++];
            }else{
                a[z] = aux[i++];
            }
        }
    }
    public static int[] mergeSort(int[] a){
        aux = new int[a.length];
        mergeSort(a, 0, a.length-1);
        return a;
    }

    public static void mergeSort(int[] a, int lo, int hi ){
        if(lo >= hi){
            return;
        }
        int middle = (lo + hi)/2;
        // 对左半边进行排序
        mergeSort(a,lo,middle);
        // 对右半边进行排序
        mergeSort(a,middle+1,hi);
        // 进行归并
        merge(a, lo, middle, hi);
    }

    /**
     * description:基数排序
     * date:2020/8/13
     * fileName:Test01.java
     * Author:yangrun
     * @return
     */
    public static int[] radixSort(int[] a){
        int max = a[0];
        for (int value : a) {
            if(max < value){
                max = value;
            }
        }
        // 找出最大位数N
        int N = 0;
        if(max == 0){
            N = 1;
        }else{
            N = (int) (Math.log10(max) + 1);
        }
        // 进行基数排序
        radixSort(a,N);
        return a;
    }
    /**
     * 基数排序
     * @param a
     * @param N 最大位数
     */
    public static void radixSort(int[] a, int N) {

        // 相当于博客中表格的编号
        int radix = 10;
        int length = a.length;
        // 代表1，10,100……
        int factor = 1;

        //之所以将二位数组的高度设置为length是为了防止极端情况【即所有数据的最高位数相同】
        int[][] bucket = new int[radix][length];

        // 记录每一个bucket里面有多少个元素
        int[] order = new int[radix];

        for(int i =0;i<N;i++,factor *= 10){
            // 将数据放入桶中
            for (int v : a) {
                int digit = (v/factor)%10;

                bucket[digit][order[digit]] = v;
                order[digit] ++;
            }

            int position = 0;
            // 将桶中的数据重新连接放入数组中
            for(int j =0;j<radix;j++ ){
                // 假如里面有数据
                if(order[j] != 0){
                    // 将数据放入数组中
                    for (int k = 0; k < order[j]; k++) {
                        a[position++] = bucket[j][k];
                    }
                    // 将计数器置零
                    order[j] = 0;
                }
            }
        }
    }

    /**
     * description:计数排序
     * date:2020/8/13
     * fileName:Test01.java
     * Author:yangrun
     * @return
     */
    public static int[] countSort(int[] a){

        int max = a[0];
        // 找出最大值
        for (int v : a) {
            if(v > max){
                max = v;
            }
        }
        // 辅助数组
        int[] count = new int[max+1];

        // 将数据的个数储存到count数组中
        for (int v : a) {
            count[v] ++;
        }

        int indexArray = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i] > 0){
                a[indexArray++]=i;
                count[i] --;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,49,68,51,25,31,12,10,5,19,15,12};
        int result[] = Test.selectionSort(a);
        System.out.println(result);
        int[] z = Test.insertSort(a);
        System.out.println("z = " + z.toString());
        int[] x = Test.bubbleSort2(a);
        System.out.println("x = " + x);
        int[] c = Test.combSort(a);
        System.out.println("c = " + c);
        int[] v = Test.shellSort(a);
        System.out.println("v = " + v);
        int b = Test.partition(a,1,12);
        System.out.println("b = " + b);
        int[] n = Test.heepSort(a);
        System.out.println("n = " + n);
        int[] m = Test.mergeSort(a);
        System.out.println("m = " + m);
        int[] l = Test.radixSort(a);
        System.out.println("l = " + l);
        int[] k = Test.countSort(a);
        System.out.println("k = " + k);








    }
}
