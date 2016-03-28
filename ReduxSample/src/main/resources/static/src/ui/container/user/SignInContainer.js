import {connect} from 'react-redux';
import {login, logout, getSession} from 'reducers/authentication';
import { redirect, closePopup } from 'reducers/commonReducer';
import SignInComponent from 'ui/component/user/SignInComponent';

export default connect(
  state => (
    {
      isAuthenticated: state.authentication.isAuthenticated,
      usrId: state.authentication.usrId,
      errorMessage: state.authentication.errorMessage,
      loading: state.authentication.loading,
      sessionTokenId: state.authentication.sessionTokenId,
      sessionFailCode: state.authentication.sessionFailCode,
      redirectURI: state.authentication.redirectURI,
      showPopup: state.authentication.showPopup,
    }
  ),
  {login, logout, getSession, redirect, closePopup}
)(SignInComponent);
