package com.dong.basic;

public class SearchInRepeat {
    public int searchLeft (int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        // 搜索空间为 [0, nums.length)  左闭右开
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 因为左侧区间已经包含了，所有直接取 mid + 1
            if (nums[mid] < target) {
                left = mid + 1;
                // 右侧本身就没有包含，所有要包含mid
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (nums[left - 1] != target) ? -1 : left - 1;
    }

    private int searchRandom(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
