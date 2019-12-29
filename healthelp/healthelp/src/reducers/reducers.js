import {combineReducers} from 'redux';
import loginReducer from '../modules/login/reducer/login.reducer';
import userReducer from '../modules/users/reducer/user.reducer';

export default combineReducers({
    auth :loginReducer,
    users:userReducer
});