<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script language="javascript" type="text/javascript" src="/resources/js/shoppingCart.js"></script>
<script language="javascript" type="text/javascript" src="/resources/js/select.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/shoppingCart.css">

<div class="body">
    <div id="shoppingCart">Shopping Cart
        <p><a href="../cart/checkout"><img src="http://www.linestyle.com.ua/ru/images/car.png"
                               width="149" height="110" alt="cart"></a>
        </p>
        <table id="shoppingCartTable" border="0">
            <tr>
                <td>TotalCost:</td>
                <td id="totalCost">${totalCost}</td>
            </tr>
            <tr>
                <td>TotalAmount:</td>
                <td id="totalAmount">${totalAmount}</td>
            </tr>
        </table>
    </div>

    <div id="sort_view">
        <span>Сортировка</span>
        <select class="select_id" onchange="val()"  id="select_id" >
            <option style="color:indigo" value="title">по названию</option>
            <option style="color:gold" value="price_inc">цена(увеличение)</option>
            <option style="color:tomato" value="price_desc">цена(уменьшение)</option>
        </select>
    </div>

  <c:forEach var="product" items="${products}">
    <table border="0">
      <tr>
        <td rowspan="4"><img src="/resources/image/${product.id}.jpg" weight="85" height="128"></td>
        <td>${product.title}</td>
      </tr>
      <tr>
        <td>Price: ${product.price}</td>
      </tr>
      <tr>
        <td>${product.description}</td>
      </tr>
      <tr>
        <td>
          <input id="cart_btn" class="btnBody add2cart" type="button" value="Add to cart"
                 data-product-id="${product.id}"/>
          <a href='${product.id}'>
            <input type="button" class="btnBody" value="View" data-product-id="${product.id}">
          </a>
        </td>
      </tr>
    </table>
  </c:forEach>

</div>