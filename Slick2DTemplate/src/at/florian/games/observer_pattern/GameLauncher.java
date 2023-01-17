package at.florian.games.observer_pattern;

import at.florian.games.first_game.Actor;
import at.florian.games.observer_pattern.actors.Player;
import at.florian.games.observer_pattern.movement.MoveByKeys;
import at.florian.games.strategy_pattern.actors.Circle;
import at.florian.games.strategy_pattern.actors.Rectangle;
import at.florian.games.strategy_pattern.movement.MoveAround;
import at.florian.games.strategy_pattern.movement.MovementStrategy;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class GameLauncher extends BasicGame {
    private List<Actor> actors;
    private List<ObserverKeyListener> observerKeyListeners = new ArrayList<>();

    public GameLauncher(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        MovementStrategy moveAround = new MoveAround(100, 100, 0.8f);
        MoveByKeys moveByKeys = new MoveByKeys(100, 100);

        this.observerKeyListeners.add(moveByKeys);

        this.actors = new ArrayList<Actor>();

        Player player = new Player(50,50,moveByKeys);
        Rectangle rectangle1 = new Rectangle(50, 100, moveAround);

        moveByKeys.addItemColorChanger(rectangle1);

        this.actors.add(player);
        this.actors.add(rectangle1);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }
    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);
        for (ObserverKeyListener observerKeyListener : observerKeyListeners) {
            observerKeyListener.onKeyPressed(key);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new GameLauncher("Fortnite-4K"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
