package org.codelabuk.examples

import org.apache.spark.sql.SparkSession

object HelloSpark extends Serializable {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Hello Spark").master("local[3]").getOrCreate()
    spark.stop()

  }
}
