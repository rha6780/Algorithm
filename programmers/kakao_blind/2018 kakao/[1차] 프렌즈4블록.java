class Solution {
    public int[][] removec=new int[100][100];
    public int[][] arr=new int[100][100];
    public int[][] temp=new int[100][100];
    
    public boolean select(int m, int n, String[] board){
        int count=0;
        
        int f=0;
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                int s=arr[i][j];
                if(s!=0&&s==arr[i+1][j]&&s==arr[i][j+1]&&s==arr[i+1][j+1]){
                    removec[i][j]=1;removec[i+1][j]=1;removec[i][j+1]=1;removec[i+1][j+1]=1;
                    f=1;
                }
            }
        }
        if(f==1){
            return true;
        }
        else{return false;}
    }
    public void remove(int m, int n){
        temp=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(removec[i][j]==1){
                    arr[i][j]=0;
                }
            }
        }
        for(int i=0; i<n; i++){
            int ind=m-1;
            for(int j=m-1; j>=0; j--){
                if(removec[j][i]!=1){
                    temp[ind--][i]=arr[j][i];
                    //본래 remove가 1이 아닌 부분 즉 지워지지 않는 부분이 M-1 부터 온다면 board에 해당하는 부분도 그대로 이기 때문에 해당 블럭은 그대로 있다.
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=temp[i][j];
            }
        }
        removec=new int[m][n];
    }
    public int solution(int m, int n, String[] board) {
        arr=new int[m][n];removec=new int[m][n];
        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++)
                arr[i][j]=board[i].charAt(j)-'A'+1;
        }
        int answer = 0;
        int count=0;
        boolean f=false;
        while(true){
            f=select(m,n,board);
            if(f==false){break;}
            else{
                remove(m,n);
            } 
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==0){
                    //System.out.print(arr[i][j]);
                    count++;
                }   
            }//System.out.println();
        }
        answer=count;
        return answer;
    }
}