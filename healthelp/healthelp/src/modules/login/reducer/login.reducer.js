import {SET_HANDLE_LOGIN} from '../types/login.types';


const initialState = {
    data:[]
}

export default function login(state = initialState,action){
    switch(action.type){
        case SET_HANDLE_LOGIN:
            return{
                oauth: action.payload
            }
        default:
            return state;    
    }
}