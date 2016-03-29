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
            {label: 'Buyer Member', link: '/member/buyerList'},
            {label: 'Admin Member',
              subNodes: [
                {label: 'Admin Member22', link: '/member/adminList'},
                {label: 'Admin Member33', link: '/member/adminList'}
              ]
            }
          ]
        },
        {label: 'Content', link: '/content'},
        {label: 'Display', link: '/display'},
        {label: 'Order', link: '/order'},
        {label: 'System', link: '/system'}
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



// const Parent = (props) => {
//   console.log("Parent : " + JSON.stringify(props.parentMenus));
//   const parentMenu = props.parentMenus.map((item, key) => (
//       <li><label className="tree-toggler nav-header">{item.label}</label>
//         <ul className="nav nav-list tree">
//           <Child items={item.subMenuItems} />
//         </ul>
//       </li>
//   ));

//   return (
//     {parentMenu}
//   );
// }

// const Child = (props) => {
//   console.log("Child : " + JSON.stringify(props.items));
//   const childMenu = props.items.map((item, key) => {
//     if (item.subMenuItems) {
//       <SubParent subParent={item} />
//     }else {
//       <li key={key}>
//         <Link to={item.link}>{item.label}</Link>
//       </li>
//     }
//   });

//   return (
//     <ul className="nav nav-list tree">
//       {childMenu} 
//     </ul>
//   );
// }

// const SubParent = (props) => {
//   console.log("SubParent : " + JSON.stringify(props.subParent));
//   return (
//     <li><label className="tree-toggler nav-header">{props.subParent.label}</label>
//       <ul className="nav nav-list tree">
//         <Child items={props.subParent.subMenuItems} />
//       </ul>
//     </li>
//   );
// }







