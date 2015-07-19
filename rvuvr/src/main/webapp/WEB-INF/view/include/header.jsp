<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <nav class="navbar navbar-default" role="navigation"> <!-- Start Nav -->
            <div class="container">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a href="index.html" class="navbar-brand ">
                        <span class="logo"><strong>classified</strong><span class="handwriting">ads</span><br />
                            <small >a minimalist theme built with bootstrap </small></span>
                    </a>

                </div>



                <div class="collapse navbar-collapse">

                    <ul class="nav navbar-nav navbar-right visible-xs">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="my_account.html">Login</a></li>
                        <li><a href="register.html">Register</a></li>
                        <li><a href="listings.html">Listings</a></li>
                        <li><a href="account_dashboard.html">My account</a></li>
                        <li><a href="account_ad_create.html">Post an ad</a></li>
                    </ul> 
                    <div class="nav navbar-nav navbar-right hidden-xs">
                        <div class="row">

                            <div class="pull-right">


                                <a data-toggle="modal" data-target="#modalLogin"  href="#">Login</a> | 
                                <a href="register.html">Register</a> | 
                                <a href="listings.html">Listings</a> | 
                                <a href="account_dashboard.html">My account</a>
                                <a href="account_ad_create.html" class="btn btn-warning post-ad-btn">Post an ad</a>

                            </div>	
                        </div>




                    </div>

                </div>
                </div>





            </nav> <!-- End Nav -->
