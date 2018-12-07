package org.rao.kotlin.rest.security.organization.context

import org.rao.kotlin.rest.organization.dao.OrganizationDao
import org.rao.kotlin.rest.organization.service.OrganizaionService
import org.rao.kotlin.rest.security.organization.filter.CallBackHandlerImpl
import org.rao.kotlin.rest.security.organization.filter.MyIdentityStore
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
