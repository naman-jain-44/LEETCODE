//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        
        char array[] = S.toCharArray();

    

         Arrays.sort(array);
   
         S = new String(array);
        
        
        List<String> ans =new ArrayList<>();
        
        ans = recurse(S);
        
        return ans;
    }
    
    List<String> recurse(String j ){
        if(j.length()==0){
             List<String> ans =new ArrayList<>();
             ans.add("");
             return ans;
            
        }
         List<String> ans =new ArrayList<>();
         
         for(int i =0;i<j.length();i++){
             if(i==0 ||j.charAt(i)!=j.charAt(i-1)){
                 char t =j.charAt(i);
                 String l =j.substring(0,i);
                 String r= j.substring(i+1);
                 
                 List<String> g =recurse(l+r);
                 for(int k=0;k<g.size();k++){
                     ans.add(""+t+""+ g.get(k));
                 }
                 
                 
             }
         }
         
         return ans;
        
        
        
    }
}