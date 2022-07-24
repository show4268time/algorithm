package weeklyContest.WeeklyContest303;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author: PhilipFry
 * @create: 2022-07-24 13:56
 * @Description:
 */
public class FoodRatings {

    HashMap<String, TreeSet<food>> map;// 烹饪方式对应的食物集合，食物集合根据评分和字典序自然排序
    HashMap<String, String> cuisinesMap;//食物名字对应的烹饪方式。
    HashMap<String, food> objMap;//食物名字对应的食物对象。

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        cuisinesMap = new HashMap<>();
        objMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            //自定义食物的排序规则
            TreeSet<FoodRatings.food> foodTreeSet = map.getOrDefault(cuisine, new TreeSet<>(
                    (o1, o2) -> {
                        if (o1.rating == o2.rating) {
                            return o1.name.compareTo(o2.name);
                        } else {
                            return o2.rating - o1.rating;
                        }
                    }
            ));
            FoodRatings.food e = new food(food, rating, cuisine);
            foodTreeSet.add(e);
            map.put(cuisine, foodTreeSet);
            objMap.put(food, e);
            cuisinesMap.put(food, cuisine);
        }
    }

    //修改名字为 food 的食物的评分。
    public void changeRating(String food, int newRating) {
        String cuisines = cuisinesMap.get(food);
        if (cuisines != null) {
            TreeSet<food> set = map.get(cuisines);
            if (set != null) {
                FoodRatings.food o = objMap.get(food);
                set.remove(o);
                FoodRatings.food e = new food(food, newRating, o.cuisine);
                set.add(e);
                objMap.put(food, e);
            }
        }
    }

    //返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
    public String highestRated(String cuisine) {
        TreeSet<food> foods = map.get(cuisine);
        food last = foods.first();
        return last.name;
    }

    class food {
        String name;
        int rating;
        String cuisine;

        public food(String name, int rating, String cuisine) {
            this.name = name;
            this.rating = rating;
            this.cuisine = cuisine;
        }
    }
}
