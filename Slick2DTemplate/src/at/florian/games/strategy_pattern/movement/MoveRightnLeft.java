package at.florian.games.strategy_pattern.movement;

import at.florian.games.first_game.Oval;

public class MoveRightnLeft implements MovementStrategy{
    private float x,y,speed;
    private enum DIRECTION {RIGHT, LEFT};
    private DIRECTION movementDirection;

    public MoveRightnLeft(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.movementDirection = DIRECTION.RIGHT;
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
        if (this.movementDirection == DIRECTION.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x > 800 - width * 2) {
                this.movementDirection = DIRECTION.LEFT;
            }
        } else if (this.movementDirection == DIRECTION.LEFT) {
            this.x -= (float) delta / this.speed;
            if (this.x < 0 + width) {
                this.movementDirection = DIRECTION.RIGHT;
            }
        }
    }
}
