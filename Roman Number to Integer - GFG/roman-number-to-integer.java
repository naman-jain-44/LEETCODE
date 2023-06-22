//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        // code here
         HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I' , 1);
         hm.put('V' , 5);
         hm.put('X' , 10);
         hm.put('L' , 50);
         hm.put('C' , 100);
         hm.put('D' , 500);
         hm.put('M' , 1000);
        int sum=0;
        
        for(int i =0 ;i<s.length();i++){
            Character c = s.charAt(i);
            Character d = '0';
            if(i<(s.length()-1)){
             d = s.charAt(i+1);
        }
            if(c=='I' && d=='V'){
                i++;
                sum = sum+4;
            }else if(c=='I' && d=='X'){
                i++;
                sum = sum+9;
            }else if(c=='X' && d=='L'){
                i++;
                sum = sum+40;
            }else if(c=='X' && d=='C'){
                i++;
                sum = sum+90;
            }else if(c=='C' && d=='D'){
                i++;
                sum = sum+400;
            }else if(c=='C' && d=='M'){
                i++;
                sum = sum+900;
            }else{
                sum = sum+hm.get(s.charAt(i));
            }
            
            
            
        }
   return sum;
    }
}