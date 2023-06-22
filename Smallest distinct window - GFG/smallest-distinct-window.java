//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        int len =Integer.MAX_VALUE;
        Set<Character> s =new HashSet<>();
        for(int i =0;i<str.length();i++){
            s.add(str.charAt(i));
        }
        String h ="";
        for(char j: s){
            h=h+j;
        }
        
        return minWindow(str,h).length();
       
        }
    
      public String minWindow(String s, String t) {

        int i = 0; // window start
        int j = 0; // window end
        int ansI = 0; // answer start index
        int ansJ = 0; // answer end index
        int ansLength = Integer.MAX_VALUE; // to compare length of answer string, store minimum length

        HashMap<Character, Integer> hm = new HashMap<>(); // hashmap to store frequency of characters of t
        for (int p = 0; p < t.length(); p++) {
            if (hm.containsKey(t.charAt(p))) {
                hm.put(t.charAt(p), hm.get(t.charAt(p)) + 1);
            } else {
                hm.put(t.charAt(p), 1);
            }
        }
        // count will keep count of all alive (freq greater than 0) characters
        int count = hm.size(); // variable to help us in avoiding to interate thru map, for checking all 0 or not

        while (j < s.length()) {    // iterate till j (window end) reaches end of string s

            char currJ = s.charAt(j);
            
            // calculation to be done for every upcoming character
            if (hm.containsKey(currJ)) {
                // decrementing freq count if character present in map
                hm.put(currJ, hm.get(currJ) - 1);
                // if freq of a particular character is 0, means count should be decremented as well,
                if (hm.get(currJ) == 0) {
                    count--;
                }
            }
            
            // count = 0  means all characters of t have came in current SW, we can now search for answer
            // a SW containing t  has been found, now we can start increasing i, so that we find minimum as well
            // increasing i -> means lets say t was "TTA", but in current SW string is "TOTMTA", we can see that
            // there is extra T in SW at(0 index), so we can increase i so that we reach to "TMTA" -> possible candidate for answer
            while (count == 0) {
                if (j - i + 1 < ansLength) {    // computing ans substring start and end index
                    ansI = i;
                    ansJ = j;
                    ansLength = j - i + 1;
                }
                char currI = s.charAt(i);
                if (hm.containsKey(currI)) {    // now since we are increasing i, means character at position i will be out of SW
                    // hence it's frequency must be incremented
                    hm.put(currI, hm.get(currI) + 1);
                    // also if a dead character's (freq = 0) frequency becomes 1, means count has to be incremented
                    if (hm.get(currI) == 1) {
                        // count will keep count of all alive (freq greater than 0) characters
                        count++;
                        // also once the count becomes > 0, this while loop will break and we will then search in further string s
                        // for minimum length window having all characters of t
                    }
                }
                // increasing i, to minimize current SW from left side
                i++;
            } 
            
            j++; // out of all if/while blocks, j++ will be done everytime
        }

        if (ansLength != Integer.MAX_VALUE)
            return s.substring(ansI, ansJ + 1);
        else
            return "";
    }
}