<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:form="http://www.w3.org/1999/xhtml">
<head>
    <title>Email Settings</title>
    <style>
        .input1 {
            width: 200px;
        }
        .input2 {
            width: 300px;
        }
    </style>
</head>
<body>
<div>
    <div style="margin-left: 38%">
        <form:form action="update" modelAttribute="settings">
            <h2>${settings.setting}</h2>

            <div style="display: flex">
                <div class="m1">${settings.language}</div>
                <div class="m2">
                    <select name="languageId">
                        <option value="1">日本</option>
                        <option value="2">Tiếng Việt</option>
                        <option value="3">English</option>
                        <option value="4">French</option>
                    </select>
                </div>
            </div>

            <div style="display: flex">
                <div class="input1">${settings.pageSize}</div>
                <div class="input2">
                    <form:select path="pageSize">
                        <form:options items="${pages}"></form:options>
                    </form:select>
                </div>
            </div>

            <div style="display: flex">
                <div class="input1">${settings.spamsFilter}</div>
                <div class="input2">
                    <input type="checkbox">
                </div>
            </div>

            <div style="display: flex">
                <div class="input1">${settings.signature}</div>
                <div class="input2">
                    <textarea>SyVT</textarea>
                </div>
            </div>
            <div style="display: flex">
                <div class="input1"></div>
                <div class="input2">
                    <button type="submit">${settings.update}</button>
                    <button class="btn btn-primary">${settings.cancel}</button>
                </div>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>