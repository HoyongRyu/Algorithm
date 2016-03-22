import { combineReducers } from 'redux';
import { routerReducer as routing } from 'react-router-redux';

import authentication from './authentication'
import memberListReducer from './member/memberListReducer';
import userReducer from './user'


export default combineReducers({
  routing,
  authentication,
  memberListReducer,
  userReducer
});
