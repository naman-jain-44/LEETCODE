//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int w = sc.nextInt();
                    int cost[] = new int[n];
                    for(int i = 0;i<n;i++)
                        cost[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minimumCost(cost,n,w));
                }
        }
}    
// } Driver Code Ends


class Solution
{
	public int minimumCost(int cost[], int N,int W)
	{
		// Your code goes here
		int[][] dp=new int[N+1][W+1];
		for(int i =0;i<dp.length;i++){
		    Arrays.fill(dp[i],-1);
		}
		int ans =recurse(cost,0,W,dp);
		if(ans==Integer.MAX_VALUE){
		    return -1;
		}
		return ans;
	}
	public int recurse(int[] cost ,int idx , int W,int[][] dp){
	    if(idx>=cost.length){
	        if(W==0){
	            return 0;
	        }
	        return Integer.MAX_VALUE;
	    }
	    if(dp[idx][W]!=-1){
	        return dp[idx][W];
	    }
	    int ans=Integer.MAX_VALUE;
	    int nottake =recurse(cost,idx+1,W,dp);
	    int take =Integer.MAX_VALUE;
	    if(idx+1<=W&&cost[idx]!=-1){
	        int u=recurse(cost,idx,W-(idx+1),dp);
	       if(u!=Integer.MAX_VALUE){
	           take=cost[idx]+u;
	       }
	    }
	    
	    ans =Math.min(nottake,take );
	    
	    return dp[idx][W]=ans;
	}
}