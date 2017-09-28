package com.egfbank.util

import com.egfbank.tfemp.util.HfbkUtil
import java.text.SimpleDateFormat

/**
 * @author andy
 */
object TestTime {
  def main(args: Array[String]): Unit = {
    val a = dateFormat("20120921")
    println(a)
  }

  def dateFormat(day: String) = {
    var df: SimpleDateFormat = new SimpleDateFormat("yyyyMMdd")
    val date = df.parse(day)
    val format: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    format.format(date)
  }
}