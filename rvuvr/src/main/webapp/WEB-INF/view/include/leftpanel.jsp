<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    <div class="col-sm-4  hidden-xs">
            <div class="sidebar ">		
    <div class="row ">

        <div class="col-sm-11 hidden-xs">	
            <a class="btn btn-primary pull-right" id="regionsBtn" style="width: 100%">Greater London  <span class="caret"></span></a>
        </div>   
        
        <div data-backdrop="" id="regionsModal" class="bs-countries-modal-sm  hidden-xs" tabindex="-1" role="dialog" aria-labelledby="regionsModal" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="directory-counties">
                        <div class="col-sm-12">
                            <ul class="nav nav-tabs" id="myTab">
                                                                <li class=""><a data-toggle="tab"  href="#EN">England</a></li>
                                                                <li class=""><a data-toggle="tab"  href="#WA">Wales</a></li>
                                                                <li class=""><a data-toggle="tab"  href="#SC">Scotland</a></li>
                                                                <li class=""><a data-toggle="tab"  href="#NI">Northern Ireland</a></li>
                                                                <li class="dropdown">
                                    <a data-toggle="dropdown" class="dropdown-toggle" id="myTabDrop1" href="#">Other countries <b class="caret"></b></a>
                                    <ul aria-labelledby="myTabDrop1" role="menu" class="dropdown-menu">
                                        <li><a href="listings.html">USA</a></li>
                                        <li><a href="listings.html">France</a></li>
                                        <li><a href="listings.html">Germany</a></li>
                                        <li><a href="listings.html">Spain and Portugal</a></li>
                                        <li><a href="listings.html">Switzerland</a></li>
                                        <li><a href="listings.html">Other Europe</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <div class="tab-content " id="myTabContent">
                                                                <div id="popular" class="tab-pane fade counties-pane active">
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html">London</a><br />
                                                                                                <a href="listings.html">Edinburgh</a><br />
                                                                                                <a href="listings.html">Manchester</a><br />
                                                                                                <a href="listings.html">Birmingham</a><br />
                                                                                                <a href="listings.html">Glasgow</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html">Liverpool</a><br />
                                                                                                <a href="listings.html">Bristol</a><br />
                                                                                                <a href="listings.html">Oxford</a><br />
                                                                                                <a href="listings.html">Cambridge</a><br />
                                                                                                <a href="listings.html">Cardiff</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html">Brighton</a><br />
                                                                                                <a href="listings.html">Newcastle-upon-Tyne</a><br />
                                                                                                <a href="listings.html">Leeds</a><br />
                                                                                                <a href="listings.html">York</a><br />
                                                                                                <a href="listings.html">Inverness</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html">Bath</a><br />
                                                                                                <a href="listings.html">Nottingham</a><br />
                                                                                                <a href="listings.html">Reading</a><br />
                                                                                                <a href="listings.html">Aberdeen</a><br />
                                                                                                <a href="listings.html">Chester</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                    </div>


                                                                                                <div id="EN" class="tab-pane counties-pane">
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Avon</a><br />
                                                                                                <a href="listings.html" >Bedfordshire</a><br />
                                                                                                <a href="listings.html" >Berkshire</a><br />
                                                                                                <a href="listings.html" >Buckinghamshire</a><br />
                                                                                                <a href="listings.html" >Cambridgeshire</a><br />
                                                                                                <a href="listings.html" >Cheshire</a><br />
                                                                                                <a href="listings.html" >Cleveland</a><br />
                                                                                                <a href="listings.html" >Cornwall</a><br />
                                                                                                <a href="listings.html" >Cumbria</a><br />
                                                                                                <a href="listings.html" >Derbyshire</a><br />
                                                                                                <a href="listings.html" >Devon</a><br />
                                                                                                <a href="listings.html" >Dorset</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Durham</a><br />
                                                                                                <a href="listings.html" >East Sussex</a><br />
                                                                                                <a href="listings.html" >Essex</a><br />
                                                                                                <a href="listings.html" >Gloucestershire</a><br />
                                                                                                <a href="listings.html" >Hampshire</a><br />
                                                                                                <a href="listings.html" >Herefordshire</a><br />
                                                                                                <a href="listings.html" >Hertfordshire</a><br />
                                                                                                <a href="listings.html" >Isle of Wight</a><br />
                                                                                                <a href="listings.html" >Kent</a><br />
                                                                                                <a href="listings.html" >Lancashire</a><br />
                                                                                                <a href="listings.html" >Leicestershire</a><br />
                                                                                                <a href="listings.html" >Lincolnshire</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >London</a><br />
                                                                                                <a href="listings.html" >Merseyside</a><br />
                                                                                                <a href="listings.html" >Middlesex</a><br />
                                                                                                <a href="listings.html" >Norfolk</a><br />
                                                                                                <a href="listings.html" >Northamptonshire</a><br />
                                                                                                <a href="listings.html" >Northumberland</a><br />
                                                                                                <a href="listings.html" >North Humberside</a><br />
                                                                                                <a href="listings.html" >North Yorkshire</a><br />
                                                                                                <a href="listings.html" >Nottinghamshire</a><br />
                                                                                                <a href="listings.html" >Oxfordshire</a><br />
                                                                                                <a href="listings.html" >Rutland</a><br />
                                                                                                <a href="listings.html" >Shropshire</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Somerset</a><br />
                                                                                                <a href="listings.html" >South Humberside</a><br />
                                                                                                <a href="listings.html" >South Yorkshire</a><br />
                                                                                                <a href="listings.html" >Staffordshire</a><br />
                                                                                                <a href="listings.html" >Suffolk</a><br />
                                                                                                <a href="listings.html" >Surrey</a><br />
                                                                                                <a href="listings.html" >Tyne and Wear</a><br />
                                                                                                <a href="listings.html" >Warwickshire</a><br />
                                                                                                <a href="listings.html" >West Midlands</a><br />
                                                                                                <a href="listings.html" >West Sussex</a><br />
                                                                                                <a href="listings.html" >West Yorkshire</a><br />
                                                                                                <a href="listings.html" >Worcestershire</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                    </div>
                                                                                                <div id="WA" class="tab-pane counties-pane">
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Clwyd</a><br />
                                                                                                <a href="listings.html" >Dyfed</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Gwent</a><br />
                                                                                                <a href="listings.html" >Gwynedd</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Mid Glamorgan</a><br />
                                                                                                <a href="listings.html" >Powys</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >South Glamorgan</a><br />
                                                                                                <a href="listings.html" >West Glamorgan</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                    </div>
                                                                                                <div id="SC" class="tab-pane counties-pane">
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Aberdeenshire</a><br />
                                                                                                <a href="listings.html" >Angus</a><br />
                                                                                                <a href="listings.html" >Argyll</a><br />
                                                                                                <a href="listings.html" >Ayrshire</a><br />
                                                                                                <a href="listings.html" >Banffshire</a><br />
                                                                                                <a href="listings.html" >Berwickshire</a><br />
                                                                                                <a href="listings.html" >Bute</a><br />
                                                                                                <a href="listings.html" >Caithness</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Clackmannanshire</a><br />
                                                                                                <a href="listings.html" >Dumfriesshire</a><br />
                                                                                                <a href="listings.html" >Dunbartonshire</a><br />
                                                                                                <a href="listings.html" >East Lothian</a><br />
                                                                                                <a href="listings.html" >Fife</a><br />
                                                                                                <a href="listings.html" >Inverness-shire</a><br />
                                                                                                <a href="listings.html" >Kincardineshire</a><br />
                                                                                                <a href="listings.html" >Kinross-shire</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Kirkcudbrightshire</a><br />
                                                                                                <a href="listings.html" >Lanarkshire</a><br />
                                                                                                <a href="listings.html" >Midlothian</a><br />
                                                                                                <a href="listings.html" >Moray</a><br />
                                                                                                <a href="listings.html" >Nairnshire</a><br />
                                                                                                <a href="listings.html" >Orkney</a><br />
                                                                                                <a href="listings.html" >Peeblesshire</a><br />
                                                                                                <a href="listings.html" >Perthshire</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Renfrewshire</a><br />
                                                                                                <a href="listings.html" >Ross-shire</a><br />
                                                                                                <a href="listings.html" >Roxburghshire</a><br />
                                                                                                <a href="listings.html" >Selkirkshire</a><br />
                                                                                                <a href="listings.html" >Shetland</a><br />
                                                                                                <a href="listings.html" >Stirlingshire</a><br />
                                                                                                <a href="listings.html" >Sutherland</a><br />
                                                                                                <a href="listings.html" >West Lothian</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Wigtownshire</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                    </div>
                                                                                                <div id="NI" class="tab-pane counties-pane">
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Antrim</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Armagh</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Down</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Fermanagh</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Londonderry</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                        <div class="col-sm-3">

                                        <div class="row directory-block">
                                            <div class="col-sm-12">
                                                                                                <a href="listings.html" >Tyrone</a><br />
                                                                                            </div>
                                        </div>

                                    </div>
                                                                    </div>
                                                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>

    </div>        
    <br />

    <div class="row ">


        <div class="col-sm-11">

            <div class="panel panel-default">
                <div class="panel-heading">Filters</div>
                <div class="panel-body">
                    <form class="form-inline mini" style="margin-bottom: 0px;">
                        <fieldset>				

                            <div class="row filter-row">
                                <div class="col-sm-6">
                                    <label>Make</label>
                                </div>
                                <div class="col-sm-6">
                                    <select class=" form-control ">
                                        <option>Any</option>
                                        <option>Alfa romeo</option>
                                        <option>Houses</option>
                                        <option>Flats/ Apartments</option>
                                        <option>Bungalows</option>
                                        <option>Land</option>
                                        <option>Commercial property</option>
                                        <option>Other</option>
                                    </select>
                                </div>
                            </div>

                            <div class="row filter-row">
                                <div class="col-sm-6">
                                    <label>Mileage</label>
                                </div>
                                <div class="col-sm-6">
                                    <select class="col-sm-10 form-control ">
                                        <option>Any</option>
                                        <option>Alfa romeo</option>
                                        <option>Houses</option>
                                        <option>Flats/ Apartments</option>
                                        <option>Bungalows</option>
                                        <option>Land</option>
                                        <option>Commercial property</option>
                                        <option>Other</option>
                                    </select>
                                </div>
                            </div>

                            <div class="row filter-row">
                                <div class="col-sm-6">
                                    <label>Seller type</label>
                                </div>
                                <div class="col-sm-6">
                                    <select class="col-sm-10 form-control ">
                                        <option>Any</option>
                                        <option>Alfa romeo</option>
                                        <option>Houses</option>
                                        <option>Flats/ Apartments</option>
                                        <option>Bungalows</option>
                                        <option>Land</option>
                                        <option>Commercial property</option>
                                        <option>Other</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row filter-row">
                                <div class="col-sm-6">
                                    <label>Body type</label>
                                </div>
                                <div class="col-sm-6">
                                    <select class="col-sm-10 form-control ">
                                        <option>Any</option>
                                        <option>Alfa romeo</option>
                                        <option>Houses</option>
                                        <option>Flats/ Apartments</option>
                                        <option>Bungalows</option>
                                        <option>Land</option>
                                        <option>Commercial property</option>
                                        <option>Other</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row filter-row">
                                <div class="col-sm-6">
                                    <label>Fuel type</label>
                                </div>
                                <div class="col-sm-6">
                                    <select class="col-sm-10 form-control ">
                                        <option>Any</option>
                                        <option>Alfa romeo</option>
                                        <option>Houses</option>
                                        <option>Flats/ Apartments</option>
                                        <option>Bungalows</option>
                                        <option>Land</option>
                                        <option>Commercial property</option>
                                        <option>Other</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row filter-row">
                                <div class="col-sm-6">
                                    <label>Age</label>
                                </div>
                                <div class="col-sm-6">
                                    <select class="col-sm-10 form-control ">
                                        <option>Any</option>
                                        <option>Alfa romeo</option>
                                        <option>Houses</option>
                                        <option>Flats/ Apartments</option>
                                        <option>Bungalows</option>
                                        <option>Land</option>
                                        <option>Commercial property</option>
                                        <option>Other</option>
                                    </select>
                                </div>
                            </div>

                            <div class="row filter-row">
                                <div class="col-sm-12">
                                    <label>Price range</label>
                                </div>
                                <div class="col-sm-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">$</span>
                                        <input type="email" class="form-control price-input" placeholder="min" />
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="input-group">
                                        <span class="input-group-addon">$</span>
                                        <input type="email" class="form-control price-input" placeholder="max" />
                                    </div>
                                </div>
                            </div>
                            <div class="row filter-row">
                                <div class="col-sm-12">
                                    <label>Search only:</label>
                                </div>
                                <div class="col-sm-12">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios" value="option1" checked>
                                            Urgent ads
                                        </label>
                                    </div><br />

                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios" value="option2">
                                            Featured ads
                                        </label>
                                    </div><br />

                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="optionsRadios" value="option2">
                                            Only ads with pictures
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="row filter-row">	

                                <div class="col-sm-2 pull-right" style="margin-top: 10px;">
                                    <button class="btn btn-primary pull-right" type="submit">Update results</button>

                                </div>
                            </div>						


                        </fieldset>
                    </form>
                </div>
            </div>


        </div>
    </div>


    <div class="row ">
        <div class="col-sm-11">
            <div class="panel panel-default">
                <div class="panel-heading">Refine category</div>
                <div class="panel-body">
                    <ul class="nav nav-category">
                        <li>
                            <a class="active" href="category.html">All categories</a>
                            <ul>
                                <li><a href="listings.html">Cars, Vans & Motorbikes</a>
                                <ul>
                                    <li><a class="active" href="listings.html">Cars</a>
                                        <ul>
                                            <li><a class="active" href="listings.html"><strong>Porsche</strong></a> (66)<a href="#" class="remove-category"><i class="fa fa-times"></i></a></li>
                                        </ul>
                                    </li>

                                </ul>
                                    </li>
                            </ul>
                        </li>
                    </ul>				

                </div>
            </div>
        </div>
    </div>

    <div class="row ">
        <div class="col-sm-11">
            <div class="panel panel-default">
                <div class="panel-heading">Refine category</div>
                <div class="panel-body">

                    <div class="property">
                        <a href="#AC+Cobra">AC Cobra</a>
                    </div>
                    <div class="property">
                        <a href="#Acura">Acura</a>
                    </div>
                    <div class="property">
                        <a href="#Alfa+Romeo">Alfa Romeo</a>
                    </div>
                    <div class="property">
                        <a href="#American+Motors">American Motors</a>
                    </div>
                    <div class="property">
                        <a href="#Aston+Martin">Aston Martin</a>
                    </div>
                    <div class="more" id="more_make_link"><a href="#" class="more link-info" id="more_make">More ...</a></div>
                    <div id="more_make_list" style="display: none;">
                        <div class="property">
                            <a href="#Audi">Audi</a>
                        </div>
                        <div class="property">
                            <a href="#Austin+Healey">Austin Healey</a>
                        </div>
                        <div class="property">
                            <a href="#Avanti">Avanti</a>
                        </div>
                        <div class="property">
                            <a href="#Bentley">Bentley</a>
                        </div>
                        <div class="property">
                            <a href="#Bitter">Bitter</a>
                        </div>
                        <div class="property">
                            <a href="#BMW">BMW</a>
                        </div>
                        <div class="property">
                            <a href="#Bricklin">Bricklin</a>
                        </div>
                        <div class="property">
                            <a href="#British+Leyland">British Leyland</a>
                        </div>
                        <div class="property">
                            <a href="#Bugatti">Bugatti</a>
                        </div>
                        <div class="property">
                            <a href="#Buick">Buick</a>
                        </div>
                        <div class="property">
                            <a href="#Cadillac">Cadillac</a>
                        </div>
                        <div class="property">
                            <a href="#Caterham">Caterham</a>
                        </div>
                        <div class="property">
                            <a href="#Chevrolet">Chevrolet</a>
                        </div>
                        <div class="property">
                            <a href="#Chrysler">Chrysler</a>
                        </div>
                        <div class="property">
                            <a href="#Citroen">Citroen</a>
                        </div>
                        <div class="property">
                            <a href="#Daewoo">Daewoo</a>
                        </div>
                        <div class="property">
                            <a href="#Daihatsu">Daihatsu</a>
                        </div>
                        <div class="property">
                            <a href="#Dodge">Dodge</a>
                        </div>
                        <div class="property">
                            <a href="#Eagle">Eagle</a>
                        </div>
                        <div class="property">
                            <a href="#Ferrari">Ferrari</a>
                        </div>
                        <div class="property">
                            <a href="#Fiat">Fiat</a>
                        </div>
                        <div class="property">
                            <a href="#Ford">Ford</a>
                        </div>
                        <div class="property">
                            <a href="#FUJI+HEAVY+IND">FUJI HEAVY IND</a>
                        </div>
                        <div class="property">
                            <a href="#General+Motors">General Motors</a>
                        </div>
                        <div class="property">
                            <a href="#Geo">Geo</a>
                        </div>
                        <div class="property">
                            <a href="#Ginetta">Ginetta</a>
                        </div>
                        <div class="property">
                            <a href="#GMC">GMC</a>
                        </div>
                        <div class="property">
                            <a href="#Holden">Holden</a>
                        </div>
                        <div class="property">
                            <a href="#Honda">Honda</a>
                        </div>
                        <div class="property">
                            <a href="#Hummer">Hummer</a>
                        </div>
                        <div class="property">
                            <a href="#Hyundai">Hyundai</a>
                        </div>
                        <div class="property">
                            <a href="#Infiniti">Infiniti</a>
                        </div>
                        <div class="property">
                            <a href="#Isuzu">Isuzu</a>
                        </div>
                        <div class="property">
                            <a href="#Jaguar">Jaguar</a>
                        </div>
                        <div class="property">
                            <a href="#Jeep">Jeep</a>
                        </div>
                        <div class="property">
                            <a href="#Jensen">Jensen</a>
                        </div>
                        <div class="property">
                            <a href="#Kaiser">Kaiser</a>
                        </div>
                        <div class="property">
                            <a href="#Kia">Kia</a>
                        </div>
                        <div class="property">
                            <a href="#Lada">Lada</a>
                        </div>
                        <div class="property">
                            <a href="#Laforza">Laforza</a>
                        </div>
                        <div class="property">
                            <a href="#Lamborghini">Lamborghini</a>
                        </div>
                        <div class="property">
                            <a href="#Lancia">Lancia</a>
                        </div>
                        <div class="property">
                            <a href="#Land+Rover">Land Rover</a>
                        </div>
                        <div class="property">
                            <a href="#Lexus">Lexus</a>
                        </div>
                        <div class="property">
                            <a href="#Lincoln">Lincoln</a>
                        </div>
                        <div class="property">
                            <a href="#Lotus">Lotus</a>
                        </div>
                        <div class="property">
                            <a href="#Maserati">Maserati</a>
                        </div>
                        <div class="property">
                            <a href="#Matra">Matra</a>
                        </div>
                        <div class="property">
                            <a href="#Maybach">Maybach</a>
                        </div>
                        <div class="property">
                            <a href="#Mazda">Mazda</a>
                        </div>
                        <div class="property">
                            <a href="#Mercedes-Benz">Mercedes-Benz</a>
                        </div>
                        <div class="property">
                            <a href="#Mercury">Mercury</a>
                        </div>
                        <div class="property">
                            <a href="#Merkur">Merkur</a>
                        </div>
                        <div class="property">
                            <a href="#MG">MG</a>
                        </div>
                        <div class="property">
                            <a href="#Mini">Mini</a>
                        </div>
                        <div class="property">
                            <a href="#Mitsubishi">Mitsubishi</a>
                        </div>
                        <div class="property">
                            <a href="#Morgan">Morgan</a>
                        </div>
                        <div class="property">
                            <a href="#Nissan">Nissan</a>
                        </div>
                        <div class="property">
                            <a href="#Oldsmobile">Oldsmobile</a>
                        </div>
                        <div class="property">
                            <a href="#Opel">Opel</a>
                        </div>
                        <div class="property">
                            <a href="#Peugeot">Peugeot</a>
                        </div>
                        <div class="property">
                            <a href="#Plymouth">Plymouth</a>
                        </div>
                        <div class="property">
                            <a href="#Pontiac">Pontiac</a>
                        </div>
                        <div class="property">
                            <a href="#Porsche">Porsche</a>
                        </div>
                        <div class="property">
                            <a href="#Renault">Renault</a>
                        </div>
                        <div class="property">
                            <a href="#Rolls-Royce">Rolls-Royce</a>
                        </div>
                        <div class="property">
                            <a href="#Rover">Rover</a>
                        </div>
                        <div class="property">
                            <a href="#Saab">Saab</a>
                        </div>
                        <div class="property">
                            <a href="#Saturn">Saturn</a>
                        </div>
                        <div class="property">
                            <a href="#Scion">Scion</a>
                        </div>
                        <div class="property">
                            <a href="#Skoda">Skoda</a>
                        </div>
                        <div class="property">
                            <a href="#Smart">Smart</a>
                        </div>
                        <div class="property">
                            <a href="#Studebaker">Studebaker</a>
                        </div>
                        <div class="property">
                            <a href="#Subaru">Subaru</a>
                        </div>
                        <div class="property">
                            <a href="#Suzuki">Suzuki</a>
                        </div>
                        <div class="property">
                            <a href="#Tatra">Tatra</a>
                        </div>
                        <div class="property">
                            <a href="#Toyota">Toyota</a>
                        </div>
                        <div class="property">
                            <a href="#Trabant">Trabant</a>
                        </div>
                        <div class="property">
                            <a href="#TVR">TVR</a>
                        </div>
                        <div class="property">
                            <a href="#Vauxhall">Vauxhall</a>
                        </div>
                        <div class="property">
                            <a href="#Volkswagen">Volkswagen</a>
                        </div>
                        <div class="property">
                            <a href="#Volvo">Volvo</a>
                        </div>
                        <div class="property">
                            <a href="#Yugo">Yugo</a>
                        </div>
                        <div class="more"><a id="less_make" href="#" class="more link-info">Less ...</a></div>
                    </div>			

                </div>
            </div>
        </div>
    </div>

    <div class="row ">
        <div class="col-sm-11">
            <div class="panel panel-default">
                <div class="panel-heading">Location</div>
                <div class="panel-body">
                    <ul class="nav">
                        <li>
                            <a class="active" href="category.html">Greater London (12)</a>
                            <ul>
                                <li><a href="listings.html"> - Central London (11)</a></li>
                                <li><a class="active" href="listings.html"> - East London (1)</a></li>
                                <li><a class="active" href="listings.html"> - North London (1)</a></li>
                                <li><a class="active" href="listings.html"> - North London (1)</a></li>
                                <li><a class="active" href="listings.html"> - North West London  (1)</a></li>
                                <li><a class="active" href="listings.html"> - South East London  (1)</a></li>
                                <li><a class="active" href="listings.html"> - South West London  (1)</a></li>
                                <li><a class="active" href="listings.html"> - West London  (1)</a></li>
                            </ul>
                        </li>
                        <li><a href="category.html">Brighton (5)</a></li>
                        <li><a href="category.html">Cambridge (2)</a></li>
                        <li><a href="category.html">Essex (2)</a></li>
                        <li><a href="category.html">Guildford (2)</a></li>
                        <li><a href="category.html">Kent (2)</a></li>
                        <li><a href="category.html">Luton (2)</a></li>
                        <li><a href="category.html">Milton Keynes (2)</a></li>
                        <li><a href="category.html">Oxford (2)</a></li>
                        <li><a href="category.html">Reading (2)</a></li>
                    </ul>					

                </div>
            </div>
        </div>
    </div>	





</div>        </div> <!-- End left Search-->