package at.florian.games.strategy_pattern.movement;

public interface MovementStrategy {
    public float getX();

    public float getY();

    public void update(int delta, float height, float width);
}
