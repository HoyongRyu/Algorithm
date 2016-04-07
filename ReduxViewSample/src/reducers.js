import { combineReducers } from 'redux';
import { routerReducer as routing } from 'react-router-redux';


import member from './member/reducer'


export default combineReducers({
  routing,
  member
});
