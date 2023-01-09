package at.florian.games.first_game;

import org.newdawn.slick.Graphics;

public class Rectangle implements Actor {
    private DIRECTION movementDirection;

    private float x;
    private float y;
    private final int width;
    private final int height;
    private final float speed;
    public Rectangle(float x, float y, int width, int height, float speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.movementDirection = DIRECTION.RIGHT;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, this.width, this.height);
    }

    @Override
    public void update(int delta) {
        if (this.movementDirection == DIRECTION.RIGHT) {
            this.x += delta / this.speed;
            if (this.x > 800 - this.width * 2) {
                this.movementDirection = DIRECTION.DOWN;
            }
        } else if (this.movementDirection == DIRECTION.DOWN) {
            this.y += delta / this.speed;
            if (this.y > 600 - this.height * 2) {
                this.movementDirection = DIRECTION.LEFT;
            }
        } else if (this.movementDirection == DIRECTION.LEFT) {
            this.x -= delta / this.speed;
            if (this.x < this.width) {
                this.movementDirection = DIRECTION.UP;
            }
        } else {
            this.y -= delta / this.speed;
            if (this.y < this.height) {
                this.movementDirection = DIRECTION.RIGHT;
            }
        }
    }

    private enum DIRECTION {RIGHT, LEFT, UP, DOWN}
}

