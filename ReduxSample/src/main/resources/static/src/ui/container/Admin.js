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
      {label: 'Member', link: '/member',
        subMenuItems: [
          {subLabal: 'Buyer Member', link: '/member/buyerList'},
          {subLabal: 'Admin Member', link: '/member/adminList'}
        ]
      },
      {label: 'Content', link: '/content'},
      {label: 'Display', link: '/display'},
      {label: 'Order', link: '/order'},      
      {label: 'System', link: '/system'}
    ];

    return (
      <div className="row">
        <div className="col-sm-3">
            <div className="well">
              <div>
                  <ul className="nav nav-list">
                      <li><label className="tree-toggler nav-header">Header 1</label>
                          <ul className="nav nav-list tree">
                              <li><a href="#">Link</a></li>
                              <li><a href="#">Link</a></li>
                              <li><label className="tree-toggler nav-header">Header 1.1</label>
                                  <ul className="nav nav-list tree">
                                      <li><a href="#">Link</a></li>
                                      <li><a href="#">Link</a></li>
                                      <li><label className="tree-toggler nav-header">Header 1.1.1</label>
                                          <ul className="nav nav-list tree">
                                              <li><a href="#">Link</a></li>
                                              <li><a href="#">Link</a></li>
                                          </ul>
                                      </li>
                                  </ul>
                              </li>
                          </ul>
                      </li>
                      <li className="divider"></li>
                      <li><label className="tree-toggler nav-header">Header 2</label>
                          <ul className="nav nav-list tree">
                              <li><a href="#">Link</a></li>
                              <li><a href="#">Link</a></li>
                              <li><label className="tree-toggler nav-header">Header 2.1</label>
                                  <ul className="nav nav-list tree">
                                      <li><a href="#">Link</a></li>
                                      <li><a href="#">Link</a></li>
                                      <li><label className="tree-toggler nav-header">Header 2.1.1</label>
                                          <ul className="nav nav-list tree">
                                              <li><a href="#">Link</a></li>
                                              <li><a href="#">Link</a></li>
                                          </ul>
                                      </li>
                                  </ul>
                              </li>
                              <li><label className="tree-toggler nav-header">Header 2.2</label>
                                  <ul className="nav nav-list tree">
                                      <li><a href="#">Link</a></li>
                                      <li><a href="#">Link</a></li>
                                      <li><label className="tree-toggler nav-header">Header 2.2.1</label>
                                          <ul className="nav nav-list tree">
                                              <li><a href="#">Link</a></li>
                                              <li><a href="#">Link</a></li>
                                          </ul>
                                      </li>
                                  </ul>
                              </li>
                          </ul>
                      </li>
                  </ul>
              </div>
          </div>
        </div>
        <div className="col-sm-9">
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
