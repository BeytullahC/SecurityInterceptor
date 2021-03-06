<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="windows-1254"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
        <%
            response.setHeader("pragma", "no-cache");
        %>
        <%
            response.setHeader("Cache-control",
                    "no-cache, no-store, must-revalidate");
        %>
        <%
            response.setHeader("Expires", "0");
        %>

    <link
        href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
        rel="stylesheet" type="text/css" />
    <link
        href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css"
        rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link
        href="//code.ionicframework.com/ionicons/1.5.2/css/ionicons.min.css"
        rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="<c:url value="/resources/css/morris/morris.css"/>"
          rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link
        href="<c:url value="/resources/css/jvectormap/jquery-jvectormap-1.2.2.css"/>"
        rel="stylesheet" type="text/css" />
    <!-- Date Picker -->
    <link href="<c:url value="/resources/css/datepicker/datepicker3.css"/>"
          rel="stylesheet" type="text/css" />
    <!-- Daterange picker -->
    <link
        href="<c:url value="/resources/css/daterangepicker/daterangepicker-bs3.css"/>"
        rel="stylesheet" type="text/css" />
    <!-- bootstrap wysihtml5 - text editor -->
    <link
        href="<c:url value="/resources/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"/>"
        rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="<c:url value="/resources/css/AdminLTE.css"/>"
          rel="stylesheet" type="text/css" />

    <!-- Ionicons -->
    <link href="//code.ionicframework.com/ionicons/1.5.2/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- DATA TABLES -->
    <link href="<c:url value="/resources/css/datatables/dataTables.bootstrap.css"/>" rel="stylesheet" type="text/css" />

    <!-- jQuery 2.0.2 -->
    <script
    src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="//code.jquery.com/ui/1.11.1/jquery-ui.min.js"
    type="text/javascript"></script>
    <script
        src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"
    type="text/javascript"></script>

    <!-- Morris.js charts -->
    <script
    src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script
    src="<c:url value="/resources/js/plugins/morris/morris.min.js"/>"> type = "text/javascript" ></script>

    <!-- Sparkline -->
    <script
    src="<c:url value="/resources/js/plugins/sparkline/jquery.sparkline.min.js"/>"> type = "text/javascript" ></script>

    <!-- jvectormap -->
    <script
    src="<c:url value="/resources/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/>"> type = "text/javascript" ></script>
    <script
    src="<c:url value="/resources/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/>"> type = "text/javascript" ></script>

    <!-- jQuery Knob Chart -->
    <script
    src="<c:url value="/resources/js/plugins/jqueryKnob/jquery.knob.js"/>"> type = "text/javascript" ></script>

    <!-- daterangepicker -->
    <script
    src="<c:url value="/resources/js/plugins/daterangepicker/daterangepicker.js"/>"> type = "text/javascript" ></script>

    <!-- datepicker -->
    <script
    src="<c:url value="/resources/js/plugins/datepicker/bootstrap-datepicker.js"/>"> type = "text/javascript" ></script>

    <!-- Bootstrap WYSIHTML5 -->
    <script
    src="<c:url value="/resources/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"/>"> type = "text/javascript" ></script>

    <!-- iCheck -->
    <script
    src="<c:url value="/resources/js/plugins/iCheck/icheck.min.js"/>"> type = "text/javascript" ></script>

    <!-- AdminLTE App -->
    <script src="<c:url value="/resources/js/AdminLTE/app.js"/>"> type = "text/javascript" ></script>

    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="<c:url value="/resources/js/AdminLTE/dashboard.js"/>"> type = "text/javascript" ></script>

    <!-- AdminLTE for demo purposes -->
    <script src="<c:url value="/resources/js/AdminLTE/demo.js"/>"> type = "text/javascript" ></script>

    <script src="<c:url value="/resources/js/plugins/datatables/jquery.dataTables.js"/>"> type = "text/javascript" ></script>
    <script src="<c:url value="/resources/js/plugins/datatables/dataTables.bootstrap.js"/>"> type = "text/javascript" ></script>

