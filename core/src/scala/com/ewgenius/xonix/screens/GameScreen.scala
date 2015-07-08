package com.ewgenius.xonix.screens

import com.badlogic.gdx.graphics.g3d.utils.CameraInputController
import com.badlogic.gdx.graphics.{OrthographicCamera, PerspectiveCamera, GL20}
import com.badlogic.gdx.{Gdx, ScreenAdapter}
import com.badlogic.gdx.graphics.g3d.ModelBatch
import com.badlogic.ashley.core.Engine
import com.ewgenius.xonix.XonixGame
import com.ewgenius.xonix.engine.systems.{MessagingSystem, BehaviourSystem, MovementSystem, RenderingSystem}
import com.ewgenius.xonix.engine.world.World

class GameScreen(xonixGame: XonixGame) extends ScreenAdapter {
  private val modelBatch: ModelBatch = new ModelBatch()

  private val camera: PerspectiveCamera = new PerspectiveCamera(67, Gdx.graphics.getWidth, Gdx.graphics.getHeight)
  //private val camera: OrthographicCamera = new OrthographicCamera(Gdx.graphics.getWidth, Gdx.graphics.getHeight)
  camera.position.set(10, 10, 10)
  camera.lookAt(0, 0, 0)
  camera.near = 1
  camera.far = 1000
  camera.update()

  private val cameraController: CameraInputController = new CameraInputController(camera)
  private val engine: Engine = new Engine
  private val world: World = new World(engine)

  override def show(): Unit = {
    Gdx.input.setInputProcessor(cameraController)

    engine.addSystem(new RenderingSystem(modelBatch, camera))
    engine.addSystem(new MovementSystem)
    engine.addSystem(new BehaviourSystem)
    engine.addSystem(new MessagingSystem)

    world.createTestEntity()
    world.createField()
  }

  override def render(delta: Float): Unit = {
    Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth, Gdx.graphics.getHeight)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT)

    engine.update(delta)
  }

  override def resize(width: Int, height: Int): Unit = {
    // TODO: resize camera viewport
    //camera.viewportWidth = width
  }

  override def dispose(): Unit = {
  }
}
