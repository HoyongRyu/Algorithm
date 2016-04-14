import React, { Component } from 'react';
import { Link, Router } from 'react-router';
import { connect } from 'react-redux';
import logger from 'config/logger';


const Header = (props) => {
  var topMenu = props.node.map((node, key)=>
    <li><Link key={key} to={node.link}>{node.label}<span className="sr-only">(current)</span></Link></li>
  );

  return (
    <header className="main-header">
      <a href="/" className="logo">
        <span className="logo-mini"><b>Sample</b></span>
        <span className="logo-lg"><b>Sample</b> Application</span>
      </a>
      <nav className="navbar navbar-static-top" role="navigation">
        <a href="#" className="sidebar-toggle" data-toggle="offcanvas" role="button">
          <span className="sr-only">Toggle navigation</span>
        </a>
        <div className="collapse navbar-collapse pull-left" id="navbar-collapse">
          <ul className="nav navbar-nav">
            {topMenu}
          </ul>
        </div>
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

const LeftMenuNode = (props) => {
  logger("props : " + JSON.stringify(props));
  var component;
  if (props.node.subNodes != null){
    component = props.node.subNodes.map((node, key) => (
      <LeftMenuNode node={node} key={key}/>
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
        <i className="fa fa-angle-left pull-right"></i>
      </a>
      <ul className="treeview-menu">
        {component}
      </ul>
    </li>
  );
}

class LeftMenu extends Component {
  render() {
    return (
      <div>
        <aside className="main-sidebar">
          <section className="sidebar">
            <ul className="sidebar-menu">
              <li className="header">{this.props.leftMenuTitle}</li>
              {this.props.node}
            </ul>
          </section>
        </aside>
      </div>
    )
  }
}

export class Index extends Component {
  
  componentDidMount() {
    logger("1234");
    //TODO 로긴 정보가 없으면 로긴 화면 이동
    //this.props.getSession();
  }

  render() {
    const topMenuItems = [
      {label: 'Main', link:'/'},
      {label: 'Product', link:''},
      {label: 'Module Mgmt.', link:''},
      {label: 'Store Display', link:''},
      {label: 'Member', link:''},
      {label: 'Order', link:''},
      {label: 'Statistics', link:''},
      {label: 'System', link:''}
    ];

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

    var leftNode = leftMenuItems.menus.map((node, key) => 
      <LeftMenuNode node={node} key={key} />
    );

    return (
      <div id="application" className="wrapper">
        <Header node={topMenuItems} />
        <LeftMenu node={leftNode} leftMenuTitle={leftMenuItems.title} />
        <div className="content-wrapper">
          <section className="content-header">
            <ol className="breadcrumb">
              <li><i className="fa fa-angle-double-right"></i> Top Level Menu</li>
              <li className="active">Child Menu</li>
            </ol>
          </section>
          <section className="content">
            {this.props.children}
          </section>
        </div>
      </div>
    );
  }
}

export default connect(
//  state => ({isAuthenticated: state.authentication.isAuthenticated, currentLocale: state.locale.currentLocale}),
//  {getSession, setLocale}
)(Index);
