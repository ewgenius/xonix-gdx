package com.ewgenius.xonix.engine.graphics

import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Uniform
import com.badlogic.gdx.graphics.{GL20, Camera}
import com.badlogic.gdx.graphics.g3d.utils.RenderContext
import com.badlogic.gdx.graphics.g3d.{Renderable, Shader}
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader

class TestShader extends BaseShader {
  val u_projTrans: Int = register(new Uniform("u_projTrans"))
  val u_worldTrans: Int = register(new Uniform("u_projTrans"))
  val u_color: Int = register(new Uniform("u_projTrans"))

  override def init(): Unit = super.init(program, null)

  override def begin(camera:Camera, context:RenderContext): Unit = {
    program.begin()
    context.setDepthTest(GL20.GL_LEQUAL, 0f, 1f)
    context.setDepthMask(true)
  }

  override def compareTo(other: Shader): Int = 0

  override def canRender(instance: Renderable): Boolean = true


}
