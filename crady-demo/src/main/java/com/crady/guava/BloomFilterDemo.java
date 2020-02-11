package com.crady.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author :Crady
 * date :2019/9/4 15:39
 * desc : 布隆过滤器应用
 **/
public class BloomFilterDemo {
    static int total = 1000000;
    static int n = total + 10000;

    public static void main(String[] args) {
        //设置误差率=0.0003 则理论错误个数：1010000 * (0.0003 / 100) = 3.03
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),total,0.0003);
        init(bf);
        check(bf);

    }
    public static void init(BloomFilter bf){
        for (int i =0;i< total;i++){
            bf.put("" + i);
        }
    }

    public static void check(BloomFilter bf){
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if(bf.mightContain("" + i)){
                 a++;
            }else{
                b++;
            }
        }
        System.out.println("a = " + a + ",b = " + b);
    }

}
