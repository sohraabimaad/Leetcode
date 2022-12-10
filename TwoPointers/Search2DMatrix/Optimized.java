
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        

           if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
                return false;

        int i=0,j=matrix.length-1;  
        
        while(i<j)
        {
            int mid=i+(j-i)/2;
            if(matrix[mid][matrix[0].length-1]==target)
                return true;
            else if(matrix[mid][matrix[0].length-1]<target)
                i=mid+1;
            else 
                j=mid-1;
        }
        while(target>matrix[i][matrix[0].length-1])
        {
            i++;
            if(i<0 || i>=matrix.length)
                return false;
        }
        
        int p=0;j=matrix[0].length-1;
        while(p<=j)
        {
            int mid=(p+j)/2;
            if(matrix[i][mid]==target)
                return true;
            else if(matrix[i][mid]<target)
                p=mid+1;
            else
                j=mid-1;
        }
        
        return false;
    }
}
