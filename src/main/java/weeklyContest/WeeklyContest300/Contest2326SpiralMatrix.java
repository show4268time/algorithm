package weeklyContest.WeeklyContest300;

import java.util.Arrays;

/**
 * @author: PhilipFry
 * @create: 2022-07-03 14:05
 * @Description: You are given two integers m and n, which represent the dimensions of a matrix.
 * <p>
 * You are also given the head of a linked list of integers.
 * <p>
 * Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise),
 * <p>
 * starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.
 * <p>
 * Return the generated matrix.
 */
public class Contest2326SpiralMatrix {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -1);
        }
        int h = 0, w = 0;
        int count = 0;
        while (head != null) {
            h = count;
            for (int i = count; i < n - count; i++) {
                if (head == null) {
                    return result;
                }
                int val = head.val;
                result[h][i] = val;
                head = head.next;
            }

            w = n - 1 - count;
            for (int i = 1 + count; i < m - count; i++) {
                if (head == null) {
                    return result;
                }
                int val = head.val;
                result[i][w] = val;
                head = head.next;
            }


            h = m - 1 - count;
            for (int i = n - 2 - count; i >= count; i--) {
                if (head == null) {
                    return result;
                }
                int val = head.val;
                result[h][i] = val;
                head = head.next;
            }

            w = count;
            for (int i = m - 2 - count; i >= count + 1; i--) {
                if (head == null) {
                    return result;
                }
                int val = head.val;
                result[i][w] = val;
                head = head.next;
            }

            count++;
        }
        return result;
    }
}
