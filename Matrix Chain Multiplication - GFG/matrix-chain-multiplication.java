//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp =new int[N][N];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return recurse(arr,0,N-2,dp);
        
    }
    
    public static int recurse(int[] arr , int i , int j ,int[][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int u =arr[i]*arr[k+1]*arr[j+1]+recurse(arr,i,k,dp)+recurse(arr,k+1,j,dp);
            max=Math.min(max,u);
        }
        
        return dp[i][j]=max;
    }
}