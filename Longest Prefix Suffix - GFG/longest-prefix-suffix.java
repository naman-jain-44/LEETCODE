//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        // code here
        int i=1;
        int len=0;
        int[] dp=new int[s.length()];
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                dp[i]=len;
                i++;
            }else{
                if(len>0){
                    len=dp[len-1];
                }else{
                    i++;
                }
            }
        }
        return dp[s.length()-1];
    }
}