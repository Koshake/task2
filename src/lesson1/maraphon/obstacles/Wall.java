package lesson1.maraphon.obstacles;

import lesson1.maraphon.competitors.Competitor;

public class Wall implements Obstacle {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}
