class Solution {
    public String removeStars(String s) {
        Stack<Character> k = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='*'){
               k.pop();
               
               
               }else{
                   k.push(s.charAt(i));
                   
               }
        }
               
               String sol ="";
               while(k.size()>0){
                   sol = String.valueOf(k.pop())  +sol ;
               }
               
               
               return sol;
        
    }
}