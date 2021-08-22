import React, { useEffect, useState } from "react";
import Narbar from "../../Components/Layout/Navbar/Navbar";
import Siderbar from "../../Components/Layout/Sidebar/Sidebar";
import Category from "../../Components/Layout/Sidebar/Category";
import { Link , Redirect} from 'react-router-dom';
import Subcribe from "../../Components/Layout/Footer/Subcribe";
import Footer from "../../Components/Layout/Footer/Footer";
import Introduce from "../../Components/Layout/Footer/Introduce";

import './Shopping_Cart.css'
import Cart_Iteam from "./Cart_Iteam";

const Shopping_Cart = ({handle_update_plus, handle_update_moin, handle_remove, user}) => {


    const [cart_details, setCartDetails] = useState({
        cart:[]
    })

    
    
   

    

    useEffect(() => {

        
        if(localStorage.getItem('total') > 0){
            var convert = JSON.parse(localStorage.getItem('list_cart'));
            var content = []
            for(var i = 0; i < convert.length; i++){
                var txt = <Cart_Iteam price = {convert[i]['giaGiam']} number={convert[i]['soLuongMua']}
                total={convert[i]['giaBanThucTe']} id={convert[i]['chiTietGioHangID']['maSanPham']}
                handle_update_plus = {handle_update_plus} handle_update_moin = {handle_update_moin}
                handle_remove = {handle_remove}></Cart_Iteam>
    
                content.push(txt);
            }
        }
       

        setCartDetails({
            cart:content
        })
    }

        , [cart_details])


    if(localStorage.getItem('token'))    
    {
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
    
    
                            </div>
                        </div>
                    </div>
                </div>
    
    
                <section id="shopping-cart-body">
                    <ol className="breadcrumb breadcrumb1">
                        <li><Link to="index.html">Home</Link></li>
                        <li className="active">Products</li>
                    </ol>
    
                    <div className="shopping-cart">
                        <div className="column-labels">
                            <label className="product-image">Image</label>
                            <label className="product-details">Product</label>
                            <label className="product-price">Price</label>
                            <label className="product-quantity">Quantity</label>
                            <label className="product-removal">Remove</label>
                            <label className="product-line-price">Total</label>
                        </div>
                        {localStorage.getItem('total') > 0? cart_details['cart']:<p style={{marginLeft:"5%"}}><h2>Cart is empty</h2> 
                        <Link to='/'><button type="button" class="btn btn-primary">Go to shop</button></Link></p>}
                        
    
                       
                         
    
                        <div className="totals">
                            <div className="totals-item">
                                <label>Subtotal</label>
                                <div className="totals-value" id="cart-subtotal">{localStorage.getItem('total')}</div>
                            </div>
                            <div className="totals-item">
                                <label>Tax (5%)</label>
                                <div className="totals-value" id="cart-tax">{localStorage.getItem('total')*0.05}</div>
                            </div>
                            <div className="totals-item">
                                <label>Shipping</label>
                                {localStorage.getItem('total') > 0 ? <div className="totals-value" id="cart-shipping">23000</div>:
                                <div className="totals-value" id="cart-shipping">0</div>}
                                
                            </div>
                            <div className="totals-item totals-item-total">
                                <label>Grand Total</label>
                                {localStorage.getItem('total') > 0 ? <div className="totals-value" id="cart-total">{localStorage.getItem('total')-
                                localStorage.getItem('total')*0.05 - 23000}</div>:
                                <div className="totals-value" id="cart-total">0</div>}
                                
    
                            </div>
                        </div>
    
                        <button className="checkout"><Link to='/check-out'>Checkout</Link></button>
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
    }
    else{
        // return <Redirect to="/login" />
       
        window.location.href = "http://localhost:3000/login"
    }
    
}

export default Shopping_Cart;