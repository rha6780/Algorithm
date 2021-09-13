import java.util.*;
class Solution {
    
    public HashMap<String, String> hmap=new HashMap<String, String>();
    public String[] solution(String[] record) {
        String[] answer = {};
        int count=0;
        String[] sub=new String[100001];
        String[] subn=new String[100001];
        for(int i=0; i<record.length; i++){
            String comm="";
            String[] cmd=record[i].split(" ");
            if(cmd[0].equals("Enter")){comm+="님이 들어왔습니다."; hmap.put(cmd[1], cmd[2]);
                                       sub[count]=comm;
                                       subn[count]=cmd[1]; count++;}
            else if(cmd[0].equals("Leave")){comm+="님이 나갔습니다.";
                                            sub[count]=comm;subn[count]=cmd[1];count++;}
            else {
                hmap.replace(cmd[1], hmap.get(cmd[1]), cmd[2]); 
            }
            
        }
        answer=new String[count];
        for(int i=0; i<count; i++){
            answer[i]=(hmap.get(subn[i])+""+sub[i]);
           // System.out.println(answer[i]);
        }
        return answer;
    }
}