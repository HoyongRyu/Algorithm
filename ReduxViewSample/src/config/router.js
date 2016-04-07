import React from 'react';
import { Route, Redirect, IndexRoute } from 'react-router';

import Index from 'main/container/Index';
import Admin from 'main/container/Admin';
import SignIn from 'member/container/SignInContainer';
import SignUp from 'member/container/SignUpContainer';
import MemberList from 'member/container/MemberListContainer';


export default () => (
  <Route path="/" name="index" component={Index}>
    <IndexRoute component={SignIn}/>
    <Route path="/signup" name="signup" component={SignUp}/>
    <Route path="/admin" name="admin" component={Admin}>
      /* index router에 Dashboard 추가 */
      <Route path="/admin/member" name="memberList" component={MemberList} />
    </Route>
  </Route>
);
