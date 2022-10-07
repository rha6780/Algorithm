import java.util.*;

public class Main {
   static int N, H;
   static HashMap<Integer, Integer> map;
   public static void main(String[] args) {
      map = new HashMap<Integer, Integer> ();
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      H = sc.nextInt();
      int n2 = N/2;

      for (int i=0; i<n2; i++) {
         int t = H-sc.nextInt();
         map.put(t, map.getOrDefault(t, 0)+1);  
         t = sc.nextInt();
         map.put(t, map.getOrDefault(t, 0)-1);  
      }
      sc.close();
      int idx=0, len = map.size();
      int[][] E = new int[len][2];
        for(Integer key : map.keySet() ){
            E[idx][0] = key;
            E[idx++][1]= map.get(key);
        }

        Arrays.sort(E, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
                   return o1[0]- o2[0];
                }
           });
  
      int cur = n2, min =n2, cnt=1;
      for (int i=0; i<len; i++) {
         cur = cur+E[i][1];
         if (min > cur) {
            min = cur; 
            if (i+1 <len) 
               cnt=E[i+1][0]-E[i][0];
            else 
               cnt=H -E[i][0];
         }
         else if (min ==cur) {
            if (i+1 <len) 
               cnt+=E[i+1][0]-E[i][0];
            else 
               cnt+=H -E[i][0];
         }
      }
      System.out.println(min +" "+ cnt);
   }
}