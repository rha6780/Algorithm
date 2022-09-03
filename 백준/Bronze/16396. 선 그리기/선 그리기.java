import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] pos = new int[N][2];
		for(int i=0; i<N; i++) {
			pos[i][0] = sc.nextInt();
			pos[i][1] = sc.nextInt();
			if(pos[i][0]>pos[i][1]) {
				int tmp = pos[i][0];
				pos[i][0] = pos[i][1];
				pos[i][1] = tmp;
			}
		}
		
		Arrays.sort(pos, new Comparator<int[]>() {
			public int compare(int a1[],  int a2[]) {
				if(a1[0]==a2[0]) {
					return Integer.compare(a1[1], a2[1]);
				}
				else
				return Integer.compare(a1[0], a2[0]);
			}
		});
		
		int result = 0;
		int Maxx = 1; int Maxy = 1;
		for(int i=0; i<N; i++) {
			if(i==0) {
				result+=(pos[i][1]-pos[i][0]);
				Maxx = pos[i][0];
				Maxy = pos[i][1];
			}
			else {
				if(pos[i][0]<Maxy) {
					if(Maxy<pos[i][1]) {
						result+=(pos[i][1]-Maxy);
						Maxy = pos[i][1];
					}
				}
				else if(pos[i-1][1]<=pos[i][0]) {
					result+=(pos[i][1]-pos[i][0]);
					Maxx = pos[i][0];
					Maxy = pos[i][1];
				}
			}
			//System.out.println(pos[i][0]+" "+pos[i][1]+" "+result);
		}
		
		System.out.println(result);

	}

}
