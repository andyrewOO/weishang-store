package com.egfbank.util

import com.egfbank.tfemp.util.HfbkUtil
import java.util.Calendar
import java.text.SimpleDateFormat
import java.util.Date

/**
 * @author andy
 */
object TestTimeDelay {
  def main(args: Array[String]): Unit = {
    val a = createStartTime("230000", "20160621")
    println(a)
  }

  /**
   * hour:启动的时间，为(HHmmSS)
   */
  def getTimtDelay(hour: String) = {
    val nowDate = new Date
    var dateFormatHour: SimpleDateFormat = new SimpleDateFormat("HHmmss")
    val startHour = dateFormatHour.parse(hour)
    val nowHour = dateFormatHour.parse(HfbkUtil.getXmlTime)

    var day = if (startHour.after(nowHour)) HfbkUtil.getXmlToday else HfbkUtil.getTomorrow
    val startTime = day + hour
    var dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss")
    val startDate = dateFormat.parse(startTime)
    startDate.getTime - nowDate.getTime
  }

  /**
   * hour:启动的时间，为(HHmmSS)
   */
  def createStartTime(hour: String, day: String) = {
    val nowDate = new Date
    val startTime = day + hour
  }
}