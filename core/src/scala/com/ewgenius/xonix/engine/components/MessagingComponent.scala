package com.ewgenius.xonix.engine.components

import com.badlogic.ashley.core.Component
import com.ewgenius.xonix.engine.messaging.Message

import scala.collection.mutable

class MessagingComponent(name:String) extends Component {
  val outQueue: mutable.Queue[Message] = new mutable.Queue[Message]
  val inQueue: mutable.Queue[Message] = new mutable.Queue[Message]
}
