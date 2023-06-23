//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        
        int max =Integer.MIN_VALUE;
        for(int i =0;i<C;i++){
            int[] arr=new int[R];
            for(int j =i;j<C;j++){
                
                for(int k =0;k<R;k++){
                    arr[k]=arr[k]+M[k][j];
                }
                
                max=Math.max(max,answer(arr));
            }
        }
        
        return max;
    }
    public int answer(int[] ans){
        int cmax=Integer.MIN_VALUE;
        int omax=Integer.MIN_VALUE;
        for(int i =0;i<ans.length;i++){
            cmax=Math.max(cmax,0)+ans[i];
            omax=Math.max(omax,cmax);
        }
        return omax;
    }
};