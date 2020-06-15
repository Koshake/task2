package lesson1.maraphon.obstacles;

import lesson1.maraphon.competitors.Competitor;

public class Treadmill implements  Obstacle {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(distance);
    }
}
