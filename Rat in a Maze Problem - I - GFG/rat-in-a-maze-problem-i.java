//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        boolean[][] visited=new boolean[n][n];
        
        recurse(0,0,visited,"",m,ans);
        Collections.sort(ans);
        
        
        
        
        return ans;
    }
    
    public void recurse(int i , int j , boolean[][] visited, String path,int[][] m, ArrayList<String> ans){
        if(i<0||j<0||i>=visited.length||j>=visited.length||visited[i][j]==true||m[i][j]==0){
            return ;
        }
        if(i==visited.length-1&&j==visited.length-1){
            ans.add(new String(path));
            return ;
        }
        
        visited[i][j]=true;
        recurse(i+1,j,visited,path+"D",m,ans);
        recurse(i-1,j,visited,path+"U",m,ans);
        recurse(i,j+1,visited,path+"R",m,ans);
        recurse(i,j-1,visited,path+"L",m,ans);
        
        visited[i][j]=false;
    }
}