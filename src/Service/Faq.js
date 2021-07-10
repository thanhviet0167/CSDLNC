import React from 'react'
import Narbar from "../Components/Layout/Navbar/Navbar";
import Siderbar from "../Components/Layout/Sidebar/Sidebar";
import Category from "../Components/Layout/Sidebar/Category";
import { Link } from 'react-router-dom';
import Subcribe from "../Components/Layout/Footer/Subcribe";
import Footer from "../Components/Layout/Footer/Footer";
import Introduce from "../Components/Layout/Footer/Introduce";


const Faq = () => {


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


            
            <div className="faq-w3agile">
		<div className="container"> 
			<h3 className="w3ls-title w3ls-title1">Frequently asked questions(FAQ)</h3> 
			<ul className="faq">
				<li className="item1"><Link to="#" title="click here">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tempor vehicula ipsum nec ?</Link>
					<ul>
						<li className="subitem1"><p> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore. At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p></li>										
					</ul>
				</li>
				<li className="item2"><Link to="#" title="click here">The standard Lorem Ipsum passage Etiam faucibus viverra libero vel efficitur. Ut semper nisl ut laoreet ultrices ?</Link>
					<ul>
						<li className="subitem1"><p> Tincidunt ut laoreet dolore At vero eos et Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod  consectetuer adipiscing elit, sed diam nonummy nibh euismod accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p></li>										
					</ul>
				</li>
				<li className="item3"><Link to="#" title="click here">Consectetuer adipiscing elit Etiam faucibus viverra libero vel efficitur. Ut semper nisl ut laoreet ultrices?</Link>
					<ul>
						<li className="subitem1"><p>Dincidunt ut laoreet dolore At vero eos et Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod  consectetuer adipiscing elit, sed diam nonummy nibh euismod accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p></li>										
					</ul>
				</li>
				<li className="item4"><Link to="#" title="click here">Sed diam nonummy nibh euismod Etiam faucibus viverra libero vel efficitur. Ut semper nisl ut laoreet ultrices?</Link>
					<ul>
						<li className="subitem1"><p>At vero eos et Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod  consectetuer adipiscing elit, sed diam nonummy nibh euismod accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p></li>										
					</ul>
				</li> 
				<li className="item5"><Link to="#" title="click here">Euismod tincidunt laoreet Etiam faucibus viverra libero vel efficitur ?</Link>
					<ul>
						<li className="subitem1"><p>At vero eos et Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod  consectetuer adipiscing elit, sed diam nonummy nibh euismod accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p></li>										
					</ul>
				</li>
				<li className="item6"><Link to="#" title="click here">Voluptas sit aspernatur aut Ut semper nisl ut laoreet ultrices ?</Link>
					<ul>
						<li className="subitem1"><p>At vero eos et Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod  consectetuer adipiscing elit, sed diam nonummy nibh euismod accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p></li>										
					</ul>
				</li>
				<li className="item7"><Link to="#" title="click here">Donec ut quam ligula feugiat Ut semper nisl ut laoreet ultrices ?</Link>
					<ul>
						<li className="subitem1"><p>At vero eos et Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod  consectetuer adipiscing elit, sed diam nonummy nibh euismod accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p></li>										
					</ul>
				</li>
				<li className="item8"><Link to="#" title="click here">The standard Lorem Ipsum Ut semper nisl ut laoreet ultrices passage ?</Link>
					<ul>
						<li className="subitem1"><p>Lorem ipsum dolor sit amet At vero eos et Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod  consectetuer adipiscing elit, sed diam nonummy nibh euismod accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p></li>										
					</ul>
				</li>
				<li className="item9"><Link to="#" title="click here">Consectetuer adipiscing Ut semper nisl ut laoreet ultrices elit ?</Link>
					<ul>
						<li className="subitem1"><p>Lorem ipsum dolor sit amet At vero eos et Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod  consectetuer adipiscing elit, sed diam nonummy nibh euismod accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p></li>										
					</ul>
				</li>
				<li className="item10"><Link to="#" title="click here">Sed diam nonummy Ut semper nisl ut laoreet ultrices nibh euismod ?</Link>
					<ul>
						<li className="subitem1"><p>Consectetuer adipiscing elit, sed diam nonummy nibh euismod  consectetuer adipiscing elit, sed diam nonummy nibh euismod accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p></li>										
					</ul>
				</li> 
			</ul> 
			 
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


export default Faq;