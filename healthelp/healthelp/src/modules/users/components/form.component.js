import React from 'react';
import CssBaseline from '@material-ui/core/CssBaseline';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import SaveIcon from '@material-ui/icons/Save';
import EditIcon from '@material-ui/icons/Edit';
import DeleteIcon from '@material-ui/icons/Delete';
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
        <SaveIcon id="item-icon" onClick={handleDialog}></SaveIcon>
        <EditIcon id="item-icon"></EditIcon>
        <DeleteIcon id="item-icon"></DeleteIcon>
        </div>
      </Container>
   
    {open?<Dialog></Dialog>:''}
    </div>
  );
}

export default SimpleContainer;