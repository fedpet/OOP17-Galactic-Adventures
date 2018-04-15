package it.unibo.oop17.ga_game.model.entities;

import static com.google.common.base.Predicates.alwaysTrue;

import it.unibo.oop17.ga_game.model.entities.components.EntityPersonality;
import it.unibo.oop17.ga_game.model.entities.components.MeleeWeapon;
import it.unibo.oop17.ga_game.model.entities.components.ViolentBrain;
import it.unibo.oop17.ga_game.model.physics.BodyBuilder;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

/**
 * Models a group of spikes that damage the player at contact.
 */
public class Spikes extends AbstractEntity {
    private static final Dimension2D SIZE = new Dimension2D(0.8, 1.5);
    private static final double ATTACK_KNOCKBACK = 20;

    /**
     * 
     * @param bodyBuilder
     *            the @BodyBuilder.
     * @param position
     *            Its position (relative to its center).
     */
    public Spikes(final BodyBuilder bodyBuilder, final Point2D position) {
        super(bodyBuilder
                .position(position)
                .size(SIZE)
                .moveable(false)
                .build());
        add(new ViolentBrain(EntityPersonality.EVIL));
        add(new MeleeWeapon(1, 0, ATTACK_KNOCKBACK, alwaysTrue()));
    }

    @Override
    public final String toString() {
        return "Spikes";
    }

}
