package com.ewgenius.xonix

import com.badlogic.gdx.Game
import screens.GameScreen

class XonixGame extends Game {
  override def create: Unit = {
    val gameScreen: GameScreen = new GameScreen(this)

    setScreen(gameScreen)
  }
}
