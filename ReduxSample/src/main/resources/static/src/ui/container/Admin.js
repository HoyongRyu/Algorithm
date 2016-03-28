import React, { Component } from 'react';
import { Link, Router } from 'react-router';
import { connect } from 'react-redux';
import { Nav, Navbar, NavItem, Button, Jumbotron, Grid, Row, Col } from 'react-bootstrap'


export class App extends Component {
  
  componentDidMount() {
//    this.props.getSession();
  }

  render() {
    const leftMenuItems = [
      {label: 'Member', link: '/member'},
      {label: 'Content', link: '/content'},
      {label: 'Display', link: '/display'},
      {label: 'Order', link: '/order'},      
      {label: 'System', link: '/system'}
    ];

    return (
      <div class="row">
        <div class="col-sm-3">
          <div class="sidebar-nav">
            <div class="navbar navbar-default" role="navigation">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <span class="visible-xs navbar-brand">Sidebar menu</span>
              </div>
              <div class="navbar-collapse collapse sidebar-navbar-collapse">
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Menu Item 1</a></li>
                  <li><a href="#">Menu Item 2</a></li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Action</a></li>
                      <li><a href="#">Another action</a></li>
                      <li><a href="#">Something else here</a></li>
                      <li class="divider"></li>
                      <li class="dropdown-header">Nav header</li>
                      <li><a href="#">Separated link</a></li>
                      <li><a href="#">One more separated link</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Menu Item 4</a></li>
                  <li><a href="#">Reviews <span class="badge">1,118</span></a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-9">
          {this.props.children}
        </div>
      </div>
    );
  }
}

export default connect(
//  state => ({isAuthenticated: state.authentication.isAuthenticated, currentLocale: state.locale.currentLocale}),
//  {getSession, setLocale}
)(App);