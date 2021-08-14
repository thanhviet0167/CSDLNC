import React from 'react'
import Narbar from "../Components/Layout/Navbar/Navbar";
import Siderbar from "../Components/Layout/Sidebar/Sidebar";
import Category from "../Components/Layout/Sidebar/Category";
import { Link } from 'react-router-dom';
import Subcribe from "../Components/Layout/Footer/Subcribe";
import Footer from "../Components/Layout/Footer/Footer";
import Introduce from "../Components/Layout/Footer/Introduce";


const Marketplace = () => {


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


            {/* <!-- services-page --> */}
            <div className="w3l-services">
                <div className="container">
                    <h3 className="w3ls-title w3ls-title1">Marketplace</h3>
                    <div className="services-row">
                        <div className="col-md-3 services-grids">
                            <i className="fa fa-line-chart" aria-hidden="true"></i>
                            <h4>Best Performance</h4>
                            <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias</p>
                        </div>
                        <div className="col-md-3 services-grids">
                            <i className="fa fa-user-plus" aria-hidden="true"></i>
                            <h4>Expand audience</h4>
                            <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias</p>
                        </div>
                        <div className="col-md-3 services-grids">
                            <i className="fa fa-lock" aria-hidden="true"></i>
                            <h4>Relay on our Safety</h4>
                            <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias</p>
                        </div>
                        <div className="col-md-3 services-grids">
                            <i className="fa fa-bar-chart" aria-hidden="true"></i>
                            <h4>business partner</h4>
                            <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias</p>
                        </div>
                        <div className="col-md-3 services-grids services-grids-btm">
                            <i className="fa fa-check-square-o" aria-hidden="true"></i>
                            <h4>Good quality</h4>
                            <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias</p>
                        </div>
                        <div className="col-md-3 services-grids services-grids-btm">
                            <i className="fa fa-shopping-cart" aria-hidden="true"></i>
                            <h4>Fulfill Orders</h4>
                            <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias</p>
                        </div>
                        <div className="col-md-3 services-grids services-grids-btm">
                            <i className="fa fa-comments" aria-hidden="true"></i>
                            <h4>User Requirements</h4>
                            <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias</p>
                        </div>
                        <div className="col-md-3 services-grids services-grids-btm">
                            <i className="fa fa-cc-visa" aria-hidden="true"></i>
                            <h4>Easy Transactions</h4>
                            <p>Itaque earum rerum hic tenetur a sapiente delectus reiciendis maiores alias</p>
                        </div>
                        <div className="clearfix"></div>
                    </div>
                </div>
            </div>
            {/* <!-- //services-page -->  */}


            {/* <!--//products-->   */}
            {/* <!-- footer-top --> */}
            <Introduce></Introduce>
            {/* <!-- //footer-top --> 
	<!-- subscribe --> */}
            <Subcribe></Subcribe>
            <Footer></Footer>
        </>
    );
};


export default Marketplace;