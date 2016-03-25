import {connect} from 'react-redux';
import {signUp, closeErrorPopup} from 'reducers/user/signUpReducer';
import SignUpComponent from 'ui/component/user/SignUpComponent';

export default connect(
  state => (
  	{
  		message: state.userReducer.signUpReducer.message,
  		isSuccess: state.userReducer.signUpReducer.isSuccess
  	}
  ),
  { signUp, closeErrorPopup }
)(SignUpComponent);
