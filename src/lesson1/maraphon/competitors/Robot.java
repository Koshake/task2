package lesson1.maraphon.competitors;

public class Robot implements Competitor{
    private String model;
    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean onDistance;

    public Robot(String model) {
        this.model = model;
        this.maxRunDistance = 5000;
        this.maxJumpHeight = 2;
        this.onDistance = true;
    }

    public Robot(String model, int maxRunDistance, int maxJumpHeight) {
        this.model = model;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (maxRunDistance >= dist) {
            System.out.printf("Robot %s successfully runs %d meters\n", model, dist);
        } else {
            System.out.printf("Robot %s can't run %d meters\n", model, dist);
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (maxJumpHeight >= height) {
            System.out.printf("Robot %s successfully jumps %d meters\n", model, height);
        } else {
            System.out.printf("Robot %s can't jump %d meters\n", model, height);
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.printf("Robot %s %b\n", model, onDistance);
    }
}
