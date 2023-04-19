package org.example;

import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        int[]arr={1, 200, 2, 201, 3, 202, 4, 5,6,15,16,17,17,18,19,20,21};
        int[] nums = {2, 1, 4, 3, 2};
        /**
         * [1 200 2 201 3 202 4 5 6] -- 6
         */
        System.out.println(getLongestSequence(arr));
        }
        private static int getLongestSequence(int[] nums ) {
        int[]array=    Arrays.stream(nums).sorted().toArray();
            System.out.println(Arrays.toString(array));
        int max=1;
        int temp=1;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i+1]-array[i]==1){temp++;
                    System.out.println(temp+"    "+i);
                }else
                if (temp>max){ max=temp;
                    System.out.println(max);
                temp=1;}
            }
        return max;
    }
}
//private static int getLongestSequence(int[] nums) {
//        int[] array = Arrays.stream(nums).sorted().toArray();
//        System.out.println(Arrays.toString(array));
//        int max = 1;
//        int temp = 1;
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] - array[i - 1] == 1) {
//                temp++;
//            } else if (array[i] - array[i - 1] == 0) {
//                continue;
//            }else if (temp > max ) {
//                max = temp;
//                temp = 1;
//            }
//        }
//        return max;
//    }