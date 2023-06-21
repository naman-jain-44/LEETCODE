//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return recurse(s,t,s.length()-1,t.length()-1,dp);
        
    }
    public int recurse(String s,String t , int i , int j,int[][] dp){
        if(i<0 && j<0){
            return 0;
        }else if(i<0 && j>=0){
            return j+1;
        }else if(j<0 &&i>=0){
            return i+1;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int ans =Integer.MAX_VALUE;
        if(s.charAt(i)==t.charAt(j)){
            ans = recurse(s,t,i-1,j-1,dp);
        }else{
            ans =1+Math.min(recurse(s,t,i-1,j,dp),Math.min(recurse(s,t,i,j-1,dp),recurse(s,t,i-1,j-1,dp)));
        }
        
        return dp[i][j]=ans;
        
    }
}