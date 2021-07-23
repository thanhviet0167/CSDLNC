import './App.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'

import Home from './Layout/Pages/Home/Home';
import Login from './Layout/Pages/Login/Login';
import Register from './Layout/Pages/Login/Register';
import Forgot from './Layout/Pages/Login/Forgot';
import Cards from './Layout/Pages/Card/Cards';
import Chart from './Layout/Pages/Chart/Chart';

function App() {
  return (
    <div className="App">
        <Router>
          <Switch>
              <Route path="/" exact><Home />  </Route>
              <Route path="/login" exact><Login/></Route>
              <Route path="/sign-up" exact><Register/></Route>
              <Route path="/forgot" exact><Forgot/></Route>
              <Route path="/cards" exact><Cards/></Route>
              <Route path="/chart" exact><Chart/></Route>
          </Switch>
        </Router>
  
      </div>
  );
}

export default App;
