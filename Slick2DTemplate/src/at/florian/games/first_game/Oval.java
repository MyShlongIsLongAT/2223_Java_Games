package at.florian.games.first_game;

import org.newdawn.slick.Graphics;

public class Oval implements Actor {

    private enum DIRECTION {RIGHT, LEFT}

    ;
    private float x;
    private float y;
    private float width;
    private float height;
    private DIRECTION movementDirection;
    private float speed;

    public Oval(float x, float y, float width, float height, float speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.movementDirection = DIRECTION.RIGHT;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.width, this.height);
    }

    @Override
    public void update(int delta) {
        if (this.movementDirection == DIRECTION.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x > 800 - this.width * 2) {
                this.movementDirection = DIRECTION.LEFT;
            }
        } else if (this.movementDirection == DIRECTION.LEFT) {
            this.x -= (float) delta / this.speed;
            if (this.x < 0 + this.width) {
                this.movementDirection = DIRECTION.RIGHT;
            }
        }
    }
}