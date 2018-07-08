package org.rao.kotlin.cdi.resource

import javax.annotation.Resource

class Dao {
    @Resource(name ="myDataSource")
    private lateinit var dataSource: javax.sql.DataSource
}
