

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

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="//code.ionicframework.com/ionicons/1.5.2/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<!-- Morris chart -->
<link href="<c:url value="/resources/css/morris/morris.css"/>" rel="stylesheet" type="text/css" />
<!-- jvectormap -->
<link
	href="<c:url value="/resources/css/jvectormap/jquery-jvectormap-1.2.2.css"/>" rel="stylesheet" type="text/css" />
<!-- Date Picker -->
<link
	href="<c:url value="/resources/css/datepicker/datepicker3.css"/>" rel="stylesheet" type="text/css" />
<!-- Daterange picker -->
<link
	href="<c:url value="/resources/css/daterangepicker/daterangepicker-bs3.css"/>" rel="stylesheet" type="text/css" />
<!-- bootstrap wysihtml5 - text editor -->
<link
	href="<c:url value="/resources/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"/>" rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="<c:url value="/resources/css/AdminLTE.css"/>" rel="stylesheet" type="text/css"/>

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

       <!-- jQuery 2.0.2 -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="//code.jquery.com/ui/1.11.1/jquery-ui.min.js" type="text/javascript"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js" type="text/javascript"></script>
	
	<!-- Morris.js charts -->
	<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="<c:url value="/resources/js/plugins/morris/morris.min.js"/>"> type="text/javascript"></script>
	
	<!-- Sparkline -->
	<script	src="<c:url value="/resources/js/plugins/sparkline/jquery.sparkline.min.js"/>"> type="text/javascript"></script>
	
	<!-- jvectormap -->
	<script src="<c:url value="/resources/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/>"> type="text/javascript"></script>
	<script src="<c:url value="/resources/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/>"> type="text/javascript"></script>
	
	<!-- jQuery Knob Chart -->
	<script src="<c:url value="/resources/js/plugins/jqueryKnob/jquery.knob.js"/>"> type="text/javascript"></script>
	
	<!-- daterangepicker -->
	<script src="<c:url value="/resources/js/plugins/daterangepicker/daterangepicker.js"/>"> type="text/javascript"></script>
	
	<!-- datepicker -->
	<script src="<c:url value="/resources/js/plugins/datepicker/bootstrap-datepicker.js"/>"> type="text/javascript"></script>
	
	<!-- Bootstrap WYSIHTML5 -->
	<script src="<c:url value="/resources/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"/>"> type="text/javascript"></script>
	
	<!-- iCheck -->
	<script src="<c:url value="/resources/js/plugins/iCheck/icheck.min.js"/>"> type="text/javascript"></script>

	<!-- AdminLTE App -->
	<script src="<c:url value="/resources/js/AdminLTE/app.js"/>"> type="text/javascript"></script>

	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="<c:url value="/resources/js/AdminLTE/dashboard.js"/>"> type="text/javascript"></script>

	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value="/resources/js/AdminLTE/demo.js"/>"> type="text/javascript"></script>

    </body>

</html>