package at.florian.games.first_game;

import org.newdawn.slick.Graphics;

public class Circle implements Actor {
    private final float x;

    private float y;
    private final float diameter;
    private DIRECTION movementDirection;
    private final float speed;
    public Circle(float x, float y, float diameter, float speed) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.speed = speed;
        this.movementDirection = DIRECTION.DOWN;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
    }

    @Override
    public void update(int delta) {
        if (this.movementDirection == DIRECTION.DOWN) {
            this.y += delta / this.speed;
            if (this.y > 600 - this.diameter * 2) {
                this.movementDirection = DIRECTION.UP;
            }
        } else if (this.movementDirection == DIRECTION.UP) {
            this.y -= delta / this.speed;
            if (this.y < 0 + this.diameter) {
                this.movementDirection = DIRECTION.DOWN;
            }
        }
    }

    private enum DIRECTION {UP, DOWN}
}
