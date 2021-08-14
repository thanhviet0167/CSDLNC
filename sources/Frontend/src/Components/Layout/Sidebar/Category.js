import React from 'react'
import { Link } from 'react-router-dom';
const Category = () => {
    return (
        <>
            <Link className="cd-dropdown-trigger" to="#0">Store Categories</Link>
            <nav className="cd-dropdown">
                <Link to="#0" className="cd-close">Close</Link>
                <ul className="cd-dropdown-content">
                    <li><a href="/offers">Today's Offers</a></li>
                    <li className="has-children">
                        <Link to="#">Electronics</Link>
                        <ul className="cd-secondary-dropdown is-hidden">
                            <li className="go-back"><Link to="#">Menu</Link></li>
                            <li className="see-all"><Link to="products.html">All Electronics</Link></li>
                            <li className="has-children">
                                <Link to="#">MOBILE PHONES</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Electronics</Link></li>
                                    <li className="has-children">
                                        <Link to="#0">SmartPhones</Link>
                                        <ul className="is-hidden">
                                            <li className="go-back"><Link to="#"> </Link></li>
                                            <li><Link to="products.html">Android</Link></li>
                                            <li><Link to="products.html">Windows</Link></li>
                                            <li><Link to="products.html">Black berry</Link></li>
                                        </ul>
                                    </li>
                                    <li> <Link to="products.html">IPhones</Link> </li>
                                    <li><Link to="products.html">Tablets</Link></li>
                                    <li><Link to="products.html">IPad</Link></li>
                                    <li><Link to="products.html">Feature Phones</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">LARGE APPLIANCES</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Electronics </Link></li>
                                    <li><Link to="products.html">Refrigerators</Link></li>
                                    <li><Link to="products.html">Washing Machine</Link></li>
                                    <li><Link to="products.html">Office Technology</Link></li>
                                    <li><Link to="products.html">Air conditioner</Link></li>
                                    <li><Link to="products.html">Home Automation</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">ENTERTAINMENT</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Electronics</Link></li>
                                    <li><Link to="products.html">Tv & Accessories</Link></li>
                                    <li><Link to="products.html">Digital Camera</Link></li>
                                    <li><Link to="products.html">Gaming</Link></li>
                                    <li><Link to="products.html">Home Audio & Theater</Link></li>
                                    <li className="has-children">
                                        <Link to="#">Computer</Link>
                                        <ul className="is-hidden">
                                            <li className="go-back"><Link to="#"> </Link></li>
                                            <li><Link to="products.html">Laptop </Link></li>
                                            <li><Link to="products.html">Gaming PC</Link></li>
                                            <li><Link to="products.html">Monitors</Link></li>
                                            <li><Link to="products.html">Networking</Link></li>
                                            <li><Link to="products.html">Printers & Supplies</Link></li>
                                            <li><Link to="products.html">Accessories</Link></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">HOME APPLIANCES</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#0">All Electronics </Link></li>
                                    <li className="has-children"><Link to="#">Kitchen appliances</Link>
                                        <ul className="is-hidden">
                                            <li className="go-back"><Link to="#0"> </Link></li>
                                            <li><Link to="products.html">Rice Cookers</Link></li>
                                            <li><Link to="products.html">Mixer Juicer</Link></li>
                                            <li><Link to="products.html">Grinder</Link></li>
                                            <li><Link to="products.html">Blenders & Choppers</Link></li>
                                            <li><Link to="products.html">Microwave Oven</Link></li>
                                            <li><Link to="products.html">Food Processors</Link></li>
                                        </ul>
                                    </li>
                                    <li><Link to="products.html">Purifiers</Link></li>
                                    <li><Link to="products.html">Geysers</Link></li>
                                    <li><Link to="products.html">Gas Stove</Link></li>
                                    <li><Link to="products.html">Vacuum Cleaner</Link></li>
                                    <li><Link to="products.html">Sewing Machine</Link></li>
                                    <li><Link to="products.html">Heaters & Fans</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">SMALL DEVICES</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#0">All Electronics </Link></li>
                                    <li><Link to="products.html">Wifi Dongle</Link></li>
                                    <li><Link to="products.html">Router & Modem</Link></li>
                                    <li className="has-children"><Link to="#">Storage Devices</Link>
                                        <ul className="is-hidden">
                                            <li className="go-back"><Link to="#0"> </Link></li>
                                            <li><Link to="products.html">Cloud Storage</Link></li>
                                            <li><Link to="products.html">Hard Disk</Link></li>
                                            <li><Link to="products.html">SSD</Link></li>
                                            <li><Link to="products.html">Pen Drive</Link></li>
                                            <li><Link to="products.html">Memory card</Link></li>
                                            <li><Link to="products.html">Security Devices</Link></li>
                                        </ul>
                                    </li>
                                    <li><Link to="products.html">Office Supplies</Link></li>
                                    <li><Link to="products.html">Cut the Cable</Link></li>
                                    <li><Link to="products.html">Auto Electronics</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">PERSONAL CARE</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#0">All Electronics </Link></li>
                                    <li><Link to="products.html">Epilator</Link></li>
                                    <li><Link to="products.html">Hair Styler</Link></li>
                                    <li><Link to="products.html">Trimmer & Shaver</Link></li>
                                    <li><Link to="products.html">Health Care</Link></li>
                                    <li><Link to="products.html">cables</Link></li>
                                </ul>
                            </li>
                        </ul>
                        {/* <!-- .cd-secondary-dropdown -->  */}
                    </li>
                    {/* <!-- .has-children --> */}
                    <li className="has-children">
                        <Link to="#">Fashion Store</Link>
                        <ul className="cd-secondary-dropdown is-hidden">
                            <li className="go-back"><Link to="#">Menu</Link></li>
                            <li className="see-all"><Link to="products1.html">All Fashion Stores</Link></li>
                            <li className="has-children">
                                <Link to="#">GIRLS' CLOTHING</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Fashion Stores</Link></li>
                                    <li><Link to="products1.html">Ethnic wear </Link></li>
                                    <li><Link to="products1.html">Maternity wear</Link></li>
                                    <li><Link to="products1.html">inner & nightwear </Link></li>
                                    <li><Link to="products1.html">casual wear </Link></li>
                                    <li><Link to="products1.html">formal wear</Link></li>
                                    <li><Link to="products1.html">Sports wear</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">BOYS' CLOTHING</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Fashion Stores</Link></li>
                                    <li><Link to="products1.html">Jeans</Link></li>
                                    <li><Link to="products1.html">Casual wear</Link></li>
                                    <li><Link to="products1.html">Shorts</Link></li>
                                    <li><Link to="products1.html">T-Shirts & Polos</Link></li>
                                    <li><Link to="products1.html">Trousers & Chinos</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">JACKETS</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Fashion Stores</Link></li>
                                    <li><Link to="products1.html">Blazers</Link></li>
                                    <li><Link to="products1.html">Bomber jackets</Link></li>
                                    <li><Link to="products1.html">Denim Jackets</Link></li>
                                    <li><Link to="products1.html">Duffle Coats</Link></li>
                                    <li><Link to="products1.html">Leather Jackets</Link></li>
                                    <li><Link to="products1.html">Parkas</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">ACCESSORIES </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Fashion Stores</Link></li>
                                    <li><Link to="products1.html">Watches </Link></li>
                                    <li><Link to="products1.html">Eyewear </Link></li>
                                    <li><Link to="products1.html">Jewellery </Link></li>
                                    <li className="has-children">
                                        <Link to="#">Footwear </Link>
                                        <ul className="is-hidden">
                                            <li className="go-back"><Link to="#"> </Link></li>
                                            <li><Link to="products1.html">Ethnic</Link></li>
                                            <li><Link to="products1.html">Casual wear</Link></li>
                                            <li><Link to="products1.html">Sports Shoes</Link></li>
                                            <li><Link to="products1.html">Boots</Link></li>
                                        </ul>
                                    </li>
                                    <li><Link to="products1.html">Stoles & Scarves</Link></li>
                                    <li><Link to="products1.html">Handbags</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">BEAUTY</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Fashion Stores</Link></li>
                                    <li><Link to="products1.html">Perfumes & Deos</Link></li>
                                    <li><Link to="products1.html">Lipsticks & Nail Polish</Link></li>
                                    <li><Link to="products1.html">Beauty Gift Hampers</Link></li>
                                    <li><Link to="products1.html">Personal Grooming</Link></li>
                                    <li><Link to="products1.html">Travel bags</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="products1.html">PERSONAL CARE</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Fashion Stores</Link></li>
                                    <li><Link to="products1.html">Face Care</Link></li>
                                    <li><Link to="products1.html">Nail Care</Link></li>
                                    <li><Link to="products1.html">Hair Care</Link></li>
                                    <li><Link to="products1.html">Body Care</Link></li>
                                    <li><Link to="products1.html">Bath & Spa</Link></li>
                                </ul>
                            </li>
                        </ul>
                        {/* <!-- .cd-secondary-dropdown -->  */}
                    </li>
                    {/* <!-- .has-children --> */}
                    <li className="has-children">
                        <Link to="products2.html">Kids Fashion & Toys</Link>
                        <ul className="cd-secondary-dropdown is-hidden">
                            <li className="go-back"><Link to="#">Menu</Link></li>
                            <li className="see-all"><Link to="products2.html">All Kids Fashions</Link></li>
                            <li className="has-children">
                                <Link to="products2.html">KIDS CLOTHING</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Kids Fashions</Link></li>
                                    <li><Link to="products2.html">Ethnic wear </Link></li>
                                    <li><Link to="products2.html">inner & Sleepwear </Link></li>
                                    <li><Link to="products2.html">Dresses & Frocks </Link></li>
                                    <li><Link to="products2.html">Winter wear</Link></li>
                                    <li><Link to="products2.html">Diaper & Accessories</Link></li>
                                </ul>
                            </li>
                            <li className="has-children"><Link to="#">KIDS FASHION</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Kids Fashions</Link></li>
                                    <li><Link to="products2.html">Footwear</Link></li>
                                    <li><Link to="products2.html">Sunglasses </Link></li>
                                    <li><Link to="products2.html">School & Stationery</Link></li>
                                    <li><Link to="products2.html">Jewellery</Link></li>
                                    <li><Link to="products2.html">Hair bands & Clips</Link></li>
                                </ul>
                            </li>
                            <li className="has-children"><Link to="#">Baby Care</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Kids Fashions</Link></li>
                                    <li><Link to="products2.html">Lotions, Oil & Powder </Link></li>
                                    <li><Link to="products2.html">Soaps, Shampoo </Link></li>
                                    <li><Link to="products2.html">Bath Towels</Link></li>
                                    <li className="has-children">
                                        <Link to="#">Feeding</Link>
                                        <ul className="is-hidden">
                                            <li className="go-back"><Link to="#"> </Link></li>
                                            <li><Link to="products2.html">Baby Food </Link></li>
                                            <li><Link to="products2.html">Bottle Feeding </Link></li>
                                            <li><Link to="products2.html">Breast Feeding</Link></li>
                                        </ul>
                                    </li>
                                    <li><Link to="products2.html">Toddlers' Rooms</Link></li>
                                </ul>
                                {/* <!-- .cd-secondary-dropdown -->  */}
                            </li>
                            {/* <!-- .has-children -->								 */}
                            <li className="has-children"><Link to="#">TOYS & GAMES </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Kids Fashions</Link></li>
                                    <li><Link to="products2.html">Art & Crafts</Link></li>
                                    <li><Link to="products2.html">Educational Toys </Link></li>
                                    <li><Link to="products2.html">Baby Toys</Link></li>
                                    <li><Link to="products2.html">Outdoor Play </Link></li>
                                    <li><Link to="products2.html">Musical Instruments</Link></li>
                                </ul>
                            </li>
                            <li>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#">All Kids Fashions</Link></li>
                                    <li><Link to="products2.html">Toy Tips & Trends</Link></li>
                                    <li><Link to="products2.html">Preschool Toys</Link></li>
                                    <li><Link to="products2.html">Musical Instruments</Link></li>
                                    <li><Link to="products2.html">Bikes & Ride-Ons</Link></li>
                                    <li><Link to="products2.html">Video Games</Link></li>
                                    <li><Link to="products2.html">PC & Digital Gaming</Link></li>
                                </ul>
                            </li>
                        </ul>
                        {/* <!-- .cd-secondary-dropdown -->  */}
                    </li>
                    {/* <!-- .has-children -->  */}
                    <li className="has-children">
                        <Link to="#">Home, Furniture & Patio</Link>
                        <ul className="cd-secondary-dropdown is-hidden">
                            <li className="go-back"><Link to="#">Menu</Link></li>
                            <li className="see-all"><Link to="products3.html">All Products</Link></li>
                            <li className="has-children">
                                <Link to="#">Kitchen Uses</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products3.html">Dinner Sets </Link></li>
                                    <li><Link to="products3.html">Cookware & Bakeware </Link></li>
                                    <li><Link to="products3.html">Containers & Jars </Link></li>
                                    <li><Link to="products3.html">Kitchen Tools </Link></li>
                                    <li><Link to="products3.html">Food Storage</Link></li>
                                    <li><Link to="products3.html">Casseroles</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Furniture </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products3.html">Bedroom </Link></li>
                                    <li><Link to="products3.html">Dining Room </Link></li>
                                    <li><Link to="products3.html">Kids' Furniture </Link></li>
                                    <li><Link to="products3.html">Living Room</Link></li>
                                    <li><Link to="products3.html">Office</Link></li>
                                    <li><Link to="products3.html">Mattresses</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Home Decor </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products3.html">Lighting</Link></li>
                                    <li><Link to="products3.html">Painting</Link></li>
                                    <li><Link to="products3.html">Curtains & Blinds</Link></li>
                                    <li><Link to="products3.html">Patio Furniture</Link></li>
                                    <li><Link to="products3.html">Wardrobes & Cabinets</Link></li>
                                    <li><Link to="products3.html">Mattresses</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Gardening & Lawn </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"> </Link></li>
                                    <li><Link to="products3.html">Gardening </Link></li>
                                    <li><Link to="products3.html">Landscaping </Link></li>
                                    <li><Link to="products3.html">Sheds</Link></li>
                                    <li><Link to="products3.html">Outdoor Storage  </Link></li>
                                    <li><Link to="products3.html">Garden & Ideas </Link></li>
                                    <li><Link to="products3.html">Patio Tips</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Garage Storage</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products3.html">Baskets & Bins </Link></li>
                                    <li><Link to="products3.html">Garage Door Openers</Link></li>
                                    <li><Link to="products3.html">Free Standing Shelves </Link></li>
                                    <li><Link to="products3.html">Floor cleaning</Link></li>
                                    <li><Link to="products3.html">Tool Kits</Link></li>
                                </ul>
                            </li>
                        </ul>
                        {/* <!-- .cd-secondary-dropdown -->  */}
                    </li>
                    {/* <!-- .has-children -->   */}
                    <li className="has-children">
                        <Link to="#">Sports, Fitness & Outdoor</Link>
                        <ul className="cd-secondary-dropdown is-hidden">
                            <li className="go-back"><Link to="#">Menu</Link></li>
                            <li className="see-all"><Link to="products4.html">All Products</Link></li>
                            <li className="has-children">
                                <Link to="#">Single Sports </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products4.html">Bikes </Link></li>
                                    <li><Link to="products4.html">Fishing  </Link></li>
                                    <li><Link to="products4.html">Cycling </Link></li>
                                    <li><Link to="products4.html">Musical Instruments</Link></li>
                                    <li><Link to="products4.html">Archery </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Team Sports</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products4.html">Cricket </Link></li>
                                    <li><Link to="products4.html">Badminton </Link></li>
                                    <li><Link to="products4.html">Swimming Gear </Link></li>
                                    <li><Link to="products4.html">Sports Apparel </Link></li>
                                    <li><Link to="products4.html">Indoor games</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Fitness </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products4.html">Fitness Accessories </Link></li>
                                    <li><Link to="products4.html">Exercise Machines </Link></li>
                                    <li><Link to="products4.html">Ellipticals </Link></li>
                                    <li><Link to="products4.html">Home Gyms</Link></li>
                                    <li><Link to="products4.html">Exercise Bikes</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Camping </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products4.html"> Airbeds</Link></li>
                                    <li><Link to="products4.html">Tents </Link></li>
                                    <li><Link to="products4.html">Gazebo's & Shelters</Link></li>
                                    <li><Link to="products4.html">Coolers </Link></li>
                                    <li><Link to="products4.html">Canopies</Link></li>
                                    <li><Link to="products4.html">Sleeping Bags</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Camping Tools</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products4.html">Shooting </Link></li>
                                    <li><Link to="products4.html">Knives & Tools </Link></li>
                                    <li><Link to="products4.html">Optics & Binoculars </Link></li>
                                    <li><Link to="products4.html">Lights & Lanterns </Link></li>
                                    <li><Link to="products4.html">Hunting Clothing </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Other</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products4.html">Riding Gears & More </Link></li>
                                    <li><Link to="products4.html">Body Massagers </Link></li>
                                    <li><Link to="products4.html">Health Monitors </Link></li>
                                    <li><Link to="products4.html">Health Drinks </Link></li>
                                </ul>
                            </li>
                        </ul>
                        {/* <!-- .cd-secondary-dropdown -->  */}
                    </li>
                    {/* <!-- .has-children -->   */}
                    <li className="has-children">
                        <Link to="#">Grocery store</Link>
                        <ul className="cd-secondary-dropdown is-hidden">
                            <li className="go-back"><Link to="#">Menu</Link></li>
                            <li className="see-all"><Link to="products5.html">All Products</Link></li>
                            <li className="has-children">
                                <Link to="#">Veggies & Fruits </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products5.html">Vegetables </Link></li>
                                    <li><Link to="products5.html">Fruits </Link></li>
                                    <li><Link to="products5.html">Dry Fruits</Link></li>
                                    <li><Link to="products5.html">Snacks & Cookies </Link></li>
                                    <li><Link to="products5.html">Breakfast & Cereal</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Packet Food</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products5.html">Beverages </Link></li>
                                    <li><Link to="products5.html">Baking </Link></li>
                                    <li><Link to="products5.html">Emergency Food </Link></li>
                                    <li><Link to="products5.html">Candy & Gum </Link></li>
                                    <li><Link to="products5.html">Meals & Pasta </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Shop All Pets </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products5.html">Dogs </Link></li>
                                    <li><Link to="products5.html">Fish </Link></li>
                                    <li><Link to="products5.html">Cats</Link></li>
                                    <li><Link to="products5.html">Birds </Link></li>
                                    <li><Link to="products5.html">Pet Food </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Household Essentials </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products5.html">Laundry Room </Link></li>
                                    <li><Link to="products5.html">Paper & Plastic</Link></li>
                                    <li><Link to="products5.html">Pest Control </Link></li>
                                    <li><Link to="products5.html">Batteries </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Food Shops </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products5.html">Fresh Food</Link></li>
                                    <li><Link to="products5.html">Food Gifts </Link></li>
                                    <li><Link to="products5.html">Frozen Food </Link></li>
                                    <li><Link to="products5.html">Organic </Link></li>
                                    <li><Link to="products5.html">Gluten Free </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Tips </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products5.html">Pets Growth</Link></li>
                                    <li><Link to="products5.html">Recipes </Link></li>
                                    <li><Link to="products5.html">Snacks</Link></li>
                                    <li><Link to="products5.html">Nutrition</Link></li>
                                </ul>
                            </li>
                        </ul>
                        {/* <!-- .cd-secondary-dropdown -->  */}
                    </li>
                    {/* <!-- .has-children -->   */}
                    <li className="has-children">
                        <Link to="#">Photo, Gifts & Office Supplies</Link>
                        <ul className="cd-secondary-dropdown is-hidden">
                            <li className="go-back"><Link to="#">Menu</Link></li>
                            <li className="see-all"><Link to="products6.html">All Products</Link></li>
                            <li className="has-children">
                                <Link to="#">Trending Now </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products6.html">Best Priced</Link></li>
                                    <li><Link to="products6.html">Chocolates </Link></li>
                                    <li><Link to="products6.html">Gift Cards </Link></li>
                                    <li><Link to="products6.html">Fashion & Accessories </Link></li>
                                    <li><Link to="products6.html">Decorative Plants </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Photos </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products6.html">Shelf animation </Link></li>
                                    <li><Link to="products6.html">3D-rendered </Link></li>
                                    <li><Link to="products6.html">gift builder </Link></li>
                                    <li><Link to="products6.html">Frames</Link></li>
                                    <li><Link to="products6.html">Wall Decor</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Gifts </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products6.html">Personalized Gifts </Link></li>
                                    <li><Link to="products6.html">Flowers </Link></li>
                                    <li><Link to="products6.html">Cards & Toys</Link></li>
                                    <li><Link to="products6.html">Show pieces </Link></li>
                                    <li><Link to="products6.html">Photo Books</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Favourite Brands </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products6.html">Archies </Link></li>
                                    <li><Link to="products6.html">Jewel Fuel </Link></li>
                                    <li><Link to="products6.html">Ferns N Petals </Link></li>
                                    <li><Link to="products6.html">Happily Unmarried</Link></li>
                                    <li><Link to="products6.html">Chumbak</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Office</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products6.html">Calendars</Link></li>
                                    <li><Link to="products6.html">Mousepads</Link></li>
                                    <li><Link to="products6.html">Phone Cases</Link></li>
                                    <li><Link to="products6.html">Tablet & Laptop Cases</Link></li>
                                    <li><Link to="products6.html">Mounted Photos</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Combos </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products6.html">Chocolates </Link></li>
                                    <li><Link to="products6.html">Dry Fruits</Link></li>
                                    <li><Link to="products6.html">Sweets</Link></li>
                                    <li><Link to="products6.html">Snacks</Link></li>
                                    <li><Link to="products6.html">Cakes</Link></li>
                                </ul>
                            </li>
                        </ul>
                        {/* <!-- .cd-secondary-dropdown -->  */}
                    </li>
                    <li className="has-children">
                        <Link to="#">Health, Beauty & Pharmacy</Link>
                        <ul className="cd-secondary-dropdown is-hidden">
                            <li className="go-back"><Link to="#">Menu</Link></li>
                            <li className="see-all"><Link to="products7.html">All Products</Link></li>
                            <li className="has-children">
                                <Link to="#">Health</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products7.html">Home Health Care </Link></li>
                                    <li><Link to="products7.html">Sports Nutrition </Link></li>
                                    <li><Link to="products7.html">Vision </Link></li>
                                    <li><Link to="products7.html">Vitamins </Link></li>
                                    <li><Link to="products7.html">Diet & Nutrition </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Health Tips</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products7.html">Diet</Link></li>
                                    <li><Link to="products7.html">Exercise Tips  </Link></li>
                                    <li><Link to="products7.html">Vitamin Balance</Link></li>
                                    <li><Link to="products7.html">Health Insurance</Link></li>
                                    <li><Link to="products7.html">Funeral</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Beauty </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products7.html">Massage & Spa </Link></li>
                                    <li><Link to="products7.html">Face Wash</Link></li>
                                    <li><Link to="products7.html">Facial Cleanser</Link></li>
                                    <li><Link to="products7.html">Makeup </Link></li>
                                    <li><Link to="products7.html">Beauty Tips</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Pharmacy </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products7.html">Home Delivery </Link></li>
                                    <li><Link to="products7.html">History & Reports </Link></li>
                                    <li><Link to="products7.html">Transfer Prescriptions </Link></li>
                                    <li><Link to="products7.html">Health CheckUp</Link></li>
                                    <li><Link to="products7.html">Mobile App</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Pharmacy Center </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products7.html">Diabetes Shop </Link></li>
                                    <li><Link to="products7.html">Medicine Cabinet </Link></li>
                                    <li><Link to="products7.html">Vitamin Selector</Link></li>
                                    <li><Link to="products7.html">Pharmacy Help</Link></li>
                                </ul>
                            </li>
                        </ul>
                        {/* <!-- .cd-secondary-dropdown -->  */}
                    </li>
                    <li className="has-children">
                        <Link to="#">Automotive</Link>
                        <ul className="cd-secondary-dropdown is-hidden">
                            <li className="go-back"><Link to="#">Menu</Link></li>
                            <li className="see-all"><Link to="products8.html">All Products</Link></li>
                            <li className="has-children">
                                <Link to="#">All Motors </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products8.html">Bikes </Link></li>
                                    <li><Link to="products8.html">Yachts </Link></li>
                                    <li><Link to="products8.html">Scooters </Link></li>
                                    <li><Link to="products8.html">Autos</Link></li>
                                    <li><Link to="products8.html">Bus</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Accessories </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products8.html">Vehicle Electronics</Link></li>
                                    <li><Link to="products8.html">Stereos & Monitors</Link></li>
                                    <li><Link to="products8.html">Bluetooth Devices</Link></li>
                                    <li><Link to="products8.html">GPS Navigation</Link></li>
                                    <li><Link to="products8.html">Speakers & Tweeters</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Safety & Security </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products8.html">Anti-Theft Devices </Link></li>
                                    <li><Link to="products8.html">Helmets</Link></li>
                                    <li><Link to="products8.html">Sensors</Link></li>
                                    <li><Link to="products8.html">Auto Repair Tools </Link></li>
                                    <li><Link to="products8.html">Antifreeze & Coolants </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Car Interiors</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products8.html">Stereos </Link></li>
                                    <li><Link to="products8.html">Floor Mats </Link></li>
                                    <li><Link to="products8.html">Seat Covers</Link></li>
                                    <li><Link to="products8.html">Chargers </Link></li>
                                    <li><Link to="products8.html">Audio Finder </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Exterior Accessories </Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products8.html">Wheel covers </Link></li>
                                    <li><Link to="products8.html">Car Lighting </Link></li>
                                    <li><Link to="products8.html">Polish & Waxes</Link></li>
                                    <li><Link to="products8.html">Cargo Management</Link></li>
                                    <li><Link to="products8.html">Car Decoration </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Car Care</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products8.html">Auto Tips & Advice </Link></li>
                                    <li><Link to="products8.html">Car Washes & Cleaners </Link></li>
                                    <li><Link to="products8.html">Car Wax & Polish</Link></li>
                                    <li><Link to="products8.html">Cleaning Tools</Link></li>
                                    <li><Link to="products8.html">Detailing Kits </Link></li>
                                </ul>
                            </li>
                        </ul>
                        {/* <!-- .cd-secondary-dropdown -->  */}
                    </li>
                    <li className="has-children">
                        <Link to="#">Books, Music & Movies</Link>
                        <ul className="cd-secondary-dropdown is-hidden">
                            <li className="go-back"><Link to="#">Menu</Link></li>
                            <li className="see-all"><Link to="products9.html">All Products</Link></li>
                            <li className="has-children">
                                <Link to="#">Books</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li className="has-children"><Link to="#">Exam books </Link>
                                        <ul className="is-hidden">
                                            <li className="go-back"><Link to="#"> </Link></li>
                                            <li><Link to="products9.html">CAT/MAT/XAT</Link></li>
                                            <li><Link to="products9.html">Civil Services</Link></li>
                                            <li><Link to="products9.html">AFCAT</Link></li>
                                            <li><Link to="products9.html">New Releases</Link></li>
                                        </ul>
                                    </li>
                                    <li><Link to="products9.html">Academic Text </Link></li>
                                    <li><Link to="products9.html">Romance Books </Link></li>
                                    <li><Link to="products9.html">Journals </Link></li>
                                    <li><Link to="products9.html">Children's & Teen Books </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Music</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products9.html">New Releases </Link></li>
                                    <li><Link to="products9.html">Country Music </Link></li>
                                    <li><Link to="products9.html">Musical Instruments </Link></li>
                                    <li><Link to="products9.html">Collections</Link></li>
                                    <li><Link to="products9.html">Boxed Sets </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Music Combo</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products9.html">Pop </Link></li>
                                    <li><Link to="products9.html">Preorders </Link></li>
                                    <li><Link to="products9.html">Album Songs</Link></li>
                                    <li><Link to="products9.html">Top 50 CDs </Link></li>
                                    <li><Link to="products9.html">Music DVDs </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Movies</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products9.html">New Releases </Link></li>
                                    <li><Link to="products9.html">Children & Family </Link></li>
                                    <li><Link to="products9.html">Action</Link></li>
                                    <li><Link to="products9.html">Classic Movies </Link></li>
                                    <li><Link to="products9.html">Bollywood Movies </Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">Movies Combo</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products9.html">Hollywood Movies </Link></li>
                                    <li><Link to="products9.html">Digital Movies </Link></li>
                                    <li><Link to="products9.html">Boxed Sets</Link></li>
                                    <li><Link to="products9.html">Animated</Link></li>
                                    <li><Link to="products9.html">Adventure</Link></li>
                                </ul>
                            </li>
                            <li className="has-children">
                                <Link to="#">TV Shows</Link>
                                <ul className="is-hidden">
                                    <li className="go-back"><Link to="#"></Link></li>
                                    <li><Link to="products9.html">Serials</Link></li>
                                    <li><Link to="products9.html">Best Programs</Link></li>
                                    <li><Link to="products9.html">Celebrations</Link></li>
                                    <li><Link to="products9.html">Top Shows</Link></li>
                                </ul>
                            </li>
                        </ul>
                        {/* <!-- .cd-secondary-dropdown -->  */}
                    </li>
                    <li><Link to="/sitemap">Full Site Directory </Link></li>
                </ul>
                {/* <!-- .cd-dropdown-content --> */}
            </nav>
        </>
    );
};

export default Category;