import React from 'react'
import Narbar from "../../Components/Layout/Navbar/Navbar";
import Siderbar from "../../Components/Layout/Sidebar/Sidebar";
import Category from "../../Components/Layout/Sidebar/Category";
import { Link } from 'react-router-dom';
import Subcribe from "../../Components/Layout/Footer/Subcribe";
import Footer from "../../Components/Layout/Footer/Footer";
import Introduce from "../../Components/Layout/Footer/Introduce";


const Offer = () => {


    return(
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
          
	<div className="wthree-offers">
		<div className="container">
			<h3 className="w3ls-title w3ls-title1">Today's Offers & Gift Cards </h3>
			<div className="w3ls-add-grids w3agile-add-products">
				<a href="#"> 
					<h4>TOP 10 TRENDS FOR YOU FLAT <span>20%</span> OFF</h4>
					<h6>Shop now <i className="fa fa-arrow-circle-right" aria-hidden="true"></i></h6>
				</a>
			</div> 
			<div className="offer-card-row">
				<div className="col-md-4 offer-card-grids">
					<h4>20% Cashback </h4>
					<p>Shop Using Gift Cards Get 20% Cashback</p>
					<a href="products.html">Shop Now <i className="fa fa-arrow-circle-right" aria-hidden="true"></i></a>
				</div>
				<div className="col-md-4 offer-card-grids">
					<h4>Earn $20</h4>
					<p>Refer a friend and earn $20 in Smart bazaar!</p>
					<a href="products.html">Shop Now <i className="fa fa-arrow-circle-right" aria-hidden="true"></i></a>
				</div>
				<div className="col-md-4 offer-card-grids">
					<h4>10% Cashback </h4>
					<p>Shop Using Credit Card Get 10% Cashback </p>
					<a href="products.html">Shop Now <i className="fa fa-arrow-circle-right" aria-hidden="true"></i></a>
				</div>	
				<div className="clearfix"> </div>
			</div>	
			<div className="offer-bottom"> 
				<div className="col-md-6 offer-bottom-grids">
					<div className="offer-bottom-grids-info2">
						<h4>Special Gift Cards</h4> 
						<h6>More brands, more ways to shop. <br/> Check out these ideal gifts!</h6>
					</div>
				</div>
				<div className="col-md-6 offer-bottom-grids">
					<div className="offer-bottom-grids-info">
						<h4>Flat $10 Discount</h4> 
						<h6>The best Shopping Offer <br/> On Fashion Store</h6>
					</div>
				</div>
				<div className="clearfix"> </div>
			</div>
		</div>
	</div>


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


export default Offer;