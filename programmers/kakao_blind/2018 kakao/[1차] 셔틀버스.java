import java.util.*;
import java.io.*;
class Solution {
    public int trans(String s){
        int h=(s.charAt(0)-'0')*10+(s.charAt(1)-'0');
        int m=(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
        return (h*60+m);
    }
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int len=timetable.length;
        int[] people=new int[len];
        for(int j=0; j<len; j++){
            people[j]=trans(timetable[j]);
        }
        Arrays.sort(people);
        int bustime=trans("09:00");
        int count=0;
        int contime=0;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<m; j++){
                if(people[count]<=bustime){count++;} //셔틀에 탈수 있는지 확인하고 카운트한다.
            }
            bustime+=t;
        }
        if(len-count<m) contime=bustime; //사람들 수-셔틀에 탄 사람수 =셔틀에 남은 자리가 m보다 작으면 콘이 탈수 있기 때문에 해당 막차 시간을 나가는 시간으로 한다.
        else{
            int ind=count+m-1;//위에서 셔틀에 남은 자리가 없다고 했기 때문에 
            //인덱스는 해당 count+m-1한것으로 최대로 가능한 인덱스가 된다.
            if(people[ind]<=bustime){contime=people[ind]-1; }//마지막으로 탈사람보다 1분 먼저 간다.
            //시간이 작고 자리가 남아있으니 이 사람을 기준으로 -1을 한다.
            else{contime=bustime;}// 시간이 커서 이사람을 기준으로 하는 것이 아닌 버스 시간을 기준으로 한다.
        }
        int hh=contime/60;
        int mm=contime%60;
        if(hh<10){answer="0"+hh+":";}
        else{answer=hh+":";}
        if(mm<10){answer+="0"+mm;}
        else{answer+=mm;}
        System.out.println(answer);
        return answer;
    }
}