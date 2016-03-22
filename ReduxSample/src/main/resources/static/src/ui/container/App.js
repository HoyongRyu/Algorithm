import React, { Component } from 'react';
import { Link, Router } from 'react-router';
import { connect } from 'react-redux';
import { Nav, Navbar, NavItem, Button, Jumbotron, Grid, Row, Col } from 'react-bootstrap'

const LoginForm = (props) => {
  return (
    props.isAuthenticated ? '' :
    <Jumbotron>
      <Grid>
        <Row>
          <Col md={7}>
            <h2 className="text-center"><img src={require('img/logobas.jpg')} /></h2>
            <h1 className="text-center text-muted">Welcome to</h1>
            <h3 className="text-center text-muted">
              <b>Administration Site</b>
            </h3>
          </Col>
          <Col md={5}>
            <form role="form" className="text-left" submit="">
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
              <Button type="submit" bsStyle="default">Sign In</Button>&nbsp;
              <Link className="btn btn-primary" to="/signup">Sign Up</Link>
            </form>
          </Col>
        </Row>
      </Grid>
    </Jumbotron>
  );
}


export class App extends Component {
  
  componentDidMount() {
//    this.props.getSession();
  }

  render() {
    const topMenuItems = [
      {label: 'Home', link: '/'},
      {label: 'Member', link: '/member'}
    ];

    return (
      <div id="application">
        <LoginForm />
        {this.props.children}
      </div>
    );
  }
}

export default connect(
//  state => ({isAuthenticated: state.authentication.isAuthenticated, currentLocale: state.locale.currentLocale}),
//  {getSession, setLocale}
)(App);
