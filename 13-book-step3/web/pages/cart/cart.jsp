<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="application/javascript">
		$(function () {
			$("a.deleteItem").click(function () {
				var name = $(this).parent().parent().find("td:first").text();
				return confirm("你确定要删除【" + name +"】吗？");
			});
			$("#clearCart").click(function () {
				return confirm("你确定要清空购物车吗？");
			})
			$("input.updateCount").change(function () {
				var count = $(this).val();
				var id = $(this).attr("itemId");
				var name = $(this).parent().parent().find("td:first").text();
				if (confirm("你确定要将【" + name +"】的数量修改为" + count + "吗？")) {
					location.href = "${pageScope.basePath}servlet/cart?action=updateCount&id=" + id + "&count=" + count;
				} else {
					$(this).val(this.defaultValue);
				}
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<td colspan="5"><a href="index.jsp">亲，当前购物车为空，快跟小伙伴们浏览商品吧！</a></td>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items.values()}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>
							<input itemId="${item.id}" class="updateCount" style="width: 80px" type="number" value="${item.count}">
						</td>
						<td>${item.price}</td>
						<td>${item.totalPrice}</td>
						<td><a class="deleteItem" href="servlet/cart?action=deleteItem&id=${item.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clearCart" href="servlet/cart?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="servlet/order?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	
	</div>

	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>