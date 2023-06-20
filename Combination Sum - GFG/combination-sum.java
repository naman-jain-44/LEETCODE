//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    public  ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        Set<Integer> s = new HashSet<>();
        for(int i =0;i<A.size();i++){
            s.add(A.get(i));
        }
        A=new ArrayList<>();
        for(int y :s){
            A.add(y);
        }
        Collections.sort(A);
        
        ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
        recurse(0,A,new ArrayList<Integer>(),B,ans);
        
        
        
        
        return ans;
    }
    
    public void recurse(int idx , ArrayList<Integer> A,ArrayList<Integer> an, int B, ArrayList<ArrayList<Integer>> ans){
        if(idx>=A.size()){
            if(B==0){
                ArrayList<Integer> d =new ArrayList<>();
                for(int i =0;i<an.size();i++){
                    d.add(an.get(i));
                }
                ans.add(d);
                
            }
            
            return ;
            
        }
        if(A.get(idx)<=B){
            an.add(A.get(idx));
            recurse(idx,A,an,B-A.get(idx),ans);
            an.remove(an.size()-1);
        }
        recurse(idx+1,A,an,B,ans);
        return ;
    }
    
}