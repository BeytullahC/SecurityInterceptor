

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%--
  Created by IntelliJ IDEA.
  User: 912867
  Date: 16.10.2014
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <style>
            .error {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
            }

            .msg {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #31708f;
                background-color: #d9edf7;
                border-color: #bce8f1;
            }
        </style>

        <meta charset="UTF-8">

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin 2 - Bootstrap Admin Theme</title>

        <!-- Bootstrap Core CSS -->

        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"></link>

        <!-- MetisMenu CSS -->

        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"></link>

        <!-- Custom CSS -->

        <link href="<c:url value="/resources/css/sb-admin-2.css" />" rel="stylesheet"></link>

        <!-- Custom Fonts -->                
        <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet"></link>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
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
                                        <input class="form-control" placeholder="E-mail" name="j_username" type="text" autofocus/>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="j_password" type="password" value=""/>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                        </label>
                                    </div>
                                    <div class="form-group">
                                        <!--<button class="btn btn-primary btn-lg btn-block">Sign In</button>-->
                                        <input class="btn btn-primary btn-lg btn-block"  name="submit" type="submit"
                                               value="Sign In"/>
                                        <span class="pull-right"><a href="#">Register</a></span><span><a href="welcome">Need help?</a></span>
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}"
                                           value="${_csrf.token}" />
                                    </div>
                                    </div>
                                    <div class="modal-footer">
                                        <div class="col-md-12">
                                            <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- jQuery Version 1.11.0 -->
        <script src="<c:url value="/resources/js/jquery-1.11.0.js" />"></script>

        <!-- Bootstrap Core JavaScript -->

        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="<c:url value="/resources/js/plugins/metisMenu/metisMenu.min.js" />"></script>

        <!-- Custom Theme JavaScript -->
        <script src="<c:url value="/resources/js/sb-admin-2.js" />"></script>

    </body>

</html>