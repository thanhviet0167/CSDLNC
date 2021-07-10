import React from 'react'
import Narbar from "../../Components/Layout/Navbar/Navbar";
import Siderbar from "../../Components/Layout/Sidebar/Sidebar";
import Category from "../../Components/Layout/Sidebar/Category";
import { Link } from 'react-router-dom';
import Subcribe from "../../Components/Layout/Footer/Subcribe";
import Footer from "../../Components/Layout/Footer/Footer";
import Introduce from "../../Components/Layout/Footer/Introduce";


const Card = () => {


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
            {/* <!-- card-page --> */}
	<div className="card-page">
		<div className="container"> 
			<h3 className="w3ls-title w3ls-title1"> Smart bazaar Credit card</h3>  
			<div className="agile-card-top">
				<div className="col-md-4 card-top-grids">
					<h4>Save <span>$15</span></h4>
					<i className="fa fa-camera" aria-hidden="true"></i>
					<h5>on purchase of Electronics In Smart bazaar.com</h5>
				</div>
				<div className="col-md-4 card-top-grids">
					<h4>Save <span>$5</span></h4>
					<i className="fa fa-motorcycle" aria-hidden="true"></i>
					<h5>on purchase of Smart bazaar Automotive </h5>
				</div>
				<div className="col-md-4 card-top-grids">
					<h4>Save <span>$20</span></h4>
					<i className="fa fa-users" aria-hidden="true"></i>
					<h5>on purchase of Clothings Using Card</h5>
				</div>
				<div className="clearfix"> </div>
			</div>
			<div className="agile-card-text">
            <h5>New User Account Offers</h5>
				<p>className aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Maecenas faucibus ipsum et libero euismod iaculis. Integer consectetur congue laoreet. Morbi eget leo elementum, vulputate eros et, egestas diam. Nam egestas, quam id viverra congue, elit mi eleifend libero, eget vulputate ante lorem vel quam. Sed suscipit ligula eu mi bibendum, vel mollis enim finibus. Suspendisse vitae est tortor. Donec aliquet leo vitae ligula mattis, vitae auctor mi pellentesque. Integer eu dui accumsan, convallis neque id, malesuada urna. </p>
				<h5>Special account openings</h5>
				<p>Nulla sodales nulla et ipsum pharetra pharetra. Suspendisse potenti. Phasellus cursus vehicula lorem, nec dignissim orci cursus tempor. Suspendisse vel ullamcorper arcu. Mauris tellus augue, tristique ut varius ac, scelerisque ac urna. Mauris nibh ligula, cursus eu vehicula a, scelerisque a nunc. Mauris sit amet sem orci. Proin sit amet tortor non massa tincidunt faucibus. Sed a lacus a purus congue dignissim. Maecenas auctor urna et ullamcorper sagittis. Aenean semper, nisi sed vulputate euismod, justo odio dictum lorem, a mattis ipsum magna non quam.<br/>  Maecenas faucibus ipsum et libero euismod iaculis. Integer consectetur congue laoreet. Morbi eget leo elementum, vulputate eros et, egestas diam. Nam egestas, quam id viverra congue, elit mi eleifend libero, eget vulputate ante lorem vel quam. Sed suscipit ligula eu mi bibendum, vel mollis enim finibus. Suspendisse vitae est tortor. Donec aliquet leo vitae ligula mattis, vitae auctor mi pellentesque. Integer eu dui accumsan, convallis neque id, malesuada urna. </p>
			</div>
		</div>
	</div>
	{/* <!-- //card-page -->  */}

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


export default Card;