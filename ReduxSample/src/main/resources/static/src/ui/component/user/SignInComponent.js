import React, {Component} from 'react';
import { Link } from 'react-router';
import { Form, TextInput } from 'react-easy-form';
import ErrorPopup from 'ui/component/common/ErrorPopupComponent'
import SuccessPopup from 'ui/component/common/SuccessPopupComponent'

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
      <div>
        <div className="cover">
          <div className="cover-image"></div>
          <div className="container">
            <div className="row">
              <div className="col-md-7 text-center">
                <br/>
                <br/>
                <h2><img src={require('img/logobas.jpg')} /></h2>
                <h1>Welcome to</h1>
                <p>Administration site</p>
                <br/>
                <br/>
              </div>
              <div className="col-md-3">
                <br/><br/><br/>
                <Form ref="form" className="text-left" onSubmit={(formData) => this.handleSubmit(formData)}>
                  <div className="form-group" id="loginId">
                    <label className="control-label">Email address</label>
                    <TextInput className="form-control" name="loginId" placeholder="Enter email" type="email" required />
                  </div>
                  <div className="form-group" id="password">
                    <label className="control-label">Password</label>
                    <TextInput className="form-control" name="password" placeholder="Password" type="password" required />
                  </div>
                  <button type="submit" className="btn btn-default">Sign In</button>&nbsp;
                  <Link className="btn btn-primary" to="/signup">Sign Up</Link>
                </Form>
                <br/>
                <br/>
              </div>
            </div>
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


