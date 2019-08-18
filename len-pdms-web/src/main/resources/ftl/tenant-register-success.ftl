<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册结果</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${re.contextPath}/plugin/x-admin/css/font.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/x-admin/css/xadmin.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>

</head>
<body>

<div class="layui-col-md12">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>注册结果</legend>
    </fieldset>

    <blockquote class="layui-elem-quote">租户注册成功<a href="/goLogin" id="login" type="button" class="layui-btn layui-btn-lg" style="margin-left: 15px;">立即登录</a></blockquote>

</div>


<script>
    var layer;
    $(function () {
        layui.use(['form', 'layer'], function () {
            layer = layui.layer;
            var msg = '${message}';
            if (msg.trim() != "") {
                layer.msg(msg, {icon: 5, anim: 6, offset: 't'});
            }
        })
    })

</script>


<!-- 底部结束 -->
</body>
</html>
