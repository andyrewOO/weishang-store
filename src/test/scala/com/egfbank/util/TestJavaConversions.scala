package com.egfbank.util

import java.util.Arrays.ArrayList
import java.util.ArrayList
import cfca.safeguard.tx.Account
import scala.collection.JavaConverters

/**
 * @author andy
 */
object TestJavaConversions {
  def main(args: Array[String]): Unit = {
    import scala.collection.JavaConversions
    
    val accountList = new ArrayList[Account]
    val sl = JavaConversions.asScalaBuffer(accountList)
    
    val slist = Map((1,(1,1)),(2,(2,2)))
    val jm = JavaConversions.mapAsJavaMap(slist)
    println("jm:" + jm)
    println("slist:" + slist)
  }
}