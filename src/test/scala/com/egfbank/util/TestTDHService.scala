package com.egfbank.util

import com.egfbank.tfemp.actor.services.TDHService

/**
 * @author andy
 */
object TestTDHService extends TDHService {
  def main(args: Array[String]) = {
    val sql = "select * from acc_trans_info"
    queryTDH(sql, Seq())
  }
}