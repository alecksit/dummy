<!DOCTYPE html>
<html>

<!-- Mirrored from www.pxcreate.com/bootstrap/classic/listing-grid.html by HTTrack Website Copier/3.x [XR&CO'2013], Tue, 14 Jul 2015 12:02:41 GMT -->
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
      <li> <a >My Account</a> </li>
      <li class="active">Listing</li>
    </ul>
    <div class="row mt40"> 
      <!--  Sideabar -->
      <aside class="col-lg-3 col-md-3 col-sm-12 col-xs-12"> 
        
        <!--Filter-->
        <div class="filter sidemodule">
          <h2 class="heading5"><span class="maintext">Filter Search</span></h2>
          <h5 class="subheading">Price</h5>
          <ul class="checkprice">
            <li>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="">
                  Rs. 999 and Below (0) </label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="">
                  Rs. 1000 - Rs. 1999 </label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="">
                  Rs. 2000 - Rs. 3999 </label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="">
                  Rs. 3000 - Rs. 5000 </label>
              </div>
            </li>
          </ul>
          <h5 class="subheading">brand</h5>
          <input type="search" class="form-control brandsearch" placeholder="Search Brand">
          <ul class="searchbrand">
            <li>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="">
                  Sony </label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="">
                  Samsung </label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="">
                  Nokia </label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="">
                  HTC </label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="">
                  Micromax </label>
              </div>
            </li>
          </ul>
          <h5 class="subheading">Search Only</h5>
          <ul class="searcholy">
            <li>
              <div class="radio">
                <label>
                  <input type="radio" value="option1" id="option1">
                  Rs. 2000 and Below (0) </label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <label>
                  <input type="radio" value="option2" id="option2">
                  Rs. 2000 and Below (0) </label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <label>
                  <input type="radio" value="option3" id="option3">
                  Rs. 2000 and Below (0) </label>
              </div>
            </li>
          </ul>
        </div>
        
        <!--Location-->
        <div class="sidemodule">
          <h2 class="heading5"><span class="maintext"> Location</span></h2>
          <ul class="nav nav-list categories">
            <li> <a href="#">Paris, Hong Kongs</a> </li>
            <li> <a href="#">Washington D.C. </a></li>
            <li> <a href="#">Bangkok</a> </li>
            <li> <a href="#">Singapore </a></li>
            <li> <a href="#">New York</a> </li>
            <li> <a href="#">Kuala Lumpur </a></li>
          </ul>
        </div>
        
        <!--Caegogries-->
        <div class="sidemodule">
          <h2 class="heading5"><span class="maintext"> Refine Category</span></h2>
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
            <button class="btn " id="list"><i class="fa fa-th-list "></i> </button>
            <button class="btn btn-orange" id="grid"><i class="fa fa-th fa-white  "></i></button>
          </div>
        </div>
        <!-- Listing-->
        <div class="mt40" id="serchlist">
          <div class="searchresult grid">
            <ul class="mt30 clearfix row">
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a>
                  <div class="featured">Featured</div>
                  <div>
                    <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                      <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a>
                  <div class="latest">Latest</div>
                  <div>
                    <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                      <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a>
                  <div>
                    <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                      <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
                </div>
              </li>
            </ul>
            <ul class="mt30 clearfix row">
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a>
                  <div>
                    <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                      <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a>
                  <div class="featured">Featured</div>
                  <div>
                    <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                      <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a>
                  <div>
                    <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                      <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
                </div>
              </li>
            </ul>
            <ul class="mt30 clearfix row">
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a>
                  <div>
                    <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                      <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a>
                  <div>
                    <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                      <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
                </div>
              </li>
              <li class="col-sm-4">
                <div class="searchgrid"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a>
                  <div>
                    <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                    <ul class="icondetail">
                      <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                      <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                      <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                      <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                    </ul>
                  </div>
                  <div>
                    <div class="share"> Share On : <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                    <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
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
          <div class="searchresult list">
            <ul>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a>
                  <div class="featured">Featured</div>
                </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                    <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="discrption"> White, 8 GB, 2G, 3G, Wi-Fi, Bluetooth Headset - > Samsung Galaxy Tab 3 T211 Tablet <br>
                    Dual SIM (GSM + GSM), 5 MP Primary Camera, 0.3 MP Secondary Camera,   Android v4.2 OS </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a> </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                    <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="discrption"> White, 8 GB, 2G, 3G, Wi-Fi, Bluetooth Headset - > Samsung Galaxy Tab 3 T211 Tablet <br>
                    Dual SIM (GSM + GSM), 5 MP Primary Camera, 0.3 MP Secondary Camera,   Android v4.2 OS </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a>
                  <div class="latest">Latest</div>
                </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                    <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="discrption"> White, 8 GB, 2G, 3G, Wi-Fi, Bluetooth Headset - > Samsung Galaxy Tab 3 T211 Tablet <br>
                    Dual SIM (GSM + GSM), 5 MP Primary Camera, 0.3 MP Secondary Camera,   Android v4.2 OS </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a> </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                    <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="discrption"> White, 8 GB, 2G, 3G, Wi-Fi, Bluetooth Headset - > Samsung Galaxy Tab 3 T211 Tablet <br>
                    Dual SIM (GSM + GSM), 5 MP Primary Camera, 0.3 MP Secondary Camera,   Android v4.2 OS </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a> </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                    <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="discrption"> White, 8 GB, 2G, 3G, Wi-Fi, Bluetooth Headset - > Samsung Galaxy Tab 3 T211 Tablet <br>
                    Dual SIM (GSM + GSM), 5 MP Primary Camera, 0.3 MP Secondary Camera,   Android v4.2 OS </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a> </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                    <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="discrption"> White, 8 GB, 2G, 3G, Wi-Fi, Bluetooth Headset - > Samsung Galaxy Tab 3 T211 Tablet <br>
                    Dual SIM (GSM + GSM), 5 MP Primary Camera, 0.3 MP Secondary Camera,   Android v4.2 OS </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product1.jpg" alt=""></a> </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                    <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="discrption"> White, 8 GB, 2G, 3G, Wi-Fi, Bluetooth Headset - > Samsung Galaxy Tab 3 T211 Tablet <br>
                    Dual SIM (GSM + GSM), 5 MP Primary Camera, 0.3 MP Secondary Camera,   Android v4.2 OS </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product2.jpg" alt=""></a> </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                    <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="discrption"> White, 8 GB, 2G, 3G, Wi-Fi, Bluetooth Headset - > Samsung Galaxy Tab 3 T211 Tablet <br>
                    Dual SIM (GSM + GSM), 5 MP Primary Camera, 0.3 MP Secondary Camera,   Android v4.2 OS </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
              </li>
              <li class="clearfix">
                <div class="col-sm-2"> <a class="thumbnail" href="detail.html"><img src="img/product3.jpg" alt=""></a> </div>
                <div class="col-sm-8">
                  <h3><a class="title" href="#">Samsung Galaxy Tab 3 T211 Tablet </a></h3>
                  <ul class="icondetail">
                    <li><i class="fa fa-th-list"></i> Category : <a href="#">Mobile</a></li>
                    <li><i class="fa fa-map-marker"></i> Location : California, U.S.</li>
                    <li><i class="fa fa-calendar"></i> Posted On : Mach 22, 2014 </li>
                    <li><i class="fa fa-user"></i> Posted by : <a href="#">pxcreate</a></li>
                  </ul>
                  <div class="discrption"> White, 8 GB, 2G, 3G, Wi-Fi, Bluetooth Headset - > Samsung Galaxy Tab 3 T211 Tablet <br>
                    Dual SIM (GSM + GSM), 5 MP Primary Camera, 0.3 MP Secondary Camera,   Android v4.2 OS </div>
                </div>
                <div class="col-sm-2">
                  <div class="share"> Share On : <br>
                    <a data-original-title="Facebook" class="tooltip-test"><i class="fa fa-facebook"></i></a> <a data-original-title="Twitter" class="tooltip-test"><i class="fa fa-twitter"></i></a> <a data-original-title="Google Plus" class="tooltip-test"><i class="fa fa-google-plus"></i></a> </div>
                  <a class="btn  contact"><i class="fa fa-envelope-o"></i> Contact</a> </div>
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

<!-- Mirrored from www.pxcreate.com/bootstrap/classic/listing-grid.html by HTTrack Website Copier/3.x [XR&CO'2013], Tue, 14 Jul 2015 12:02:41 GMT -->
</html>