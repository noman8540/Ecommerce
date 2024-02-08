<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link rel="stylesheet" href="style.css">

    
    <!-- FONT AWSOME LINK  -->
    <script src="https://kit.fontawesome.com/789c569d32.js" crossorigin="anonymous"></script>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">


</head>

<body>

  <%@include file="header.jsp" %>

    <section>
        <div class="section">
            <div class="section1">
                <div class="img-slider">
                    <img src="https://images.unsplash.com/photo-1516478177764-9fe5bd7e9717?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=400&ixid=MnwxfDB8MXxyYW5kb218MHx8c2hvZXN8fHx8fHwxNjk3OTc3NTI0&ixlib=rb-4.0.3&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=600"
                        alt="" class="img">
                    <img src="https://images.pexels.com/photos/3962294/pexels-photo-3962294.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                        alt="" class="img">
                    <img src="https://images.pexels.com/photos/2292953/pexels-photo-2292953.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                        alt="" class="img">
                    <img src="https://images.pexels.com/photos/1229861/pexels-photo-1229861.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                        alt="" class="img">
                    <img src="https://images.unsplash.com/photo-1518894781321-630e638d0742?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=400&ixid=MnwxfDB8MXxyYW5kb218MHx8c2hvZXN8fHx8fHwxNjk3OTc3NDY3&ixlib=rb-4.0.3&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=600"
                        alt="" class="img">
                </div>

            </div>


            <div class="section2">
                <div class="container">
                <c:forEach items="${obj}" var="prod" varStatus="loop">
                <c:if test="${loop.index < 4}">
                    <div class="items">
                <div class="img img1">
                    <a href="singlepage?id=${prod.id}">
                        <img src="image/${prod.imageUrl}" alt="">
                    </a>
                </div>
                <div class="name"> ${prod.name}</div>
                <div class="price">Price : ${prod.price}</div>
                <div class="price">Size : ${prod.size}</div>
                <div class="info ">
                <a href="addcart?id=${prod.id}&email=<%=email%>"> 
                <button>Add to cart </button>
                </a>
                 &nbsp;
                
                <a href="singlepage?id=${prod.id}">
                <button>  Read more </button>
                </a>
                
                </div>
                    </div>
                    
                </c:if>
                </c:forEach>
                
                
            </div>
                </div>
                <br>
                <br>
                 <!-- "Show More" link to redirect to products.jsp -->
                <div class="section3">
                <div class="container-fluid text-center">
                    <a href="products">Show More</a>
                </div>
                </div>
                
                <br>
                <br>
                
        </div>

    </section>


<jsp:include page= "footer.jsp"/>







