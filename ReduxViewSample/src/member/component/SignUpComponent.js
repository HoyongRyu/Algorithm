import React, {Component} from 'react';
import { Link } from 'react-router';
import { Form, TextInput } from 'react-easy-form';
import ErrorPopup from 'common/component/ErrorPopupComponent'
import SuccessPopup from 'common/component/SuccessPopupComponent'

export default class SignUpComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isErrorShow: false,
      isSuccesShow: false
    };
  }

  componentWillReceiveProps(nextProps) {
    this.setState({
      isErrorShow: nextProps.isSuccess == false && nextProps.message ? true : false,
      isSuccesShow: nextProps.isSuccess == true && nextProps.message ? true : false
    });
    if (typeof redirectURI  == "string") {
      this.props.redirect(nextProps.redirectURI);
    }
  }

  render() {
    return (
      <div>
        <div className="well">
          <div className="row">
            <div className="col-md-12">
              <div className="col-md-7 text-center">
                <br/><br/>
                <h2>BAS Admin 회원 가입</h2>
                <p>가입 신청 후 관리자의 승인이 완료되면 로그인이 가능합니다.</p>
                <br/><br/>
              </div>
              <div className="col-md-5">
                <Form ref="form" onSubmit={(formData) => this.handleSubmit(formData)} className="pure-form pure-form-aligned">
                  <div className="form-group">
                    <label className="control-label">Email address</label>
                    <TextInput className="form-control" name="loginId" type="email" placeholder="Enter email" required />
                  </div>
                  <div className="form-group">
                    <label className="control-label">Password</label>
                    <TextInput className="form-control" name="password" type="password" placeholder="Password" required />
                  </div>
                  <Link to="/" className="btn btn-default">Back</Link>&nbsp;
                  <button type="submit" className="btn btn-primary">Sign Up For BAS Admin</button>
                </Form>
              </div>
            </div>
          </div>
        </div>
        <SuccessPopup message={this.props.message} show={this.state.isSuccesShow} close={this.props.closePopup} />
        <ErrorPopup message={this.props.message} show={this.state.isErrorShow} close={this.props.closePopup} />
      </div>
    );
  }

  handleSubmit(formData) {
    const { loginId, password } = formData;
    const { signUp } = this.props;
    signUp(loginId, password);
  }


}