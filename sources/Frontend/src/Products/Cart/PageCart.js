import React, { useState, useEffect } from "react";
import { Link } from 'react-router-dom';

const PageCart = ({listProduct, load_data}) => {

    function load(){
        load_data();
    }

    return (
        <>
            <div className="products-row">

                {listProduct}

                <div className="col-md-3 product-grids">
                    <div className="agile-products">
                        <div className="new-tag"><h6>20%<br />Off</h6></div>
                        <Link to="single.html"><img src="images/e1.png" className="img-responsive" alt="img" /></Link>
                        <div className="agile-product-text">
                            <h5><Link to="single.html">Audio speaker</Link></h5>
                            <h6><del>$200</del> $100</h6>
                            <form action="#" method="post">
                                <input type="hidden" name="cmd" value="_cart" />
                                <input type="hidden" name="add" value="1" />
                                <input type="hidden" name="w3ls_item" value="Audio speaker" />
                                <input type="hidden" name="amount" value="100.00" />
                                <button type="submit" className="w3ls-cart pw3ls-cart"><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div className="col-md-3 product-grids">
                    <div className="agile-products">
                        <div className="new-tag"><h6>New</h6></div>
                        <Link to="single.html"><img src="images/e2.png" className="img-responsive" alt="img" /></Link>
                        <div className="agile-product-text">
                            <h5><Link to="single.html">Refrigerator</Link></h5>
                            <h6><del>$700</del> $300</h6>
                            <form action="#" method="post">
                                <input type="hidden" name="cmd" value="_cart" />
                                <input type="hidden" name="add" value="1" />
                                <input type="hidden" name="w3ls_item" value="Refrigerator" />
                                <input type="hidden" name="amount" value="300.00" />
                                <button type="submit" className="w3ls-cart pw3ls-cart"><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div className="col-md-3 product-grids">
                    <div className="agile-products">
                        <div className="new-tag"><h6>5% <br /> Off</h6></div>
                        <Link to="single.html"><img src="images/e3.png" className="img-responsive" alt="img" /></Link>
                        <div className="agile-product-text">
                            <h5><Link to="single.html">Smart Phone</Link></h5>
                            <h6><del>$100</del> $70</h6>
                            <form action="#" method="post">
                                <input type="hidden" name="cmd" value="_cart" />
                                <input type="hidden" name="add" value="1" />
                                <input type="hidden" name="w3ls_item" value="Smart Phone" />
                                <input type="hidden" name="amount" value="70.00" />
                                <button type="submit" className="w3ls-cart pw3ls-cart"><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div className="col-md-3 product-grids">
                    <div className="agile-products">
                        <div className="new-tag"><h6>New</h6></div>
                        <Link to="single.html"><img src="images/e4.png" className="img-responsive" alt="img" /></Link>
                        <div className="agile-product-text">
                            <h5><Link to="single.html">Digital Camera</Link></h5>
                            <h6><del>$100</del> $80</h6>
                            <form action="#" method="post">
                                <input type="hidden" name="cmd" value="_cart" />
                                <input type="hidden" name="add" value="1" />
                                <input type="hidden" name="w3ls_item" value="Digital Camera" />
                                <input type="hidden" name="amount" value="80.00" />
                                <button type="submit" className="w3ls-cart pw3ls-cart"><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                            </form>
                        </div>
                    </div>
                </div>
                
            
                <button className="btn btn-primary" style={{ margin: "10px 370px", with: "50px" }} onClick={()=>load()}>Load data</button>
                {/* <button className="btn btn-primary" style={{ margin: "10px 20px", with: "25px" }}>Previous</button>
                <button className="btn btn-primary" style={{ margin: "10px 5px", with: "25x" }}>Net</button> */}

                <div className="clearfix"> </div>
            </div>
        </>
    );
};

export default PageCart;
