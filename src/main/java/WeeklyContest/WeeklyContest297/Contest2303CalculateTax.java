package WeeklyContest.WeeklyContest297;

/**
 * @author: PhilipFry
 * @create: 2022-06-12 12:43
 * @Description:You are given a 0- indexed (指数) 2D integer array brackets where brackets[i] = [upperi, percenti] means that the ith tax bracket (支架) has an upper bound of upperi and is taxed at a rate of percenti. The brackets (支架) are sorted by upper bound (i.e. upperi-1 < upperi for 0 < i < brackets.length).
 * <p>
 * Tax is calculated (计算) as follows:
 * <p>
 * The first upper0 dollars earned are taxed at a rate of percent0.
 * The next upper1 - upper0 dollars earned are taxed at a rate of percent1.
 * The next upper2 - upper1 dollars earned are taxed at a rate of percent2.
 * And so on.
 * You are given an integer income representing the amount of money you earned. Return the amount of money that you have to pay in taxes. Answers within 10-5 of the actual answer will be accepted.
 */
public class Contest2303CalculateTax {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int last = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (income <= brackets[i][0]) {
                tax = tax + ((double) (income - last) * brackets[i][1] / 100);
                break;
            } else {
                tax = tax + ((double) (brackets[i][0] - last) * brackets[i][1] / 100);
            }
            last = brackets[i][0];
        }
        return tax;
    }
}
