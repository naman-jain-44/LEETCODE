//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public  List<String> wordBreak(int n, List<String> dict, String s)
    {
        // code here
        Set<String> h=new HashSet<>();
        
        for(String j :dict){
            
            h.add(j);
        }
       // System.out.print(h.size());
        List<String> ans =new ArrayList<>();
        
        String u ="";
        
        recurse(0,h,ans,s,u);
        
        
        return ans;
    }
    
    public   void recurse(int idx ,  Set<String> h ,List<String> ans,String s , String sol){
        if(idx>=s.length()){
           // System.out.print(sol);
            
            if(sol.length()>0){
             //   String u = ;
                
                 ans.add(new String(sol.substring(0,sol.length()-1)));
            }
            
            return ;
        }
        
        for(int i =idx+1;i<=s.length();i++){
            if(h.contains(s.substring(idx,i))){
                //String j = new String();
                recurse(i,h,ans,s,sol+s.substring(idx,i)+" ");
            }
        }
        
        return ;
    }
}