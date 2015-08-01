<!DOCTYPE html>
<html>

<!-- Mirrored from www.pxcreate.com/bootstrap/classic/features.html by HTTrack Website Copier/3.x [XR&CO'2013], Tue, 14 Jul 2015 12:02:47 GMT -->
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
  <div class="container"> 
    <!--  breadcrumb -->
    <ul class="breadcrumb">
      <li> <a >Home</a> </li>
      <li class="active"> <a >Features</a> </li>
    </ul>
    <div class="row mt40">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
        
        <!--  Modal -->
        <section id="modals">
          <h2 class="heading5"> <span>Modals bootstrap</span> </h2>
          <h3>Live demo</h3>
          <p>Toggle a modal via JavaScript by clicking the button below. It will slide down and fade in from the top of the page.</p>
          <!-- sample modal content --> 
          <!-- Button trigger modal --> 
          <a data-toggle="modal" href="#myModal" class="btn btn-orange btn-lg">Launch demo modal</a> 
          
          <!-- Modal -->
          <div class="modal fade" id="myModal" tabindex="-1" role="dialog"  aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title">Modal title</h4>
                </div>
                <div class="modal-body"> ... </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-orange" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary">Save changes</button>
                </div>
              </div>
              <!-- /.modal-content --> 
            </div>
            <!-- /.modal-dialog --> 
          </div>
          <!-- /.modal --> 
          
        </section>
        <div class="row mt40"> 
          <!--  Tab -->
          <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <h2 class="heading5"> <span>Html Tabs</span> </h2>
            <ul class="nav nav-tabs mytabs">
              <li class=""><a href="#home" data-toggle="tab">Home</a> </li>
              <li class=""><a href="#profile" data-toggle="tab">Profile</a> </li>
              <li class=""><a href="#messages" data-toggle="tab">Messages</a> </li>
              <li class="active"><a href="#settings" data-toggle="tab">Settings</a> </li>
            </ul>
            <div class="tab-content">
              <div class="tab-pane" id="home">Sed pretium, ligula sollicitudin laoreet viverra, tortor libero sodales leo, eget blandit nunc tortor eu nibh. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapibus id, mattis vel, nisi. Nullam mollis.. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapiPhasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapi</div>
              <div class="tab-pane" id="profile">Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapibus id, mattis vel, nisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed pretium, ligula sollicitudin laoreet viverra, tortor libero sodales leo, eget blandit nunc tortor eu nibh. Nullam mollis Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapi</div>
              <div class="tab-pane" id="messages">Sed pretium, ligula sollicitudin laoreet viverra, tortor libero sodales leo, eget blandit nunc tortor eu nibh. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapibus id, mattis vel, nisi. Nullam mollis. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapi</div>
              <div class="tab-pane active" id="settings"> Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapibus id, mattis vel, nisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed pretium, ligula sollicitudin laoreet viverra, tortor libero sodales leo, eget blandit nunc tortor eu nibh Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapi</div>
            </div>
          </div>
          <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"> 
            <!--  Tooltips -->
            <section id="tooltip">
              <h2 class="heading5"> <span class="maintext">Tooltips</span> </h2>
              <h3>Four directions</h3>
              <div class="bs-docs-example tooltip-demo">
                <ul class="bs-docs-tooltip-examples listoption4">
                  <li><a  class="tooltip-test" data-toggle="tooltip" data-placement="top" title="Tooltip on top">Tooltip on top</a></li>
                  <li><a  class="tooltip-test" data-toggle="tooltip" data-placement="right" title="Tooltip on right">Tooltip on right</a></li>
                  <li><a  class="tooltip-test" data-toggle="tooltip" data-placement="bottom" title="Tooltip on bottom">Tooltip on bottom</a></li>
                  <li><a  class="tooltip-test" data-toggle="tooltip" data-placement="left" title="Tooltip on left">Tooltip on left</a></li>
                </ul>
              </div>
            </section>
          </div>
        </div>
        <section class="messages mt40">
          <h2 class="heading4"><span class="maintext">Messages</span></h2>
          <div class="infomsg alert"><i class="fa fa-info-circle font36"></i><i class="fa fa-times-circle"></i><strong>Information!</strong> Lorem Ipsum is simply dummy </div>
          <div class="successmsg alert"> <i class="fa fa-check-circle-o font36"></i><i class="fa fa-times-circle"></i> <strong>Sucess!</strong> Lorem Ipsum is simply dummy </div>
          <div class="errormsg alert"> <i class="fa fa-frown-o font36"></i><i class="fa fa-times-circle"></i><strong>Error!</strong> Lorem Ipsum is simply dummy </div>
          <div class="alertmsg alert"><i class="fa fa-warning font36"></i><i class="fa fa-times-circle"></i> <strong>Alert!</strong> Lorem Ipsum is simply dummy </div>
          <div class="infomsg2 alert"> <i class="fa fa-info-circle font36"></i><i class="fa fa-times-circle"></i><strong>Information!</strong> Lorem Ipsum is simply dummy </div>
        </section>
        <div class="row mt40">
          <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <h2 class="heading5"> <span>Accordion</span> </h2>
            <a class="accrodian-trigger" >Accrodian 1</a>
            <div class="accrodian-data">
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat eu</p>
            </div>
            <a class="accrodian-trigger" >Accrodian 2</a>
            <div class="accrodian-data">
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat eu</p>
            </div>
            <a class="accrodian-trigger" >Accrodian 3</a>
            <div class="accrodian-data">
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat eu</p>
            </div>
            <a class="accrodian-trigger" >Accrodian 4</a>
            <div class="accrodian-data">
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat eu</p>
            </div>
            <a class="accrodian-trigger" >Accrodian 5</a>
            <div class="accrodian-data">
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat eu</p>
            </div>
            <a class="accrodian-trigger" >Accrodian 5</a>
            <div class="accrodian-data">
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat eu</p>
            </div>
          </div>
          <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <h2 class="heading5"> <span>Toggles</span> </h2>
            <div class="togglehandle">Toggle1</div>
            <div class="toggledata">
              <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat euLorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat eu</p>
            </div>
            <div class="togglehandle">Toggle2</div>
            <div class="toggledata">
              <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat euLorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat eu</p>
            </div>
            <div class="togglehandle">Toggle3</div>
            <div class="toggledata">
              <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat euLorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nisl orci, condimentum ultrices consequat eu</p>
            </div>
          </div>
        </div>
        
        <!-- Collapse -->
        <section id="collapse" class="mt40">
          <h2 class="heading5"> <span>Collapse</span> </h2>
          <div class="bs-docs-example">
            <div class="panel-group" id="accordion">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title"> <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"> Collapsible Group Item #1 </a> </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in">
                  <div class="panel-body"> Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS. </div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title"> <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"> Collapsible Group Item #2 </a> </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse">
                  <div class="panel-body"> Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS. </div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title"> <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree"> Collapsible Group Item #3 </a> </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse">
                  <div class="panel-body"> Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS. </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
    <div class="row mt40">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
        
        <!-- features-->
        <h2 class="heading5"><span class="maintext">Typography</span><span class="subtext">See Our Typography, List Items, Tables, Icons</span></h2>
        <!-- Typo-->
        <section id="typography"> 
          <!-- Headings & Paragraph Copy -->
          <p> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. </p>
          <br>
          <h1>h1. Heading 1</h1>
          <p> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. </p>
          <h2>h2. Heading 2</h2>
          <p> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. </p>
          <h3>h3. Heading 3</h3>
          <p> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. </p>
          <h4>h4. Heading 4</h4>
          <p> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. </p>
          <h5>h5. Heading 5</h5>
          <p> Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. </p>
          
          <strong></strong> <br>
          <br>
          
          <!-- Blockquotes -->
          <h2 class="heading5"><span class="maintext">Blockquotes</span></h2>
          <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <p>To include a blockquote, wrap <code>&lt;blockquote&gt;</code> around any <abbr title="HyperText Markup Language">HTML</abbr> as the quote. For straight quotes we recommend a <code>&lt;p&gt;</code>.</p>
              <p>Include an optional <code>&lt;small&gt;</code> element to cite your source and you'll get an em dash <code>&amp;mdash;</code> before it for styling purposes.</p>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
              <div class="prettyprint linenums">
                <ol class="linenums">
                  <li class="L0"><span class="tag">&lt;blockquote&gt;</span></li>
                  <li class="L1"><span class="pln"> </span><span class="tag">&lt;p&gt;</span><span class="pln">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante venenatis.</span><span class="tag">&lt;/p&gt;</span></li>
                  <li class="L2"><span class="pln"> </span><span class="tag">&lt;small&gt;</span><span class="pln">Someone famous</span><span class="tag">&lt;/small&gt;</span></li>
                  <li class="L3"><span class="tag">&lt;/blockquote&gt;</span></li>
                </ol>
              </div>
            </div>
          </div>
          <!--/row--> 
          <br>
          <br>
          <h2 class="">
          Example blockquotes
          </h2>
          <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
              <p>Default blockquotes are styled as such:</p>
              <blockquote>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante venenatis.</p>
                <small>Someone famous in <cite title="">Body of work</cite></small> </blockquote>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
              <p>To float your blockquote to the right, add <code>class="pull-right"</code>:</p>
              <blockquote class="pull-right">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante venenatis.</p>
                <small>Someone famous in <cite title="">Body of work</cite></small> </blockquote>
            </div>
          </div>
          
          <!-- Lists -->
          <h2 class="heading5"><span class="maintext">Lists</span></h2>
          <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <h4 class="">Unordered</h4>
              <p><code>&lt;ul&gt;</code></p>
              <ul class="listoption1">
                <li>Lorem ipsum dolor sit amet</li>
                <li>Consectetur adipiscing elit</li>
                <li>Integer molestie lorem at massa</li>
                <li>Facilisis in pretium nisl aliquet</li>
                <li>Nulla volutpat aliquam velit </li>
                <li>Faucibus porta lacus fringilla vel</li>
                <li>Aenean sit amet erat nunc</li>
                <li>Eget porttitor lorem</li>
              </ul>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <h4 class="">Unstyled</h4>
              <p><code>&lt;ul class="unstyled"&gt;</code></p>
              <ul class="unstyled listoption2">
                <li>Lorem ipsum dolor sit amet</li>
                <li>Consectetur adipiscing elit</li>
                <li>Integer molestie lorem at massa</li>
                <li>Facilisis in pretium nisl aliquet</li>
                <li>Nulla volutpat aliquam velit </li>
                <li>Faucibus porta lacus fringilla vel</li>
                <li>Aenean sit amet erat nunc</li>
                <li>Eget porttitor lorem</li>
              </ul>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <h4 class="">Unstyled</h4>
              <p><code>&lt;ul class="unstyled"&gt;</code></p>
              <ul class="unstyled listoption3">
                <li>Lorem ipsum dolor sit amet</li>
                <li>Consectetur adipiscing elit</li>
                <li>Integer molestie lorem at massa</li>
                <li>Facilisis in pretium nisl aliquet</li>
                <li>Nulla volutpat aliquam velit </li>
                <li>Faucibus porta lacus fringilla vel</li>
                <li>Aenean sit amet erat nunc</li>
                <li>Eget porttitor lorem</li>
              </ul>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <h4 class="">Unordered</h4>
              <p><code>&lt;ul&gt;</code></p>
              <ul class="listoption4">
                <li>Lorem ipsum dolor sit amet</li>
                <li>Consectetur adipiscing elit</li>
                <li>Integer molestie lorem at massa</li>
                <li>Facilisis in pretium nisl aliquet</li>
                <li>Nulla volutpat aliquam velit </li>
                <li>Faucibus porta lacus fringilla vel</li>
                <li>Aenean sit amet erat nunc</li>
                <li>Eget porttitor lorem</li>
              </ul>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <h4 class="">Unstyled</h4>
              <p><code>&lt;ul class="unstyled"&gt;</code></p>
              <ul class="unstyled listoption5">
                <li>Lorem ipsum dolor sit amet</li>
                <li>Consectetur adipiscing elit</li>
                <li>Integer molestie lorem at massa</li>
                <li>Facilisis in pretium nisl aliquet</li>
                <li>Nulla volutpat aliquam velit </li>
                <li>Faucibus porta lacus fringilla vel</li>
                <li>Aenean sit amet erat nunc</li>
                <li>Eget porttitor lorem</li>
              </ul>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <h4 class="">UnOrdered</h4>
              <p><code>&lt;ol&gt;</code></p>
              <ul class="listoption6">
                <li>Lorem ipsum dolor sit amet</li>
                <li>Consectetur adipiscing elit</li>
                <li>Integer molestie lorem at massa</li>
                <li>Facilisis in pretium nisl aliquet</li>
                <li>Nulla volutpat aliquam velit</li>
                <li>Faucibus porta lacus fringilla vel</li>
                <li>Aenean sit amet erat nunc</li>
                <li>Eget porttitor lorem</li>
              </ul>
            </div>
          </div>
          <div class="row mt40">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <h4 class="">Ordered</h4>
              <p><code>&lt;ol&gt;</code></p>
              <ol class="listoption1">
                <li>Lorem ipsum dolor sit amet</li>
                <li>Consectetur adipiscing elit</li>
                <li>Integer molestie lorem at massa</li>
                <li>Facilisis in pretium nisl aliquet</li>
                <li>Nulla volutpat aliquam velit</li>
                <li>Faucibus porta lacus fringilla vel</li>
                <li>Aenean sit amet erat nunc</li>
                <li>Eget porttitor lorem</li>
              </ol>
            </div>
          </div>
          
          <!-- /row --> 
          <br>
          <br>
        </section>
        <!-- Tabels-->
        <section id="tables">
          <div class="page-header">
            <h2 class="heading5"><span class="maintext">Tables</span></h2>
          </div>
          <h3>1. Default table styles</h3>
          <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <p>Tables are automatically styled with only a few borders to ensure readability and maintain structure. With 2.0, the <code>.table</code> class is required.</p>
              <div class="prettyprint linenums">
                <ol class="linenums">
                  <li class="L0"><span class="tag">&lt;table</span><span class="pln"> </span><span class="atn">class</span><span class="pun">=</span><span class="atv">"table"</span><span class="tag">&gt;</span></li>
                  <li class="L1"><span class="pln"> …</span></li>
                  <li class="L2"><span class="tag">&lt;/table&gt;</span></li>
                </ol>
              </div>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
              <table class="table">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <br>
          <br>
          <h3>2. Striped table</h3>
          <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <p>Get a little fancy with your tables by adding zebra-striping&mdash;just add the <code>.table-striped</code> class.</p>
              <p class="muted"><strong>Note:</strong> Striped tables use the <code>:nth-child</code> CSS selector and is not available in IE7-IE8.</p>
              <div style="margin-bottom: 18px;" class="prettyprint linenums">
                <ol class="linenums">
                  <li class="L0"><span class="tag">&lt;table</span><span class="pln"> </span><span class="atn">class</span><span class="pun">=</span><span class="atv">"table table-striped"</span><span class="tag">&gt;</span></li>
                  <li class="L1"><span class="pln"> …</span></li>
                  <li class="L2"><span class="tag">&lt;/table&gt;</span></li>
                </ol>
              </div>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <br>
          <br>
          <h3>3. Bordered table</h3>
          <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <p>Add borders around the entire table and rounded corners for aesthetic purposes.</p>
              <div class="prettyprint linenums">
                <ol class="linenums">
                  <li class="L0"><span class="tag">&lt;table</span><span class="pln"> </span><span class="atn">class</span><span class="pun">=</span><span class="atv">"table table-bordered"</span><span class="tag">&gt;</span></li>
                  <li class="L1"><span class="pln"> …</span></li>
                  <li class="L2"><span class="tag">&lt;/table&gt;</span></li>
                </ol>
              </div>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td rowspan="2">1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@TwBootstrap</td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <br>
          <br>
          <h3>4. Condensed table</h3>
          <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <p>Make your tables more compact by adding the <code>.table-condensed</code> class to cut table cell padding in half (from 8px to 4px).</p>
              <div style="margin-bottom: 18px;" class="prettyprint linenums">
                <ol class="linenums">
                  <li class="L0"><span class="tag">&lt;table</span><span class="pln"> </span><span class="atn">class</span><span class="pun">=</span><span class="atv">"table table-condensed"</span><span class="tag">&gt;</span></li>
                  <li class="L1"><span class="pln"> …</span></li>
                  <li class="L2"><span class="tag">&lt;/table&gt;</span></li>
                </ol>
              </div>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
              <table class="table table-condensed">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <br>
          <br>
          <h3>5. Combine them all!</h3>
          <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
              <p>Feel free to combine any of the table classes to achieve different looks by utilizing any of the available classes.</p>
              <div style="margin-bottom: 18px;" class="prettyprint linenums">
                <ol class="linenums">
                  <li class="L0"><span class="tag">&lt;table</span><span class="pln"> </span><span class="atn">class</span><span class="pun">=</span><span class="atv">"table table-striped table-bordered table-condensed"</span><span class="tag">&gt;</span></li>
                  <li class="L1"><span class="pln"> ...</span></li>
                  <li class="L2"><span class="tag">&lt;/table&gt;</span></li>
                </ol>
              </div>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
              <table class="table table-striped table-bordered table-condensed">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </section>
      </div>
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
<a id="gotop"><i class="fa fa-arrow-circle-up"></i></a>
</div>

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

<!-- Mirrored from www.pxcreate.com/bootstrap/classic/features.html by HTTrack Website Copier/3.x [XR&CO'2013], Tue, 14 Jul 2015 12:02:48 GMT -->
</html>
