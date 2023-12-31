<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modify</title>
    <link rel="shortcut icon" href="/resources/img/ej_img/logoimg.ico">
<link rel="stylesheet" href="/resources/css/hs_css/buttons.css">
<link rel="stylesheet" href="/resources/css/hs_css/noticeModify.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/mouse.jsp" %>

<div class="bodyTop">
	<div class="category">NOTICE</div>
</div>
		<form id="modifyForm" action="/notice/modify" method="post">
		  <div class="frameWrap">
		      <div class="bodyText must">Modify</div>
		      <div class="n1">
		       <input name="bno" type="hidden" readonly="readonly" value='<c:out value="${modify.bno}"/>' >
		       <input type="text" name="title" value='<c:out value="${modify.title}"/>' >
		      </div>
		      <div class="n2">
		     	<input type="text" name="updateDate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${modify.updatedate}"/>' >
		      <input type="text"name="regdate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${modify.regdate}"/>' >
		      <input type="text" name="writer" readonly="readonly" value='<c:out value="${modify.writer}"/>' >
		      </div>
		      <div class="n3">
		          <textarea row="50" name="content"><c:out value="${modify.content}"/></textarea>
		      </div>
		      <div class="n4">
		          <a id="list_btn" class="button button--ujarak button--border-thin button--text-thick btnRegister">목록</a>
		          <a id="modify_btn" class="button button--ujarak button--border-thin button--text-thick btnRegister">완료</a>
		          <a id="cancel_btn" class="button button--ujarak button--border-thin button--text-thick btnRegister">취소</a>
	           </div>
			</div>
		</form>

    <form id="infoForm" action="/notice/modify" method="get">
		<input type="hidden" id="bno" name="bno" value='<c:out value="${modify.bno}"/>'>
	</form>
                
<%@ include file="../includes/footer.jsp" %>

<script>
		let form = $("#infoForm");        // 페이지 이동 form(리스트 페이지 이동, 조회 페이지 이동)
		let mForm = $("#modifyForm");    // 페이지 데이터 수정 form
		
		/* 목록 페이지 이동 버튼 */
		$("#list_btn").on("click", function(e){
		    form.find("#bno").remove();
		    form.attr("action", "/notice/list");
		    form.submit();
		});
		
		/* 수정 하기 버튼 */
		$("#modify_btn").on("click", function(e){
		    mForm.submit();
		});
		
		/* 취소 버튼 */
		$("#cancel_btn").on("click", function(e){
		    form.attr("action", "/notice/read");
		    form.submit();
		});
		
</script>	

</body>
</html>