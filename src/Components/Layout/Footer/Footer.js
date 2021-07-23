import React from "react";
import { Link } from 'react-router-dom';
const Footer = () =>{

    return(
    <>
	<div className="footer">
		<div className="container">
			<div className="footer-info w3-agileits-info">
				<div className="col-md-4 address-left agileinfo">
					<div className="footer-logo header-logo">
						<h2><a href="index.html"><span>S</span>Naco <i>Tiki</i></a></h2>
						<h6>Your stores. Your place.</h6>
					</div>
					<ul>
						<li><i className="fa fa-map-marker"></i> 123 San Sebastian, New York City USA.</li>
						<li><i className="fa fa-mobile"></i> 333 222 3333 </li>
						<li><i className="fa fa-phone"></i> +222 11 4444 </li>
						<li><i className="fa fa-envelope-o"></i> <a href="mailto:example@mail.com"> mail@example.com</a></li>
					</ul> 
				</div>
				<div className="col-md-8 address-right">
					<div className="col-md-4 footer-grids">
						<h3>Company</h3>
						<ul>
							<li><a href="/about">About Us</a></li>
							<li><a href="/marketplace">Marketplace</a></li>  
							<li><a href="/values">Core Values</a></li>  
							<li><a href="/privacy">Privacy Policy</a></li>
						</ul>
					</div>
					<div className="col-md-4 footer-grids">
						<h3>Services</h3>
						<ul>
							<li><a href="/contact">Contact Us</a></li>
							<li><a href="/login">Returns</a></li> 
							<li><a href="/faq">FAQ</a></li>
							<li><a href="/sitemap">Site Map</a></li>
							<li><a href="/login">Order Status</a></li>
						</ul> 
					</div>
					<div className="col-md-4 footer-grids">
						<h3>Payment Methods</h3>
						<ul>
							<li><i className="fa fa-laptop" aria-hidden="true"></i> Net Banking</li>
							<li><i className="fa fa-money" aria-hidden="true"></i> Cash On Delivery</li>
							<li><i className="fa fa-pie-chart" aria-hidden="true"></i>EMI Conversion</li>
							<li><i className="fa fa-gift" aria-hidden="true"></i> E-Gift Voucher</li>
							<li><i className="fa fa-credit-card" aria-hidden="true"></i> Debit/Credit Card</li>
						</ul>  
					</div>
					<div className="clearfix"></div>
				</div>
				<div className="clearfix"></div>
			</div>
		</div>
	</div>
	{/* <!-- //footer -->		 */}
	<div className="copy-right"> 
		<div className="container">
			<p>© 2021 Smart bazaar . All rights reserved | Design by <a href="http://w3layouts.com"> W3layouts.</a></p>
		</div>
	</div> 
	{/* <!-- cart-js --> */}
	<script src="js/minicart.js"></script>
	{/* <script>
        w3ls.render();

        w3ls.cart.on('w3sb_checkout', function (evt) {
        	var items, len, i;

        	if (this.subtotal() > 0) {
        		items = this.items();

        		for (i = 0, len = items.length; i < len; i++) {
        			items[i].set('shipping', 0);
        			items[i].set('shipping2', 0);
        		}
        	}
        });
    </script>   */}
	{/* <!-- //cart-js -->	
	<!-- countdown.js -->	 */}
	<script src="js/jquery.knob.js"></script>
	<script src="js/jquery.throttle.js"></script>
	<script src="js/jquery.classycountdown.js"></script>
		{/* <script>
			$(document).ready(function() {
				$('#countdown1').ClassyCountdown({
					end: '1388268325',
					now: '1387999995',
					labels: true,
					style: {
						element: "",
						textResponsive: .5,
						days: {
							gauge: {
								thickness: .10,
								bgColor: "rgba(0,0,0,0)",
								fgColor: "#1abc9c",
								lineCap: 'round'
							},
							textCSS: 'font-weight:300; color:#fff;'
						},
						hours: {
							gauge: {
								thickness: .10,
								bgColor: "rgba(0,0,0,0)",
								fgColor: "#05BEF6",
								lineCap: 'round'
							},
							textCSS: ' font-weight:300; color:#fff;'
						},
						minutes: {
							gauge: {
								thickness: .10,
								bgColor: "rgba(0,0,0,0)",
								fgColor: "#8e44ad",
								lineCap: 'round'
							},
							textCSS: ' font-weight:300; color:#fff;'
						},
						seconds: {
							gauge: {
								thickness: .10,
								bgColor: "rgba(0,0,0,0)",
								fgColor: "#f39c12",
								lineCap: 'round'
							},
							textCSS: ' font-weight:300; color:#fff;'
						}

					},
					onEndCallback: function() {
						console.log("Time out!");
					}
				});
			});
		</script> */}
	{/* <!-- //countdown.js -->
	<!-- menu js aim --> */}
	<script src="../js/jquery.menu-aim.js"> </script>
	<script src="../js/main.js"></script>
    </>
    );
};


export default Footer;