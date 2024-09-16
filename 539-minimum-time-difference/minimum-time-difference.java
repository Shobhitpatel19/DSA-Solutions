class Solution {
    public int findMinDifference(List<String> timePoints) {
        // In a day 1440 minutes are present
        boolean minutes[] = new boolean[1440];
        
        for(int i = 0; i < timePoints.size(); i++){
            
            String splitTime[] = timePoints.get(i).split(":");
            
            int hours = Integer.parseInt(splitTime[0]);
            int minute = Integer.parseInt(splitTime[1]);
            
            int totalTime = hours * 60 + minute;
            
            // Means there are two same time points so best min ans is 0
            if( minutes[totalTime] ) return 0;
            
            minutes[totalTime] = true;
        }
        
        int min = Integer.MAX_VALUE;
        int firstTimeStamp = -1;
        int lastTimeStamp = -1;
        int currentTimeStamp = -1;
        
        for(int i = 0; i < minutes.length; i++){
            if(minutes[i]){
                if(lastTimeStamp == -1) {
                   lastTimeStamp = i;   // becoz i is minutes
                   firstTimeStamp = i;
                   continue;
               }
               currentTimeStamp = i;
               min = Math.min(min , currentTimeStamp - lastTimeStamp);
               lastTimeStamp = i; // lastTimeStamp = currentTimeStamp;
            }
        }
        
        /* check for conditions like 11:59 - 00:00 */
        
        return Math.min(min , 1440 - lastTimeStamp + firstTimeStamp );
        
        
    }
}