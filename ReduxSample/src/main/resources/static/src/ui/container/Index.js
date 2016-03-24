import React, { Component } from 'react';
import { Link, Router } from 'react-router';
import { connect } from 'react-redux';

const Header = (props) => {
  return (
    <div className="navbar navbar-default navbar-static-top navbar-inverse">
      <div className="container">
        <div className="navbar-header">
          <button type="button" className="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span className="sr-only">Toggle navigation</span>
            <span className="icon-bar"></span>
            <span className="icon-bar"></span>
            <span className="icon-bar"></span>
          </button>
          <a className="navbar-brand" href="#"><span>BAS</span><br/></a>
        </div>
        <div className="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul className="nav navbar-nav navbar-right">
            <li className="active">
              <a href="#">Home</a>
            </li>
            <li>
              <a href="#">Contacts</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  );
}


export class Index extends Component {
  
  componentDidMount() {
    //TODO 로긴 정보가 있으면 /admin으로 이동
//    this.props.getSession();
  }

  render() {
    return (
      <div id="application">
        <Header />
        {this.props.children}
      </div>
    );
  }
}

export default connect(
//  state => ({isAuthenticated: state.authentication.isAuthenticated, currentLocale: state.locale.currentLocale}),
//  {getSession, setLocale}
)(Index);
