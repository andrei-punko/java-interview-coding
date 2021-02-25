package by.andd3dfx.numeric;

/**
 * For given array of heights find largest pit
 */
public class LargestPit {

    /**
     * Given an Array A of integers, here is one way to look for the depth bestDepth of the deepest pit (P,Q,R) using a
     * variable status to know in every iteration where we are in the pit: going up or down. status will contain one the
     * values ‘P’ then ‘Q’ then ‘R’.
     *
     * According to: https://www.quora.com/What-is-the-algorithm-for-finding-the-deepest-pit-in-an-array
     */
    public static int find(int[] heights) {
        if (heights.length < 3) {
            return 0;
        }

        int bestDepth = -1;
        int currMinDepth = 0;
        int P = heights[0];
        int Q = heights[0];
        int R = heights[0];
        int status = 'P';
        int i = 0;
        while (i < heights.length - 1) {
            if (heights[i] > heights[i + 1]) {
                if (status == 'R') {
                    currMinDepth = Math.min(P - Q, R - Q);
                    if (currMinDepth > 0 && currMinDepth > bestDepth) {
                        bestDepth = currMinDepth;
                    }
                    P = heights[i];
                }
                Q = heights[i + 1];
                status = 'Q';
                i++;
                continue;
            } else if (heights[i + 1] > heights[i]) {
                if (status == 'Q' || status == 'R') {
                    R = heights[i + 1];
                    i++;
                    status = 'R';
                    if (i == heights.length - 1) {
                        currMinDepth = Math.min(P - Q, R - Q);
                        if (currMinDepth > bestDepth) {
                            bestDepth = currMinDepth;
                        }
                    }
                    continue;
                }
                if (status == 'P') {
                    P = heights[i + 1];
                    i++;
                    continue;
                }
            }
            i++;
        }
        return bestDepth;
    }
}
