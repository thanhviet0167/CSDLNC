import React from 'react'
import Narbar from "../Components/Layout/Navbar/Navbar";
import Siderbar from "../Components/Layout/Sidebar/Sidebar";
import Category from "../Components/Layout/Sidebar/Category";
import { Link } from 'react-router-dom';
import Subcribe from "../Components/Layout/Footer/Subcribe";
import Footer from "../Components/Layout/Footer/Footer";
import Introduce from "../Components/Layout/Footer/Introduce";


const Privacy = () => {


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

            {/* <!-- privacy-page --> */}
            <div class="privacy">
                <div class="container">
                    <h3 class="w3ls-title w3ls-title1">Privacy Policy</h3>
                    <div class="privacy-w3row">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare turpis ut porta aliquet. Morbi quis dictum lacus. Donec scelerisque lacus nec lobortis tempor. Morbi orci arcu, ullamcorper ut arcu vel, ultricies congue lacus. Phasellus porta cursus tempor. Nunc ultricies sapien nec est ornare pulvinar. Vivamus mollis faucibus purus sed blandit. Praesent fermentum dapibus risus id rutrum. Aliquam rutrum vel nulla eu fringilla.</p>
                        <p>Nunc ornare turpis ut porta aliquet. Morbi quis dictum lacus. Donec scelerisque lacus nec lobortis tempor. Morbi orci arcu, ullamcorper ut arcu vel, ultricies congue lacus. Phasellus porta cursus tempor. Nunc ultricies sapien nec est ornare pulvinar. Vivamus mollis faucibus purus sed blandit. Praesent fermentum dapibus risus id rutrum. Aliquam rutrum vel nulla eu fringilla. Curabitur efficitur justo a est tempor, pretium accumsan leo sagittis. Ut imperdiet sapien velit, a auctor neque laoreet sed. Praesent ornare nulla sit amet ullamcorper vulputate. Suspendisse vitae magna finibus, egestas eros quis, ornare risus. Duis magna ex, ultrices quis tellus non, commodo eleifend odio. Donec et faucibus risus. Aliquam laoreet justo sapien. </p>
                        <p>Donec scelerisque lacus nec lobortis tempor donec et faucibus risus. Aliquam laoreet justo sapien. </p>
                        <p>Pellentesque quis sagittis est. Nam placerat ante at nunc ornare, sed faucibus odio interdum. Nam viverra, purus ac ullamcorper convallis, lorem erat consequat enim, at pharetra magna ipsum at velit. </p>
                        <h5>What Does Our Privacy Policy Include?</h5>
                        <p>Maecenas malesuada leo dui, at venenatis ligula sodales ut. Cras a feugiat orci. </p>
                        <p>Pellentesque metus enim, aliquet eu felis sed, pretium ultrices ante convallis nec turpis.</p>
                        <p>Phasellus imperdiet nibh et lorem tincidunt aliquam. Integer elementum purus non venenatis volutpat. Curabitur sit amet neque sed arcu pretium iaculis. Phasellus posuere egestas tortor a molestie. Nulla sed urna dignissim, maximus magna et, elementum metus. Ut dolor lorem, mattis eu consectetur non, euismod quis nulla. </p>
                        <h5>How Do We Use Your Personal Information?</h5>
                        <p>Phasellus imperdiet nibh et lorem tincidunt aliquam. Integer elementum purus non venenatis volutpat. Curabitur sit amet neque sed arcu pretium iaculis. Phasellus posuere egestas tortor a molestie. Nulla sed urna dignissim, maximus magna et, elementum metus. Ut dolor lorem, mattis eu consectetur non, euismod quis nulla. </p>
                    </div>
                </div>
            </div>
            {/* <!-- //privacy-page -->  */}


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


export default Privacy;