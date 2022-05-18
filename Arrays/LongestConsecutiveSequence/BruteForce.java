import java.util.HashMap;
import java.util.LinkedHashSet;
public class BruteForce
{
	public static void main(String[] args) {
	    
	    int[] nums = {1, 2, 3};
	   
	    boolean nextNumExists = true;
	    
	    HashMap<Integer, LinkedHashSet<Integer>>hm = new HashMap<>();
	    
	    /* Integers to keep track */
        int longestStreak = 0;
        int currentStreak = 0;
        
        for(int n: nums){
            int nextNum = n+1;
            currentStreak = 1;
            
            /* While Loop */
            while(nextNumExists){
                /* Third Loop */
                for(int i = 0; i < nums.length; i++){
                    if(nums[i] == nextNum){
                        nextNum++;
                        currentStreak++;
                    }
                }
                nextNumExists = false;
            }
            
            if(currentStreak > longestStreak)
                longestStreak = currentStreak;
        }
        
        return longestStreak;
	    
	}
}
