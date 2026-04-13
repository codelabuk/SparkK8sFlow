package org.codelabuk.repository

import org.apache.spark.sql.{DataFrame, SparkSession}

class CsvRepository(spark: SparkSession, inputPath: String) extends DataRepository {

  override def load(): DataFrame = {
    spark.read.option("header", "true")
      .option("inferSchema", "true")
      .csv(inputPath)
  }
}
