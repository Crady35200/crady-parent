package com.crady.algorithm.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Crady
 * date: 2022/11/5 00:14
 * desc: 有 n 个字符串，将这些字符串分类，两个字符串A和B属于同一类需要满足以下条件：
 * A中交换任意位置的两个字符，最终可以得到B，交换的次数不限。比如：abc与bca就是同一类字符串。
 * 这 n 个字符串可以分成几类?
 *
 * 输入描述:
 * 首先输入一个正整数 n，接下来输入N个字符串，每个字符串长度不超过50。
 *
 * 1<=n<=50
 * 输出描述:
 * 输出一个整数，表示分类的个数。
 *
 * 样例1
 * 输入
 * 4
 * abcd
 * abdc
 * dabc
 * bacd
 * 输出
 * 1
 **/
public class StringType {

    public static void main(String[] args) {
        System.out.println(solution(4,new String[]{"abcd","abdc","eabf","bace"}));
        System.out.println(solution(4,new String[]{"abcd","abdc","dabc","bacd"}));
    }

    public static int solution(int n, String [] strs){
        if(strs == null) {
            return 0;
        }
        int len = strs.length;
        if(len == 1) {
            return 1;
        }
        List<HashMap<Character,Integer>> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            String s = strs[i];
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j=0;j<s.length();j++){
                Character c = s.charAt(j);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            list.add(map);
        }
        List<HashMap<Character, Integer>> tMap = new ArrayList<>();
        for(int i=0;i<len;i++) {
            boolean flag = false;
            HashMap<Character, Integer> m = list.get(i);
            for (int j = 0; j < tMap.size(); j++) {
                boolean im = true;
                HashMap<Character, Integer> ma = tMap.get(j);
                if(ma.size() == m.keySet().size()){
                    Iterator<Character> iterator = ma.keySet().iterator();
                    while (iterator.hasNext()) {
                        Character c = iterator.next();
                        if(m.get(c) != ma.get(c)) {
                            im = false;
                            break;
                        }

                    }
                }else {
                    im = false;
                }
                flag = flag || im;
                if (flag) {
                    break;
                }
            }
            if (!flag || tMap.size() < 1){
                tMap.add(m);
            }
        }
        return tMap.size();
    }
}
