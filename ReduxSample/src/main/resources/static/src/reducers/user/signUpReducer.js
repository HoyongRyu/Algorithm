import { browserHistory } from 'react-router';
import { POPUP_CLOSE } from 'reducers/commonType';

const SIGN_UP_REQUEST = 'signUp/REQUEST';
const SIGN_UP_SUCCESS = 'signUp/SUCCESS';
const SIGN_UP_FAIL = 'signUp/FAIL';

const initialState = {
  usrId: '',
  errorMessage: ''
};

// Reducer

export default function signUpReducer(state = initialState, action) {
  switch (action.type) {
    case SIGN_UP_SUCCESS:
      return {
        ...state,
        usrId: action.result.data.usrId
      };
    case SIGN_UP_FAIL:
      return {
        ...state,
        errorMessage: '회원가입 실패. 관리자에게 문의하세요.'
      };
    case POPUP_CLOSE:
      return {
        ...state,
        errorMessage: ''
      }
    default:
      return state;
  }
}

// Actions

export const signUp = (loginId, password) => {
  return  {
    types: [SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAIL],
    promise: client => client.post('/api/user/createUser', {loginId, password}),
    afterSuccess: (dispatch, getState, response) => {
      if (getState().userReducer.signUpReducer.usrId > ''){
        browserHistory.push('/');
      }
    }
  };
}

export const closeErrorPopup = () => {
  return {
    type: POPUP_CLOSE
  }
}

// export function signUp(loginId, password) {
//   return  {
//     types: [SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAIL],
//     promise: client => client.post('/api/user/createUser', {loginId, password}),
//     afterSuccess: (dispatch, getState, response) => {
//       browserHistory.push('/');
//     }
//   };
// }
