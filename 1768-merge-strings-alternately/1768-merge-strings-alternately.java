class Solution {
    public String mergeAlternately(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();
        int z =0;
        int x =0;
        if(a>=b){
            z = a;
            x = b;
            
        }else{
            z =b;
            x =a;
        }
        int k =0;
        int kk =0;
        
        StringBuilder sol = new StringBuilder();
        for(int i =0;i<2*x;i++){
            if(i%2==0){
            sol = sol.append(Character.toString(word1.charAt(k)));
                k++;
            }else if(i%2==1){
            sol = sol.append(Character.toString(word2.charAt(kk)));
                kk++;
        }
            
        }
        
        if(a>=b){
           for(int i=k;i<a;i++){
                sol = sol.append(Character.toString(word1.charAt(i)));
           }
            
        }else{
            for(int i =kk;i<b;i++){
              sol = sol.append(Character.toString(word2.charAt(i)));
           }
        }
        return sol+"";
        
    }
}