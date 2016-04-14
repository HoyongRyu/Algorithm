import React from 'react';
import { Route, Redirect, IndexRoute } from 'react-router';

import Index from 'main/container/Index';
import SignIn from 'member/container/SignInContainer';
import SignUp from 'member/container/SignUpContainer';


export default () => (
  <Route path="/" name="index" component={Index}>
    <IndexRoute component={SignIn}/>
    <Route path="/signup" name="signup" component={SignUp}/>
  </Route>
);
