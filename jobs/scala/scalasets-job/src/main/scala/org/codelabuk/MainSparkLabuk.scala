package org.codelabuk

import org.apache.spark.sql.SparkSession

object MainSparkLabuk {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Sellers-City").getOrCreate()
    val df = spark.read.option("header","true")
      .csv("s3a://data/csv/sellers/")
    df.printSchema()
    df.show(10)
  }

}
