<%@ page import="java.util.*,com.ecommerce.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
List<Product> products=(List<Product>)request.getAttribute("products");
if(products==null){ try { products=new com.ecommerce.dao.ProductDAO().findAll(); } catch(Exception e){ throw new RuntimeException(e); } }
%>
<!DOCTYPE html><html><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1">
<title>ShopSphere | Products</title><link rel="stylesheet" href="css/style.css"></head><body>
<header class="nav"><a class="logo-text" href="products.jsp">ShopSphere</a><nav>
<a href="products.jsp">Products</a><a href="cart.jsp">Cart</a>
<% if(session.getAttribute("username")!=null){ %><span class="welcome">Hi, <%=session.getAttribute("username")%></span><a href="logout">Logout</a><% } else { %><a href="login.jsp">Login</a><% } %>
</nav></header>
<section class="hero"><div><span class="pill">NEW COLLECTION</span><h1>Discover products<br><span>you’ll love.</span></h1><p>Simple shopping experience with a modern storefront.</p></div></section>
<main class="container"><div class="section-head"><h2>Featured Products</h2><span><%=products.size()%> items</span></div>
<div class="grid">
<% for(Product p:products){ %><article class="product"><img src="<%=p.getImageUrl()%>" alt="<%=p.getName()%>"><div class="product-body"><span class="category"><%=p.getCategory()%></span><h3><%=p.getName()%></h3><p><%=p.getDescription()%></p><div class="product-foot"><strong>₹<%=p.getPrice()%></strong>
<form method="post" action="cart"><input type="hidden" name="productId" value="<%=p.getId()%>"><button class="add">Add to cart</button></form></div></div></article><% } %>
</div></main></body></html>
