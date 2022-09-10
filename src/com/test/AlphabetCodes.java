package com.test;
import java.util.ArrayList;
import java.util.List;

public class AlphabetCodes {
        /**
         * @param args
         */
        public static void main(String[] args) {

            List<String> codes = findAllCodes("110203");

            System.out.println(codes.size());
            for (String code : codes){
                System.out.println(code);
            }
        }

        private static List<String> findAllCodes(String string) {


            List<String> ret = new ArrayList<String>();
            List<String> preRet = new ArrayList<String>();

            for (int index = 0; index < string.length(); index ++){
                List<String> temp1 = new ArrayList<String>();
                List<String> temp2 = new ArrayList<String>();
                if (index >=  1){
                    int val = Integer.valueOf(string.substring(index - 1, index + 1));
                    if (val <= 26 && val >= 10){
                        char chr = (char)(val + 96);
                        temp1 = addChrToPrefix(preRet, chr);
                    }
                }
                int val = Integer.valueOf(string.substring(index, index + 1));
                if (val != 0){
                    char chr = (char)(val + 96);
                    temp2  = addChrToPrefix(ret, chr);
                }
                preRet = ret;
                temp1.addAll(temp2);
                ret = temp1;
            }
            return ret;
        }



        private static List<String> addChrToPrefix(List<String> preRet, char chr) {

            List<String> ret = new ArrayList<String>();
            if (preRet.size() == 0){
                ret.add(String.valueOf(chr));
            }
            for (String item : preRet){
                ret.add(item + String.valueOf(chr));
            }
            return ret;
        }

    }
