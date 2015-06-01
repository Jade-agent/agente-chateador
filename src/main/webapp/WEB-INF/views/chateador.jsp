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

            .messageChat, messageUser{
                margin-top: 5px;
            }

            .messageUser {
                alignment: right;
            }
        </style>

        <h2><span class="glyphicon glyphicon-comment"></span>&nbsp;Chat</h2>

        <div id="chat_log" class="img-rounded">
            <div class="messageChat container">
                <div class="col-md-8">Mensaje de Chat</div>
                <div class="col-md-4"></div>
            </div>
            <div class="messageUser container">
                <div class="col-md-4"></div>
                <div class="col-md-8">Mensaje de Usuario</div>
            </div>
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