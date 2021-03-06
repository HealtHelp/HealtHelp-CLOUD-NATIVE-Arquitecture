import React , {useEffect}from 'react';
import {useDispatch} from 'react-redux';
import Header from '../../header/components/header.component';
import Table from './table.component';
import {handleGETUsers} from '../actions/user.actions';
import Form from './form.component';

const Users = () => {
    const dispatch = useDispatch();
    const getUsers = () => dispatch(handleGETUsers())
    useEffect( () =>{
        getUsers()
    },[]); 

        return(
            <div>
                <Header></Header>
                <Table></Table>
                <Form></Form>
            </div>
        );
}


export default Users;