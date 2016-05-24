package me.urielsalis.RPGGame.base.game;

import me.urielsalis.RPGGame.base.engine.GameObject;
import me.urielsalis.RPGGame.base.gameobject.Player;
import me.urielsalis.RPGGame.base.gameobject.item.Cube;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

/**
 * @author urielsalis
 */
public class Game {
    private ArrayList<GameObject> objects;
    private ArrayList<GameObject> remove;
    private Player player;

    public Game() {
        objects = new ArrayList<GameObject>();
        remove = new ArrayList<GameObject>();

        player = new Player(Display.getWidth() / 2 - Player.SIZE / 2, Display.getHeight() / 2 - Player.SIZE / 2);

        objects.add(player);
        objects.add(new Cube(32, 32, player));
    }

    public void getInput() {
        player.getInput();
    }

    public void update() {

        for(GameObject go: objects)
            if(!go.getRemove())
                go.update();
            else
                remove.add(go);

        if(!remove.isEmpty())
            for(GameObject go: remove) {
                objects.remove(go);
            }
    }

    public void render() {
        for(GameObject go: objects)
            go.render();
    }
}
