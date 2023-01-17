package at.florian.games.observer_pattern.movement;

import at.florian.games.observer_pattern.ObserverColorChanger;
import at.florian.games.observer_pattern.ObserverKeyListener;
import at.florian.games.strategy_pattern.movement.MovementStrategy;

import java.util.ArrayList;
import java.util.List;

public class MoveByKeys implements MovementStrategy, ObserverKeyListener {
    private float x, y, speed;
    private List<ObserverColorChanger> observerColorChangers;

    private enum DIRECTION {RIGHT, LEFT, UP, DOWN}

    ;
    private DIRECTION movementDirection;

    public MoveByKeys(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 2f;
        this.observerColorChangers = new ArrayList<>();
    }

    public void addItemColorChanger(ObserverColorChanger observerColorChanger) {
        this.observerColorChangers.add(observerColorChanger);
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public void update(int delta, float height, float width) {
        if (this.movementDirection == DIRECTION.UP) {
            if (!(this.y < height)) {
                this.y -= delta / this.speed;
                isNotTouchedObserver();
            } else {
                isTouchedObserver();
            }
        } else if (this.movementDirection == DIRECTION.LEFT) {
            if (!(this.x < width)) {
                this.x -= delta / this.speed;
                isNotTouchedObserver();
            } else {
                isTouchedObserver();
            }
        } else if (this.movementDirection == DIRECTION.DOWN) {
            if (!(this.y > 600 - height * 2)) {
                this.y += delta / this.speed;
                isNotTouchedObserver();
            } else {
                isTouchedObserver();
            }
        } else if (this.movementDirection == DIRECTION.RIGHT) {
            if (!(this.x > 800 - width * 2)) {
                this.x += delta / this.speed;
                isNotTouchedObserver();
            } else {
                isTouchedObserver();
            }
        }
    }

    private void isTouchedObserver() {
        for (ObserverColorChanger observerColorChanger : this.observerColorChangers) {
            observerColorChanger.isTouched();
        }
    }

    private void isNotTouchedObserver() {
        for (ObserverColorChanger observerColorChanger : this.observerColorChangers) {
            observerColorChanger.isNotTouched();
        }
    }

    public void movePlayer(int pressedKey) {
        if (pressedKey == 205) {
            this.movementDirection = DIRECTION.RIGHT;
        } else if (pressedKey == 200) {
            this.movementDirection = DIRECTION.UP;
        } else if (pressedKey == 203) {
            this.movementDirection = DIRECTION.LEFT;
        } else if (pressedKey == 208) {
            this.movementDirection = DIRECTION.DOWN;
        }
    }

    @Override
    public void onKeyPressed(int key) {
        movePlayer(key);
        System.out.println(key);
        System.out.println("noob");
    }
}
