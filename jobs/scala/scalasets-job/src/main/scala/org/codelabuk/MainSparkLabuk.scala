package org.codelabuk

import org.codelabuk.config.AppConfigLoader
import org.codelabuk.repository.{CsvRepository, DataRepository}
import org.codelabuk.service.DataService
import org.codelabuk.spark.SparkSessionFactory

object MainSparkLabuk {

  def main(args: Array[String]): Unit = {
    val config = AppConfigLoader.load()
    val spark = SparkSessionFactory.create(config.appName)
    val repository: DataRepository = new CsvRepository(spark, config.inputPath)
    val service = new DataService
    service.process(repository.load())
  }

}
