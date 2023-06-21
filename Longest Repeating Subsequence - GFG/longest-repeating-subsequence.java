//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        
        int[][] dp=new int[str.length()+1][str.length()+1];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return recurse(str, str , str.length()-1,str.length()-1,dp);
    }
    public int recurse(String s, String t , int i , int j,int[][] dp ){
        if(i<0||j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(i!=j){
            if(s.charAt(i)==s.charAt(j)){
                return dp[i][j]= 1+recurse(s,t,i-1,j-1,dp);
            }else{
                return dp[i][j]=Math.max(recurse(s,t,i-1,j,dp),recurse(s,t,i,j-1,dp));
            }
            
        }else{
            return dp[i][j]=Math.max(recurse(s,t,i-1,j,dp),recurse(s,t,i,j-1,dp));
        }
    }
}