</head>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/spring-mvc" user="root" password="1234" />
<body class="skin-blue">
    <!-- header logo: style can be found in header.less -->
    <header class="header">
        <a href="index.html" class="logo"> <!-- Add the class icon to your logo image or logo icon to add the margining -->
            AdminLTE
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas"
               role="button"> <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </a>
            <div class="navbar-right">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu"><a href="#"
                                                          class="dropdown-toggle" data-toggle="dropdown"> <i
                                class="fa fa-envelope"></i> <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 4 messages</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li>
                                        <!-- start message --> <a href="#">
                                            <div class="pull-left">
                                                <img src="img/avatar3.png" class="img-circle"
                                                     alt="User Image" />
                                            </div>
                                            <h4>
                                                Support Team <small><i class="fa fa-clock-o"></i> 5
                                                    mins</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a>
                                    </li>
                                    <!-- end message -->
                                    <li><a href="#">
                                            <div class="pull-left">
                                                <img src="img/avatar2.png" class="img-circle"
                                                     alt="user image" />
                                            </div>
                                            <h4>
                                                AdminLTE Design Team <small><i class="fa fa-clock-o"></i>
                                                    2 hours</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a></li>
                                    <li><a href="#">
                                            <div class="pull-left">
                                                <img src="img/avatar.png" class="img-circle"
                                                     alt="user image" />
                                            </div>
                                            <h4>
                                                Developers <small><i class="fa fa-clock-o"></i>
                                                    Today</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a></li>
                                    <li><a href="#">
                                            <div class="pull-left">
                                                <img src="img/avatar2.png" class="img-circle"
                                                     alt="user image" />
                                            </div>
                                            <h4>
                                                Sales Department <small><i class="fa fa-clock-o"></i>
                                                    Yesterday</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a></li>
                                    <li><a href="#">
                                            <div class="pull-left">
                                                <img src="img/avatar.png" class="img-circle"
                                                     alt="user image" />
                                            </div>
                                            <h4>
                                                Reviewers <small><i class="fa fa-clock-o"></i> 2
                                                    days</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a></li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">See All Messages</a></li>
                        </ul></li>
                    <!-- Notifications: style can be found in dropdown.less -->
                    <li class="dropdown notifications-menu"><a href="#"
                                                               class="dropdown-toggle" data-toggle="dropdown"> <i
                                class="fa fa-warning"></i> <span class="label label-warning">10</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 10 notifications</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li><a href="#"> <i class="ion ion-ios7-people info"></i>
                                            5 new members joined today
                                        </a></li>
                                    <li><a href="#"> <i class="fa fa-warning danger"></i>
                                            Very long description here that may not fit into the page and
                                            may cause design problems
                                        </a></li>
                                    <li><a href="#"> <i class="fa fa-users warning"></i> 5
                                            new members joined
                                        </a></li>

                                    <li><a href="#"> <i class="ion ion-ios7-cart success"></i>
                                            25 sales made
                                        </a></li>
                                    <li><a href="#"> <i class="ion ion-ios7-person danger"></i>
                                            You changed your username
                                        </a></li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">View all</a></li>
                        </ul></li>
                    <!-- Tasks: style can be found in dropdown.less -->
                    <li class="dropdown tasks-menu"><a href="#"
                                                       class="dropdown-toggle" data-toggle="dropdown"> <i
                                class="fa fa-tasks"></i> <span class="label label-danger">9</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 9 tasks</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li>
                                        <!-- Task item --> <a href="#">
                                            <h3>
                                                Design some buttons <small class="pull-right">20%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-aqua"
                                                     style="width: 20%" role="progressbar" aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">20% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                    <li>
                                        <!-- Task item --> <a href="#">
                                            <h3>
                                                Create a nice theme <small class="pull-right">40%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-green"
                                                     style="width: 40%" role="progressbar" aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">40% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                    <li>
                                        <!-- Task item --> <a href="#">
                                            <h3>
                                                Some task I need to do <small class="pull-right">60%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-red"
                                                     style="width: 60%" role="progressbar" aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">60% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                    <li>
                                        <!-- Task item --> <a href="#">
                                            <h3>
                                                Make beautiful transitions <small class="pull-right">80%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-yellow"
                                                     style="width: 80%" role="progressbar" aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">80% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                </ul>
                            </li>
                            <li class="footer"><a href="#">View all tasks</a></li>
                        </ul></li>
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu"><a href="#"
                                                           class="dropdown-toggle" data-toggle="dropdown"> <i
                                class="glyphicon glyphicon-user"></i> <span>Jane Doe <i
                                    class="caret"></i></span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header bg-light-blue"><img
                                    src="img/avatar3.png" class="img-circle" alt="User Image" />
                                <p>
                                    Jane Doe - Web Developer <small>Member since Nov. 2012</small>
                                </p></li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <div class="col-xs-4 text-center">
                                    <a href="#">Followers</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Sales</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Friends</a>
                                </div>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                </div>
                                <div class="pull-right">
                           
                                <li class="divider"></li>
                                <c:url value="/j_spring_security_logout" var="logoutUrl" />
                            <form action="${logoutUrl}" method="post" id="logoutForm">
                                <input type="hidden" name="${_csrf.parameterName}"
                                       value="${_csrf.token}" />
                            </form>
                            <li><a onclick="document.getElementById('logoutForm').submit();"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul></li>
                </ul>
            </div>
        </nav>
    </header>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="img/avatar3.png" class="img-circle" alt="User Image" />
                </div>
                <div class="pull-left info">
                    <p>Hello, Jane</p>

                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>
            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control"
                           placeholder="Search..." /> <span class="input-group-btn">
                        <button type='submit' name='search' id='search-btn'
                                class="btn btn-flat">
                            <i class="fa fa-search"></i>
                        </button>
                    </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <sql:query dataSource="${snapshot}" var="menus">
                    SELECT DISTINCT p.`TYPE`
                    FROM sec_user_def u,
                    sec_page_role_def pr,
                    sec_page_def p,
                    user_roles ur
                    WHERE u.username='${pageContext.request.userPrincipal.name}'
                    AND ur.user_id=u.id
                    AND pr.`ROLE` IN(ur.role_id)
                    AND p.`VIEW_ID`= pr.`VIEW_ID`
                    AND p.TYPE!='PROCESS';
                </sql:query>
                <c:forEach var="menus" items="${menus.rows}">
                    <li class="treeview"><a href="#"> <i
                                class="fa fa-bar-chart-o"> </i> <span> <c:out
                                    value="${menus.TYPE}" />
                            </span> <i class="fa fa-angle-left pull-right"> </i>
                        </a>
                        <ul class="treeview-menu">
                            <c:set var="TYPE" value="${menus.TYPE}" />
                            <sql:query dataSource="${snapshot}" var="result">
                                SELECT P.*
                                FROM sec_user_def u,
                                sec_page_role_def pr,
                                sec_page_def p,user_roles ur
                                WHERE u.username='${pageContext.request.userPrincipal.name}'
                                AND ur.user_id=u.id AND pr.`ROLE` IN(ur.role_id) AND p.`VIEW_ID`= pr.`VIEW_ID`
                                AND p.TYPE=?;
                                <sql:param value="${TYPE}" />
                            </sql:query>
                            <c:forEach var="row" items="${result.rows}">
                                <li><a style="margin-left: 10px;"
                                       href="<c:url value="${row.VIEW_ID}"/>"> <i
                                            class="fa fa-angle-double-right"><c:out
                                                value="${row.NAME}" /></i>
                                    </a></li>
                                </c:forEach>
                        </ul></li>
                    </c:forEach>

            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>


    <aside class="right-side">
        <tiles:insertAttribute name="body" />
    </aside>
    <!-- /.right-side -->
</div>
<!-- ./wrapper -->

</body>

</html>
