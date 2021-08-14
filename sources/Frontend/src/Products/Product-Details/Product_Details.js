import React from "react";
import Narbar from "../../Components/Layout/Navbar/Navbar";
import Siderbar from "../../Components/Layout/Sidebar/Sidebar";
import Category from "../../Components/Layout/Sidebar/Category";
import { Link } from 'react-router-dom';
import Subcribe from "../../Components/Layout/Footer/Subcribe";
import Footer from "../../Components/Layout/Footer/Footer";
import Introduce from "../../Components/Layout/Footer/Introduce";


const Product_Details = () => {

    return (
        <>
            <div className="header">
                <Narbar></Narbar>
                <Siderbar></Siderbar>
                <div className="header-three">
                    {/* <!-- header-three --> */}
                    <div className="container">
                        <div className="menu">
                            <div className="cd-dropdown-wrapper">

                                <Category></Category>
                                {/* <!-- .cd-dropdown --> */}
                            </div>
                            {/* <!-- .cd-dropdown-wrapper -->	  */}
                        </div>
                        <div className="move-text">
                            <div className="marquee"><Link to="offers.html"> New collections are available here...... <span>Get extra 10% off on everything | no extra taxes </span> <span> Try shipping pass free for 15 days with unlimited</span></Link></div>
                            <script type="text/javascript" src="js/jquery.marquee.min.js"></script>

                        </div>
                    </div>
                </div>
            </div>
            {/* <!-- breadcrumbs -->  */}
            <div className="container">
                <ol className="breadcrumb breadcrumb1">
                    <li><Link to="index.html">Home</Link></li>
                    <li className="active">Single Page</li>
                </ol>
                <div className="clearfix"> </div>
            </div>
            {/* <!-- //breadcrumbs -->
	<!-- products --> */}
            <div className="products">
                <div className="container">
                    <div className="single-page">
                        <div className="single-page-row" id="detail-21">
                            <div className="col-md-6 single-top-left">
                                <div className="flexslider">
                                    <ul className="slides">
                                        <li data-thumb="images/s1.jpg">
                                            <div className="thumb-image detail_images"> <img src="images/s1.jpg" data-imagezoom="true" className="img-responsive" alt="" /> </div>
                                        </li>
                                        <li data-thumb="images/s2.jpg">
                                            <div className="thumb-image"> <img src="images/s2.jpg" data-imagezoom="true" className="img-responsive" alt="" /> </div>
                                        </li>
                                        <li data-thumb="images/s3.jpg">
                                            <div className="thumb-image"> <img src="images/s3.jpg" data-imagezoom="true" className="img-responsive" alt="" /> </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div className="col-md-6 single-top-right">
                                <h3 className="item_name">Electric Snow Blower</h3>
                                <p>Processing Time: Item will be shipped out within 2-3 working days. </p>
                                <div className="single-rating">
                                    <ul>
                                        <li><i className="fa fa-star-o" aria-hidden="true"></i></li>
                                        <li><i className="fa fa-star-o" aria-hidden="true"></i></li>
                                        <li><i className="fa fa-star-o" aria-hidden="true"></i></li>
                                        <li><i className="fa fa-star-o" aria-hidden="true"></i></li>
                                        <li><i className="fa fa-star-o" aria-hidden="true"></i></li>
                                        <li className="rating">20 reviews</li>
                                        <li><Link to="#">Add your review</Link></li>
                                    </ul>
                                </div>
                                <div className="single-price">
                                    <ul>
                                        <li>$540</li>
                                        <li><del>$600</del></li>
                                        <li><span className="w3off">10% OFF</span></li>
                                        <li>Ends on: June,5th</li>
                                        <li><Link to="#"><i className="fa fa-gift" aria-hidden="true"></i> Coupon</Link></li>
                                    </ul>
                                </div>
                                <p className="single-price-text">Fusce a egestas nibh, eget ornare erat. Proin placerat, urna et consequat efficitur, sem odio blandit enim, sit amet euismod turpis est mattis lectus. Vestibulum maximus quam et quam egestas imperdiet. In dignissim auctor viverra. </p>
                                <form action="#" method="post">
                                    <input type="hidden" name="cmd" value="_cart" />
                                    <input type="hidden" name="add" value="1" />
                                    <input type="hidden" name="w3ls_item" value="Snow Blower" />
                                    <input type="hidden" name="amount" value="540.00" />
                                    <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                </form>
                                <button className="w3ls-cart w3ls-cart-like"><i className="fa fa-heart-o" aria-hidden="true"></i> Add to Wishlist</button>
                            </div>
                            <div className="clearfix"> </div>
                        </div>
                        <div className="single-page-icons social-icons">
                            <ul>
                                <li><h4>Share on</h4></li>
                                <li><Link to="#" className="fa fa-facebook icon facebook"> </Link></li>
                                <li><Link to="#" className="fa fa-twitter icon twitter"> </Link></li>
                                <li><Link to="#" className="fa fa-google-plus icon googleplus"> </Link></li>
                                <li><Link to="#" className="fa fa-dribbble icon dribbble"> </Link></li>
                                <li><Link to="#" className="fa fa-rss icon rss"> </Link></li>
                            </ul>
                        </div>
                    </div>
                    {/* <!-- recommendations --> */}
                    <div className="recommend">
                        <h3 className="w3ls-title">Our Recommendations </h3>

                        <div id="owl-demo5" className="owl-carousel">
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>20% <br /> Off</h6></div>
                                    <Link to="products1.html"><img src="images/f2.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products1.html">Women Sandal</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$20</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Women Sandal" />
                                            <input type="hidden" name="amount" value="20.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products.html"><img src="images/e4.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products.html">Digital Camera</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$80</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Digital Camera" />
                                            <input type="hidden" name="amount" value="100.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>New</h6></div>
                                    <Link to="products4.html"><img src="images/s1.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products4.html">Roller Skates</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$180</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Roller Skates" />
                                            <input type="hidden" name="amount" value="180.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products1.html"><img src="images/f1.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products1.html">T Shirt</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$10</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="T Shirt" />
                                            <input type="hidden" name="amount" value="10.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>New</h6></div>
                                    <Link to="products6.html"><img src="images/p1.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products6.html">Coffee Mug</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$14</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Coffee Mug" />
                                            <input type="hidden" name="amount" value="14.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>20% <br /> Off</h6></div>
                                    <Link to="products6.html"><img src="images/p2.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products6.html">Teddy bear</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$20</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Teddy bear" />
                                            <input type="hidden" name="amount" value="20.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products4.html"><img src="images/s2.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products4.html">Football</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$70</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Football" />
                                            <input type="hidden" name="amount" value="70.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>Sale</h6></div>
                                    <Link to="products3.html"><img src="images/h1.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products3.html">Wall Clock</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$80</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Wall Clock" />
                                            <input type="hidden" name="amount" value="80.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/* <!-- //recommendations --> 
			<!-- collapse-tabs --> */}
                    <div className="collpse tabs">
                        <h3 className="w3ls-title">About this item</h3>
                        <div className="panel-group collpse" id="accordion" role="tablist" aria-multiselectable="true">
                            <div className="panel panel-default">
                                <div className="panel-heading" role="tab" id="headingOne">
                                    <h4 className="panel-title">
                                        <Link className="pa_italic" role="button" data-toggle="collapse" data-parent="#accordion" to="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                            <i className="fa fa-file-text-o fa-icon" aria-hidden="true"></i> Description <span className="fa fa-angle-down fa-arrow" aria-hidden="true"></span> <i className="fa fa-angle-up fa-arrow" aria-hidden="true"></i>
                                        </Link>
                                    </h4>
                                </div>
                                <div id="collapseOne" className="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                    <div className="panel-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                    </div>
                                </div>
                            </div>
                            <div className="panel panel-default">
                                <div className="panel-heading" role="tab" id="headingTwo">
                                    <h4 className="panel-title">
                                        <Link className="collapsed pa_italic" role="button" data-toggle="collapse" data-parent="#accordion" to="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                            <i className="fa fa-info-circle fa-icon" aria-hidden="true"></i> additional information <span className="fa fa-angle-down fa-arrow" aria-hidden="true"></span> <i className="fa fa-angle-up fa-arrow" aria-hidden="true"></i>
                                        </Link>
                                    </h4>
                                </div>
                                <div id="collapseTwo" className="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                                    <div className="panel-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                    </div>
                                </div>
                            </div>
                            <div className="panel panel-default">
                                <div className="panel-heading" role="tab" id="headingThree">
                                    <h4 className="panel-title">
                                        <Link className="collapsed pa_italic" role="button" data-toggle="collapse" data-parent="#accordion" to="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                            <i className="fa fa-check-square-o fa-icon" aria-hidden="true"></i> reviews (5) <span className="fa fa-angle-down fa-arrow" aria-hidden="true"></span> <i className="fa fa-angle-up fa-arrow" aria-hidden="true"></i>
                                        </Link>
                                    </h4>
                                </div>
                                <div id="collapseThree" className="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                                    <div className="panel-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                    </div>
                                </div>
                            </div>
                            <div className="panel panel-default">
                                <div className="panel-heading" role="tab" id="headingFour">
                                    <h4 className="panel-title">
                                        <Link className="collapsed pa_italic" role="button" data-toggle="collapse" data-parent="#accordion" to="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                            <i className="fa fa-question-circle fa-icon" aria-hidden="true"></i> help <span className="fa fa-angle-down fa-arrow" aria-hidden="true"></span> <i className="fa fa-angle-up fa-arrow" aria-hidden="true"></i>
                                        </Link>
                                    </h4>
                                </div>
                                <div id="collapseFour" className="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                                    <div className="panel-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/* <!-- //collapse --> 
			<!-- offers-cards -->  */}
                    <div className="w3single-offers offer-bottom">
                        <div className="col-md-6 offer-bottom-grids">
                            <div className="offer-bottom-grids-info2">
                                <h4>Special Gift Cards</h4>
                                <h6>More brands, more ways to shop. <br /> Check out these ideal gifts!</h6>
                            </div>
                        </div>
                        <div className="col-md-6 offer-bottom-grids">
                            <div className="offer-bottom-grids-info">
                                <h4>Flat $10 Discount</h4>
                                <h6>The best Shopping Offer <br /> On Fashion Store</h6>
                            </div>
                        </div>
                        <div className="clearfix"> </div>
                    </div>
                    {/* <!-- //offers-cards --> */}
                </div>
            </div>
            {/* <!--//products-->  
	
             {/* <!-- footer-top --> */}
             <Introduce></Introduce>
            {/* <!-- //footer-top --> 
	<!-- subscribe --> */}
            <Subcribe></Subcribe>
            <Footer></Footer>
        </>
    );
};

export default Product_Details;