package org.rao.kotlin.javaee.servletexample

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "home", value = "/home")
class HomeController : HttpServlet() {
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        response.writer.write("<html><body><h2>Welcome ${request.getParameter("loginId")}</h2></body></html>")
    }
}


