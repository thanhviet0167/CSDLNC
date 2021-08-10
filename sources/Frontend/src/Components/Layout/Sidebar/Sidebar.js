import React from "react";
import { Link } from 'react-router-dom';

const Siderbar = () => {



    return (
        <>
        <div className="header-two">
            {/* <!-- header-two --> */}
			<div className="container">
				<div className="header-logo">
					<h1><a href="/"><span>S</span>Naco <i>Tiki</i></a></h1>
					<h6>Your stores. Your place.</h6> 
				</div>	
				<div className="header-search">
					<form action="#" method="post">
						<input type="search" name="Search" placeholder="Search for a Product..." required=""/>
						<button type="submit" className="btn btn-default" aria-label="Left Align">
							<i className="fa fa-search" aria-hidden="true"> </i>
						</button>
					</form>
				</div>
				<div className="header-cart"> 
					<div className="my-account">
						<Link to="/contact-us"><i className="fa fa-map-marker" aria-hidden="true"></i> CONTACT US</Link>						
					</div>
					<div className="cart"> 
						<form action="#" method="post" className="last"> 
							<input type="hidden" name="cmd" value="_cart" />
							<input type="hidden" name="display" value="1" />
							<button className="w3view-cart" type="submit" name="submit" value=""><i className="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
						</form>  
					</div>
					<div className="clearfix"> </div> 
				</div> 
				<div className="clearfix"> </div>
			</div>		
		</div>
        {/* <!-- //header-two --> */}
        </>
    );
};

export default Siderbar;