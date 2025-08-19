import java.io.*;
import java.util.*;

public class Main {

	public static int N, result;
	public static int[][] board;
	public static ArrayList<Integer[][]> arr;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		N = Integer.parseInt(br.readLine());
		int result = 0;
		board = new int[N][N]; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				result = Math.max(result, board[i][j]);
			}
		}

		result = move(5, board);

		System.out.println(result);
	}


	public static int move(int count, int[][] previous) {
		if (count == 0 ) {
			int max = 0;
			// System.out.println("===================" + count);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int current = previous[i][j];
					max = Math.max(max, current);
					// System.out.print(current+"  ");
				}
				// System.out.print(" => "+ max);
				// System.out.println();
			}
			return max;
		} else {
			//위로
			int max = 0;
			int[][] temp = new int[N][N];
			for (int i=0; i<N; i++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				int value = 0;
				for(int j=0; j<N; j++) {
					if(previous[j][i] == 0) {
						continue;
					} else {
						if(value == 0) {
							if (previous[j][i] != 0) {
								value = previous[j][i];
							}
						} else {
							if (previous[j][i] == value) {
								value += previous[j][i];
								queue.add(value);
								value = 0;
							} else {
								queue.add(value);
								value = previous[j][i];
							}
						}
					}
				}
				if (value != 0) {
					queue.add(value);
				}
				int row = 0;
				for (int h : queue){
					temp[row][i] = h;
					row ++;
				}
			}
			// for(int i=0; i<N; i++) {
			// 	for(int j=0; j<N; j++) {
			// 		System.out.print(temp[i][j]+"  ");
			// 	}
			// 	System.out.println();
			// }
			max = Math.max(max, move(count-1, temp));

			//아래
			temp = new int[N][N];
			for (int i=0; i<N; i++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				int value = 0;
				for(int j=N-1; j>=0; j--) {
					if(previous[j][i] == 0) {
						continue;
					} else {
						if(value == 0) {
							if (previous[j][i] != 0) {
								value = previous[j][i];
							}
						} else {
							if (previous[j][i] == value) {
								value += previous[j][i];
								queue.add(value);
								value = 0;
							} else {
								queue.add(value);
								value = previous[j][i];
							}
						}
					}
				}
				if (value != 0) {
					queue.add(value);
				}
				int row = N-1;
				for (int h : queue){
					temp[row][i] = h;
					row--;
				}
			}
			max = Math.max(max, move(count-1, temp));


			// 왼쪽
			temp = new int[N][N];
			for (int i=0; i<N; i++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				int value = 0;
				for(int j=0; j<N; j++) {
					if(previous[i][j] == 0) {
						continue;
					} else {
						if(value == 0) {
							if (previous[i][j] != 0) {
								value = previous[i][j];
							}
						} else {
							if (previous[i][j] == value) {
								value += previous[i][j];
								queue.add(value);
								value = 0;
							} else {
								queue.add(value);
								value = previous[i][j];
							}
						}
					}
				}
				if (value != 0) {
					queue.add(value);
				}
				int row = 0;
				for (int h : queue){
					temp[i][row] = h;
					row ++;
				}
			}
			// for(int i=0; i<N; i++) {
			// 	for(int j=0; j<N; j++) {
			// 		System.out.print(temp[i][j]+"  ");
			// 	}
			// 	System.out.println();
			// }
			max = Math.max(max, move(count-1, temp));


			// 오른쪽
			temp = new int[N][N];
			for (int i=0; i<N; i++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				int value = 0;
				for(int j=N-1; j>=0; j--) {
					if(previous[i][j] == 0) {
						continue;
					} else {
						if(value == 0) {
							if (previous[i][j] != 0) {
								value = previous[i][j];
							}
						} else {
							if (previous[i][j] == value) {
								value += previous[i][j];
								queue.add(value);
								value = 0;
							} else {
								queue.add(value);
								value = previous[i][j];
							}
						}
					}
				}
				if (value != 0) {
					queue.add(value);
				}
				int row = N-1;
				for (int h : queue){
					temp[i][row] = h;
					row --;
				}
			}
	
			max = Math.max(max, move(count-1, temp));
			return max;
		}
	}

}
