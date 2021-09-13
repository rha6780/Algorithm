class Solution {
   
  public String[] solution(int n, int[] arr1, int[] arr2) {
	 char[][] Map1=new char[n][n];
	 char[][] Map2=new char[n][n];
     String[] answer=new String[n];
      	for(int j=0; j<2; j++) {
		for(int i=0; i<n; i++) {
            if(j==0){
            for(int k=0; k<n; k++) {
			if(arr1[i]%2==0) {
				Map1[i][(n-1)-k]=' ';
				arr1[i]/=2;
			}
			else {
				Map1[i][(n-1)-k]='#';
				arr1[i]-=1;
				arr1[i]/=2;
			}
		}}
            else{
            for(int k=0; k<n; k++) {
				if(arr2[i]%2==0) {
					Map2[i][(n-1)-k]=' ';
					arr2[i]/=2;
				}
				else {
					Map2[i][(n-1)-k]='#'; 
                    if(Map1[i][(n-1)-k]==' ') Map1[i][(n-1)-k]='#';
					arr2[i]-=1;
					arr2[i]/=2;
				}
			}
        }
		
	}
		
}
		for(int i=0; i<n; i++) {
			answer[i]="";
		for(int j=0; j<n; j++) {
		answer[i]+=Character.toString(Map1[i][j]);}
		}
      return answer;
  }
}