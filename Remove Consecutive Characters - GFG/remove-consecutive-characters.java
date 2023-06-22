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
            
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.removeConsecutiveCharacter(S);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String removeConsecutiveCharacter(String s){
        
        
 int i = 0;
    int j = 0;
 
    // Initialize an empty string for new elements
    String newElements = "";
 
    // Iterate string using j pointer
    while (j < s.length()) {
 
      // If both elements are same then skip
      if (s.charAt(i) == s.charAt(j)) {
        j++;
      }
 
      // If both elements are not same then append new
      // element
      else if (s.charAt(j) != s.charAt(i)
               || j == s.length() - 1) {
        newElements += s.charAt(i);
 
        // After appending, slide over the window
        i = j;
        j++;
      }
    }
 
    // Append the last string
    newElements += s.charAt(j - 1);
    return newElements;
    }
   
}