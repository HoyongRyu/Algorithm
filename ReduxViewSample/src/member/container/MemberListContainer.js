import MemberListComponent from 'member/component/MemberListComponent';
import {connect} from 'react-redux';
import {getMemberList} from 'member/reducer/memberListReducer';


export default connect(
  state => ({members: state.member.memberListReducer.members}),
  {getMemberList}
)(MemberListComponent);
