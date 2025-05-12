package daliyTest2025.May.findEvenNumbers;

import java.util.*;

class Solution {
    private List<Integer> ans;
    public int[] findEvenNumbers(int[] digits) {
        ans = new ArrayList<>();
        int n = digits.length;
        int[] cnt = new int[10];
        for(int data : digits){
            cnt[data] += 1;
        }
        find(0,0,digits,cnt);
        return ans.stream().mapToInt(i->i).toArray();
    }
    private void find(int i,int num ,int[] digits,int[] cnt){
        if( i == 3){
            if(num>=100)
                ans.add(num);
            return;
        }
        for(int j = 0;j<10;j++){
            if(cnt[j] == 0)
                continue;
            if(i == 0 && j == 0)
                continue;
            if(i == 2 && j %2 == 1)
                continue;
            num = num * 10 + j;
            cnt[j] -= 1;
            find(i+1,num,digits,cnt);
            cnt[j] += 1;
            num /= 10;
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] digits = new int[] {2,1,3,0};
        int[] ans = s.findEvenNumbers(digits);
        for(int data : ans){
            System.out.print(data + " ");
        }
    }
}
