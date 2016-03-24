import React, {Component} from 'react';
import { Link } from 'react-router';

export default class SignInComponent extends Component {

  render() {
    return (
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
              <form role="form" className="text-left" onSubmit={(formData) => this.handleSubmit(formData)}>
                <div className="form-group" id="loginId">
                  <label className="control-label">Email address</label>
                  <input className="form-control" id="loginId"
                  placeholder="Enter email" type="email" />
                </div>
                <div className="form-group" id="password">
                  <label className="control-label">Password</label>
                  <input className="form-control" id="password"
                  placeholder="Password" type="password" />
                </div>
                <button type="submit" className="btn btn-default">Sign In</button>&nbsp;
                <Link className="btn btn-primary" to="/signup">Sign Up</Link>
              </form>
              <br/>
              <br/>
            </div>
          </div>
        </div>
      </div>
    );
  }

  handleSubmit(formData) {
    const { loginId, password } = formData;
    const { login } = this.props;
    login(username, password);
  }

}


