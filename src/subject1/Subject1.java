package subject1;

public class Subject1 {
    public int[] twoSum(int[] nums, int target) {

        int numMin = Integer.MAX_VALUE;
        int numMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < numMin) {
                numMin = num;
            }

            if (num > numMax) {
                numMax = num;
            }
        }

        int max = target - numMin;
        int min = target - numMax;

        int targetMax = max > numMax ? numMax : max;
        int targetMin = min < numMin ? numMin : min;

        int[] numIndices = new int[targetMax - targetMin + 1];

        for (int i = 0; i <= numIndices.length - 1; i++) {
            numIndices[i] = -1;
        }

        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] >= targetMin && nums[i] <= targetMax) {
                int offset = -targetMin;
                if (numIndices[(target - nums[i]) + offset] != -1) {
                    return new int[] { numIndices[(target - nums[i]) + offset], i };
                } else {
                    numIndices[nums[i] + offset] = i;
                }
            }
        }
        return new int[] { 0, 0 };

//         for(int i = 0; i < nums.length; i++) {
//             for(int j = i + 1; j < nums.length; j++) {
//                 if(nums[i] + nums[j] == target) {
//                     return new int[]{i, j};
//                 }
//             }
//         }

//         return null;
    }
}
