package com.ewgenius.xonix.engine.systems

import com.badlogic.ashley.core.{ComponentMapper, Entity, Family}
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.utils.Array
import com.ewgenius.xonix.engine.components.MessagingComponent
import scala.collection.JavaConversions._

class MessagingSystem extends IteratingSystem(Family.all(classOf[MessagingComponent]).get()) {
  private val messagingQueue: Array[Entity] = new Array[Entity]()
  private val messagingMapper: ComponentMapper[MessagingComponent] = ComponentMapper.getFor(classOf[MessagingComponent])

  override def update(delta: Float): Unit = {
    messagingQueue.foreach(entity => {
      val messaging: MessagingComponent = messagingMapper.get(entity)
      messaging.inQueue.foreach(message => {})
      messaging.outQueue.foreach(message => {})
    })
    messagingQueue.clear()
  }

  override def processEntity(entity: Entity, delta: Float): Unit = {
    messagingQueue.add(entity)
  }
}
