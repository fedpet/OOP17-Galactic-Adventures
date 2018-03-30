package it.unibo.oop17.ga_game.view.entities;

import it.unibo.oop17.ga_game.model.entities.Door;
import it.unibo.oop17.ga_game.model.entities.components.TriggerState;
import javafx.geometry.Dimension2D;
import javafx.scene.Group;
import javafx.scene.image.Image;

/**
 * Models a {@link Door} view.
 */
public class DoorView extends AbstractStateChangingEntityView<TriggerState> implements TriggerEntityView {
    private static final int WIDTH = 130, HEIGHT = 203;

    /**
     * @param group
     *            The @Group in which the door view is added.
     * @param open
     *            The initial state of the door (open or closed) to represent.
     */
    public DoorView(final Group group, final boolean open) {
        super(group, new Dimension2D(WIDTH, HEIGHT));

        mapAnimation(TriggerState.ON, justAnImage(new Image("/door_open.png")));
        mapAnimation(TriggerState.OFF, justAnImage(new Image("/door_closed.png")));

        if (open) {
            startAnimation(TriggerState.ON);
        } else {
            startAnimation(TriggerState.OFF);
        }
    }
}