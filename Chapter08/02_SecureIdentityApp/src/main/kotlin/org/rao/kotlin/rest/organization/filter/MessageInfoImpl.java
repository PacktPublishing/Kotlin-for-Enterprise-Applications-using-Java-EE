package org.rao.kotlin.rest.organization.filter;

import java.io.*;
import java.security.*;
import java.util.*;
import javax.security.auth.message.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MessageInfoImpl implements MessageInfo {
  public Object getRequestMessage () {

    return new HttpServletRequest () {
      public String getAuthType () {

        return null;
      }

      public Cookie[] getCookies () {

        return new Cookie[0];
      }

      public long getDateHeader (String s) {

        return 0;
      }

      public String getHeader (String s) {

        return null;
      }

      public Enumeration<String> getHeaders (String s) {

        return null;
      }

      public Enumeration<String> getHeaderNames () {

        return null;
      }

      public int getIntHeader (String s) {

        return 0;
      }

      public String getMethod () {

        return null;
      }

      public String getPathInfo () {

        return null;
      }

      public String getPathTranslated () {

        return null;
      }

      public String getContextPath () {

        return null;
      }

      public String getQueryString () {

        return null;
      }

      public String getRemoteUser () {

        return null;
      }

      public boolean isUserInRole (String s) {

        return false;
      }

      public Principal getUserPrincipal () {

        return null;
      }

      public String getRequestedSessionId () {

        return null;
      }

      public String getRequestURI () {

        return null;
      }

      public StringBuffer getRequestURL () {

        return null;
      }

      public String getServletPath () {

        return null;
      }

      public HttpSession getSession (boolean b) {

        return null;
      }

      public HttpSession getSession () {

        return null;
      }

      public String changeSessionId () {

        return null;
      }

      public boolean isRequestedSessionIdValid () {

        return false;
      }

      public boolean isRequestedSessionIdFromCookie () {

        return false;
      }

      public boolean isRequestedSessionIdFromURL () {

        return false;
      }

      public boolean isRequestedSessionIdFromUrl () {

        return false;
      }

      public boolean authenticate (HttpServletResponse httpServletResponse)
          throws IOException, ServletException {

        return false;
      }

      public void login (String s, String s1) throws ServletException {

      }

      public void logout () throws ServletException {

      }

      public Collection<Part> getParts () throws IOException, ServletException {

        return null;
      }

      public Part getPart (String s) throws IOException, ServletException {

        return null;
      }

      public <T extends HttpUpgradeHandler> T upgrade (Class<T> aClass)
          throws IOException, ServletException {

        return null;
      }

      public Object getAttribute (String s) {

        return null;
      }

      public Enumeration<String> getAttributeNames () {

        return null;
      }

      public String getCharacterEncoding () {

        return null;
      }

      public void setCharacterEncoding (String s) throws UnsupportedEncodingException {

      }

      public int getContentLength () {

        return 0;
      }

      public long getContentLengthLong () {

        return 0;
      }

      public String getContentType () {

        return null;
      }

      public ServletInputStream getInputStream () throws IOException {

        return null;
      }

      public String getParameter (String s) {

        return null;
      }

      public Enumeration<String> getParameterNames () {

        return null;
      }

      public String[] getParameterValues (String s) {

        return new String[0];
      }

      public Map<String, String[]> getParameterMap () {

        return null;
      }

      public String getProtocol () {

        return null;
      }

      public String getScheme () {

        return null;
      }

      public String getServerName () {

        return null;
      }

      public int getServerPort () {

        return 0;
      }

      public BufferedReader getReader () throws IOException {

        return null;
      }

      public String getRemoteAddr () {

        return null;
      }

      public String getRemoteHost () {

        return null;
      }

      public void setAttribute (String s, Object o) {

      }

      public void removeAttribute (String s) {

      }

      public Locale getLocale () {

        return null;
      }

      public Enumeration<Locale> getLocales () {

        return null;
      }

      public boolean isSecure () {

        return false;
      }

      public RequestDispatcher getRequestDispatcher (String s) {

        return null;
      }

      public String getRealPath (String s) {

        return null;
      }

      public int getRemotePort () {

        return 0;
      }

      public String getLocalName () {

        return null;
      }

      public String getLocalAddr () {

        return null;
      }

      public int getLocalPort () {

        return 0;
      }

      public ServletContext getServletContext () {

        return null;
      }

      public AsyncContext startAsync () throws IllegalStateException {

        return null;
      }

      public AsyncContext startAsync (
          ServletRequest servletRequest, ServletResponse servletResponse)
          throws IllegalStateException {

        return null;
      }

      public boolean isAsyncStarted () {

        return false;
      }

      public boolean isAsyncSupported () {

        return false;
      }

      public AsyncContext getAsyncContext () {

        return null;
      }

      public DispatcherType getDispatcherType () {

        return null;
      }
    };
  }

  public Object getResponseMessage () {

    return null;
  }

  public void setRequestMessage (Object o) {

  }

  public void setResponseMessage (Object o) {

  }

  public Map getMap () {

    return null;
  }
}
