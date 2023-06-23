//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[]= new int[N];
            for(int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> cost = ob.candyStore(candies,N,K);
            System.out.println(cost.get(0)+" "+cost.get(1));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        // code here
        
        Arrays.sort(candies);
        int weneed=0;
        int weget=0;
        while(weget<N){
            weneed++;
            weget=weget+K+1;
        }
        ArrayList<Integer> ans =new ArrayList<>();
        int one=0;
        int sec=0;
        for(int i =0;i<weneed;i++){
            one=one+candies[i];
            sec=sec+candies[N-1-i];
        }
        ans.add(one);
        ans.add(sec);
        return ans;
    }
}