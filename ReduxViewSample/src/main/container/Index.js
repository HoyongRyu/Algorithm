import React, { Component } from 'react';
import { Link, Router } from 'react-router';
import { connect } from 'react-redux';
import logger from 'config/logger';


const Header = (props) => {
  return (
    <header className="main-header">
      <a href="/" className="logo">
        <span className="logo-lg"><b>Sample</b> Application</span>
      </a>
      <nav className="navbar navbar-static-top" role="navigation">
        <a href="#" className="sidebar-toggle" data-toggle="offcanvas" role="button">
          <span className="sr-only">Toggle navigation</span>
        </a>
        <div className="navbar-custom-menu">
          <ul className="nav navbar-nav">
            <li className="dropdown user user-menu">
              <a href="#" className="dropdown-toggle" data-toggle="dropdown">
                <img src={require("img/user2-160x160.jpg")} className="user-image" alt="User Image" />
                <span className="hidden-xs">Alexander Pierce</span>
              </a>
            </li>
            <li>
              <a href="#" className="btn btn-primary btn-flat">Sign out</a>
            </li>
          </ul>
        </div>
      </nav>
    </header>
  );
}


export class Index extends Component {
  
  componentDidMount() {
    logger("1234");
    //TODO 로긴 정보가 있으면 /admin으로 이동
//    this.props.getSession();
  }

  render() {
    return (
      <div id="application">
        <Header />
        <div>
          {this.props.children}
        </div>
      </div>
    );
  }
}

export default connect(
//  state => ({isAuthenticated: state.authentication.isAuthenticated, currentLocale: state.locale.currentLocale}),
//  {getSession, setLocale}
)(Index);
