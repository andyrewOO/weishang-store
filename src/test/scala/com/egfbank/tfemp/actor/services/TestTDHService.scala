package com.egfbank.tfemp.actor.services

/**
 * @author andy
 */
object TestTDHService extends TDHDbService{
  def main(args: Array[String]): Unit = {
    val t100403 = queryT100403()
    println("t100403:" + t100403)
  }
}