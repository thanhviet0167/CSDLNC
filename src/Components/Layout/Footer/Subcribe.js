import React from "react";
import { Link } from 'react-router-dom';

const Subcribe = () => {


    return (

        <div className="subscribe">
            <div className="container">
                <div className="col-md-6 social-icons w3-agile-icons">
                    <h4>Keep in touch</h4>
                    <ul>
                        <li><Link to="#" className="fa fa-facebook icon facebook"> </Link></li>
                        <li><Link to="#" className="fa fa-twitter icon twitter"> </Link></li>
                        <li><Link to="#" className="fa fa-google-plus icon googleplus"> </Link></li>
                        <li><Link to="#" className="fa fa-dribbble icon dribbble"> </Link></li>
                        <li><Link to="#" className="fa fa-rss icon rss"> </Link></li>
                    </ul>
                    <ul className="apps">
                        <li><h4>Download Our app : </h4> </li>
                        <li><Link to="#" className="fa fa-apple"></Link></li>
                        <li><Link to="#" className="fa fa-windows"></Link></li>
                        <li><Link to="#" className="fa fa-android"></Link></li>
                    </ul>
                </div>
                <div className="col-md-6 subscribe-right">
                    <h4>Sign up for email and get 25%off!</h4>
                    <form action="#" method="post">
                        <input type="text" name="email" placeholder="Enter your Email..." required="" />
                        <input type="submit" value="Subscribe" />
                    </form>
                    <div className="clearfix"> </div>
                </div>
                <div className="clearfix"> </div>
            </div>
        </div>
    );
};


export default Subcribe;