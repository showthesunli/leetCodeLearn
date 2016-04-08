import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * Created by prototype on 2016/4/8.
 */
public class MoveZero {
    public void moveZeroes(int[] nums) {
        for (int i=0;i<nums.length;i++){
            int j = i+1;
            if (nums[i] == 0){
                while (j<nums.length){
                    if (nums[j] != 0){
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                    j++;
                }
            }
        }

    }

    public static void main(String [] args){

        int []A = new int[]{4,2,4,0,0,3,0,5,1,0};
        new MoveZero().moveZeroes(A);
        System.out.println(Arrays.toString(A));
    }
}
