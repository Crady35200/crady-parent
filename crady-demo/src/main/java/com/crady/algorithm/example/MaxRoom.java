package com.crady.algorithm.example;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: Crady
 * date: 2022/7/27 13:48
 * desc: 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],…] (si < ei)，为避免会议冲突，
 * 同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 * 示例 1:
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [[7,10],[2,4]]
 * 输出: 1
 **/
public class MaxRoom {

    public static void main(String[] args) {
//        int [][] array = {{0,30},{5,10},{15,20}};
        int [][] array = {{7,10},{2,4}};
        MaxRoom maxRoom = new MaxRoom();
        System.out.println(maxRoom.getMaxRoom(array));
    }

    public int getMaxRoom(int [][] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int len = array.length;
        int [] start = new int[len];
        int [] end = new int[len];
        for (int i = 0; i < len; i++) {
            start[i] = array[i][0];
            end[i] = array[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0, j=0;
        int rooms = 0;
        while (i < len && j < len) {
            if (start[i] < end[j]) {
                rooms++;
                i++;
            }else {
                rooms--;
                j++;
            }
            rooms = Math.max(rooms,0);
        }
        return rooms;

    }
}
