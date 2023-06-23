//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public  int palindromicPartition(String str)
    {
        // code here
        int[] dp=new int[str.length()+1];
        Arrays.fill(dp,-1);
        
        return recurse(str,0,dp)-1;
    }
    
    public int recurse(String s , int idx,int[] dp){
        if(idx>=s.length()){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans =Integer.MAX_VALUE;
        for(int i =idx+1;i<=s.length();i++){
            if(ispali(s,idx,i-1)){
                int u =1+recurse(s,i,dp);
                ans=Math.min(u,ans);
            }
        }
        return dp[idx]=ans;
    }
    
    public boolean ispali(String s , int i , int j ){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}