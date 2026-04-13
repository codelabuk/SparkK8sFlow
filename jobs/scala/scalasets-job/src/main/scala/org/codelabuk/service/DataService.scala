package org.codelabuk.service

import org.apache.spark.sql.DataFrame

class DataService {
  def process(df: DataFrame): Unit = {
    df.printSchema()
    df.show(10)
    val logicalRDDplan = df.queryExecution.analyzed
    logicalRDDplan.printSchema()
  }
}
