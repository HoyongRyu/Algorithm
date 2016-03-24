import React from 'react';
import { Route, Redirect, IndexRoute } from 'react-router';

import Index from 'ui/container/Index';
import SignIn from 'ui/container/user/SignInContainer';
import App from 'ui/container/App';
import SignUp from 'ui/container/user/SignUpContainer';
import MemberList from 'ui/container/MemberListContainer';


export default () => (
  <Route path="/" name="index" component={Index}>
    <IndexRoute component={SignIn}/>
    <Route path="/signup" name="signup" component={SignUp}/>
  	<Route path="/admin" name="app" component={App}>
      <Route path="/member" name="member" component={MemberList} />
    </Route>
  </Route>
);
