import MemberListComponent from 'ui/component/member/MemberListComponent';
import {connect} from 'react-redux';
import {getMemberList} from 'reducers/member/memberListReducer';


export default connect(
  state => ({members: state.memberListReducer.members}),
  {getMemberList}
)(MemberListComponent);
