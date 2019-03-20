package com.frostbite.core.interfaces;

public interface GameElement {

    void onUpdate(int tick);

    void onInit();

    void onDispose();
}
