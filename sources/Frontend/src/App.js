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
    for(var i = 0; i < listProduct['product'].length; i++){
      _product.push(listProduct['product'][i]);
    }
    async function fetchPostList(){
      for(var i = 0; i < 4; i++){
        var data = <Cart />
      
        _product.push(data)
    }
    setlistProduct({product:_product})
  }
  fetchPostList();
  },[count]);
 
  

  const search_product = (_key_search) => {
    setsearchKey({key_search:_key_search});
  //  console.log("Result : "+searchKey['key_search']);
    if(_key_search){
     

      fetch('http://localhost:8080/nacotiki/api/product/search?query=store%3DRenteria1995&page=0&size=10&sort=product_price,asc', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      },
    })
      .then(res => res.json())
      .then(json => {
        console.log(json)
      });
    }
  }

  


  const [listProduct,setlistProduct] = useState({
    product : []
  });
    
    const load_more = () => {
    
        setCount({count:listProduct.length});
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
              <Route path="/product" exact><Product listProduct = {listProduct['product']} load_more = {load_more} /></Route>
              <Route path="/shopping-cart" exact><Shopping_Cart /></Route>
              <Route path="/product-details" exact><Product_Details /></Route>
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
