package net.dimkonko.vkmlj.controllers;

/**
 * Used in Controllers to initialize before switch to scene with this controller
 * Used in {@link net.dimkonko.vkmlj.scene.ControllableScene}
 */
public interface Changeable {
    void beforeChange();
}
