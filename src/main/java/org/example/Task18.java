package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task18 {
    public static void main(String[] args) {
        //String s="cbaebabacd";
        //String p="abc";
       String s = "abab";
//        String p = "cba";
        String p = "ba";
        System.out.println(getArr(s,p));
        System.out.println(getArr1(s,p));
    }

    /**
     * "cbaebabacd" -- "abc" -- [0, 6]
     * "abab" -- "ab" -- [0, 1, 2]
     */

    private static List<Integer> getArr(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> maPp=strToMap(p);

        for (int i = 0; i <s.length()-p.length() ; i++) {
          Map<Character,Integer>mapSub=strToMap(s.substring(i,i+p.length()));
          if (mapSub.equals(maPp))result.add(i);
        }
        return result;
    }
    private static Map<Character,Integer> strToMap(String s){
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            map.merge(s.charAt(i),1,Integer::sum);
        }
        return map;
    }
    private static List<Integer> getArr1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || s == null) {
            return result;
        }

        int[] charCounts = new int[26];
        for (char c : p.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {
            if (charCounts[s.charAt(right++) - 'a']-- >= 1) {
                count--;
            }

            if (count == 0) {
                result.add(left);
            }

            if (right - left == p.length() && charCounts[s.charAt(left++) - 'a']++ >= 0) {
                count++;
            }
        }
        return result;
    }
}
//public class Main {
//    public static void main(String[] args) {
////        String s = "cbaebabacd";
//        String s = "abab";
////        String p = "cba";
//        String p = "ba";
//        System.out.println(getArr(s,p));
//    }
//
//    private static List<Integer> getArr(String s, String p) {
//        List<Integer> result = new ArrayList<>();
//        Map<Character, Integer> mapP = strToMap(p);
//        for (int i = 0; i <= s.length()-p.length() ; i++) {
//            Map<Character, Integer> mapSub = strToMap(s.substring(i, i + p.length()));
//            if (mapSub.equals(mapP)) result.add(i);
//        }
//        return result;
//    }
//
//    private static Map<Character, Integer> strToMap(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            map.merge(s.charAt(i),1,Integer::sum);
//        }
//        return map;
//    }
//}
//
//    /**
//     * "cbaebabacd" -- "abc" -- [0, 6]
//     * "abab" -- "ab" -- [0, 1, 2]
//     */