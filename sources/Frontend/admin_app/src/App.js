import './App.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'

import Home from './Layout/Pages/Home/Home';
import Login from './Layout/Pages/Login/Login';
import Register from './Layout/Pages/Login/Register';
import Forgot from './Layout/Pages/Login/Forgot';
import Cards from './Layout/Pages/Card/Cards';
import Chart from './Layout/Pages/Chart/Chart';

function App() {

  const handle_getToken = () =>{
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
       
        if(json.id_token.length){
        
          localStorage.setItem('token', json.id_token);
        
        }
        
        
      });

  }




  return (
    <div className="App">
        <Router>
          <Switch>
              <Route path="/" exact><Home />  </Route>
              <Route path="/login" exact><Login/></Route>
              <Route path="/sign-up" exact><Register/></Route>
              <Route path="/forgot" exact><Forgot/></Route>
              <Route path="/cards" exact><Cards/></Route>
              <Route path="/chart" handle_getToken = {handle_getToken()} exact><Chart/></Route>
          </Switch>
        </Router>
  
      </div>
  );
}

export default App;
