<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html><html><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1">
<title>ShopSphere | Login</title><link rel="stylesheet" href="css/style.css"></head><body class="auth-bg">
<div class="auth-card"><div class="brand">S</div><h1>Welcome back</h1><p class="muted">Sign in to continue shopping</p>
<% if(request.getAttribute("error")!=null){ %><div class="alert"><%=request.getAttribute("error")%></div><% } %>
<% if("true".equals(request.getParameter("registered"))){ %><div class="success">Registration successful. Please login.</div><% } %>
<form method="post" action="login">
<div class="field"><input name="userName" required placeholder=" "><label>Username</label></div>
<div class="field"><input id="password" type="password" name="password" required placeholder=" "><label>Password</label><button type="button" class="eye" onclick="togglePassword()">Show</button></div>
<button class="btn">Login</button></form>
<p class="center muted">New customer? <a href="register.jsp">Create an account</a></p>
</div><script>function togglePassword(){let p=document.getElementById('password');p.type=p.type==='password'?'text':'password'}</script></body></html>
