import {connect} from 'react-redux';
import {signUp, closeErrorPopup} from 'reducers/user/signUpReducer';
import SignUpComponent from 'ui/component/user/SignUpComponent';

export default connect(
  state => ({errorMessage: state.userReducer.signUpReducer.errorMessage}),
  { signUp, closeErrorPopup }
)(SignUpComponent);

const mapStateToProps = (state) => {
  return 
  {
  	errorMessage: state.userReducer.signUpReducer.errorMessage
  }
}