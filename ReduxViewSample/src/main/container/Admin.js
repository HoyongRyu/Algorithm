import React, { Component } from 'react';
import { Link, Router } from 'react-router';
import { connect } from 'react-redux';

const Node = (props) => {
  console.log("props : " + JSON.stringify(props));
  var component;
  if (props.node.subNodes != null){
    component = props.node.subNodes.map((node, key) => (
      <Node node={node} key={key}/>
    ))
  }else {
    return (
      <li key={props.key}>
        <Link to={props.node.link}>{props.node.label}</Link>
      </li>
    );
  }

  return (
    <li><label className="tree-toggler nav-header">{props.node.label}</label>
      <ul className="nav nav-list tree">
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
      label: 'Admin',
      subNodes: [
        {label: 'Member',
          subNodes: [
            {label: 'Buyer', link: '/admin/member'},
            {label: 'Admin',
              subNodes: [
                {label: 'Admin1', link: '/admin/member/adminList'},
                {label: 'Admin2', link: '/admin/member/adminList'}
              ]
            }
          ]
        },
        {label: 'Content', link: '/admin/content'},
        {label: 'Display', link: '/admin/display'},
        {label: 'Order', link: '/admin/order'},
        {label: 'System', link: '/admin/system'}
      ]
    };

    return (
      <div className="row">
        <div className="col-sm-2">
            <div className="well">
              <div>
                  <ul className="nav nav-list">
                    <Node node={leftMenuItems} />
                  </ul>
              </div>
          </div>
        </div>
        <div className="col-sm-10">
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
