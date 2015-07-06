package com.ewgenius.xonix.engine.systems

import com.badlogic.ashley.core.{ComponentMapper, Entity, Family}
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.g3d.{Environment, ModelBatch}
import com.ewgenius.xonix.engine.components.{TransformComponent, ModelComponent}
import com.badlogic.gdx.utils.Array
import scala.collection.JavaConversions._

class RenderingSystem(modelBatch: ModelBatch, camera: Camera) extends IteratingSystem(Family.all(classOf[TransformComponent], classOf[ModelComponent]).get()) {
  private val transformMapper: ComponentMapper[TransformComponent] = ComponentMapper.getFor(classOf[TransformComponent])
  private val modelMapper: ComponentMapper[ModelComponent] = ComponentMapper.getFor(classOf[ModelComponent])
  private val renderQueue: Array[Entity] = new Array[Entity]()
  private val environment: Environment = new Environment

  override def update(delta: Float): Unit = {
    super.update(delta)

    camera.update()
    modelBatch.begin(camera)

    renderQueue.foreach(entity => {
      val transform: TransformComponent = transformMapper.get(entity)
      val model: ModelComponent = modelMapper.get(entity)
      model.modelInstance.transform.set(transform.position, transform.orientation, transform.scale)
      modelBatch.render(model.modelInstance)
    })

    modelBatch.end()
    renderQueue.clear()
  }

  override def processEntity(entity: Entity, delta: Float): Unit = {
    renderQueue.add(entity)
  }
}
