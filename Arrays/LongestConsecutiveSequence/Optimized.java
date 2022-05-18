import java.util.HashSet;


/* Time Complexity: O(N)
 * Space Complexity: O(N) */

public class leetcode
{
	public static void main(String[] args) {
        
        /* HashSet: Search up time is O(1), but space complexity is O(N). */
	    HashSet<Integer> hs = new HashSet<>();
	    
	    /* Variables to keep track of what the longest streak is.  */
        int longestStreak = 0;
        int currentStreak = 0;
        
        /* Add all the variables to the HashSet so we can lookup the values in the array in O(1) */
        for(int n: nums){
            hs.add(n);
        }

        /* Traversing through the array: O(N) Time Complexity */
        for(int n: nums){

            int nextNum = n+1;
            currentStreak = 1;
            
            /* Check to see if the lower number exists, cause if it does we don't want to call this for the higher number.
                For example:
                    For an array such as [5, 6, 4, 3, 2, 1]
                    We would go throug the entire Sequence...
                    But now, when we get to a # like 2, we see that 1 exists
                    The sequence for 2 would be:
                        2 -> 3 -> 4 -> 5 -> 6
                    But we know the sequence for 1 will be:
                        1 -> 2 -> 3 -> 4 -> 5 -> 6
                    So, let's not do anything for 2 because 1 is going to have the same but longer sequence than 2.
            */
            if(!hs.contains(n-1)){

                /* Check if the hashSet contains the next number in the sequence */
                while(hs.contains(nextNum)){
                    nextNum++;
                    currentStreak++;
                }
            }
            
            if(currentStreak > longestStreak)
                longestStreak = currentStreak;
        }
        
        return longestStreak;
	}
}
