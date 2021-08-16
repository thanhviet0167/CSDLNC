import React from 'react'
import { Link } from 'react-router-dom';

const Cart = () => {



    return (
        <>
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
        </>
    )
};

export default Cart;