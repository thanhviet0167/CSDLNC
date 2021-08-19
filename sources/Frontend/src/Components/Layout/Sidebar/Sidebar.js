import React from "react";
import { Link } from 'react-router-dom';

const Siderbar = ({handler_search_product}) => {

	const handler_search = () =>{
		
	//	console.log(document.getElementById("search").value)
		handler_search_product(document.getElementById("search").value)
	}

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
					<form action = "/product">
						<input type="search" name="Search" id="search" placeholder="Search for a Product..." required=""/>
						<button type="button" className="btn btn-default" aria-label="Left Align" onClick = {handler_search}>
							<i className="fa fa-search" aria-hidden="true"> </i>
						</button>
					</form>
				</div>
				<div className="header-cart"> 
					<div className="my-account">
						<Link to="/contact-us"><i className="fa fa-map-marker" aria-hidden="true"></i> CONTACT US</Link>						
					</div>
					<div className="cart"> 
						<form className="last"> 
							<input type="hidden" name="cmd" value="_cart" />
							<input type="hidden" name="display" value="1" />
							<Link to='/shopping-cart'><button className="w3view-cart" type="button" name="submit" value=""><i className="fa fa-cart-arrow-down" aria-hidden="true">{localStorage.getItem('size')}</i></button></Link>
							
							
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