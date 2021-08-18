import React,{useState} from "react";
import { Link } from 'react-router-dom';
import Narbar from "../../Layout/Navbar/Navbar";
import Siderbar from "../../Layout/Sidebar/Sidebar";
import Category from "../../Layout/Sidebar/Category";

import Footer from "../../Layout/Footer/Footer";
import Introduce from "../../Layout/Footer/Introduce";
import Subcribe from "../../Layout/Footer/Subcribe";

const Sign_up = ({handle_signup}) => {

  const [form,setForm] = useState({
    username:'',
    password:'',
    sdtDangKy:'1234324254'
  });

  const handle_submit = (e)=>{
    console.log(form)
    e.preventDefault();
    handle_signup(form);
  }

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
          <h3 className="w3ls-title w3ls-title1">Create your account</h3>
          <div className="login-body">
            <form onSubmit = {handle_submit}>
              <input type="text" className="user" name="name" placeholder="Enter your Name" required="" />
              <input type="text" className="user" onChange={e => setForm({ ...form, username: e.target.value })} value={form.username} name="username" placeholder="Enter your email" required="" />
              <input type="password" className="lock" className="lock" onChange={e => setForm({ ...form, password: e.target.value })} value={form.password}
                               id="password" name="password" placeholder="Password" required="" />
              <input type="submit" value="Sign Up" />
              <div className="forgot-grid">
                <label className="checkbox"><input type="checkbox" name="checkbox" /><i></i>Remember me</label>
                <div className="forgot">
                  <Link to="#">Forgot Password?</Link>
                </div>
                <div className="clearfix"> </div>
              </div>
              <p id="error_signup" style = {{color:"red"}}></p>
            </form>
          </div>
          <h6>Already have an account? <Link to="/login">Login Now »</Link> </h6>
        </div>
      </div>
        <Introduce></Introduce>
        {/* <!-- //footer-top --> 
	<!-- subscribe --> */}
        <Subcribe></Subcribe>
        <Footer></Footer>
    </>
  );
};

export default Sign_up;







