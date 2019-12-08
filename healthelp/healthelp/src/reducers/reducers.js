import {combineReducers} from 'redux';
import loginReducer from '../modules/login/reducer/login.reducer';

export default combineReducers({
    auth :loginReducer
    
});