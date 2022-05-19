/*
Time Complexity: O(N³)
Space Complexity: 2 * O(N)
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        /* Sort the array to help us avoid repeats when adding to our List & Set:
            For Example:
                0, 1, 1 and 1, 0, 1 would both be added to our set and list.
                If we sort the array however.
                    Only 0, 1, 1 would be added to our List & Set. */
        Arrays.sort(nums);
        
        List<List<Integer>> returnList = new ArrayList<>();

        /* Set needed so we don't have repeats */
        Set<List<Integer>> seen = new HashSet<>();
        
        int target = 0;
        
        /* First Loop: Get the first number */
        for(int i = 0; i < nums.length-2; i++){

            /* Second Loop: Get the second number */
            for(int j = i+1; j < nums.length-1; j++){

                /* Third Loop: Get the third number */
                for (int k = j+1; k < nums.length; k++){

                    /* Make sure we aren't re-using a number */
                    if(i != k && i != j && k != j){

                        /* Check to see if they add up to 0 */
                        if( nums[k] + nums[j] == -(nums[i])){

                            /* Check if we've already seen this combo */
                            if(!(seen.contains(Arrays.asList(nums[i], nums[j], nums[k]))))
                            {
                               returnList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                               seen.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            }
                        }
                    }
                }
            }
        }
      return returnList;  
    }
}

