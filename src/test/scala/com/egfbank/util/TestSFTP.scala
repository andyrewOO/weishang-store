package com.egfbank.util

import com.egfbank.tfemp.actor.services.TDHService

/**
 * @author andy
 */
object TestSFTP extends TDHService {
  def main(args: Array[String]): Unit = {
    //    val a = SFTPChannel.getChannel()
    //    a.mkdir("/home/b")
    
    val sql = "select * from acc_trans_info"
    val a = queryTDH(sql, Seq())
    println(a.length)
  }
}