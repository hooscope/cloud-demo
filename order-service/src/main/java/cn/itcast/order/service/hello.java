package cn.itcast.order.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class hello {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("a"));
    }
    public static int lengthOfLongestSubstring1(String s) {
        List<Character> res = new ArrayList<>();
        int a=0,b=0;
        int max=0;
        while(b<s.length()){
            if(!res.contains(s.charAt(b))){
                res.add(s.charAt(b));
                b++;
            }else{
                max= Math.max(res.size(), max);
                a+=1;
                b=a;
                res.clear();
            }
        }
        return Math.max(res.size(), max);
    }

    public static int lengthOfLongestSubstring2(String s) {

        int r = -1;//右指针
        Set<Character> set = new HashSet<>();
        int max=0;
        for(int i=0;i<s.length();i++){
            if(i>0){
                set.remove(s.charAt(i-1));
            }
            while(r+1<s.length()&&!set.contains(s.charAt(r+1))){
                set.add(s.charAt(r+1));
                r++;
            }
            max=Math.max(set.size(), max);
        }

        return max;
    }
}
