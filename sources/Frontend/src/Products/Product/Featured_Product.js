import React from "react";
import { Link } from 'react-router-dom';

const Featured_Product = () => {

    return(
        <>
            <h3 className="w3ls-title">Featured Products</h3>
            <div id="myTabContent" className="tab-content">
                <div role="tabpanel" className="tab-pane fade in active" id="home" aria-labelledby="home-tab">
                    <div className="tabcontent-grids">
                        <div id="owl-demo" className="owl-carousel">
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products.html"><img src="images/e1.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products.html">Audio speaker</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$100</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Audio speaker" />
                                            <input type="hidden" name="amount" value="100.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>Sale</h6></div>
                                    <Link to="products.html"><img src="images/e2.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products.html">Refrigerator</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$300</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Refrigerator" />
                                            <input type="hidden" name="amount" value="300.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>New</h6></div>
                                    <Link to="products.html"><img src="images/e3.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products.html">Smart Phone</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$70</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Smart Phone" />
                                            <input type="hidden" name="amount" value="70.00" />
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
                                            <input type="hidden" name="amount" value="80.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products.html"><img src="images/e1.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products.html">Audio speaker</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$100</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Audio speaker" />
                                            <input type="hidden" name="amount" value="100.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>Sale</h6></div>
                                    <Link to="products.html"><img src="images/e2.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products.html">Refrigerator</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$300</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Refrigerator" />
                                            <input type="hidden" name="amount" value="300.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>New</h6></div>
                                    <Link to="products.html"><img src="images/e3.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products.html">Smart Phone</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$70</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Smart Phone" />
                                            <input type="hidden" name="amount" value="70.00" />
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
                                            <input type="hidden" name="amount" value="80.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" className="tab-pane fade" id="carl" aria-labelledby="carl-tab">
                    <div className="tabcontent-grids">

                        <div id="owl-demo1" className="owl-carousel">
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
                                    <Link to="products1.html"><img src="images/f3.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products1.html">Jewellery</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$60</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Jewellery" />
                                            <input type="hidden" name="amount" value="60.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>New</h6></div>
                                    <Link to="products1.html"><img src="images/f4.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products1.html">Party dress</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$15</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Party dress" />
                                            <input type="hidden" name="amount" value="15.00" />
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
                                    <Link to="products1.html"><img src="images/f3.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products1.html">Jewellery</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$60</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Jewellery" />
                                            <input type="hidden" name="amount" value="60.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>New</h6></div>
                                    <Link to="products1.html"><img src="images/f4.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products1.html">Party dress</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$15</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Party dress" />
                                            <input type="hidden" name="amount" value="15.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" className="tab-pane fade" id="james" aria-labelledby="james-tab">
                    <div className="tabcontent-grids">

                        <div id="owl-demo2" className="owl-carousel">
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
                                    <div className="new-tag"><h6>Sale</h6></div>
                                    <Link to="products6.html"><img src="images/p3.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products6.html">Chocolates</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$60</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Chocolates" />
                                            <input type="hidden" name="amount" value="60.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products6.html"><img src="images/p4.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products6.html">Gift Card</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$22</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Gift Card" />
                                            <input type="hidden" name="amount" value="22.00" />
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
                                    <div className="new-tag"><h6>Sale</h6></div>
                                    <Link to="products6.html"><img src="images/p3.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products6.html">Chocolates</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$60</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Chocolates" />
                                            <input type="hidden" name="amount" value="60.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products6.html"><img src="images/p4.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products6.html">Gift Card</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$22</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Gift Card" />
                                            <input type="hidden" name="amount" value="22.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" className="tab-pane fade" id="decor" aria-labelledby="decor-tab">
                    <div className="tabcontent-grids">

                        <div id="owl-demo3" className="owl-carousel">
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
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>10%<br />Off</h6></div>
                                    <Link to="products3.html"><img src="images/h2.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products3.html">Plants & Vases</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$40</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Plants & Vases" />
                                            <input type="hidden" name="amount" value="40.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products3.html"><img src="images/h3.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products3.html">Queen Size Bed</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$250</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Queen Size Bed" />
                                            <input type="hidden" name="amount" value="250.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products3.html"><img src="images/h4.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products3.html">flower pot</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$30</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="flower pot" />
                                            <input type="hidden" name="amount" value="30.00" />
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
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>10%<br />Off</h6></div>
                                    <Link to="products3.html"><img src="images/h2.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products3.html">Plants & Vases</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$40</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Plants & Vases" />
                                            <input type="hidden" name="amount" value="40.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products3.html"><img src="images/h3.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products3.html">Queen Size Bed</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$250</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Queen Size Bed" />
                                            <input type="hidden" name="amount" value="250.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products3.html"><img src="images/h4.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products3.html">flower pot</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$30</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="flower pot" />
                                            <input type="hidden" name="amount" value="30.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" className="tab-pane fade" id="sports" aria-labelledby="sports-tab">
                    <div className="tabcontent-grids">

                        <div id="owl-demo4" className="owl-carousel">
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
                                            <button type="submit" className="w3ls-cart"><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <div className="new-tag"><h6>20% <br />Off</h6></div>
                                    <Link to="products4.html"><img src="images/s3.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products4.html">Nylon Shuttle</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$56</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Nylon Shuttle" />
                                            <input type="hidden" name="amount" value="56.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products4.html"><img src="images/s4.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products4.html">Cricket Kit</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$80</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Cricket Kit" />
                                            <input type="hidden" name="amount" value="80.00" />
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
                                    <div className="new-tag"><h6>20% <br />Off</h6></div>
                                    <Link to="products4.html"><img src="images/s3.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products4.html">Nylon Shuttle</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$56</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Nylon Shuttle" />
                                            <input type="hidden" name="amount" value="56.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="item">
                                <div className="glry-w3agile-grids agileits">
                                    <Link to="products4.html"><img src="images/s4.png" alt="img" /></Link>
                                    <div className="view-caption agileits-w3layouts">
                                        <h4><Link to="products4.html">Cricket Kit</Link></h4>
                                        <p>Lorem ipsum dolor sit amet consectetur</p>
                                        <h5>$80</h5>
                                        <form action="#" method="post">
                                            <input type="hidden" name="cmd" value="_cart" />
                                            <input type="hidden" name="add" value="1" />
                                            <input type="hidden" name="w3ls_item" value="Cricket Kit" />
                                            <input type="hidden" name="amount" value="80.00" />
                                            <button type="submit" className="w3ls-cart" ><i className="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};

export default Featured_Product;