import React from 'react'
import { Link } from 'react-router-dom';
import SiderBar from '../../Components/Navbar/SiderBar';
import TopBar from '../../Components/Navbar/TopBar';
import Footer from '../../Components/Footer/Footer';


const Chart = () => {


    return (
        <>
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

                            <div className="container-fluid">

                                {/* <!-- Page Heading --> */}
                                <h1 className="h3 mb-2 text-gray-800">Charts</h1>
                                <p className="mb-4">Chart.js is a third party plugin that is used to generate the charts in this theme.
                                    The charts below have been customized - for further customization options, please visit the <a
                                        target="_blank" href="https://www.chartjs.org/docs/latest/">official Chart.js
                                        documentation</a>.</p>

                                {/* <!-- Content Row --> */}
                                <div className="row">

                                    <div className="col-xl-8 col-lg-7">

                                        {/* <!-- Area Chart --> */}
                                        <div className="card shadow mb-4">
                                            <div className="card-header py-3">
                                                <h6 className="m-0 font-weight-bold text-primary">Area Chart</h6>
                                            </div>
                                            <div className="card-body">
                                                <div className="chart-area">
                                                    <canvas id="myAreaChart"></canvas>
                                                </div>
                                                <hr />
                                                Styling for the area chart can be found in the
                                                <code>/js/demo/chart-area-demo.js</code> file.
                                            </div>
                                        </div>

                                        {/* <!-- Bar Chart --> */}
                                        <div className="card shadow mb-4">
                                            <div className="card-header py-3">
                                                <h6 className="m-0 font-weight-bold text-primary">Bar Chart</h6>
                                            </div>
                                            <div className="card-body">
                                                <div className="chart-bar">
                                                    <canvas id="myBarChart"></canvas>
                                                </div>
                                                <hr />
                                                Styling for the bar chart can be found in the
                                                <code>/js/demo/chart-bar-demo.js</code> file.
                                            </div>
                                        </div>

                                    </div>

                                    {/* <!-- Donut Chart --> */}
                                    <div className="col-xl-4 col-lg-5">
                                        <div className="card shadow mb-4">
                                            {/* <!-- Card Header - Dropdown --> */}
                                            <div className="card-header py-3">
                                                <h6 className="m-0 font-weight-bold text-primary">Donut Chart</h6>
                                            </div>
                                            {/* <!-- Card Body --> */}
                                            <div className="card-body">
                                                <div className="chart-pie pt-4">
                                                    <canvas id="myPieChart"></canvas>
                                                </div>
                                                <hr />
                                                Styling for the donut chart can be found in the
                                                <code>/js/demo/chart-pie-demo.js</code> file.
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
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
        </>
    )
}

export default Chart;