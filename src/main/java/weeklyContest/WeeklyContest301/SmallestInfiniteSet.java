package weeklyContest.WeeklyContest301;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: PhilipFry
 * @create: 2022-07-10 12:35
 * @Description:
 */
public class SmallestInfiniteSet {
    private Set<Integer> set = new HashSet<>();

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        set.add(i);
        return i;

    }

    public void addBack(int num) {
        if (set.contains(num)) {
            set.remove(num);
        }

    }
}
