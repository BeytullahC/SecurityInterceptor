<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<body>

			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Welcome Page</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Welcome</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">TEST</section>
			<!-- /.content -->
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>
