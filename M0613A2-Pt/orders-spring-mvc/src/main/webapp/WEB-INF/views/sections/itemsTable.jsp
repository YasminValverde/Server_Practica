<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th><spring:message code="itemsTable.reference" /></th>
				<th><spring:message code="itemsTable.item" /></th>
				<th><spring:message code="itemsTable.price" /></th>
				<th><spring:message code="itemsTable.quantity" /></th>
				<th><spring:message code="itemsTable.amount" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="itemQuantity" items="${order.items}">
				<c:set var="item" value="${itemQuantity.key}" />
				<c:set var="qty" value="${itemQuantity.value}" />
				<tr>
					<td>${item.reference}</td>
					<td>${item.name}</td>
					<td><fmt:formatNumber value="${item.price}" type="currency"
							currencySymbol="${currencySymbol}" pattern="#,###,##0.00 ¤" /></td>
					<td>${qty}</td>
					<td><fmt:formatNumber value="${qty * item.price}"
							type="currency" currencySymbol="${currencySymbol}"
							pattern="#,###,##0.00 ¤" /></td>
				</tr>
			</c:forEach>
			<tr class="table-secondary">
				<td colspan="3" style="text-align: right"><strong><spring:message
							code="itemsTable.total" /></strong></td>
				<td><strong>${order.totalQuantity}</strong></td>
				<td><strong><fmt:formatNumber
							value="${order.totalAmount}" type="currency" currencySymbol="€"
							pattern="#,###,##0.00 ¤" /></strong></td>
			</tr>
		</tbody>
	</table>
</div>