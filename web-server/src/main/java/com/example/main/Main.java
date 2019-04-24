package com.example.main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;

        String lineNum = bufferedReader.readLine();
        String[] arr = bufferedReader.readLine().split(" ");
        int[] nums = new int[Integer.parseInt(lineNum)];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            ans += nums[i] * (i + 1);
        }

        System.out.println(ans);
    }
}
