import React,{useState, useEffect} from "react";
import Narbar from "../../Components/Layout/Navbar/Navbar";
import Siderbar from "../../Components/Layout/Sidebar/Sidebar";
import Category from "../../Components/Layout/Sidebar/Category";
import { Link } from 'react-router-dom';
import Subcribe from "../../Components/Layout/Footer/Subcribe";
import Footer from "../../Components/Layout/Footer/Footer";
import Introduce from "../../Components/Layout/Footer/Introduce";
import Cart from "../Cart/Cart";
import PageCart from "../Cart/PageCart";

const Product = ({listProduct, load_more, handle_sort, handle_price, filter, handler_search_product, handle_rate, 
    handle_product_details}) => {

    
  //  var value = listProduct;
    
    
    const [count, setCount] = useState(0);
    const [value, setValue] = useState({
        product : [],
        count: 0
      });
      
    const [list_search, setlist_search] = useState({
        product : []
      });

    const sort = (type)=>{
        handle_sort(type);
    }
   
    useEffect(()=>{

        function updateList(){
            
            var pr= []
            
            for(var i = 0; i < value['product'].length; i++){
                var data = <Cart name_product = {value['product'][i]['tenSanPham']} price_current = {value['product'][i]['giaGiam']}
                price = {value['product'][i]['giaHienHanh']} product_detail = {value['product'][i]} 
                handle_product_details = {handle_product_details}></Cart>
                pr.push(data)
            }
            setlist_search({product:pr})
        }
        updateList();
    },[value])
    
    const filter_sort = (type) =>{
        handle_sort(type);
        setValue({product:listProduct})
    }

    
    const load = ()=>{
        
        setValue({product:listProduct})
     //   document.getElementsByClassName("products-row").item(leng).innerHTML(listProduct);
    }
    
    useEffect(() => {
        // Cập nhập document title sử dụng browser API
    //    document.getElementById("list").append(<div>Hello</div>) ;

    
    
      });

    return (
        <>
        
     

            <div className="header">
                <Narbar></Narbar>
                <Siderbar handler_search_product = {handler_search_product}></Siderbar>
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
            {/* // <!-- products --> */}
            <div className="products">
                <div className="container">
                    <div className="col-md-9 product-w3ls-right">
                        {/* <!-- breadcrumbs --> */}
                        <ol className="breadcrumb breadcrumb1">
                            <li><Link to="index.html">Home</Link></li>
                            <li className="active">Products</li>
                        </ol>
                        <div className="clearfix"> </div>
                        {/* <!-- //breadcrumbs --> */}
                        <div className="product-top">
                            <h4>Electronics</h4>
                            <ul>
                                <li className="dropdown head-dpdn">
                                    <Link to="#" className="dropdown-toggle" data-toggle="dropdown">Filter By<span className="caret"></span></Link>
                                    <ul className="dropdown-menu">
                                        <li><Link onClick = {()=>filter_sort('desc')}>Low price</Link></li>
                                        <li><Link onClick = {()=>filter_sort('asc')}>High price</Link></li>
                                        <li><Link to="#">Latest</Link></li>
                                        <li><Link to="#">Popular</Link></li>
                                    </ul>
                                </li>
                                <li className="dropdown head-dpdn">
                                    <Link to="#" className="dropdown-toggle" data-toggle="dropdown">Brands<span className="caret"></span></Link>
                                    <ul className="dropdown-menu">
                                        <li><Link to="#">Samsung</Link></li>
                                        <li><Link to="#">LG</Link></li>
                                        <li><Link to="#">Sony</Link></li>
                                        <li><Link to="#">Other</Link></li>
                                    </ul>
                                </li>
                            </ul>
                            <div className="clearfix"> </div>
                        </div>
                        <PageCart listProduct={list_search['product']} load_data={load}></PageCart>
                        
                        {/* <!-- add-products -->  */}
                        <div className="w3ls-add-grids w3agile-add-products">
                            <Link to="#">
                                <h4>TOP 10 TRENDS FOR YOU FLAT <span>20%</span> OFF</h4>
                                <h6>Shop now <i className="fa fa-arrow-circle-right" aria-hidden="true"></i></h6>
                            </Link>
                        </div>
                        {/* <!-- //add-products --> */}
                    </div>
                    <div className="col-md-3 rsidebar">
                        <div className="rsidebar-top">
                            <div className="slider-left">
                                <h4>Filter By Price</h4>
                                <div className="row row1 scroll-pane">
                                    <label className="checkbox"><input type="checkbox" name="checkbox" onClick ={()=>handle_price(0,220000)}/><i></i>0 - $100 </label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" onClick ={()=>handle_price(636313,824330)}/><i></i>$100 - $200 </label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>$200 - $250  </label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>$250 - $300 </label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>$350 - $400 </label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>$450 - $500  </label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>More</label>
                                </div>
                            </div>
                            <br/>
                            <br />
                            <br/>
                            <br />
                            <div className="slider-left">
                                <h4>Filter By Rate</h4>
                                <div className="row row1 scroll-pane">
                                    <label className="checkbox"><input type="checkbox" name="checkbox" onClick = {()=>handle_rate(1,2)}/><i></i>1 star - 2 star</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" onClick = {()=>handle_rate(2,3)}/><i></i>2 star - 3 star</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" onClick = {()=>handle_rate(3,4)}/><i></i>3 star - 4 star</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" onClick = {()=>handle_rate(4,5)}/><i></i>4 star - 5 star</label>
                                
                                </div>
                            </div>
                            <div className="sidebar-row">
                                <h4> Electronics</h4>
                                <ul className="faq">
                                    <li className="item1"><Link to="#">Mobile phones<span className="glyphicon glyphicon-menu-down"></span></Link>
                                        <ul>
                                            <li className="subitem1"><Link to="#">Smart phones</Link></li>
                                            <li className="subitem1"><Link to="#">Accessories</Link></li>
                                            <li className="subitem1"><Link to="#">Tabs</Link></li>
                                        </ul>
                                    </li>
                                    <li className="item2"><Link to="#">Large appliances<span className="glyphicon glyphicon-menu-down"></span></Link>
                                        <ul>
                                            <li className="subitem1"><Link to="#">Refrigerators </Link></li>
                                            <li className="subitem1"><Link to="#">Washing Machine </Link></li>
                                            <li className="subitem1"><Link to="#">Kitchen Appliances </Link></li>
                                            <li className="subitem1"><Link to="#">Air Conditioner</Link></li>
                                        </ul>
                                    </li>
                                    <li className="item3"><Link to="#">Entertainment<span className="glyphicon glyphicon-menu-down"></span></Link>
                                        <ul>
                                            <li className="subitem1"><Link to="#"> Tv & Accessories</Link></li>
                                            <li className="subitem1"><Link to="#">Digital Camera </Link></li>
                                            <li className="subitem1"><Link to="#">Computer</Link></li>
                                        </ul>
                                    </li>
                                </ul>
                                {/* <!-- script for tabs --> */}

                                {/* <!-- script for tabs --> */}
                            </div>
                            <div className="sidebar-row">
                                <h4>DISCOUNTS</h4>
                                <div className="row row1 scroll-pane">
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>Upto - 10% (20)</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>70% - 60% (5)</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>50% - 40% (7)</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>30% - 20% (2)</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>10% - 5% (5)</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>30% - 20% (7)</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>10% - 5% (2)</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>Other(50)</label>
                                </div>
                            </div>
                            <div className="sidebar-row">
                                <h4>Color</h4>
                                <div className="row row1 scroll-pane">
                                    <label className="checkbox"><input type="checkbox" name="checkbox" checked="" /><i></i>White</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>Pink</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>Gold</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>Blue</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>Orange</label>
                                    <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i> Brown</label>
                                </div>
                            </div>
                        </div>
                        <div className="related-row">
                            <h4>Related Searches</h4>
                            <ul>
                                <li><Link to="products.html">Air conditioner </Link></li>
                                <li><Link to="products.html">Gaming</Link></li>
                                <li><Link to="products.html">Monitors</Link></li>
                                <li><Link to="products.html">Pc </Link></li>
                                <li><Link to="products.html">Food Processors</Link></li>
                                <li><Link to="products.html">Oven</Link></li>
                                <li><Link to="products.html">Purifiers</Link></li>
                                <li><Link to="products.html">Oven</Link></li>
                                <li><Link to="products.html">Cleaners</Link></li>
                                <li><Link to="products.html">Small devices</Link></li>
                            </ul>
                        </div>
                        <div className="related-row">
                            <h4>YOU MAY ALSO LIKE</h4>
                            <div className="galry-like">
                                <Link to="single.html"><img src="images/e1.png" className="img-responsive" alt="img" /></Link>
                                <h4><Link to="products.html">Audio speaker</Link></h4>
                                <h5>$100</h5>
                            </div>
                        </div>
                    </div>
                    <div className="clearfix"> </div>
                    {/* <!-- recommendations --> */}
                    <div className="recommend">
                        <h3 className="w3ls-title">Our Recommendations </h3>

                        <div id="owl-demo5" className="owl-carousel">
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>20% <br /> Off</h6></div>
                                    <Link to="products1.html"><img src="images/f2.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products1.html">Women Sandal</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$20</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Women Sandal" />
                                            <input type="hidden" name="amount" value="20.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products.html"><img src="images/e4.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products.html">Digital Camera</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$80</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Digital Camera" />
                                            <input type="hidden" name="amount" value="100.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>New</h6></div>
                                    <Link to="products4.html"><img src="images/s1.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products4.html">Roller Skates</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$180</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Roller Skates" />
                                            <input type="hidden" name="amount" value="180.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products1.html"><img src="images/f1.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products1.html">T Shirt</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$10</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="T Shirt" />
                                            <input type="hidden" name="amount" value="10.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>New</h6></div>
                                    <Link to="products6.html"><img src="images/p1.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products6.html">Coffee Mug</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$14</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Coffee Mug" />
                                            <input type="hidden" name="amount" value="14.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>20% <br /> Off</h6></div>
                                    <Link to="products6.html"><img src="images/p2.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products6.html">Teddy bear</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$20</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Teddy bear" />
                                            <input type="hidden" name="amount" value="20.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products4.html"><img src="images/s2.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products4.html">Football</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$70</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Football" />
                                            <input type="hidden" name="amount" value="70.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>Sale</h6></div>
                                    <Link to="products3.html"><img src="images/h1.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products3.html">Wall Clock</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$80</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Wall Clock" />
                                            <input type="hidden" name="amount" value="80.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/* <!-- //recommendations --> */}
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

export default Product;