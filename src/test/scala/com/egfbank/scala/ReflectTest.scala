package com.egfbank.scala

import scala.reflect.runtime.{universe => ru}

/**
 * @author huxp
 */
object ReflectTest {
  
  def main(args: Array[String]): Unit = {
   val m =  ru.runtimeMirror(getClass.getClassLoader)
  }
}