import java.util.*;

class Solution {

    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] res = new double[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int j = stack.peek();
                /*
                if ith speed is lesser, than move on to next car(pop)
                if time to collide with car is longer, than ANOTHER ALREADY CALCULATED TIME, than pop
                 */
                if (cars[i][1] <= cars[j][1] || (cars[j][0] - cars[i][0]) * 1.0 / (cars[i][1] - cars[j][1]) >= res[j] && res[j] > 0) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (stack.isEmpty()) {
                res[i] = -1.0;
            } else {
                int j = stack.peek();
                res[i] = (cars[j][0] - cars[i][0]) * 1.0 / (cars[i][1] - cars[j][1]);
            }
            stack.push(i);
        }
        return res;
    }
}