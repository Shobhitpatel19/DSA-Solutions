class Solution {
public:
    int longestConsecutive(vector<int>& arr) {
        unordered_map<int, bool> map;
        for(int val: arr){
            map[val] = true;
        }
        for(int val: arr){
            if(map.find(val-1) != map.end()){
                map[val] = false;
            }
        }
        int ml = 0;
        for(int val: arr){
            if(map[val] == true){
                int tl = 1;
                int tsp = val;

                while(map.find(tsp + tl) != map.end()){
                    tl++;
                }
                if(tl > ml){
                    ml = tl;
                }
            }
        }
        return ml;
    }
};