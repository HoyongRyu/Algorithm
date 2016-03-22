const SIGN_UP_REQUEST = 'signUp/REQUEST';
const SIGN_UP_SUCCESS = 'signUp/SUCCESS';
const SIGN_UP_FAIL = 'signUp/FAIL';

const SIGN_UP_MODAL_CLOSE = 'signUp/MODAL_CLOSE'

const initialState = {
  sessionTokenId: '',
  sessionFailCode: '',
  modalShow: true
};

// Reducer

export default function signUpReducer(state = initialState, action) {
  switch (action.type) {
    case SIGN_UP_SUCCESS:
      router.transitionTo('/');
      return {
        ...state,
        sessionTokenId: action.result.data.usrId
      };
    case SIGN_UP_FAIL:
      return {
        ...state
        // failCode: action.result.
      };
    case SIGN_UP_MODAL_CLOSE:
      return {
        ...state,
        modalShow: false
      };  
    default:
      return state;
  }
}

// Actions

export function signUp() {
  return  {
    types: [SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAIL],
    promise: client => client.post('/api/createUser')
  };
}

export function modalClose() {
  return {
    types: SIGN_UP_MODAL_CLOSE
  }
}