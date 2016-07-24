import java.util.HashMap;
public class ReverseBits {
    private HashMap<Long, Integer> map;
    public ReverseBits() {
        map = new HashMap<Long, Integer>();
        long one = 1;
        for (int i = 0; i < 64; i ++) {
            map.put((one << i), i);
        }
        //System.out.println("Number of keys in map: " + map.keySet().size());
    }

    public long reverse(long num) {
        long reverse = 0;
        int pow = 0;
        while (pow < 64) {
            reverse |= ((num & (1 << pow)) << (63 - pow - pow));
            pow ++;
        }
        return reverse;
    }
    
    public long reverseOpt(long num) {
        long reverse = 0;
        //int numIters = 0;
        while (num > 0) {
            long mask = num & ~(num - 1);
            int pow = map.get(mask);
            reverse |= (mask << (63 - pow - pow));
            num &= (num - 1);
            //numIters ++;
        }
        //System.out.println(numIters);
        return reverse;
    }


    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java reverseBits <number>");
            return;
        }
        try {
            ReverseBits test = new ReverseBits();
            long num = Long.parseLong(args[0]);
            //long startTime = System.currentTimeMillis();
            long startTime = System.nanoTime();
            long reverse = test.reverse(num);
            //long timeTaken = System.currentTimeMillis() - startTime;
            long timeTaken = System.nanoTime() - startTime;
            System.out.println("Reverse of " + num + " is " + reverse + "; calculated in " + timeTaken + " ns");
            //startTime = System.nanoTime();
            //reverse = test.reverseOpt(num);
            //timeTaken = System.nanoTime() - startTime;
            //System.out.println("Reverse of " + num + " with optimization is " + reverse + "; calculated in " + timeTaken + " ns");
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter only a number");
        }
    }



}
