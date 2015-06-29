package com.ewgenius.xonix.engine.systems

import com.badlogic.ashley.core.{ComponentMapper, Entity, Family}
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.g3d.ModelBatch
import com.badlogic.gdx.math.Vector3
import com.ewgenius.xonix.engine.components.{MovementComponent, TransformComponent}


class MovementSystem extends IteratingSystem(Family.all(classOf[TransformComponent], classOf[MovementComponent]).get()) {
  private val transformMapper: ComponentMapper[TransformComponent] = ComponentMapper.getFor(classOf[TransformComponent])
  private val movementMapper: ComponentMapper[MovementComponent] = ComponentMapper.getFor(classOf[MovementComponent])

  override def processEntity(entity: Entity, delta: Float): Unit = {
    val transform: TransformComponent = transformMapper.get(entity)
    val movement: MovementComponent = movementMapper.get(entity)

    val temp: Vector3 = new Vector3()
    temp.set(movement.acceleration).scl(delta)
    movement.velocity.add(temp)

    temp.set(movement.velocity).scl(delta)
    transform.position.add(temp)
  }
}
