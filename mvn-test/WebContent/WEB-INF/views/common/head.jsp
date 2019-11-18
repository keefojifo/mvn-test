<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   
<c:set var="ver" value="1.0.2"/>
<!-- value 의 버전만 올려주면 캐쉬가 초기화 되어 읽게 된다  . -->  
<script  src="${jsPath}/jquery-3.4.1.min.js?ver=${ver}"></script>
<script src="${jsPath}/bootstrap.js?ver=${ver}"></script>
<script  src="${jsPath}/bootstrap.bundle.js?ver=${ver}"></script>
<script  src="${jsPath}/common.js?ver=1?ver=${ver}"></script>
<link  rel="stylesheet"href="${cssPath}/bootstrap.css?ver=${ver}"/>
<link  rel="stylesheet"href="${cssPath}/bootstrap-reboot.css?ver=${ver}"/>
<link  rel="stylesheet"href="${cssPath}/bootstrap-grid.css?ver=${ver}"/>