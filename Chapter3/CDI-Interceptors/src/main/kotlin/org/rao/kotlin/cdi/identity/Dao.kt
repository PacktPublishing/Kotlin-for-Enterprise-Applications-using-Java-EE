package org.rao.kotlin.cdi.identity

import javax.annotation.Resource

class Dao {
    @Resource(name ="myDataSource")
    private lateinit var dataSource: javax.sql.DataSource
}
