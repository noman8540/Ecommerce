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

    <div class="navbg sticky-top " >
        <nav class="navbar navbar-expand-lg bg-body-tertiary" id="navbg">
            <div class="container-fluid">
                <a class="navbar-brand" id="logo" href="home">ShopAll</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse " id="navbarSupportedContent">


                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 " id="navright">
                        <li class="nav-item">
                        <%String email=(String) session.getAttribute("eid");
                        if(email!=null)
                        {
                        	%>
                        	<a class="nav-link active" aria-current="page" href="logout">
                                <i class="fa-solid fa-user" style="color: #276add;"></i>
                                Logout</a>
                            <%
                        }
                        else
                        {
                        	%>
                        	<a class="nav-link active" aria-current="page" href="login">
                            <i class="fa-solid fa-user" style="color: #276add;"></i>
                            Login</a>
                            
                        
                        <% }%>
                        
                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="home">
                                <i class="fa-solid fa-house" style="color: #1b5dd0;"></i>
                        HOME </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="cart?email=<%=email%>">
                                <i class="fa-solid fa-cart-shopping fa-beat" style="color: #296adb;"></i>
                                CART</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="products">OUR PRODUCTS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about">ABOUT US</a>
                        </li>
                        
                         <li class="nav-item">
                            <a class="nav-link" href="addproduct">ADD PRODUCT</a>
                        </li>


                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2 " type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-primary" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>


 <c:forEach items="${obj1}" var="prod1">
<div class="card m-3" id="card">
                <div class="row g-0">
                    <div class="col-md-5">
                        <img src="image/${prod1.imageUrl}"
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
</body>
</html>