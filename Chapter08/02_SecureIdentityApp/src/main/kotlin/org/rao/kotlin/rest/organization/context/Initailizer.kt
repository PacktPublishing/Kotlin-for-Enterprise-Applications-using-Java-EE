package org.rao.kotlin.rest.organization.context

import org.rao.kotlin.rest.organization.dao.OrganizationDao
import org.rao.kotlin.rest.organization.filter.CallBackHandlerImpl
import org.rao.kotlin.rest.organization.filter.MyIdentityStore
import org.rao.kotlin.rest.organization.service.OrganizaionService
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces
import javax.security.auth.callback.CallbackHandler

@ApplicationScoped
public class Initializer {
    @Produces
    public fun organizaionService(): OrganizaionService {
        return OrganizaionService()
    }

    @Produces
    public fun organizaionDao(): OrganizationDao {
        return OrganizationDao()
    }

    @Produces
    public fun myIdentityStore(): MyIdentityStore {
        return MyIdentityStore()
    }

    @Produces
    public fun callbackHandler(): CallbackHandler {
        return CallBackHandlerImpl()
    }


}
