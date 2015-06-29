package com.ewgenius.xonix.screens

import com.badlogic.gdx.graphics.g3d.utils.CameraInputController
import com.badlogic.gdx.graphics.{PerspectiveCamera, GL20}
import com.badlogic.gdx.{Gdx, ScreenAdapter}
import com.badlogic.ashley.core.Engine
import com.ewgenius.xonix.XonixGame
import com.ewgenius.xonix.engine.World
import com.ewgenius.xonix.engine.systems.RenderingSystem

class GameScreen(xonixGame: XonixGame) extends ScreenAdapter {
  private val camera: PerspectiveCamera = new PerspectiveCamera(67, Gdx.graphics.getWidth, Gdx.graphics.getHeight)
  camera.position.set(10, 10, 10)
  camera.lookAt(0, 0, 0)
  camera.near = 1
  camera.far = 1000
  camera.update()

  private val cameraController: CameraInputController = new CameraInputController(camera)
  Gdx.input.setInputProcessor(cameraController)

  private val engine: Engine = new Engine
  engine.addSystem(new RenderingSystem)

  private val world: World = new World(engine)
  world.createTestEntity()

  override def render(delta: Float): Unit = {
    Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth, Gdx.graphics.getHeight)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT)

    engine.update(delta)
  }

  override def dispose(): Unit = {
  }
}
