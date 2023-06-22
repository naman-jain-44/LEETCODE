//{ Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        ArrayList<Pair> ans=new ArrayList<>();
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==word.charAt(0)){
                    if(above(word,i,j,grid)){
                        ans.add(new Pair(i,j));
                    }else if(below(word,i,j,grid)){
                         ans.add(new Pair(i,j));
                    }else if(left(word,i,j,grid)){
                         ans.add(new Pair(i,j));
                    }else if(right(word,i,j,grid)){
                         ans.add(new Pair(i,j));
                    }else if(belowright(word,i,j,grid)){
                         ans.add(new Pair(i,j));
                    }else if(belowleft(word,i,j,grid)){
                         ans.add(new Pair(i,j));
                    }else if(aboveright(word,i,j,grid)){
                         ans.add(new Pair(i,j));
                    }else if(aboveleft(word,i,j,grid)){
                         ans.add(new Pair(i,j));
                    }
                }
            }
        }
        
        
        
        int[][] a=new int[ans.size()][2];
        for(int i =0;i<a.length;i++){
            a[i][0]=ans.get(i).x;
            a[i][1]=ans.get(i).y;
        }
        return a;
    }
    
    public boolean above(String s , int i , int j , char[][] grid){
        int k=0;
        while(i>=0 &&k<s.length()){
            if(s.charAt(k)==grid[i][j]){
                i--;
                k++;
            }else{
                return false;
            }
        }
        
        return k==s.length();
        
    }
     public boolean below(String s , int i , int j , char[][] grid){
        int k=0;
        while(i<grid.length &&k<s.length()){
            if(s.charAt(k)==grid[i][j]){
                i++;
                k++;
            }else{
                return false;
            }
        }
        
        return k==s.length();
        
    }
     public boolean left(String s , int i , int j , char[][] grid){
        int k=0;
        while(j>=0 &&k<s.length()){
            if(s.charAt(k)==grid[i][j]){
                j--;
                k++;
            }else{
                return false;
            }
        }
        
        return k==s.length();
        
    }
      public boolean right(String s , int i , int j , char[][] grid){
        int k=0;
        while(j<grid[0].length &&k<s.length()){
            if(s.charAt(k)==grid[i][j]){
                j++;
                k++;
            }else{
                return false;
            }
        }
        
        return k==s.length();
        
    }
    public boolean belowleft(String s , int i , int j , char[][] grid){
        int k=0;
        while(i<grid.length&&j>=0 &&k<s.length()){
            if(s.charAt(k)==grid[i][j]){
                j--;
                i++;
                k++;
            }else{
                return false;
            }
        }
        
        return k==s.length();
        
    }
     public boolean belowright(String s , int i , int j , char[][] grid){
        int k=0;
        while(i<grid.length&&j<grid[0].length &&k<s.length()){
            if(s.charAt(k)==grid[i][j]){
                j++;
                i++;
                k++;
            }else{
                return false;
            }
        }
        
        return k==s.length();
        
    }
     public boolean aboveright(String s , int i , int j , char[][] grid){
        int k=0;
        while(i>=0&&j<grid[0].length &&k<s.length()){
            if(s.charAt(k)==grid[i][j]){
                j++;
                i--;
                k++;
            }else{
                return false;
            }
        }
        
        return k==s.length();
        
    }
     public boolean aboveleft(String s , int i , int j , char[][] grid){
        int k=0;
        while(i>=0&&j>=0 &&k<s.length()){
            if(s.charAt(k)==grid[i][j]){
                j--;
                i--;
                k++;
            }else{
                return false;
            }
        }
        
        return k==s.length();
        
    }
    
    
}
class Pair{
    int x ;
    int y ;
    Pair(int i , int j ){
        x=i;
        y=j;
    }
}