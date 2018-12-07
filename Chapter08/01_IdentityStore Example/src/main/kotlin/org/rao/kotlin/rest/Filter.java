package org.rao.kotlin.rest;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter (filterName = "Filter") public class Filter
    implements javax.servlet.Filter {
  public void destroy () {

  }

  public void doFilter (
      ServletRequest req,
      ServletResponse resp,
      FilterChain chain) throws ServletException, IOException {

    chain.doFilter (req, resp);
  }

  public void init (FilterConfig config) throws ServletException {

  }

}
