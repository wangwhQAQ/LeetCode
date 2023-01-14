import java.util.*;

class SolutionTest {
    public static void main(String[] args) {
        Integer i = 124;
        Integer j = 124;
        ++i;
//        i ++;
        System.out.println(i);
        System.out.println(j);

        Byte c = 0x4;
        Byte b = 0x2;
        System.out.println(Integer.toBinaryString(b&c));
    }
}