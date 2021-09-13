
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[][] reportcheck = new int[id_list.length][id_list.length];
        HashMap<String, Integer> id = new HashMap<String, Integer>();
        boolean[] count = new boolean[id_list.length];
        
        for(int i =0; i<id_list.length; i++){
            id.put(id_list[i], i);
        }
        
        for(int i=0; i<report.length; i++) {
            //System.out.println(report[i]);
            String a = report[i];
            StringTokenizer st = new StringTokenizer(a);
            String reporter = st.nextToken();
            String reported = st.nextToken();
            
            reportcheck[id.get(reporter)][id.get(reported)] = 1;
        }
        for(int i=0; i<id_list.length; i++) {
            int cnt =0;
            for(int j =0; j<id_list.length; j++) {
                if(reportcheck[j][i]==1) {
                    cnt++;
                }
            }
            if(cnt>=k) {
                count[i]=true;
                //System.out.println(id_list[i]+"는 신고되었습니다.");
            }
        }
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            for(int j=0; j<id_list.length; j++) {
                if(reportcheck[i][j]==1&&count[j]==true) {
                    answer[i]++;
                }
            }
        }
        
        
        return answer;
    }
}

