import React, {Component} from 'react';
import { Link } from 'react-router';
import { Form, TextInput } from 'react-easy-form';
import ErrorPopup from 'common/component/ErrorPopupComponent'
import SuccessPopup from 'common/component/SuccessPopupComponent'

export default class SignInComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isErrorShow: false,
      isSuccesShow: false
    };
  }

  componentWillReceiveProps(nextProps) {
    this.setState({
      isErrorShow: nextProps.showPopup == true && nextProps.isAuthenticated == false ? true : false,
      isSuccesShow: nextProps.showPopup == true && nextProps.isAuthenticated == true ? true : false
    });
    if (typeof nextProps.redirectURI  == "string") {
      this.props.redirect(nextProps.redirectURI);
    }
  }

  render() {
    return (
      <div className="hold-transition">
        <div className="login-box">
          <div className="box box-info">
            <div className="box-header with-border">
              <h3 className="box-title">Sample Login</h3>
            </div>
            <Form ref="form" className="form-horizontal" onSubmit={(formData) => this.handleSubmit(formData)}>
              <div className="box-body">
                <div className="form-group">
                  <label htmlFor="loginId" className="col-sm-2 control-label">Email</label>
                  <div className="col-sm-10">
                    <TextInput type="email" className="form-control" name="loginId" placeholder="Enter email" required />
                  </div>
                </div>
                <div className="form-group">
                  <label htmlFor="password" className="col-sm-2 control-label">Password</label>
                  <div className="col-sm-10">
                    <TextInput type="password" className="form-control" name="password" placeholder="Password" required />
                  </div>
                </div>
              </div>
              <div className="box-footer">
                <Link to="/signup" className="btn btn-default pull-left">Sign up</Link>
                <button type="submit" className="btn btn-primary pull-right">Sign in</button>
              </div>
            </Form>
          </div>
        </div>
        <SuccessPopup message="로그인 성공" show={this.state.isSuccesShow} close={() => this.props.closePopup('/admin')} />
        <ErrorPopup message="로그인 실패" show={this.state.isErrorShow} close={this.props.closePopup} />
      </div>
    );
  }

  handleSubmit(formData) {
    const { loginId, password } = formData;
    const { login } = this.props;
    login(loginId, password);
  }

}


