import java.util.*;
import java.io.*;
class Solution {
    
    public HashMap<String, Integer> map=new HashMap<String, Integer>();
    public int[] solution(String msg) {
        int[] answer;
        char alph='A';
        int ind=27;
        for(int i=1; i<=26; i++){
            map.put(alph+"", i);
            //System.out.println(alph+" "+i);
            alph+=1;
        }
        char[] w=msg.toCharArray();
        int len=msg.length();
        int[] ans=new int[len];
        int count=0;
        for(int i=0; i<len; i++){
            String now=""+w[i];
            if(map.containsKey(now)){
                String tem=now;
                String nexts=now;
                if(i==len-1){ans[count]=map.get(now); count++; break;}
                for(int j=i+1; j<len; j++){
                    nexts+=""+w[j];
                    if(!map.containsKey(nexts)){
                        map.put(nexts, ind); ind++; ans[count]=map.get(tem); count++;i=j-1;break;
                        
                    }
                    if(j==len-1&&map.containsKey(nexts)){
                        ans[count]=map.get(nexts); count++;
                        i=j;
                    }
                    tem=nexts;
                }
            }
        }
        answer=new int[count];
        for(int i=0; i<count; i++){
            answer[i]=ans[i];
            //System.out.print(answer[i]+" ");
        }
        return answer;
    }
}