import React from 'react';
import {useSelector} from 'react-redux';
import store from './store/store';
import {BrowserRouter as Router,Route,Redirect} from 'react-router-dom';
import FormDialogLogin from './modules/login/components/login.component';
import SUCCESS from './modules/snackbar/success';
import ERROR from './modules/snackbar/error';
import Home from './modules/home/components/home.component';
import Users from './modules/users/components/users.component';
import UpdateUser from './modules/users/components/edit.component'; 

const App = () => {
  const login = useSelector((state) => state.auth.oauth)
  let error;
  let token;
  if(login){
    error = login.error;
    token = login.access_token;
  }
    return (
      <Router>
      <div className="App">
        <Route exact path="/" component={FormDialogLogin}/>
        <Route exact path="/home" component={Home}/>
        <Route exact path="/users" component={Users}/>
        <Route exact path="/users/:id" component={UpdateUser}></Route>
      </div>
      {token?<SUCCESS></SUCCESS> :''}
      {token? <Redirect to="/home" />:''}
      {error?<ERROR></ERROR>:''}
      {window.onload=<Redirect to="/"/>}
      </Router>
    );
  }

 
export default App;
