import { GET_USERS } from '../types/user.types';
import { URL_GET_USERS } from '../../constants/constants';
  
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

