<%@ page import="java.util.*,java.math.BigDecimal,com.ecommerce.model.Product,com.ecommerce.dao.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
Map<Integer,Integer> cart=(Map<Integer,Integer>)session.getAttribute("cart");
if(cart==null) cart=new LinkedHashMap<>();
ProductDAO dao=new ProductDAO(); BigDecimal total=BigDecimal.ZERO;
%>
<!DOCTYPE html><html><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>ShopSphere | Cart</title><link rel="stylesheet" href="css/style.css"></head><body>
<header class="nav"><a class="logo-text" href="products.jsp">ShopSphere</a><nav><a href="products.jsp">Products</a><a href="cart.jsp">Cart</a><a href="logout">Logout</a></nav></header>
<main class="container cart-page"><h1>Your Cart</h1>
<% if(cart.isEmpty()) { %><div class="empty"><h2>Your cart is empty</h2><p>Add something you love from the product catalog.</p><a class="btn inline" href="products.jsp">Browse Products</a></div>
<% } else { %><div class="cart-list">
<% for(Map.Entry<Integer,Integer> e:cart.entrySet()){ Product p=dao.findById(e.getKey()); BigDecimal line=p.getPrice().multiply(BigDecimal.valueOf(e.getValue())); total=total.add(line); %>
<div class="cart-row"><img src="<%=p.getImageUrl()%>"><div><h3><%=p.getName()%></h3><p>Qty: <%=e.getValue()%></p></div><strong>₹<%=line%></strong></div>
<% } %></div><div class="summary"><span>Total</span><strong>₹<%=total%></strong><a class="btn inline" href="checkout.jsp">Proceed to Checkout</a></div><% } %>
</main></body></html>
