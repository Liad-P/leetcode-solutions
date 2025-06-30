import java.util.Arrays;

// https://leetcode.com/problems/two-sum/
class Question2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        Question2 q = new Question2();
        System.out.println(Arrays.toString(q.twoSum(nums, target)));

        nums = new int[] { 3, 2, 4 };
        target = 6;
        System.out.println(Arrays.toString(q.twoSum(nums, target)));

        nums = new int[] { 3, 3 };
        target = 6;
        System.out.println(Arrays.toString(q.twoSum(nums, target)));
    }
    
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        OuterLoop: for (int i = 0; i < nums.length - 1; i++) {
            InnerLoop: for (int i2 = i + 1; i2 < nums.length; i2++) {
                if (target == (nums[i] + nums[i2])) {
                    result[0] = i;
                    result[1] = i2;
                    break OuterLoop;
                }
            }
        }
        return result;
    }
}