import React from 'react';
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

const useStyles = makeStyles(theme => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
      width: 200,
    }
  },
}));

export default function AlertDialog() {
  const [open, setOpen] = React.useState(true);



  const handleClose = () => {
    setOpen(false);
  };
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
            <TextField id="standard-basic" label="Username" />
            <TextField id="standard-basic" label="Email" />
            <TextField
               id="standard-password-input"
               label="Password"
               type="password"
               autoComplete="current-password"
            />
             <TextField
               id="standard-password-input"
               label="Repit Password"
               type="password"
               autoComplete="current-password"
            />
        <InputLabel htmlFor="grouped-select">Profile</InputLabel>
        <Select defaultValue="" input={<Input id="grouped-select" />}>
          <MenuItem value="">
          </MenuItem>
          <ListSubheader>Category 1</ListSubheader>
          <MenuItem value={1}>ROLE_ADMIN</MenuItem>
          <ListSubheader>Category 2</ListSubheader>
          <MenuItem value={3}>ROLE_USER</MenuItem>
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