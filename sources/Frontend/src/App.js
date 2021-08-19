import { BrowserRouter as Router, Switch, Route, Redirect } from 'react-router-dom'
import './App.css';
import React, {useState, useEffect} from "react";
import Login from './Components/UserForm/Login/Login'
import Home from './Components/Homepage/Home'
import Signup from './Components/UserForm/Signup/Sign_up'
import Contact from './Components/Contact/Contact';
import ResestPassword from './Components/UserForm/Forgot/ResestPassword';
import Product from './Products/Product/Product';
import Shopping_Cart from './Products/Product/Shopping_Cart';
import Product_Details from './Products/Product-Details/Product_Details';
import Checkout from './Pay/Checkout';
import Card from './Promotion/Card/Card';
import Sitemap from './Products/Classify/Sitemap';
import Values from './Company/Values';
import Help from './Components/Contact/Help';
import About from './Company/About';
import Faq from './Service/Faq';
import Marketplace from './Company/Marketplace';
import Offer from './Promotion/Offer/Offer';
import Privacy from './Company/Privacy';
import Cart from './Products/Cart/Cart';

import axios from 'axios'





function App() {
  const [account, setAccount] = useState({
    usename: "",
    status : false,
    token:''
  });



  

  const handle_logout = ()=>{
    console.log("Hello" + localStorage.getItem("username"))
    localStorage.setItem("username","");
    localStorage.setItem("token","");
    setAccount({
      usename:'',
      status:false,
      token:''
    })
    
  }

  const handle_Login = (_username, _password)=>{
    var data = {
      username: _username,
      password: _password
    }
    var check = false;
    
    fetch('http://localhost:8080/nacotiki/api/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
      .then(res => res.json())
      .then(json => {
       
        if(json.id_token.length){
          document.getElementById("error").innerHTML = "";
          check = true;
          localStorage.setItem('token', json.id_token);
          localStorage.setItem('username', _username);
          console.log(json.id_token)
          onChange_login(_username, json.id_token, true)
          console.log(localStorage.getItem("username"))
        }
        
        
      });

      if(!check){
        document.getElementById("error").innerHTML = "Username or password is not correct";
      }
      else{
        document.getElementById("error").innerHTML = "";
        console.log("Truee")
      }
  }


  const handle_signup = (data)=>{
    
    var check = false;
    fetch('http://localhost:8080/nacotiki/api/register', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
      .then(res => res.json())
      .then(json => {
        check = true
        console.log(json)
        document.getElementById('error_signup').innerHTML = ""
      });
      if(!check){
        document.getElementById('error_signup').innerHTML = "Username arealdy exist";
      }
    
  }

  const onChange_login = (_username,_jtoken, _status) =>{
    setAccount({
      usename:_username,
      token: _jtoken,
      status: _status
    })
  }

  const [filter, setFilter] = useState({
    search: '',
    sort:'',
    store:'',
    fromPrice: 0,
    toPrice:0,
    fromRate:0,
    toRate:0,
    count:0
  });

  const [productDetail, setproductDetail] = useState({
    detail: {}
  });

  const handle_product_details = (product) => {
    setproductDetail({detail: product})
    
  }


  const handle_sort = (type)=> {
    setFilter({
      search: '',
      fromPrice: 0,
      toPrice: 0,
      sort:type,
      store:'',
      fromRate:0,
      toRate:0,
      count:0
      
    })

  }
  const handle_price = (from, to)=> {
   
    setFilter({
      search: '',
      fromPrice: from,
      toPrice: to,
      sort:'asc',
      store:'',
      fromRate:0,
      toRate:0,
      count:0
    })

    console.log(filter)
  }
  const handle_rate = (from, to)=> {
   
    setFilter({
      search: '',
      fromRate: from,
      toRate: to,
      sort:'',
      store:'',
      fromPrice:0,
      toPrice:0,
      count:0
    })

    console.log(filter)
  }

  const [user,setUser] = useState({email: "", password: ""});
 // const [error, setError] = useState("");
  const LoginHandler = details => {
    if(details.email !== account.email || details.password !== account.password)
    {
      document.getElementById("check_login").innerHTML = "Username or password does not correct";
    }
    else{
      document.getElementById("check_login").innerHTML = "";
      setUser({email: details.email, password: details.password})
      return <Redirect to = "/" />
    }
  }
  const [searchKey, setsearchKey] = useState({
    key_search : "",
    list_product_search:[]
  });
  const [count, setCount] = useState({total:0});

  useEffect(()=>{

    //localStorage.setItem('token', json.token);
    var _product = [];
    // for(var i = 0; i < listProduct['product'].length; i++){
    //   _product.push(listProduct['product'][i]);
    // }
    

    if(JSON.parse(localStorage.getItem('list_cart'))){
    
      
      setListCart({
        cart: JSON.parse(localStorage.getItem('list_cart')),
        total: localStorage.getItem('total'),
        size: localStorage.getItem('size')
      })
    }
    console.log(list_cart)

    async function fetchPostList(){
      
    //   for(var i = 0; i < searchKey['list_product_search'].length; i++){
    //     var data = <Cart name_product = {searchKey['list_product_search'][i]['tenSanPham']}
    //     price = {searchKey['list_product_search'][i]['giaHienHanh']}/>
      
    //     _product.push(data)
    // }
    // setlistProduct({product:_product})
    // console.log(searchKey['list_product_search'])
    if((filter['sort'].length > 0 || filter['search'].length > 0) && filter['fromPrice'] == 0){

      console.log("Toi day" + filter['search']);

      fetch('http://localhost:8080/nacotiki/api/product/search?query=store%3D' + searchKey['key_search'] + '&page=0&size=10&sort=product_price,' + filter['sort'], {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        },
      })
        .then(res => res.json())
        .then(json => {
          console.log("json " + json['content_list'])
          
          setsearchKey({
            ... searchKey,
            list_product_search: json['content_list']
          })
        });

        setFilter({
          ... filter,
          sort:'',
          search:''
        })
    }
    else{
      if(filter['fromPrice'] > 0){
        fetch('http://localhost:8080/nacotiki/api/product/search?query=store%3D'+ searchKey['key_search'] +'&fromPrice%3D'+filter['fromPrice'] +'%26toPrice%3D'+filter['toPrice']+'&page=0&size=10&sort=product_price,'
        + 'asc', {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        },
      })
        .then(res => res.json())
        .then(json => {
          console.log("json " + json['content_list'])
          
          setsearchKey({
            ... searchKey,
            list_product_search: json['content_list']
          })
        });

        setFilter({
          ... filter,
          fromPrice:0,
          toPrice:0,
          sort: ''
        })
      }
      else{
        if(filter['fromRate'] > 0){

          console.log("Rate" + 'http://localhost:8080/nacotiki/api/product/search?query=store%3D'+ searchKey['key_search']+'&fromRate%3D'+filter['fromRate'] +'%26toRate%3D'+filter['toRate']+'&page=0&size=10&sort=product_price,')

          fetch('http://localhost:8080/nacotiki/api/product/search?query=store%3D'+ searchKey['key_search']+'&fromRate%3D'+filter['fromRate'] +'%26toRate%3D'+filter['toRate']+'&page=0&size=10&sort=product_price,'
          + 'desc', {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          },
        })
          .then(res => res.json())
          .then(json => {
            console.log("json " + json)
            
            setsearchKey({
              ... searchKey,
              list_product_search: json['content_list']
            })
          });
  
          setFilter({
            ... filter,
            fromRate:0,
            toRate:0,
            sort:''
          })
        }
      }
    }
   
  }
  fetchPostList();
  },[filter]);
 
  

  const search_product = (_key_search) => {
    setsearchKey({key_search:_key_search});
    setFilter({
      ... filter,
      search: _key_search
    })
  //  console.log("Result : "+searchKey['key_search']);
    if(_key_search){
     

    //   fetch('http://localhost:8080/nacotiki/api/product/search?query=store%3DRenteria1995&page=0&size=10&sort=product_price,asc', {
    //   method: 'GET',
    //   headers: {
    //     'Content-Type': 'application/json'
    //   },
    // })
    //   .then(res => res.json())
    //   .then(json => {
        
    //     setsearchKey({
    //       ... searchKey,
    //       list_product_search: json['content_list']
    //     })
    //   });
    }
  }

  


  const [listProduct,setlistProduct] = useState({
    product : []
  });
    
    const load_more = () => {
    
        setFilter({... filter,count:listProduct.length});
        console.log(listProduct.length)
        
    }

    
    const [list_cart, setListCart] = useState({
      cart: [],
      total: 0,
      size: 0
    })

    const add_to_cart = (data) =>{
      var cart_current = list_cart['cart']

      var _total = 0
      
      if(cart_current.length > 0){
        var check = false;
        for(var i = 0; i < cart_current.length; i++){
          if(cart_current[i]['chiTietGioHangID']['maSanPham'] == data['chiTietGioHangID']['maSanPham'])
          {
            cart_current[i]['soLuongMua'] += data['soLuongMua']
            cart_current[i]['giaBanThucTe'] = cart_current[i]['soLuongMua']*cart_current[i]['giaGiam']
            check = true
          }
        }
        if(!check){
          cart_current.push(data);
        }
        for(var i = 0; i < cart_current.length; i++){
          _total += cart_current[i]['giaBanThucTe']
        }
        
      }
      else{
        cart_current.push(data);
      }




      localStorage.setItem('list_cart',JSON.stringify(cart_current));
      localStorage.setItem('size',cart_current.length);
      localStorage.setItem('total',_total)
      setListCart({
        cart: cart_current,
        total: _total,
        size: cart_current.length
      })

      console.log(list_cart['cart'])
      
      console.log(JSON.parse(localStorage.getItem('list_cart')))
     // localStorage.setItem('list_cart',JSON.stringify([]));
      
    }

    const handle_update_plus = (product_id) => {
     
      var current = JSON.parse(localStorage.getItem('list_cart'));
      for(var i = 0; i < current.length; i++){
        if(current[i]['chiTietGioHangID']['maSanPham'] == product_id){
          current[i]['soLuongMua'] += 1;
          current[i]['giaBanThucTe'] = current[i]['soLuongMua']*current[i]['giaGiam']
        }
      }
      var _total = 0;
      for(var i = 0; i < current.length; i++){
        _total += current[i]['giaBanThucTe']
      }

      console.log(current)

      localStorage.setItem('list_cart',JSON.stringify(current));
      localStorage.setItem('size',current.length);
      localStorage.setItem('total',_total)

      setListCart({
        cart: JSON.parse(localStorage.getItem('list_cart')),
        total: localStorage.getItem('total'),
        size: localStorage.getItem('size')
      })

    }

    const handle_update_moin = (product_id) => {
     
      var current = JSON.parse(localStorage.getItem('list_cart'));
      for(var i = 0; i < current.length; i++){
        if(current[i]['chiTietGioHangID']['maSanPham'] == product_id){
          current[i]['soLuongMua'] -= 1;
          if(current[i]['soLuongMua'] == 0){
            current.splice(i, 1); 
          }
          else{
            current[i]['giaBanThucTe'] = current[i]['soLuongMua']*current[i]['giaGiam']
          }
        
          
        }
      
      }
      
      var _total = 0;
      for(var i = 0; i < current.length; i++){
        _total += current[i]['giaBanThucTe']
      }

      console.log(current)

      localStorage.setItem('list_cart',JSON.stringify(current));
      localStorage.setItem('size',current.length);
      localStorage.setItem('total',_total)

      setListCart({
        cart: JSON.parse(localStorage.getItem('list_cart')),
        total: localStorage.getItem('total'),
        size: localStorage.getItem('size')
      })

    }


    const handle_remove = (product_id) => {
     
      var current = JSON.parse(localStorage.getItem('list_cart'));
      for(var i = 0; i < current.length; i++){
        if(current[i]['chiTietGioHangID']['maSanPham'] == product_id){
         
            current.splice(i, 1); 
        }
      
      }
      
      var _total = 0;
      for(var i = 0; i < current.length; i++){
        _total += current[i]['giaBanThucTe']
      }

      console.log(current)

      localStorage.setItem('list_cart',JSON.stringify(current));
      localStorage.setItem('size',current.length);
      localStorage.setItem('total',_total)

      setListCart({
        cart: JSON.parse(localStorage.getItem('list_cart')),
        total: localStorage.getItem('total'),
        size: localStorage.getItem('size')
      })

    }


    
    return (
      <div className="App">
        <Router>
          <Switch>
              <Route path="/" exact><Home user= {user} handler_search_product = {search_product} searchKey = {searchKey} account={account} handle_logout = {handle_logout}/>  </Route>
              <Route path="/login" exact><Login LoginHandler = {LoginHandler} user = {user} handle_Login = {handle_Login} account={account}/></Route>
              <Route path="/sign-up" exact><Signup handle_signup={handle_signup}/></Route>
              <Route path="/forgot-password" exact><ResestPassword/></Route>
              <Route path="/contact-us" exact><Contact/></Route>
              <Route path="/product" exact><Product listProduct = {searchKey['list_product_search']} load_more = {load_more} handle_sort = {handle_sort}
                handle_price = {handle_price} filter = {filter} handler_search_product = {search_product}
                handle_rate = {handle_rate} handle_product_details = {handle_product_details}
              /></Route>
              <Route path="/shopping-cart" exact><Shopping_Cart handle_update_plus = {handle_update_plus} handle_update_moin = {handle_update_moin} 
              handle_remove = {handle_remove}/></Route>
              <Route path="/product-details" exact><Product_Details product_detail = {productDetail} add_to_cart = {add_to_cart}/></Route>
              <Route path="/check-out" exact><Checkout /></Route>
              <Route path="/card" exact><Card /></Route>
              <Route path="/sitemap" exact><Sitemap /></Route>
              <Route path="/values" exact><Values /></Route>
              <Route path="/help" exact><Help /></Route>
              <Route path="/about" exact><About /></Route>
              <Route path="/faq" exact><Faq /></Route>
              <Route path="/marketplace" exact><Marketplace /></Route>
              <Route path="/offers" exact><Offer /></Route>
              <Route path="/privacy" exact><Privacy /></Route>
          </Switch>
        </Router>
  
      </div>
    );
 
}

export default App;
