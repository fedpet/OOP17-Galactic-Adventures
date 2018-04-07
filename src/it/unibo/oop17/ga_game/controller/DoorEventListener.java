package it.unibo.oop17.ga_game.controller;

import com.google.common.eventbus.Subscribe;

import it.unibo.oop17.ga_game.model.entities.events.EntityEventListener;
import it.unibo.oop17.ga_game.model.entities.events.FinishedLevelEvent;

class DoorEventListener implements EntityEventListener {
    
    private final MainController mainController;
    
    public DoorEventListener(final MainController mainController) {
        this.mainController = mainController;
    }
    
    @Subscribe
    public void endLevel(final FinishedLevelEvent e) {
        this.mainController.toMenu();
    }
    
}