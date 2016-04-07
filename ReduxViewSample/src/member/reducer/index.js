import { combineReducers } from 'redux';


import signUpReducer from './signUpReducer';
import authenticationReducer from './authentication';
import memberListReducer from './memberListReducer';

export default combineReducers({
  signUpReducer,
  authenticationReducer,
  memberListReducer
});
