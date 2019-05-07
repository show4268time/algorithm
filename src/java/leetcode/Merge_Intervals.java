package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @description: 合并区间
 *  假设有[2,6],[1,3],[15,18],[8,10]。先按起始位置排序，变成[1,3],[2,6],[8,10],[15,18]就好办多了。依次遍历，维护一个最大scope。
 *  只要起始位置没有超过这个最大scope就可以判断是overlapping了。
 *  比如，[1,3]最大scope是3，[2,6]的起始位置2 < 3，代表区间重叠。然后最大scope更新为6。下一个元素[8,10]的起始元素8 > 6，就没有重叠。
 * @author: yaoweihao
 * @date: 2018/10/22
 * @time: 10:34
 * @modified by:
 */
public class Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals.isEmpty()) return result;

        Collections.sort(intervals, (Interval first, Interval second) -> first.start - second.start);

        Interval pool = intervals.get(0);
        for(Interval interval : intervals){
            if(pool.end < interval.start){
                result.add(pool);
                pool = interval;
            }else {
                pool.end = Math.max(interval.end, pool.end);
            }
        }
        result.add(pool);
        return result;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
