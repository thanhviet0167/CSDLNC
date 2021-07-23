import React from 'react'
import { Link } from 'react-router-dom';
import Footer from '../../Components/Footer/Footer';
import SiderBar from '../../Components/Navbar/SiderBar';
import TopBar from '../../Components/Navbar/TopBar';
import Content from './Content';


const Home = () => {

    return (
        <div className="Home">
            <body id="page-top">

                { /* <!-- Page Wrapper --> */}
                <div id="wrapper">

                    { /* <!-- Sidebar --> */}
                    <SiderBar></SiderBar>
                    { /* <!-- End of Sidebar --> */}

                    { /* <!-- Content Wrapper --> */}
                    <div id="content-wrapper" className="d-flex flex-column">

                        { /* <!-- Main Content --> */}
                        <div id="content">

                            { /* <!-- Topbar --> */}
                            
                            <TopBar></TopBar>

                            { /* <!-- End of Topbar --> */}

                            { /* <!-- Begin Page Content --> */}

                            <Content></Content>
                            
                            { /* <!-- /.container-fluid --> */}

                        </div>
                        { /* <!-- End of Main Content --> */}

                        { /* <!-- Footer --> */}
                        <Footer />
                        { /* <!-- End of Footer --> */}

                    </div>
                    { /* <!-- End of Content Wrapper --> */}

                </div>
                { /* <!-- End of Page Wrapper --> */}

                { /* <!-- Scroll to Top Button--> */}
                <Link className="scroll-to-top rounded" to="#page-top">
                    <i className="fas fa-angle-up"></i>
                </Link>

                { /* <!-- Logout Modal--> */}
                <div className="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                                <button className="close" type="button" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <div className="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                            <div className="modal-footer">
                                <button className="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                <Link className="btn btn-primary" to="login.html">Logout</Link>
                            </div>
                        </div>
                    </div>
                </div>


            </body>
        </div>
    )
};

export default Home;