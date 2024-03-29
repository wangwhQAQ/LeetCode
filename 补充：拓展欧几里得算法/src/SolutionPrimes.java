import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.RandomAccessFile;
import java.util.*;

class SolutionPrimes {
    static int x = -1;
    static int y = -1;

    //辗转相除法取最大公因数
    public int countPrimes(int a, int b) {
        return b == 0 ? a:countPrimes(b,a%b);
    }

    //a*b 除以最大公因数就是最大公倍数
    public int lcm(int a , int b){
        return a*b/countPrimes(a,b);
    }

    //拓展欧几里得算法
    public int xGCD(int a , int b , int x , int y){
        if (b == 0){
            x = 1;
            y = 0;
            return a;
        }else {
            int p = xGCD(b , a%b , x , y);
            int temp = x;
            x = y;
            y = temp - a/b*y;
            return p;
        }
    }

    class test{
        SortedSet set = new TreeSet();

        Deque<Integer> deque = new LinkedList<>();

        Map<String, String> hashMap = new HashMap<>();

        Map<String, String> linkedHashMap = new LinkedHashMap<>();

        Deque<Integer> deque1 = new ArrayDeque<>();

//        RandomAccessFile randomAccessFile = new RandomAccessFile("text.txt", );
//        BufferedReader bufferedReader = new BufferedReader();
//        BufferedInputStream bufferedInputStream = new BufferedInputStream();
    }
}