package controller;

import java.awt.Graphics;

public interface IController {
    void start();

    void setChange();

    void moveLeft();

    void moveRight();

    void moveDown();

    void ronate();

    void draw(Graphics g);

    void fastDown();

    void pause();

    void lose();

    void resume();

    void setLevel(int level);

    int getLevel();
}
