package org.codelabuk.repository

import org.apache.spark.sql.DataFrame

trait DataRepository {
    def load(): DataFrame
}
