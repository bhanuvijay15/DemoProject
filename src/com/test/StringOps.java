package com.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringOps {
    public static void main(String[] args) {
        String str = "LIRIL";
        StringBuffer sb = new StringBuffer(str);
        System.out.println("Reverse Str = "+sb.reverse().toString().equals(str));
        if(str.equals(sb.reverse().toString())) {
            System.out.println("it's palindrome");
        } else {
            System.out.println("it's not a palindrome");
        }
        String str2 ="sai baba parayanam".replaceAll("\\s","");
        //str2 = str2.replaceAll("\\s+","");
        System.out.println("after removing spacds str2 = "+str2);
        char s[] = str2.toCharArray();
        int size = s.length;
        Map<Character,Integer> lhmap = new LinkedHashMap<>();

        for(char c : s) {
            if (lhmap.containsKey(c)) {
                lhmap.put(c, lhmap.get(c)+1);
            } else {
                //int oldVal = lhmap.get(s[c]);
                lhmap.put(c,1);
            }
        }
        System.out.println("str2 ---> "+lhmap);
        Set<Map.Entry<Character,Integer>> lhmap1 = lhmap.entrySet();
        char maxkey = ' ';
        int maxval = 0;
        for(Map.Entry<Character,Integer> entry : lhmap1) {
            if(entry.getValue() > maxval) {
                maxkey = entry.getKey();
                maxval = entry.getValue();
            }
        }
        System.out.println("maxkey = "+maxkey);
        System.out.println("maxval = "+maxval);
    //Stream usage
    Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
    List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    System.out.println("Reverse Order --->"+reverseSorted); // [ef, d, aBc, 123456]

    Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
    List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
    System.out.println(naturalSorted); //[123456, aBc, d, ef]


        List<Integer> ss = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> result = new ArrayList<Integer>();

        Stream<Integer> stream = ss.parallelStream();

        stream.map(s1 -> {
            synchronized (result) {
                if (result.size() < 10) {
                    result.add(s1);
                }
            }
            return s1;
        }).forEach( e -> {});
        System.out.println("--->Synchronized Map = "+result);

    }
}
