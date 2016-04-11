import React, { Component } from 'react';
import { Link, Router } from 'react-router';
import { connect } from 'react-redux';
import logger from 'config/logger';

const Node = (props) => {
  logger("props : " + JSON.stringify(props));
  var component;
  if (props.node.subNodes != null){
    component = props.node.subNodes.map((node, key) => (
      <Node node={node} key={key}/>
    ))
  }else {
    return (
      <li key={props.key}>
        <Link to={props.node.link}><i className="fa fa-circle-o"></i>{props.node.label}</Link>
      </li>
    );
  }

  return (
    <li className="treeview">
      <a href="#">
        <i className="fa fa-square"></i>
        <span>{props.node.label}</span>
      </a>
      <ul className="treeview-menu">
        {component}
      </ul>
    </li>
  );
}

export class Admin extends Component {
  
  componentDidMount() {
//    this.props.getSession();
  }

  render() {
    const leftMenuItems = {
      title: 'Member',
      menus: [
        {label: 'Buyer', link: '/admin/member'},
        {label: 'Admin',
          subNodes: [
            {label: 'Admin1', link: '/admin/member/adminList'},
            {label: 'Admin2', link: '/admin/member/adminList'}
          ]
        },
        {label: 'Menu1', link: '/admin/menu1'},
        {label: 'Menu2', link: '/admin/menu2'},
        {label: 'Menu3', link: '/admin/menu3'},
        {label: 'Menu4', link: '/admin/menu4'}
      ]
    };

    var node = leftMenuItems.menus.map((node, key) => 
        <Node node={node} key={key} />
    );

    return (
      <div>
        <aside className="main-sidebar">
          <section className="sidebar">
            <ul className="sidebar-menu">
              <li className="header">{leftMenuItems.title}</li>
              {node}
            </ul>
          </section>
        </aside>
        <div className="content-wrapper">
          {this.props.children}
        </div>
      </div>
    );
  }
}

export default connect(
//  state => ({isAuthenticated: state.authentication.isAuthenticated, currentLocale: state.locale.currentLocale}),
//  {getSession, setLocale}
)(Admin);

