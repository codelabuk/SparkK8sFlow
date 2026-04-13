package org.codelabuk.spark

import org.apache.spark.sql.SparkSession

object SparkSessionFactory {
   def create(appName: String): SparkSession = {
     SparkSession.builder()
       .appName(appName)
       .getOrCreate()
   }
}
