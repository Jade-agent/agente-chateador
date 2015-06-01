<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:body>

        <style>
            #chat_log {
                min-height: 400px;
                max-height: 400px;
                min-width: 400px;
                width: 100%;
                background-color: #DDDDDD;
                border: 1px solid #999999;
            }
        </style>

        <h2><span class="glyphicon glyphicon-comment"></span>&nbsp;Chat</h2>

        <div id="chat_log" class="img-rounded">

        </div>
        <h3>Escriba aquí</h3>

        <div class="controls">
            <form role="form" autocomplete="off">
                <div class="input-group input-group-lg">
                    <input type="text" class="form-control" id="chat_message"/>
                            <span class="input-group-btn">
                                <button class="btn btn-success">
                                    <span class="glyphicon glyphicon-send"></span>
                                </button>
                            </span>
                </div>
            </form>
        </div>

    </jsp:body>
</t:layout>