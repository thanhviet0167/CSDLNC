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
  const account = {
    email: "thanhviet0167@gmail.com",
    password: "123456"
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
    var _product = [];
    // for(var i = 0; i < listProduct['product'].length; i++){
    //   _product.push(listProduct['product'][i]);
    // }
    
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
    
    return (
      <div className="App">
        <Router>
          <Switch>
              <Route path="/" exact><Home user= {user} handler_search_product = {search_product} searchKey = {searchKey}/>  </Route>
              <Route path="/login" exact><Login LoginHandler = {LoginHandler} user = {user}/></Route>
              <Route path="/sign-up" exact><Signup/></Route>
              <Route path="/forgot-password" exact><ResestPassword/></Route>
              <Route path="/contact-us" exact><Contact/></Route>
              <Route path="/product" exact><Product listProduct = {searchKey['list_product_search']} load_more = {load_more} handle_sort = {handle_sort}
                handle_price = {handle_price} filter = {filter} handler_search_product = {search_product}
                handle_rate = {handle_rate} handle_product_details = {handle_product_details}
              /></Route>
              <Route path="/shopping-cart" exact><Shopping_Cart /></Route>
              <Route path="/product-details" exact><Product_Details product_detail = {productDetail}/></Route>
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
