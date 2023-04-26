class Solution {
    public int addDigits(int num) {
       int sol =0;
        if(num>=0 &&num<=9){
            return num;
        }
        while(!(num>=0 &&num<=9)){
             sol =0;
            while(!(num>=0 && num<=9)){
            int x = num%10;
            sol = sol+x;
            num = num/10;
        }
            sol = sol+num;
        num = sol;
        }
        return sol;
    }
}