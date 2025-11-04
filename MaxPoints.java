/*
 * There are several cards arranged in a row, and each card has an associated
 * number of points. The points are given in the integer array cardPoints.
 * 
 * In one step, you can take one card from the beginning or from the end of the
 * row. You have to take exactly k cards.
 * 
 * Your score is the sum of the points of the cards you have taken.
 * 
 * Given the integer array cardPoints and the integer k, return the maximum
 * score you can obtain.
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // STEP 1: Find the lsum
        int lsum = 0;
        int i;
        for (i = 0; i <= k - 1; i++)
            lsum = lsum + cardPoints[i];

        int maxsum = lsum;
        int rsum = 0;
        // STEP 2: Reduce the lsum and increase the rsum
        int rind = cardPoints.length - 1;
        for (i = k - 1; i >= 0; i--) {
            lsum = lsum - cardPoints[i]; // reducing the lsum
            rsum = rsum + cardPoints[rind];// counting thr right sum from back
            rind--;
            maxsum = Math.max(maxsum, lsum + rsum);

        }
        return maxsum;
    }
}