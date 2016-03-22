const MEMBER_LIST_FETCH = 'memberList/FETCH';
const MEMBER_LIST_FETCH_SUCCESS = 'memberList/FETCH_SUCCESS';
const MEMBER_LIST_FETCH_FAIL = 'memberList/FETCH_FAIL';

const initialState = {
  members: []
};

// Reducer

export default function memberListReducer(state = initialState, action) {
  switch (action.type) {
    case MEMBER_LIST_FETCH_SUCCESS:
      return {
        ...state,
        members: action.result.data
      };
    default:
      return state;
  }
}

// Actions

export function getMemberList() {
  return  {
    types: [MEMBER_LIST_FETCH, MEMBER_LIST_FETCH_SUCCESS, MEMBER_LIST_FETCH_FAIL],
    promise: client => client.post('/api/getAllMembers')
  };
}
