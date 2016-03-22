import {connect} from 'react-redux';
import {login, logout, getSession} from 'reducers/authentication';
import SignInComponent from 'ui/component/user/SignInComponent';

export default connect(
  mapStateToProps,
  {login, logout, getSession}
)(SignInComponent);

const mapStateToProps = (state) => (
  {
  	isAuthenticated: state.authentication.isAuthenticated,
	usrId: state.authentication.usrId,
	errorMessage: state.authentication.errorMessage,
	loading: state.authentication.loading,
  	sessionTokenId: state.authentication.sessionTokenId,
  	sessionFailCode: state.authentication.sessionFailCode
  }
)