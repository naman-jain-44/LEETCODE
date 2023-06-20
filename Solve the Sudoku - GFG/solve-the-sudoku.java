//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int arr[][])
    {
        // add your code here
        
        //make bitmasks of initial array that is given and store in three ararys 
        
        int[] bitrow = new int[9];
        int[] bitcol=new int[9];
        int[][] grid = new int[3][3];
        
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                int k =1<<arr[i][j];
                //here OR because we have to prepare or add all the answers 
                bitrow[i]^=k;
                bitcol[j]^=k;
               grid[i/3][j/3]^=k;
            }
        }
        
        
        return recurse(arr,bitrow,bitcol,grid,0,0);
    }
    public static boolean recurse(int[][] arr , int[] bitrow ,int[] bitcol,int[][] grid,int i , int j){
        if(i==arr.length){
            return true;
        }
        
        if(arr[i][j]>0){
            int nr =i;
            int nc=j+1;
            if(j==arr.length-1){
               
                nr++;
                nc=0;
            }
            boolean ans =recurse(arr,bitrow,bitcol,grid,nr,nc);
            if(ans==true){
                return true;
            }
            
            
           
            
        }else{
            for(int k =1;k<=9;k++){
                if(((bitrow[i]&(1<<k))==0)&&((bitcol[j]&(1<<k))==0)&&((grid[i/3][j/3]&(1<<k))==0)){
                    
                    bitrow[i]^=(1<<k);
                bitcol[j]^=(1<<k);
               grid[i/3][j/3]^=(1<<k);
               arr[i][j]=k;
                
            int nr =i;
            int nc=j+1;
            if(j==arr.length-1){
               
                nr++;
                nc=0;
            }
            boolean ans =recurse(arr,bitrow,bitcol,grid,nr,nc);
            if(ans==true){
                return true;
            }
           
               
               
               arr[i][j]=0;
               
               bitrow[i]^=(1<<k);
                bitcol[j]^=(1<<k);
               grid[i/3][j/3]^=(1<<k);
               
            }
                
                
                
                
                
            }
            
            return false;
            
        }
        
        return false;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}