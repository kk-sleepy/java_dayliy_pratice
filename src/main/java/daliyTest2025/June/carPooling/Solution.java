package daliyTest2025.June.carPooling;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] reg = new int[1001];
        int mx = 0;
        for(int i = 0;i<n;i++){
            int x = trips[i][0];
            reg[trips[i][1]] += x;
            reg[trips[i][2]+1] -= x;
            mx = Math.max(mx,trips[i][2]);
        }
        for(int i = 1;i<=mx;i++){
            reg[i] += reg[i-1];
            if(reg[i] > capacity)
                return false;
        }
        return true;
    }
}
