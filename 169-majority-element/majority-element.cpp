#include <climits>

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count = 0;
        int me = INT_MAX;

        for(int i=0; i<nums.size(); i++){
            if(count == 0){
                me = nums[i];
                count++;
            }else if(me == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return me;
    }
};