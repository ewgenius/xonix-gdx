package com.ewgenius.xonix.engine.systems

import com.badlogic.ashley.core.{ComponentMapper, Entity, Family}
import com.badlogic.ashley.systems.IteratingSystem
import com.ewgenius.xonix.engine.components.BehaviourComponent


class BehaviourSystem extends IteratingSystem(Family.all(classOf[BehaviourComponent]).get()) {
  private val behaviourMapper: ComponentMapper[BehaviourComponent] = ComponentMapper.getFor(classOf[BehaviourComponent])

  override def processEntity(entity: Entity, delta: Float): Unit = {
    val behaviour: BehaviourComponent = behaviourMapper.get(entity)

    behaviour.behaviour.update(delta)
  }
}
