package it.unibo.oop17.ga_game.model.entities.components;

import com.google.common.eventbus.Subscribe;

import it.unibo.oop17.ga_game.model.KeyLockType;
import it.unibo.oop17.ga_game.model.entities.events.BeginContactEvent;

public class LockBrain extends AbstractBrain {

    private final KeyLockType type;

    public LockBrain(final KeyLockType type) {
        this.type = type;
    }

    @Subscribe
    public void beginContact(final BeginContactEvent contact) {
        contact.getOtherBody().getOwner().ifPresent(otherEntity -> {
            otherEntity.get(Inventory.class).ifPresent(inv -> {
                if (inv.getKeysBunch().contains(type)) {
                    getEntity().destroy();
                }
            });
        });
    }

    public KeyLockType getType() {
        return type;
    }

    @Override
    public Personality getPersonality() {
        return EntityPersonality.NONE;
    }

}