import React from 'react';
import CssBaseline from '@material-ui/core/CssBaseline';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import AddIcon from '@material-ui/icons/Add';
import Fab from '@material-ui/core/Fab';
import Dialog from './save.component';




const SimpleContainer = () => {
  const [open, setOpen] = React.useState(false);
  const handleDialog = () => {
    if(open){
      setOpen(false)
    }
    else{
      setOpen(true)
    }
  }
  return (
     <div>
      <CssBaseline />
      <Container maxWidth="sm">
        <Typography component="div" style={{ backgroundColor: '#cfe8fc' }} />
        <div className="item-form-users">
        <Fab color="primary" aria-label="add" onClick={handleDialog}>
        <AddIcon />
         </Fab>
        </div>
      </Container>
    {open?<Dialog></Dialog>:''}
    </div>
  );
}

export default SimpleContainer;