package lesson1.maraphon.competitors;

public class Cat implements Competitor {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean onDistance;

    public Cat(String name) {
        this.name = name;
        this.maxRunDistance = 500;
        this.maxJumpHeight = 3;
        this.onDistance = true;
    }

    public Cat(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (maxRunDistance >= dist) {
            System.out.printf("Cat %s successfully runs %d meters\n", name, dist);
        } else {
            System.out.printf("Cat %s can't run %d meters\n", name, dist);
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (maxJumpHeight >= height) {
            System.out.printf("Cat %s successfully jumps %d meters\n", name, height);
        } else {
            System.out.printf("Cat %s can't jump %d meters\n", name, height);
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.printf("Cat %s %b\n", name, onDistance);
    }
}
