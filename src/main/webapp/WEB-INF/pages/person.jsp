<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<body>
			<div class="col-lg-12">
				<h4 class="panel-heading panel-info">Employee</h4>
			</div>
			<br />
			<div class="col-lg-12">
				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal">Create User</button>
				<br>
				<h3>Persons List</h3>
				<c:if test="${!empty listPersons}">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Users</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body table-responsive">
								<table id="personTable"
									class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>Id</th>
											<th>FirstName</th>
											<th>LastName</th>
											<th>Username</th>
											<th>UserType</th>
											<th>E-mail</th>
<!-- 											<th>Account Expired</th> -->
<!-- 											<th>Account Locked</th> -->
<!-- 											<th>Account Valid</th> -->
<!-- 											<th>Last Login Date</th> -->
<!-- 											<th>Last Pwd Date</th> -->
<!-- 											<th>Login Try</th> -->
<!-- 											<th>Pwd Expired</th> -->
										</tr>
									</thead>
									<c:forEach items="${listPersons}" var="person">
										<tr>
											<td>${person.id}</td>
											<td>${person.firstName}</td>
											<td>${person.lastName}</td>
											<td>${person.username}</td>
											<td>${person.userType}</td>
											<td>${person.email}</td>
<%-- 											<td>${person.accountExpired}</td> --%>
<%-- 											<td>${person.accountLocked}</td> --%>
<%-- 											<td>${person.accountValid}</td> --%>
<%-- 											<td>${person.lastLoginDate}</td> --%>
<%-- 											<td>${person.lastPwdDate}</td> --%>
<%-- 											<td>${person.loginTry}</td> --%>
<%-- 											<td>${person.pwdExpired}</td> --%>
											<td><a href="<c:url value='/edit/${person.id}' />">Edit</a></td>
											<td><a href="<c:url value='/remove/${person.id}' />">Delete</a></td>
										</tr>
									</c:forEach>
								</table>

							</div>
						</div>
					</div>
				</c:if>
				<!-- Modal -->
				<c:url var="addAction" value="/persons/add"></c:url>
				<form:form action="${addAction}" commandName="person">
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<!--<a href="<c:url value='/persons' />"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></a>-->
									<h4 class="modal-title" id="myModalLabel">Users</h4>
								</div>
								<div class="modal-body">
									<div class="box box-primary">
										<div class="box-header">
											<h3 class="box-title">Create User</h3>
										</div>
										<!-- /.box-header -->
										<!-- form start -->
										
											<div class="box-body">
											    <c:if test="${!empty person.username}">
										
											<div class="form-group">
												<label for="id">ID</label>
													<input type="text" class="form-control" id="id" name='id'  value="${person.id}" disabled="disabled"  placeholder="Enter Last Name">
												</div>
										
										</c:if>
											
												<div class="form-group">
												<label for="firstName">First name</label>
													<input type="text" class="form-control" id="firstName" name='firstName' value="${person.firstName}" placeholder=" Enter First Name">
												</div>
												
												<div class="form-group">
												<label for="lastName">Last name</label>
													<input type="text" class="form-control" id="lastName" name='lastName'  value="${person.lastName}"   placeholder="Enter Last Name">
												</div>
												
												<div class="form-group">
													<label for="username">User name</label>
													<input type="text" class="form-control" id="username" name='username' value="${person.username}" placeholder=" Enter Username">
												</div>
												
												<div class="form-group">
													<label for="password">Password</label>
													<input type="text" class="form-control" id="password" name='password' value="${person.password}" placeholder=" EnterPassword">
												</div>
												
												<div class="form-group">
													<label for="userType">User Type</label>
													<input type="text" class="form-control" id="userType" name='userType' value="${person.userType}" placeholder="Enter User Type">
												</div>
												
												<div class="form-group">
													<label for="email">Email address</label>
													<input type="email" class="form-control" id="email" name='email' value="${person.email}" placeholder="Enter email">
												</div>
												
											</div>
											<!-- /.box-body -->
									</div>
									<!-- /.box -->
<!-- 									<table> -->
<%-- 										<c:if test="${!empty person.username}"> --%>
<!-- 											<tr> -->
<%-- 												<td><form:label path="id"> --%>
<%-- 														<spring:message text="ID" /> --%>
<%-- 													</form:label></td> --%>
<%-- 												<td><form:input path="id" readonly="true" size="8" --%>
<%-- 														disabled="true" /> <form:hidden path="id" /></td> --%>
<!-- 											</tr> -->
<%-- 										</c:if> --%>
<!-- 										<tr> -->
<%-- 											<td><form:label path="firstName"> --%>
<%-- 													<spring:message text="First Name :" /> --%>
<%-- 												</form:label></td> --%>
<%-- 											<td><form:input path="firstName" /></td> --%>
<!-- 										</tr> -->
<!-- 										<tr> -->
<%-- 											<td><form:label path="lastName"> --%>
<%-- 													<spring:message text="Last Name :" /> --%>
<%-- 												</form:label></td> --%>
<%-- 											<td><form:input path="lastName" /></td> --%>
<!-- 										</tr> -->
<!-- 										<tr> -->
<%-- 											<td><form:label path="Username"> --%>
<%-- 													<spring:message text="Username :" /> --%>
<%-- 												</form:label></td> --%>
<%-- 											<td><form:input path="username" /></td> --%>
<!-- 										</tr> -->
<!-- 										<tr> -->
<%-- 											<td><form:label path="userType"> --%>
<%-- 													<spring:message text="User Type :" /> --%>
<%-- 												</form:label></td> --%>
<%-- 											<td><form:input path="userType" /></td> --%>
<!-- 										</tr> -->
<!-- 										<tr> -->
<%-- 											<td><form:label path="Password"> --%>
<%-- 													<spring:message text="Password  :" /> --%>
<%-- 												</form:label></td> --%>
<%-- 											<td><form:input path="password" /></td> --%>
<!-- 										</tr> -->
<!-- 										<tr> -->
<%-- 											<td><form:label path="email"> --%>
<%-- 													<spring:message text="E- mail :" /> --%>
<%-- 												</form:label></td> --%>
<%-- 											<td><form:input path="email" /></td> --%>
<!-- 										</tr> -->
<!-- 										<br /> -->
<!-- 									</table> -->
								</div>
								<div class="modal-footer">
									<a href="<c:url value='/persons' />">
										<li class="btn btn-danger">Cancel</li>
									</a>
									<c:if test="${!empty person.username}">
										<input type="submit" class="btn btn-primary"
											value="<spring:message text="Edit Person"/>" />
									</c:if>
									<c:if test="${empty person.username}">
										<input type="submit" class="btn btn-primary"
											value="<spring:message text="Add Person"/>" />
									</c:if>
								</div>
							</div>
						</div>
					</div>

				</form:form>
				<c:if test="${!empty person.username}">
					<script type="text/javascript">
						$('#myModal').modal('show');
					</script>
				</c:if>
			</div>
			<script type="text/javascript">
				$(function() {
					$('#personTable').dataTable({
						"bPaginate" : true,
						"bLengthChange" : false,
						"bFilter" : false,
						"bSort" : true,
						"bInfo" : true,
						"bAutoWidth" : false
					});
				});
			</script>
		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>