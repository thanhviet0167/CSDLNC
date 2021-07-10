import React from "react";
import { Link } from 'react-router-dom';

const Banner = () => {

    return (
        <div className="banner">
		<div id="kb" className="carousel kb_elastic animate_text kb_wrapper" data-ride="carousel" data-interval="6000" data-pause="hover">
			{/* <!-- Wrapper-for-Slides --> */}
            <div className="carousel-inner" role="listbox">  
                <div className="item active">
                    <img src="images/5.jpg" alt="" className="img-responsive" />
                    <div className="carousel-caption kb_caption kb_caption_right">
                        <h3 data-animation="animated flipInX">Flat <span>50%</span> Discount</h3>
                        <h4 data-animation="animated flipInX">Hot Offer Today Only</h4>
                    </div>
                </div>  
                <div className="item"> 
                    <img src="images/8.jpg" alt="" className="img-responsive" />
                    <div className="carousel-caption kb_caption kb_caption_right">
                        <h3 data-animation="animated fadeInDown">Our Latest Fashion Editorials</h3>
                        <h4 data-animation="animated fadeInUp">cupidatat non proident</h4>
                    </div>
                </div> 
                <div className="item">
                    <img src="images/3.jpg" alt="" className="img-responsive"/>
                    <div className="carousel-caption kb_caption kb_caption_center">
                        <h3 data-animation="animated fadeInLeft">End Of Season Sale</h3>
                        <h4 data-animation="animated flipInX">cupidatat non proident</h4>
                    </div>
                </div> 
            </div> 
            {/* <!-- Left-Button --> */}
            <Link className="left carousel-control kb_control_left" to="#kb" role="button" data-slide="prev">
				<span className="fa fa-angle-left kb_icons" aria-hidden="true"></span>
                <span className="sr-only">Previous</span>
            </Link> 
            {/* <!-- Right-Button --> */}
            <Link className="right carousel-control kb_control_right" to="#kb" role="button" data-slide="next">
                <span className="fa fa-angle-right kb_icons" aria-hidden="true"></span>
                <span className="sr-only">Next</span>
            </Link> 
        </div>
		<script src="js/custom.js"></script>
	</div>
    );
};

export default Banner;