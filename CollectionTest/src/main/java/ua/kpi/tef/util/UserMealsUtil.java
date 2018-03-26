package ua.kpi.tef.util;

import ua.kpi.tef.model.UserMeal;
import ua.kpi.tef.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510),
                new UserMeal(LocalDateTime.of(2016, Month.MAY, 30, 9,0), "Завтрак", 200)
        );
        List<UserMealWithExceed> result =
                getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);

        for (UserMealWithExceed userMealWithExceed : result) {
            System.out.println(userMealWithExceed);
        }
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with correctly exceeded field
        Map<LocalDate, Integer> totalCaloriesPerDay = new HashMap<>();
        for (UserMeal meal : mealList) {
            LocalDate day = meal.getDateTime().toLocalDate();
            if (totalCaloriesPerDay.containsKey(day)) {
                totalCaloriesPerDay.put(day, totalCaloriesPerDay.get(day) + meal.getCalories());
            } else {
                totalCaloriesPerDay.put(day, meal.getCalories());
            }
        }

        List<UserMealWithExceed> userMealWithExceeds = new ArrayList<>();

        for (UserMeal meal : mealList) {
            LocalDate day = meal.getDateTime().toLocalDate();
            if (TimeUtil.isBetween(meal.getDateTime().toLocalTime(), startTime, endTime)) {
                userMealWithExceeds.add(
                        new UserMealWithExceed(meal.getDateTime(), meal.getDescription(),
                                meal.getCalories(), totalCaloriesPerDay.get(day) <= caloriesPerDay));
            }
        }
        return userMealWithExceeds;
    }
}
