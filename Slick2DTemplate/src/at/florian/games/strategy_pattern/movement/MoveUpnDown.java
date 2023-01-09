package at.florian.games.strategy_pattern.movement;

public class MoveUpnDown implements MovementStrategy {
    private float x, y, speed;

    private enum DIRECTION {UP, DOWN}

    private DIRECTION movementDirection;

    public MoveUpnDown(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.movementDirection = DIRECTION.DOWN;
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
        if (this.movementDirection == DIRECTION.DOWN) {
            this.y += delta / this.speed;
            if (this.y > 600 - height * 2) {
                this.movementDirection = DIRECTION.UP;
            }
        } else if (this.movementDirection == DIRECTION.UP) {
            this.y -= delta / this.speed;
            if (this.y < 0 + height) {
                this.movementDirection = DIRECTION.DOWN;
            }
        }

    }
}
