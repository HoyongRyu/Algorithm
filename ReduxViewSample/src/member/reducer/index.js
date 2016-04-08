import { combineReducers } from 'redux';


import signUpReducer from './signUpReducer';
import authenticationReducer from './authentication';

export default combineReducers({
  signUpReducer,
  authenticationReducer,
});
