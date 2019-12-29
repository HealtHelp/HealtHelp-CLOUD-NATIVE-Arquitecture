import {GET_USERS} from '../types/user.types';


const initialState = {
    data:[]
}

export default function handleGETUsers(state = initialState,action){
    switch(action.type){
        case GET_USERS:
            return{
                ...state,
                data: action.payload
            }
        default:
            return state;    
    }
}