import React from "react";
import { Link } from 'react-router-dom';
const Deal = () => {


    return (
        <div className="deals">
            <div className="container">
                <h3 className="w3ls-title">DEALS OF THE DAY </h3>
                <div className="deals-row">
                    <div className="col-md-3 focus-grid">
                        <Link to="products.html" className="wthree-btn">
                            <div className="focus-image"><i className="fa fa-mobile"></i></div>
                            <h4 className="clrchg">Mobiles</h4>
                        </Link>
                    </div>
                    <div className="col-md-3 focus-grid">
                        <Link to="products.html" className="wthree-btn wthree1">
                            <div className="focus-image"><i className="fa fa-laptop"></i></div>
                            <h4 className="clrchg"> Electronics & Appliances</h4>
                        </Link>
                    </div>
                    <div className="col-md-3 focus-grid">
                        <Link to="products4.html" className="wthree-btn wthree2">
                            <div className="focus-image"><i className="fa fa-wheelchair"></i></div>
                            <h4 className="clrchg">Furnitures</h4>
                        </Link>
                    </div>
                    <div className="col-md-3 focus-grid">
                        <Link to="products3.html" className="wthree-btn wthree3">
                            <div className="focus-image"><i className="fa fa-home"></i></div>
                            <h4 className="clrchg">Home Decor</h4>
                        </Link>
                    </div>
                    <div className="col-md-2 focus-grid w3focus-grid-mdl">
                        <Link to="products9.html" className="wthree-btn wthree3">
                            <div className="focus-image"><i className="fa fa-book"></i></div>
                            <h4 className="clrchg">Books & Music</h4>
                        </Link>
                    </div>
                    <div className="col-md-2 focus-grid w3focus-grid-mdl">
                        <Link to="products1.html" className="wthree-btn wthree4">
                            <div className="focus-image"><i className="fa fa-asterisk"></i></div>
                            <h4 className="clrchg">Fashion</h4>
                        </Link>
                    </div>
                    <div className="col-md-2 focus-grid w3focus-grid-mdl">
                        <Link to="products2.html" className="wthree-btn wthree2">
                            <div className="focus-image"><i className="fa fa-gamepad"></i></div>
                            <h4 className="clrchg">Kids</h4>
                        </Link>
                    </div>
                    <div className="col-md-2 focus-grid w3focus-grid-mdl">
                        <Link to="products5.html" className="wthree-btn wthree">
                            <div className="focus-image"><i className="fa fa-shopping-basket"></i></div>
                            <h4 className="clrchg">Groceries</h4>
                        </Link>
                    </div>
                    <div className="col-md-2 focus-grid w3focus-grid-mdl">
                        <Link to="products7.html" className="wthree-btn wthree5">
                            <div className="focus-image"><i className="fa fa-medkit"></i></div>
                            <h4 className="clrchg">Health</h4>
                        </Link>
                    </div>
                    <div className="col-md-2 focus-grid w3focus-grid-mdl">
                        <Link to="products8.html" className="wthree-btn wthree1">
                            <div className="focus-image"><i className="fa fa-car"></i></div>
                            <h4 className="clrchg">Automotive</h4>
                        </Link>
                    </div>
                    <div className="col-md-3 focus-grid">
                        <Link to="products5.html" className="wthree-btn wthree2">
                            <div className="focus-image"><i className="fa fa-cutlery"></i></div>
                            <h4 className="clrchg">Food</h4>
                        </Link>
                    </div>
                    <div className="col-md-3 focus-grid">
                        <Link to="products4.html" className="wthree-btn wthree5">
                            <div className="focus-image"><i className="fa fa-futbol-o"></i></div>
                            <h4 className="clrchg">Sports</h4>
                        </Link>
                    </div>
                    <div className="col-md-3 focus-grid">
                        <Link to="products2.html" className="wthree-btn wthree3">
                            <div className="focus-image"><i className="fa fa-gamepad"></i></div>
                            <h4 className="clrchg">Games & Toys</h4>
                        </Link>
                    </div>
                    <div className="col-md-3 focus-grid">
                        <Link to="products6.html" className="wthree-btn ">
                            <div className="focus-image"><i className="fa fa-gift"></i></div>
                            <h4 className="clrchg">Gifts</h4>
                        </Link>
                    </div>
                    <div className="clearfix"> </div>
                </div>
            </div>
        </div>
    );
};


export default Deal;