package model;

public class SpinWithBlock3x3 implements Spinnable {

    @Override
    public void spin(Position[] coord) {
        for (Position position : coord) {
            int x = position.getX();
            int y = position.getY();
            position.setX(position.getY());
            position.setY(-x);
        }
    }

}
