import java.util.*;
class stage implements Comparable<stage>{
    int num;
    int rest, people;
    double rate;
    public stage(int num,  int rest, int people){ //mok 하나 지우니까 된다... 아마 0으로 나누는 문제에서 런타임 에러가 생긴듯 하다.
        this.num=num; this.rest=rest; this.people=people;
        this.rate=rest/(double)people;
    }
    @Override
    public int compareTo(stage o){
        if(this.rate<o.rate){
            return 1;
        }
        else if(this.rate>o.rate){return -1;}
        else{
            return this.num-o.num;
        }
    }
}
class Solution {
    public ArrayList<stage> arr=new ArrayList<stage>();
    public int[] solution(int N, int[] stages) {
        int[] answer = {}; 
        int[] clearcount=new int[N+1];
        int user=0;
        for(int i=0; i<stages.length; i++){
            clearcount[stages[i]-1]++;
            user++;
            
        }
        for(int i=0; i<N; i++){
            arr.add(new stage(i+1, clearcount[i], user));
            user-=clearcount[i];
        }
        Collections.sort(arr);//Comparator.reverseOrder()
        answer=new int[N];
        for(int i=0; i<N; i++){
            //System.out.println(arr.get(i).num+" "+arr.get(i).mok+" "+arr.get(i).rest+" "+arr.get(i).people);
            answer[i]=arr.get(i).num;
        }
       
        return answer;
    }
}