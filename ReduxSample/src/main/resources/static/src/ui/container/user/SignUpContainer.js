import {connect} from 'react-redux';
import {signUp, modalClose} from 'reducers/user/signUpReducer';
import SignUpComponent from 'ui/component/user/SignUpComponent';

export default connect(
  mapStateToProps,
  {signUp, modalClose}
)(SignUpComponent);

const mapStateToProps = (state) => (
  {
  	sessionTokenId: state.userReducer.signUpReducer.sessionTokenId,
  	sessionFailCode: state.userReducer.signUpReducer.sessionFailCode,
  	modalShow: state.userReducer.signUpReducer.modalShow
  }
)