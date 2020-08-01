package com.sdu.algorithm.offercode;

public class JZ037 {

    private static int GetNumberOfK(int [] array , int k) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int target = array[mid];
            if (target == k) {
                // 左右两侧找
                int left = mid - 1;
                int cnt = 1;
                while (left >= low) {
                    if (array[left] == k) {
                        cnt += 1;
                        left -= 1;
                    } else if (array[left] < k) {
                        break;
                    }
                }
                int right = mid + 1;
                while (right <= high) {
                    if (array[right] == k) {
                        cnt += 1;
                        right += 1;
                    } else if (array[right] > k) {
                        break;
                    }
                }
                return cnt;
            } else if (target > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(GetNumberOfK(new int[] {2, 2, 4, 6}, 2));
        System.out.println(GetNumberOfK(new int[] {2, 4, 4, 6, 7}, 4));
    }

}
