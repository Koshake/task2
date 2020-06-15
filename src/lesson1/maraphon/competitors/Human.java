package lesson1.maraphon.competitors;

public class Human implements  Competitor{
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean onDistance;

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 1000;
        this.maxJumpHeight = 2;
        this.onDistance = true;
    }

    public Human(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (maxRunDistance >= dist) {
            System.out.printf("Human %s successfully runs %d meters\n", name, dist);
        } else {
            System.out.printf("Human %s can't run %d meters\n", name, dist);
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (maxJumpHeight >= height) {
            System.out.printf("Human %s successfully jumps %d meters\n", name, height);
        } else {
            System.out.printf("Human %s can't jump %d meters\n", name, height);
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.printf("Human %s %b\n", name, onDistance);
    }
}
