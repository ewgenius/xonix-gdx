package com.ewgenius.xonix.engine.systems

import com.badlogic.ashley.core.{ComponentMapper, Entity, Family}
import com.badlogic.ashley.systems.IteratingSystem
import com.ewgenius.xonix.engine.components.{TransformComponent, ModelComponent}

class RenderingSystem extends IteratingSystem(Family.all(classOf[TransformComponent], classOf[ModelComponent]).get()) {
  private val transformMapper: ComponentMapper[TransformComponent] = ComponentMapper.getFor(classOf[TransformComponent])
  private val modelMapper: ComponentMapper[ModelComponent] = ComponentMapper.getFor(classOf[ModelComponent])

  override def processEntity(entity: Entity, delta: Float): Unit = {
    val transform: TransformComponent = transformMapper.get(entity)
    val model: ModelComponent = modelMapper.get(entity)
  }
}
