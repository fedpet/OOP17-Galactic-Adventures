package it.unibo.oop17.ga_game.controller;

import it.unibo.oop17.ga_game.view.MenuView;

/**
 * Main Menu controller interface.
 */
public interface MenuObserver {
    
    /**
     * Starts new Game.
     */
    void newGame();
    
    /**
     * Resumes saved game.
     */
    void continueGame();
    
    /**
     * Quits from the game.
     */
    void quit();
    
    /**
     * Sets next volume value for Music.
     */
    void nextMusicVolume();
    
    /**
     * Sets next volume value for SFX.
     */
    void nextSFXVolume();
    
    /**
     * Sets next difficulty value.
     */
    void nextDifficulty();
    
    /**
     * Sets next language value.
     */
    void nextLanguage();
    
    /**
     * Updates text with chosen language.
     */
    void updateLanguage();
    
    /**
     * Sets Options to default.
     */
    void setDefaults();
    
    /**
     * Updates view.
     */
    void updateView();

    /**
     * @return view
     */
    MenuView getView();

}
