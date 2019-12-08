import React from 'react';
import {BrowserRouter as Router,Route,Redirect} from 'react-router-dom';
import './App.css';
import FormDialogLogin from './modules/login/components/login.component';

function App() {
  return (
    <Router>
    <div className="App">
      <Route exact path="/" component={FormDialogLogin}/>
    </div>
    {window.onload=<Redirect to="/"  />}
    </Router>
  );
}

export default App;
