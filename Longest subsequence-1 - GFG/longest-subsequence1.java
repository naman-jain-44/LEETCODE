//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubsequence(N, A));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubsequence(int N, int A[])
    {
        // code here
        int[][] dp = new int[N+3][N+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return recurse(A,N+2,0,dp);
        
    }
    public static int recurse(int[] A , int prev , int curr , int[][] dp){
        if(curr>=A.length){
            return 0;
        }
        if(dp[prev][curr]!=-1){
            return dp[prev][curr];
        }
        //int max =0;
        if(prev==A.length+2 || Math.abs(A[prev]-A[curr])==1){
            return  dp[prev][curr]=Math.max(1+recurse(A,curr,curr+1,dp),recurse(A,prev,curr+1,dp));
        }else{
            return dp[prev][curr]=recurse(A,prev,curr+1,dp);
            
        }
    }
    
}