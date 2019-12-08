import React from 'react';
import {connect} from 'react-redux';
import {handleLogin} from '../actions/login.actions';
import store from '../../../store/store';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import { FormControl,InputLabel,Input,FormHelperText } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles(theme => ({
    button: {
      margin: theme.spacing(1),
    },
  }));


function FormDialog() {
  const [open, setOpen] = React.useState(true);
  let [username,password] = React.useState('');
  const classes = useStyles();
   
  /* const handleClickOpen = () => {
    setOpen(true);
  }; */

  const handleClose = () => {
    setOpen(false);
  };

  const handleUser = (e) => {
    username = e.target.value;
  } 

  const handlePassword = (e) => {
    password = e.target.value;
  }

  const handleActionLogin = (data) =>{
    let json = {
      username: username,
      password: password,
      grant_type: 'password'
    };
    store.dispatch(handleLogin(json));
  }

  return (
    <div>
      <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
        <DialogTitle id="form-dialog-title"><i className="fas fa-laptop-medical"></i>&nbsp;HEALTHELP&nbsp;</DialogTitle>
        <DialogContent>
          <DialogContentText>
            Inserta tus credenciales
          </DialogContentText>
          <form>
          <FormControl>
            <InputLabel htmlFor="item-user">Usuario</InputLabel>
            <Input id="item-user" aria-describedby="my-helper-text" onChange={handleUser} />
            <FormHelperText id="item-email">We'll never share your user.</FormHelperText>
        </FormControl>&nbsp;&nbsp;
        <FormControl>
            <InputLabel htmlFor="my-input">Password</InputLabel>
            <Input type="password" id="my-input" aria-describedby="my-helper-text" onChange={handlePassword}/>
            <FormHelperText id="my-helper-text">We'll never share your password.</FormHelperText>
        </FormControl>
        </form>
        </DialogContent>
        <DialogActions>
        <Button
            variant="contained"
            color="primary"
            className={classes.button}
            onClick={handleActionLogin}
        >
            Enviar
        </Button> 
        </DialogActions>
      </Dialog>
    </div>
  );
}



const mapStateToProps = (state) =>({
    login:state.data
  }) 
  
  
export default connect(mapStateToProps,null) (FormDialog);