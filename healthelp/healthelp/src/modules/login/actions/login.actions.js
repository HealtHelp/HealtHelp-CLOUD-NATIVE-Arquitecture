import { SET_HANDLE_LOGIN } from '../types/login.types';
import { URL_LOGIN,HEADERS } from '../../constants/constants';

export const handleLogin = (data) =>  dispatch => {
    const body = Object.keys(data).map(key => encodeURIComponent(key) + '=' + encodeURIComponent(data[key])).join('&');
      const request =  {
        method:'POST',
        headers:HEADERS,
        body
      };

       fetch(URL_LOGIN,request)
        .then((res) => {
          res.json().then((res) =>{
            return dispatch({
              type:SET_HANDLE_LOGIN,
              payload:res
            })
          })   
        })
        .catch((err) =>{
            console.log(err);
        })     
}

