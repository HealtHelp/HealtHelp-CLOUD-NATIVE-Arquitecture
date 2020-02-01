import React from 'react';
import {useSelector} from 'react-redux';
import {connect} from 'react-redux';
import store from '../../../store/store'; 
import {handlePOSTUser,handleGETUsers} from '../actions/user.actions';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import InputLabel from '@material-ui/core/InputLabel';
import Input from '@material-ui/core/Input';
import Select from '@material-ui/core/Select';
import MenuItem from '@material-ui/core/MenuItem';
import ListSubheader from '@material-ui/core/ListSubheader';
import SaveIcon from '@material-ui/icons/Save';
import Swal from 'sweetalert2';

const useStyles = makeStyles(theme => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
      width: 200,
    }
  },
}));

 function AlertDialog() {
  const [open, setOpen] = React.useState(true);
  const handleClose = () => {
    setOpen(false);
  };

  const id =  useSelector((state) => state.auth.oauth.tenantId);
  const handleSubmit = (e) => {
    e.preventDefault();
    setOpen(false)
    var validator = require("email-validator");
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("standard-password-input").value;
    const repitPassword = document.getElementById("repit-password-input").value;
    const role = document.getElementById("grouped-select").value;
    const tenantId = id;
    
    if(password != repitPassword){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'LOS PASSWORDS NO SON IGUALES!',
        footer: '<a href>http://web.mit.edu/rhel-doc/4/RH-DOCS/rhel-sg-es-4/s1-wstation-pass.html</a>'
      })
    }
    else if(!validator.validate(email)){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'EL EMAIL TIENE UNN FORMATO INCORRECTO!',
        footer: '<a href>https://answers.microsoft.com/es-es/outlook_com/forum/all/usa-el-siguiente-formato-para-las-direcciones-de/88526ae0-4e5e-4153-8dc7-83d20655383d</a>'
      })
    }
    else{
      const user = {
        username,
        email,
        password,
        tenantId,
        "enabled":true
      }
      console.log(user);
      store.dispatch(handlePOSTUser(user));
      Swal.fire({
        title: `¿Guardar al usuario ${username}?`,
        text: `Email: ${email} Role: ${role}`,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
      }).then((result) => {
        if (result.value) {
          Swal.fire(
            'Guardado!',
            'Your user has been inserted.',
            'success'
          )
          store.dispatch(handleGETUsers());
        }
      })
    }
  } 

  const classes = useStyles();
  return (
    
      <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="alert-dialog-title"
        aria-describedby="alert-dialog-description"
      >
        <DialogTitle id="alert-dialog-title">{"Save a physiotherapist"}<i className="fas fa-user-md"></i></DialogTitle>
        <DialogContent>
          <DialogContentText id="alert-dialog-description">
          <form className={classes.root} noValidate autoComplete="off">
            <TextField id="username" label="Username" />
            <TextField id="email" label="Email" />
            <TextField
               id="standard-password-input"
               label="Password"
               type="password"
               autoComplete="current-password"
            />
             <TextField
               id="repit-password-input"
               label="Repit Password"
               type="password"
               autoComplete="current-password"
            />
        <InputLabel htmlFor="grouped-select">Profile</InputLabel>
        <Select defaultValue="" input={<Input id="grouped-select" />}>
          <MenuItem value="">
          </MenuItem>
          <ListSubheader>Category 1</ListSubheader>
          <MenuItem value={"ROLE_ADMIN"}>ROLE_ADMIN</MenuItem>
          <ListSubheader>Category 2</ListSubheader>
          <MenuItem value={"ROLE_USER"}>ROLE_USER</MenuItem>
        </Select>
          </form>
          </DialogContentText>
        </DialogContent>
        <DialogActions>
        <Button
        variant="contained"
        color="primary"
        size="large"
        className={classes.button}
        onClick={handleSubmit}
        startIcon={<SaveIcon />}
      >
        Save
      </Button>
          <Button onClick={handleClose} color="primary" autoFocus>
            EXIT
          </Button>
        </DialogActions>
      </Dialog>
   
  );
}

const mapStateToProps = (state) =>({
  data:state.data
}) 


export default connect(mapStateToProps,null) (AlertDialog);