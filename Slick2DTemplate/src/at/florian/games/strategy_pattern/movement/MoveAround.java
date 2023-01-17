package at.florian.games.strategy_pattern.movement;

public class MoveAround implements MovementStrategy {
    private float x,y,speed;
    private enum DIRECTION {RIGHT, LEFT, UP, DOWN};
    private DIRECTION movementDirection;

    public MoveAround(float x, float y, float speed) {
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
            this.x += delta / this.speed;
            if (this.x > 800 - width * 2) {
                this.movementDirection = DIRECTION.DOWN;
            }
        } else if (this.movementDirection == DIRECTION.DOWN) {
            this.y += delta / this.speed;
            if (this.y > 600 - height * 2) {
                this.movementDirection = DIRECTION.LEFT;
            }
        } else if (this.movementDirection == DIRECTION.LEFT) {
            this.x -= delta / this.speed;
            if (this.x < width) {
                this.movementDirection = DIRECTION.UP;
            }
        } else {
            this.y -= delta / this.speed;
            if (this.y < height) {
                this.movementDirection = DIRECTION.RIGHT;
            }
        }
    }
}
