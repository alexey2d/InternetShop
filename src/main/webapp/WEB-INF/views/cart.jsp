<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script language="javascript" type="text/javascript" src="/resources/js/shoppingCart.js"></script>

<div class="body">
  <c:forEach var="item" items="${items}">
    <table border="0">
      <tr>
        <td rowspan="5"><img src="/resources/image/${item.product.id}.jpg" weight="85" height="128"></td>
        <td>${item.product.title}</td>
      </tr>
      <tr>
        <td>Price: ${item.product.price}</td>
      </tr>
      <tr>
        <td>Description: ${item.product.description}</td>
      </tr>
        <tr>
            <td>Quantity: ${item.quantity}</td>
        </tr>
        <tr>
            <td>Item cost: ${item.totalItemPrice}</td>
        </tr>
      <tr>
        <td>
          <input id="cart_btn" class="btnBody add2cart" type="button" value="Add to cart"
                 data-product-id="${item.product.id}"/>
          <input type="button" class="btnBody deleteFromCart" value="Delete" data-product-id="${item.product.id}">
        </td>
      </tr>
    </table>
  </c:forEach>

</div>