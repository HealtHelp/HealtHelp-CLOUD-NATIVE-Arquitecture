import React from 'react';
import store from '../../../store/store';
import {connect} from 'react-redux';
import Header from '../../header/components/header.component';
import Table from './table.component';
import {handleGETUsers} from '../actions/user.actions';
import Form from './form.component';

class Users extends React.Component{
    constructor(props){
        super(props);
        this.state = {
        }
    }

    componentDidMount(){
        store.dispatch(handleGETUsers())
    }

    render(){
        return(
            <div>
                <Header></Header>
                <Table handleDialog={this.handleDialog}></Table>
                <Form></Form>

            </div>
        );
    
    }
}


const mapStateToProps = (state) =>({
    users:state.data
  }) 
  
  
export default connect(mapStateToProps,null) (Users);