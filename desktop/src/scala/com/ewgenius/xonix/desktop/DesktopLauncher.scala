package com.ewgenius.xonix.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.ewgenius.xonix.XonixGame

object DesktopLauncher {
  def main(arg: Array[String]) {
    val config: LwjglApplicationConfiguration = new LwjglApplicationConfiguration
    config.width = 1024
    config.height = 600
    new LwjglApplication(new XonixGame, config)
  }
}

