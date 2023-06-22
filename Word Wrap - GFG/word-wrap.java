//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here 
        //Arrays.sort(nums);
        int[] dp =new int[nums.length+1];
        Arrays.fill(dp,-1);
        return recurse(nums,k,0,dp);
    }
    public int recurse(int[] nums , int k , int idx,int[] dp ){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        
        int ans =Integer.MAX_VALUE;
        int sum=0;
        for(int i =idx;i<nums.length;i++){
            sum+=nums[i];
            if(sum+(i-idx)<=k){
                if(i!=nums.length-1){
                   int u =(k-(sum+i-idx))*(k-(sum+i-idx))+recurse(nums,k,i+1,dp);
                   ans=Math.min(ans,u);

                }else{
                   int u =recurse(nums,k,i+1,dp);
                   ans=Math.min(ans,u);
                }
                
            }else{
                break;
            }
            
        }
        
        return dp[idx]=ans;
    }
}