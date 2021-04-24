package com.sdu.algorithm.offercode;

public class OR039 {

    private static int majorityElement(int[] nums) {
        Integer major = null;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
            }
            count += num == major ? 1 : -1;
        }
        return major;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

}
