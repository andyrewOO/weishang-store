package com.egfbank.tfemp.actor.worker.module

import xitrum.util.Loader

/**
 * @author andy
 */
object TestPro {
  def main(args: Array[String]): Unit = {
    val scanDownQueue = Loader.propertiesFromClasspath("tfemp.properties").getProperty("adb")
    if(scanDownQueue == null) println("sss")
  }
}