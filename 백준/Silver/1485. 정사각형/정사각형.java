import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0; i<T; i++){
			int[][] dot=new int[4][2];
			for(int j=0; j<4; j++){
				dot[j][0]=sc.nextInt(); dot[j][1]=sc.nextInt();
			}
			Arrays.sort(dot, new Comparator<int[]>(){
				@Override
				public int compare(int[] o1, int[] o2){
					if(o1[0]==o2[0]){return o1[1]-o2[1];}
					else return o1[0]-o2[0];
				}
			});
			long dis11=(dot[1][0]-dot[0][0])*(dot[1][0]-dot[0][0])+(dot[1][1]-dot[0][1])*(dot[1][1]-dot[0][1]);
			long dis12=(dot[2][0]-dot[0][0])*(dot[2][0]-dot[0][0])+(dot[2][1]-dot[0][1])*(dot[2][1]-dot[0][1]);
			long dis21=(dot[3][0]-dot[2][0])*(dot[3][0]-dot[2][0])+(dot[3][1]-dot[2][1])*(dot[3][1]-dot[2][1]);
			long dis22=(dot[3][0]-dot[1][0])*(dot[3][0]-dot[1][0])+(dot[3][1]-dot[1][1])*(dot[3][1]-dot[1][1]);
			long dir1=(dot[2][0]-dot[1][0])*(dot[2][0]-dot[1][0])+(dot[2][1]-dot[1][1])*(dot[2][1]-dot[1][1]);
			long dir2=(dot[3][0]-dot[0][0])*(dot[3][0]-dot[0][0])+(dot[3][1]-dot[0][1])*(dot[3][1]-dot[0][1]);
			boolean is=false;
			if(dis11==dis12){
				if(dis21==dis22){
					if(dis11==dis21){
						if(dir1==dir2)is=true;}
				}
			}
			if(is){System.out.println(1);}
			else{System.out.println(0);}
			
		}

	}

}
