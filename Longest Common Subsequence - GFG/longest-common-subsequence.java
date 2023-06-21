//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        
        int[][] dp = new int[x+1][y+1];
        for(int i =0;i<dp.length;i++){
              Arrays.fill(dp[i],-1);
        }
        
        return recurse(s1,s2,x-1,y-1,dp);
    }
    public static int recurse(String s ,String t , int i , int j ,int[][] dp){
        if(i<0 ||j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans =Integer.MIN_VALUE;
        if(s.charAt(i)==t.charAt(j)){
            ans =1+recurse(s,t,i-1,j-1,dp);
            
        }else{
            ans =Math.max(recurse(s,t,i-1,j,dp),recurse(s,t,i,j-1,dp));
        }
        return dp[i][j]=ans;
    }
    
}