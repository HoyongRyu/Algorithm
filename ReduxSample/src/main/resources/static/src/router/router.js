import React from 'react';
import { Route, Redirect, IndexRoute } from 'react-router';

import App from 'ui/container/App';
import MemberList from 'ui/container/MemberListContainer';
import UserSignUp from 'ui/container/user/SignUpContainer';

export default () => (
  <Route path="/" name="app" component={App}>
    <Route path="/member" component={MemberList}/>
    <Route path="/signup" component={UserSignUp}/>
  </Route>
);
