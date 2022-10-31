import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> letterCasePermutation(String s) {
        int len = s.length();
        char[] ss = s.toCharArray();
        List<String> res = new ArrayList<>();
        huffman(ss,0,res);
        System.out.println(res.toString());
        return res;
    }

    public static void huffman(char[] ss, int index, List<String> res){
        if (index == ss.length){
            res.add(String.copyValueOf(ss));
        }
        if (index >= ss.length){
            return;
        }

        char temp = ss[index];

        if (ss[index] > 64  && ss[index] <91){
            huffman(ss,index+1,res);
            ss[index] += 32;
            huffman(ss, index+1, res);
        } else if (ss[index] > 96  && ss[index] <123) {
            huffman(ss,index+1,res);
            ss[index] -= 32;
            huffman(ss, index+1, res);
        }else{
            huffman(ss,index+1,res);
        }

    }


    public static void main(String[] args){
        letterCasePermutation("a1b4");
    }
}