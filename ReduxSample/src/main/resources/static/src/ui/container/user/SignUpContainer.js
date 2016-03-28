import {connect} from 'react-redux';
import {signUp } from 'reducers/user/signUpReducer';
import { redirect, closePopup } from 'reducers/commonReducer';
import SignUpComponent from 'ui/component/user/SignUpComponent';

export default connect(
  state => (
	{
	  message: state.userReducer.signUpReducer.message,
	  isSuccess: state.userReducer.signUpReducer.isSuccess,
	  redirectURI: state.userReducer.signUpReducer.redirectURI
	}
  ),
  { signUp, closePopup, redirect }
)(SignUpComponent);
