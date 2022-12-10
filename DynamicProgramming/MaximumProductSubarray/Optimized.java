class Solution {
    public int maxProduct(int[] nums) {
        
        int max = nums[0];
        int localMax = nums[0];
        int localMin = nums[0];
        
        /* Iterate through nums */
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            
            /* Is the current number negative? */
            if(num < 0){
                /* Swap localMin & localMax */
                int temp = localMin;
                localMin = localMax;
                localMax = temp;
            }
            
            localMax = Math.max(num, localMax*num);
            max = Math.max(max, localMax);
            
            localMin = Math.min(num, localMin * num);
        }
        
        return max;
    }
}
