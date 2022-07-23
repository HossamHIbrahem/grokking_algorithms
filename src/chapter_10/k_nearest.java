package chapter_10;

import java.util.LinkedList;
import java.util.List;

public class k_nearest {

    private static class BreadNumber {
        int weather;
        int isHoliday;
        int isActivity;
        int number;
        float distance;

        public BreadNumber(int weather, int isHoliday, int isActivity, int number) {
            this.weather = weather;
            this.isHoliday = isHoliday;
            this.isActivity = isActivity;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        List<BreadNumber> breadNumbers = new LinkedList<BreadNumber>() {
            {
                add(new BreadNumber(5, 1, 0, 300));
                add(new BreadNumber(3, 1, 1, 225));
                add(new BreadNumber(1, 1, 0, 75));
                add(new BreadNumber(4, 0, 0, 200));
                add(new BreadNumber(4, 0, 0, 150));
                add(new BreadNumber(2, 0, 0, 50));
            }
        };
        BreadNumber today = new BreadNumber(4, 1, 0, 0);
        float prediction = knn(breadNumbers, today, 4);
        System.out.println(prediction);
    }

    private static float knn(List<BreadNumber> breadNumbers, BreadNumber today, int k) {

        for (BreadNumber breadNumber : breadNumbers) {
            float distance = computeDistance(breadNumber, today);
            breadNumber.distance = distance;
        }

        List<BreadNumber> neighbors = new LinkedList<BreadNumber>();
        while (k > 0 && !breadNumbers.isEmpty()) {
            float nearest = Float.MAX_VALUE;
            BreadNumber nearestNeighbor = null;
            for (BreadNumber breadNumber : breadNumbers) {
                if (breadNumber.distance < nearest) {
                    nearestNeighbor = breadNumber;
                    nearest = breadNumber.distance;
                }
            }
            k--;
            neighbors.add(nearestNeighbor);
            breadNumbers.remove(nearestNeighbor);
        }

        float todayNumber = 0;
        for (BreadNumber neighbor : neighbors) {
            todayNumber += neighbor.number;
        }
        return todayNumber / neighbors.size();
    }

    private static float computeDistance(BreadNumber breadNumber, BreadNumber today) {
        return (float) Math.sqrt(Math.pow((breadNumber.weather - today.weather), 2) +
                Math.pow((breadNumber.isHoliday - today.isHoliday), 2) +
                Math.pow((breadNumber.isActivity - today.isActivity), 2));
    }
}
