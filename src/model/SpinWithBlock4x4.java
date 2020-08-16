package model;

public class SpinWithBlock4x4 implements Spinnable {

    @Override
    public void spin(Position[] coord) {
        for (Position position : coord) {
            int x = position.getX();
            int y = position.getY();
            position.setX(-y);
            position.setY(-x);
        }
    }

}
