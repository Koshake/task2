package lesson1.maraphon;

import lesson1.maraphon.competitors.Cat;
import lesson1.maraphon.competitors.Competitor;
import lesson1.maraphon.competitors.Human;
import lesson1.maraphon.competitors.Robot;
import lesson1.maraphon.obstacles.Obstacle;
import lesson1.maraphon.obstacles.Treadmill;
import lesson1.maraphon.obstacles.Wall;

public class Main {
    public static void main(String[] args) {

        Competitor [] competitors = {
                new Cat("Kitty"),
                new Human("Bob"),
                new Robot("r2d2", 10000, 0),
                new Cat("Tom", 5000, 2),
                new Human("Andrew", 500, 1),
                new Robot("JoJo")
        };

        Obstacle [] obstacles = new Obstacle[]{
                new Wall(1),
                new Treadmill(5000),
                new Wall(2)
        };

        for (Competitor competitor : competitors) {
            for (Obstacle obstacle : obstacles) {
                if (competitor.isOnDistance())
                    obstacle.doIt(competitor);
            }
        }
    }
}
