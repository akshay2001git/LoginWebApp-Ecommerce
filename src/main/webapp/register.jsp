<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html><html><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1">
<title>ShopSphere | Register</title><link rel="stylesheet" href="css/style.css"></head><body class="auth-bg">
<div class="auth-card"><div class="brand">S</div><h1>Create account</h1><p class="muted">Join ShopSphere today</p>
<% if(request.getAttribute("error")!=null){ %><div class="alert"><%=request.getAttribute("error")%></div><% } %>
<form method="post" action="register">
<div class="field"><input name="username" required placeholder=" "><label>Username</label></div>
<div class="field"><input type="email" name="email" required placeholder=" "><label>Email</label></div>
<div class="field"><input type="password" name="password" minlength="6" required placeholder=" "><label>Password</label></div>
<button class="btn">Create Account</button></form>
<p class="center muted">Already registered? <a href="login.jsp">Login</a></p></div></body></html>
