import React from 'react';
import CssBaseline from '@material-ui/core/CssBaseline';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import SaveIcon from '@material-ui/icons/Save';
import EditIcon from '@material-ui/icons/Edit';
import DeleteIcon from '@material-ui/icons/Delete';

export default function SimpleContainer() {
  return (
    <React.Fragment>
      <CssBaseline />
      <Container maxWidth="sm">
        <Typography component="div" style={{ backgroundColor: '#cfe8fc' }} />
        <form className="item-form-users">
        <SaveIcon id="item-icon"></SaveIcon>
        <EditIcon id="item-icon"></EditIcon>
        <DeleteIcon id="item-icon"></DeleteIcon>
        </form>
      </Container>
    </React.Fragment>
  );
}