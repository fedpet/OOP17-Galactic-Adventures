package it.unibo.oop17.ga_game.model.entities.components;

import it.unibo.oop17.ga_game.utils.PositionCompare;
import javafx.geometry.Point2D;
import javafx.geometry.Side;

public class SlimeEnemyBrain extends ViolentBrain {

    public SlimeEnemyBrain() {
        super(EntityPersonality.EVIL);
    }

    @Override
    public void update(final double dt) {
        super.update(dt);
        checkPath();
    }

    private void checkPath() {
        getEntity().getBody().getContacts()
                .map(other -> PositionCompare.relativeSide(getEntity().getBody(), other))
                .filter(Side::isVertical)
                .findAny()
                .ifPresent(this::pathIsBlocked);
    }

    private void pathIsBlocked(final Side side) {
        final Point2D newDirection = PositionCompare.sideToDirection(side).multiply(-1);

        final Point2D dir = new Point2D(newDirection.getX(), 0);
        if (!newDirection.equals(Point2D.ZERO)) {
            getEntity().get(MovementComponent.class).ifPresent(movement -> {
                movement.move(dir);
            });
        }
    }
}
