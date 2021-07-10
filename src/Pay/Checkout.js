import React from 'react'
import Narbar from "../Components/Layout/Navbar/Navbar";
import Siderbar from "../Components/Layout/Sidebar/Sidebar";
import Category from "../Components/Layout/Sidebar/Category";
import { Link } from 'react-router-dom';
import Subcribe from "../Components/Layout/Footer/Subcribe";
import Footer from "../Components/Layout/Footer/Footer";
import Introduce from "../Components/Layout/Footer/Introduce";
import './Checkout.css'


const Checkout = () => {

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
            <section id="checkout-body">
        <div className="container">
            <div className="row">
                <div className="col-6 left">
                    <form action="" className="form-billing">
                        <h2 className="form-title">Billing Details</h2>
                        <div className="row">
                            <div className="form-group col-6">
                                <label for="first-name" className="form-label css_form">First Name*</label>
                                <input id="first-name" name="first-name" type="text" placeholder="" className="form-control"/>
                                <span className="form-message"></span>
                            </div>
                            <div className="form-group col-6">
                                <label for="last-name" className="form-label css_form">Last Name*</label>
                                <input id="last-name" name="last-name" type="text" placeholder="" className="form-control"/>
                                <span className="form-message"></span>
                            </div>
                            <div className="form-group col-12">
                                <label for="company-name" className="form-label css_form">Company Name</label>
                                <input id="company-name" name="company-name" type="text" placeholder="" className="form-control"/>
                                <span className="form-message"></span>
                            </div>
                            <div className="form-group col-12">
                                <label for="country" className="form-label css_form">Country*</label>
                                <input id="country" name="country" type="text" placeholder="" className="form-control"/>
                                <span className="form-message"></span>
                            </div>
                            <div className="form-group col-12">
                                <label for="street-address" className="form-label css_form">Street Address*</label>
                                <input id="street-address" name="street-address" type="text" placeholder="" className="form-control"/>
                                <span className="form-message"></span>
                            </div>
                            <div className="form-group col-12">
                                <label for="postcode" className="form-label css_form">Postcode / ZIP (optional)</label>
                                <input id="postcode" name="postcode" type="text" placeholder="" className="form-control"/>
                                <span className="form-message"></span>
                            </div>
                            <div className="form-group col-12">
                                <label for="town" className="form-label css_form">Town / City*</label>
                                <input id="town" name="town" type="text" placeholder="" className="form-control"/>
                                <span className="form-message"></span>
                            </div>
                            <div className="form-group col-6">
                                <label for="email-address" className="form-label css_form">Email Address*</label>
                                <input id="email-address" name="email-address" type="text" placeholder="" className="form-control"/>
                                <span className="form-message"></span>
                            </div>
                            <div className="form-group col-6">
                                <label for="phone" className="form-label css_form">Phone*</label>
                                <input id="phone" name="phone" type="text" placeholder="" className="form-control"/>
                                <span className="form-message"></span>
                            </div>
                        </div>
                    </form>
                </div>

                <div className="col-6 right">
                    <div className="wrap">
                        <h2 className="form-title">Your Order</h2>

                        <div className="form-wrap">
                            <div className="label seperate">
                                <div className="row">
                                    <div className="col-6 left bold">
                                            PRODUCT
                                    </div>
                                     <div className="col-6 right bold">
                                            PRICE
                                    </div>
                                </div>
                            </div>
    
                            <div className="item seperate">
                                <div className="row">
                                    <div id="" className="col-6 left">
                                        <label for="" className="css_form">Combination</label>
                                        <span>X</span>
                                        <label for="">1</label>
                                    </div>

                                    <div id="" className="col-6 right bold">
                                        <span>$</span>
                                        <label for="">60.00</label>
                                    </div>
                                </div>
                            </div>
                            <div className="item seperate">
                                <div className="row">
                                    <div id="" className="col-6 left">
                                        <label for="" className = "css_form">Combination</label>
                                        <span>X</span>
                                        <label for="">1</label>
                                    </div>

                                    <div id="" className="col-6 right bold">
                                        <span>$</span>
                                        <label for="" className = "css_form">60.00</label>
                                    </div>
                                </div>
                            </div>
                         
                            <div className="subtotal seperate">
                                <div className="row">
                                    <div id="" className="col-6 left">
                                        <label for="">Subtotal</label>
                                    </div>

                                    <div id="" className="col-6 right bold">
                                        <span>$</span>
                                        <label for="">60.00</label>
                                    </div>
                                </div>
                            </div>

                            <div className="total seperate">
                                <div className="row">
                                    <div id="" className="col-6 left bold">
                                        <label for="">TOTAL</label>
                                    </div>

                                    <div id="" className="col-6 right bold">
                                        <span>$</span>
                                        <label for="">60.00</label>
                                    </div>
                                </div>
                            </div>

                            <div className="btn-wrap">
                                <button className="submit-btn">PLACE ORDER</button>
                            </div>

                        </div>
                        
                    </div>

                       
                    
                </div>
            </div>
        </div>
    </section>

            {/* <!-- footer-top --> */}
            <Introduce></Introduce>
            {/* <!-- //footer-top --> 
<!-- subscribe --> */}
            <Subcribe></Subcribe>
            <Footer></Footer>
        </>
    );
};


export default Checkout;