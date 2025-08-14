import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
	    long a=sc.nextLong();
        long b=sc.nextLong();

        BFS(a, b);
	}


    public static void BFS(long start, long end) {
        Queue<Long> que = new LinkedList<Long>();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        que.add(start);
        map.put(start, 0);

        while(!que.isEmpty()) {
            long t = que.poll();
            int pre = map.get(t);

            if (t == end) {
                System.out.println(pre + 1);
                return;
            }

            long next1 = t * 2;
            long next2 = t * 10 + 1;

            if (next1 <= 1_000_000_000 && !map.containsKey(next1)) {
                que.add(next1);
                map.put(next1, pre+1);
            }

            if (next2 <= 1_000_000_000 && !map.containsKey(next2)) {
                que.add(next2);
                map.put(next2, pre+1);
            }
        }
        System.out.println("-1");
    }
  
}