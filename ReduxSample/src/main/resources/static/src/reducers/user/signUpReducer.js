import { browserHistory } from 'react-router';
import { POPUP_CLOSE } from 'reducers/commonReducer';

const SIGN_UP_REQUEST = 'signUp/REQUEST';
const SIGN_UP_SUCCESS = 'signUp/SUCCESS';
const SIGN_UP_FAIL = 'signUp/FAIL';

const initialState = {
  isSuccess: null,
  message: '',
  redirectURI: null
};

// Reducer

export default function signUpReducer(state = initialState, action) {
  switch (action.type) {
    case SIGN_UP_SUCCESS:
      return {
        ...state,
        isSuccess: true,
        message: '관리자 승인 후 로그인 하세요.'
      };
    case SIGN_UP_FAIL:
      return {
        ...state,
        isSuccess: false,
        message: '회원가입 실패. 관리자에게 문의하세요.'
      };
    case POPUP_CLOSE:
      return {
        ...state,
        isSuccess: null,
        message: '',
        redirectURI: action.redirectURI
      }
    default:
      return state;
  }
}

// Actions

export const signUp = (loginId, password) => {
  return  {
    types: [SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAIL],
    promise: client => client.post('/api/user/createUser', {loginId, password})
  };
}


