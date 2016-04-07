import {connect} from 'react-redux';
import {login, logout, getSession} from 'member/reducer/authentication';
import { redirect, closePopup } from 'common/reducer/commonReducer';
import SignInComponent from 'member/component/SignInComponent';

export default connect(
  state => (
    {
      isAuthenticated: state.member.authenticationReducer.isAuthenticated,
      usrId: state.member.authenticationReducer.usrId,
      errorMessage: state.member.authenticationReducer.errorMessage,
      loading: state.member.authenticationReducer.loading,
      sessionTokenId: state.member.authenticationReducer.sessionTokenId,
      sessionFailCode: state.member.authenticationReducer.sessionFailCode,
      redirectURI: state.member.authenticationReducer.redirectURI,
      showPopup: state.member.authenticationReducer.showPopup,
    }
  ),
  {login, logout, getSession, redirect, closePopup}
)(SignInComponent);
