import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';



class ButtonAppBar extends React.Component {

  handleStyles = () => {
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
 
  

  
  render(){
    const classes = this.handleStyles;
    return (
        <div className={classes.root}>
          <AppBar position="static">
            <Toolbar>
              <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
               
              </IconButton>
              <Typography variant="h6" className={classes.title}>
                HealtHelp Organization
              </Typography>
            </Toolbar>
          </AppBar>
        </div>
      );
  }
  
}




  
  
export default ButtonAppBar;