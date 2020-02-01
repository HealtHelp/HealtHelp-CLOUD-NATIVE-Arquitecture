import { 
    GET_USERS,
    SET_USER } from '../types/user.types';
import { 
    URL_GET_USERS,
    URL_SET_USER } from '../../constants/constants';

  
import axios from 'axios';

let token = localStorage.getItem("token");

const  HEADERS = {
    headers:{
        "Access-Control-Allow-Origin":"http://localhost:3000",
        "Authorization": "Bearer "+token,
      }   
    }

export const handleGETUsers = () =>  dispatch => {
    axios.get(URL_GET_USERS,HEADERS)
    .then((res) => {
        return dispatch ({
            type:GET_USERS,
            payload:res.data
       }) 
    })
    .catch(error => console.log(error))      
}

export const handlePOSTUser = () => dispatch => {
    axios.post(URL_SET_USER.HEADERS)
    .then((res) => {
        console.log(res)
        return dispatch ({
            type:SET_USER,
            payload:res.data
       }) 
    })
    .catch(error => console.log(error)) 
}

