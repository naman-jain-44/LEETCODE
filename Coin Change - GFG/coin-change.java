//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        
        long[] ans =new long[sum+1];
        ans[0]=1L;
        for(int i=0;i<coins.length;i++){
            
            for(int j =1;j<ans.length;j++){
                if(j>=coins[i]){
                    ans[j]=ans[j]+ans[j-coins[i]];
                }
            }
        }
        
        
        return ans[sum];
    }
}