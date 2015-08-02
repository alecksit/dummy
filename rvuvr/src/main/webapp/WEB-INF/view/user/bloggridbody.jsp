<!DOCTYPE html>
<html>

<!-- Mirrored from www.pxcreate.com/bootstrap/classic/bloggrid.html by HTTrack Website Copier/3.x [XR&CO'2013], Tue, 14 Jul 2015 12:02:47 GMT -->
<head>
<title>Classic - A Bootstrap Classified Ads Template</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Responisve, Bootstrap, Html5, Css3, Blog, Classified, Ads, Simple, Clean ">
<!-- CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- Google Webfont -->
<link href='https://www.google.com/fonts#UsePlace:use/Collection:Open+Sans:400,300,400italic,600,700,800,800italic' rel='stylesheet' type='text/css'>
<!-- Main Css -->
<link href="css/color1.css" rel="stylesheet" media="screen" id="color">
<link href="css/demo.css" rel="stylesheet" >
<!-- Font Icon -->
<link href="css/font-awesome.min.css" rel="stylesheet" media="screen">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script> 
     <![endif]-->
</head>
<body>
<div id="maincontainer"> 
  <!-- Search Start-->
  <section id="searchinner">
    <div class="container">
      <div class="searchcontianer">
        <form class="form-inline">
          <div class="btn-group">
            <input type="search" placeholder="Search Here" class="form-control mainserarch">
            <button data-toggle="dropdown" class="btn  dropdown-toggle category" type="button"> Select Categories <span class="caret"></span> </button>
            <ul class="dropdown-menu categorydropdown">
              <li><a href="#">Real Estate</a></li>
              <li><a href="#">Services</a></li>
              <li><a href="#">Item For Sale</a></li>
              <li><a href="#">Jobs</a></li>
              <li><a href="#">Personal</a></li>
            </ul>
            <input type="submit" value="Search" class="btn btn-orange tooltip-test mainserarchsubmit">
          </div>
        </form>
      </div>
    </div>
    <a class="postad" href="post-ad.html"><span> <i class="fa fa-pencil"></i> Post An Ad</span></a> </section>
  <div class="container"> 
    <!--  breadcrumb -->
    <ul class="breadcrumb">
      <li> <a >Home</a> </li>
      <li class="active">Blog Grid</li>
    </ul>
    <div class="row mt40"> 
      <!--  Sideabar -->
      <aside class="col-lg-3 col-md-3 col-sm-12 col-xs-12"> 
        <!--Caegogries-->
        <div class="sidemodule">
          <h2 class="heading5"><span class="maintext"> Category</span></h2>
          <ul class="nav nav-list categories">
            <li> <a href="#">Real Estate </a></li>
            <li> <a href="#">Services </a></li>
            <li> <a href="#">Electronics </a>
              <ul class="nav nav-list">
                <li> <a href="#">Mobiles & Tablets </a>
                  <ul class="nav nav-list">
                    <li class="active"> <a href="#">Mobile Phones </a> </li>
                  </ul>
                </li>
              </ul>
            </li>
          </ul>
        </div>
        <!-- Latest Blog-->
        <div class="mt40">
          <h5 class="heading5"><span class="maintext">Latest Blog</span></h5>
          <div id="latestblog">
            <ul>
              <li> <img class="pull-left" width="100" title="blog" alt="blog" src="img/blog1.jpg">
                <div class="blogdate"> <span class="blogicon"><i class="fa fa-calendar"></i> September 5, 2013 </span> <span class="blogicon"><a ><i class="fa fa-comment"></i> 5 Comments</a> </span> <span class="blogicon"><a class="orange" ><i class="fa fa-user"></i> by : pxcreate </a> </span> </div>
                <a href="blog.html" class="blogtitle">Lorem Ipsum is simply dummy...</a> </li>
              <li> <img class="pull-left" width="100" title="blog" alt="blog" src="img/blog1.jpg">
                <div class="blogdate"> <span class="blogicon"><i class="fa fa-calendar"></i> September 5, 2013 </span> <span class="blogicon"><a ><i class="fa fa-comment"></i> 5 Comments</a> </span> <span class="blogicon"><a class="orange" ><i class="fa fa-user"></i> by : pxcreate </a> </span> </div>
                <a href="blog.html" class="blogtitle">Dummy text of the printing text...</a> </li>
            </ul>
          </div>
        </div>
        <!-- Cloud Plgin-->
        <div class="mt40">
          <h5 class="heading5"><span class="maintext">Cloud</span></h5>
          <div id="cloud"></div>
        </div>
         <!--Latest News-->
        <div class="mt40">
          <h5 class="heading5"><span class="maintext">Latest News</span></h5>
          <div id="latestnews">
            <ul>
              <li>
                <div class="date"><span class="datetext">25</span><br>
                  March 2014</div>
                Lorem Ipsum is simply dummy text of the printing and typesetting dummy text of industry. <a href="#"> Read more</a> </li>
              <li>
                <div class="date"><span class="datetext">05</span><br>
                  Jan 2014</div>
                Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a Latin.<a href="#"> Read more</a> </li>
            </ul>
          </div>
        </div> 
        <!-- Ad Banner-->
        <div class="mt40 banner"> <img  title="Banner" alt="Banner" src="img/ad1.jpg"> </div>
      </aside>
      <!--  Container -->
      <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 mt40column"> 
        <!--Sorting-->
        <div class="sorting well">
          <form class=" form-inline pull-left">
            Sort By :
            <select class="span2">
              <option>Default</option>
              <option>Name</option>
              <option>Pirce</option>
              <option>Date </option>
            </select>
            &nbsp;&nbsp;
            Show:
            <select class="span1">
              <option>10</option>
              <option>15</option>
              <option>20</option>
              <option>25</option>
              <option>30</option>
            </select>
          </form>
          <div class="btn-group pull-right">
            <button class="btn " id="list"><i class="fa fa-th-list"></i> </button>
            <button class="btn btn-orange" id="grid"><i class="fa fa-th  fa-white"></i></button>
          </div>
        </div>
        <!-- Listing-->
        <div class="mt40" id="bloglist">
          <div class="bloglisting grid">
            <ul class="mt30 clearfix row">
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a>
                  <div class="category color6"> <i class="fa fa-mobile-phone"></i> Mobile</div>
                  <div>
                    <h3><a class="title" href="#">Your First Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a>
                  <div class="category color2"> <i class="fa fa-cutlery"></i> Food</div>
                  <div>
                    <h3><a class="title" href="#">Your Second Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a>
                  <div class="category color9"> <i class="fa fa-glass"></i> Hobbies</div>
                  <div>
                    <h3><a class="title" href="#">Your First Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
            </ul>
            <ul class="mt30 clearfix row">
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a>
                  <div class="category color10"> <i class="fa fa-video-camera"></i> Movies</div>
                  <div>
                    <h3><a class="title" href="#">Your Fourth Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a>
                  <div class="category color7"> <i class="fa fa-camera"></i> Camera</div>
                  <div>
                    <h3><a class="title" href="#">Your Next Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a>
                  <div class="category color3"> <i class="fa fa-user-md"></i> Health</div>
                  <div>
                    <h3><a class="title" href="#">Your First Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
            </ul>
            <ul class="mt30 clearfix row">
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a>
                  <div class="category color1"> <i class="fa fa-mobile-phone"></i> Mobile</div>
                  <div>
                    <h3><a class="title" href="#">Your First Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a>
                  <div class="category color4"> <i class="fa fa-cutlery"></i> Food</div>
                  <div>
                    <h3><a class="title" href="#">Your Second Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a>
                  <div class="category color6"> <i class="fa fa-glass"></i> Hobbies</div>
                  <div>
                    <h3><a class="title" href="#">Your First Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
            </ul>
            <ul class="mt30 clearfix row">
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a>
                  <div class="category color10"> <i class="fa fa-video-camera"></i> Movies</div>
                  <div>
                    <h3><a class="title" href="#">Your Fourth Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a>
                  <div class="category color7"> <i class="fa fa-camera"></i> Camera</div>
                  <div>
                    <h3><a class="title" href="#">Your Next Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a>
                  <div class="category color3"> <i class="fa fa-user-md"></i> Health</div>
                  <div>
                    <h3><a class="title" href="#">Your First Blog Title</a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn comment"><i class="fa fa-comment-o"></i> 5 Comments</a> </div>
                </div>
              </li>
            </ul>
            
            <!-- Paging-->
            <div class="mt30 clearfix">
              <ul class="pagination pull-right">
                <li><a >Prev</a> </li>
                <li class="active"> <a >1</a> </li>
                <li><a >2</a> </li>
                <li><a >3</a> </li>
                <li><a >4</a> </li>
                <li><a >Next</a> </li>
              </ul>
            </div>
          </div>
          <div class="bloglisting list">
            <ul>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a>
                  <div class="personal category color1"> <i class="fa fa-user"></i> Category</div>
                </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Display Your First Blog Title here </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="tag"></div>
                  <div class="discrption">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. <br>
                    <a class="readmore" href="blog.html">Read More...</a> </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn comment"><i class="fa fa-comment-o"></i> 10 Comments</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a>
                  <div class="personal category color2"> <i class="fa fa-plane"></i> Vehicle </div>
                </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Display Your Second Blog Title here </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="tag"></div>
                  <div class="discrption">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. <br>
                    <a class="readmore" href="blog.html">Read More...</a> </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn comment"><i class="fa fa-comment-o"></i> 10 Comments</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a>
                  <div class="personal category color3"> <i class="fa fa-thumbs-o-up"></i> Services </div>
                </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Display Your Third Blog Title here </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="tag"></div>
                  <div class="discrption">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. <br>
                    <a class="readmore" href="blog.html">Read More...</a> </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn comment"><i class="fa fa-comment-o"></i> 10 Comments</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a>
                  <div class="personal category color4"> <i class="fa fa-home"></i> For Rent </div>
                </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Display Your Fourth Blog Title here </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="tag"></div>
                  <div class="discrption">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. <br>
                    <a class="readmore" href="blog.html">Read More...</a> </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn comment"><i class="fa fa-comment-o"></i> 10 Comments</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a>
                  <div class="personal category color5"> <i class="fa fa-suitcase"></i> Jobs </div>
                </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Display Your Fifth Blog Title here </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="tag"></div>
                  <div class="discrption">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. <br>
                    <a class="readmore" href="blog.html">Read More...</a> </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn comment"><i class="fa fa-comment-o"></i> 10 Comments</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a>
                  <div class="personal category color6"> <i class="fa fa-users"></i> Community </div>
                </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Display Your Sixth Blog Title here </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="tag"></div>
                  <div class="discrption">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. <br>
                    <a class="readmore" href="blog.html">Read More...</a> </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn comment"><i class="fa fa-comment-o"></i> 10 Comments</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a>
                  <div class="personal category color1"> <i class="fa fa-user"></i> Category</div>
                </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Display Your First Blog Title here </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="tag"></div>
                  <div class="discrption">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. <br>
                    <a class="readmore" href="blog.html">Read More...</a> </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn comment"><i class="fa fa-comment-o"></i> 10 Comments</a> </div>
              </li>
            </ul>
            <!-- Paging-->
            <div class="mt30 clearfix">
              <ul class="pagination pull-right">
                <li><a >Prev</a> </li>
                <li class="active"> <a >1</a> </li>
                <li><a >2</a> </li>
                <li><a >3</a> </li>
                <li><a >4</a> </li>
                <li><a >Next</a> </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Social-->
  <div class="container mt20">
    <h2 class="heading3">Social</h2>
    <div class="mt40" id="social" >
      <ul class="row clearfix">
        <li class="col-md-3 col-sm-6">
          <h5 class="heading5">Twitter</h5>
          <div id="twitter"> </div>
        </li>
        <li class="col-md-3 col-sm-6 mt40column">
          <h5 class="heading5">Flickr</h5>
           <div class="social-feed flickr-feed">
          <img src="img/photo1.jpg" alt="" title=""/>
          <img src="img/photo2.jpg" alt="" title=""/>
          <img src="img/photo3.jpg" alt="" title=""/>
          <img src="img/photo4.jpg" alt="" title=""/>
          <img src="img/photo4.jpg" alt="" title=""/>
          <img src="img/photo2.jpg" alt="" title=""/>
          <img src="img/photo1.jpg" alt="" title=""/>
          <img src="img/photo3.jpg" alt="" title=""/>
          <img src="img/photo1.jpg" alt="" title=""/>
          <img src="img/photo2.jpg" alt="" title=""/>
          <img src="img/photo3.jpg" alt="" title=""/>
          <img src="img/photo4.jpg" alt="" title=""/>
          <img src="img/photo2.jpg" alt="" title=""/>
          <img src="img/photo4.jpg" alt="" title=""/>
          <img src="img/photo3.jpg" alt="" title=""/>
          <img src="img/photo1.jpg" alt="" title=""/>
          </div>
        </li>
        <li class="col-md-3 col-sm-6 mt40column">
          <h5 class="heading5">Youtube</h5>
          <div class="social-feed youtube-feed"> </div>
        </li>
        <li class="col-md-3 col-sm-6 mt40column">
          <h5 class="heading5">Facebook</h5>
          <div class="">
            <div id="fb-root"></div>
            <script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "../../../connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
            <div class="fb-like-box" data-href="https://www.facebook.com/facebook" data-width="240" data-show-faces="true" data-colorscheme="light" data-stream="false" data-show-border="false" data-header="false"  data-height="240"></div>
          </div>
        </li>
      </ul>
    </div>
  </div>
  <!-- Newsletter-->
  <section class="mt40 newsletter" id="newslettersignup">
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-sm-12">
          <div class="pull-left ">
            <h5 class="heading5 borderbottm"> Newsletters Signup</h5>
            Sign up to Our Newsletter &amp; get attractive Offers by subscribing to our newsletters. </div>
        </div>
        <div class="col-md-6 col-sm-12">
          <div class="pull-right mt20 surbscribeform">
            <form class="form-inline">
              <div class="input-prepend">
                <input type="text" class="subscribeinput" id="inputIcon" placeholder="Subscribe to Newsletter">
                <input type="submit" class="btn btn-orange" value="Subscribe">
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- Got to top --> 
  <a id="gotop"><i class="fa fa-arrow-circle-up"></i></a> </div>
<div id="styleswitch">
  <h3>Style Color switcher <i class="fa fa-cogs"></i> </h3>
  <a href="javascript: void(0)" title="switch styling" id="color1">color1</a> <a href="javascript: void(0)" title="switch styling" id="color2">color2</a> <a href="javascript: void(0)" title="switch styling" id="color3">color3</a> <a href="javascript: void(0)" title="switch styling" id="color4">color4</a> <a href="javascript: void(0)" title="switch styling" id="color5">color5</a> <a href="javascript: void(0)" title="switch styling" id="color6">color6</a> <a href="javascript: void(0)" title="switch styling" id="color7">color7</a> <a href="javascript: void(0)" title="switch styling" id="color8">color8</a> <a href="javascript: void(0)" title="switch styling" id="color9">color9</a> <a href="javascript: void(0)" title="switch styling" id="color10">color10</a> <a href="javascript: void(0)" title="switch styling" id="color11">color11</a> <a href="javascript: void(0)" title="switch styling" id="color12">color12</a> <a href="javascript: void(0)" title="switch styling" id="color13">color13</a> <a href="javascript: void(0)" title="switch styling" id="color14">color14</a> <a href="javascript: void(0)" title="switch styling" id="color15">color15</a> <a href="javascript: void(0)" title="switch styling" id="color16">color16</a> <a href="javascript: void(0)" title="switch styling" id="color17">color17</a> <a href="javascript: void(0)" title="switch styling" id="color18">color18</a> <a href="javascript: void(0)" title="switch styling" id="color19">color19</a> <a href="javascript: void(0)" title="switch styling" id="color20">color20</a> </div>
<!-- Placed at the end of the document so the pages load faster --> 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="js/jquery.js"></script> 
<script src="js/jquery-migrate-1.2.1.js"></script> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="js/bootstrap.min.js"></script> 
<!-- include jQuery + carouFredSel plugin --> 
<script src="js/jquery.carouFredSel-6.2.1-packed.js"></script> 
<!-- Flex slider Blog--> 
<script src="js/jquery.flexslider.js"></script> 
<!-- Jquery zoom on detail page--> 
<script  src="js/zoomsl-3.0.min.js"></script> 
<!-- Jquery Validation--> 
<script  type="text/javascript" src="js/jquery.validate.js"></script> 
<!-- Jquery Latest Tweet--> 
<script type="text/javascript" src="js/jquery.tweet.js"></script> 
<!-- Jquery Countdown--> 
<script type="text/javascript" src="js/jquery.countdown.js"></script> 
<!-- Social --> 
<script type="text/javascript" src="js/socialstream.jquery.js"></script> 
<!-- Jquery Map --> 
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script> 
<script type="text/javascript" src="js/jquery.gmap.js"></script> 
<!-- Sparkline --> 
<script type="text/javascript" src="js/jquery.sparkline.min.js"></script> 
<!-- Cloud --> 
<script type="text/javascript" src="js/jqcloud-1.0.4.js"></script>
<!-- Ratina View --> 
<script type="text/javascript" src="js/retina-1.1.0.min.js"></script> 
<!-- Custom --> 
<script src="js/custom.js"></script> 
<script type="text/javascript" src="js/jquery.style-switcher.js"></script> 
<script type="text/javascript">
$(document).ready(function() {
	$('#styleswitch').styleSwitcher();
	$("#styleswitch h3").click(function () {
		if($(this).parent().css("left") == "-200px"){
			$(this).parent().animate({left:'0px'}, {queue: false, duration: 500});
 		} else {
    	$(this).parent().animate({left:'-200px'}, {queue: false, duration: 500});
  		}
 	 });
});
</script>
</body>

<!-- Mirrored from www.pxcreate.com/bootstrap/classic/bloggrid.html by HTTrack Website Copier/3.x [XR&CO'2013], Tue, 14 Jul 2015 12:02:47 GMT -->
</html>