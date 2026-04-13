package org.codelabuk.config

import com.typesafe.config.ConfigFactory

case class AppConfig(appName: String, inputPath: String)

object AppConfigLoader {
  def load(): AppConfig = {
    val config = ConfigFactory.load()
    AppConfig(
      appName = config.getString("app.name"),
      inputPath = config.getString("app.file.inputPath")
    )
  }
}
