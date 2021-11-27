package com.dong.basic;

import java.util.*;

public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k <= 0 || k > input.length) return new ArrayList<>();
        PriorityQueue<Integer> temp = new PriorityQueue<>(k, Collections.reverseOrder());
        for (Integer i : input) {
            if (temp.size() < k) {
                temp.add(i);
            } else if (temp.peek() > i) {
                temp.remove();
                temp.add(i);
            }
        }
        return new ArrayList<>(temp);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        if (k <= 0 || k > input.length) return new ArrayList<>();
        PriorityQueue<Integer> temp = new PriorityQueue<>(k);
        for (Integer i : input) {
            temp.add(i);
        }
        return new ArrayList<>(temp);
    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        System.out.println(getLeastNumbers.GetLeastNumbers_Solution1(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }
}
