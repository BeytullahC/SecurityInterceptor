<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <tiles:insertDefinition name="defaultTemplate">
        <tiles:putAttribute name="body">
            <body>
                <div class="col-lg-12">
                    <h4 class="panel-heading panel-info">Admin</h1>
                </div>

            </body>
        </tiles:putAttribute>

    </tiles:insertDefinition>
