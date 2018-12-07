package org.rao.kotlin.javaee.servletexample

import javax.inject.Inject
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "home", value = "/home")
class HomeController @Inject constructor(
        private val statelessEjb: StatelessEjb): HttpServlet() {

    //@Inject
   // private var statelessEjb: StatelessEjb? = null

//    private var statelessEjb: StatelessEjb = StatelessEjb()

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        response.writer.write("<html><body><h2>${statelessEjb.hello(request.getParameter("loginId"))}</h2></body></html>")
    }
}

