import React from 'react'
import Narbar from "../Components/Layout/Navbar/Navbar";
import Siderbar from "../Components/Layout/Sidebar/Sidebar";
import Category from "../Components/Layout/Sidebar/Category";
import { Link } from 'react-router-dom';
import Subcribe from "../Components/Layout/Footer/Subcribe";
import Footer from "../Components/Layout/Footer/Footer";
import Introduce from "../Components/Layout/Footer/Introduce";


const Values = () => {


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
           

            {/* <!-- values-page --> */}
	<div className="values">
		<div className="container"> 
			<h3 className="w3ls-title w3ls-title1">Core Values</h3> 
			<h5>About Core Values</h5>
			<p>className aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Maecenas faucibus ipsum et libero euismod iaculis. Integer consectetur congue laoreet. Morbi eget leo elementum, vulputate eros et, egestas diam. Nam egestas, quam id viverra congue, elit mi eleifend libero, eget vulputate ante lorem vel quam. Sed suscipit ligula eu mi bibendum, vel mollis enim finibus. Suspendisse vitae est tortor. Donec aliquet leo vitae ligula mattis, vitae auctor mi pellentesque. Integer eu dui accumsan, convallis neque id, malesuada urna. </p>
			<div className="w3values-row">
				<h5>Here  are some core values :</h5>
				<div className="col-md-6 w3values-grids">
					<h6>1. INNOVATION</h6>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ultrices orci at augue sollicitudin, sed rhoncus leo dictum. Duis sed elit tempus, convallis elit eget, ornare nibh. Sed eu risus eget magna condimentum blandit.  </p>
				</div>
				<div className="col-md-6 w3values-grids">
					<h6>2. NEW TRENDS</h6>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ultrices orci at augue sollicitudin, sed rhoncus leo dictum. Duis sed elit tempus, convallis elit eget, ornare nibh. Sed eu risus eget magna condimentum blandit.  </p>
				</div>
				<div className="col-md-6 w3values-grids">
					<h6>3. OPENNESS</h6>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ultrices orci at augue sollicitudin, sed rhoncus leo dictum. Duis sed elit tempus, convallis elit eget, ornare nibh. Sed eu risus eget magna condimentum blandit.  </p>
				</div>
				<div className="col-md-6 w3values-grids">
					<h6>4. OWNERSHIP</h6>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ultrices orci at augue sollicitudin, sed rhoncus leo dictum. Duis sed elit tempus, convallis elit eget, ornare nibh. Sed eu risus eget magna condimentum blandit.  </p>
				</div>
				<div className="col-md-6 w3values-grids">
					<h6>5. HONESTY</h6>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ultrices orci at augue sollicitudin, sed rhoncus leo dictum. Duis sed elit tempus, convallis elit eget, ornare nibh. Sed eu risus eget magna condimentum blandit.  </p>
				</div>
				<div className="clearfix"> </div>
			</div>
		</div>
	</div>
	{/* <!-- //values-page -->  */}


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


export default Values;