import React from 'react'
import { Link, Redirect } from 'react-router-dom';
import Narbar from "../Layout/Navbar/Navbar";
import Siderbar from "../Layout/Sidebar/Sidebar";
import Category from "../Layout/Sidebar/Category";

import Introduce from "../Layout/Footer/Introduce";
import Subcribe from "../Layout/Footer/Subcribe";
import Footer from '../Layout/Footer/Footer';


const Contact = () => {


    return (
        // Header
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
        {/* <!-- contact-page --> */}
        <div className="contact">
            <div className="container">
                <h3 className="w3ls-title w3ls-title1">Contact Us</h3>
                <div className="map-info">
                    <div className="col-md-6 map-grids">
                        <h4>Our Taco Tiki Store1</h4>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3023.9503398796587!2d-73.9940307!3d40.719109700000004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c25a27e2f24131%3A0x64ffc98d24069f02!2sCANADA!5e0!3m2!1sen!2sin!4v1441710758555"></iframe>
                    </div>
                    <div className="col-md-6 map-grids">
                        <h4>Our Taco Tiki Store2</h4>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d23778.253788067046!2d-87.77626504212625!3d41.84376259112007!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x880e33967c81db8f%3A0xbc5872c77c003120!2sCicero%2C+IL!5e0!3m2!1sen!2sin!4v1470650895897"></iframe>
                    </div>
                    <div className="col-md-6 map-grids">
                        <h4>Our Taco Tiki Store3</h4>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4851.135123262741!2d105.86847248902144!3d58.25136049196456!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x5cf6e6f5eed7e5eb%3A0xfec064728556bbad!2sTokma%2C+Irkutsk+Oblast%2C+Russia%2C+666639!5e0!3m2!1sen!2sin!4v1470650971228"></iframe>
                    </div>
                    <div className="col-md-6 map-grids">
                        <h4>Our Taco Tiki Store4</h4>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3023.9503398796587!2d-73.9940307!3d40.719109700000004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c25a27e2f24131%3A0x64ffc98d24069f02!2sCANADA!5e0!3m2!1sen!2sin!4v1441710758555" allowfullscreen=""></iframe>
                    </div>
                    <div className="clearfix"> </div>
                </div>
                <div className="contact-form-row">
                    <h3 className="w3ls-title w3ls-title1">Drop Us a line</h3>
                    <div className="col-md-7 contact-left">
                        <form action="#" method="post">
                            <input type="text" name="Name" placeholder="Name" required="" />
                            <input className="email" type="text" name="Email" placeholder="Email" required="" />
                            <textarea placeholder="Message" name="Message" required=""></textarea>
                            <input type="submit" value="SUBMIT" />
                        </form>
                    </div>
                    <div className="col-md-4 contact-right">
                        <div className="cnt-w3agile-row">
                            <div className="col-md-3 contact-w3icon">
                                <i className="fa fa-truck" aria-hidden="true"></i>
                            </div>
                            <div className="col-md-9 contact-w3text">
                                <p>Manage Your Orders <br />Easily Track Orders & Returns </p>
                            </div>
                            <div className="clearfix"> </div>
                        </div>
                        <div className="cnt-w3agile-row cnt-w3agile-row-mdl">
                            <div className="col-md-3 contact-w3icon">
                                <i className="fa fa-bell" aria-hidden="true"></i>
                            </div>
                            <div className="col-md-9 contact-w3text">
                                <p>Notifications <br />Get Relevant Alerts & Recommendations</p>
                            </div>
                            <div className="clearfix"> </div>
                        </div>
                        <div className="cnt-w3agile-row">
                            <div className="col-md-3 contact-w3icon">
                                <i className="fa fa-heart" aria-hidden="true"></i>
                            </div>
                            <div className="col-md-9 contact-w3text">
                                <p>Requirements<br /> With Wishlists, Reviews, Ratings</p>
                            </div>
                            <div className="clearfix"> </div>
                        </div>
                    </div>
                    <div className="clearfix"> </div>
                </div>
            </div>
        </div>
        {/* <!-- //deals --> 
	<!-- footer-top --> */}
        <Introduce></Introduce>
        {/* <!-- //footer-top --> 
	<!-- subscribe --> */}
        <Subcribe></Subcribe>
        <Footer></Footer>

        </>
    );
};


export default Contact;