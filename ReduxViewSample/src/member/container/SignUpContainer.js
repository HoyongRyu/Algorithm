import {connect} from 'react-redux';
import { signUp } from 'member/reducer/signUpReducer';
import { redirect, closePopup } from 'common/reducer/commonReducer';
import SignUpComponent from 'member/component/SignUpComponent';

export default connect(
  state => (
	{
	  message: state.member.signUpReducer.message,
	  isSuccess: state.member.signUpReducer.isSuccess,
	  redirectURI: state.member.signUpReducer.redirectURI
	}
  ),
  { signUp, closePopup, redirect }
)(SignUpComponent);
