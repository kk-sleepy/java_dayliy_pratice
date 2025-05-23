package daliyTest2025.May.minimumRefill2105;

class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0, r = plants.length - 1;
        int a = capacityA , b = capacityB;
        int sum = 0;
        while(l <= r){
            if(l == r){
                if(Math.max(a,b)<plants[l])
                    sum += 1;
                break;
            }
            if(a >= plants[l]){
                a -= plants[l];
            }else{
                a = capacityA - plants[l];
                sum += 1;
            }
            l += 1;
            if(b >= plants[r]){
                b -= plants[r];
            }else{
                b = capacityB - plants[r];
                sum += 1;
            }
            r -= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumRefill(new int[]{1,2,4,4,5},6,5));
    }
}