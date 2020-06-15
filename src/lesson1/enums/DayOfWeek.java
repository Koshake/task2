package lesson1.enums;

public enum DayOfWeek {
    Monday(40),
    Tuesday(32),
    Wednesday(24),
    Thursday(16),
    Friday(8),
    Saturday(0),
    Sunday(0);

    private int workingHoursLeft;

    DayOfWeek(int workingHoursLeft) {
        this.workingHoursLeft = workingHoursLeft;
    }

    public int getWorkingHours(DayOfWeek current) {
        return current.workingHoursLeft;
    }


}
