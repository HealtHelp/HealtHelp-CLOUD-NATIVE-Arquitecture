import React from 'react';
import store from './store/store';
import {BrowserRouter as Router,Route,Redirect} from 'react-router-dom';
import FormDialogLogin from './modules/login/components/login.component';
import SUCCESS from './modules/snackbar/success';
import ERROR from './modules/snackbar/error';
import Home from './modules/home/components/home.component';
import Users from './modules/users/components/users.component';

class App extends React.Component {
  constructor(props){
    super(props);
    this.state={
        login:{}
    }
  store.subscribe(() => {
    this.setState({
      login : store.getState().auth.oauth
    });
  });
  }

 handleUserComponent = () => {
   console.log("users")
 }

  render(){
    return (
      <Router>
      <div className="App">
        <Route exact path="/" component={FormDialogLogin}/>
        <Route exact path="/home" component={Home}/>
        <Route exact path="/users" component={Users}/>
      </div>
      {this.state.login.access_token?<SUCCESS></SUCCESS>:''}
      {this.state.login.access_token? <Redirect to="/home" />:''}
      {this.state.login.error?<ERROR></ERROR>:''}
      {window.onload=<Redirect to="/"/>}
      </Router>
    );
  }
}

export default App;
