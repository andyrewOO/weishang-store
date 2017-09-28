package com.egfbank.util

import xitrum.Log
import cfca.safeguard.api.bank.bean.tx.upstream.Tx100306

/**
 * @author andy
 */
object TestCFCAUtil extends Log{
  def main(args: Array[String]): Unit = {
    
    test(2) match {
      case a:String =>
        println("a")
      case b:Tx100306 =>
        println("b")
    }
  }
  
  def test(a:Int) = {
    if(a == 1)
      "as"
    else{
    	val tx100306 = new Tx100306
      tx100306
    }
  }
}