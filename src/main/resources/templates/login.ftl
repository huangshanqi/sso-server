<!DOCTYPE html>

<html lang="en">

<body>
<form name="login" method="post" enctype="multipart/form-data" accept-charset="utf-8" action="/sso/login">
    <input name="redirect" type="hidden" value="${Request.redirect!"--"}">
    <br>
    <input name="username" type="text">
    <br>
    <input name="password" type="password">
    <br>

    <button type="submit" name="提交">提交</button>
</form>
</body>

</html>