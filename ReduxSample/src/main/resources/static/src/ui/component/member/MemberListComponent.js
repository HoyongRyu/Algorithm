import React, {Component} from 'react';

export default class MemberList extends Component {
  render() {
    var members = this.props.members;
    var list = members.map(member => 
      <tr>
        <td>{member.memberId}</td>
        <td>{member.name}</td>
        <td>{member.age}</td>
      </tr>
    );

    return (
      <div>
        <button onClick={this.props.getMemberList}>
          Fetch
        </button>
        <table>
          <thead>
          <tr>
            <th>Member ID</th>
            <th>Name</th>
            <th>Age</th>
          </tr>
          </thead>
          <tbody>
          {list}
          </tbody>
        </table>
      </div>
    );
  }
}
