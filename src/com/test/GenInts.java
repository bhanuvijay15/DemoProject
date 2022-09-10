package com.test;

import java.util.*;

public class GenInts {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter any word ....... ");
        String val = input.nextLine().replaceAll("\\s", "");

        System.out.println("Enter the value = " + val + " decode val = " + decode(val));
        //for (String string : decode(val)) {
        //System.out.println(string);
        //}

    }

    private static int decode(String in) {
        char curChar = 'a';
        Map<Character, Integer> charToNum = new LinkedHashMap<>();
        for (int i = 1; i <= 26; i++) {
            charToNum.put(curChar, i);
            curChar++;
        }
        //return decodeHelper(charToNum, in, 0, new ArrayList<Character>());
        int count = 0;
        char ch[] = in.toCharArray();
        for (char c : ch) {
            if (charToNum.containsKey(c)) {
                count += charToNum.get(c);
            }
        }
        System.out.println("Count = " + count);
        return count;
    }

    /*private static Set<String> decodeHelper(
            Map<Integer, Character> numberToChar, String in, int charAt,
            ArrayList<Character> arrayList) {
        Set<String> result = new HashSet<String>();
        if (charAt >= in.length()) {
            String str = "";
            for (char c : arrayList) {
                str += c;
            }
            result.add(str);
            return result;
        } else {
            int charCode = Integer.valueOf(in.charAt(charAt) + "");
            if (charCode == 0) {
                int precCharCode = Integer.valueOf(in.charAt(charAt - 1) + "");
                if (precCharCode == 1)
                    charCode = 10;
                if (precCharCode == 2)
                    charCode = 20;
            }
            char curChar = numberToChar.get(charCode);
            arrayList.add(curChar);
            result.addAll(decodeHelper(numberToChar, in, charAt + 1, arrayList));
            arrayList.remove(arrayList.size() - 1);
            if (in.length() > charAt + 1) {
                charCode = Integer.valueOf(in.substring(charAt, charAt + 2));
                if (charCode <= 26) {
                    curChar = numberToChar.get(charCode);
                    arrayList.add(curChar);
                    result.addAll(decodeHelper(numberToChar, in, charAt + 2,
                            arrayList));
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return result;
    } */
}
