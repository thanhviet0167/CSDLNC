import React from "react";
import { Link } from 'react-router-dom';
import '../Navbar/Navbar.css'
const Narbar = () => {
    return (
        <div className="w3ls-header">
            {/* <!--header-one-->  */}
			<div className="w3ls-header-left">
				<p><Link to="#">UPTO $50 OFF ON LAPTOPS | USE COUPON CODE LAPPY </Link></p>
			</div>
			<div className="w3ls-header-right">
				<ul>
					<li className="dropdown head-dpdn">
						<Link to="#" className="dropdown-toggle" data-toggle="dropdown"><i className="fa fa-user" aria-hidden="true"></i> My Account<span className="caret"></span></Link>
						<ul className="dropdown-menu">
							<li><a href="/login">Login </a></li> 
							<li><a href="/sign-up">Sign Up</a></li> 
							<li><Link to="login.html">My Orders</Link></li>  
							<li><Link to="login.html">Wallet</Link></li> 
						</ul> 
					</li> 
					<li className="dropdown head-dpdn">
						<Link to="#" className="dropdown-toggle" data-toggle="dropdown"><i className="fa fa-percent" aria-hidden="true"></i> Today's Deals<span className="caret"></span></Link>
						<ul className="dropdown-menu">
							<li><Link to="offers.html">Cash Back Offers</Link></li> 
							<li><Link to="offers.html">Product Discounts</Link></li>
							<li><Link to="offers.html">Special Offers</Link></li> 
						</ul> 
					</li> 
					<li className="dropdown head-dpdn">
						<Link to="#" className="dropdown-toggle" data-toggle="dropdown"><i className="fa fa-gift" aria-hidden="true"></i> Gift Cards<span className="caret"></span></Link>
						<ul className="dropdown-menu">
							<li><Link to="offers.html">Product Gift card</Link></li> 
							<li><Link to="offers.html">Occasions Register</Link></li>
							<li><Link to="offers.html">View Balance</Link></li> 
						</ul> 
					</li> 
					<li className="dropdown head-dpdn">
						<Link to="/contact" className="dropdown-toggle"><i className="fa fa-map-marker" aria-hidden="true"></i> Store Finder</Link>
					</li> 
					<li className="dropdown head-dpdn">
						<Link to="/card" className="dropdown-toggle"><i className="fa fa-credit-card-alt" aria-hidden="true"></i> Credit Card</Link>
					</li> 
					<li className="dropdown head-dpdn">
						<Link to="/help" className="dropdown-toggle"><i className="fa fa-question-circle" aria-hidden="true"></i> Help</Link>
					</li>
				</ul>
			</div>
			<div className="clearfix"> </div> 
		</div>
    
    );
};

export default Narbar;