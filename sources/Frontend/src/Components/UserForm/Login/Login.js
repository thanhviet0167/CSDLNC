import React, { useState } from "react";
import { Link, Redirect } from 'react-router-dom';
import Narbar from "../../Layout/Navbar/Navbar";
import Siderbar from "../../Layout/Sidebar/Sidebar";
import Category from "../../Layout/Sidebar/Category";

import Footer from "../../Layout/Footer/Footer";
import Introduce from "../../Layout/Footer/Introduce";
import Subcribe from "../../Layout/Footer/Subcribe";

const Login = ({ LoginHandler, user }) => {
  const [details, setDetails] = useState({ email: "", password: "" });

  const submitHandler = e => {
    e.preventDefault();
    LoginHandler(details);
  }
  const style_error = {
    color: 'red'
  }
  if (user.email.length <= 0) {
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
        
        <div className="login-page">
          <div className="container">
            <h3 className="w3ls-title w3ls-title1">Login to your account</h3>
            <div className="login-body">
              <form action="#" method="post">
                <input type="text" className="user" name="email" placeholder="Enter your email" required="" />
                <input type="password" name="password" className="lock" placeholder="Password" required="" />
                <input type="submit" value="Login" />
                <div className="forgot-grid">
                  <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>Remember me</label>
                  <div className="forgot">
                    <Link to="#">Forgot Password?</Link>
                  </div>
                  <div className="clearfix"> </div>
                </div>
              </form>
            </div>
            <h6> Not a Member? <Link to="/sign-up">Sign Up Now »</Link> </h6>
            <div className="login-page-bottom social-icons">
              <h5>Recover your social account</h5>
              <ul>
                <li><Link to="#" className="fa fa-facebook icon facebook"> </Link></li>
                <li><Link to="#" className="fa fa-twitter icon twitter"> </Link></li>
                <li><Link to="#" className="fa fa-google-plus icon googleplus"> </Link></li>
                <li><Link to="#" className="fa fa-dribbble icon dribbble"> </Link></li>
                <li><Link to="#" className="fa fa-rss icon rss"> </Link></li>
              </ul>
            </div>
          </div>
        </div>

      
        {/* <!-- //deals --> 
	<!-- footer-top --> */}
        <Introduce></Introduce>
        {/* <!-- //footer-top --> 
	<!-- subscribe --> */}
        <Subcribe></Subcribe>
        <Footer></Footer>
      </>
    );
  }
  else {
    return <Redirect to="/" />
  }

};

export default Login;







// <div className="bg-gradient-primary">
//         <div className="container">
//           <div className="row justify-content-center">
//             <div className="col-xl-10 col-lg-12 col-md-9">
//               <div className="card o-hidden border-0 shadow-lg my-5">
//                 <div className="card-body p-0">
//                   <div className="row">
//                     <div className="col-lg-6 d-none d-lg-block bg-login-image"></div>
//                     <div className="col-lg-6">
//                       <div className="p-5">
//                         <div className="text-center">
//                           <h1 className="h4 text-gray-900 mb-4">Welcome Back!</h1>
//                         </div>
//                         <form className="user" onSubmit={submitHandler}>
//                           <div className="form-group">
//                             <input type="email" className="form-control form-control-user"
//                               id="email" name="email" aria-describedby="emailHelp"
//                               onChange={e => setDetails({ ...details, email: e.target.value })} value={details.email}
//                               placeholder="Enter Email Address..." />
//                           </div>
//                           <div className="form-group">
//                             <input type="password" className="form-control form-control-user"
//                               onChange={e => setDetails({ ...details, password: e.target.value })} value={details.password}
//                               id="password" name="password" placeholder="Password" />
//                           </div>
//                           <div className="form-group">
//                             <div className="custom-control custom-checkbox small">
//                               <input type="checkbox" className="custom-control-input" id="customCheck" />
//                               <label className="custom-control-label" for="customCheck">Remember
//                                 Me</label>
//                             </div>
//                           </div>
//                           <button className="btn btn-primary btn-user btn-block">
//                             Login
//                           </button>
//                           <hr />
//                           <Link to="/" className="btn btn-google btn-user btn-block">
//                             <i className="fab fa-google fa-fw"></i> Login with Google
//                           </Link>
//                           <Link to="/" className="btn btn-facebook btn-user btn-block">
//                             <i className="fab fa-facebook-f fa-fw"></i> Login with Facebook
//                           </Link>
//                         </form>
//                         <hr />
//                         <div className="text-center">
//                           <Link className="small" to="/forgot-password">Forgot Password?</Link>
//                         </div>
//                         <div className="text-center">
//                           <Link className="small" to="/sign-up">Create an Account!</Link>
//                         </div>
//                         <div className="text-center">
//                           <Link className="small" to="/">Back home</Link>
//                         </div>
//                         <div className="text-center">
//                           <p id="check_login" style={style_error}></p>
//                         </div>
//                       </div>
//                     </div>
//                   </div>
//                 </div>
//               </div>
//             </div>
//           </div>
//         </div>
//         <script src="vendor/jquery/jquery.min.js"></script>
//         <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
//         <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
//         <script src="js/sb-admin-2.min.js"></script>
//       </div>