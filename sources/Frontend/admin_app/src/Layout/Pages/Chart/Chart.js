import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import SiderBar from '../../Components/Navbar/SiderBar';
import TopBar from '../../Components/Navbar/TopBar';
import Footer from '../../Components/Footer/Footer';
import { Bar, Line, Pie, Doughnut, Radar } from 'react-chartjs-2'


const Chart = ({ }) => {


    const handle_getToken = () => {
        var data = {
            "username": "Abbie1955",
            "password": "Travis1995"
        }

        fetch('http://localhost:8080/nacotiki/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(res => res.json())
            .then(json => {

                if (json.id_token.length) {

                    localStorage.setItem('token', json.id_token);

                }


            });

    }


    const [month, setMonth] = useState({ value_from: "1", value_to: "1" });

    const handle_setMonth_from = () => {
        setMonth({
            ...month,
            value_from: document.getElementById("month_from").value
        })
        console.log("Hello" + document.getElementById("month_from").value)
    }
    const handle_setYear_from = () => {
        setYear({
            ...year,
            value_from: document.getElementById("year_from").value
        })
        console.log("Hello" + document.getElementById("year_from").value)
    }

    const handle_setMonth_to = () => {
        setMonth({
            ...month,
            value_to: document.getElementById("month_to").value
        })
        console.log("Hello" + document.getElementById("month_to").value)
    }
    const handle_setYear_to = () => {
        setYear({
            ...year,
            value_to: document.getElementById("year_to").value
        })
        console.log("Hello" + document.getElementById("year_to").value)
    }


    const handle_setOption = () => {
        setOption({
            value: document.getElementById('option').value
        })
    }

    const [year, setYear] = useState({ value_from: "2011", value_to: "2011" });
    const [option, setOption] = useState({ value: "store" });
    const [status, setStatus] = useState({ value: 1 })

    const [data, setData] = useState({
        from: '',
        to: '',
        option: ''
    })

    const getData = () => {
        setData({
            from: month['value_from'] + '/' + year['value_from'],
            to: month['value_to'] + '/' + year['value_to'],
            option: option['value']
        })

    }

    const [data_chart, setDataChart] = useState({
        label: [],
        list_data: []
    })

    const [data_total, setDataTotal] = useState({
        label: ['Thành công','Không thành công'],
        list_data: [0,0], 
        year: ''
    })

    const handle_Total = () => {
        handle_getToken()
        var url = 'http://localhost:8080/nacotiki/api/admin/statistics/success-order?year=' + document.getElementById('year').value
        fetch(url, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Bearer ' + localStorage.getItem('token')
                    }
                })
                    .then(res => res.json())
                    .then(json => {

                        console.log(json)
                        var total = json['soLuongDonHang']
                        var success = json['soLuongDonHangThanhCong']
                        var list = []
                        list.push(success)
                        list.push(total-success)
                        setDataTotal({
                            year: document.getElementById('year').value,
                            list_data: list
                        })
                        console.log(data_total['label'])

                    });

    }

    const handle_getDataChart_Payment = (json) => {

        // localStorage.setItem('label',JSON.stringify([]));
        // localStorage.setItem('data_label',JSON.stringify([]));
        if (json['congThanhToan']) {
            var _label = [], _list_data = []
            for (var i = 0; i < json['congThanhToan'].length; i++) {

                _label.push(json['congThanhToan'][i]['maCongThanhToan'])
                _list_data.push(json['congThanhToan'][i]['soLuong'])
            }
            console.log(_label)
            console.log(_list_data)
            setDataChart({
                label: _label,
                list_data: _list_data
            })
            localStorage.setItem('label', JSON.stringify(_label));
            localStorage.setItem('data_label', JSON.stringify(_list_data));
        }
        else {
            localStorage.setItem('label', JSON.stringify([]));
            localStorage.setItem('data_label', JSON.stringify([]));
        }
    }

    const handle_getDataChart_Store = (json) => {


        if (json['nhaCungCap']) {
            var _label = [], _list_data = []
            for (var i = 0; i < json['nhaCungCap'].length; i++) {

                _label.push(json['nhaCungCap'][i]['maNhaCungCap'])
                _list_data.push(json['nhaCungCap'][i]['duLieu'])
            }
            console.log(_label)
            console.log(_list_data)
            setDataChart({
                label: _label,
                list_data: _list_data
            })
            localStorage.setItem('label', JSON.stringify(_label));
            localStorage.setItem('data_label', JSON.stringify(_list_data));
        }
        else {
            localStorage.setItem('label', JSON.stringify([]));
            localStorage.setItem('data_label', JSON.stringify([]));
        }
    }

    const handle_getDataChart_Transport = (json) => {


        if (json['hinhThucVanChuyen']) {
            var _label = [], _list_data = []
            for (var i = 0; i < json['hinhThucVanChuyen'].length; i++) {

                _label.push(json['hinhThucVanChuyen'][i]['tenHinhThucVanChuyen'])
                _list_data.push(json['hinhThucVanChuyen'][i]['soLuong'])
            }

            setDataChart({
                label: _label,
                list_data: _list_data
            })
            localStorage.setItem('label', JSON.stringify(_label));
            localStorage.setItem('data_label', JSON.stringify(_list_data));
        }
        else {
            localStorage.setItem('label', JSON.stringify([]));
            localStorage.setItem('data_label', JSON.stringify([]));
        }
        console.log(JSON.parse(localStorage.getItem('label')))
        console.log(JSON.parse(localStorage.getItem('data_label')))
    }

    // http://localhost:8080/nacotiki/api/admin/statistics/payment-method?from=01/2016&to=08/2020

    useEffect(() => {
        function handle_change() {
            handle_getToken();
            if (data['from'] == '') {
                localStorage.setItem('label', JSON.stringify([]));
                localStorage.setItem('data_label', JSON.stringify([]));
            }

            if (data['option'] == 'payment') {
                fetch('http://localhost:8080/nacotiki/api/admin/statistics/payment-method?from=' + data['from'] + '&' + 'to=' + data['to'], {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Bearer ' + localStorage.getItem('token')
                    }
                })
                    .then(res => res.json())
                    .then(json => {

                        console.log(json)
                        handle_getDataChart_Payment(json)



                    });
            }
            if (data['option'] == 'store' && data['from'] != '') {
                fetch('http://localhost:8080/nacotiki/api/admin/statistics/store?from=' + data['from'] + '&' + 'to=' + data['to'] + '&type=1', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Bearer ' + localStorage.getItem('token')
                    }
                })
                    .then(res => res.json())
                    .then(json => {

                        console.log(json)
                        handle_getDataChart_Store(json)
                        


                    });
            }
            if (data['option'] == 'transport') {
                /// http://localhost:8080/nacotiki/api/admin/statistics/transport-method?from=01/2016&to=08/2020
                fetch('http://localhost:8080/nacotiki/api/admin/statistics/transport-method?from=' + data['from'] + '&' + 'to=' + data['to'] + '&type=1', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Bearer ' + localStorage.getItem('token')
                    }
                })
                    .then(res => res.json())
                    .then(json => {

                        console.log(json)
                        handle_getDataChart_Transport(json)
                    });
            }

        }
        handle_change()
        //    handle_change()

    }, [data])

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
                                <h1 className="h3 mb-2 text-gray-800">Naco Tiki Charts</h1>
                                <p className="mb-4">Chart.js is a third party plugin that is used to generate the charts in this theme.
                                    The charts below have been customized - for further customization options, please visit the <a
                                        target="_blank" href="https://www.chartjs.org/docs/latest/">official Chart.js
                                        documentation</a>.</p>

                                {/* <!-- Content Row --> */}
                                <div className="row" style={{ marginLeft: "0.5%", marginBottom: "5%" }}>
                                    <p style={{ marginRight: "1.5%", paddingTop: "1%" }} >From</p>
                                    <select class="form-select" id="month_from" onChange={() => handle_setMonth_from()} aria-label="Month">
                                        <option value="1" selected>January</option>
                                        <option value="2">February</option>
                                        <option value="3">March</option>
                                        <option value="4">April</option>
                                        <option value="5">May</option>
                                        <option value="6">June</option>
                                        <option value="7">July</option>
                                        <option value="8">August</option>
                                        <option value="9">September</option>
                                        <option value="10">October</option>
                                        <option value="11">November</option>
                                        <option value="12">December</option>


                                    </select>

                                    <select class="form-select" id="year_from" onChange={() => handle_setYear_from()} style={{ marginLeft: "1.5%" }} aria-label="Year">
                                        <option value="2011" selected>2011</option>
                                        <option value="2012">2012</option>
                                        <option value="2013">2013</option>
                                        <option value="2014">2014</option>
                                        <option value="2015">2015</option>
                                        <option value="2016">2016</option>
                                        <option value="2017">2017</option>
                                        <option value="2018">2018</option>
                                        <option value="2019">2019</option>
                                        <option value="2020">2020</option>
                                        <option value="2021">2021</option>

                                    </select>

                                    <p style={{ marginRight: "1.5%", marginLeft: "3%", paddingTop: "1%" }}>To</p>
                                    <select class="form-select" id="month_to" onChange={() => handle_setMonth_to()} aria-label="Month">
                                        <option value="1" selected>January</option>
                                        <option value="2">February</option>
                                        <option value="3">March</option>
                                        <option value="4">April</option>
                                        <option value="5">May</option>
                                        <option value="6">June</option>
                                        <option value="7">July</option>
                                        <option value="8">August</option>
                                        <option value="9">September</option>
                                        <option value="10">October</option>
                                        <option value="11">November</option>
                                        <option value="12">December</option>


                                    </select>

                                    <select class="form-select" id="year_to" onChange={() => handle_setYear_to()} style={{ marginLeft: "1.5%" }} aria-label="Year">
                                        <option value="2011" selected>2011</option>
                                        <option value="2012">2012</option>
                                        <option value="2013">2013</option>
                                        <option value="2014">2014</option>
                                        <option value="2015">2015</option>
                                        <option value="2016">2016</option>
                                        <option value="2017">2017</option>
                                        <option value="2018">2018</option>
                                        <option value="2019">2019</option>
                                        <option value="2020">2020</option>
                                        <option value="2021">2021</option>

                                    </select>

                                    <select class="form-select" id="option"
                                        onChange={() => handle_setOption()} style={{ marginLeft: "1.5%" }} aria-label="Option">
                                        <option selected value="store">Store</option>
                                        <option value="transport">Transport</option>
                                        <option value="payment">Paymen</option>

                                    </select>

                                    <button type="button" style={{ marginLeft: "1.5%" }}
                                        onClick={() => getData()} class="btn btn-primary">Thống kê</button>

                                </div>
                                <div className="row" style={{ marginLeft: "4.5%" }}>
                                <select class="form-select" id="year"  style={{ marginLeft: "1.5%" }} aria-label="Year">
                                        <option value="2011" selected>2011</option>
                                        <option value="2012">2012</option>
                                        <option value="2013">2013</option>
                                        <option value="2014">2014</option>
                                        <option value="2015">2015</option>
                                        <option value="2016">2016</option>
                                        <option value="2017">2017</option>
                                        <option value="2018">2018</option>
                                        <option value="2019">2019</option>
                                        <option value="2020">2020</option>
                                        <option value="2021">2021</option>

                                    </select>
                                    <button type="button" onClick = {()=> handle_Total()} style={{ marginLeft: "1.5%" }}
                                         class="btn btn-primary">Thống kê đơn hàng</button>
                                </div>

                                <hr />
                                <hr />
                                <hr />

                                <div className="row">
                                <h3 style={{ marginLeft: "45%", color: 'goldenrod' }}>
                                        Pie Chart
                                    </h3>
                                    {data_total['list_data'][0] > 0 ?<Pie
                                        data={{
                                            labels: ["Thành công", "Không thành công"],
                                            datasets: [{
                                                label: 'values of' + data['option'],
                                                data: data_total['list_data'],
                                                backgroundColor: [
                                                    
                                                    'rgba(54, 162, 235, 0.2)',
                                                    'rgba(255, 99, 132, 0.2)'
                                                    
                                                ],
                                                borderColor: [
                                                    
                                                    'rgba(54, 162, 235, 1)',
                                                    'rgba(255, 99, 132, 1)'
                                                    
                                                ],
                                                borderWidth: 1
                                            }]
                                        }}
                                        height={50}
                                        width={100}
                                    /> : <p></p>}
                                    
                                    <hr />
                                    <p>

                                    </p>
                                    {data_total['list_data'][0] > 0 ? <h4 style={{marginLeft:"25%", color:'blueviolet'}}>Thống kê số lượng giao hàng năm {data_total['year']}</h4>
                                    : <p></p>}
                                    

                                </div>

                                <hr />
                                <hr />


                                <div className="row">
                                <h3 style={{ marginLeft: "45%", color: 'goldenrod' }}>
                                        Bar Chart
                                    </h3>
                                    <Bar
                                        data={{
                                            labels: data_chart['label'],
                                            datasets: [{
                                                label: 'values of' + data['option'],
                                                data: data_chart['list_data'],
                                                backgroundColor:

                                                    'rgba(54, 162, 235, 0.2)'

                                                ,
                                                borderColor: 'rgba(54, 162, 235, 1)'



                                                ,
                                                borderWidth: 1
                                            }]
                                        }}
                                        height={200}
                                        width={500}
                                    />
                                    <h4 style={{marginLeft:"35%", color:'blueviolet'}}>Thống kê của {data['option']} từ {data['from']} tới {data['to']}</h4>

                                </div>

                                <hr />
                                <hr />

                                <div className="row">
                                <h3 style={{ marginLeft: "45%", color: 'goldenrod' }}>
                                        Line Chart
                                    </h3>
                                    <Line
                                        data={{
                                            labels: data_chart['label'],
                                            datasets: [{
                                                label: 'values of' + data['option'],
                                                data: data_chart['list_data'],
                                                backgroundColor:

                                                    'rgba(54, 162, 235, 0.2)'

                                                ,
                                                borderColor: 'rgba(54, 162, 235, 1)'



                                                ,
                                                borderWidth: 1
                                            }]
                                        }}
                                        height={200}
                                        width={500}
                                    />
                                    <h4 style={{marginLeft:"35%", color:'blueviolet'}}>Thống kê của {data['option']} từ {data['from']} tới {data['to']}</h4>

                                </div>

                                <hr />

                                <hr />
                                <hr />
                                <hr />
                                <div className="row">
                                    <h3 style={{ marginLeft: "45%", color: 'goldenrod' }}>
                                        Radar Chart
                                    </h3>
                                    <Radar
                                        data={{
                                            labels: data_chart['label'],
                                            datasets: [{
                                                label: 'values of' + data['option'],
                                                data: data_chart['list_data'],
                                                backgroundColor: [
                                                    'rgba(255, 99, 132, 0.2)',
                                                    'rgba(54, 162, 235, 0.2)',
                                                    'rgba(255, 206, 86, 0.2)',
                                                    'rgba(75, 192, 192, 0.2)',
                                                    'rgba(153, 102, 255, 0.2)',
                                                    'rgba(255, 159, 64, 0.2)'
                                                ],
                                                borderColor: [
                                                    'rgba(255, 99, 132, 1)',
                                                    'rgba(54, 162, 235, 1)',
                                                    'rgba(255, 206, 86, 1)',
                                                    'rgba(75, 192, 192, 1)',
                                                    'rgba(153, 102, 255, 1)',
                                                    'rgba(255, 159, 64, 1)'
                                                ],
                                                borderWidth: 1
                                            }]
                                        }}
                                        height={800}
                                        width={500}
                                    />
                                    <h4 style={{marginLeft:"35%", color:'blueviolet'}}>Thống kê của {data['option']} từ {data['from']} tới {data['to']}</h4>

                                    {/* <!-- Donut Chart --> */}

                                </div>
                                <hr />

                                <div className="row">

                                    {/* <p>Thống kê của {data['option']} từ {data['from']} tới {data['to']}</p> */}
                                    {/* <!-- Area Chart --> */}


                                    <h3 style={{ marginLeft: "38%", color: 'goldenrod' }}>
                                        Doughnut Chart
                                    </h3>
                                    <Doughnut
                                        title='Doughnut Chart'
                                        data={{
                                            labels: data_chart['label'],
                                            datasets: [{
                                                label: 'values of' + data['option'],
                                                data: data_chart['list_data'],
                                                backgroundColor: [
                                                    'rgba(255, 99, 132, 0.2)',
                                                    'rgba(54, 162, 235, 0.2)',
                                                    'rgba(255, 206, 86, 0.2)',
                                                    'rgba(75, 192, 192, 0.2)',
                                                    'rgba(153, 102, 255, 0.2)',
                                                    'rgba(255, 159, 64, 0.2)'
                                                ],
                                                borderColor: [
                                                    'rgba(255, 99, 132, 1)',
                                                    'rgba(54, 162, 235, 1)',
                                                    'rgba(255, 206, 86, 1)',
                                                    'rgba(75, 192, 192, 1)',
                                                    'rgba(153, 102, 255, 1)',
                                                    'rgba(255, 159, 64, 1)'
                                                ],
                                                borderWidth: 1
                                            }]
                                        }}
                                        height={200}
                                        width={500}
                                    />
                                    <h4 style={{marginLeft:"35%", color:'blueviolet'}}>Thống kê của {data['option']} từ {data['from']} tới {data['to']}</h4>

                                    {/* <!-- Donut Chart --> */}

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