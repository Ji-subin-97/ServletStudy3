<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Insert Page</h1>
	
	<form action="./bankbookInsert.do" method="post">
		제품명 <input type="text" name="bookName" placeholder="subin">
		이자율 <input type="text" name="bookRate">
		판매여부 
			<input type="radio" name="bookSale" value="1" checked="checked">YES
			<input type="radio" name="bookSale" value="0">NO
			<select>
				<option>Y</option>
				<option>N</option>
			</select>
			
		<div>
			<button>WRITE1</button>
			<input type="button" value="WRITE2">
			<input type="submit" value="SUBMIT">
			<input type="reset" value="RESET">
		</div>
	</form>
</body>
</html>