package lesson1.enums;

public class DayOfWeekMain {
    public static void main(String[] args) {
        getWorkingHours(DayOfWeek.Thursday);
    }

    public static void getWorkingHours(DayOfWeek day) {
        if (day.getWorkingHours(day) == 0) {
            System.out.println("Сегодня выходной!");
        } else {
            System.out.println("До конца недели нужно отработать " + day.getWorkingHours(day));
        }
    }
}
