import { browserHistory } from 'react-router';
import { POPUP_CLOSE } from 'common/reducer/commonReducer';

const LOGIN = 'authentication/LOGIN';
const LOGIN_SUCCESS = 'authentication/LOGIN_SUCCESS';
const LOGIN_FAIL = 'authentication/LOGIN_FAIL';

const LOGOUT = 'authentication/LOGOUT';
const LOGOUT_SUCCESS = 'authentication/LOGOUT_SUCCESS';
const LOGOUT_FAIL = 'authentication/LOGOUT_FAIL';

const GET_SESSION = 'authentication/GET_SESSION';
const GET_SESSION_SUCCESS = 'authentication/GET_SESSION_SUCCESS';
const GET_SESSION_FAIL = 'authentication/GET_SESSION_FAIL';

const ERROR_MESSAGE = 'authentication/ERROR_MESSAGE';

const initialState = {
  isAuthenticated: null,
  sessionToken: null,
  loginId: null,
  errorMessage: null,
  loading: true,
  redirectURI: null,
  showPopup: null
};

// Reducer

export default function reducer(state = initialState, action) {
  switch (action.type) {
    case LOGIN_SUCCESS:
      return {
        ...state,
        isAuthenticated: action.result.data.sessionToken ? true : false,
        sessionToken: action.result.data.sessionToken,
        loginId: action.result.data.loginId,
        errorMessage: null,
        showPopup: true
      };
    case LOGIN_FAIL:
      return {
        ...state,
        isAuthenticated: false,
        loginId: null,
        sessionToken: null,
        errorMessage: action.error.data.messageKey,
        showPopup: true
      };
    case LOGOUT_SUCCESS:
      return {
        ...state,
        isAuthenticated: false,
        loginId: null,
        sessionToken: null,
        showPopup: true
      };
    case GET_SESSION:
      return {
        ...state,
        loading: true
      };
    case GET_SESSION_SUCCESS:
      return {
        ...state,
        isAuthenticated: action.result.data.sessionToken ? true : false,
        loginId: action.result.data.loginId,
        sessionToken: action.result.data.sessionToken,
        errorMessage: null,
        loading: false
      };
    case GET_SESSION_FAIL:
      return {
        ...state,
        isAuthenticated: false,
        loginId: null,
        sessionToken: null,
        debugError: action.error,
        loading: false
      };
    case ERROR_MESSAGE:
      return {
        ...state,
        errorMessage: action.message
      };
    case POPUP_CLOSE:
      return {
        ...state,
        redirectURI: action.redirectURI,
        showPopup: false
      }
    default:
      return state;
  }
}

// Public action creators and async actions

export function displayAuthError(message) {
  return {type: ERROR_MESSAGE, message};
}

export function login(loginId, password) {
  return {
    types: [LOGIN, LOGIN_SUCCESS, LOGIN_FAIL],
    promise: (client) => client.post('/api/user/session', {loginId, password}),
    afterSuccess: (dispatch, getState, response) => {
      localStorage.setItem('auth-token', response.headers['x-auth-token']);
      const routingState = getState().routing.locationBeforeTransitions.state || {};
      browserHistory.push(routingState.nextPathname || '');
    }
  };
}

export function logout() {
  return {
    types: [LOGOUT, LOGOUT_SUCCESS, LOGOUT_FAIL],
    promise: (client) => client.delete('/api/user/session'),
    afterSuccess: () => {
      browserHistory.push('/');
    }
  };
}

export function getSession() {
  return {
    types: [GET_SESSION, GET_SESSION_SUCCESS, GET_SESSION_FAIL],
    promise: (client) => client.get('/api/user/session')
  };
}

export function redirectToLoginWithMessage(messageKey) {
  return (dispatch, getState) => {
    const currentPath = getState().routing.locationBeforeTransitions.pathname;
    dispatch(displayAuthError(messageKey));
    browserHistory.replace({pathname: '/', state: {nextPathname: currentPath}});
  }
}
