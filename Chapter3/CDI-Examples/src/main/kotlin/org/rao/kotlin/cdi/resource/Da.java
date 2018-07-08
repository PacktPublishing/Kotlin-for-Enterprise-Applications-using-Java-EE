package org.rao.kotlin.cdi.resource;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class Da {
    private DataSource dataSource;

    @Resource(name ="myDataBase")
    private void setDataSource(javax.sql.DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
