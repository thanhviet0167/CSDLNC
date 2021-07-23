import React, { useState } from "react";
import { Link, Redirect } from 'react-router-dom';

const Login = ({ LoginHandler, user }) => {
    const style_error = {
        color: 'red'
    }
    const [details, setDetails] = useState({ email: "", password: "" });

    const submitHandler = e => {
        e.preventDefault();
        LoginHandler(details);
    }
    return (
        <>
            <div className="bg-gradient-primary">
                <div className="container">
                    <div className="row justify-content-center">
                        <div className="col-xl-10 col-lg-12 col-md-9">
                            <div className="card o-hidden border-0 shadow-lg my-5">
                                <div className="card-body p-0">
                                    <div className="row">
                                        <div className="col-lg-6 d-none d-lg-block bg-login-image"></div>
                                        <div className="col-lg-6">
                                            <div className="p-5">
                                                <div className="text-center">
                                                    <h1 className="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                                </div>
                                                <form className="user" onSubmit={submitHandler}>
                                                    <div className="form-group">
                                                        <input type="email" className="form-control form-control-user"
                                                            id="email" name="email" aria-describedby="emailHelp"
                                                            onChange={e => setDetails({ ...details, email: e.target.value })} value={details.email}
                                                            placeholder="Enter Email Address..." />
                                                    </div>
                                                    <div className="form-group">
                                                        <input type="password" className="form-control form-control-user"
                                                            onChange={e => setDetails({ ...details, password: e.target.value })} value={details.password}
                                                            id="password" name="password" placeholder="Password" />
                                                    </div>
                                                    <div className="form-group">
                                                        <div className="custom-control custom-checkbox small">
                                                            <input type="checkbox" className="custom-control-input" id="customCheck" />
                                                            <label className="custom-control-label" for="customCheck">Remember
                                                                Me</label>
                                                        </div>
                                                    </div>
                                                    <button className="btn btn-primary btn-user btn-block">
                                                        Login
                                                    </button>
                                                    <hr />
                                                    <Link to="/" className="btn btn-google btn-user btn-block">
                                                        <i className="fab fa-google fa-fw"></i> Login with Google
                                                    </Link>
                                                    <Link to="/" className="btn btn-facebook btn-user btn-block">
                                                        <i className="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                                    </Link>
                                                </form>
                                                <hr />
                                                <div className="text-center">
                                                    <Link className="small" to="/forgot-password">Forgot Password?</Link>
                                                </div>
                                                <div className="text-center">
                                                    <Link className="small" to="/sign-up">Create an Account!</Link>
                                                </div>
                                                <div className="text-center">
                                                    <Link className="small" to="/">Back home</Link>
                                                </div>
                                                <div className="text-center">
                                                    <p id="check_login" style={style_error}></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <script src="vendor/jquery/jquery.min.js"></script>
                <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
                <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
                <script src="js/sb-admin-2.min.js"></script>
            </div>
        </>
    )
}

export default Login;