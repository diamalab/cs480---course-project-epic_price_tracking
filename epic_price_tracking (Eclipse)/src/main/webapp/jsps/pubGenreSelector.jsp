<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
	<script ><%@include file="/WEB-INF/lib/js/bootstrap.min.js"%></script>
	<script ><%@include file="/WEB-INF/lib/js/jquery.min.js"%></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div>
<div class="accordion" id="accordionExample">
  <div class="card genre-tab">
    <div class="card-header" onclick="showGenresTab();" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left genre-tab" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Genre
        </button>
      </h2>
    </div>

    <div id="collapseOne" class="collapse genre-content" aria-labelledby="headingOne" data-parent="#accordionExample">
      <div class="card-body" style="padding:0px">
		<ul class="list-group genres-list">
	  		<c:forEach items="${GenreList}" var="genre">
	  	  		<li class="list-group-item list-genre-item" data-id="genre-${genre.id}" onclick="selectGenre(${genre.id},this)">${genre.name}</li>
	  		</c:forEach>
		</ul>
      </div>
    </div>
  </div>
  <div class="card" >
    <div class="card-header" onclick="showPublishersTab();" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Publisher
        </button>
      </h2>
    </div>
    <div id="collapseTwo" class="collapse publisher-content" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="card-body" style="padding:0px">
		<ul class="list-group publishers-list">
		  <c:forEach items="${publisherList}" var="publisher">
		  	<li class="list-group-item list-publisher-item" data-id="publisher-${publisher.id}" onclick="selectPublisher(${publisher.id},this)">${publisher.publisherName}</li>
		  </c:forEach>
		</ul>
	  </div>
    </div>
  </div>
 
 
  </div>
  <form action="<c:url value='/queryGames'/>" id="filter-form" method="post" target="content">
  	<input type="text" id="genre-id-val" name="genreId" value="" hidden/>
  	<input type="text" id="publisher-id-val" name="publisherId" value="" hidden/> 
  	<input type="text" id="game-id-val" name="sortVariable" value="" hidden/> 
  	<input type="submit" class="btn btn-primary" value="Apply filter" style="padding:10px"/>
  	<input type="button" onclick="clearFilter()" class="btn btn-secondary" value="Clear filter" style="padding:10px"/>
  </form>
  
  
  
  
  <div class="card" >
    <div class="card-header" onclick="showLowestPriceTab();" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Sort in Alphabetical Order
        </button>
        
      </h2>
    </div>
  
  <form action="<c:url value='/queryGames'/>" id="filter-form" method="post" target="content">
  	<input type="text" id="game-id-val" name="gameId" value="" hidden/>
  	<input type="text" id="game-id-val2" name="gameId2" value="" hidden/>
  	<input type="text" id="game-id-val3" name="gameId3" value="name" hidden/>
  	<input type="submit" class="btn btn-primary" value="Sort" style="padding:10px"/>
  	
  </form>
  
  
  
  
  </div> 
  </body>
  
  <script>
  
  
  
  function showGenresTab(){
	  let genreTab = document.getElementsByClassName("genre-content");
	  genreTab[0].classList.toggle("show");
	  
  }
  
  function showPublishersTab(){
	  let publisherTab = document.getElementsByClassName("publisher-content");
	  publisherTab[0].classList.toggle("show");
  }

  // lowest price
  function showLowestPriceTab(){
	  let gameTab = document.getElementsByClassName("game-content");
	  gameTab[0].classList.toggle("show");	  
  }
  
  
  function selectGame(id,element){
	  
	  selectedGames = document.getElementsByClassName('list-game-item active')
	  if(selectedGames && selectedGames.length){
		  for (let item of selectedGames) {
			  item.classList.remove("active")
			}
	  }
	  
	  
	  if((document.getElementById("game-id-val").value == id)){
		  element.classList.remove("active");
	  }else{
		  element.classList.add("active");
	  }
	  
	  let selectedGame = document.querySelector('[data-id=game'+id+']')
	  document.getElementById("game-id-val").value = (document.getElementById("game-id-val").value == id)?"":id;
	  
  }
  
 // end of lowestPrice 
  
  function selectGenre(id,element){
	  
	  selectedGenres = document.getElementsByClassName('list-genre-item active')
	  if(selectedGenres && selectedGenres.length){
		  for (let item of selectedGenres) {
			  item.classList.remove("active")
			}
	  }
	  
	  
	  if((document.getElementById("genre-id-val").value == id)){
		  element.classList.remove("active");
	  }else{
		  element.classList.add("active");
	  }
	  
	  let selectedGenre = document.querySelector('[data-id=genre'+id+']')
	  document.getElementById("genre-id-val").value = (document.getElementById("genre-id-val").value == id)?"":id;
	  
  }
  
  function selectPublisher(id,element){
	  
	  selectedPublishers = document.getElementsByClassName('list-publisher-item active')
	  if(selectedPublishers && selectedPublishers.length){
		  for (let item of selectedPublishers) {
			  item.classList.remove("active")
			}
	  }
	  
	  if((document.getElementById("publisher-id-val").value == id)){
		  element.classList.remove("active");
	  }else{
		  element.classList.add("active");
	  }
	  
	  let selectedPublisher = document.querySelector('[data-id=publisher'+id+']')
	  document.getElementById("publisher-id-val").value = (document.getElementById("publisher-id-val").value == id)?"":id;
	  
  }
  
  function clearFilter(){
	  
	  selectedGenres = document.getElementsByClassName('list-genre-item active')
	  if(selectedGenres && selectedGenres.length){
		  for (let item of selectedGenres) {
			  item.classList.remove("active")
			}
	  }
	  
	  
	  selectedPublishers = document.getElementsByClassName('list-publisher-item active')
	  if(selectedPublishers && selectedPublishers.length){
		  for (let item of selectedPublishers) {
			  item.classList.remove("active")
			}
	  }
	  
	  
	  document.getElementById("genre-id-val").value= "";
	  document.getElementById("publisher-id-val").value= "";
	  let form = document.getElementById("filter-form").submit();
  }
  
  
  </script>
  
  
  
  
  
</html>
