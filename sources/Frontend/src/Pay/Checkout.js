import React, { useEffect, useState } from 'react'
import Narbar from "../Components/Layout/Navbar/Navbar";
import Siderbar from "../Components/Layout/Sidebar/Sidebar";
import Category from "../Components/Layout/Sidebar/Category";
import { Link, Redirect } from 'react-router-dom';
import Subcribe from "../Components/Layout/Footer/Subcribe";
import Footer from "../Components/Layout/Footer/Footer";
import Introduce from "../Components/Layout/Footer/Introduce";
import './Checkout.css'

import Checkout_Item from './Checkout_Item';


const Checkout = () => {

    const [cart_details, setCartDetails] = useState({
        cart:[],

    })

    const [price_current, setPriceCurrent] = useState({
        promotion: 25000,
        transport: 25000
    }) 

    const getTransport = () =>{
        var p = document.getElementById("transport").value
        console.log(p)
        if(p == "25k"){
            
            setPriceCurrent({
                ... price_current,
                transport: 25000
            })
        }
        else{
            if(p == "40k"){
                setPriceCurrent({
                    ... price_current,
                    transport: 40000
                })
               
            }
            else{
               
                    setPriceCurrent({
                        ... price_current,
                        transport: 120000
                    })
                    
                
            }
        }

        
    }


    
    const getPromotion = () =>{
        var p = document.getElementById("promotion").value
        console.log(p)
        if(p == "25k"){
            
            setPriceCurrent({
                ... price_current,
                promotion: 25000
            })
        }
        else{
            if(p == "10%"){
                setPriceCurrent({
                    ... price_current,
                    promotion: localStorage.getItem('total')*0.1
                })
               
            }
            else{
                if(p == "15%"){
                    setPriceCurrent({
                        ... price_current,
                        promotion: localStorage.getItem('total')*0.15
                    })
                    
                }
                else{
                    setPriceCurrent({
                        ... price_current,
                        promotion: 40000
                    })
                    
                }
            }
        }

        
    }
    
    const init = () =>{
       
        var convert = JSON.parse(localStorage.getItem('list_cart'));
        var content = []
        for(var i = 0; i < convert.length; i++){
            var txt = <Checkout_Item  number={convert[i]['soLuongMua']}
            total={convert[i]['giaBanThucTe']} id={convert[i]['chiTietGioHangID']['maSanPham']}
           ></Checkout_Item>

            content.push(txt);
        }

        setCartDetails({
            cart:content
        })
    }
   

    const handle_buy = () =>{
        var data = {
            "nhaCungCap": {
                "username": "Copley999"
            },
            "tongTienChuaKhuyenMai": localStorage.getItem('total'),
            "tongTienQuaTang": localStorage.getItem('total') - localStorage.getItem('total_final'),
            "soTienGiamThucTe": localStorage.getItem('total_final'),
            "voucher": {
                "maVoucher": 315
            },
            "soDiaChi": {
                "soDiaChiID": {
                    "username": "Abbie1955",
                    "stt": 10
                }
            },
            "chiTietGioHangSet": JSON.parse(localStorage.getItem('list_cart')),
            "voucherApDungSet": [
                {
                    "voucherApDungID": {
                        "maVoucher": 7
                    },
                    "chiTietQuaTangSet": [
                        {
                            "chiTietQuaTangID": {
                                "sanPhamTangKem": 1932
                            },
                            "giaBanTangKem": 21930,
                            "soLuongTangKem": 1
                        }
                    ]
                }
            ]
        }

        var beta = {
            "nhaCungCap": {
                "username": "Copley999"
            },
            "tongTienChuaKhuyenMai": 14919039,
            "tongTienQuaTang": 360423,
            "soTienGiamThucTe": 360423,
            "voucher": {
                "maVoucher": 315
            },
            "soDiaChi": {
                "soDiaChiID": {
                    "username": "Abbie1955",
                    "stt": 10
                }
            },
            "chiTietGioHangSet": [
                {
                    "chiTietGioHangID": {
                        "maSanPham": 1931
                    },
                    "soLuongMua": 43,
                    "giaBanThucTe": 2634935,
                    "giaGiam": 597466
                },
                {
                    "chiTietGioHangID": {
                        "maSanPham": 1193
                    },
                    "soLuongMua": 18,
                    "giaBanThucTe": 2759148,
                    "giaGiam": 201284
                }
            ],
            "voucherApDungSet": [
                {
                    "voucherApDungID": {
                        "maVoucher": 7
                    },
                    "chiTietQuaTangSet": [
                        {
                            "chiTietQuaTangID": {
                                "sanPhamTangKem": 1932
                            },
                            "giaBanTangKem": 21930,
                            "soLuongTangKem": 1
                        }
                    ]
                }
            ]
        }


        
        fetch('http://localhost:8080/nacotiki/api/cart', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        },
        body: JSON.stringify(data)
        })
        .then(res => res.json())
        .then(json => {
           
            console.log(json)
            alert("Order Success")
            localStorage.setItem('list_cart',[])
            localStorage.setItem('size',0)
            localStorage.setItem('total',0)
            localStorage.setItem('total_final',0)
            window.location.href = "http://localhost:3000"
        });
    }

    

    useEffect(() => {

        console.log(localStorage.getItem('total'))
        if(localStorage.getItem('total') > 0){
            init()
            var price_cur = localStorage.getItem('total') - price_current['promotion'] + price_current['transport'];
            localStorage.setItem('total_final',price_cur);
        }
        
       
    }

        , [price_current])


    if(localStorage.getItem('token')){
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
                <div className="container wrapper">
                <div className="row cart-head">
                    <div className="container">
                    <div className="row">
                        <p></p>
                    </div>
                    <div className="row">
                        <div style={{display: "table", margin: "auto"}}>
                            <span className="step step_complete"> <a href="#" className="check-bc">Cart</a> <span className="step_line step_complete"> </span> <span className="step_line backline"> </span> </span>
                            <span className="step step_complete"> <a href="#" className="check-bc">Checkout</a> <span className="step_line "> </span> <span className="step_line step_complete"> </span> </span>
                            {/* <span className="step_thankyou check-bc step_complete">Thank you</span> */}
                        </div>
                    </div>
                    <div className="row">
                        <p></p>
                    </div>
                    </div>
                </div>    
                <div className="row cart-body">
                    <form className="form-horizontal" method="post" action="">
                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-push-6 col-sm-push-6">
                      
                        <div className="panel panel-info">
                            <div className="panel-heading">
                                Review Order <div className="pull-right"><small><a className="afix-1" href="#">Edit Cart</a></small></div>
                            </div>
                            <div className="panel-body">
                                
                                {localStorage.getItem('total') > 0?cart_details['cart']: <p style={{color:'yellowgreen'}}>Cart is empty</p>}
                                
    
                                
                                
    
                                <div className="form-group">
                                    <div className="col-md-12"><strong>Promotion</strong></div>
                                    <div className="col-md-12">
                                        <select id="promotion" name="CreditCardType" className="form-control" onClick={()=>getPromotion()}>
                                           
                                            <option value="25k">Free ship 25k</option>
                                            <option value="10%">Sale 10%</option>
                                            <option value="15%">Sale 15%</option>
                                            <option value="40k">Free ship 40k</option>
                                        </select>
                                    </div>
                                </div>
    
                                <div className="form-group">
                                    <div className="col-md-12"><strong>Transport</strong></div>
                                    <div className="col-md-12">
                                        <select id="transport" name="CreditCardType" className="form-control" onClick = {()=>getTransport()}>
                                           
                                            <option value="25k">Normal</option>
                                            <option value="40k">Faster</option>
                                            <option value="120k">Air freight</option>
                                            
                                        </select>
                                    </div>
                                </div>
    
                                <div className="form-group">
                                    <div className="col-xs-8">
                                        <strong>Subtotal</strong>
                                        <div className="pull-right"><span>$</span><span>{localStorage.getItem('total')}</span></div>
                                    </div>
                                    <div className="col-xs-8">
                                        <small>Promotion</small>
                                        <div className="pull-right"><span>+{price_current['promotion']}</span></div>
                                    </div>
                                    <div className="col-xs-8">
                                        <small>Shipping</small>
                                        <div className="pull-right"><span>-{price_current['transport']}</span></div>
                                    </div>
                                </div>
                                <div className="form-group"><hr /></div>
                                <div className="form-group">
                                    <div className="col-xs-12">
                                        <strong>Order Total</strong>
                                        <div className="pull-right"><span>$</span><span>{localStorage.getItem('total_final')}</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-pull-6 col-sm-pull-6">
                       
                        <div className="panel panel-info">
                            <div className="panel-heading">Address</div>
                            <div className="panel-body">
                                <div className="form-group">
                                    <div className="col-md-12">
                                        <h4>Shipping Address</h4>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12"><strong>Country:</strong></div>
                                    <div className="col-md-12">
                                        <input type="text" className="form-control" name="country" />
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-6 col-xs-12">
                                        <strong>First Name:</strong>
                                        <input type="text" name="first_name" className="form-control" />
                                    </div>
                                    <div className="span1"></div>
                                    <div className="col-md-6 col-xs-12">
                                        <strong>Last Name:</strong>
                                        <input type="text" name="last_name" className="form-control"  />
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12"><strong>Address:</strong></div>
                                    <div className="col-md-12">
                                        <input type="text" name="address" className="form-control" />
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12"><strong>City:</strong></div>
                                    <div className="col-md-12">
                                        <input type="text" name="city" className="form-control" />
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12"><strong>State:</strong></div>
                                    <div className="col-md-12">
                                        <input type="text" name="state" className="form-control"/>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12"><strong>Zip / Postal Code:</strong></div>
                                    <div className="col-md-12">
                                        <input type="text" name="zip_code" className="form-control" />
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12"><strong>Phone Number:</strong></div>
                                    <div className="col-md-12"><input type="text" name="phone_number" className="form-control" /></div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12"><strong>Email Address:</strong></div>
                                    <div className="col-md-12"><input type="text" name="email_address" className="form-control" /></div>
                                </div>
                            </div>
                        </div>
                       
                        <div className="panel panel-info">
                            <div className="panel-heading"><span><i className="glyphicon glyphicon-lock"></i></span> Secure Payment</div>
                            <div className="panel-body">
                                <div className="form-group">
                                    <div className="col-md-12"><strong>Card Type:</strong></div>
                                    <div className="col-md-12">
                                        <select id="CreditCardType" name="CreditCardType" className="form-control">
                                            <option value="5">Visa</option>
                                            <option value="6">MasterCard</option>
                                            <option value="7">American Express</option>
                                            <option value="8">Discover</option>
                                        </select>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12"><strong>Credit Card Number:</strong></div>
                                    <div className="col-md-12"><input type="text" className="form-control" name="car_number" /></div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12"><strong>Card CVV:</strong></div>
                                    <div className="col-md-12"><input type="text" className="form-control" name="car_code" /></div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12">
                                        <strong>Expiration Date</strong>
                                    </div>
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <select className="form-control" name="">
                                            <option value="">Month</option>
                                            <option value="01">01</option>
                                            <option value="02">02</option>
                                            <option value="03">03</option>
                                            <option value="04">04</option>
                                            <option value="05">05</option>
                                            <option value="06">06</option>
                                            <option value="07">07</option>
                                            <option value="08">08</option>
                                            <option value="09">09</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                    </select>
                                    </div>
                                    <div className="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <select className="form-control" name="">
                                            <option value="">Year</option>
                                            <option value="2015">2015</option>
                                            <option value="2016">2016</option>
                                            <option value="2017">2017</option>
                                            <option value="2018">2018</option>
                                            <option value="2019">2019</option>
                                            <option value="2020">2020</option>
                                            <option value="2021">2021</option>
                                            <option value="2022">2022</option>
                                            <option value="2023">2023</option>
                                            <option value="2024">2024</option>
                                            <option value="2025">2025</option>
                                    </select>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-12">
                                        <span>Pay secure using your credit card.</span>
                                    </div>
                                    <div className="col-md-12">
                                        <ul className="cards">
                                            <li className="visa hand">Visa</li>
                                            <li className="mastercard hand">MasterCard</li>
                                            <li className="amex hand">Amex</li>
                                        </ul>
                                        <div className="clearfix"></div>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <div className="col-md-6 col-sm-6 col-xs-12">
                                        <Link to="/"><button type="button" className="btn btn-primary btn-submit-fix" onClick={()=>handle_buy()}>Place Order</button></Link>
                                    </div>
                                </div>
                            </div>
                        </div>
                      
                    </div>
                    
                    </form>
                </div>
                <div className="row cart-footer">
            
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
    }
    else{
        window.location.href = "http://localhost:3000/login"
    }
    
};


export default Checkout;