import React from 'react';
import Header from '../../header/components/header.component';
import Table from './table.component';
import Form from './form.component';
class Users extends React.Component{
    render(){
        return(
            <div>
                 <Header></Header>
                <Table></Table>
                <Form></Form>
            </div>
        );
    }
}

export default Users;