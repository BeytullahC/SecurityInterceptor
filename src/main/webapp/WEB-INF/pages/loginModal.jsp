<%-- 
    Document   : loginModal
    Created on : Oct 21, 2014, 1:15:32 PM
    Author     : 912867
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<div class="login-panel panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Please Sign In</h3>
    </div>
    <div>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="alert alert-success">${msg}</div>
        </c:if>
    </div>
    <div class="panel-body">
        <form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
            <fieldset>
                <div class="form-group">
                    <input class="form-control" placeholder="E-mail" name="username" type="text" autofocus>
                </div>
                <div class="form-group">
                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                </div>
                <div class="checkbox">
                    <label>
                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                    </label>
                </div>
                <div class="form-group">
                    <!--<button class="btn btn-primary btn-lg btn-block">Sign In</button>-->
                    <input class="btn btn-primary btn-lg btn-block" name="submit" type="submit"
                           value="Sign In"/>
                    <span class="pull-right"><a href="#">Register</a></span><span><a href="welcome">Need help?</a></span>
                </div>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
                <div class="modal-footer">
                    <div class="col-md-12">
                        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>

