<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ShopAll</title>
    <link rel="stylesheet" href="style.css">

    
    <!-- FONT AWSOME LINK  -->
    <script src="https://kit.fontawesome.com/789c569d32.js" crossorigin="anonymous"></script>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">


</head>

<body>

   <%@include file="header.jsp" %>


 <c:forEach items="${obj1}" var="prod1">
<div class="card m-3" id="card">
                <div class="row g-0">
                    <div class="col-md-5">
                        <img src="images/${prod1.imageUrl}"
                            class="img-fluid rounded-start" id="detailImg" alt="...">
                    </div>
                    <div class="col-md-7">
                        <div class="card-body">
                            <h5 class="card-title"> <strong> ${prod1.name} </strong> </h5>

                            <p class="card-text">${prod1.description}</p>
                            
                                                       
                        </div>

                        <div class="buybtn">
                            <button type="button" class="btn btn-warning mx-3" id="buybtn"> Buy Now
                                <i class="fa-solid fa-bolt fa-fade mx-2"></i> </button>
                            <a href="addcart?id=${prod1.id}&email=<%=email%>"><button type="button" class="btn btn-warning mx-3" > Add cart
                                <i class="fa-solid fa-cart-shopping fa-fade mx-2"></i> </button></a>
                        </div>
                    </div>
                </div>
            </div>


</c:forEach>

<jsp:include page= "footer.jsp"/>
