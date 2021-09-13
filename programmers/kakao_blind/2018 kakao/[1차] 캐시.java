class Solution {
   
    public int solution(int cacheSize, String[] cities) {
      int answer = 0;
        String[] space=new String[cacheSize];
        int [] count=new int[cacheSize];
    if(cacheSize==0){answer+=(5*cities.length);}
    else {
        
      for(int y=0; y<cities.length; y++){cities[y]=cities[y].toLowerCase();}
       
      int h=0, oo=0;
      for(int k=0; k<cities.length; k++){
          oo=0;
          for(int j=0; j<cacheSize; j++){if(space[j]!=null&&space[j].equals(cities[k])) {oo=1; count[j]=k; } }
              if(oo!=1){
                 oo=5;
                 int min=k, site=0, cco=0;
                 for(int m=h; ;m=(m+1)%cacheSize){
                         if(space[m]==null){space[m]=cities[k]; count[m]=k; h=((m+1)%cacheSize); break;}
                         else{
                         if(min>count[m]){//오래전에 활용된것을 찾는 것.
                             min=count[m];
                             site=m;
                         } 
                        if(cco==cacheSize){
                             h=site; space[h]=cities[k]; count[h]=k; h=((m+1)%cacheSize); break;}
                             cco++;
                     }
                 }
              }
          answer+=oo;
      }
     }
      return answer;
  }
}