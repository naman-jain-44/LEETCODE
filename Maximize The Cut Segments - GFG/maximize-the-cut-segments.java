//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int[] cut =new int[]{x,y,z};
       Arrays.sort(cut);
       
       int[] dp = new int[n+1];
       Arrays.fill(dp,-1);
       if(recurse(cut , n,dp)==Integer.MIN_VALUE){
           return 0;
       }
       
       return dp[n];
       
    }
    
    public int recurse(int[] cut , int length,int[] dp){
        
        if(length==0){
            return 0;
            
        }
        if(length<0){
            return Integer.MIN_VALUE;
        }
        if(dp[length]!=-1){
            return dp[length];
        }
        int ans =Integer.MIN_VALUE;
        for(int i =0;i<cut.length;i++){
            if(length>=cut[i]){
                int u =recurse(cut,length-cut[i],dp);
                if(u!=Integer.MIN_VALUE){
                     ans=Math.max(u+1,ans);
                }
               
            }else{
                break;
            }
            
        }
        
        return dp[length]=ans;
    }
}
