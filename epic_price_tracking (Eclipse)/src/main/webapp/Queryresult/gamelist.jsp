<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style><%@include file="/WEB-INF/lib/css/bootstrap.min.css"%></style>
	<script ><%@include file="/WEB-INF/lib/js/bootstrap.min.js"%></script>
	<script
			  src="https://code.jquery.com/jquery-3.6.0.slim.js"
			  integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY="
			  crossorigin="anonymous"></script>
</head>
<style>
.no-margin{
	margin: 0px
}

.body-padding{
	padding: 6px
}

.image-holder{
	min-height: 60%;
	max-height: 75%;
	display: flex;
	align-items: center;
	justify-content: center;
}

.custom-btn{
	padding: 2px 8px;
}

#alert-message{
position: fixed;
top: 80%;
left: 75%;
display:none;
}

</style>
<body>
	<h3 align="center"> Epic Games </h3>
	 <div id="session-data" data-sessoin="${sessionScope.session_user.id}"></div>
	<div style="display:flex; flex-direction:row; flex-wrap: wrap">
		<c:forEach items="${GameList}" var="game">
			<div class="card" style="width: 15rem; margin:10px;">
				<div class="image-holder">
				<img class="card-img-top" src=${game.thumbnail} alt="Card image cap">
				</div>
			  <div class="card-body body-padding">
			    <p class="card-text no-margin">${game.name}</p>
			    <p class="card-test no-margin">${game.publisher}</p>
			    <p class="card-test no-margin">Current price:<b>${game.price}</b></p>
			    <button class="btn btn-small btn-primary custom-btn" onclick="javascript:myFunction(${game.id},${sessionScope.session_user.id})">Track</button>
			  </div>
			</div>
		</c:forEach>
	</div>
	<div class="alert alert-info" id="alert-message" role="alert">
	  message
	</div>
	
	
<%-- 	<table class="table" align="center">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>thumbnail</th>
		<th>price</th>
	</tr>
<c:forEach items="${GameList}" var="game">
	<tr>
		<td>${game.id }</td>
		<td>${game.name }</td>
		<td>${game.thumbnail }</td>
		<td>${game.price }</td>
	</tr>
</c:forEach>
</table> --%>
</body>

<script>
function myFunction(game_id, user_id){
	console.log(game_id);
	console.log(user_id);
	
	
	async function postData(url = '', data = {}) {
		  // Default options are marked with *
		  const response = await fetch(url, {
		    method: 'POST', // *GET, POST, PUT, DELETE, etc.
		    mode: 'cors', // no-cors, *cors, same-origin
		    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
		    credentials: 'same-origin', // include, *same-origin, omit
		    headers: {
		      'Content-Type': 'application/x-www-form-urlencoded'
		      // 'Content-Type': 'application/x-www-form-urlencoded',
		    },
		    redirect: 'follow', // manual, *follow, error
		    referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
		    body: data // body data type must match "Content-Type" header
		  });
		  return response; // parses JSON response into native JavaScript objects
		}

		let formData = new FormData();
		formData.append('game_id', game_id);
		formData.append('user_id', user_id);
	
		postData(window.location.protocol+"//"+window.location.host+"/CS480Demo/UserGame","val1="+game_id+"&val2="+user_id)
		  .then(data => {
		    if(data.status == 200){
		    	var msgelement = document.getElementById("alert-message");
		    	msgelement.innerText = "Selected Game had been added to your tracking list!"
		    	msgelement.style.display = "block"
		    
		    	setTimeout(function(){
		    		msgelement.style.display = "none"	
		    	},5000)
		    
		    } else{
		    	var msgelement = document.getElementById("alert-message");
		    	msgelement.innerText = "You are already tracking this game!"
		    	msgelement.style.display = "block"
		    
		    	setTimeout(function(){
		    		msgelement.style.display = "none"	
		    	},3000)
		    } 
		  });
	
	
}
	
</script>


</html>