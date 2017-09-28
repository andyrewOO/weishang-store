package com.egfbank.tfemp.actor.services

/**
 * @author andy
 */
object testinsertintoTDH extends TDHDbService with CFCADbService {
  def main(args: Array[String]): Unit = {

//    val items: List[Map[String, String]] = getVerFaild()
//
//    items.foreach { item =>
//      println("idsys" + item.getOrElse("ID", ""))
//    }

    insertIntoCaseReport(Map(
        "APPLICATIONID" -> "2",
        "TRANSSERIALNUMBER" -> "2",
        "XMLCONTENT" -> "2"
    ))
  }
}