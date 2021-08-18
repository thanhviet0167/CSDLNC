import React, {useState} from "react";
import Narbar from "../Layout/Navbar/Navbar";
import { Link, Redirect } from 'react-router-dom';
import Siderbar from '../Layout/Sidebar/Sidebar'
import $ from "jquery";
import Footer from "../Layout/Footer/Footer";
import Category from "../Layout/Sidebar/Category";
import Subcribe from "../Layout/Footer/Subcribe";
import Introduce from "../Layout/Footer/Introduce";
import Deal from "../Layout/Deals/Deal";
import Banner from "../Layout/Banner/Banner";
import Featured_Product from "../../Products/Product/Featured_Product";

const Home = ({ user, handler_search_product, searchKey, account, handle_logout }) => {
    console.log(searchKey['key_search']);
	

    
	if(!searchKey['key_search'])
	{
		return (
			<>
			<div className="agileits-modal modal fade" id="myModal88" tabindex="-1" role="dialog" aria-labelledby="myModal88"
			aria-hidden="true">
			<div className="modal-dialog">
				<div className="modal-content">
					<div className="modal-header">
						<button type="button" className="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 className="modal-title" id="myModalLabel"><i className="fa fa-map-marker" aria-hidden="true"></i> Location</h4>
					</div>
					<div className="modal-body modal-body-sub"> 
						<h5>Select your delivery location </h5>  
						<select className="form-control bfh-states" data-country="US" data-state="CA">
							<option value="">Select Your location</option>
							<option value="AL">Alabama</option><option value="AK">Alaska</option><option value="AS">American Samoa</option><option value="AZ">Arizona</option><option value="AR"/>Arkansas<option value="CA">California</option><option value="CO">Colorado</option><option value="CT">Connecticut</option><option value="DE">Delaware</option><option value="DC">District of Columbia</option><option value="FM">Federated States Of Micronesia</option><option value="FL">Florida</option><option value="GA">Georgia</option><option value="GU">Guam</option><option value="HI">Hawaii</option><option value="ID">Idaho</option><option value="IL">Illinois</option><option value="IN">Indiana</option><option value="IA">Iowa</option><option value="KS">Kansas</option><option value="KY">Kentucky</option><option value="LA">Louisiana</option><option value="ME">Maine</option><option value="MH">Marshall Islands</option><option value="MD">Maryland</option><option value="MA">Massachusetts</option><option value="MI">Michigan</option><option value="MN">Minnesota</option>
							<option value="MS">Mississippi</option><option value="MO">Missouri</option><option value="MT">Montana</option><option value="NE">Nebraska</option><option value="NV">Nevada</option><option value="NH">New Hampshire</option><option value="NJ">New Jersey</option><option value="NM">New Mexico</option><option value="NY">New York</option><option value="NC">North Carolina</option><option value="ND">North Dakota</option><option value="MP">Northern Mariana Islands</option><option value="OH">Ohio</option><option value="OK">Oklahoma</option><option value="OR">Oregon</option><option value="PW">Palau</option><option value="PA">Pennsylvania</option><option value="PR">Puerto Rico</option><option value="RI">Rhode Island</option><option value="SC">South Carolina</option><option value="SD">South Dakota</option><option value="TN">Tennessee</option><option value="TX">Texas</option><option value="UT">Utah</option><option value="VT">Vermont</option><option value="VI">Virgin Islands</option><option value="VA">Virginia</option><option value="WA">Washington</option><option value="WV">West Virginia</option><option value="WI">Wisconsin</option><option value="WY">Wyoming</option>
						</select>
						<input type="text" name="Name" placeholder="Enter your area / Landmark / Pincode" required=""/>
						<button type="button" className="close2" data-dismiss="modal" aria-hidden="true">Skip & Explore</button>
					</div>
				</div>
			</div>
		</div>
	
		{/* <!-- header --> */}
		<div className="header">
			<Narbar account = {account} handle_logout = {handle_logout}></Narbar>
			<Siderbar handler_search_product = {handler_search_product}></Siderbar>
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
		{/* <!-- //header -->	
		<!-- banner --> */}
		<Banner></Banner>
		{/* <!-- //banner -->  
		<!-- welcome --> */}
		<div className="welcome"> 
			<div className="container"> 
				<div className="welcome-info">
					<div className="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
						<ul id="myTab" className=" nav-tabs" role="tablist">
							<li role="presentation" className="active"><Link to="#home" id="home-tab" role="tab" data-toggle="tab" >
								<i className="fa fa-laptop" aria-hidden="true"></i> 
								<h5>Electronics</h5>
							</Link></li>
							<li role="presentation"><Link to="#carl" role="tab" id="carl-tab" data-toggle="tab"> 
								<i className="fa fa-female" aria-hidden="true"></i>
								<h5>Fashion</h5>
							</Link></li>
							<li role="presentation"><Link to="#james" role="tab" id="james-tab" data-toggle="tab"> 
								<i className="fa fa-gift" aria-hidden="true"></i>
								<h5>Photo & Gifts</h5>
							</Link></li>
							<li role="presentation"><Link to="#decor" role="tab" id="decor-tab" data-toggle="tab"> 
								<i className="fa fa-home" aria-hidden="true"></i>
								<h5>Home Decor</h5>
							</Link></li>
							<li role="presentation"><Link to="#sports" role="tab" id="sports-tab" data-toggle="tab"> 
								<i className="fa fa-motorcycle" aria-hidden="true"></i>
								<h5>Sports</h5>
							</Link></li> 
						</ul>
						<div className="clearfix"> </div>
						{/* Featured Product   */}
						<Featured_Product></Featured_Product>
					</div>  
				</div>  	
			</div>  	
		</div> 
		{/* <!-- //welcome -->
		<!-- add-products --> */}
		<div className="add-products"> 
			<div className="container">  
				<div className="add-products-row">
					<div className="w3ls-add-grids">
						<Link to="products1.html"> 
							<h4>TOP 10 TRENDS FOR YOU FLAT <span>20%</span> OFF</h4>
							<h6>Shop now <i className="fa fa-arrow-circle-right" aria-hidden="true"></i></h6>
						</Link>
					</div>
					<div className="w3ls-add-grids w3ls-add-grids-mdl">
						<Link to="products1.html"> 
							<h4>SUNDAY SPECIAL DISCOUNT FLAT <span>40%</span> OFF</h4>
							<h6>Shop now <i className="fa fa-arrow-circle-right" aria-hidden="true"></i></h6>
						</Link>
					</div>
					<div className="w3ls-add-grids w3ls-add-grids-mdl1">
						<Link to="products.html"> 
							<h4>LATEST DESIGNS FOR YOU <span> Hurry !</span></h4>
							<h6>Shop now <i className="fa fa-arrow-circle-right" aria-hidden="true"></i></h6>
						</Link>
					</div>
					
					<div className="clerfix"> </div>
				</div>  	
			</div>  	
		</div>
		{/* <!-- //add-products -->
		<!-- coming soon --> */}
		<div className="soon">
			<div className="container">
				<h3>Mega Deal Of the Week</h3>
				<h4>Coming Soon Don't Miss Out</h4>  
				<div id="countdown1" className="ClassyCountdownDemo"></div>
			</div> 
		</div>
		{/* <!-- //coming soon -->
		<!-- deals --> */}
		<Deal></Deal>
		{/* <!-- //deals --> 
		<!-- footer-top --> */}
		<Introduce></Introduce>
		{/* <!-- //footer-top --> 
		<!-- subscribe --> */}
		<Subcribe></Subcribe>
		<Footer></Footer>
		</>
		); 
	}
	else{
		var url = "/product?keyword=" + searchKey['key_search'];
		return <Redirect to = {url}/>
	}
       
};

export default Home;


