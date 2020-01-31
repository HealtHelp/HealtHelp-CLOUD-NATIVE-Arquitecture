import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import {Link} from 'react-router-dom';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import AddIcon from '@material-ui/icons/Add';
import Fab from '@material-ui/core/Fab';


const ButtonAppBar = () => {

const handleStyles = () => {
      return makeStyles(theme => ({
        root: {
          flexGrow: 1,
        },
        menuButton: {
          marginRight: theme.spacing(2),
        },
        title: {
          flexGrow: 1,
        },
      }));
  }
 
 

    const classes = handleStyles();
    return (
        <div className={classes.root}>
          <AppBar position="static">
            <Toolbar>
            
              <Typography variant="h6" className={classes.title}>
                HealtHelp Organization
              </Typography>
            </Toolbar>
          </AppBar>
        </div>
      );
  }
  
  
export default ButtonAppBar;